package edu.clemson.cs.cpsc215.SimpleMail;

import java.util.ArrayList;

public class Driver {

	public static void main(String [] args) {
		
		ArrayList<Contact> contacts = DataStore.getDataStore().getContactList();
		
		Contact guy = new Contact("bill clemson","404 street","536-7778", "bill@yahoo.com");
		contacts.add(guy);
		
		MainFrame test = new MainFrame("SimpleMail");
		test.setVisible(true);
	}

}
