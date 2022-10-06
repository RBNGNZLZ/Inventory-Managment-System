package main;

import java.util.Scanner;

import main.util.ReportInput;
import main.util.StockInput;
import main.util.TransactionInput;
import stocks.StockManager;
import transactions.IncomingTransaction;
import transactions.OutgoingTransaction;
import transactions.TransactionsManager;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.border.TitledBorder;


/**
 * 
 */
public class Main
{
	/**
	 * Manages the data for stores and products in the system.
	 */
	public StockManager systemInventory;

	/**
	 * Manages transactions in the system.
	 */
	public TransactionsManager transactionsManager;

	private Main()
	{
		systemInventory = new StockManager();
		transactionsManager = new TransactionsManager(systemInventory);
	}

	public static void main(String args[]) throws Exception
	{
		Main main = new Main();
		main.runInputLoop();
	}

	/**
	 * Runs the basic program loop for interacting with the system.
	 */
	public void runInputLoop()
	{
		//outputField.setText("Test.");
		//outputField.setEditable(false);
		//topFrame.setVisible(true);

		createWindow();

		Scanner sc = new Scanner(System.in);

		String input = "";
		while (!input.equals("x"))
		{
			printMenu();
			System.out.print("Input an action: ");
			input = sc.nextLine();

			if (input.equals("p"))
				//systemInventory.addProduct(StockInput.doNewProductInput(sc)); 
			 if (input.equals("s"))
				//systemInventory.addStore(StockInput.doNewStoreInput(sc));
			 if (input.equals("i"))
			{
				/*IncomingTransaction it = TransactionInput.doNewIncomingTransaction(sc, systemInventory);
				transactionsManager.addTransaction(it);
				systemInventory.saveUpdatedStock();*/
			} else if (input.equals("o"))
			{
				/*OutgoingTransaction ot = TransactionInput.doNewOutgoingTransaction(sc, systemInventory);
				transactionsManager.addTransaction(ot);
				systemInventory.saveUpdatedStock();*/
			} else if (input.equals("r"))
			{
				//ReportInput.getReportDetails(sc, systemInventory, transactionsManager);
			} else if (input.equals("x"))
				;
			else
			{
				System.out.println("Invalid input.");
			}
		}
		System.out.println("Exiting program...");
	}

	/**
	 * Prints menu of possible actions, convenience method used by {@link #runInputLoop()}.
	 */
	private void printMenu()
	{
		System.out.println("\n\nInventory Management System Menu");
		System.out.println("--------------------------------");
		System.out.println("p: Add Product");
		System.out.println("s: Add Store");
		System.out.println("i: Perform Incoming Transaction");
		System.out.println("o: Perform Outgoing Transaction");
		System.out.println("r: Generate Reports");
		System.out.println("x: Exit Program");

		System.out.println();
	}

	private void createWindow() {
		JFrame frame = new JFrame("Inventory Management System");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		createUI(frame);
		frame.setSize(550, 400);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}

	private void createUI(final JFrame frame) {
		JPanel panel = new JPanel();
		LayoutManager layout = new FlowLayout();
		panel.setLayout(layout);
		
		TitledBorder border = new TitledBorder("Inventory Management System Menu");
	    border.setTitleJustification(TitledBorder.CENTER);
	    border.setTitlePosition(TitledBorder.TOP);
	    border.setTitleFont(new Font("Serif", Font.BOLD, 20));
	    panel.setBorder(border);

		JButton b1 = new JButton("Add Product");
		JButton b2 = new JButton("Add Store");
		JButton b3 = new JButton("Perform Incoming Transaction");
		JButton b4 = new JButton("Perform Outgoing Transaction");
		JButton b5 = new JButton("Generate Reports");
		JButton b6 = new JButton("Exit");

		
		final JLabel label = new JLabel();

		b1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String product = (String)JOptionPane.showInputDialog(frame, "What product would you like to add?", "Product Add", JOptionPane.PLAIN_MESSAGE, null, null, null);
				if(product != null && product.length() > 0) {
					systemInventory.addProduct(StockInput.doNewProductInput(product, frame));					
					label.setText("Product to be entered " + product);
				}
				else {
					label.setText("None selected");
				}
			}
			
		});
		
		b2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String store = (String)JOptionPane.showInputDialog(frame, "What store would you like to add?", "Store Add", JOptionPane.PLAIN_MESSAGE, null, null, null);
				if(store != null && store.length() > 0) {
					systemInventory.addStore(StockInput.doNewStoreInput(store, frame));					
					label.setText("Store to be entered " + store);
				}
				else {
					label.setText("None selected");
				}
			}
			
		});
		
		b6.addActionListener(new ActionListener() {
			@Override 
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
			
		});
		
		panel.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.insets = new Insets(5, 0, 5, 0);
		gbc.gridwidth = GridBagConstraints.REMAINDER;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		
		panel.add(b1, gbc);
		panel.add(b2, gbc);
		panel.add(b3, gbc);
		panel.add(b4, gbc);
		panel.add(b5, gbc);
		panel.add(b6, gbc);
		
		panel.add(label);
		frame.getContentPane().add(panel, BorderLayout.CENTER);
	}
}
