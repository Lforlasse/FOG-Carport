package FunctionLayer;

public class RoofUnit {

    private int unitId;
    private String unitDesc;
    private String unitInfo;
    private int unitLength;
    private int unitWidth;
    private int vendorPrice;
    private int salesPrice;

    public RoofUnit(int unitId, String unitDesc, int unitLength, int unitWidth, int vendorPrice, int salesPrice){

        this.unitId = unitId;
        this.unitDesc = unitDesc;
        this.unitInfo = "-";
        this.unitLength = unitLength;
        this.unitWidth = unitWidth;
        this.vendorPrice = vendorPrice;
        this.salesPrice = salesPrice;
    }//constructor

    public int getUnitId() {
        return unitId;
    }

    public void setUnitId(int unitId) {
        this.unitId = unitId;
    }

    public String getUnitDesc() {
        return unitDesc;
    }

    public void setUnitDesc(String unitDesc) {
        this.unitDesc = unitDesc;
    }

    public String getUnitInfo() {
        return unitInfo;
    }

    public void setUnitInfo(String unitInfo) {
        this.unitInfo = unitInfo;
    }

    public int getUnitLength() {
        return unitLength;
    }

    public void setUnitLength(int unitLength) {
        this.unitLength = unitLength;
    }

    public int getUnitWidth() {
        return unitWidth;
    }

    public void setUnitWidth(int unitWidth) {
        this.unitWidth = unitWidth;
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
