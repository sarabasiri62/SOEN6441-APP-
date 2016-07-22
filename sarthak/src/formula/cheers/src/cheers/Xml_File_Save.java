package cheers;

import java.util.*;
import javax.xml.transform.*;
import javax.xml.transform.stream.*;
import javax.xml.transform.dom.*;
import org.w3c.dom.*;
import javax.xml.parsers.*;

public class Xml_File_Save {
    public static void save(String radius, String length) throws Exception {

        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
        Document document = documentBuilder.parse("d:/cheers.xml");
        Element root = document.getDocumentElement();

        Collection<Values> servers = new ArrayList<Values>();
        servers.add(new Values());

        for (Values server : servers) {
            // server elements
            Element newServer = document.createElement("Execution");

            Element name = document.createElement("Radius");
            name.appendChild(document.createTextNode(radius));
            newServer.appendChild(name);

            Element port = document.createElement("Length");
            port.appendChild(document.createTextNode(length));
            newServer.appendChild(port);

            root.appendChild(newServer);
        }

        DOMSource source = new DOMSource(document);

        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        StreamResult result = new StreamResult("d:/cheers.xml");
        transformer.transform(source, result);
        System.out.println("XML Saved!!!");
    }

    public static class Values {
        public String getRadius() { return ""; }
        public String getLength() { return ""; }
    }
}