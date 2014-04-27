package edu.clemson.cs.cpsc215.SimpleMail;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

//extends AbstractTableModel?
public class DataStore {
	private static DataStore toSelf = new DataStore();
	private ArrayList<Contact> contacts = new ArrayList<Contact>();
	private Configuration config = new Configuration();

	private DataStore() {
	}

	public static DataStore getDataStore() {
		if (toSelf == null) {
			toSelf = new DataStore();
		}
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

}