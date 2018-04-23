/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto2Progra2;

import javafx.scene.layout.Pane;
import javafx.scene.shape.Line;

/**
 *
 * @author hvill
 */
public class Cell extends Pane {

    public Cell() {
        setStyle("-fx-border-color : black");
        this.setPrefSize(100, 100);
        this.setOnMouseClicked(e -> handleClick());
    }

    private void handleClick() {
        Line line1 = new Line(10, this.getHeight() - 10, this.getWidth() - 10, 10);
        line1.endXProperty().bind(this.widthProperty().subtract(10));
        line1.endYProperty().bind(this.heightProperty().subtract(10));
        
        getChildren().addAll(line1);
    }

}
