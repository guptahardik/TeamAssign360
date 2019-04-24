package main;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;

public class GUIEventHandler{

	
	public void updateExceptionHandler(String desc, String prio, String stat) {
		if(desc.equals("")) {
			JOptionPane.showMessageDialog(null, "Update Description in empty !");
			return;
		}
		else if(prio.equals("")) {
			JOptionPane.showMessageDialog(null, "Priority not chosen !");
			return;
		}
		else if(stat.equals("")) {
			JOptionPane.showMessageDialog(null, "Status not chosen !");
			return;
		}
		else {
			// call update function
		}
		return;
	}
		
	public void completeTaskHandler(String desc, String prio, String stat) {
		// get the list object
		// perform the actions for complete task
		return;
	}
	
	public void deleteTaskHandler(String desc, String prio, String stat) {
		// get the corresponding list object
		// delete the object from the list
		// make priority changes to other list objects accordingly
		return;
	}
	
	public void addTaskHandler(String desc, String prio, String stat) {
		if(desc.equals("")) {
			JOptionPane.showMessageDialog(null, "Update Description in empty !");
			return;
		}
		else if(prio.equals("")) {
			JOptionPane.showMessageDialog(null, "Priority not chosen !");
			return;
		}
		else if(stat.equals("")) {
			JOptionPane.showMessageDialog(null, "Status not chosen !");
			return;
		}
		else {
			// call add function
		}
		return;
	}
	
	public void saveTaskHandler() {
		// perform save list task
		return;
	}
	
	public void printToFileTaskHandler() {
		// perform print to file operation
		return;
	}
	
	// add function for the radio button sorting
}
