//Parker Davis (parkerd), Peter Schatteman (prschat), Phillip Schneider (pschnei)
//Last Modified: Apr 28 2014
//Assignment 4: SimpleMail
//This file contains the MainFrame class and associated methods
package edu.clemson.cs.cpsc215.SimpleMail;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTable;//

public class MainFrame extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 5579764837969697449L;
	private JTable table;
	private JMenuBar system;
	private JMenu file, config, help;
	private JMenuItem exit, compose, configure, test, about;
	private JPanel base, layer;
	private JButton add, edit, delete;

	public MainFrame(String title) {
		super(title);
		super.setSize(800, 400);

		table = new JTable(DataStore.getDataStore());
		file = new JMenu("File");
		system = new JMenuBar();
		file.add(exit = new JMenuItem("Exit"));
		file.add(compose = new JMenuItem("Compose Mail"));
		config = new JMenu("Config");
		config.add(configure = new JMenuItem("Configure"));
		config.add(test = new JMenuItem("Test"));
		help = new JMenu("Help");
		help.add(about = new JMenuItem("About"));
		base = new JPanel();
		layer = new JPanel();

		base.setLayout(new BorderLayout());
		layer.setLayout(new BorderLayout());
		add = new JButton("Add");
		edit = new JButton("Edit");
		delete = new JButton("Delete");

		add.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				ContactEditingDlg newContact = new ContactEditingDlg();
			}

		});
		delete.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO: delete contact
				
				//DataStore.getDataStore().getContactList().remove(index);
			}

		});

		compose.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				EmailTransmissionDlg newMail = new EmailTransmissionDlg();
			}

		});

		edit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				ContactEditingDlg editContact = new ContactEditingDlg();
			}

		});
		
		
		configure.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				ConfigurationDlg editConfig = new ConfigurationDlg();
			}

		});
		
		about.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				SystemInformationDlg info = new SystemInformationDlg();
			}

		});

		exit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
			}

		});

		system.add(file);
		system.add(config);
		system.add(help);

		base.add(system, BorderLayout.PAGE_START);
		base.add(table, BorderLayout.CENTER);
		layer.add(add, BorderLayout.LINE_START);
		layer.add(edit, BorderLayout.CENTER);
		layer.add(delete, BorderLayout.LINE_END);
		base.add(layer, BorderLayout.PAGE_END);
		super.add(base);
	}
}