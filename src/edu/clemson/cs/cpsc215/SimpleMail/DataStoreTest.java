//Parker Davis (parkerd), Peter Schatteman (prschat), Phillip Schneider (pschnei)
//Last Modified: Apr 28 2014
//Assignment 4: SimpleMail
//This file contains the DataStore JUnit test class and associated methods

package edu.clemson.cs.cpsc215.SimpleMail;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

public class DataStoreTest {
	private DataStore singleton;
	private Configuration config;
	private ArrayList<Contact> contacts;

	@Before
	public void setUp() throws Exception {
		singleton = DataStore.getDataStore();
		config = singleton.getConfig();
		contacts = singleton.getContactList();
	}

	@Test
	public void testDataStore() {
		assertEquals(singleton.getConfig(), config);
		assertEquals(singleton, DataStore.getDataStore());
		assertNotEquals(singleton, null);
	}

	@Test
	public void testContactList() {
		assertNotEquals(contacts, null);
		assertEquals(singleton.getContactList(), contacts);
		assertEquals(DataStore.getDataStore().getContactList(), contacts);
	}

	@Test
	public void testGetConfig() {
		assertNotEquals(config, null);
		assertEquals(singleton.getConfig(), config);
		assertEquals(DataStore.getDataStore().getConfig(), config);
	}

	@Test
	public void testSerialization() {
		String beforeConfig = config.getEmail();
		int numbefore = contacts.size();
		singleton.saveData();
		singleton.loadData();
		assertEquals(singleton.getConfig().getEmail(), beforeConfig);
		assertEquals(singleton.getContactList().size(), 2*numbefore);
	}

	@Test
	public void testContact() {
		int numbefore = contacts.size();
		Contact bob = new Contact("Bob", "Bob@gmail.com");
		singleton.getContactList().add(bob);
		assertEquals(numbefore+1, contacts.size());
		singleton.getContactList().remove(bob);
		assertEquals(numbefore, singleton.getContactList().size());
	}

	@Test
	public void testGetColumnCount() {
		assertEquals(4, singleton.getColumnCount());
	}

	@Test
	public void testGetRowCount() {
		int numbefore = contacts.size();
		assertEquals(contacts.size(), numbefore);
		contacts.add(new Contact());
		assertEquals(contacts.size(), numbefore+1);
	}

}
