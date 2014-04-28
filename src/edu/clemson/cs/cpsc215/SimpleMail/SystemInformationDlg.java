//Parker Davis (parkerd), Peter Schatteman (prschat), Phillip Schneider (pschnei)
//Last Modified: Apr 28 2014
//Assignment 4: SimpleMail
//This file contains the SystemInformationDlg class and associated methods
package edu.clemson.cs.cpsc215.SimpleMail;

import java.awt.Frame;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JDialog;
import javax.swing.JFrame;

public class SystemInformationDlg extends JDialog {
	public SystemInformationDlg(Frame main) {
		super(main, "System Information / About");
		setLayout(new GridBagLayout());
		//constraints = new GridBagConstraints();
		//constraints.anchor = GridBagConstraints.WEST;
		//constraints.insets = new Insets(5, 5, 5, 5);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		//setupMenu();
	//	setupForm();
	}
	
	//include version, date, quick about sentence, contributors
}