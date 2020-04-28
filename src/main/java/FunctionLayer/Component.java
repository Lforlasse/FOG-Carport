package FunctionLayer;

public class Component {

    private int compId;
    private String compDesc;
    private String material;
    private int vendorPrice;
    private int salesPrice;
    private int compLength;

    public Component(int compId, String compDesc, String material, int compLength, int vendorPrice, int salesPrice) {
        this.compId = compId;
        this.compDesc = compDesc;
        this.material = material;
        this.compLength = compLength;
        this.vendorPrice = vendorPrice;
        this.salesPrice = salesPrice;
    }

    public Component() {
    }

    //Getter & Setter
    public int getCompId() {
        return compId;
    }

    public void setCompId(int compId) {
        this.compId = compId;
    }

    public String getCompDesc() {
        return compDesc;
    }

    public void setCompDesc(String compDesc) {
        this.compDesc = compDesc;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
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

    public int getCompLength() {
        return compLength;
    }

    public void setCompLength(int compLength) {
        this.compLength = compLength;
    }
}//class