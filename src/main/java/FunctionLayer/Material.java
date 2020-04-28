package FunctionLayer;

public class Material {

    int materialID;
    String name;
    int length;
    int height;
    int width;

    public Material(int materialID, String name, int length, int height, int width) {
        this.materialID = materialID;
        this.name = name;
        this.length = length;
        this.height = height;
        this.width = width;
    }//construtor

    public Material() {
    }//tom constructor


    //Getter & Setter
    public int getMaterialID() {
        return materialID;
    }

    public void setMaterialID(int materialID) {
        this.materialID = materialID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }
}//class
