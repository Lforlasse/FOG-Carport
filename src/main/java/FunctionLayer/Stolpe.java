package FunctionLayer;

public class Stolpe {

    int price;
    int lengthCM;
    String treeMaterial;
    String stolper;

    public Stolpe(int price, int lengthCM, String treeMaterial, String stolper) {
        this.price = price;
        this.lengthCM = lengthCM;
        this.treeMaterial = treeMaterial;
        this.stolper = stolper;
    }

    public Stolpe() {

    }

    //Getter & Setter
    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getLengthCM() {
        return lengthCM;
    }

    public void setLengthCM(int lengthCM) {
        this.lengthCM = lengthCM;
    }

    public String getTreeMaterial() {
        return treeMaterial;
    }

    public void setTreeMaterial(String treeMaterial) {
        this.treeMaterial = treeMaterial;
    }

    public String getStolper() {
        return stolper;
    }

    public void setStolper(String stolper) {
        this.stolper = stolper;
    }


}//class
