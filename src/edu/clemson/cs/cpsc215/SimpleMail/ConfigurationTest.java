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
		alpha.setSmtpServ("173.244.213.68");
	}

	@Test
	public void testMail() {
		assertEquals(alpha.getMail(), "prschat@g.clemson.edu");
		assertEquals(omega3.getMail(), null);
		omega3.setMail("name@gmail.com");
		assertEquals("name@gmail.com", omega3.getMail());
	}

	@Test
	public void testSmtpServ() {
		assertEquals(alpha.getSmtpServ(), "173.244.213.68");
		assertEquals(omega3.getSmtpServ(), null);
		omega3.setSmtpServ("173.244.569.78");
		assertEquals("173.244.569.78", omega3.getSmtpServ());
	}

}
