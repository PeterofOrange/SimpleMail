//Parker Davis (parkerd), Peter Schatteman (prschat), Phillip Schneider (pschnei)
//Last Modified: Apr 28 2014
//Assignment 4: SimpleMail
//This file contains the Configuration class and associated methods
package edu.clemson.cs.cpsc215.SimpleMail;

import java.awt.Font;
import java.awt.Frame;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class ConfigurationDlg extends JDialog {
	
    private GridBagConstraints constraints;
    private JLabel emailAddrLabel, emailPasswordLabel, serverAddrLabel, serverPortLabel;
    private JTextField emailAddrText, emailPasswordText, serverAddrText, serverPortText;
	private JButton saveButton, cancelButton;
    
	
	public ConfigurationDlg(Frame main, Contact con) {
			super(main, "Add or Edit a Contact");
			setLayout(new GridBagLayout());
			constraints = new GridBagConstraints();
			constraints.anchor = GridBagConstraints.WEST;
			constraints.insets = new Insets(5, 5, 5, 5);
			setLocationRelativeTo(null);
			setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			setupMenu();
			setupForm();
			emailAddrText.setText(con.getName());
			emailPasswordText.setText(con.getPost());
			serverAddrText.setText(con.getPhone());
			serverPortText.setText(con.getEmail());
			this.pack();
			this.setVisible(true);
		}
	
	public ConfigurationDlg() {
		//super(main, "Add or Edit a Contact");
		setLayout(new GridBagLayout());
		constraints = new GridBagConstraints();
		constraints.anchor = GridBagConstraints.WEST;
		constraints.insets = new Insets(5, 5, 5, 5);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setupMenu();
		setupForm();
		this.pack();
		this.setVisible(true);
	}
	
		private void setupMenu() {
		// TODO Auto-generated method stub
		
	}
	
	private void setupForm() {
		emailAddrLabel = new JLabel("Email address: ");
		constraints.gridx = 0;
		constraints.gridy = 0;
		this.add(emailAddrLabel, constraints);
		emailAddrText = new JTextField(30);
		constraints.gridx = 1;
		constraints.fill = GridBagConstraints.HORIZONTAL;
		this.add(emailAddrText, constraints);
		
		
		emailPasswordLabel = new JLabel("Email password: ");
		constraints.gridx = 0;
		constraints.gridy = 1;
		this.add(emailPasswordLabel, constraints);
		emailPasswordText = new JTextField(30);
		constraints.gridx = 1;
		constraints.fill = GridBagConstraints.HORIZONTAL;
		this.add(emailPasswordText, constraints);
		
		
		serverAddrLabel = new JLabel("SMTP server address: ");
		constraints.gridx = 0;
		constraints.gridy = 2;
		this.add(serverAddrLabel, constraints);
		serverAddrText = new JTextField(30);
		constraints.gridx = 1;
		constraints.fill = GridBagConstraints.HORIZONTAL;
		this.add(serverAddrText, constraints);
		
		serverPortLabel = new JLabel("SMTP server port: ");
		constraints.gridx = 0;
		constraints.gridy = 3;
		this.add(serverPortLabel, constraints);
		serverPortText = new JTextField(30);
		constraints.gridx = 1;
		constraints.fill = GridBagConstraints.HORIZONTAL;
		this.add(serverPortText, constraints);
		
		saveButton = new JButton("Save");
		saveButton.setFont(new Font("Arial", Font.BOLD, 16));
		constraints.gridx = 1;
		constraints.gridy = 4;
		constraints.gridheight = 2;
		constraints.gridwidth = 1;
		this.add(saveButton, constraints);

		cancelButton = new JButton("Cancel");
		cancelButton.setFont(new Font("Arial", Font.BOLD, 16));
		constraints.gridx = 0;
		constraints.gridy = 4;
		constraints.gridheight = 2;
		constraints.gridwidth = 1;
		this.add(cancelButton, constraints);
		
		
		cancelButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				dispose();
			}});
			
		
		saveButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DataStore.getDataStore().getConfig().setEmail(emailAddrText.getText());
				DataStore.getDataStore().getConfig().setPassword(emailPasswordText.getText());
				DataStore.getDataStore().getConfig().setServerAddr(serverAddrText.getText());
				DataStore.getDataStore().getConfig().setServerPort(serverPortText.getText());
				DataStore.getDataStore().saveConfig();
				
			}});
	}

		public void saveContact() {
			String name = emailAddrText.getText();
					String post  = emailPasswordText.getText();
					String phone = serverAddrText.getText();
					String email = serverPortText.getText();
					Contact add = new Contact(name, post, phone, email);
					DataStore.getDataStore().addContact(add);
					dispose();
				//TODO: date main for table update
	}
}