import java.util.*;
import java.io.FileWriter;
import java.io.IOException;
import java.io.BufferedWriter;

public class TransactionsManager {
    private String transactionType;

    public TransactionsManager() {
        String fileName = "None";
        String transactionType = "None";
    }

    public void addTransaction(Transaction tr, int transactionType) {
        // Used for Incoming/Outgoing Transaction when implemented
        if(transactionType == 1) {
            IncomingTransaction.updateProductStock(tr);
        }
        //Transaction.IncomingTransaction
        System.out.println();
    }

    public void appendToFile(Transaction transaction, int transactionCheck) {
        // Adding transaction to transaction file for report history
        if(transactionCheck == 1) {
            transactionType = "Incoming Transaction";
        }
        else {
            transactionType = "Outgoing Transaction";
        }

        //Writing format: TransactionID|TransactionDate|TransactionType|Store|Product|StockChange
        //Separator: |
        try {
            FileWriter fw = new FileWriter("Transactions.txt", true);
            BufferedWriter transactionWriter = new BufferedWriter(fw);
            transactionWriter.write(transaction.getTransactionID() + "|");
            transactionWriter.write(transaction.getTransactionDate() + "|");
            transactionWriter.write(transactionType);
            //transactionWriter for Store used in transaction
            //transactionWriter for Product used in transaction
            //transactionwriter for affected Stock
            transactionWriter.newLine();
            transactionWriter.close();
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

}
