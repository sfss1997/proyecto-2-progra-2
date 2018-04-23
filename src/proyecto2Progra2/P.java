/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto2Progra2;

import archivos.ArchivosXML;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javax.xml.parsers.ParserConfigurationException;
import Domain.Imagenes;
import java.util.LinkedList;

/**
 *
 * @author fabian
 */
public class P extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("Sprite.fxml"));
        
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.show();
        
        
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        
        ArchivosXML arc = new ArchivosXML();
        LinkedList list = new LinkedList();
        list.add(arc.leerXml().get(0));
        System.out.println(list.get(0));
        ArchivosXML archivos = new ArchivosXML();
        archivos.generarDocumento();
        archivos.generarXml();
        
        launch(args);
    }
    
}
