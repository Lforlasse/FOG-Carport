package FunctionLayer;

public class Roof {

    int roofHeight;
    String material;
    int inclination;
    int maxLengthComponent;
    int sideC;



    public Roof(String material, int inclination) {
        this.material = material;
        this.inclination = inclination;
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

    public int getInclination() {
        return inclination;
    }

    public void setInclination(int inclination) {
        this.inclination = inclination;
    }

    public int getSideC() {
        return sideC;
    }

    public void setSideC(int sideC) {
        this.sideC = sideC;
    }
}
