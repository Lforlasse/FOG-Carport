package FunctionLayer;

public class Roof {

    int roofHeight;
    String material;
    int inclination;
    int maxLengthComponent;
    int sideC;



    public Roof(int inclination, String material, int width) {
        this.material = material;
        this.inclination = inclination;
        this.sideC = calcSideC(inclination, width);
        this.maxLengthComponent = 400;
    }

    public Roof() {
    }

    private int calcSideC(int inclination, int width) {

        double dWidth = width/2;
        double dInclination = 90-inclination;
        double dCornerC = Math.toRadians(90);
        dCornerC = Math.sin(dCornerC);

        dInclination = Math.toRadians(dInclination);
        dInclination = Math.sin(dInclination);

        dWidth /= dInclination * dCornerC;

        int res = toInt(dWidth);

        return res;
    }//calcSideC

    private int toInt(double d){
        d = Math.round(d);
        String s = ""+d;
        s = s.substring(0,s.length()-2);
        int i = Integer.parseInt(s);
        return i;
    }//toDouble

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
        return inclination;
    }

    public void setRoofInclination(int roofInclination) {
        this.inclination = roofInclination;
    }

    public int getSideC() {
        return sideC;
    }

    public void setSideC(int sideC) {
        this.sideC = sideC;
    }
}
