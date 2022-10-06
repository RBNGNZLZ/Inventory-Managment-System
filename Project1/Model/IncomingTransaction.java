
import java.io.*;
import java.util.*;
import java.time.LocalDate;
import java.util.Scanner;  

public class IncomingTransaction extends Transaction {

    public IncomingTransaction() {
    }

    public static void updateProductStock(Transaction tr) {
        System.out.println("Incoming Transaction Menu\n Enter 1 to add new items using command line.\nEnter 2 to add new items using a file.");
        Scanner scnr = new Scanner(System.in);
        String s = "";
        int userOption = scnr.nextInt();
        int ID = 0;
        int numItems = 0;
        LocalDate d = LocalDate.now();
         
        if(userOption == 2) {
            System.out.println("Enter file name.");
            String file = scnr.nextLine();
            String line;
            try { 
                Scanner fileScan = new Scanner(new File(file));
                fileScan.useDelimiter(",");
                while(fileScan.hasNext()) {
                    Transaction inTransaction = tr;
                    Product p = new Product();

                    ID = (int)fileScan.nextInt();
                    s = fileScan.next();
                    p.setProductName(s);
                    d = LocalDate.parse(fileScan.next());
                    p.setProductID((int)fileScan.nextInt());
                    p.setNumOfItems((int)fileScan.nextInt());
                }
                } catch (IOException e) {
                    System.out.println("An error occurred.");
                    e.printStackTrace();
                    }
            }
            else if(userOption == 1) {
                Product p = new Product();
                Transaction inTransaction = tr;

                System.out.println("Enter Transaction ID: ");
                ID = scnr.nextInt();
                System.out.println("Enter product: ");
                s = scnr.nextLine();
                p.setProductName(s);
                System.out.println("Enter date: ");
                d = LocalDate.parse(scnr.next());
                System.out.println("Enter product ID: ");
                p.setProductID(scnr.nextInt());
                System.out.println("Enter number of items for product: ");
                numItems = scnr.nextInt();

                inTransaction.setTransactionID(ID);
                inTransaction.addProduct(p, numItems);
                }
                else
                System.out.println("Enter a valid option. Either 1 or 2.");
    }
}
