/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package archivos;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFileChooser;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

/**
 *
 * @author fabian
 */
public class ArchivosJSON {

    public void escribirJson(String usuario,ArrayList url,ArrayList x,ArrayList y, int ancho, int largo) {
        JSONObject obj = new JSONObject();
        
        

        JSONArray listUrl = new JSONArray();
        JSONArray listX = new JSONArray();
        JSONArray listY = new JSONArray();
        
        for (int i = 0; i < url.size(); i++) {
            listUrl.add(i,url.get(i));
            listX.add(i,x.get(i));
            listY.add(i,y.get(i));
        }
        
        obj.put("usuario", usuario);
        obj.put("ancho",ancho);
        obj.put("alto",largo);
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

}
