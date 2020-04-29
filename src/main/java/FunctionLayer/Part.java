package FunctionLayer;

public class Part {

    private int partsId;
    private String partDescription;
    private String itemType;
    private int currentStock;
    private int vendorPrice;
    private int salesPrice;

    public Part(int partsId, String partDescription, String itemType, int vendorPrice, int salesPrice) {
        this.partsId = partsId;
        this.partDescription = partDescription;
        this.itemType = itemType;
        this.vendorPrice = vendorPrice;
        this.salesPrice = salesPrice;
    }

    public Part() {
    }

    //Getter & Setter
    public int getPartsId() {
        return partsId;
    }

    public void setPartsId(int partsId) {
        this.partsId = partsId;
    }

    public String getPartDescription() {
        return partDescription;
    }

    public void setPartDescription(String partDescription) {
        this.partDescription = partDescription;
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
