//Parker Davis (parkerd), Peter Schatteman (prschat), Phillip Schneider (pschnei)
//Last Modified: Apr 28 2014
//Assignment 4: SimpleMail
//This file contains the Contact test class and associated methods
package edu.clemson.cs.cpsc215.SimpleMail;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 * @author prschat
 * 
 */
public class ContactTest {
	Contact yates;
	Contact other;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		yates = new Contact("Yates", "100 Clemson Drive", "867-5309",
				"jymonte@clemson.edu");// Too lazy to googlestalk);
		other = new Contact("Name", "email@gmail.com");
	}

	@Test
	public void Name() {
		assertEquals(yates.getName(), "Yates");
		yates.setName("Monteith");
		assertEquals(other.getName(), "Name");
		other.setName(yates.getName());
		assertEquals(yates.getName(), other.getName());
		assertEquals(other.getName(), "Monteith");
	}

	@Test
	public void Post() {
		assertEquals(yates.getPost(), "100 Clemson Drive");
		yates.setPost("415 Daniel");
		assertEquals(other.getPost(), null);
		other.setPost(yates.getPost());
		assertEquals(yates.getPost(), other.getPost());
		assertEquals(other.getPost(), "415 Daniel");
	}

	@Test
	public void Phone() {
		assertEquals(yates.getPhone(), "867-5309");
		other.setPhone("0118 999 881 999 119 7253");
		assertEquals(other.getPhone(), "0118 999 881 999 119 7253");
		other.setPhone(yates.getPhone());
		assertEquals(yates.getPhone(), other.getPhone());
		assertEquals(other.getPhone(), "867-5309");
	}

	@Test
	public void Email() {
		assertEquals(yates.getEmail(), "jymonte@clemson.edu");
		assertEquals(other.getEmail(), "email@gmail.com");
		other.setEmail(yates.getEmail());
		assertEquals(yates.getEmail(), other.getEmail());
		assertEquals(other.getEmail(), "jymonte@clemson.edu");
	}

}
