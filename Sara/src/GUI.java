import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font; 
import java.io.*;
import java.text.NumberFormat;
import java.awt.SystemColor;

/**
 * @author sara basiri
 * <p>
 * This class is an interface between the user and the application. 
 */
public class GUI {
    
	private JFrame frame;  // the main application frame
	private JTextField input; // the text field to insert the value of radius. 
	private long timeElapsed;  //the variable that stores the value of time consumption
	private String result="*********Output*********\n";
	private JLabel lblResult = new JLabel("New label");

	/**
	 * Launch the application.
	 */
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI window = new GUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * @throws IOException 
	 */
	public GUI() throws IOException {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * @throws IOException 
	 */
	private void initialize() throws IOException {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.black);
		
		frame.setForeground(SystemColor.desktop);
		frame.setBackground(SystemColor.desktop);
		frame.setResizable(false);
		frame.getContentPane().setBackground(SystemColor.control);
		frame.setBounds(100, 100, 582, 505);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblRadious = new JLabel("Radius (cm) :");
		lblRadious.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblRadious.setBounds(34, 261, 95, 14);
		frame.getContentPane().add(lblRadious);
		
		input = new JTextField();
		input.setBounds(34, 286, 232, 26);
		frame.getContentPane().add(input);
		input.setColumns(10);
		
		/**
		 *This function first checks the boundaries of radius and if it was in the right boundaries
		 *calls the run() function from controller. 
		 *After running the program, it computes the time consumption. 
		 */
		JButton calculate = new JButton("Calculate");
		calculate.setFont(new Font("Tahoma", Font.BOLD, 12));
		calculate.setBounds(300, 283, 125, 30);
		calculate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
				Controller c=new Controller();
				if(input.getText().equals("")){
					JOptionPane.showMessageDialog(frame,"ERROR : Value of radius should be between 1 and 30.","Input Out of Range",JOptionPane.ERROR_MESSAGE);
					
				
				}
				else if(Double.parseDouble(input.getText())<1){
					JOptionPane.showMessageDialog(frame,"ERROR : Value of radius should be between 1 and 30.","Input Out of Range",JOptionPane.ERROR_MESSAGE);
					
					
				}
				else if(Double.parseDouble(input.getText())>30){
					JOptionPane.showMessageDialog(frame,"ERROR : Value of radius should be between 1 and 30.","Input Out of Range",JOptionPane.ERROR_MESSAGE);
					
				}
				
											
				else{
					
					
				long startTime=System.nanoTime(); // time of the system before running the program. 
			
				
												
				double Radious=Double.parseDouble(input.getText());
				c.run(Radious);
				
				lblResult.setBounds(113, 349, 151, 14);
				frame.getContentPane().add(lblResult);
				lblResult.setText(Double.toString(c.getLength()));
								
				//lengthOutput.setText(Double.toString(c.getLength()));
				timeElapsed=System.nanoTime()-startTime; /* the difference between the current time of the system and the 
				                                                   time before running would be the time consumption of the program. */
				
				
				
				
				
								
				result+="Radius= "+input.getText()+"\nLength= "+lblResult.getText()+"\n\n\n";
				}
				}
				catch (NumberFormatException nfe){
					JOptionPane.showMessageDialog(frame,"ERROR : Invalid value entered. \nPlease enter radius between 1 and 30.","Invalid Input",JOptionPane.ERROR_MESSAGE);
					
				}
				
			}
				
		});
		frame.getContentPane().add(calculate);
		
		JLabel lblresult = new JLabel("Length: ");
		lblresult.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblresult.setBounds(35, 347, 68, 14);
		frame.getContentPane().add(lblresult);
		
		
		/**
		 * <p>
		 * The functionality of Save button is to save the values of Radius and Length in the output file 
		 * in a text format.
		 */
		
		JButton btnSave = new JButton("<html>Save to <br> Text File</html>");
		btnSave.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
								
				 try {
					    if(lblResult.getText().equals("")){
					    	JOptionPane.showMessageDialog(frame,"No Output Generated, Maybe you have not clicked on 'Calculate' button.","No Calculation Made",JOptionPane.ERROR_MESSAGE);
					    	
					    }
					    else{
					    	
			            String str = result;
			            File newTextFile = new File("resources/Output.txt");
			            FileWriter fw = new FileWriter(newTextFile);
         
			            fw.write(str);
			            fw.close();
			            
			            JOptionPane.showMessageDialog(frame, "Text file updated sucessfully.");
					    }

			        } catch (IOException iox) {
			              iox.printStackTrace();
			              JOptionPane.showMessageDialog(frame,"ERROR : Unable to save the output to txt file. Please check file location.","Error While Saving",JOptionPane.ERROR_MESSAGE);
			        }
			    
			}
		});
		btnSave.setBounds(34, 405, 125, 59);
		frame.getContentPane().add(btnSave);
		
		JButton btnClose = new JButton("Exit");
		btnClose.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
		btnClose.setBounds(445, 405, 110, 60);
		frame.getContentPane().add(btnClose);
		
		JButton btnView = new JButton("<html>View Time <br> \r\n Consumed\r\n</html>");
		btnView.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnView.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(frame,"Time taken for computation : "+timeElapsed+"  Nanoseconds");
			}
		});
		btnView.setBounds(169, 404, 138, 60);
		frame.getContentPane().add(btnView);
		
		JLabel lblCheers = new JLabel("CHEERS");
		lblCheers.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblCheers.setBounds(241, 25, 86, 34);
		frame.getContentPane().add(lblCheers);
		
		/**
		 * by clicking this button, a description of the application would be provided for the user. 
		 */
		JButton button_description = new JButton("About");
		button_description.setFont(new Font("Tahoma", Font.BOLD, 13));
		button_description.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(frame, "Suppose there are two circular beverage coasters of equal area. "
						+ "\nThe purpose is to find how far the two coasters need to be moved on top of each other,"
						+ "\nsuch that the area of the overlapping region is half the area of any of the coasters."
						+ "\nThe input should be the radius of the circles and the output would be the distance at which "
						+ "\ncoasters must be placed in order to meet the condition."
						+"\n\nImage ref. -\nhttp://users.encs.concordia.ca/~kamthan/courses/soen-6441/project_description.pdf");
			}
		});
		
		JPanel panel = new JPanel();
		panel.setBounds(191, 79, 179, 151);
		frame.getContentPane().add(panel);
		ImageIcon image = new ImageIcon("resources/background.jpg");
		JLabel label1 = new JLabel("", image, JLabel.CENTER);
		panel.add(label1);
		
		button_description.setBounds(317, 404, 118, 60);
		frame.getContentPane().add(button_description);
		
		JButton btnClear = new JButton("Clear");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				input.setText(null);
			}
		});
		btnClear.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnClear.setBounds(437, 283, 118, 30);
		frame.getContentPane().add(btnClear);
		
		
		
		
		
		
		
		
		
	}
}
