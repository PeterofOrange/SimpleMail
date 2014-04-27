package edu.clemson.cs.cpsc215.SimpleMail;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

public class DataStore implements Serializable {
	private static final long serialVersionUID = -3397949010748837896L;
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
		loadConfiguration();
	}
	
	public void loadContacts() {
		
	}
	
	public void loadConfiguration() {
		
	}

	
	public static void serialize(Object obj, String filename) throws IOException {
		FileOutputStream fileOut = new FileOutputStream(filename);
		ObjectOutputStream objOut = new ObjectOutputStream(fileOut);
		objOut.writeObject(obj);
		fileOut.close();
		}
	
	public static Object deserialize(String filename) throws IOException, ClassNotFoundException {
		FileInputStream fileIn = new FileInputStream(filename);
		ObjectInputStream objIn = new ObjectInputStream(fileIn);
		Object obj = objIn.readObject();
		objIn.close();
	return obj;
}


}
