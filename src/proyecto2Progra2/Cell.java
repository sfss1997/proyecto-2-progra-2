/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto2Progra2;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.DragEvent;
import javafx.scene.input.TransferMode;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Line;

/**
 *
 * @author hvill
 */
public class Cell extends Pane {

    private ImageView imageView;
    
    public Cell() {
        setStyle("-fx-border-color : black");
        this.setPrefSize(100, 100);
        this.imageView = new ImageView();
        this.setOnMouseClicked(e -> handleClick());
    }

    private void handleClick() {
        this.getChildren().add(new ImageView("icon/chrome.png"));
    }

}
