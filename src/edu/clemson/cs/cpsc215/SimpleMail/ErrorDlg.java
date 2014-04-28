package edu.clemson.cs.cpsc215.SimpleMail;

import javax.swing.JDialog;
import javax.swing.JOptionPane;

public class ErrorDlg extends JDialog {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static void showError(String errorString) {
		JOptionPane.showMessageDialog(null, errorString);
	}
}