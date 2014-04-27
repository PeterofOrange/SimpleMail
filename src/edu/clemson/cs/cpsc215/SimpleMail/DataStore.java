package edu.clemson.cs.cpsc215.SimpleMail;

import java.util.ArrayList;

public class DataStore {
	private DataStore toSelf = new DataStore();
	private ArrayList<Contact> contacts = new ArrayList<Contact>();
	private Configuration config;

	private DataStore() {
		
	}

	public DataStore getDataStore() {
		return toSelf;
	}

	public ArrayList<Contact> getContactList() {
		return contacts;
	}

	public void setContactList(ArrayList<Contact> contactList) {
		this.contacts = contactList;
	}
	
	public void loadData(){
		loadContacts();
	}
	
	public void loadContacts(){
		
	}

	public Configuration getConfig() {
		return config;
	}

	public void setConfig(Configuration config) {
		this.config = config;
	}

}
