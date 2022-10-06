
import java.util.*;

/**
 Outgoing transactions: Send items to the stores 
 through either the command line or a file.
(ID, Type, Date, ProductID, Number of Items, StoreID)
 */
public class OutgoingTransaction extends Transaction {
    private Store store;

    public OutgoingTransaction() {
        
    }

    public void updateProductStock() {
        System.out.println("Outgoing Transaction Menu\n Enter 1 to send items using command line.\nEnter 2 to send items using a file.");
        Scanner scnr = new Scanner(System.in);
        int userOption = scnr.nextInt();
        Store store = new Store();
         
        if(userOption == 2) {
            System.out.println("Enter file name.");
            String file = scnr.nextLine();
            String line;
             
            Scanner fileScan = new Scanner(new File(file));
            fileScan.useDelimiter(",");
            while(fileScan.hasNext()) {
                int ID = (int)fileScan.next();
                Product p = (Product)fileScan.next();
                Date d = (Date)fileScan.next();
                p.setProductID((int)fileScan.next());
                p.setNumOfItems((int)fileScan.next());
                store.setStoreID = (int)fileScan.next();
                
                Transaction(ID, d, productList.put(p));
                //TODO: Save file content to correct methods (ID, Type, Date, ProductID, Number of Items)
            }
        }
        else if(userOption == 1) {
            System.out.println("Enter Transaction ID: ");
            ID = scnr.nextInt();
            System.out.println("Enter product: ");
            p = (Product)scnr.nextLine();
            System.out.println("Enter date: ");
            d = (Date)scnr.nextLine();
            System.out.println("Enter product ID: ");
            p.setProductID(scnr.nextInt());
            System.out.println("Enter number of items for product: ");
            p.setNumOfItems(scnr.nextInt());
            System.out.println("Enter store ID: ");
            store.setStoreID = scnr.nextInt();

            Transaction(ID, d, productList.put(p));
        }
        else
        System.out.println("Enter a valid option. Either 1 or 2.");
    }

}
