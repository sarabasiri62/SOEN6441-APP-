package formula;

import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class Xml_file_save {

	public static void save(double radius, double length) {

	  try {

		DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder docBuilder = docFactory.newDocumentBuilder();

		// root elements
		Document doc = docBuilder.newDocument();
		Element rootElement = doc.createElement("Cheers Project");
		doc.appendChild(rootElement);

		// staff elements
		Element staff = doc.createElement("Radius");
		rootElement.appendChild(staff);

		// set attribute to staff element
		Attr attr = doc.createAttribute("Length");
		attr.setValue("1");
		staff.setAttributeNode(attr);

		// shorten way
		// staff.setAttribute("id", "1");

		// radius elements
		Element firstname = doc.createElement("Radius");
		String string_radius = Double.toString(radius);
		firstname.appendChild(doc.createTextNode(string_radius));
		staff.appendChild(firstname);

		// length elements
		Element lastname = doc.createElement("Length");
		String string_length = Double.toString(length);
		lastname.appendChild(doc.createTextNode(string_length));
		staff.appendChild(lastname);


		// write the content into xml file
		TransformerFactory transformerFactory = TransformerFactory.newInstance();
		Transformer transformer = transformerFactory.newTransformer();
		DOMSource source = new DOMSource(doc);
		StreamResult result = new StreamResult(new File("d:\\file.xml"));

		// Output to console for testing
		// StreamResult result = new StreamResult(System.out);

		transformer.transform(source, result);

		System.out.println("File saved!");

	  } catch (ParserConfigurationException pce) {
		pce.printStackTrace();
	  } catch (TransformerException tfe) {
		tfe.printStackTrace();
	  }
	}
}