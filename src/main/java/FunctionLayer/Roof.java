package FunctionLayer;

public class Roof {

    int roofHeight;
    String material;
    int roofInclination;
    int maxLengthComponent;
    int sideC;



    public Roof(int roofInclination, String material) {
        this.material = material;
        this.roofInclination = roofInclination;
        this.sideC = calcSideC();
        this.maxLengthComponent = 400;
    }

    public Roof() {
    }

    public int calcSideC() {

        int res = 0;



        return res;

    }

    //Getter & Setter
    public int getRoofHeight() {
        return roofHeight;
    }

    public void setRoofHeight(int roofHeight) {
        this.roofHeight = roofHeight;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public int getRoofInclination() {
        return roofInclination;
    }

    public void setRoofInclination(int roofInclination) {
        this.roofInclination = roofInclination;
    }

    public int getSideC() {
        return sideC;
    }

    public void setSideC(int sideC) {
        this.sideC = sideC;
    }
}
