
import java.time.LocalDate;
import java.util.*;

//Transaction object
public class Transaction {
    private int ID;
    private LocalDate date;
    private ArrayList<Product> productList;

    //Default constructor
    public Transaction() {
        ID = 0;
        date = LocalDate.now();
        productList = new ArrayList<Product>();
    }
    // 
    public Transaction(int ID, LocalDate date, ArrayList<Product> productList) {
        this.ID = ID;
        this.date = date;
        this.productList = productList;
    }

    public void setTransactionID(int ID) {
        this.ID = ID;
    }

    public int getTransactionID() {
        return ID;
    }

    public void setTransactionDate(LocalDate date) {
        this.date = date;
    }

    public LocalDate getTransactionDate() {
        return date;
    }

    public void setTransactionProductList(ArrayList<Product> productList) {
        this.productList = productList;
    }
    
    public ArrayList<Product> getTransactionProductList() {
        return productList;
    }

    public void addProduct(Product pr, int numberOfItems) {
        pr = new Product();
        pr.setNumOfItems(numberOfItems);
        productList.add(pr);
    }

}
