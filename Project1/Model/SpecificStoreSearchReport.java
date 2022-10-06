
import java.util.*;
import java.io.*;

public class SpecificStoreSearchReport {

    /**
/**
 * Items, that are available in the inventory.
Items entered in the inventory.
Items sent to the stores (all or for one store)
 */     
    public SpecificStoreSearchReport() {
    }

    public static void printSpecificStoreSearchReport() {
        Scanner scnr = new Scanner(System.in);
        int userInput = 0;

        System.out.println("Enter 1 for all stores, or 2 to search.");
        userInput = scnr.nextInt();

        if(userInput == 1) {
            System.out.println("Generating store report.");
            String line = "";
            try {
                File file = new File("Stores.txt");
                BufferedReader br = new BufferedReader(new FileReader(file));
                while((line = br.readLine()) != null) {
                    System.out.println(line);
                    }
                    br.close();
                    }
                    catch(IOException ex) {
                        System.out.println("Error reading file named Stores.txt");
                    }
 
        }
        else if(userInput == 2) {
            System.out.println("Enter store ID to locate store.");
            userInput = scnr.nextInt();

            try {
                File file = new File("Stores.txt");
                Scanner fileScanner = new Scanner(new FileInputStream("Stores.txt"));
                fileScanner.useDelimiter("|");
                while(fileScanner.hasNextInt()) {
                    if(userInput == fileScanner.nextInt()) {
                        System.out.println("Match found! Generating specific store report.");
                        System.out.println(fileScanner.nextLine());
                    }
                }
                fileScanner.close();
                }
                catch(IOException ex) {
                    System.out.println("Error reading file named Stores.txt");
                }

        }
        else 
        System.out.println("Store ID not found.");
    }
}
