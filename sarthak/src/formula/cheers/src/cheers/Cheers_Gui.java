package cheers;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;

/**
 * Cheers_Gui class consists of all the GUI components which enable the user to input the value of radius and get the 
 * calculated value of length. The user also has option to save the output generated as XMl file and exit the GUI.
 */
public class Cheers_Gui {

	private JFrame frame;
	private JTextField textField_radius_input;
	public JLabel label_length_output = new JLabel("");	
	public static JButton button_save_xml = new JButton("Save as XML");
	
	public static double Radius = 1;
	public static String string_length_result = null;
	public static String radius_input = null;
	
	/**
	 * This function creates a new GUi window and makes it visible to the user. 
	 */
	public static void gui() 
	{
		EventQueue.invokeLater(new Runnable() 
		{
			public void run() 
			{
				try {
						Cheers_Gui window = new Cheers_Gui();							//Create new window
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
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		textField_radius_input = new JTextField();										//radius_input text field
		textField_radius_input.setBounds(44, 52, 96, 20);
		frame.getContentPane().add(textField_radius_input);
		textField_radius_input.setColumns(10);
/**
 *   The 'Calculate' button checks the legal boundaries for the value of radius (i.e it need to be valid integer between 1 and 30) and 
 *   if the value is accepted then it calls the function calculateLength in Solution class. 
 *   Once it gets the result, this button will show the value of result in label length_output.    
 */
		
		JButton button_go = new JButton("Calculate");									//button_go
		button_go.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				
				  try {
						radius_input = textField_radius_input.getText();
						Radius = Double.parseDouble(radius_input);
						
						if ((Radius<1||Radius>30)||(radius_input==null))				//Check if input is in range and not null
						{
							java.awt.Toolkit.getDefaultToolkit().beep();
							JOptionPane.showMessageDialog(frame,"ERROR : Value of radius should be between 1 and 30.","Input Out of Range",JOptionPane.ERROR_MESSAGE);
							Radius=0;
							textField_radius_input.setText("");
						}
						else if(Radius>=1&&Radius<=30)									//If radius value accepted
						{
							double length_result= Solution.calculate_Length(Radius);
							string_length_result = String.valueOf(length_result);
							label_length_output.setText(string_length_result); 
						}
					  }
				  
				  catch (NumberFormatException nfe) 									//Handle NumberFormatException
				  	{
					    System.out.println(nfe);
					    JOptionPane.showMessageDialog(frame,"ERROR : Value of radius is invalid. \nPlease enter an interger between 1 and 30.","Invalid Input",JOptionPane.ERROR_MESSAGE);
					  }
				
			}
			
		});
		button_go.setBounds(150, 51, 89, 23);
		frame.getContentPane().add(button_go);
		
		/**
		 * The 'Save to XML button' helps in saving the calculated result by calling the function saveFile in Xml_File_save class. 
		 */
		JButton button_save_xml = new JButton("Save as XML");							//button_save_xml
		button_save_xml.addActionListener(new ActionListener()		
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				try {
					Xml_File_Save.saveFile(radius_input,string_length_result);			//Save output as XML
				} catch (Exception e) {
					java.awt.Toolkit.getDefaultToolkit().beep();
				    JOptionPane.showMessageDialog(frame,"ERROR : Unable to save the output as XML. Please check save location or file.","Error in Saving",JOptionPane.ERROR_MESSAGE);
					e.printStackTrace();
				}
			}
		});
		button_save_xml.setBounds(56, 181, 109, 52);
		frame.getContentPane().add(button_save_xml);
		
		JLabel label_length = new JLabel("Length : ");									//label_length
		label_length.setFont(new Font("Tahoma", Font.BOLD, 11));
		label_length.setBounds(211, 104, 58, 14);
		frame.getContentPane().add(label_length);
		
		JButton button_exit = new JButton("Exit");										//button_exit
		button_exit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		button_exit.setBounds(319, 181, 89, 52);
		frame.getContentPane().add(button_exit);
		
		JLabel label_radius = new JLabel("Radius");										//label_radius
		label_radius.setFont(new Font("Tahoma", Font.BOLD, 13));
		label_radius.setBounds(44, 31, 53, 14);
		frame.getContentPane().add(label_radius);
		
		JButton button_clear = new JButton("Clear");									//button_clear
		button_clear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				label_length_output.setText(""); 										//Clear label_length_output and textField_radius_input
				textField_radius_input.setText("");
			
			}
		});
		button_clear.setBounds(253, 51, 89, 23);
		frame.getContentPane().add(button_clear);
		
																						//label_length_output
		label_length_output.setBounds(263, 104, 161, 14);
		frame.getContentPane().add(label_length_output);
		
	}		//end of initialize
	
}		//end of Cheers_Gui
