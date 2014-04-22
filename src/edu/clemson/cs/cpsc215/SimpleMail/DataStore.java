package edu.clemson.cs.cpsc215.SimpleMail;

import java.util.ArrayList;

public class DataStore {
	private DataStore toSelf = new DataStore();
	private ArrayList<Contact> contactList = new ArrayList<Contact>();

	private DataStore() {

	}

	public DataStore getDataStore() {
		return toSelf;
	}

	public ArrayList<Contact> getContactList() {
		return contactList;
	}

	public void setContactList(ArrayList<Contact> contactList) {
		this.contactList = contactList;
	}

}
