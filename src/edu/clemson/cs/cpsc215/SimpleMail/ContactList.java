package edu.clemson.cs.cpsc215.SimpleMail;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class ContactList {
	//most of this I wrote in DataStore now, I'm not sure to what extent this class is needed, I won't delete
	//things from it now though

	private ArrayList<Contact> plist;
	
	@SuppressWarnings("unchecked")
	public ContactList() {
		// Read from disk using FileInputStream
		FileInputStream f_in;
		try {
			f_in = new FileInputStream("contacts.data");

			// Read object using ObjectInputStream
			ObjectInputStream obj_in = new ObjectInputStream(f_in);

			// Read an object
			Object obj = obj_in.readObject();

			if (obj instanceof ArrayList<?>) {
				// Cast object to a Vector
				plist = (ArrayList<Contact>) obj;

				//Load list of people from file if such file exists
			}
			f_in.close();
		} catch (FileNotFoundException e) {
		} catch (IOException e1) {
		} catch (ClassNotFoundException e2) {
		}
		if(plist == null)
			plist = new ArrayList<Contact>();

	}

	public void write() {
		try {
			// Write to disk with FileOutputStream
			FileOutputStream f_out = new FileOutputStream("contacts.data");

			// Write object with ObjectOutputStream
			ObjectOutputStream obj_out = new ObjectOutputStream(f_out);

			// Write object out to disk
			obj_out.writeObject(plist);
			obj_out.close();
		} catch (IOException e) {
			System.out
					.println("Could not store contact information.");
		}
	}

	public Object getValueAt(int arg0, int arg1) {
		Object ret = null;
		switch (arg1) {
		case 0:
			ret = plist.get(arg0).getName();
			break;
		case 1:
			ret = plist.get(arg0).getPost();
			break;
		case 2:
			ret = plist.get(arg0).getPhone();
			break;
		case 3:
			ret = plist.get(arg0).getEmail();
			break;
		}
		return ret;
	}

	public Contact getPerson(int place) {
		return plist.get(place);
	}

	public void add(Contact gnu) {
		plist.add(gnu);

	}

	public void remove(int auld) {
		plist.remove(auld);
	}

}
