package edu.clemson.cs.cpsc215.SimpleMail;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class DataStoreTest {
	private DataStore singleton;

	@Before
	public void setUp() throws Exception {
		singleton = DataStore.getDataStore();
		
	}

	@Test
	public void testGetDataStore() {
		assert();
		assertEquals(singleton, DataStore.getDataStore());
	}

	@Test
	public void testContactList() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetConfig() {
		fail("Not yet implemented");
	}

	@Test
	public void testLoadData() {
		fail("Not yet implemented");
	}

	@Test
	public void testSaveData() {
		fail("Not yet implemented");
	}

	@Test
	public void testAddContact() {
		fail("Not yet implemented");
	}

	@Test
	public void testRemoveContact() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetColumnCount() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetRowCount() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetValueAt() {
		fail("Not yet implemented");
	}

}
