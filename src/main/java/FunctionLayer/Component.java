package FunctionLayer;

public class Component {

    private int compId;
    private String compDesc;
    private String compInfo;
    private String material;
    private int compHeight;
    private int compWidth;
    private int compLength;
    private int vendorPrice;
    private int salesPrice;

    public Component(int compId, String compDesc, String material, int compHeight, int compWidth, int compLength, int vendorPrice, int salesPrice) {
        this.compId = compId;
        this.compDesc = compDesc;
        this.compInfo = "-";
        this.material = material;
        this.compHeight = compHeight;
        this.compWidth = compWidth;
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

    public String getCompInfo() {
        return compInfo;
    }

    public void setCompInfo(String compInfo) {
        this.compInfo = compInfo;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public int getCompHeight() {
        return compHeight;
    }

    public void setCompHeight(int compHeight) {
        this.compHeight = compHeight;
    }

    public int getCompWidth() {
        return compWidth;
    }

    public void setCompWidth(int compWidth) {
        this.compWidth = compWidth;
    }

    public int getCompLength() {
        return compLength;
    }

    public void setCompLength(int compLength) {
        this.compLength = compLength;
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

}//class