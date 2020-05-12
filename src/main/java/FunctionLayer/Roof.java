package FunctionLayer;

public class Roof {

    int roofHeight;
    String materiale;
    int inclination;


    public Roof(int roofHeight, String materiale, int inclination) {
        this.roofHeight = roofHeight;
        this.materiale = materiale;
        this.inclination = inclination;
    }


    //Getter & Setter
    public int getRoofHeight() {
        return roofHeight;
    }

    public void setRoofHeight(int roofHeight) {
        this.roofHeight = roofHeight;
    }

    public String getMateriale() {
        return materiale;
    }

    public void setMateriale(String materiale) {
        this.materiale = materiale;
    }

    public int getInclination() {
        return inclination;
    }

    public void setInclination(int inclination) {
        this.inclination = inclination;
    }
}
