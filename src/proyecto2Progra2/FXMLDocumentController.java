/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto2Progra2;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;

/**
 *
 * @author fabian
 */
public class FXMLDocumentController implements Initializable {
    //

    @FXML
    private AnchorPane spriteAnchorPane;

    private Cell[][] cell = new Cell[3][3];
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    public void add(ActionEvent event) {
        GridPane pane = new GridPane();

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                cell[i][j] = new Cell();
                pane.add(cell[i][j], j, i);
            }
        }
        
        spriteAnchorPane.getChildren().add(pane);
        
    }
    
}
