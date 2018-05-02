/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto2Progra2;

import archivos.ArchivosXML;
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
    private ArchivosXML archivosXML;
    private int row;
    private int column;
    private String direction;
    
    public Cell() {
        try {
            setStyle("-fx-border-color : black");
            this.setPrefSize(100, 100);
            this.setOnMouseClicked(e -> handleClick());
            this.spriteController = new SpriteController();
            this.archivosXML = new ArchivosXML();
        } catch (ParserConfigurationException ex) {
            Logger.getLogger(Cell.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void handleClick() {
        try {
            String selectedItem = spriteController.getSelectedItem();
            if(!selectedItem.equals("")){
                for (int i = 0; i < archivosXML.leerXml().size(); i++) {
                    if(archivosXML.leerXml().get(i).getNombre().equals(selectedItem)){
                        this.getChildren().clear();
                        this.getChildren().add(new ImageView(archivosXML.leerXml().get(i).getDireccion()));
                        setName(archivosXML.leerXml().get(i).getDireccion());
                    }
                }
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

    public String getName() {
        return direction;
    }

    public void setName(String name) {
        this.direction = name;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    
}
