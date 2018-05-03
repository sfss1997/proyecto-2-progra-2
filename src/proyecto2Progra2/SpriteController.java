/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto2Progra2;

import Domain.Logic;
import archivos.ProyectsAdministration;
import archivos.ImagesAdministration;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.SnapshotParameters;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.WritableImage;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

import javax.xml.parsers.ParserConfigurationException;

/**
 *
 * @author fabian
 */
public class SpriteController extends ProyectsAdministration implements Initializable {

    @FXML
    private AnchorPane spriteAnchorPane;
    @FXML
    private TextField rowsTextField;
    @FXML
    private TextField columnsTextField;
    @FXML
    private MenuItem deleteMenuItem;
    @FXML
    private ListView<String> iconsListView;

    private Cell[][] cell;
    private GridPane spriteGridPane;
    private ImagesAdministration xmlArchives;
    private int rows;
    private int columns;
    private static String selectedItem = "";
    private Logic logic;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            // TODO
            this.xmlArchives = new ImagesAdministration();
            this.logic = new Logic();
            initializeListView();

        } catch (ParserConfigurationException ex) {
            Logger.getLogger(SpriteController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(SpriteController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Crea un nuevo GridPane.
     * @param event
     * @throws Exception 
     */
    @FXML
    public void createGridPane(ActionEvent event) throws Exception {
        this.spriteAnchorPane.getChildren().clear();
        this.rows = Integer.parseInt(this.rowsTextField.getText());
        this.columns = Integer.parseInt(this.columnsTextField.getText());
        this.cell = new Cell[this.rows][this.columns];
        this.spriteGridPane = new GridPane();

        //Crea el GridPane
        this.spriteGridPane = this.logic.createGridPane(this.rows, this.columns, this.cell);

        //Añade el GridPane al AnchorPane
        this.spriteAnchorPane = this.logic.addGridPaneToAnchorPane(this.spriteAnchorPane, this.spriteGridPane);

    }

    /**
     * Llena el ListView con los elementos del XML.
     * @throws Exception 
     */
    private void initializeListView() throws Exception {
        Image[] imageList = new Image[this.xmlArchives.readXml().size()];
        for (int i = 0; i < imageList.length; i++) {
            Image img = new Image(this.xmlArchives.readXml().get(i).getUrl());
            imageList[i] = img;
        }

        ObservableList<String> items = FXCollections.observableArrayList();
        for (int i = 0; i < this.xmlArchives.readXml().size(); i++) {
            items.add(this.xmlArchives.readXml().get(i).getName());
        }

        this.iconsListView.setItems(items);

        this.iconsListView.setCellFactory(param -> new ListCell<String>() {
            private ImageView imageView = new ImageView();

            @Override
            public void updateItem(String name, boolean empty) {
                super.updateItem(name, empty);
                if (empty) {
                    setText(null);
                    setGraphic(null);
                } else {
                    for (int i = 0; i < items.size(); i++) {
                        if (name.equals(items.get(i))) {
                            this.imageView.setImage(imageList[i]);
                        }
                    }
                    setText(name);
                    setGraphic(this.imageView);
                }
            }
        });
    }

    /**
     * Borra todo lo que se haya agregado al GridPane
     * @param event
     * @throws Exception 
     */
    @FXML
    private void deleteOnAction(ActionEvent event) throws Exception {
        this.spriteAnchorPane.getChildren().clear();

        //Crea el GridPane
        this.spriteGridPane = this.logic.createGridPane(this.rows, this.columns, this.cell);

        //Añade el GridPane al AnchorPane
        this.spriteAnchorPane = this.logic.addGridPaneToAnchorPane(this.spriteAnchorPane, this.spriteGridPane);
    }

    /**
     * Exporta a un archivo .png lo que hay en el AnchorPane.
     */
    @FXML
    public void exportAsImage() {

        changeCellStyle("none");
        WritableImage image = this.spriteAnchorPane.snapshot(new SnapshotParameters(), null);
        changeCellStyle("black");
        // TODO: probably use a file chooser here

        JFileChooser guardarImagen = new JFileChooser();
        guardarImagen.setApproveButtonText("Guardar");
        guardarImagen.showSaveDialog(null);

        File file = new File(guardarImagen.getSelectedFile() + ".png");
        guardarImagen.setVisible(false);
        try {
            ImageIO.write(SwingFXUtils.fromFXImage(image, null), "png", file);

        } catch (IOException e) {
            // TODO: handle exception here
        }

    }

    /**
     * Cambia el color del borde de cada celda del GridPane.
     * @param color 
     */
    private void changeCellStyle(String color) {
        for (int i = 0; i < Integer.parseInt(this.rowsTextField.getText()); i++) {
            for (int j = 0; j < Integer.parseInt(this.columnsTextField.getText()); j++) {
                this.cell[i][j].setStyle("-fx-border-color : " + color);
            }
        }
    }

    /**
     * Valida el caracter ingresado en el TextField.
     * @param event 
     */
    @FXML
    private void validateOnKeyTyped(KeyEvent event) {
        boolean validate = this.logic.isNumeric(event);
        if (validate == false) {
            event.consume();
        }
    }

    /**
     * Abre un archivo .json con el progreso guardado.
     * @param event
     * @throws Exception 
     */
    @FXML
    private void openProjectOnAction(ActionEvent event) throws Exception {
        ArrayList document = readJson();

        String numberOfColums = document.get(1).toString();
        String NumberOfRows = document.get(2).toString();
        ArrayList url2 = (ArrayList) document.get(3);
        ArrayList x2 = (ArrayList) document.get(4);
        ArrayList y2 = (ArrayList) document.get(5);

        this.columnsTextField.setText(numberOfColums);
        this.rowsTextField.setText(NumberOfRows);
        this.spriteAnchorPane.getChildren().clear();
        this.rows = Integer.parseInt(this.rowsTextField.getText());
        this.columns = Integer.parseInt(this.columnsTextField.getText());
        this.cell = new Cell[this.rows][this.columns];

        //Crea el GridPane
        this.spriteGridPane = this.logic.createGridPane(this.rows, this.columns, this.cell);

        //Añade el GridPane al AnchorPane
        this.spriteAnchorPane = this.logic.addGridPaneToAnchorPane(this.spriteAnchorPane, this.spriteGridPane);

        int cont = 0;
        for (int i = 0; i < Integer.parseInt(this.rowsTextField.getText()); i++) {
            for (int j = 0; j < Integer.parseInt(this.columnsTextField.getText()); j++) {
                if (!url2.get(cont).equals("")) {
                    this.cell[i][j].getChildren().add(new ImageView(url2.get(cont).toString()));
                    this.cell[i][j].setUrl(url2.get(cont).toString());
                }
                cont++;
            }
        }

    }
    
    /**
     * Guarda el progreso en un archivo .json
     * @param event 
     */
    @FXML
    private void saveProgressOnAction(ActionEvent event) {

        ArrayList<String> url = new ArrayList();
        ArrayList<String> x = new ArrayList();
        ArrayList<String> y = new ArrayList();
        for (int i = 0; i < this.rows; i++) {
            for (int j = 0; j < this.columns; j++) {
                url.add(this.cell[i][j].getUrl());
                x.add(String.valueOf(this.cell[i][j].getRow()));
                y.add(String.valueOf(this.cell[i][j].getColumn()));
            }
        }

        writeJson("json", url, x, y, this.columns, this.rows);
    }
    
    /**
     * Guarda en un String el nombre del elemento seleccionado en el ListView.
     */
    @FXML
    public void setSelectedItem() {
        String selectedItem1 = "";
        ObservableList listOfItems = this.iconsListView.getSelectionModel().getSelectedItems();
        for (Object item : listOfItems) {
            selectedItem1 = (String) item;
        }
        this.selectedItem = selectedItem1;
    }

    /**
     * Retorna un String con el nombre del elemento seleccionado en el ListView.
     * @return 
     */
    public String getSelectedItem() {
        return this.selectedItem;
    }

    /**
     * Borra el GridPane.
     * @param event 
     */
    @FXML
    private void newProjectOnAction(ActionEvent event) {
        this.spriteAnchorPane.getChildren().clear();
        this.rowsTextField.setText("");
        this.columnsTextField.setText("");
    }
    @FXML
    private void about(){
        JOptionPane.showMessageDialog(null, "Armacabezas\n\nHans Villalobos\nSergio Siles\n\n2018", "Créditos", JOptionPane.INFORMATION_MESSAGE);
    }
}
