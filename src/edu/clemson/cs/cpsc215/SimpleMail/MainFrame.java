//Parker Davis (parkerd), Peter Schatteman (prschat), Phillip Schneider (pschnei)
//Last Modified: Apr 27 2014
//Assignment 4: SimpleMail
//This file contains the MainFrame class and associated methods
package edu.clemson.cs.cpsc215.SimpleMail;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JPanel;
import javax.swing.JTable;//

public class MainFrame extends JFrame {

	private static final long serialVersionUID = 1701901772098877485L;

	public MainFrame(String title) {
		super(title);
		super.setSize(800, 800);

		JTable table = new JTable(DataStore.getDataStore());
		JMenuBar system = new JMenuBar();
		JMenu File = new JMenu("File");
		JMenu Config = new JMenu("Config");
		JMenu Help = new JMenu("Help");
		JPanel base = new JPanel();
		JButton add = new JButton("Add");
		JButton edit = new JButton("Edit");
		JButton Delete = new JButton("Delete");
		system.add(File);
		system.add(Config);
		system.add(Help);
		base.add(system);
		base.add(table);
		base.add(add);
		base.add(edit);
		base.add(Delete);
		super.add(base);
	}

}
