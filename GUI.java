import javax.swing.JFrame;
import javax.swing.JScrollPane;
import java.awt.GridLayout;
import javax.swing.JRadioButton;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.*;
import javax.swing.border.*;

public class GUI 
{

	public JFrame frame;


	public GUI()
	{
		initialize();
	}

	private void initialize() 
	{
		frame = new JFrame();
		frame.setBounds(200, 200, 750, 468);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(16, 42, 195, 252);
		frame.getContentPane().add(scrollPane);
		
		JLabel lblTaskList = new JLabel("Task List");
		lblTaskList.setBounds(79, 14, 61, 16);
		frame.getContentPane().add(lblTaskList);
		
		JPanel panel = new JPanel(new GridLayout(2, 2));
		panel.setBounds(16, 306, 195, 122);
		frame.getContentPane().add(panel);
		
		JRadioButton rdbtnDescription = new JRadioButton("Description");
		rdbtnDescription.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
		rdbtnDescription.setBounds(57, 310, 111, 23);
		
		JRadioButton rdbtnPriority = new JRadioButton("Priority");
		rdbtnPriority.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
		rdbtnPriority.setBounds(57, 336, 141, 23);
		
		JRadioButton rdbtnDueDate = new JRadioButton("Due Date");
		rdbtnDueDate.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
		rdbtnDueDate.setBounds(57, 362, 141, 23);
		
		JRadioButton rdbtnStatus = new JRadioButton("Status");
		rdbtnStatus.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
		rdbtnStatus.setBounds(57, 387, 141, 23);
		
	    Border border = BorderFactory.createTitledBorder("Sort By");
	    panel.setBorder(border);
		ButtonGroup group = new ButtonGroup();
		group.add(rdbtnDescription);
		panel.add(rdbtnDescription);
		group.add(rdbtnPriority);
		panel.add(rdbtnPriority);
		group.add(rdbtnDueDate);
		panel.add(rdbtnDueDate);
		group.add(rdbtnStatus);
		panel.add(rdbtnStatus);
	}
}
