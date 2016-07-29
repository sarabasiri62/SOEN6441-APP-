package cheers;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import javax.swing.JPanel;

/**
 * Cheers_Gui class consists of all the GUI components which enable the user to input the value of radius and get the 
 * calculated value of length. The user also has option to save the output generated as XMl file and exit the GUI.
 */
public class Cheers_Gui {

	private static JFrame frame;
	private JTextField textField_radius_input;
	public JLabel label_length_output = new JLabel("");	
	public static JButton button_save_xml = new JButton("Save as XML");
	
	public static double Radius = 1;
	public static String string_length_result = null;
	public static String radius_input = null;
	public static long startTime;
	public static long computationTime;
	
/**
* This function creates a new GUi window and makes it visible to the user. 
*/
	public static void main(String args[])
	{
		EventQueue.invokeLater(new Runnable() 
		{
			public void run() 
			{
				try {
						Cheers_Gui window = new Cheers_Gui();									//Create new window
						window.frame.setVisible(true);
					} 
				catch (Exception e) 
					{
						e.printStackTrace();
					}
			}
		});
	}			// end of gui

/**
* Create the application.
*/
	public Cheers_Gui() 
	{
		initialize();
	}		//end of Cheers_Gui

/**
* This function initializes the components of the GUI eg. text field, labels, buttons and error dialog boxes. 
*/
	private void initialize() 
	{
		frame = new JFrame();
		frame.setBounds(100, 100, 485, 494);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		textField_radius_input = new JTextField();												//text field radius_input
		textField_radius_input.setBounds(61, 263, 161, 20);
		frame.getContentPane().add(textField_radius_input);
		textField_radius_input.setColumns(10);
/**
 *   The 'Calculate' button checks the legal boundaries for the value of radius (i.e it need to be valid integer between 1 and 30) and 
 *   if the value is accepted then it calls the function calculateLength in Solution class. 
 *   Once it gets the result, this button will show the value of result in label length_output.    
 */
		
		JButton button_calculate = new JButton("Calculate");									//button calculate
		button_calculate.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				
				  try {
						radius_input = textField_radius_input.getText();
						Radius = Double.parseDouble(radius_input);
						
						if ((Radius<1||Radius>30)||(radius_input==null))						//value not in range or null
						{
							java.awt.Toolkit.getDefaultToolkit().beep();
							JOptionPane.showMessageDialog(frame,"ERROR : Value of radius should be between 1 and 30.","Input Out of Range",JOptionPane.ERROR_MESSAGE);
							Radius=0;
							textField_radius_input.setText("");
						}
						else if(Radius>=1&&Radius<=30)											//accepted value of radius
						{
							computationTime=0;
							startTime=0;
							startTime = System.nanoTime();
							Controller controller =new Controller();
							controller.run(Radius);

							double length_result=controller.getLength(); 
							computationTime = System.nanoTime() - startTime;
							string_length_result = String.valueOf(length_result);
							label_length_output.setText(string_length_result); 
						}
					  }
				  
				  catch (NumberFormatException nfe) 											//Handle Number format exception
				  	{
					    System.out.println(nfe);
					    JOptionPane.showMessageDialog(frame,"ERROR : Invalid value entered. \nPlease enter radius between 1 and 30.","Invalid Input",JOptionPane.ERROR_MESSAGE);
					  }
				
			}
			
		});
		button_calculate.setBounds(232, 262, 89, 23);
		frame.getContentPane().add(button_calculate);
		
