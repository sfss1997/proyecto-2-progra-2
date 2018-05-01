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
    private GridPane pane;
    @FXML
    private TextField rowsTextField;
    @FXML
    private TextField columnsTextField;

    private ArchivosXML archivos;
    @FXML
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

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            // TODO
            archivos = new ArchivosXML();
            this.url = new ArrayList<>();
            this.x = new ArrayList<>();
            this.y = new ArrayList<>();
            setVBox();
        } catch (ParserConfigurationException ex) {
            Logger.getLogger(SpriteController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(SpriteController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    public void add(ActionEvent event) throws Exception {
        spriteAnchorPane.getChildren().clear();
        this.rows = Integer.parseInt(rowsTextField.getText());
        this.columns = Integer.parseInt(columnsTextField.getText());
        cell = new Cell[this.rows][this.columns];
        pane = new GridPane();

        for (int i = 0; i < Integer.parseInt(rowsTextField.getText()); i++) {
            for (int j = 0; j < Integer.parseInt(columnsTextField.getText()); j++) {
                cell[i][j] = new Cell();
                pane.add(cell[i][j], i, j);
            }
        }

        setupGestureTarget(pane);

        spriteAnchorPane.setPrefHeight(pane.getPrefHeight());
        spriteAnchorPane.setPrefWidth(pane.getPrefWidth());
        spriteAnchorPane.getChildren().add(pane);

    }

    private void setVBox() throws Exception {
        for (int i = 0; i < archivos.leerXml().size(); i++) {
            Image img = new Image(archivos.leerXml().get(i).getDireccion());
            insertImage(img, iconsVBox);
        }
    }

    void insertImage(Image i, VBox vb1) {

        auxImageView = new ImageView();
        auxImageView.setImage(i);

        setupGestureSource(auxImageView);

        vb1.getChildren().add(auxImageView);
    }

    void setupGestureSource(final ImageView source) {

        source.setOnDragDetected(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent event) {

                /* allow any transfer mode */
                Dragboard db = source.startDragAndDrop(TransferMode.MOVE);

                /* put a image on dragboard */
                ClipboardContent content = new ClipboardContent();

                Image sourceImage = source.getImage();
                content.putImage(sourceImage);
                db.setContent(content);

//                auxImageView = source;
                event.consume();
            }
        });

        source.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent e) {
                source.setCursor(Cursor.HAND);
//                    System.out.println("e...: "+e.getSceneX());
                curseur = (int) e.getSceneX();
            }
        });
    }

    @FXML
    private void deleteOnAction(ActionEvent event) {
        spriteAnchorPane.getChildren().clear();
    }

    private void setupGestureTarget(final GridPane targetBox) {
//
//        targetBox.setOnDragOver(new EventHandler<DragEvent>() {
//            @Override
//            public void handle(DragEvent event) {
//
//                Dragboard db = event.getDragboard();
//
//                if (db.hasImage()) {
//                    event.acceptTransferModes(TransferMode.MOVE);
//                }
//
//                event.consume();
//            }
//        });
//
//        targetBox.setOnDragDropped(new EventHandler<DragEvent>() {
//            @Override
//            public void handle(DragEvent event) {
//
//                Dragboard db = event.getDragboard();
//
//                if (db.hasImage()) {
//
//                    auxImageView.setImage(db.getImage());
//
//                    Point2D localPoint = targetBox.sceneToLocal(new Point2D(event.getSceneX(), event.getSceneY()));
//
////                    System.out.println("event.getSceneX : "+event.getSceneX());
////                    System.out.println("localPoint.getX : "+localPoint.getX());
////                    System.out.println("********");
//                    targetBox.getChildren().remove(auxImageView);
//
//                    auxImageView.setX((int) (localPoint.getX() - auxImageView.getBoundsInLocal().getWidth() / 2));
//                    auxImageView.setY((int) (localPoint.getY() - auxImageView.getBoundsInLocal().getHeight() / 2));
//
//                    targetBox.getChildren().add(auxImageView);
//
//                    event.consume();
//                }
//            }
//        });

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

}
