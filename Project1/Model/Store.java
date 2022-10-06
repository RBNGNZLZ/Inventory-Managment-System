public class Store {
    private int ID;
    private String name;
    private String address;

    /**
     * Default constructor
     */
    public Store() {
        ID = 0;
        name = "None";
        address = "None";
    }

    public Store(int ID, String name, String address) {
        this.ID = ID;
        this.name = name;
        this.address = address;
    }

    public void setStoreID(int ID) {
        this.ID = ID;
    }

    public int getStoreID() {
        return ID;
    }

    public void setStoreName(String name) {
        this.name = name;
    }

    public String getStoreName() {
        return name;
    }

    public void setStoreAddress(String address) {
        this.address = address;
    }

    public String getStoreAddress() {
        return address;
    }
}