//Parker Davis (parkerd), Peter Schatteman (prschat), Phillip Schneider (pschnei)
//Last Modified: Apr 28 2014
//Assignment 4: SimpleMail
//This file contains the ContactEditing class and associated methods
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

public class ContactEditingDlg extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 772183832819353099L;
	private GridBagConstraints constraints;
	private JLabel nameLabel, postLabel, phoneLabel, emailLabel;
	private JTextField nameText, postText, phoneText, emailText;
	private JButton saveButton, cancelButton;
	private Contact con;

	public ContactEditingDlg(Frame main, Contact con) {
		super(main, "Add or Edit a Contact");
		setLayout(new GridBagLayout());
		constraints = new GridBagConstraints();
		constraints.anchor = GridBagConstraints.WEST;
		constraints.insets = new Insets(5, 5, 5, 5);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setupMenu();
		setupForm();
		nameText.setText(con.getName());
		postText.setText(con.getPost());
		phoneText.setText(con.getPhone());
		emailText.setText(con.getEmail());
		this.pack();
		this.setVisible(true);
	}

	public ContactEditingDlg(int contactIndex) {
		// super(main, "Add or Edit a Contact");
		setLayout(new GridBagLayout());
		constraints = new GridBagConstraints();
		constraints.anchor = GridBagConstraints.WEST;
		constraints.insets = new Insets(5, 5, 5, 5);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setupMenu();
		setupForm();
		this.pack();
		con = new Contact();
		if (contactIndex != -1) {
			con = DataStore.getDataStore().getContactList().get(contactIndex);
		}
		if (con != null) {
			nameText.setText(con.getName());
			postText.setText(con.getPost());
			phoneText.setText(con.getPhone());
			emailText.setText(con.getEmail());
		}

		this.setVisible(true);
	}

	private void setupMenu() {
		// TODO Auto-generated method stub

	}

	private void setupForm() {
		nameLabel = new JLabel("Name: ");
		constraints.gridx = 0;
		constraints.gridy = 0;
		this.add(nameLabel, constraints);
		nameText = new JTextField(30);
		constraints.gridx = 1;
		constraints.fill = GridBagConstraints.HORIZONTAL;
		this.add(nameText, constraints);

		postLabel = new JLabel("Postal Address: ");
		constraints.gridx = 0;
		constraints.gridy = 1;
		this.add(postLabel, constraints);
		postText = new JTextField(30);
		constraints.gridx = 1;
		constraints.fill = GridBagConstraints.HORIZONTAL;
		this.add(postText, constraints);

		phoneLabel = new JLabel("Phone Number: ");
		constraints.gridx = 0;
		constraints.gridy = 2;
		this.add(phoneLabel, constraints);
		phoneText = new JTextField(30);
		constraints.gridx = 1;
		constraints.fill = GridBagConstraints.HORIZONTAL;
		this.add(phoneText, constraints);

		emailLabel = new JLabel("Email Address: ");
		constraints.gridx = 0;
		constraints.gridy = 3;
		this.add(emailLabel, constraints);
		emailText = new JTextField(30);
		constraints.gridx = 1;
		constraints.fill = GridBagConstraints.HORIZONTAL;
		this.add(emailText, constraints);

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
				if (DataStore.getDataStore().getContactList().contains(con)) {
					saveContact(DataStore.getDataStore().getContactList()
							.lastIndexOf(con));
				} else {
					saveContact(-1);
				}
				DataStore.getDataStore().fireTableRowsInserted(0,
						DataStore.getDataStore().getRowCount());
				DataStore.getDataStore().saveContacts();

			}
		});
	}

	/**
	 * Saves a contact. This saves a new contact or overwrites old contact
	 * information.
	 * 
	 * @param index
	 *            the index of the contact to overwrite. Set this to -1 for a
	 *            new contact.
	 */
	public void saveContact(int index) {
		String name = nameText.getText();
		String post = postText.getText();
		String phone = phoneText.getText();
		String email = emailText.getText();
		if (!email.matches(".*@.*")) {
			ErrorDlg.showError("Invalid Email: " + email);
		} else {
			Contact add = new Contact(name, post, phone, email);
			if (index == -1) {
				DataStore.getDataStore().addContact(add);
			} else {
				DataStore.getDataStore().getContactList().set(index, add);
			}
			DataStore.getDataStore().saveContacts();
			// TODO: move to exit functions

			dispose();

		}
	}
}