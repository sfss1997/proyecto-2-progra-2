/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto2Progra2;

import archivos.ArchivosJSON;
import archivos.ArchivosXML;
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
import javax.imageio.ImageIO;
import javax.swing.JFileChooser;

import javax.xml.parsers.ParserConfigurationException;

/**
 *
 * @author fabian
 */
public class SpriteController extends ArchivosJSON implements Initializable {
    //

    @FXML
    private AnchorPane spriteAnchorPane;

    private Cell[][] cell;
    private GridPane spriteGridPane;

    @FXML
    private TextField rowsTextField;
    @FXML
    private TextField columnsTextField;

    private ArchivosXML archivosXML;
//    private ArchivosJSON archivosJson;
    
    @FXML
    private MenuItem deleteMenuItem;

    private int rows;
    private int columns;

    @FXML
    private ListView<String> iconsListView;

    private static String selectedItem = "";

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            // TODO
            archivosXML = new ArchivosXML();
            initializeListView();

        } catch (ParserConfigurationException ex) {
            Logger.getLogger(SpriteController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(SpriteController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    public void createGridPane(ActionEvent event) throws Exception {
        this.spriteAnchorPane.getChildren().clear();
        this.rows = Integer.parseInt(rowsTextField.getText());
        this.columns = Integer.parseInt(columnsTextField.getText());
        this.cell = new Cell[this.rows][this.columns];
        this.spriteGridPane = new GridPane();

        for (int i = 0; i < Integer.parseInt(rowsTextField.getText()); i++) {
            for (int j = 0; j < Integer.parseInt(columnsTextField.getText()); j++) {
                cell[i][j] = new Cell();
                cell[i][j].setRow(i);
                cell[i][j].setColumn(j);
                spriteGridPane.add(cell[i][j], j, i);
            }
        }

        spriteAnchorPane.setPrefHeight(spriteGridPane.getPrefHeight());
        spriteAnchorPane.setPrefWidth(spriteGridPane.getPrefWidth());
        spriteAnchorPane.getChildren().add(spriteGridPane);

    }

    private void initializeListView() throws Exception {
        Image[] imageList = new Image[archivosXML.leerXml().size()];
        for (int i = 0; i < imageList.length; i++) {
            Image img = new Image(archivosXML.leerXml().get(i).getDireccion());
            imageList[i] = img;
        }

        ObservableList<String> items = FXCollections.observableArrayList();
        for (int i = 0; i < archivosXML.leerXml().size(); i++) {
            items.add(archivosXML.leerXml().get(i).getNombre());
        }

        iconsListView.setItems(items);

        iconsListView.setCellFactory(param -> new ListCell<String>() {
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
                            imageView.setImage(imageList[i]);
                        }
                    }
                    setText(name);
                    setGraphic(imageView);
                }
            }
        });
    }

    @FXML
    private void deleteOnAction(ActionEvent event) {
        spriteAnchorPane.getChildren().clear();
    }

    @FXML
    public void exportAsImage() {

        changeCellStyle("none");
        WritableImage image = spriteAnchorPane.snapshot(new SnapshotParameters(), null);
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

    private void changeCellStyle(String color) {
        for (int i = 0; i < Integer.parseInt(rowsTextField.getText()); i++) {
            for (int j = 0; j < Integer.parseInt(columnsTextField.getText()); j++) {
                cell[i][j].setStyle("-fx-border-color : " + color);
            }
        }
    }

    @FXML
    private void validateOnKeyTyped(KeyEvent event) {
        char charType = event.getCharacter().charAt(0);
        if (!Character.isDigit(charType)) {
            event.consume();
        }
    }

    @FXML
    private void openProjectOnAction(ActionEvent event) {
    }

    @FXML
    private void saveProgressOnAction(ActionEvent event) {
        
        ArrayList<String> url = new ArrayList();
        ArrayList<String> x = new ArrayList();
        ArrayList<String> y = new ArrayList();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                url.add(cell[i][j].getDirection());
                x.add(String.valueOf(j));
                y.add(String.valueOf(i));
            }
        }   
//        System.out.println(rows);
//        System.out.println(columns);
//        for (int i = 0; i < rows; i++) {
//            for (int j = 0; j < columns; j++) {
//                System.out.println(cell[i][j].getDirection());
//                System.out.println(j);
//                 System.out.println(i);
//            }
//        }
        
      escribirJson("json", url, x, y, columns, rows);
    }

    public void setSelectedItem() {
        String selectedItem1 = "";
        ObservableList listOfItems = iconsListView.getSelectionModel().getSelectedItems();
        for (Object item : listOfItems) {
            selectedItem1 = (String) item;
        }
        this.selectedItem = selectedItem1;
    }

    public String getSelectedItem() {
        return this.selectedItem;
    }

}
