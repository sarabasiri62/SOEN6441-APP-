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

public class Cheers_Gui {

	private JFrame frame;
	private JTextField textField;
	public JLabel label_length_output = new JLabel("");	
	public static JButton button_save_xml = new JButton("Save as XML");
	long time_elapsed = 0;
	long startTime = 0;
	public static double Radius = 1;
	public static String string_length_result = null;
	public static String radius_input = null;
	
	/**
	 * Launch the application.
	 */
	public static void gui() 
	{
		EventQueue.invokeLater(new Runnable() 
		{
			public void run() 
			{
				try {
						Cheers_Gui window = new Cheers_Gui();
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
	 * Initialize the contents of the frame.
	 */
	private void initialize() 
	{
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		textField = new JTextField();					//radius_input text field
		textField.setBounds(44, 52, 96, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);

		
		JButton button_go = new JButton("Go");									//button_go
		button_go.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				radius_input = textField.getText();
				Radius = Double.parseDouble(radius_input);
				if (Radius<1||Radius>30)
				{
					java.awt.Toolkit.getDefaultToolkit().beep();
					JOptionPane.showMessageDialog(frame,"ERROR : Value of radius should be between 1 and 30","Inane error",JOptionPane.ERROR_MESSAGE);
					Radius=0;
					textField.setText("");
				}
				else if(Radius>=1&&Radius<=30)
				{
					double length_result= Solution.calculate_Length(Radius);
					string_length_result = String.valueOf(length_result);
					label_length_output.setText(string_length_result); 
				}
				else
				{
					JOptionPane.showMessageDialog(frame,"ERROR : Value of radius is invalid","Inane error",JOptionPane.ERROR_MESSAGE);
				}
				
			}
			
		});
		button_go.setBounds(150, 51, 89, 23);
		frame.getContentPane().add(button_go);
		
		
		JButton button_save_xml = new JButton("Save as XML");					//button_save_xml
		button_save_xml.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				try {
					Xml_File_Save.save(radius_input,string_length_result);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		button_save_xml.setBounds(56, 181, 109, 52);
		frame.getContentPane().add(button_save_xml);
		
		JLabel label_length = new JLabel("Length : ");							//label_length
		label_length.setFont(new Font("Tahoma", Font.BOLD, 11));
		label_length.setBounds(211, 104, 58, 14);
		frame.getContentPane().add(label_length);
		
		JButton button_exit = new JButton("Exit");								//button_exit
		button_exit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		button_exit.setBackground(Color.RED);
		button_exit.setBounds(319, 181, 89, 52);
		frame.getContentPane().add(button_exit);
		
		JLabel label_radius = new JLabel("Radius");								//label_radius
		label_radius.setFont(new Font("Tahoma", Font.BOLD, 13));
		label_radius.setBounds(44, 31, 53, 14);
		frame.getContentPane().add(label_radius);
		
		JButton button_clear = new JButton("Clear");							//button_clear
		button_clear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				label_length_output.setText(""); 
				textField.setText("");
				time_elapsed=0;
				startTime=0;
				
			}
		});
		button_clear.setBounds(253, 51, 89, 23);
		frame.getContentPane().add(button_clear);
		
																						//label_length_output
		label_length_output.setBounds(263, 104, 161, 14);
		frame.getContentPane().add(label_length_output);
		
		JButton button_view_stats = new JButton("View Stats");					//button_view_stats
		button_view_stats.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(frame, "Time taken to calculate : "+time_elapsed+ " Milliseconds");
			}
		});
		button_view_stats.setBounds(186, 208, 111, 23);
		frame.getContentPane().add(button_view_stats);
		

	}
}
