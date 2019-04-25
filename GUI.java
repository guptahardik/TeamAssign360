package main;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import java.text.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;

public class GUI extends JFrame implements ActionListener, ListSelectionListener
{

	public JFrame frame;
	private JScrollPane scrollPane;
	private JPanel panel;
	private JTextField descriptionUpdateTextField;
	private JTextField dueDateTextField;
	private JTextField monthUpdateTextField;
	private JTextField dayUpdateTextField;
	private JTextField newDescriptionTextBox;
	private JTextField newMonthTextField;
	private JTextField newDayTextField;
	private JComboBox priorityUpdateComboBox;
	private JComboBox statusComboBox;
	private JButton btnUpdateTask;
	private JButton btnCompleteTask;
	private JButton btnDeleteTask;
	private JButton btnAddTask;
	private JButton btnSaveTask;
	private JButton btnPrintToFile;
	private JTextField viewAndUpdatePriorityTextBox;
	private JTextField newPriorityTextBox;
	private GUIEventHandler buttonHandler;
	private DefaultListModel<String> listModel;
	private JList<String> list;

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
		frame.setTitle("To Do List");
		
		buttonHandler = new GUIEventHandler();
		
		

		panel = new JPanel();
		panel.setSize(330, 250);
		panel.setLayout(new GridLayout(20, 1));
		
		//First section of GUI Beginning
		//Create Scrollable List and Jlist
		listModel = new DefaultListModel<String>();
		list = new JList<String>(listModel);
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		list.setSelectedIndex(0);
		list.addListSelectionListener(this);
		list.setVisibleRowCount(5);
		scrollPane = new JScrollPane(list);
		
		scrollPane.setBounds(16, 42, 331, 252);
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
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
		rdbtnDescription.addActionListener(this);
		
		JRadioButton rdbtnPriority = new JRadioButton("Priority");
		rdbtnPriority.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
		rdbtnPriority.setBounds(57, 336, 141, 23);
		rdbtnPriority.addActionListener(this);
		
		JRadioButton rdbtnDueDate = new JRadioButton("Due Date");
		rdbtnDueDate.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
		rdbtnDueDate.setBounds(57, 362, 141, 23);
		rdbtnDueDate.addActionListener(this);
		
		JRadioButton rdbtnStatus = new JRadioButton("Status");
		rdbtnStatus.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
		rdbtnStatus.setBounds(57, 387, 141, 23);
		rdbtnStatus.addActionListener(this);
		
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
		descriptionUpdateTextField.addActionListener(this);
		
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
		//didn't add action listener yet
		
		dayUpdateTextField = new JTextField();
		dayUpdateTextField.setColumns(10);
		dayUpdateTextField.setBounds(545, 143, 40, 26);
		frame.getContentPane().add(dayUpdateTextField);
		//didn't add action listener yet
		
		//Priority Label
		JLabel lblNewLabel = new JLabel("Priority:");
		lblNewLabel.setBounds(435, 190, 49, 16);
		frame.getContentPane().add(lblNewLabel);
		
		
		
		//Create Buttons
		btnUpdateTask = new JButton("Update Task");
		btnUpdateTask.setBounds(483, 271, 123, 29);
		frame.getContentPane().add(btnUpdateTask);
		btnUpdateTask.addActionListener(this);
		
		btnCompleteTask = new JButton("Complete Task");
		btnCompleteTask.setBounds(483, 312, 123, 29);
		frame.getContentPane().add(btnCompleteTask);
		btnCompleteTask.addActionListener(this);
		
		btnDeleteTask = new JButton("Delete Task");
		btnDeleteTask.setBounds(483, 353, 123, 29);
		frame.getContentPane().add(btnDeleteTask);
		btnDeleteTask.addActionListener(this);
		
		//Create Status Label
		JLabel lblStatus = new JLabel("Status:");
		lblStatus.setBounds(440, 228, 49, 16);
		frame.getContentPane().add(lblStatus);
		
		//Create Status ComboBox with three options
		statusComboBox = new JComboBox();
		statusComboBox.setModel(new DefaultComboBoxModel(new String[] {"SELECT STATUS", "Not Started", "In Progress", "Finished"}));
		statusComboBox.setBounds(483, 224, 155, 27);
		frame.getContentPane().add(statusComboBox);
		statusComboBox.addActionListener(this);

		//Right Section of the GUI Beginning
		//New Description TextBox
		newDescriptionTextBox = new JTextField();
		newDescriptionTextBox.setColumns(10);
		newDescriptionTextBox.setBounds(754, 42, 155, 77);
		frame.getContentPane().add(newDescriptionTextBox);
		newDescriptionTextBox.addActionListener(this);
		
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
		newMonthTextField.addActionListener(this);
		
		//New Day TextBox
		newDayTextField = new JTextField();
		newDayTextField.setColumns(10);
		newDayTextField.setBounds(818, 143, 40, 26);
		frame.getContentPane().add(newDayTextField);
		newDayTextField.addActionListener(this);
		
