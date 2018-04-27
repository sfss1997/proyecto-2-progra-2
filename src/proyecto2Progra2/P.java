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
import archivos.ArchivosJSON;
import java.util.LinkedList;
import java.util.ArrayList;

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
        
        
       
        
        ArchivosXML archivosXML = new ArchivosXML();
        ArchivosJSON archivosJSON = new ArchivosJSON();
        archivosXML.generarDocumento();
        archivosXML.generarXml();
//        archivosXML.leerXml();
        ArrayList<String> url = new ArrayList();
        ArrayList<String> x = new ArrayList();
        ArrayList<String> y = new ArrayList();
        
        url.add("icon/apple.png");
        url.add("icon/chrome.png");
        x.add("100");
        x.add("200");
        y.add("300");
        y.add("400");
        int ancho = 2;
        int largo = 2;
        archivosJSON.escribirJson("pedro", url, x, y, ancho, largo);
        
      
        
        launch(args);
    }
    
}