/**
* The 'Save to XML button' helps in saving the calculated result by calling the function saveFile in Xml_File_save class. 
*/
		JButton button_save_xml = new JButton("<html>Save to<br />XML File</html>");			//button save to xml file
		button_save_xml.addActionListener(new ActionListener()		
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				try {
					saveXML_File(radius_input,string_length_result);							//Save output to XML
					} 
				catch (Exception e)
				{
					java.awt.Toolkit.getDefaultToolkit().beep();
				    JOptionPane.showMessageDialog(frame,"ERROR : Unable to save the output to XML file. Please check file location.","Error While Saving",JOptionPane.ERROR_MESSAGE);
				    e.printStackTrace();
				}
			}
		});
		button_save_xml.setBounds(22, 380, 109, 52);
		frame.getContentPane().add(button_save_xml);
		
		JLabel label_length = new JLabel("Length : ");											//label_length
		label_length.setFont(new Font("Tahoma", Font.BOLD, 13));
		label_length.setBounds(61, 313, 65, 23);
		frame.getContentPane().add(label_length);
		
		JButton button_exit = new JButton("Exit");												//button_exit
		button_exit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		button_exit.setBounds(358, 380, 89, 52);
		frame.getContentPane().add(button_exit);
		
		JLabel lblRadius = new JLabel("Radius (cm):");											//label_radius
		lblRadius.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblRadius.setBounds(63, 238, 89, 14);
		frame.getContentPane().add(lblRadius);
		
		JButton button_clear = new JButton("Clear");											//button_clear
		button_clear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				label_length_output.setText(""); 												//Clear label_length_output and textField_radius_input
				textField_radius_input.setText("");
				computationTime=0;
				startTime=0;
			
			}
		});
		button_clear.setBounds(343, 262, 89, 23);
		frame.getContentPane().add(button_clear);
		label_length_output.setFont(new Font("Tahoma", Font.BOLD, 13));
						
		label_length_output.setBounds(136, 313, 217, 23);										//label_length_output
		frame.getContentPane().add(label_length_output);
		
		JPanel image_panel = new JPanel();														//image_panel
		image_panel.setBounds(136, 61, 214, 151);
		frame.getContentPane().add(image_panel);
		ImageIcon image = new ImageIcon("cheers_img.jpeg");
		JLabel label1 = new JLabel("", image, JLabel.CENTER);
		image_panel.add(label1);
		
		
		JButton button_about = new JButton("About");											//button_description
		button_about.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(frame, "Suppose there are two circular beverage coasters of equal area. "
												+ "\nThe purpose is to find how far the two coasters need to be moved on top of each other,"
												+ "\nsuch that the area of the overlapping region is half the area of any of the coasters."
												+ "\nThe input should be the radius of the circles and the output would be the distance at which "
												+ "\ncoasters must be placed in order to meet the condition."
												+"\n\nImage ref. -\nhttp://users.encs.concordia.ca/~kamthan/courses/soen-6441/project_description.pdf");
			}
		});
		button_about.setBounds(246, 380, 102, 52);
		frame.getContentPane().add(button_about);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(45, 223, 393, 132);
		frame.getContentPane().add(panel_1);
		
		JLabel label_cheers = new JLabel("<html><u>CHEERS</u></html>");												//label_cheers
		label_cheers.setFont(new Font("Tahoma", Font.BOLD, 18));
		label_cheers.setBounds(207, 22, 77, 39);
		frame.getContentPane().add(label_cheers);
		
		JButton button_view_time_consumed = new JButton("<html>View Time <br />Consumed</html>\n");	//button_view_time_consumed
		button_view_time_consumed.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(frame, "Time taken for Computation : "+computationTime+" nanosecond");
			}

		});
		button_view_time_consumed.setBounds(141, 380, 95, 52);
		frame.getContentPane().add(button_view_time_consumed);
						
	}		//end of initialize
	
	
/**
* This function is triggered by 'Save as XML' button in the GUI. It takes up the value of radius and its corresponding length and saves it to the existing XML file by appending it.  
*/
    public static void saveXML_File(String radius, String length) throws Exception 
    {
        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
        Document document = documentBuilder.parse("cheers.xml");						
        Element root = document.getDocumentElement();

        		Element Execution = document.createElement("execution");            			// Element name - execution
        	
        		Element radiusValue = document.createElement("radius");							//Child name - radius
        		radiusValue.appendChild(document.createTextNode(radius));
        		Execution.appendChild(radiusValue);
        	
        		Element lengthValue = document.createElement("length");							//Child name - length
        		lengthValue.appendChild(document.createTextNode(length));
        		Execution.appendChild(lengthValue);

        		root.appendChild(Execution);													//Append child

        DOMSource source = new DOMSource(document);
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        StreamResult result = new StreamResult("cheers.xml");		
        transformer.transform(source, result);													//Add to existing XML file
        JOptionPane.showMessageDialog(frame, "XML file updated sucessfully.");					

    }																							//end of saveXML_File
    
}																								//end of Cheers_Gui
