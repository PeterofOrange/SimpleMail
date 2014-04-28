package edu.clemson.cs.cpsc215.SimpleMail;

import javax.swing.JDialog;
import javax.swing.JOptionPane;

public class ErrorDlg extends JDialog {
	
	public ErrorDlg(String errorString) {
		JOptionPane.showMessageDialog(this, errorString);
		this.setModalityType(DEFAULT_MODALITY_TYPE);
		this.setVisible(true);
	}
}