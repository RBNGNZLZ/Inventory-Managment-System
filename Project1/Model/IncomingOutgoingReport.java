import java.util.Scanner;
import java.util.ArrayList;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.*;

public class IncomingOutgoingReport {
    int transactionType;
    String fileName;

    public IncomingOutgoingReport() {
    }

    public static void printInOutReport(String fileName, String transactionType) {
        try {
            InputStreamReader ip = new InputStreamReader(System.in);
            BufferedReader br = new BufferedReader(new FileReader(new File("Transactions.txt")));

            String currLine;
            String ID;
            String date;
            String type;
            System.out.println("Searching for " + transactionType + "s");
            while ((currLine = br.readLine()) != null) {
                if(currLine.contains("|")) {
                    currLine = currLine.trim();
                    String[] parts = currLine.split("[|]");
                    ID = parts[0].trim();
                    date = parts[1].trim();
                    type = parts[2].trim();
                    char origCheck = transactionType.charAt(0);
                    char currCheck = type.charAt(0);
                    if(origCheck == currCheck) {
                        System.out.println("Transaction: " + ID + " made on " + date + " as an " + type);
                    }
                }
            }
            br.close();
        } catch (Exception e) {
            System.out.println("There was an issue reading this report from file");
        }

    }
}