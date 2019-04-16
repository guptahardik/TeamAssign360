import javax.swing.*;
import javax.swing.border.*;
import java.text.*;
import java.awt.*;

public class GUI 
{

	public JFrame frame;
	private JTextField descriptionUpdateTextField;
	private JTextField dueDateTextField;
	private JTextField monthUpdateTextField;
	private JTextField dayUpdateTextField;
	private JTextField newDescriptionTextBox;
	private JTextField newMonthTextField;
	private JTextField newDayTextField;


	public GUI()
	{
		initialize();
	}

	private void initialize() 
	{
		//Create JFrame
		frame = new JFrame();
		frame.setBounds(200, 200, 950, 468);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		//First section of GUI Beginning
		//Create Scrollable List
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(16, 42, 331, 252);
		frame.getContentPane().add(scrollPane);
		
		//List Label
		JLabel lblTaskList = new JLabel("Task List");
		lblTaskList.setBounds(144, 14, 61, 16);
		frame.getContentPane().add(lblTaskList);
		
		//Create panel for sort radio buttons
		JPanel sortByPanel = new JPanel(new GridLayout(2, 2));
		sortByPanel.setBounds(16, 306, 331, 122);
		frame.getContentPane().add(sortByPanel);
		
		//Add radio buttons
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
		
		//Create Radio Button Border
	    Border sortByPanelBorder = BorderFactory.createTitledBorder("Sort By");
	    sortByPanel.setBorder(sortByPanelBorder);
		ButtonGroup group = new ButtonGroup();
		group.add(rdbtnDescription);
		sortByPanel.add(rdbtnDescription);
		group.add(rdbtnPriority);
		sortByPanel.add(rdbtnPriority);
		group.add(rdbtnDueDate);
		sortByPanel.add(rdbtnDueDate);
		group.add(rdbtnStatus);
		sortByPanel.add(rdbtnStatus);
		
		//Middle Section of the GUI Beginning
		//Create text fields
		descriptionUpdateTextField = new JTextField();
		descriptionUpdateTextField.setBounds(451, 42, 203, 77);
		frame.getContentPane().add(descriptionUpdateTextField);
		descriptionUpdateTextField.setColumns(10);
		
		//Create Labels
		JLabel lblDescription = new JLabel("Description:");
		lblDescription.setBounds(375, 72, 77, 16);
		frame.getContentPane().add(lblDescription);
		
		JLabel lblDueDate = new JLabel("Due Date:");
		lblDueDate.setBounds(422, 148, 62, 16);
		frame.getContentPane().add(lblDueDate);
		
		JLabel lblMonth = new JLabel("Month");
		lblMonth.setBounds(493, 125, 40, 16);
		frame.getContentPane().add(lblMonth);
		
		JLabel lblDay = new JLabel("Day");
		lblDay.setBounds(552, 125, 24, 16);
		frame.getContentPane().add(lblDay);
		
		//Create Month and Day textfields
		monthUpdateTextField = new JTextField();
		monthUpdateTextField.setBounds(496, 143, 40, 26);
		frame.getContentPane().add(monthUpdateTextField);
		monthUpdateTextField.setColumns(10);
		
		dayUpdateTextField = new JTextField();
		dayUpdateTextField.setColumns(10);
		dayUpdateTextField.setBounds(545, 143, 40, 26);
		frame.getContentPane().add(dayUpdateTextField);
		
		//Priority Label
		JLabel lblNewLabel = new JLabel("Priority:");
		lblNewLabel.setBounds(435, 190, 49, 16);
		frame.getContentPane().add(lblNewLabel);
		
		//Priority Combo Box
		JComboBox priorityUpdateComboBox = new JComboBox();
		
		//Input number of descriptions using for loop below for combo box options
		//comboBox.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12"}));
		priorityUpdateComboBox.setBounds(483, 186, 102, 27);
		frame.getContentPane().add(priorityUpdateComboBox);
		
		//Create Buttons
		JButton btnUpdateTask = new JButton("Update Task");
		btnUpdateTask.setBounds(483, 271, 123, 29);
		frame.getContentPane().add(btnUpdateTask);
		
		JButton btnCompleteTask = new JButton("Complete Task");
		btnCompleteTask.setBounds(483, 312, 123, 29);
		frame.getContentPane().add(btnCompleteTask);
		
		JButton btnDeleteTask = new JButton("Delete Task");
		btnDeleteTask.setBounds(483, 353, 123, 29);
		frame.getContentPane().add(btnDeleteTask);
		
		//Create Status Label
		JLabel lblStatus = new JLabel("Status:");
		lblStatus.setBounds(440, 228, 49, 16);
		frame.getContentPane().add(lblStatus);
		
		//Create Status ComboBox with three options
		JComboBox statusComboBox = new JComboBox();
		statusComboBox.setModel(new DefaultComboBoxModel(new String[] {"SELECT STATUS", "Not Started", "In Progress", "Finished"}));
		statusComboBox.setBounds(483, 224, 155, 27);
		frame.getContentPane().add(statusComboBox);

		//Right Section of the GUI Beginning
		//New Description TextBox
		newDescriptionTextBox = new JTextField();
		newDescriptionTextBox.setColumns(10);
		newDescriptionTextBox.setBounds(754, 42, 155, 77);
		frame.getContentPane().add(newDescriptionTextBox);
		
		//Labels
		JLabel lblDescriptionNew = new JLabel("Description:");
		lblDescriptionNew.setBounds(678, 72, 77, 16);
		frame.getContentPane().add(lblDescriptionNew);
		
		JLabel lblNewMonth = new JLabel("Month");
		lblNewMonth.setBounds(766, 125, 40, 16);
		frame.getContentPane().add(lblNewMonth);
		
		JLabel lblNewDueDate = new JLabel("Due Date:");
		lblNewDueDate.setBounds(695, 148, 62, 16);
		frame.getContentPane().add(lblNewDueDate);
		
		//New Month TextBox
		newMonthTextField = new JTextField();
		newMonthTextField.setColumns(10);
		newMonthTextField.setBounds(769, 143, 40, 26);
		frame.getContentPane().add(newMonthTextField);
		
		//New Day TextBox
		newDayTextField = new JTextField();
		newDayTextField.setColumns(10);
		newDayTextField.setBounds(818, 143, 40, 26);
		frame.getContentPane().add(newDayTextField);
		
		//New Day Label
		JLabel lblNewDay = new JLabel("Day");
		lblNewDay.setBounds(825, 125, 24, 16);
		frame.getContentPane().add(lblNewDay);
		
		//New Priority ComboBox
		JComboBox newPriorityComboBox = new JComboBox();
		newPriorityComboBox.setBounds(756, 190, 102, 27);
		newPriorityComboBox.setModel(new DefaultComboBoxModel(new String[] {"1"}));
		frame.getContentPane().add(newPriorityComboBox);
		
		//Add Labels
		JLabel lblNewPriority = new JLabel("Priority:");
		lblNewPriority.setBounds(708, 194, 49, 16);
		frame.getContentPane().add(lblNewPriority);
		
		JLabel lblNewStatus = new JLabel("Status:");
		lblNewStatus.setBounds(713, 232, 49, 16);
		frame.getContentPane().add(lblNewStatus);
		
		//New Status ComboBox 
		JComboBox newStatusTextBox = new JComboBox();
		newStatusTextBox.setBounds(754, 228, 155, 27);
		newStatusTextBox.setModel(new DefaultComboBoxModel(new String[] {"Not Started", "In Progress", "Finished"}));
		frame.getContentPane().add(newStatusTextBox);
		
		//Add Buttons
		JButton btnAddTask = new JButton("Add Task");
		btnAddTask.setBounds(754, 271, 123, 29);
		frame.getContentPane().add(btnAddTask);
		
		JButton btnSaveTask = new JButton("Save Task");
		btnSaveTask.setBounds(754, 312, 123, 29);
		frame.getContentPane().add(btnSaveTask);
		
		JButton btnPrintToFile = new JButton("Print To File");
		btnPrintToFile.setBounds(754, 353, 123, 29);
		frame.getContentPane().add(btnPrintToFile);
		
		JLabel lblViewAndUpdate = new JLabel("View and Update");
		lblViewAndUpdate.setBounds(493, 14, 109, 16);
		frame.getContentPane().add(lblViewAndUpdate);
		
		JLabel lblAddNewTask = new JLabel("Add New Task");
		lblAddNewTask.setBounds(779, 14, 90, 16);
		frame.getContentPane().add(lblAddNewTask);

	}
}