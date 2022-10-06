import java.util.Scanner;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        //Files: "Stores.txt", "Products.txt", "Transactions.txt";
        Scanner scnr = new Scanner(System.in);

        try {
            File storeFile = new File("Stores.txt");
            File productFile = new File("Products.txt");
            File transactionFile = new File("Transactions.txt");
            //Creating three files for the 'database system', provided they don't already exist
            if(storeFile.createNewFile() == true)
                System.out.println("File for store database successfully created.");
            if(productFile.createNewFile() == true)
                System.out.println("File for product database successfully created.");
            if(transactionFile.createNewFile() == true)
                System.out.println("Fire for transaction database successfully created.");
        } catch (IOException e) {
            System.out.println("An error has occurred.");
            e.printStackTrace();
        }

        String menuList = ("s - Add a store to the franchise" + "\n" +
        "p - Add a new product to inventory" + "\n" +
        "t - Initiate a transaction" + "\n" +
        "r - View reporting" + "\n" +
        "q - Quit program");
        System.out.println(menuList);
        String clrScnr;

        StockManager stockManager = new StockManager();
        TransactionsManager transactionManager = new TransactionsManager();
        ReportsManager reportManager = new ReportsManager();

        //start of switch loop
        //s - store, p - product, t - transaction, r - reporting, q - quit
        boolean quitProgram = false;
        do {
            System.out.println("What would you like to do?");
            char input = scnr.next().charAt(0);

            switch(input) {
                case('s'): clrScnr = scnr.nextLine();
                System.out.println("Enter the store's name:");
                Store newStore = new Store();
                newStore.setStoreName(scnr.nextLine());
                System.out.println("Enter the store's ID:");
                newStore.setStoreID(scnr.nextInt());
                clrScnr = scnr.nextLine();
                System.out.println("Enter the store's address:");
                newStore.setStoreAddress(scnr.nextLine());
                //StockManager as Store
                System.out.println("Adding store " + newStore.getStoreName() + " at " + 
                newStore.getStoreAddress() + ", ID: " + newStore.getStoreID() + ", to the database of stores.");
                stockManager.storeDatabaseAdd(newStore);
                System.out.println(menuList);
                break;

                case('p'): clrScnr = scnr.nextLine();
                System.out.println("Enter the product's name:");
                Product newProduct = new Product();
                newProduct.setProductName(scnr.nextLine());
                System.out.println("Enter the product's ID:");
                newProduct.setProductID(scnr.nextInt());
                clrScnr = scnr.nextLine();
                System.out.println("Enter the number of items this product will have in stock:");
                newProduct.setNumOfItems(scnr.nextInt());
                //StockManager as Product
                System.out.println("Adding item " + newProduct.getProductName() + ", ID: " +
                newProduct.getProductID() + ", with a stock of: " + newProduct.getNumOfItems());
                stockManager.productDatabaseAdd(newProduct);
                System.out.println(menuList);
                break;

                case('r'): clrScnr = scnr.nextLine();
                System.out.println("Choose a type of reporting from the following list:");
                System.out.println("1 - A report of all incoming and outgoing transactions" + "\n" + 
                "2 - Reporting the transactions for a specific store" + "\n" + 
                "3 - A report for all items in inventory");
                //Report newReport = new Report();
                int reportingInput = scnr.nextInt();
                clrScnr = scnr.nextLine();
                if(reportingInput == 1) {
                    //ReportManager as reporting for incoming and outgoing transactions
                    System.out.println("Select '1' to view incoming reports or '2' to view outgoing reports.");
                    int incOutType = scnr.nextInt();
                    clrScnr = scnr.nextLine();
                    if (incOutType == 1) {
                        String reportType = "Incoming Transaction";
                        reportManager.generateReport(reportingInput, "Transactions.txt", "none", reportType);
                    }
                    else if (incOutType == 2) {
                        String reportType = "Outgoing Transaction";
                        reportManager.generateReport(reportingInput, "Transactions.txt", "none", reportType);
                    }
                    else {
                        break;
                    }
                }
                else if(reportingInput == 2) {
                    System.out.println("What is the name of the store you would like to see the transactions of?");
                    String storeName = scnr.nextLine();
                    //ReportManager as reporting for a specific store
                    reportManager.generateReport(reportingInput, "Transactions.txt", storeName, "none");
                }
                else if(reportingInput == 3) {
                    //ReportManager as a report for all items in inventory
                    reportManager.generateReport(reportingInput, "Products.txt", "none", "none");
                    System.out.println();
                }
                else {
                    break;
                }
                System.out.println(menuList);
                break;

                case('t'): clrScnr = scnr.nextLine();
                System.out.println("Please set the ID for this transaction:");
                Transaction newTransaction = new Transaction();
                newTransaction.setTransactionID(scnr.nextInt());
                clrScnr = scnr.nextLine();
                LocalDate date = LocalDate.now();
                newTransaction.setTransactionDate(date);
                System.out.println("What transaction would you like to make?:" + "\n" +
                "1 - An incoming transaction" + "\n" +
                "2 - An outgoing transaction");
                int transactionInput = scnr.nextInt();
                if(transactionInput == 1) {
                    //TransactionManager => IncomingTransaction
                    //Temporary append to file testing
                    //Would ideally be ran from IncomingTransaction to add store/product as well
                    transactionManager.appendToFile(newTransaction, 1);
                    //System.out.println();
                }
                else if(transactionInput == 2) {
                    //TransactionManager => OutgoingTransaction
                    //Temporary append to file testing
                    //Would ideally be ran from OutgoingTransaction to add store/product as well
                    transactionManager.appendToFile(newTransaction, 2);
                    //System.out.println();
                }
                else {
                    break;
                }
                System.out.println(menuList);
                break;

                case('q'): System.out.println();
                quitProgram = true;
                break;

                default:
                    break;
            }
        } while(quitProgram != true);
    }
}
