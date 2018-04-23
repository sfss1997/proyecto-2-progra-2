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
        nombre.setAttribute("id", "1");
        Element direccion1 = document.createElement("direccion");
        direccion1.appendChild(document.createTextNode("\\icon\\apple.png"));
        nombre.appendChild(direccion1);
        
        nombre = document.createElement("chrome");
        element.appendChild(nombre);
        nombre.setAttribute("id", "2");
        Element direccion2 = document.createElement("direccion");
        direccion2.appendChild(document.createTextNode("\\icon\\chrome.png"));
        nombre.appendChild(direccion2);
        
        nombre = document.createElement("facebook");
        element.appendChild(nombre);
        nombre.setAttribute("id", "3");
        Element direccion3 = document.createElement("direccion");
        direccion3.appendChild(document.createTextNode("\\icon\\facebook.png"));
        nombre.appendChild(direccion3);
        
        nombre = document.createElement("google");
        element.appendChild(nombre);
        nombre.setAttribute("id", "4");
        Element direccion4 = document.createElement("direccion");
        direccion4.appendChild(document.createTextNode("\\icon\\google.png"));
        nombre.appendChild(direccion4);
        
        nombre = document.createElement("googlePlay");
        element.appendChild(nombre);
        nombre.setAttribute("id", "5");
        Element direccion5 = document.createElement("direccion");
        direccion5.appendChild(document.createTextNode("\\icon\\googlePlay.png"));
        nombre.appendChild(direccion5);
        
        nombre = document.createElement("hp");
        element.appendChild(nombre);
        nombre.setAttribute("id", "6");
        Element direccion6 = document.createElement("direccion");
        direccion6.appendChild(document.createTextNode("\\icon\\hp.png"));
        nombre.appendChild(direccion6);
        
        nombre = document.createElement("instagram");
        element.appendChild(nombre);
        nombre.setAttribute("id", "7");
        Element direccion7 = document.createElement("direccion");
        direccion7.appendChild(document.createTextNode("\\icon\\instagram.png"));
        nombre.appendChild(direccion7);
       
        nombre = document.createElement("internetExplorer");
        element.appendChild(nombre);
        nombre.setAttribute("id", "8");
        Element direccion8 = document.createElement("direccion");
        direccion8.appendChild(document.createTextNode("\\icon\\internetExplorer.png"));
        nombre.appendChild(direccion8);
        
        nombre = document.createElement("messenger");
        element.appendChild(nombre);
        nombre.setAttribute("id", "9");
        Element direccion9 = document.createElement("direccion");
        direccion9.appendChild(document.createTextNode("\\icon\\messenger.png"));
        nombre.appendChild(direccion9);
        
        nombre = document.createElement("microsoft");
        element.appendChild(nombre);
        nombre.setAttribute("id", "10");
        Element direccion10 = document.createElement("direccion");
        direccion10.appendChild(document.createTextNode("\\icon\\microsoft.png"));
        nombre.appendChild(direccion10);
        
        nombre = document.createElement("playStation");
        element.appendChild(nombre);
        nombre.setAttribute("id", "11");
        Element direccion11 = document.createElement("direccion");
        direccion11.appendChild(document.createTextNode("\\icon\\playStation.png"));
        nombre.appendChild(direccion11);
        
        nombre = document.createElement("telegram");
        element.appendChild(nombre);
        nombre.setAttribute("id", "12");
        Element direccion12 = document.createElement("direccion");
        direccion12.appendChild(document.createTextNode("\\icon\\telegram.png"));
        nombre.appendChild(direccion12);
        
        nombre = document.createElement("twitter");
        element.appendChild(nombre);
        nombre.setAttribute("id", "13");
        Element direccion13 = document.createElement("direccion");
        direccion13.appendChild(document.createTextNode("\\icon\\twitter.png"));
        nombre.appendChild(direccion13);
        
        nombre = document.createElement("whatsapp");
        element.appendChild(nombre);
       nombre.setAttribute("id", "14");
       Element direccion14 = document.createElement("direccion");
       direccion14.appendChild(document.createTextNode("\\icon\\whatsapp.png"));
        nombre.appendChild(direccion14);
       
        nombre = document.createElement("youTube");
        element.appendChild(nombre);
        nombre.setAttribute("id", "15");
        Element direccion15 = document.createElement("direccion");
        direccion15.appendChild(document.createTextNode("\\icon\\youTube.png"));
        nombre.appendChild(direccion15);
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
        
      try {
         File inputFile = new File("imagenes.xml");
         DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
         DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
         Document doc = dBuilder.parse(inputFile);
         doc.getDocumentElement().normalize();
         System.out.println("Root element :" + doc.getDocumentElement().getNodeName());
         NodeList nList = doc.getElementsByTagName("imagenes");
         System.out.println("----------------------------");
         
         for (int temp = 0; temp < nList.getLength(); temp++) {
            Node nNode = nList.item(temp);
            System.out.println("\nCurrent Element :" + nNode.getChildNodes().item(temp).getNodeName());
            
            if (nNode.getNodeType() == Node.ELEMENT_NODE) {
               Element eElement = (Element) nNode;
               System.out.println("direccion : " 
                  + eElement.getAttribute(""+eElement.getAttribute("direccion")));
               
            }
         }
      } catch (Exception e) {
         e.printStackTrace();
      }
    }
}
