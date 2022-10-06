public class Product {
    private int ID;
    private String name;
    private int numOfItems;

    /**
     * Default constructor
     */
    public Product() {
        ID = 0;
        name = "None";
        numOfItems = 0;
    }

    public Product(int ID, String name, int numOfItems) {
        this.ID = ID;
        this.name = name;
        this.numOfItems = numOfItems;
    }

    public void setProductID(int ID) {
        this.ID = ID;
    }

    public int getProductID() {
        return ID;
    }

    public void setProductName(String name) {
        this.name = name;
    }

    public String getProductName() {
        return name;
    }

    public void setNumOfItems(int numOfItems) {
        this.numOfItems = numOfItems;
    }

    public int getNumOfItems() {
        return numOfItems;
    }
}