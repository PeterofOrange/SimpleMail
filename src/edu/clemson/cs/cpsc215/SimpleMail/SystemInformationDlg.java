//Parker Davis (parkerd), Peter Schatteman (prschat), Phillip Schneider (pschnei)
//Last Modified: Apr 28 2014
//Assignment 4: SimpleMail
//This file contains the SystemInformationDlg class and associated methods
package edu.clemson.cs.cpsc215.SimpleMail;

import java.awt.BorderLayout;
import java.awt.Font;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class SystemInformationDlg extends JDialog {
	
	private static final long serialVersionUID = 1L;
	private JLabel builders, title, subtitle, general, version;
	private JPanel layer;
	 
	/**
	 * constructs a SystemInfromationDlg object
	 */
	public SystemInformationDlg() {
		this.setModalityType(DEFAULT_MODALITY_TYPE);
		this.setTitle("About SimpleMail");
		setLayout(new BorderLayout());
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		layer = new JPanel();
		title = new JLabel("SimpleMail");
		version = new JLabel("Version 1.0 April 28, 2014");
		subtitle = new JLabel("Coders: ");
		builders = new JLabel("Parker Davis, Peter Schatteman, Phillip Schneider");
		general = new JLabel("This project is a simple email client programed in java.");
		title.setFont(new Font("Arial", Font.PLAIN, 22));
		this.add(title,BorderLayout.PAGE_START);
		this.add(version,BorderLayout.CENTER);
		this.add(layer,BorderLayout.PAGE_END);
		layer.setLayout(new BorderLayout());
		layer.add(subtitle,BorderLayout.PAGE_START);
		layer.add(builders,BorderLayout.CENTER);
		layer.add(general,BorderLayout.PAGE_END);
		this.setTitle("Edit Configuration");
		this.pack();
		this.setVisible(true);
	}
}