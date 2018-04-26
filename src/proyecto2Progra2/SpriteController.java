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
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Point2D;
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
import javafx.scene.input.MouseEvent;
import javafx.scene.input.TransferMode;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javax.imageio.ImageIO;
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
    private TextField rows;
    @FXML
    private TextField columns;

    private ArchivosXML archivos;
    @FXML
    private VBox iconsVBox;
    @FXML
    private MenuItem deleteMenuItem;
    private Object fileChooser;

    private ImageView auxImageView;
    private int curseur;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            // TODO
            archivos = new ArchivosXML();
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
        cell = new Cell[Integer.parseInt(rows.getText())][Integer.parseInt(columns.getText())];
        pane = new GridPane();

        for (int i = 0; i < Integer.parseInt(rows.getText()); i++) {
            for (int j = 0; j < Integer.parseInt(columns.getText()); j++) {
                cell[i][j] = new Cell();
                pane.add(cell[i][j], j, i);
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

        targetBox.setOnDragOver(new EventHandler<DragEvent>() {
            @Override
            public void handle(DragEvent event) {

                Dragboard db = event.getDragboard();

                if (db.hasImage()) {
                    event.acceptTransferModes(TransferMode.MOVE);
                }

                event.consume();
            }
        });

        targetBox.setOnDragDropped(new EventHandler<DragEvent>() {
            @Override
            public void handle(DragEvent event) {

                Dragboard db = event.getDragboard();

                if (db.hasImage()) {

                    auxImageView.setImage(db.getImage());

                    Point2D localPoint = targetBox.sceneToLocal(new Point2D(event.getSceneX(), event.getSceneY()));

//                    System.out.println("event.getSceneX : "+event.getSceneX());
//                    System.out.println("localPoint.getX : "+localPoint.getX());
//                    System.out.println("********");
                    targetBox.getChildren().remove(auxImageView);

                    auxImageView.setX((int) (localPoint.getX() - auxImageView.getBoundsInLocal().getWidth() / 2));
                    auxImageView.setY((int) (localPoint.getY() - auxImageView.getBoundsInLocal().getHeight() / 2));

                    targetBox.getChildren().add(auxImageView);

                    event.consume();
                }
            }
        });

    }
    public void exportAsImage() {
        WritableImage image = spriteAnchorPane.snapshot(new SnapshotParameters(), null);
        // TODO: probably use a file chooser here
        File file = new File("sprite.png");
        try {
            ImageIO.write(SwingFXUtils.fromFXImage(image, null), "png", file);
        } catch (IOException e) {
            // TODO: handle exception here
        }
    }

}
