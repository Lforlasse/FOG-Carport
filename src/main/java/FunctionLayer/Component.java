package FunctionLayer;

public class Component {

    private int compId;
    private String compDesc;
    private int vendorPrice;
    private int SalesPrice;

    public Component(int compId, String compDesc, int vendorPrice, int salesPrice) {
        this.compId = compId;
        this.compDesc = compDesc;
        this.vendorPrice = vendorPrice;
        SalesPrice = salesPrice;
    }

    public Component() {
    }

}//class