package FunctionLayer;

public class Carport {
    private int heightCM;
    private int lengthCM;
    private int widthCM;
    private String material;
    private boolean carSpace;

    public Carport(int hCM, int lCM, int wCM, String mat){
        this.heightCM = hCM;
        this.lengthCM = lCM;
        this.widthCM = wCM;
        this.material = mat;

        this.carSpace = checkCarSpace();

    }//Carport

    private boolean checkCarSpace(){
        boolean result = true;

        if (this.heightCM < 1 /*Hent tal fra DB*/){
            result = false;
        }
        if (this.lengthCM < 1 /*Hent tal fra DB*/){
            result = false;
        }
        if (this.widthCM < 1 /*Hent tal fra DB*/){
            result = false;
        }


        return result;
    }//checkCarSpace

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

    public int getWidthCM() {
        return widthCM;
    }

    public void setWidthCM(int widthCM) {
        this.widthCM = widthCM;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public boolean isCarspace() {
        return carSpace;
    }

    public void setCarspace(boolean carspace) {
        this.carSpace = carspace;
    }



}//class