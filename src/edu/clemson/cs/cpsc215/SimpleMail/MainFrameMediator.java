package edu.clemson.cs.cpsc215.SimpleMail;

import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.io.File;

import javax.swing.JOptionPane;

public class MainFrameMediator {

	/**
	 * runs the logic behind the configure menu button in MainFrame
	 */
	public void configure() {
		ConfigurationDlg editConfig = new ConfigurationDlg();
		editConfig.setEnabled(true);
	}

	/**
	 * runs the logic behind the configure exit button in MainFrame
	 */
	public void exit() {
		DataStore.getDataStore().saveData();
	}

	/**
	 * runs the logic behind the double click a contact feature in MainFrame
	 * 
	 * @param e
	 *            The MouseEvent associated with a click
	 * @param loc
	 *            The index of the row clicked
	 */
	public void table(MouseEvent e, int loc) {
		// only consume double-clicks to compose new mail
		if (e.getClickCount() == 2 && !e.isConsumed()) {
			e.consume();
			EmailTransmissionDlg newMail = new EmailTransmissionDlg(loc);
			newMail.setEnabled(true);
		}
	}

	/**
	 * runs the logic behind the add menu button in MainFrame
	 */
	public void add() {
		ContactEditingDlg newContact = new ContactEditingDlg(-1);
		newContact.setEnabled(true);
	}

	/**
	 * runs the logic behind the compose menu button in MainFrame
	 */
	public void compose() {
		EmailTransmissionDlg newMail = new EmailTransmissionDlg(-1);
		newMail.setEnabled(true);
	}

	/**
	 * runs the logic behind the edit button in MainFrame
	 * 
	 * @param loc
	 *            the index of the contact to edit
	 */
	public void edit(int loc) {
		ContactEditingDlg editContact = new ContactEditingDlg(loc);
		editContact.setEnabled(true);
	}

	/**
	 * runs the logic behind the about menu button in MainFrame
	 */
	public void about() {
		SystemInformationDlg info = new SystemInformationDlg();
		info.setEnabled(true);
	}

	/**
	 * runs the logic behind the delete button in MainFrame
	 * 
	 * @param row
	 *            the row of the contact to delete
	 */
	public void delete(int row) {
		ArrayList<Contact> contacts = DataStore.getDataStore().getContactList();
		Contact contact = new Contact();
		if (contacts.size() > 0) {
			contact = (Contact) contacts.get(row);

			File f = new File("data/contacts/" + contact.getEmail() + ".ser");
			f.delete();
			
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
	}

	/**
	 * runs the logic behind the close menu button in MainFrame
	 */
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