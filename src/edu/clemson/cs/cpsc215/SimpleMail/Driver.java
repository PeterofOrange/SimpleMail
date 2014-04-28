//Parker Davis (parkerd), Peter Schatteman (prschat), Phillip Schneider (pschnei)
//Last Modified: Apr 28 2014
//Assignment 4: SimpleMail
//This file contains the Driver class and associated methods
package edu.clemson.cs.cpsc215.SimpleMail;

import java.util.ArrayList;

public class Driver {

	public static void main(String [] args) {
		
		/*ArrayList<Contact> contacts = DataStore.getDataStore().getContactList();
		DataStore.getDataStore().getConfig().setEmail("yates@yates.yates");*/
		//DataStore.getDataStore().getConfig().getEmail();
		
		//Contact guy = new Contact("bill clemson","404 street","536-7778", "bill@yahoo.com");
		//contacts.add(guy);
		
		MainFrame test = new MainFrame("SimpleMail");
		test.setVisible(true);
	}

}
