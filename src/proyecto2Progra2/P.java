/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto2Progra2;

import archivos.ImagesAdministration;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javax.xml.parsers.ParserConfigurationException;
import Domain.Images;
import archivos.ProyectsAdministration;
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
        
        
       
        
//        ImagesAdministration archivosXML = new ImagesAdministration();
//        ProyectsAdministration archivosJSON = new ProyectsAdministration();
//        archivosXML.generarDocumento();
//        archivosXML.generarXml();
//        archivosXML.leerXml();
//        ArrayList<String> url = new ArrayList();
//        ArrayList<String> x = new ArrayList();
//        ArrayList<String> y = new ArrayList();
//        
//        url.add("icon/apple.png");
//        url.add("icon/chrome.png");
//        
//        
//        x.add("100");
//        x.add("200");
//        y.add("300");
//        y.add("400");
//        int ancho = 2;
//        int largo = 2;
//        archivosJSON.escribirJson("proyec1", url, x, y, ancho, largo);

//        ArrayList<Object> archivoJson = archivosJSON.leerJson();
//        
//        System.out.println("nombre : "+archivoJson.get(0));
//        System.out.println("ancho : "+archivoJson.get(1));
//        System.out.println("alto : "+archivoJson.get(2));
//        ArrayList url2 = (ArrayList) archivoJson.get(3);
//        ArrayList x2= (ArrayList) archivoJson.get(4);
//        ArrayList y2 = (ArrayList) archivoJson.get(5);
//        
//        for (int i = 0; i < url2.size(); i++) {
//            
//            
//            System.out.println(url2.get(i));
//            System.out.println(x2.get(i));
//            System.out.println(y2.get(i));
//            
//        }
      
        
          launch(args);
    }

}
