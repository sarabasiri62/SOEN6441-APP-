import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font; 
import java.io.*;
import java.text.NumberFormat;

public class GUI {
    
	private JFrame frame;
	private JTextField input;
	private JTextField lengthOutput;
	private long timeElapsed;
	private long allocatedMemory;
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
		
		JButton Compute = new JButton("Calculate");
		Compute.setBounds(154, 90, 95, 42);
		Compute.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
				Controller c=new Controller();
				if(input.getText().equals("")){
					JOptionPane.showMessageDialog(frame,"Please Enter a Value for Radius","Inane error",JOptionPane.ERROR_MESSAGE);
				
				}
				else if(Double.parseDouble(input.getText())<1){
					JOptionPane.showMessageDialog(frame,"Please Enter a Number Greater than/ Equal to 1 for Radius","Inane error",JOptionPane.ERROR_MESSAGE);
					
					
				}
				else if(Double.parseDouble(input.getText())>30){
					JOptionPane.showMessageDialog(frame,"Your Input Number is Out of Range","Inane error",JOptionPane.ERROR_MESSAGE);
					
				}
				
											
				else{
				long startTime=System.currentTimeMillis();
				Runtime runtime = Runtime.getRuntime();

				NumberFormat format = NumberFormat.getInstance();

				StringBuilder sb = new StringBuilder();
				

				
				double Radious=Double.parseDouble(input.getText());
				c.run(Radious);
				
				lengthOutput.setText(Double.toString(c.getLength()));
				timeElapsed=System.currentTimeMillis()-startTime;
				
				long maxMemory = runtime.maxMemory();
				allocatedMemory = runtime.totalMemory();
				long freeMemory = runtime.freeMemory();
				
				sb.append("free memory: " + format.format(freeMemory / 1024) + "<br/>");
				sb.append("allocated memory: " + format.format(allocatedMemory / 1024) + "<br/>");
				sb.append("max memory: " + format.format(maxMemory / 1024) + "<br/>");
				sb.append("total free memory: " + format.format((freeMemory + (maxMemory - allocatedMemory)) / 1024) + "<br/>");
				
				
				
				
				
				result+="Radius= "+input.getText()+"\nLength= "+lengthOutput.getText()+"\n\n\n";
				}
				}
				catch (NumberFormatException nfe){
					    JOptionPane.showMessageDialog(frame,"ERROR : Value of radius is invalid. \nPlease enter an interger between 1 and 30.","Invalid Input",JOptionPane.ERROR_MESSAGE);
					
				}
				
			}
				
		});
		frame.getContentPane().add(Compute);
		
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
		
		JButton btnSave = new JButton("Save as Text File");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
								
				 try {
					    if(lengthOutput.getText().equals("")){
					    	JOptionPane.showMessageDialog(frame,"No Output Generated, Maybe you have not clicked on 'Calculate' button","Inane error",JOptionPane.ERROR_MESSAGE);
					    	
					    }
					    else{
					    	
			            String str = result;
			            File newTextFile = new File("Output.txt");
			            FileWriter fw = new FileWriter(newTextFile);
         
			            fw.write(str);
			            fw.close();
			            
			            JOptionPane.showMessageDialog(frame, "Your File Saved Successfully","Success Message",JOptionPane.INFORMATION_MESSAGE);
					    }

			        } catch (IOException iox) {
			              iox.printStackTrace();
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
				JOptionPane.showMessageDialog(frame,"Time= "+timeElapsed+" Miliseconds\n"+"Memory= "+allocatedMemory/1024);
			}
		});
		btnView.setBounds(338, 239, 171, 42);
		frame.getContentPane().add(btnView);
		
		JLabel lblCheers = new JLabel("CHEERS");
		lblCheers.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblCheers.setBounds(24, 11, 86, 34);
		frame.getContentPane().add(lblCheers);
		
		JButton button_description = new JButton("Description");
		button_description.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(frame, "Imagine there are two circular coasters of equal area.The purpose is to find how \n"
														+ "far the two costers need to be moved on top of each other such that the area of \n"
														+ "the overlapping region is half the area of any of the coasters. The input should \n"
														+ "be the redius of the circles and the output would be the length of the overlapping area.\n");
			}
		});
		button_description.setBounds(120, 19, 89, 23);
		frame.getContentPane().add(button_description);
		
		
		
		
	}
}
