/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto2Progra2;

import archivos.ProyectsAdministration;
import archivos.ImagesAdministration;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javax.xml.parsers.ParserConfigurationException;

/**
 *
 * @author hvill
 */
public class Cell extends Pane {

    private ImageView imageView;
    private SpriteController spriteController;
    private ImagesAdministration xmlArchives;
    private int row;
    private int column;
    private String url;

    public Cell() {
        try {
            setStyle("-fx-border-color : black");
            this.setPrefSize(100, 100);
            this.setOnMouseClicked(e -> handleClick());
            this.spriteController = new SpriteController();
            this.xmlArchives = new ImagesAdministration();
            this.url = "";
        } catch (ParserConfigurationException ex) {
            Logger.getLogger(Cell.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Se ejecuta cuando se da click en una celda.
     */
    private void handleClick() {
        try {
            String selectedItem = spriteController.getSelectedItem();
            if (!selectedItem.equals("")) {
                for (int i = 0; i < xmlArchives.readXml().size(); i++) {
                    if (xmlArchives.readXml().get(i).getName().equals(selectedItem)) {
                        this.getChildren().clear();
                        this.getChildren().add(new ImageView(xmlArchives.readXml().get(i).getUrl()));
                        setUrl(xmlArchives.readXml().get(i).getUrl());
                    }
                }
            } else {
                this.getChildren().clear();
                this.url = "";
            }
        } catch (Exception ex) {
            Logger.getLogger(Cell.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getColumn() {
        return column;
    }

    public void setColumn(int column) {
        this.column = column;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

}
