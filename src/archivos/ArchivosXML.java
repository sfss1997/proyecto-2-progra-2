/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package archivos;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 *
 * @author fabian
 */
public class ArchivosXML {
    private Document document;
    private Element elementoRaiz;
    

    public ArchivosXML() throws ParserConfigurationException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        document = builder.newDocument();
        
    }
    
    public void generarDocumento() {
        Element element = document.createElement("imagenes");
        document.appendChild(element);
        Element nombre = document.createElement("apple");
        element.appendChild(nombre);
        nombre.setAttribute("Direccion", "\\icon\\apple.png");
        
        nombre = document.createElement("chrome");
        element.appendChild(nombre);
        nombre.setAttribute("Direccion", "\\icon\\chrome.png");
        
        nombre = document.createElement("facebook");
        element.appendChild(nombre);
        nombre.setAttribute("Direccion", "\\icon\\facebook.png");
        
        nombre = document.createElement("google");
        element.appendChild(nombre);
        nombre.setAttribute("Direccion", "\\icon\\google.png");
        
        nombre = document.createElement("googlePlay");
        element.appendChild(nombre);
        nombre.setAttribute("Direccion", "\\icon\\googlePlay.png");
        
        nombre = document.createElement("hp");
        element.appendChild(nombre);
        nombre.setAttribute("Direccion", "\\icon\\hp.png");
        
        nombre = document.createElement("instagram");
        element.appendChild(nombre);
        nombre.setAttribute("Direccion", "\\icon\\instagram.png");
       
        nombre = document.createElement("internetExplorer");
        element.appendChild(nombre);
        nombre.setAttribute("Direccion", "\\icon\\internetExplorer.png");
        
        nombre = document.createElement("messenger");
        element.appendChild(nombre);
        nombre.setAttribute("Direccion", "\\icon\\messenger.png");
        
        nombre = document.createElement("microsoft");
        element.appendChild(nombre);
        nombre.setAttribute("Direccion", "\\icon\\microsoft.png");
        
        nombre = document.createElement("playStation");
        element.appendChild(nombre);
        nombre.setAttribute("Direccion", "\\icon\\playStation.png");
        
        nombre = document.createElement("telegram");
        element.appendChild(nombre);
        nombre.setAttribute("Direccion", "\\icon\\telegram.png");
        
        nombre = document.createElement("twitter");
        element.appendChild(nombre);
        nombre.setAttribute("Direccion", "\\icon\\twitter.png");
        
        nombre = document.createElement("whatsapp");
        element.appendChild(nombre);
        nombre.setAttribute("Direccion", "\\icon\\whatsapp.png");
        
        nombre = document.createElement("youTube");
        element.appendChild(nombre);
        nombre.setAttribute("Direccion", "\\icon\\youTube.png");
    }
    
    public void generarXml() throws TransformerConfigurationException, IOException, TransformerException{
        TransformerFactory factory = TransformerFactory.newInstance();
        Transformer transformer = factory.newTransformer();
        
        Source source = new DOMSource(document);
        File file = new File ("imagenes.xml");
        FileWriter fw = new FileWriter(file);
        PrintWriter pw = new PrintWriter(fw);
        Result result = new StreamResult(pw);
        
        transformer.transform(source, result);
    }
    
    public void leerXml() throws Exception{
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.parse("imagenes.xml");
        
        elementoRaiz=  document.getDocumentElement();
        
        NodeList listaImagenes = elementoRaiz.getElementsByTagName("imagenes");
        
        for (int i = 0; i < listaImagenes.getLength(); i++) {
            Node imagen = listaImagenes.item(i);
            System.out.println("Imagen"+1);
            
            NodeList datosImagenes = imagen.getChildNodes();
            for (int j = 0; j < datosImagenes.getLength(); j++) {
                Node datos = datosImagenes.item(j);
                if (datos.getNodeType() == Node.ELEMENT_NODE) {
                    System.out.println(datos.getLocalName());
                    
                }
                Node contenido = datos.getFirstChild();
                if (contenido !=null) {
                    System.out.println(" "+contenido.getNodeValue());
                    
                }
            }
            System.out.println("");
        }
    }
}
