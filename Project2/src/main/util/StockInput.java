package main.util;

import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import stocks.Product;
import stocks.Store;

/**
 * 
 * Used to contain all the command-line input methods for constructing {@link Product} and {@link Store}.
 *
 */
public class StockInput
{

	/**
	 * Constructs a product using a command-line input stream.
	 * 
	 * @param sc
	 *            The active input stream to be used in constructing the Product object, expected to be command-line.
	 * @return A {@link Product} constructed with the data provided by input from sc parameter.
	 */
	public static Product doNewProductInput(String sc, JFrame frame)
	{
		String name = sc;
		while (name.equals("") && !name.contains("|")) { // values cannot contain the | character because that is used in file formatting
			System.out.println("Invalid product name.");
			JOptionPane.showMessageDialog(frame, "Product name may not be empty and cannot contain the character '|'.\\nPlease enter a valid product name.");
			name = (String)JOptionPane.showInputDialog(frame, "What product would you like to add?", "Product Add", JOptionPane.PLAIN_MESSAGE, null, null, null);
		}

				
		int amt = Integer.parseInt((String)JOptionPane.showInputDialog(frame, "Enter product amount.", "Product Amount", JOptionPane.PLAIN_MESSAGE, null, null, null));

		return new Product(name, amt);
	}

	/**
	 * Constructs a store using a command-line input stream.
	 * 
	 * @param sc
	 *            The active input stream to be used in constructing the Store object, expected to be command-line.
	 * @return A {@link Store} constructed with the data provided by input from sc parameter.
	 */
	public static Store doNewStoreInput(String sc, JFrame frame)
	{
		String name = sc;
		while (name.equals("") && !name.contains("|")) {// values cannot contain the | character because that is used in file formatting
			JOptionPane.showMessageDialog(frame, "Store name may not be empty and cannot contain the character '|'.\\nPlease enter a valid store name.");
			name = (String)JOptionPane.showInputDialog(frame, "What store would you like to add?", "Store Add", JOptionPane.PLAIN_MESSAGE, null, null, null);
		}

			
		String addr = (String)JOptionPane.showInputDialog(frame, "Enter store address.", "Store Address", JOptionPane.PLAIN_MESSAGE, null, null, null);
		while (addr.equals("") && !addr.contains("|")) { // values cannot contain the | character because that is used in file formatting
			System.out.println("Invalid store address.");
			JOptionPane.showMessageDialog(frame, "Store address may not be empty and cannot contain the character '|'.\nPlease enter a valid store address:");
			addr = (String)JOptionPane.showInputDialog(frame, "Enter store address.", "Store Address", JOptionPane.PLAIN_MESSAGE, null, null, null);
		}

		return new Store(name, addr);
	}
}
