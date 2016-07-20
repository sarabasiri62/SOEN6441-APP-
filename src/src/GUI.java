import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font; 
import java.io.*;

public class GUI {

	private JFrame frame;
	private JTextField input;
	private JTextField Length_Output;
	private JTextField Alpha_Output;

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
	 */
	public GUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.getContentPane().setBackground(Color.LIGHT_GRAY);
		frame.setBounds(100, 100, 525, 310);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblRadious = new JLabel("Radius:");
		lblRadious.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblRadious.setBounds(22, 70, 61, 14);
		frame.getContentPane().add(lblRadious);
		
		input = new JTextField();
		input.setBounds(93, 58, 86, 42);
		frame.getContentPane().add(input);
		input.setColumns(10);
		
		JButton Compute = new JButton("Go");
		Compute.setBounds(175, 58, 61, 42);
		Compute.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Controller c=new Controller();
				if(input.getText().equals("")){
					JOptionPane.showMessageDialog(null, "Please Enter a Value for Radius");
				}
				else if(Integer.parseInt(input.getText())<1){
					
					JOptionPane.showMessageDialog(null, "Please Enter a Number Greater than/ Equal to 1 for Radius");
				}
				else if(Integer.parseInt(input.getText())>30){
					JOptionPane.showMessageDialog(null, "You Input Number is Out of Range");
				}
				else{
				double Radious=Double.parseDouble(input.getText());
				c.Run(Radious);
				Alpha_Output.setText(Double.toString(c.getAlpha()));
				Length_Output.setText(Double.toString(c.getLength()));
				}
				
				
			}
				
		});
		frame.getContentPane().add(Compute);
		
		JLabel lblLength = new JLabel("Length: ");
		lblLength.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblLength.setBounds(260, 39, 68, 14);
		frame.getContentPane().add(lblLength);
		
		Length_Output = new JTextField();
		Length_Output.setEditable(false);
		Length_Output.setBounds(338, 27, 171, 42);
		frame.getContentPane().add(Length_Output);
		Length_Output.setColumns(10);
		
		JLabel lblAlpha = new JLabel("Alpha:");
		lblAlpha.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblAlpha.setBounds(260, 109, 46, 14);
		frame.getContentPane().add(lblAlpha);
		
		Alpha_Output = new JTextField();
		Alpha_Output.setBounds(338, 97, 171, 42);
		Alpha_Output.setEditable(false);
		frame.getContentPane().add(Alpha_Output);
		Alpha_Output.setColumns(10);
		
		
		/*
		 * The functionality of Save button is to save the values of Length and Alpha in an output file 
		 * in a text format.
		 */
		
		JButton btnSave = new JButton("Save as Text File");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
								
				 try {
					    if(Alpha_Output.getText().equals("")|| Length_Output.getText().equals("")){
					    	JOptionPane.showMessageDialog(null, "No Output Generated, Maybe you have not clicked on 'Go' button ");
					    }
			            String str = "Alpha is:   "+ Alpha_Output.getText()+"\n"+"Length is:  "+Length_Output.getText();
			            File newTextFile = new File("Output.txt");

			            FileWriter fw = new FileWriter(newTextFile);
			            fw.write(str);
			            fw.close();
			            JOptionPane.showMessageDialog(null, "Your File Saved Successfully");

			        } catch (IOException iox) {
			              iox.printStackTrace();
			        }
			    
			}
		});
		btnSave.setBounds(338, 169, 128, 42);
		frame.getContentPane().add(btnSave);
		
		JButton btnClose = new JButton("Close");
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
		btnClose.setBounds(338, 222, 128, 40);
		frame.getContentPane().add(btnClose);
		
		
	}

}
