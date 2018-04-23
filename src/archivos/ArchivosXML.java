/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package archivos;

import Domain.Imagenes;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.LinkedList;
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
        
        Element nombre = document.createElement("imagen");
        element.appendChild(nombre);
        nombre.setAttribute("id", "1");
        Element nombre1 = document.createElement("nombre");
        nombre1.appendChild(document.createTextNode("apple"));
        nombre.appendChild(nombre1);
        Element direccion1 = document.createElement("direccion");
        direccion1.appendChild(document.createTextNode("\\icon\\apple.png"));
        nombre.appendChild(direccion1);
        
        nombre = document.createElement("imagen");
        element.appendChild(nombre);
        nombre.setAttribute("id", "2");
        Element nombre2 = document.createElement("nombre");
        nombre2.appendChild(document.createTextNode("chrome"));
        nombre.appendChild(nombre2);
        Element direccion2 = document.createElement("direccion");
        direccion2.appendChild(document.createTextNode("\\icon\\chrome.png"));
        nombre.appendChild(direccion2);
        
        nombre = document.createElement("imagen");
        element.appendChild(nombre);
        nombre.setAttribute("id", "3");
        Element nombre3 = document.createElement("nombre");
        nombre3.appendChild(document.createTextNode("facebook"));
        nombre.appendChild(nombre3);
        Element direccion3 = document.createElement("direccion");
        direccion3.appendChild(document.createTextNode("\\icon\\facebook.png"));
        nombre.appendChild(direccion3);
        
        nombre = document.createElement("imagen");
        element.appendChild(nombre);
        nombre.setAttribute("id", "4");
        Element nombre4 = document.createElement("nombre");
        nombre4.appendChild(document.createTextNode("google"));
        nombre.appendChild(nombre4);
        Element direccion4 = document.createElement("direccion");
        direccion4.appendChild(document.createTextNode("\\icon\\google.png"));
        nombre.appendChild(direccion4);
        
        nombre = document.createElement("imagen");
        element.appendChild(nombre);
        nombre.setAttribute("id", "5");
        Element nombre5 = document.createElement("nombre");
        nombre5.appendChild(document.createTextNode("googlePlay"));
        nombre.appendChild(nombre5);
        Element direccion5 = document.createElement("direccion");
        direccion5.appendChild(document.createTextNode("\\icon\\googlePlay.png"));
        nombre.appendChild(direccion5);
        
        nombre = document.createElement("imagen");
        element.appendChild(nombre);
        nombre.setAttribute("id", "6");
        Element nombre6 = document.createElement("nombre");
        nombre6.appendChild(document.createTextNode("hp"));
        nombre.appendChild(nombre6);
        Element direccion6 = document.createElement("direccion");
        direccion6.appendChild(document.createTextNode("\\icon\\hp.png"));
        nombre.appendChild(direccion6);
        
        nombre = document.createElement("imagen");
        element.appendChild(nombre);
        nombre.setAttribute("id", "7");
        Element nombre7 = document.createElement("nombre");
        nombre7.appendChild(document.createTextNode("instagram"));
        nombre.appendChild(nombre7);
        Element direccion7 = document.createElement("direccion");
        direccion7.appendChild(document.createTextNode("\\icon\\instagram.png"));
        nombre.appendChild(direccion7);
       
        nombre = document.createElement("imagen");
        element.appendChild(nombre);
        nombre.setAttribute("id", "8");
        Element nombre8 = document.createElement("nombre");
        nombre8.appendChild(document.createTextNode("internetExplorer"));
        nombre.appendChild(nombre8);
        Element direccion8 = document.createElement("direccion");
        direccion8.appendChild(document.createTextNode("\\icon\\internetExplorer.png"));
        nombre.appendChild(direccion8);
        
        nombre = document.createElement("imagen");
        element.appendChild(nombre);
        nombre.setAttribute("id", "9");
        Element nombre9 = document.createElement("nombre");
        nombre9.appendChild(document.createTextNode("messenger"));
        nombre.appendChild(nombre9);
        Element direccion9 = document.createElement("direccion");
        direccion9.appendChild(document.createTextNode("\\icon\\messenger.png"));
        nombre.appendChild(direccion9);
        
        nombre = document.createElement("imagen");
        element.appendChild(nombre);
        nombre.setAttribute("id", "10");
        Element nombre10 = document.createElement("nombre");
        nombre10.appendChild(document.createTextNode("microsoft"));
        nombre.appendChild(nombre10);
        Element direccion10 = document.createElement("direccion");
        direccion10.appendChild(document.createTextNode("\\icon\\microsoft.png"));
        nombre.appendChild(direccion10);
        
        nombre = document.createElement("imagen");
        element.appendChild(nombre);
        nombre.setAttribute("id", "11");
        Element nombre11 = document.createElement("nombre");
        nombre11.appendChild(document.createTextNode("playStation"));
        nombre.appendChild(nombre11);
        Element direccion11 = document.createElement("direccion");
        direccion11.appendChild(document.createTextNode("\\icon\\playStation.png"));
        nombre.appendChild(direccion11);
        
        nombre = document.createElement("imagen");
        element.appendChild(nombre);
        nombre.setAttribute("id", "12");
        Element nombre12 = document.createElement("nombre");
        nombre12.appendChild(document.createTextNode("telegram"));
        nombre.appendChild(nombre12);
        Element direccion12 = document.createElement("direccion");
        direccion12.appendChild(document.createTextNode("\\icon\\telegram.png"));
        nombre.appendChild(direccion12);
        
        nombre = document.createElement("imagen");
        element.appendChild(nombre);
        nombre.setAttribute("id", "13");
        Element nombre13 = document.createElement("nombre");
        nombre13.appendChild(document.createTextNode("twitter"));
        nombre.appendChild(nombre13);
        Element direccion13 = document.createElement("direccion");
        direccion13.appendChild(document.createTextNode("\\icon\\twitter.png"));
        nombre.appendChild(direccion13);
        
        nombre = document.createElement("imagen");
        element.appendChild(nombre);
       nombre.setAttribute("id", "14");
       Element nombre14 = document.createElement("nombre");
        nombre14.appendChild(document.createTextNode("whatsapp"));
        nombre.appendChild(nombre14);
       Element direccion14 = document.createElement("direccion");
       direccion14.appendChild(document.createTextNode("\\icon\\whatsapp.png"));
        nombre.appendChild(direccion14);
       
        nombre = document.createElement("imagen");
        element.appendChild(nombre);
        nombre.setAttribute("id", "15");
        Element nombre15 = document.createElement("nombre");
        nombre15.appendChild(document.createTextNode("youTube"));
        nombre.appendChild(nombre15);
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
    
    public ArrayList<Imagenes> leerXml() throws Exception{
        ArrayList<Imagenes> listaImagenes = new ArrayList<>();
      try {
            File archivo = new File("imagenes.xml");
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = dbf.newDocumentBuilder();
            Document document = documentBuilder.parse(archivo);
            document.getDocumentElement().normalize();
            System.out.println("Elemento raiz:" + document.getDocumentElement().getNodeName());
            NodeList listaArchivo = document.getElementsByTagName("imagen");
            for (int temp = 0; temp < listaArchivo.getLength(); temp++) {
                Node nodo = listaArchivo.item(temp);
                System.out.println("Elemento:" + nodo.getNodeName());
                if (nodo.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) nodo;
                    System.out.println("id: " + element.getAttribute("id"));
                    System.out.println("Nombre: " + element.getElementsByTagName("nombre").item(0).getTextContent());
                    System.out.println("Direccion: " + element.getElementsByTagName("direccion").item(0).getTextContent()+"\n\n");
                    Imagenes imagenes = new Imagenes();
                    imagenes.setId(Integer.parseInt(element.getAttribute("id")));
                    imagenes.setNombre(element.getElementsByTagName("nombre").item(0).getTextContent());
                    imagenes.setDireccion(element.getElementsByTagName("direccion").item(0).getTextContent());
                    listaImagenes.add(imagenes);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listaImagenes;
    }
}
