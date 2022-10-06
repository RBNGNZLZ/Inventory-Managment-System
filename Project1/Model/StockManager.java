import java.util.ArrayList;
import java.io.FileWriter;
import java.io.IOException;
import java.io.BufferedWriter;

public class StockManager {
    public StockManager() {
    
    }

    //Writing format: StoreID|StoreName|StoreAddress
    //Separator: |
    public void storeDatabaseAdd(Store newStore) {
        try {
            FileWriter fw = new FileWriter("Stores.txt", true);
            BufferedWriter storeWriter = new BufferedWriter(fw);
            storeWriter.write(newStore.getStoreID() + "|");
            storeWriter.write(newStore.getStoreName() + "|");
            storeWriter.write(newStore.getStoreAddress());
            storeWriter.newLine();
            storeWriter.close();
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    //Writing format: ProductID|ProductName|NumOfItems
    //Separator: |
    public void productDatabaseAdd(Product newProduct) {
        try {
            FileWriter fw = new FileWriter("Products.txt", true);
            BufferedWriter productWriter = new BufferedWriter(fw);
            productWriter.write(newProduct.getProductID() + "|");
            productWriter.write(newProduct.getProductName() + "|");
            productWriter.write(Integer.toString(newProduct.getNumOfItems()));
            productWriter.newLine();
            productWriter.close();
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    private ArrayList<Product> productList = new ArrayList<Product>();
    private ArrayList<Store> storeList = new ArrayList<Store>();

    public void addProduct(Product newProduct) {
        this.productList.add(productList.size(), newProduct);
    }

    public void addStore(Store newStore) {
        this.storeList.add(storeList.size(), newStore);
        }
}