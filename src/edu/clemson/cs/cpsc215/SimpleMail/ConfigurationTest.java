//Parker Davis (parkerd), Peter Schatteman (prschat), Phillip Schneider (pschnei)
//Last Modified: Apr 28 2014
//Assignment 4: SimpleMail
//This file contains the ConfigurationTest test class and associated methods
package edu.clemson.cs.cpsc215.SimpleMail;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class ConfigurationTest {
	private Configuration alpha;
	private Configuration omega3;

	@Before
	public void setUp() throws Exception {
		alpha = new Configuration("prschat@g.clemson.edu");
		omega3 = new Configuration();
		alpha.setServerAddr("173.244.213.68");
	}

	@Test
	public void testMail() {
		assertEquals(alpha.getEmail(), "prschat@g.clemson.edu");
		assertEquals(omega3.getEmail(), null);
		omega3.setEmail("name@gmail.com");
		assertEquals("name@gmail.com", omega3.getEmail());
	}

	@Test
	public void testSmtpServ() {
		assertEquals(alpha.getServerAddr(), "173.244.213.68");
		assertEquals(omega3.getServerAddr(), null);
		omega3.setServerAddr("173.244.569.78");
		assertEquals("173.244.569.78", omega3.getServerAddr());
	}

}