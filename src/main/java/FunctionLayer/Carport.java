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
    private boolean carSpace;

    public Carport(int confId, String custName, int custPhone, int custPostal,
                   int confLength, int confWidth, int confHeight, String confMat){
        this.confId = confId;
        this.custName = custName;
        this.custPhone = custPhone;
        this.custPostal = custPostal;
        this.confLength = confLength;
        this.confWidth = confWidth;
        this.confHeight = confHeight;
        this.confMat = confMat;

        this.carSpace = checkCarSpace();

    }//Carport

//    public Carport(int heightCM, int lengthCM, int widthCM) {
//
//        return null;
//    }

    private boolean checkCarSpace(){
        boolean result = true;

        if (this.confLength < 1 /*Hent tal fra DB*/){
            result = false;
        }
        if (this.confWidth < 1 /*Hent tal fra DB*/){
            result = false;
        }
        if (this.confHeight < 1 /*Hent tal fra DB*/){
            result = false;
        }


        return result;
    }//checkCarSpace

}//class