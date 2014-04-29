package edu.clemson.cs.cpsc215.SimpleMail;

import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class MainFrameMediator {

	public void configure() {
		ConfigurationDlg editConfig = new ConfigurationDlg();
		editConfig.setVisible(true);
	}

	public void exit() {
		DataStore.getDataStore().saveData();
	}

	public void table(MouseEvent e, int loc) {
		// only consume double-clicks to compose new mail
		if (e.getClickCount() == 2 && !e.isConsumed()) {
			e.consume();
			EmailTransmissionDlg newMail = new EmailTransmissionDlg(loc);
			newMail.setVisible(true);
		}
	}

	public void add() {
		ContactEditingDlg newContact = new ContactEditingDlg(-1);
		newContact.setVisible(true);
	}

	public void compose() {
		EmailTransmissionDlg newMail = new EmailTransmissionDlg(-1);
		newMail.setVisible(true);
	}

	public void edit(int loc) {
		ContactEditingDlg editContact = new ContactEditingDlg(loc);
		editContact.setVisible(true);
	}

	public void about() {
		SystemInformationDlg info = new SystemInformationDlg();
		info.setVisible(true);
	}

	public void delete(int row) {
		ArrayList<Contact> contacts = DataStore.getDataStore().getContactList();
		Contact contact = new Contact();
		if (contacts.size() > 0) {
			contact = (Contact) contacts.get(row);
		}

		int selected = JOptionPane.showOptionDialog(null,
				"Are you sure want to delete " + contact.getName() + "?",
				"Confirm contact deletion", JOptionPane.YES_NO_OPTION,
				JOptionPane.QUESTION_MESSAGE, null, null, null);
		if (selected == 0) {
			contacts.remove(row);
			DataStore.getDataStore().setContactList(contacts);
			DataStore.getDataStore().fireTableRowsInserted(0,
					DataStore.getDataStore().getRowCount());
		}
	}

	public void close() {
		int close = JOptionPane.showOptionDialog(null,
				"Are you sure you want to close the application?", "Exit?",
				JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null,
				null, null);
		if (close == 0) {
			DataStore.getDataStore().saveData();

		}
	}
}
