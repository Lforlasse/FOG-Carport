package FunctionLayer;

public class Roof{

    int price;
    int heightCM;
    int lengthCM;
    int tilt;
    String rem;
    String spaer;
    String Stern;
    String vandbraet;
    String treeMaterial;

    public Roof(int price, int heightCM, int lengthCM, int tilt, String rem, String spaer,
                String stern, String vandbraet, String treeMaterial) {
        this.price = price;
        this.heightCM = heightCM;
        this.lengthCM = lengthCM;
        this.tilt = tilt;
        this.rem = rem;
        this.spaer = spaer;
        this.Stern = stern;
        this.vandbraet = vandbraet;
        this.treeMaterial = treeMaterial;
    }

    public Roof() {

    }

    //Getter & Setter
    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getHeightCM() {
        return heightCM;
    }

    public void setHeightCM(int heightCM) {
        this.heightCM = heightCM;
    }

    public int getLengthCM() {
        return lengthCM;
    }

    public void setLengthCM(int lengthCM) {
        this.lengthCM = lengthCM;
    }

    public int getTilt() {
        return tilt;
    }

    public void setTilt(int tilt) {
        this.tilt = tilt;
    }

    public String getRem() {
        return rem;
    }

    public void setRem(String rem) {
        this.rem = rem;
    }

    public String getSpaer() {
        return spaer;
    }

    public void setSpaer(String spaer) {
        this.spaer = spaer;
    }

    public String getStern() {
        return Stern;
    }

    public void setStern(String stern) {
        Stern = stern;
    }

    public String getVandbraet() {
        return vandbraet;
    }

    public void setVandbraet(String vandbraet) {
        this.vandbraet = vandbraet;
    }

    public String getTreeMaterial() {
        return treeMaterial;
    }

    public void setTreeMaterial(String treeMaterial) {
        this.treeMaterial = treeMaterial;
    }


}
