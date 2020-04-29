package FunctionLayer;

public class Carport {
    private int confId;
    private String custName;
    private int custPhone;
    private int custPostal;
    private int confLength;
    private int confWidth;
    private int confHeight;
    private String confMat;
    private String confRoof;
    private boolean carSpace;

    public Carport(int confId, String custName, int custPhone, int custPostal,
                   int confLength, int confWidth, int confHeight, String confMat, String confRoof){
        this.confId = confId;
        this.custName = custName;
        this.custPhone = custPhone;
        this.custPostal = custPostal;
        this.confLength = confLength;
        this.confWidth = confWidth;
        this.confHeight = confHeight;
        this.confMat = confMat;
        this.confRoof = confRoof;

        this.carSpace = checkCarSpace();

    }//Carport

    private boolean checkCarSpace(){
        boolean result = true;

        if (this.confLength < 1 ){ //Hent tal fra DB
            result = false;
        }
        if (this.confWidth < 1 ){ //Hent tal fra DB
            result = false;
        }
        if (this.confHeight < 1 ){ //Hent tal fra DB
            result = false;
        }
        return result;
    }//checkCarSpace

    //Getter & Setter
    public int getConfId() {
        return confId;
    }

    public void setConfId(int confId) {
        this.confId = confId;
    }

    public String getCustName() {
        return custName;
    }

    public void setCustName(String custName) {
        this.custName = custName;
    }

    public int getCustPhone() {
        return custPhone;
    }

    public void setCustPhone(int custPhone) {
        this.custPhone = custPhone;
    }

    public int getCustPostal() {
        return custPostal;
    }

    public void setCustPostal(int custPostal) {
        this.custPostal = custPostal;
    }

    public int getConfLength() {
        return confLength;
    }

    public void setConfLength(int confLength) {
        this.confLength = confLength;
    }

    public int getConfWidth() {
        return confWidth;
    }

    public void setConfWidth(int confWidth) {
        this.confWidth = confWidth;
    }

    public int getConfHeight() {
        return confHeight;
    }

    public void setConfHeight(int confHeight) {
        this.confHeight = confHeight;
    }

    public String getConfMat() {
        return confMat;
    }

    public void setConfMat(String confMat) {
        this.confMat = confMat;
    }

    public String getConfRoof() {
        return confRoof;
    }

    public void setConfRoof(String confRoof) {
        this.confRoof = confRoof;
    }

    public boolean isCarSpace() {
        return carSpace;
    }

    public void setCarSpace(boolean carSpace) {
        this.carSpace = carSpace;
    }
}//class
