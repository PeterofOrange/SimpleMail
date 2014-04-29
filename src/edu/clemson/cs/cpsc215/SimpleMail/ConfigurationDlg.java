//Parker Davis (parkerd), Peter Schatteman (prschat), Phillip Schneider (pschnei)
//Last Modified: Apr 28 2014
//Assignment 4: SimpleMail
//This file contains the Configuration class and associated methods
package edu.clemson.cs.cpsc215.SimpleMail;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class ConfigurationDlg extends JDialog {

	private static final long serialVersionUID = 1L;
	private GridBagConstraints constraints;
	private JLabel emailAddrLabel, emailPasswordLabel, serverAddrLabel,
			serverPortLabel;
	private JTextField emailAddrText, serverAddrText, serverPortText;
	private JPasswordField emailPasswordText;
	private JButton saveButton, cancelButton;

	/**
	 * Constructs a new ConfigurationDlg
	 */
	public ConfigurationDlg() {
		setLayout(new GridBagLayout());
		constraints = new GridBagConstraints();
		constraints.anchor = GridBagConstraints.WEST;
		constraints.insets = new Insets(5, 5, 5, 5);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setupForm();
		this.pack();
		emailAddrText.setText(DataStore.getDataStore().getConfig().getEmail());
		emailPasswordText.setText(DataStore.getDataStore().getConfig()
				.getPassword());
		serverAddrText.setText(DataStore.getDataStore().getConfig()
				.getServerAddr());
		serverPortText.setText(DataStore.getDataStore().getConfig()
				.getServerPort());

		this.setModalityType(DEFAULT_MODALITY_TYPE);
		this.setTitle("Edit Configuration");
		this.setVisible(true);
	}

	/**
	 * Sets up the form for a ConfigurationDlg
	 */
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
		emailPasswordText = new JPasswordField(30);
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
			}
		});

		saveButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!emailAddrText.getText().matches(".*@.*")) {
					ErrorDlg.showError("Invalid Email: "
							+ emailAddrText.getText());
				} else {
					DataStore.getDataStore().getConfig()
							.setEmail(emailAddrText.getText());
					String tmp = emailPasswordText.getPassword().toString();
					DataStore.getDataStore().getConfig().setPassword(tmp);
					DataStore.getDataStore().getConfig()
							.setServerAddr(serverAddrText.getText());
					DataStore.getDataStore().getConfig()
							.setServerPort(serverPortText.getText());
					DataStore.getDataStore().saveConfig();
					dispose();
				}

			}
		});
	}
}