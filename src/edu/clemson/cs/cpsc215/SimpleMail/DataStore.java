//Parker Davis (parkerd), Peter Schatteman (prschat), Phillip Schneider (pschnei)
//Last Modified: Apr 27 2014
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

public class DataStore extends AbstractTableModel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 5177090278890104086L;
	private static final DataStore toSelf = new DataStore();
	private ArrayList<Contact> contacts = new ArrayList<Contact>();
	private Configuration config = new Configuration();

	private DataStore() {
	}

	public static DataStore getDataStore() {
		return toSelf;
	}

	
	public ArrayList<Contact> getContactList() {
		return contacts;
	}
	
	public Configuration getConfig() {
		return config;
	}

	
	public void setContactList(ArrayList<Contact> contactList) {
		this.contacts = contactList;
	}
	
	public void setConfig(Configuration config) {
		this.config = config;
	}
	
	
	public void loadData() {
		loadContacts();
		loadConfig();
	}
	
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
	
	public void loadContacts() {
		ObjectInputStream in = null;
		File f = new File("data/contacts/");
		File [] contactFiles = f.listFiles();
		
		for (int i = 0; i < contactFiles.length; i++) {
			try {
				in = new ObjectInputStream(new FileInputStream(contactFiles[i]));
				Contact con = (Contact) in.readObject();
				contacts.add(con);
				in.close();
			}
			catch (FileNotFoundException e) {
				System.out.println("Could not load contact.");
			}
			catch (IOException e) {
				System.out.println("Could not load contact.");
			}
			catch (ClassNotFoundException e) {
				System.out.println("Could not load contact.");
			}
		}
	}
	
	public void saveConfig() {
		ObjectOutputStream out = null;
		
		try {
			 out = new ObjectOutputStream(new FileOutputStream("data/configuration.dat"));
			 out.writeObject(config);
			 out.close();
		} catch (FileNotFoundException e) {
			System.out.println("Error saving configuration.");
		} catch (IOException e) {
			System.out.println("Error saving configuration.");
		}
	}
	
	public void saveContacts() {
		ObjectOutputStream out = null;
		
		try {
			for (int i = 0; i < contacts.size(); i++) {
				out = new ObjectOutputStream(new FileOutputStream("data/contacts/" + contacts.get(i).getEmail() + ".ser"));
				out.writeObject(contacts.get(i));
				out.close();
			}
		}
		catch (FileNotFoundException e) {
			System.out.println("Error in saving contacts.");
		}
		catch (IOException e) {
			System.out.println("Error in saving contacts.");
		}
	}
	
	public void addContact(Contact con) {
		contacts.add(con);
	}
	
	public void removeContact(int index) {
		contacts.remove(index);
	}

	@Override
	public int getColumnCount() {
		return 4;
	}

	@Override
	public int getRowCount() {
		return contacts.size();
	}

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