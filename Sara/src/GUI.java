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

/**
 * @author sara basiri
 * <p>
 * This class is an interface between the user and the application. 
 */
public class GUI {
    
	private JFrame frame;  // the main application frame
	private JTextField input; // the text field to insert the value of radius. 
	private JTextField lengthOutput; //the text field that shows the result of length value. 
	private long timeElapsed;  //the variable that stores the value of time consumption
	private String result="*********Output*********\n";

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
		frame.setResizable(false);
		frame.getContentPane().setBackground(Color.LIGHT_GRAY);
		frame.setBounds(100, 100, 535, 393);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblRadious = new JLabel("Radius:");
		lblRadious.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblRadious.setBounds(10, 102, 61, 14);
		frame.getContentPane().add(lblRadious);
		
		input = new JTextField();
		input.setBounds(70, 90, 86, 42);
		frame.getContentPane().add(input);
		input.setColumns(10);
		
		/**
		 *This function first checks the boundaries of radius and if it was in the right boundaries
		 *calls the run() function from controller. 
		 *After running the program, it computes the time consumption. 
		 */
		JButton calculate = new JButton("Calculate");
		calculate.setBounds(154, 90, 95, 42);
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
			
				
				Runtime runtime = Runtime.getRuntime(); 
								
				double Radious=Double.parseDouble(input.getText());
				c.run(Radious);
				long freeMemoryAfter = runtime.freeMemory();
				
				lengthOutput.setText(Double.toString(c.getLength()));
				timeElapsed=System.nanoTime()-startTime; /* the difference between the current time of the system and the 
				                                                   time before running would be the time consumption of the program. */
				
				
				
				
				
								
				result+="Radius= "+input.getText()+"\nLength= "+lengthOutput.getText()+"\n\n\n";
				}
				}
				catch (NumberFormatException nfe){
					JOptionPane.showMessageDialog(frame,"ERROR : Invalid value entered. \nPlease enter radius between 1 and 30.","Invalid Input",JOptionPane.ERROR_MESSAGE);
					
				}
				
			}
				
		});
		frame.getContentPane().add(calculate);
		
		JLabel lblLength = new JLabel("Length: ");
		lblLength.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblLength.setBounds(259, 102, 68, 14);
		frame.getContentPane().add(lblLength);
		
		lengthOutput = new JTextField();
		lengthOutput.setEditable(false);
		lengthOutput.setBounds(338, 90, 171, 42);
		frame.getContentPane().add(lengthOutput);
		lengthOutput.setColumns(10);
		
		
		/**
		 * <p>
		 * The functionality of Save button is to save the values of Radius and Length in the output file 
		 * in a text format.
		 */
		
		JButton btnSave = new JButton("Save to Text File");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
								
				 try {
					    if(lengthOutput.getText().equals("")){
					    	JOptionPane.showMessageDialog(frame,"No Output Generated, Maybe you have not clicked on 'Calculate' button.","No Calculation Made",JOptionPane.ERROR_MESSAGE);
					    	
					    }
					    else{
					    	
			            String str = result;
			            File newTextFile = new File("Output.txt");
			            FileWriter fw = new FileWriter(newTextFile);
         
			            fw.write(str);
			            fw.close();
			            
			            JOptionPane.showMessageDialog(frame, "Your File Saved Successfully.","Success Message",JOptionPane.INFORMATION_MESSAGE);
					    }

			        } catch (IOException iox) {
			              iox.printStackTrace();
			              JOptionPane.showMessageDialog(frame,"ERROR : Unable to save the output to txt file. Please check file location.","Error While Saving",JOptionPane.ERROR_MESSAGE);
			        }
			    
			}
		});
		btnSave.setBounds(338, 186, 171, 42);
		frame.getContentPane().add(btnSave);
		
		JButton btnClose = new JButton("Close");
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
		btnClose.setBounds(338, 292, 171, 40);
		frame.getContentPane().add(btnClose);
		
		JButton btnView = new JButton("View Status ");
		btnView.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(frame,"Time= "+timeElapsed+"  Nanoseconds");
			}
		});
		btnView.setBounds(338, 239, 171, 42);
		frame.getContentPane().add(btnView);
		
		JLabel lblCheers = new JLabel("CHEERS");
		lblCheers.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblCheers.setBounds(10, 19, 86, 34);
		frame.getContentPane().add(lblCheers);
		
		/**
		 * by clicking this button, a description of the application would be provided for the user. 
		 */
		JButton button_description = new JButton("About");
		button_description.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(frame, "Imagine there are two circular coasters of equal area.The purpose is to find how \n"
														+ "     far the two costers need to be moved on top of each other such that the area of \n"
														+ "     the overlapping region is half the area of any of the coasters. The input should \n"
														+ "     be the redius of the circles and the output would be the length of the overlapping area.\n"
														+"\n\nimage ref. -\n http://users.encs.concordia.ca/~kamthan/courses/soen-6441/project_description.pdf");
			}
		});
		
		JPanel panel = new JPanel();
		panel.setBounds(70, 181, 179, 151);
		frame.getContentPane().add(panel);
		ImageIcon image = new ImageIcon("background.jpg");
		JLabel label1 = new JLabel("", image, JLabel.CENTER);
		panel.add(label1);
		
		button_description.setBounds(94, 27, 155, 23);
		frame.getContentPane().add(button_description);
		
		
		
		
	}
}