		//New Day Label
		JLabel lblNewDay = new JLabel("Day");
		lblNewDay.setBounds(825, 125, 24, 16);
		frame.getContentPane().add(lblNewDay);
		
		
		
		//Add Labels
		JLabel lblNewPriority = new JLabel("Priority:");
		lblNewPriority.setBounds(708, 190, 49, 16);
		frame.getContentPane().add(lblNewPriority);
		
		
		
		//Add Buttons
		btnAddTask = new JButton("Add Task");
		btnAddTask.setBounds(754, 271, 123, 29);
		frame.getContentPane().add(btnAddTask);
		btnAddTask.addActionListener(this);
		
		btnSaveTask = new JButton("Save Task");
		btnSaveTask.setBounds(754, 312, 123, 29);
		frame.getContentPane().add(btnSaveTask);
		btnSaveTask.addActionListener(this);
		
		btnPrintToFile = new JButton("Print To File");
		btnPrintToFile.setBounds(754, 353, 123, 29);
		frame.getContentPane().add(btnPrintToFile);
		btnPrintToFile.addActionListener(this);
		
		JLabel lblViewAndUpdate = new JLabel("View and Update");
		lblViewAndUpdate.setBounds(493, 14, 109, 16);
		frame.getContentPane().add(lblViewAndUpdate);
		
		JLabel lblAddNewTask = new JLabel("Add New Task");
		lblAddNewTask.setBounds(779, 14, 90, 16);
		frame.getContentPane().add(lblAddNewTask);
		
		viewAndUpdatePriorityTextBox = new JTextField();		
		viewAndUpdatePriorityTextBox.setColumns(10);		
		viewAndUpdatePriorityTextBox.setBounds(496, 185, 61, 26);		
		frame.getContentPane().add(viewAndUpdatePriorityTextBox);		
				
		newPriorityTextBox = new JTextField();		
		newPriorityTextBox.setColumns(10);		
		newPriorityTextBox.setBounds(769, 185, 61, 26);		
		frame.getContentPane().add(newPriorityTextBox);
		newPriorityTextBox.addActionListener(this);
		
		JButton startOverbtn = new JButton("Start Over");		
		startOverbtn.setBounds(615, 399, 123, 29);		
		frame.getContentPane().add(startOverbtn);

	}
	
	public void actionPerformed(ActionEvent event) {
		
		String description = "";
		String priority = "";
		String status = "";
		String month = "";
		String day = "";
		//Date Not yet added
		
		if(event.getSource() == btnUpdateTask) {
			description = descriptionUpdateTextField.getText();
			priority = String.valueOf(priorityUpdateComboBox.getSelectedItem());
			status = statusComboBox.getSelectedItem().toString();
			//buttonHandler.updateExceptionHandler(description, priority, status);
		}
		else if (event.getSource() == btnCompleteTask) {
			// discuss other implementations of this method
			description = descriptionUpdateTextField.getText();
			priority = String.valueOf(priorityUpdateComboBox.getSelectedItem());
			status = statusComboBox.getSelectedItem().toString();
			//buttonHandler.completeTaskHandler(description, priority, status);
		}
		else if(event.getSource() == btnDeleteTask) {
			// discuss other implementations of this method
			
			//***get description from JList
			description = descriptionUpdateTextField.getText();
			//priority = String.valueOf(priorityUpdateComboBox.getSelectedItem());
			//status = statusComboBox.getSelectedItem().toString();
			String delete = list.getSelectedValue().toString();
			int index = list.getSelectedIndex();
			buttonHandler.deleteTaskHandler(delete);
			listModel.removeElementAt(index);
		}
		else if(event.getSource() == btnAddTask) {
			
			//priority = String.valueOf(newPriorityComboBox.getSelectedItem());
			priority = newPriorityTextBox.getText();
			month = newMonthTextField.getText();
			day = newDayTextField.getText();
			description =  newDescriptionTextBox.getText();
			//String toString = "Desctiption: " +description  +"\nPriority: "+ priority +"\nDue: "+ month +"/"+day;
			
			buttonHandler.addTaskHandler(description, priority, month, day);
			newDescriptionTextBox.setText("");
			newPriorityTextBox.setText("");
			newMonthTextField.setText("");
			newDayTextField.setText("");
			listModel.addElement(description);
			
		}
		else if (event.getSource() == btnSaveTask) {
			try {
				buttonHandler.saveTaskHandler();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else if(event.getSource() == btnPrintToFile) {
			try {
				buttonHandler.printToFileTaskHandler();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		// handling sort by radio buttons
		else if (event.getSource() == btnPrintToFile) {
			// actually have to add for radio buttons
			// call/ create and implement appropriate functions for radio button
		}
	}

	@Override
	public void valueChanged(ListSelectionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
