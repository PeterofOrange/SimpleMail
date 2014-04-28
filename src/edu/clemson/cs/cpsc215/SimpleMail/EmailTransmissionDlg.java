//Parker Davis (parkerd), Peter Schatteman (prschat), Phillip Schneider (pschnei)
//Last Modified: Apr 28 2014
//Assignment 4: SimpleMail
//This file contains the EmailTransmissionDlg class and associated methods
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
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class EmailTransmissionDlg extends JDialog {

	private GridBagConstraints constraints;
	private JLabel fromLabel, toLabel, ccLabel, bccLabel, subjLabel, msgLabel;
	private JTextField fromText, toText, ccText, bccText, subjText;
	private JTextArea msgText;
	private JScrollPane msgScroll;
	private JButton sendButton, cancelButton;

	public EmailTransmissionDlg(Frame main, Contact con) {
		super(main, "Send Email");
		setLayout(new GridBagLayout());
		constraints = new GridBagConstraints();
		constraints.anchor = GridBagConstraints.WEST;
		constraints.insets = new Insets(5, 5, 5, 5);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setupMenu();
		setupForm();
		toText.setText(con.getEmail());
		this.pack();
		this.setVisible(true);
	}

	public EmailTransmissionDlg() {
		// super(main, "Send Email");
		setLayout(new GridBagLayout());
		constraints = new GridBagConstraints();
		constraints.anchor = GridBagConstraints.WEST;
		constraints.insets = new Insets(6, 6, 6, 6);
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

		fromLabel = new JLabel("From: ");
		constraints.gridx = 0;
		constraints.gridy = 0;
		this.add(fromLabel, constraints);
		fromText = new JTextField(30);
		fromText.setText(DataStore.getDataStore().getConfig().getEmail());
		fromText.setEditable(false);
		constraints.gridx = 1;
		constraints.fill = GridBagConstraints.HORIZONTAL;
		this.add(fromText, constraints);

		toLabel = new JLabel("To: ");
		constraints.gridx = 0;
		constraints.gridy = 1;
		this.add(toLabel, constraints);
		toText = new JTextField(30);
		constraints.gridx = 1;
		constraints.fill = GridBagConstraints.HORIZONTAL;
		this.add(toText, constraints);

		ccLabel = new JLabel("CC: ");
		constraints.gridx = 0;
		constraints.gridy = 2;
		this.add(ccLabel, constraints);
		ccText = new JTextField(30);
		constraints.gridx = 1;
		constraints.fill = GridBagConstraints.HORIZONTAL;
		this.add(ccText, constraints);

		bccLabel = new JLabel("BCC: ");
		constraints.gridx = 0;
		constraints.gridy = 3;
		this.add(bccLabel, constraints);
		bccText = new JTextField(30);
		constraints.gridx = 1;
		constraints.fill = GridBagConstraints.HORIZONTAL;
		this.add(bccText, constraints);

		subjLabel = new JLabel("Subject: ");
		constraints.gridx = 0;
		constraints.gridy = 4;
		this.add(subjLabel, constraints);
		subjText = new JTextField(30);
		constraints.gridx = 1;
		constraints.fill = GridBagConstraints.HORIZONTAL;
		this.add(subjText, constraints);

		msgLabel = new JLabel("Body: ");
		constraints.gridx = 0;
		constraints.gridy = 5;
		this.add(msgLabel, constraints);
		msgText = new JTextArea(10, 30);
		msgText.setLineWrap(true);
		msgScroll = new JScrollPane(msgText);
		constraints.gridx = 1;
		constraints.fill = GridBagConstraints.HORIZONTAL;
		this.add(msgScroll, constraints);

		sendButton = new JButton("Send");
		sendButton.setFont(new Font("Arial", Font.BOLD, 16));
		constraints.gridx = 1;
		constraints.gridy = 6;
		constraints.gridheight = 2;
		constraints.gridwidth = 1;
		this.add(sendButton, constraints);

		cancelButton = new JButton("Cancel");
		cancelButton.setFont(new Font("Arial", Font.BOLD, 16));
		constraints.gridx = 0;
		constraints.gridy = 6;
		constraints.gridheight = 2;
		constraints.gridwidth = 1;
		this.add(cancelButton, constraints);

		cancelButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});

		sendButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sendAction();
			}
		});
	}

	public void sendAction() {
		EmailTransmission letter = new EmailTransmission();
		String delims = "[, ]+";

		String[] addresses = toText.getText().split(delims);
		for(int c = 0; c < addresses.length; c++)
			letter.addTo(addresses[c]);
		
		addresses = this.ccText.getText().split(delims);
		for(int c = 0; c < addresses.length; c++)
			letter.addCc(addresses[c]);
		
		addresses = this.bccText.getText().split(delims);
		for(int c = 0; c < addresses.length; c++)
			letter.addBcc(addresses[c]);

		letter.setSubject(this.subjText.getText());
		letter.setMessage(this.msgText.getText());

		try {
			letter.sendEmail();// (to, cc, bcc, subject, body);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JOptionPane.showMessageDialog(this, "Email sent!");
		}

		this.toText.setText("");
		this.ccText.setText("");
		this.bccText.setText("");
		this.subjText.setText("");
		this.msgText.setText("");
	}
}