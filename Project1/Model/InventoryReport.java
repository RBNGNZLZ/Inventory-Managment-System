
import java.util.*;
import java.io.*;

public class InventoryReport {

    public InventoryReport() {
    }
    public static void printInventoryReport() {
        String line = "";
        System.out.println("Generating all items entered report.");
        try {
        File file = new File("Products.txt");
        BufferedReader br = new BufferedReader(new FileReader(file));

        while((line = br.readLine()) != null) {
            System.out.println(line);
        }
        br.close();
        }
        catch(IOException ex) {
            
        System.out.println("Error reading file named Products.txt");
        }
    }

}
