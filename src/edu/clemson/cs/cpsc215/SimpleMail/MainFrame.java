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
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class MainFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JTable table;
	private JMenuBar system;
	private JMenu file, config, help;
	private JMenuItem exit, compose, configure, about;
	private JPanel base, layer;
	private JButton add, edit, delete;
	private MainFrameMediator mfm;

	/**
	 * constructs a mainframe object
	 * 
	 * @param SimpleMail
	 */
	public MainFrame(String title) {
		super(title);
		super.setSize(800, 400);
		mfm = new MainFrameMediator();
		setupForm();
		addListeners();
	}

	/**
	 * sets up the form for the MainFrame JFrame
	 */
	private void setupForm() {
		this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);	
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
		edit.setVisible(false);
		delete.setVisible(false);

		system.add(file);
		system.add(config);
		system.add(help);
		super.add(new JScrollPane(table), BorderLayout.CENTER);
		super.add(system, BorderLayout.PAGE_START);
		layer.add(add, BorderLayout.LINE_START);
		layer.add(edit, BorderLayout.CENTER);
		layer.add(delete, BorderLayout.LINE_END);
		base.add(layer, BorderLayout.PAGE_END);
		super.add(base, BorderLayout.PAGE_END);
	}

	/**
	 * adds listeners to the MainFram JFrame for related functionality
	 */
	private void addListeners() {
		table.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				int loc = table.getSelectedRow();
				if (loc != -1) {
					edit.setVisible(true);
					delete.setVisible(true);
				}
				mfm.table(e, loc);
			}
		});

		add.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				mfm.add();
			}
		});

		compose.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				mfm.compose();
			}
		});

		edit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int loc = table.getSelectedRow();
				mfm.edit(loc);
			}

		});

		configure.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				mfm.configure();
			}
		});

		exit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				mfm.exit();
				System.exit(0);
				
			}
		});

		about.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				mfm.about();
			}
		});

		delete.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int row = table.getSelectedRow();
				mfm.delete(row);
			}
		});
				
			
			this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent evt) {
				mfm.close();
				dispose();
			}
		});
	}
	
	public static void main(String [] args) {
		
		MainFrame test = new MainFrame("SimpleMail");
		test.setVisible(true);
	}

}