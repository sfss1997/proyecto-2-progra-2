/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package archivos;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFileChooser;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

/**
 *
 * @author fabian
 */
public class ArchivosJSON {

    public void escribirJson(String nombre,ArrayList url,ArrayList x,ArrayList y, int columnas, int filas) {
        System.out.println("llega al escribir json");
        JSONObject obj = new JSONObject();
        
        

        JSONArray listUrl = new JSONArray();
        JSONArray listX = new JSONArray();
        JSONArray listY = new JSONArray();
        
        for (int i = 0; i < url.size(); i++) {
            listUrl.add(i,url.get(i));
            listX.add(i,x.get(i));
            listY.add(i,y.get(i));
        }
        
        obj.put("nombre", nombre);
        obj.put("columnas",columnas);
        obj.put("filas", filas);
        obj.put("url", listUrl);
        obj.put("x", listX);
        obj.put("y", listY);
        
        try {
            JFileChooser guardarImagen = new JFileChooser();
            guardarImagen.setApproveButtonText("Guardar");
            guardarImagen.showSaveDialog(null);
            FileWriter file = new FileWriter(guardarImagen.getSelectedFile()+".json");
            file.write(obj.toJSONString());
            file.flush();
            file.close();

        } catch (Exception ex) {
            System.out.println("Error: " + ex.toString());
        } finally {
            System.out.print(obj);
        }
    }
    public ArrayList leerJson() throws Exception{
        
        JSONParser parser = new JSONParser();
        JFileChooser abrirJson = new JFileChooser();
            abrirJson.setApproveButtonText("Abrir");
            abrirJson.setApproveButtonToolTipText("Abrir");
            abrirJson.setToolTipText("Abrir");
            abrirJson.showSaveDialog(null);
            
            Object obj = parser.parse(new FileReader(abrirJson.getSelectedFile()+""));
            JSONObject jsonObject = (JSONObject) obj;
            
            String nombre = jsonObject.get("nombre").toString();
            String columnas =  jsonObject.get("columnas").toString();
            String filas =   jsonObject.get("filas").toString();
            ArrayList url = (ArrayList) jsonObject.get("url");
            ArrayList x= (ArrayList) jsonObject.get("x");
            ArrayList y = (ArrayList) jsonObject.get("y");
            
            ArrayList<Object> archivoJson = new ArrayList<>();
            
            archivoJson.add(0,nombre);
            archivoJson.add(1,columnas);
            archivoJson.add(2,filas);
            archivoJson.add(3,url);
            archivoJson.add(4,x);
            archivoJson.add(5,y);
        return archivoJson;
    }

}
