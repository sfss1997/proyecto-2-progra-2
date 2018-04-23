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
    private Element rootElement;
    
    /**
     *
     * @throws ParserConfigurationException
     */
    public ArchivosXML() throws ParserConfigurationException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        document = builder.newDocument();
        
    }
    
    /**
     *
     */
    public void generarDocumento() {
        Element element = document.createElement("imagenes");
        document.appendChild(element);
        
        Element name = document.createElement("imagen");
        element.appendChild(name);
        name.setAttribute("id", "1");
        Element name1 = document.createElement("nombre");
        name1.appendChild(document.createTextNode("apple"));
        name.appendChild(name1);
        Element url1 = document.createElement("direccion");
        url1.appendChild(document.createTextNode("icon/apple.png"));
        name.appendChild(url1);
        
        name = document.createElement("imagen");
        element.appendChild(name);
        name.setAttribute("id", "2");
        Element name2 = document.createElement("nombre");
        name2.appendChild(document.createTextNode("chrome"));
        name.appendChild(name2);
        Element url2 = document.createElement("direccion");
        url2.appendChild(document.createTextNode("icon/chrome.png"));
        name.appendChild(url2);
        
        name = document.createElement("imagen");
        element.appendChild(name);
        name.setAttribute("id", "3");
        Element name3 = document.createElement("nombre");
        name3.appendChild(document.createTextNode("facebook"));
        name.appendChild(name3);
        Element url3 = document.createElement("direccion");
        url3.appendChild(document.createTextNode("icon/facebook.png"));
        name.appendChild(url3);
        
        name = document.createElement("imagen");
        element.appendChild(name);
        name.setAttribute("id", "4");
        Element name4 = document.createElement("nombre");
        name4.appendChild(document.createTextNode("google"));
        name.appendChild(name4);
        Element url4 = document.createElement("direccion");
        url4.appendChild(document.createTextNode("icon/google.png"));
        name.appendChild(url4);
        
        name = document.createElement("imagen");
        element.appendChild(name);
        name.setAttribute("id", "5");
        Element name5 = document.createElement("nombre");
        name5.appendChild(document.createTextNode("googlePlay"));
        name.appendChild(name5);
        Element url5 = document.createElement("direccion");
        url5.appendChild(document.createTextNode("icon/googlePlay.png"));
        name.appendChild(url5);
        
        name = document.createElement("imagen");
        element.appendChild(name);
        name.setAttribute("id", "6");
        Element name6 = document.createElement("nombre");
        name6.appendChild(document.createTextNode("hp"));
        name.appendChild(name6);
        Element url6 = document.createElement("direccion");
        url6.appendChild(document.createTextNode("icon/hp.png"));
        name.appendChild(url6);
        
        name = document.createElement("imagen");
        element.appendChild(name);
        name.setAttribute("id", "7");
        Element name7 = document.createElement("nombre");
        name7.appendChild(document.createTextNode("instagram"));
        name.appendChild(name7);
        Element url7 = document.createElement("direccion");
        url7.appendChild(document.createTextNode("icon/instagram.png"));
        name.appendChild(url7);
       
        name = document.createElement("imagen");
        element.appendChild(name);
        name.setAttribute("id", "8");
        Element name8 = document.createElement("nombre");
        name8.appendChild(document.createTextNode("internetExplorer"));
        name.appendChild(name8);
        Element url8 = document.createElement("direccion");
        url8.appendChild(document.createTextNode("icon/internetExplorer.png"));
        name.appendChild(url8);
        
        name = document.createElement("imagen");
        element.appendChild(name);
        name.setAttribute("id", "9");
        Element name9 = document.createElement("nombre");
        name9.appendChild(document.createTextNode("messenger"));
        name.appendChild(name9);
        Element url9 = document.createElement("direccion");
        url9.appendChild(document.createTextNode("icon/messenger.png"));
        name.appendChild(url9);
        
        name = document.createElement("imagen");
        element.appendChild(name);
        name.setAttribute("id", "10");
        Element name10 = document.createElement("nombre");
        name10.appendChild(document.createTextNode("microsoft"));
        name.appendChild(name10);
        Element url10 = document.createElement("direccion");
        url10.appendChild(document.createTextNode("icon/microsoft.png"));
        name.appendChild(url10);
        
        name = document.createElement("imagen");
        element.appendChild(name);
        name.setAttribute("id", "11");
        Element name11 = document.createElement("nombre");
        name11.appendChild(document.createTextNode("playStation"));
        name.appendChild(name11);
        Element url11 = document.createElement("direccion");
        url11.appendChild(document.createTextNode("icon/playStation.png"));
        name.appendChild(url11);
        
        name = document.createElement("imagen");
        element.appendChild(name);
        name.setAttribute("id", "12");
        Element name12 = document.createElement("nombre");
        name12.appendChild(document.createTextNode("telegram"));
        name.appendChild(name12);
        Element url12 = document.createElement("direccion");
        url12.appendChild(document.createTextNode("icon/telegram.png"));
        name.appendChild(url12);
        
        name = document.createElement("imagen");
        element.appendChild(name);
        name.setAttribute("id", "13");
        Element name13 = document.createElement("nombre");
        name13.appendChild(document.createTextNode("twitter"));
        name.appendChild(name13);
        Element url13 = document.createElement("direccion");
        url13.appendChild(document.createTextNode("icon/twitter.png"));
        name.appendChild(url13);
        
        name = document.createElement("imagen");
        element.appendChild(name);
       name.setAttribute("id", "14");
       Element name14 = document.createElement("nombre");
        name14.appendChild(document.createTextNode("whatsapp"));
        name.appendChild(name14);
       Element url14 = document.createElement("direccion");
       url14.appendChild(document.createTextNode("icon/whatsapp.png"));
        name.appendChild(url14);
       
        name = document.createElement("imagen");
        element.appendChild(name);
        name.setAttribute("id", "15");
        Element name15 = document.createElement("nombre");
        name15.appendChild(document.createTextNode("youTube"));
        name.appendChild(name15);
        Element url15 = document.createElement("direccion");
        url15.appendChild(document.createTextNode("icon/youTube.png"));
        name.appendChild(url15);
    }
    
    /**
     *
     * @throws TransformerConfigurationException
     * @throws IOException
     * @throws TransformerException
     */
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
    
    /**
     *
     * @return
     * @throws Exception
     */
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
                    imagenes.setNombre((element.getElementsByTagName("nombre").item(0).getTextContent()).toString());
                    imagenes.setDireccion((element.getElementsByTagName("direccion").item(0).getTextContent()).toString());
                    listaImagenes.add(imagenes);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listaImagenes;
    }
}
