package FunctionLayer;

import DBAccess.ComponentMapper;
import DBAccess.ConfigurationMapper;

import java.util.ArrayList;
import java.util.HashMap;

public class OfferRequest {

    private Carport carport;
    private int confId;
    private HashMap<Component, Integer> compList;
    private int vendorPrice;
    private int salesPrice;
    private int profit;

    public OfferRequest(int confId) {
        this.confId = confId;
        this.compList = new HashMap<>();
        this.carport = ConfigurationMapper.makeConfigObject(confId); //TODO husk refactor configId til confId i DB.
        //  this.vendorPrice = totalVendorPrice(); //TODO metode til total vendor pris.
        //  this.salesPrice = totalSalesPrice(); //TODO metode til total salgspris.
        //  this.profit = totalProfit(); //TODO metode til total profit.
        generateCompList();
    }

    public OfferRequest() {
    }

    //metoder
    private void generateCompList() {
        addStolper();
        addRemme();
        addSper();
        addLegter();
        addStern();

    }//generateCompList

    private void addStolper() {

        carport.setConfLength(-400);
        int countUnit = 4;
        for (int i = carport.getConfLength(); i > 0; i -= 200) {
            countUnit += 2;
        }

        carport.setConfWidth(-400);
        for (int i = carport.getConfWidth(); i > 0; i -= 200) {
            countUnit += 2;
        }

        Component Stolpe = ComponentMapper.getComponent("Stolpe", carport.getConfMat());
        Stolpe.setCompLength(carport.getConfHeight() + 90);
        compList.put(Stolpe, countUnit);

    }//addStolper


//        height -= 250;
//
//        for (int i = carport.getheight(); ;i > 0; i -= 200 ){
//            countPlank += 2;
//        }

    private void addRemme() {
        int max = 400;

        int countUnit = 1;
        for (int i = 400; i < carport.getConfLength(); i += max) {
            countUnit += 1;
        }

        if (countUnit == 1) {

            Component rem = ComponentMapper.getComponent("Rem", carport.getConfMat());
            rem.setCompLength(carport.getConfLength() / countUnit);
            rem.setCompDesc(rem.getCompDesc() + ", dobbeltbeskåret 45°");
            compList.put(rem, countUnit * 2);

        } else if (countUnit == 2) {

            Component rem = ComponentMapper.getComponent("Rem", carport.getConfMat());
            rem.setCompLength(carport.getConfLength() / countUnit);
            rem.setCompDesc(rem.getCompDesc() + ", enkeltbeskåret 45°");
            compList.put(rem, countUnit * 2);

        } else {

            Component rem = ComponentMapper.getComponent("Rem", carport.getConfMat());
            rem.setCompLength(carport.getConfLength());
            countUnit *= 2;
            compList.put(rem, countUnit - 4);
            rem.setCompDesc(rem.getCompDesc() + ", enkeltbeskåret 45°");
            compList.put(rem, 4);
        }//Length

        countUnit = 1;
        for (int i = 400; i < carport.getConfWidth(); i += max) {
            countUnit += 1;
        }

        if (countUnit == 1) {

            Component rem = ComponentMapper.getComponent("Rem", carport.getConfMat());
            rem.setCompLength(carport.getConfWidth() / countUnit);
            rem.setCompDesc(rem.getCompDesc() + ", dobbeltbeskåret 45°");
            compList.put(rem, countUnit * 2);

        } else if (countUnit == 2) {

            Component rem = ComponentMapper.getComponent("Rem", carport.getConfMat());
            rem.setCompLength(carport.getConfWidth() / countUnit);
            rem.setCompDesc(rem.getCompDesc() + ", enkeltbeskåret 45°");
            compList.put(rem, countUnit * 2);

        } else {

            Component rem = ComponentMapper.getComponent("Rem", carport.getConfMat());
            rem.setCompLength(carport.getConfWidth());
            countUnit *= 2;
            compList.put(rem, countUnit - 4);
            rem.setCompDesc(rem.getCompDesc() + ", enkeltbeskåret 45°");
            compList.put(rem, 4);
        }//Width

    }//addRemme

    private void addSper() {

        int max = 400;
        int maxSpread = 50;
        int countUnit = 1;
        int addUnit = 1;
        for (int i = carport.getConfLength(); i > 0; i -= maxSpread) {
            countUnit += 1;
        }

        addUnit += carport.getConfWidth() / max;

        Component sper = ComponentMapper.getComponent("Sper", carport.getConfMat());
        sper.setCompLength(carport.getConfWidth() / addUnit);
        compList.put(sper, addUnit * countUnit);

    }//addStolper

    private static void addLegter() {
        //

    }//addStolper

    private static void addStern() {
        //en stern er går rundt i omkredsen af carporten
        //L+L+B+B = Stern


    }//addStolper

    public Carport getCarport() {
        return carport;
    }

    public void setCarport(Carport carport) {
        this.carport = carport;
    }

    public int getConfId() {
        return confId;
    }

    public void setConfId(int confId) {
        this.confId = confId;
    }

    public HashMap<Component, Integer> getCompList() {
        return compList;
    }

    public void setCompList(HashMap<Component, Integer> compList) {
        this.compList = compList;
    }

    public int getVendorPrice() {
        return vendorPrice;
    }

    public void setVendorPrice(int vendorPrice) {
        this.vendorPrice = vendorPrice;
    }

    public int getSalesPrice() {
        return salesPrice;
    }

    public void setSalesPrice(int salesPrice) {
        this.salesPrice = salesPrice;
    }

    public int getProfit() {
        return profit;
    }

    public void setProfit(int profit) {
        this.profit = profit;
    }
}//class