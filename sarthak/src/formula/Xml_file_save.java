package formula;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import java.io.File;
import java.util.Scanner;


public class Xml_file_save {
	
	   public static void save(double radius,double length) {
		   String string_radius = Double.toString(radius);
		   String string_length = Double.toString(length);
		   
	      try {
	         DocumentBuilderFactory dbFactory =
	         DocumentBuilderFactory.newInstance();
	         DocumentBuilder dBuilder = 
	            dbFactory.newDocumentBuilder();
	         Document doc = dBuilder.newDocument();
	         // root element
	         Element rootElement = doc.createElement("Cheers");
	         doc.appendChild(rootElement);

	         //  radius element
	         Element supercar = doc.createElement("Radius");
	         rootElement.appendChild(supercar);

	         // setting attribute to element
	         Attr attr = doc.createAttribute("Radius");
	         attr.setValue(string_radius);
	         supercar.setAttributeNode(attr);

	         // carname element
	         Element carname = doc.createElement("Length");
	         //Attr attrType = doc.createAttribute("Length");
	        // attrType.setValue(string_length);
	        // carname.setAttributeNode(attrType);
	         carname.appendChild(
	         doc.createTextNode(string_length));
	         supercar.appendChild(carname);    


	         // write the content into xml file
	         TransformerFactory transformerFactory =
	         TransformerFactory.newInstance();
	         Transformer transformer =
	         transformerFactory.newTransformer();
	         DOMSource source = new DOMSource(doc);
	         StreamResult result =
	         new StreamResult(new File("d:\\cheers.xml"));
	         transformer.transform(source, result);
	         // Output to console for testing
	         //StreamResult consoleResult =
	        // new StreamResult(System.out);
	        // transformer.transform(source, consoleResult);
	         System.out.println("XML File Saved");
	         System.out.println("Do you want to run again? (y or n)");
	         Scanner reader = new Scanner(System.in);
	         char c = reader.next().trim().charAt(0);
	         if (c=='y')
	        	 Main.main(null);
	         else
	        	 System.exit(0);
	         
	      } catch (Exception e) {
	         e.printStackTrace();
	      }
	   }
	}