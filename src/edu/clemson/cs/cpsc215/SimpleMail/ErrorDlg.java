//Parker Davis (parkerd), Peter Schatteman (prschat), Phillip Schneider (pschnei)
//Last Modified: Apr 28 2014
//Assignment 4: SimpleMail
//This file contains the ErrorDlg class
package edu.clemson.cs.cpsc215.SimpleMail;

import javax.swing.JDialog;
import javax.swing.JOptionPane;

public class ErrorDlg extends JDialog {
	
	private static final long serialVersionUID = 1L;

	/**
	 * Constructs an ErrorDlg JDialog
	 * 
	 * @param errorString		the error message to show on this JDialog
	 */
	public static void showError(String errorString) {
		JOptionPane.showMessageDialog(null, errorString);
	}
}