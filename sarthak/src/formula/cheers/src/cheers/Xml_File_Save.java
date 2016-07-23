package cheers;

import javax.xml.transform.stream.*;
import javax.xml.transform.dom.*;
import javax.xml.transform.*;
import javax.xml.parsers.*;
import org.w3c.dom.*;

import java.io.IOException;
import java.util.*;

/**
 * Xml_File_Save class contains the function saveFile which is used to save the value of radius and its corresponding calculated value of 
 * length to a XML file so that user can view it. 
 */
public class Xml_File_Save {
	
	/**
	 * This function is triggered by 'Save as XML' button in the GUI. It takes up the value of radius and its corresponding length and saves it to the existing XML file by appending it.  
	 */
    public static void saveFile(String radius, String length) throws Exception {

        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
        Document document = documentBuilder.parse("cheers.xml");							//XML file name
        Element root = document.getDocumentElement();

        Collection<setValues> setValues = new ArrayList<setValues>();
        setValues.add(new setValues());
for (setValues setValue : setValues) {
    Element Execution = document.createElement("Execution");            			// Element Name - Execution

    Element radiusValue = document.createElement("Radius");							//Child Name - Radius
    radiusValue.appendChild(document.createTextNode(radius));
    Execution.appendChild(radiusValue);

    Element lengthValue = document.createElement("Length");							//Child Name - Length
    lengthValue.appendChild(document.createTextNode(length));
    Execution.appendChild(lengthValue);

    root.appendChild(Execution);													//Append Element
}

DOMSource source = new DOMSource(document);

TransformerFactory transformerFactory = TransformerFactory.newInstance();
Transformer transformer = transformerFactory.newTransformer();
StreamResult result = new StreamResult("cheers.xml");		
transformer.transform(source, result);												//Add to existing XML File
System.out.println("XML File Updated!!!");											//Show Console message

    }		//end of saveFile

    
	/**
	 * This function initializes the value of radius and length which has to be added to the existing XML file. 
	 */
    public static class setValues {
        public String getRadius() { return ""; }
        public String getLength() { return ""; }
    }		//end of Values
    
}		//end of Xml_File_Save