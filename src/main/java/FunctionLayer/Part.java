package FunctionLayer;

public class Part {

    private int partId;
    private String partDesc;
    private String itemType;
    private int currentStock;
    private int vendorPrice;
    private int salesPrice;

    public Part(int partId, String partDesc, String itemType, int vendorPrice, int salesPrice) {
        this.partId = partId;
        this.partDesc = partDesc;
        this.itemType = itemType;
        this.vendorPrice = vendorPrice;
        this.salesPrice = salesPrice;
    }

    public Part() {
    }

    //Getter & Setter
    public int getPartId() {
        return partId;
    }

    public void setPartId(int partId) {
        this.partId = partId;
    }

    public String getPartDesc() {
        return partDesc;
    }

    public void setPartDesc(String partDesc) {
        this.partDesc = partDesc;
    }

    public String getItemType() {
        return itemType;
    }

    public void setItemType(String itemType) {
        this.itemType = itemType;
    }

    public int getVendorPrice() {
        return vendorPrice;
    }

    public void setVendorPrice(int vendorPrice) {
        this.vendorPrice = vendorPrice;
    }

    public int getSalesPrice() {
        return salesPrice;
    }

    public void setSalesPrice(int salesPrice) {
        this.salesPrice = salesPrice;
    }
}
