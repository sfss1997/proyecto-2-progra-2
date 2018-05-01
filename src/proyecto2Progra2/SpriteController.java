/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto2Progra2;

import archivos.ArchivosXML;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Point2D;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.SnapshotParameters;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.WritableImage;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.DragEvent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.TransferMode;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileSystemView;

import javax.xml.parsers.ParserConfigurationException;

/**
 *
 * @author fabian
 */
public class SpriteController implements Initializable {
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
    private VBox iconsVBox;
    @FXML
    private MenuItem deleteMenuItem;
    private Object fileChooser;

    private ImageView auxImageView;
    private int curseur;

    private int rows;
    private int columns;

    private ArrayList<String> url;
    private ArrayList<String> x;
    private ArrayList<String> y;
    @FXML
    private ListView<String> iconsListView;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            // TODO
            archivosXML = new ArchivosXML();
            this.auxImageView = new ImageView("icon/chrome.png");
            this.url = new ArrayList<>();
            this.x = new ArrayList<>();
            this.y = new ArrayList<>();
            setListView();
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

    private void setListView() throws Exception {
        Image img1 = new Image("icon/apple.png");
        Image img2 = new Image("icon/chrome.png");

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

    public ImageView getAuxImageView() {
        return this.auxImageView;
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
    }

    @FXML
    private void adaadfasdf(ActionEvent event) {
        String textAreaString = "";
        ObservableList listOfItems = iconsListView.getSelectionModel().getSelectedItems();
        for (Object item : listOfItems) {
            textAreaString += (String) item;
        }
        System.out.println(textAreaString);
    }

    public String getSelectedItemFromListView() {
        String selectedItem = "";
        ObservableList<String> listOfItems = iconsListView.getSelectionModel().getSelectedItems();
        for (Object item : listOfItems) {
            selectedItem = (String) item;
        }
        return selectedItem;
    }

}
