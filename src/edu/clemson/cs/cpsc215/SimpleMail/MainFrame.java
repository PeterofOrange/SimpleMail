//Parker Davis (parkerd), Peter Schatteman (prschat), Phillip Schneider (pschnei)
//Last Modified: Apr 28 2014
//Assignment 4: SimpleMail
//This file contains the MainFrame class and associated methods
package edu.clemson.cs.cpsc215.SimpleMail;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;


public class MainFrame extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int selected;
	private JTable table;
	private JMenuBar system;
	private JMenu file, config, help;
	private JMenuItem exit, compose, configure, about;
	private JPanel base, layer;
	private JButton add, edit, delete;
	/**
	 * constructs a mainframe object
	 * @param SimpleMail
	 */
	public MainFrame(String title) {
		super(title);	
		super.setSize(800, 400);
                
		table = new JTable(DataStore.getDataStore());
		file = new JMenu("File");
		system = new JMenuBar();
		file.add(exit = new JMenuItem("Exit"));
		file.add(compose = new JMenuItem("Compose Mail"));
		config = new JMenu("Configuration");
		config.add(configure = new JMenuItem("Configure"));
		help = new JMenu("Help");
		help.add(about = new JMenuItem("About"));
		base = new JPanel();
		layer = new JPanel();
		setLayout(new BorderLayout());
		base.setLayout(new BorderLayout());
		layer.setLayout(new BorderLayout());
		add = new JButton("Add");
		edit = new JButton("Edit");
		delete = new JButton("Delete");
		
		table.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e)
			{
				//System.out.println("got mouse click:" + e.getClickCount());
				if (e.getClickCount() == 2 && !e.isConsumed()) {
					e.consume();
					int loc = table.getSelectedRow();
					EmailTransmissionDlg newMail = new EmailTransmissionDlg(loc);
				}
			}
		});
		
		add.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ContactEditingDlg newContact = new ContactEditingDlg(-1);
			}
		});

		compose.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				EmailTransmissionDlg newMail = new EmailTransmissionDlg(-1);
			}
		});

		edit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int loc = table.getSelectedRow();
				ContactEditingDlg editContact = new ContactEditingDlg(loc);
			}

		});

		
		configure.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ConfigurationDlg editConfig = new ConfigurationDlg();	
			}

		});
		
		
		exit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
			}

		});
		
		about.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				SystemInformationDlg info = new SystemInformationDlg();
			}

		});
		
	delete.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ArrayList<Contact> contacts = DataStore.getDataStore().getContactList();
				Contact contact = new Contact();
				if (contacts.size() > 0)
					contact = (Contact) contacts.get(table.getSelectedRow());
				
				selected = JOptionPane.showConfirmDialog(layer, "Are you sure you want to delete " + contact.getName() + "?");
				if(selected == 0) {
					contacts.remove(table.getSelectedRow());
					DataStore.getDataStore().setContactList(contacts);
					DataStore.getDataStore().fireTableRowsInserted(0, DataStore.getDataStore().getRowCount());
				}
			}
	});
	
		system.add(file);
		system.add(config);
		system.add(help);
		super.add(new JScrollPane(table), BorderLayout.CENTER);
		super.add(system, BorderLayout.PAGE_START);
		layer.add(add, BorderLayout.LINE_START);
		layer.add(edit, BorderLayout.CENTER);
		layer.add(delete, BorderLayout.LINE_END);
		base.add(layer, BorderLayout.PAGE_END);
		super.add(base,BorderLayout.PAGE_END);
	}
}