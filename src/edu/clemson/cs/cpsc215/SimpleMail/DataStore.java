//Parker Davis (parkerd), Peter Schatteman (prschat), Phillip Schneider (pschnei)
//Last Modified: Apr 28 2014
//Assignment 4: SimpleMail
//This file contains the DataStore singleton class and associated methods
package edu.clemson.cs.cpsc215.SimpleMail;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

public class DataStore extends AbstractTableModel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 5177090278890104086L;
	private static final DataStore toSelf = new DataStore();
	private ArrayList<Contact> contacts = new ArrayList<Contact>();
	private Configuration config = new Configuration();

	private DataStore() {
	}

	/**
	 * Returns the DataStore Singleton, used to access the contact list and
	 * config data
	 * 
	 * @return pointer to DataStore
	 */
	public static DataStore getDataStore() {
		return toSelf;
	}

	/**
	 * Returns the ArrayList of contacts stored in the program
	 * 
	 * @return ArrayList<Contact> reference
	 */
	public ArrayList<Contact> getContactList() {
		return contacts;
	}

	/**
	 * Returns the Configuration object
	 * 
	 * @return Configuration reference
	 */
	public Configuration getConfig() {
		return config;
	}

	/**
	 * Changes Contact list
	 * 
	 * @param ArrayList
	 *            <Contact>
	 */
	public void setContactList(ArrayList<Contact> contactList) {
		this.contacts = contactList;
	}

	/**
	 * Sets Configuration object
	 * 
	 * @param Configuration
	 */
	public void setConfig(Configuration config) {
		this.config = config;
	}

	/**
	 * Loads contacts and cofiguration data from storage
	 */
	public void loadData() {
		loadContacts();
		loadConfig();
	}

	/**
	 * Loads cofiguration data from storage
	 */
	public void loadConfig() {
		ObjectInputStream in = null;
		File f = new File("data/configuration.dat");

		try {
			in = new ObjectInputStream(new FileInputStream(f));
			config = (Configuration) in.readObject();
			in.close();
		} catch (FileNotFoundException e) {
			System.out.println("Error in loading configuration.");
		} catch (IOException e) {
			System.out.println("Error in loading configuration.");
		} catch (ClassNotFoundException e) {
			System.out.println("Error in loading configuration.");
		}
	}

	/**
	 * Loads contact list from storage
	 */
	public void loadContacts() {
		ObjectInputStream in = null;
		File f = new File("data/contacts/");
		File[] contactFiles = f.listFiles();

		for (int i = 0; i < contactFiles.length; i++) {
			try {
				in = new ObjectInputStream(new FileInputStream(contactFiles[i]));
				Contact con = (Contact) in.readObject();
				contacts.add(con);
				in.close();
			} catch (FileNotFoundException e) {
				System.out.println("Could not load contact.");
			} catch (IOException e) {
				System.out.println("Could not load contact.");
			} catch (ClassNotFoundException e) {
				System.out.println("Could not load contact.");
			}
		}
	}

	/**
	 * Saves Configuration and Contacts for
	 * future usage.
	 */
	public void saveData(){
		saveConfig();
		saveContacts();
	}

	/**
	 * Saves Configuration for
	 * future usage.
	 */
	public void saveConfig() {
		ObjectOutputStream out = null;

		try {
			out = new ObjectOutputStream(new FileOutputStream(
					"data/configuration.dat"));
			out.writeObject(config);
			out.close();
		} catch (FileNotFoundException e) {
			System.out.println("Error saving configuration.");
		} catch (IOException e) {
			System.out.println("Error saving configuration.");
		}
	}

	/**
	 * Saves Contacts list for
	 * future usage.
	 */
	public void saveContacts() {
		ObjectOutputStream out = null;

		try {
			for (int i = 0; i < contacts.size(); i++) {
				out = new ObjectOutputStream(new FileOutputStream(
						"data/contacts/" + contacts.get(i).getEmail() + ".ser"));
				out.writeObject(contacts.get(i));
				out.close();
			}
		} catch (FileNotFoundException e) {
			System.out.println("Error in saving contacts.");
		} catch (IOException e) {
			System.out.println("Error in saving contacts.");
		}
	}

	/**
	 * Add person to contacts list
	 * 
	 * @param Contact
	 */
	public void addContact(Contact con) {
		contacts.add(con);
	}

	/**
	 * Removes contact from list
	 * 
	 * @param int
	 */
	public void removeContact(int index) {
		contacts.remove(index);
	}

	/**
	 * Returns number of columns in person list
	 * 
	 * @return 4
	 */
	@Override
	public int getColumnCount() {
		return 4;
	}

	/**
	 * Returns number of Persons in person list
	 * 
	 * @return Integer
	 */
	@Override
	public int getRowCount() {
		return contacts.size();
	}

	/**
	 * Returns element of person from contact list
	 * Second argument:
	 *    0: Name
	 *    1: Postal Address
	 *    2: Phone Number
	 *    3: E-mail address
	 * 
	 * @param Integer number of person in list,
	 * @param Integer attribute of person
	 * @return Object
	 */
	@Override
	public Object getValueAt(int arg0, int arg1) {
		Object ret = null;
		switch (arg1) {
		case 0:
			ret = contacts.get(arg0).getName();
			break;
		case 1:
			ret = contacts.get(arg0).getPost();
			break;
		case 2:
			ret = contacts.get(arg0).getPhone();
			break;
		case 3:
			ret = contacts.get(arg0).getEmail();
			break;
		}
		return ret;
	}
}