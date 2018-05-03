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
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javax.swing.JFileChooser;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

/**
 *
 * @author fabian
 */
public class ProyectsAdministration {

    /**
     *
     * @param name
     * @param url
     * @param x
     * @param y
     * @param columns
     * @param rows
     */
    public void writeJson(String name,ArrayList url,ArrayList x,ArrayList y, int columns, int rows) {
  
        JSONObject obj = new JSONObject();
        
        

        JSONArray listUrl = new JSONArray();
        JSONArray listX = new JSONArray();
        JSONArray listY = new JSONArray();
        
        for (int i = 0; i < url.size(); i++) {
            listUrl.add(i,url.get(i));
            listX.add(i,x.get(i));
            listY.add(i,y.get(i));
        }
        
        obj.put("name", name);
        obj.put("columns",columns);
        obj.put("rows", rows);
        obj.put("url", listUrl);
        obj.put("x", listX);
        obj.put("y", listY);
        
        try {
//            JFileChooser  saveImage = new JFileChooser();
//            saveImage.setApproveButtonText("Guardar");
//             saveImage.showSaveDialog(null);
            FileChooser saveProyect = new FileChooser() ;
            FileWriter file = new FileWriter(saveProyect.showSaveDialog(null)+".json");
//            FileWriter file = new FileWriter( saveImage.getSelectedFile()+".json");
            file.write(obj.toJSONString());
            file.flush();
            file.close();

        } catch (Exception ex) {
            System.out.println("Error: " + ex.toString());
        } finally {
            System.out.print(obj);
        }
    }
   
    /**
     *
     * @return
     * @throws Exception
     */
    public ArrayList readJson() throws Exception{
        
        JSONParser parser = new JSONParser();
//        JFileChooser abrirJson = new JFileChooser();
//       abrirJson.setApproveButtonText("Guardar");
//        abrirJson.showSaveDialog(null);
//        FileChooser abrirJson = new FileChooser();
//        abrirJson.getExtensionFilters().addAll(
//         new ExtensionFilter("JSON", "*.json"));
        
          
//            abrirJson.showSaveDialog(null);
            FileChooser openProyect = new FileChooser() ;
            Object obj = parser.parse(new FileReader(openProyect.showOpenDialog(null)));
//            Object obj = parser.parse(new FileReader(abrirJson.getSelectedFile()));
            JSONObject jsonObject = (JSONObject) obj;
            
            String name = jsonObject.get("name").toString();
            String columns =  jsonObject.get("columns").toString();
            String rows =   jsonObject.get("rows").toString();
            ArrayList url = (ArrayList) jsonObject.get("url");
            ArrayList x= (ArrayList) jsonObject.get("x");
            ArrayList y = (ArrayList) jsonObject.get("y");
            
            ArrayList<Object> jsonArchive = new ArrayList<>();
            
            jsonArchive.add(0,name);
            jsonArchive.add(1,columns);
            jsonArchive.add(2,rows);
            jsonArchive.add(3,url);
            jsonArchive.add(4,x);
            jsonArchive.add(5,y);
        return jsonArchive;
    }

}
