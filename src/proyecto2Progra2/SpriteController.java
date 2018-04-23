/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto2Progra2;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.DragEvent;
import javafx.scene.input.TransferMode;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;

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
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    public void add(ActionEvent event) {
        spriteAnchorPane.getChildren().clear();
        cell = new Cell[Integer.parseInt(rows.getText())][Integer.parseInt(columns.getText())];
        pane = new GridPane();
        
        ImageView imageView = new ImageView();
        
        pane.setOnDragOver(new EventHandler<DragEvent>() {
            @Override
            public void handle(DragEvent event) {
                if (event.getDragboard().hasFiles()) {
                    event.acceptTransferModes(TransferMode.ANY);
                }
            }
        });
        pane.setOnDragDropped(new EventHandler<DragEvent>() {
            @Override
            public void handle(DragEvent event) {
                try {
                    List<File> files = event.getDragboard().getFiles();
                    Image img = new Image(new FileInputStream(files.get(0)));
                    imageView.setImage(img);
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(Cell.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });

        for (int i = 0; i < Integer.parseInt(rows.getText()); i++) {
            for (int j = 0; j < Integer.parseInt(columns.getText()); j++) {
                cell[i][j] = new Cell();
                pane.add(cell[i][j], j, i);
            }
        }
        spriteAnchorPane.setPrefHeight(pane.getPrefHeight());
        spriteAnchorPane.setPrefWidth(pane.getPrefWidth());
        spriteAnchorPane.getChildren().add(pane);
        
    }

    
}
