//Parker Davis (parkerd), Peter Schatteman (prschat), Phillip Schneider (pschnei)
//Last Modified: Apr 28 2014
//Assignment 4: SimpleMail
//This file contains the SystemInformationDlg class and associated methods
package edu.clemson.cs.cpsc215.SimpleMail;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.Frame;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class SystemInformationDlg extends JDialog {
	 private JLabel builders, title, subtitle, general, version;
	 private JPanel layer;
	 
	public SystemInformationDlg(Frame main) {
		super(main, "System Information / About");
		setLayout(new BorderLayout());

		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		//setupMenu();
	//	setupForm();
	}
	/**
	 * constructs a SystemInfromationDlg object
	 */
	public SystemInformationDlg() {
		this.setModalityType(DEFAULT_MODALITY_TYPE);
		this.setTitle("About SimpleMail");
		setLayout(new BorderLayout());
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		//setupMenu();
		//setupForm();
		layer = new JPanel();
		title = new JLabel("SimpleMail");
		version = new JLabel("Version 1.0 April 28, 2014");
		subtitle = new JLabel("Coders ");
		builders = new JLabel("Philip schneider, Parker Davis, Peter Schatteman");
		general = new JLabel("This project is a simple email client programed in java.");
		title.setFont(new Font("Arial", Font.PLAIN, 22));
		this.add(title,BorderLayout.PAGE_START);
		this.add(version,BorderLayout.CENTER);
		this.add(layer,BorderLayout.PAGE_END);
		layer.setLayout(new BorderLayout());
		layer.add(subtitle,BorderLayout.PAGE_START);
		layer.add(builders,BorderLayout.CENTER);
		layer.add(general,BorderLayout.PAGE_END);
		
		this.pack();
		this.setVisible(true);
	}
	
	//include version, date, quick about sentence, contributors
}