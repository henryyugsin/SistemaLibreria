
package bimax3.pkg0;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;


public class validarAutorizacionSRI {
    public int validar(String xmlPath) throws ParserConfigurationException, FileNotFoundException, SAXException, IOException, XPathExpressionException{
        DocumentBuilderFactory dbf =   DocumentBuilderFactory.newInstance();
        dbf.setNamespaceAware(true);
        DocumentBuilder builder = dbf.newDocumentBuilder();
        File file = new File(xmlPath);
        Document doc = builder.parse(new FileInputStream(file));
        XPath xPath = XPathFactory.newInstance().newXPath();
        String expresionTranslados = "/factura";
        NodeList nodeListTranslados = (NodeList) xPath.compile(expresionTranslados).evaluate(doc, XPathConstants.NODESET);
        Element translado = (Element) nodeListTranslados.item(0);
        String mensaje = translado.getTextContent();
        String busco = "<RespuestaRecepcionComprobante><estado>RECIBIDA</estado>";
        int index = mensaje.indexOf(busco);
         return index;
    }
    public int autorizacion(String xmlPath) throws ParserConfigurationException, FileNotFoundException, SAXException, IOException, XPathExpressionException{
    DocumentBuilderFactory dbf =   DocumentBuilderFactory.newInstance();
        dbf.setNamespaceAware(true);
        DocumentBuilder builder = dbf.newDocumentBuilder();
        File file = new File(xmlPath);
        Document doc = builder.parse(new FileInputStream(file));
        XPath xPath = XPathFactory.newInstance().newXPath();
        String expresionTranslados = "/factura";
        NodeList nodeListTranslados = (NodeList) xPath.compile(expresionTranslados).evaluate(doc, XPathConstants.NODESET);
        Element translado = (Element) nodeListTranslados.item(0);
        String mensaje = translado.getTextContent();
        String busco = "<autorizacion><estado>AUTORIZADO</estado>";
        int index = mensaje.indexOf(busco);
        return index;
    }
    public int autorizacionespera(String xmlPath) throws ParserConfigurationException, FileNotFoundException, SAXException, IOException, XPathExpressionException{
    DocumentBuilderFactory dbf =   DocumentBuilderFactory.newInstance();
        dbf.setNamespaceAware(true);
        DocumentBuilder builder = dbf.newDocumentBuilder();
        File file = new File(xmlPath);
        Document doc = builder.parse(new FileInputStream(file));
        XPath xPath = XPathFactory.newInstance().newXPath();
        String expresionTranslados = "/factura";
        NodeList nodeListTranslados = (NodeList) xPath.compile(expresionTranslados).evaluate(doc, XPathConstants.NODESET);
        Element translado = (Element) nodeListTranslados.item(0);
        String mensaje = translado.getTextContent();
        String busco = "<autorizacion><estado>EN PROCESO</estado>";
        int index = mensaje.indexOf(busco);
        return index;
    }
}
