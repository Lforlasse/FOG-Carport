package FunctionLayer;

import DBAccess.ComponentMapper;
import DBAccess.ConfigurationMapper;

import java.util.HashMap;
import java.util.Map;

public class OfferRequest {

    private Carport carport;
    private int confId;
    private HashMap<Component, Integer> compList;
    private HashMap<Part, Integer> partList;
    private int vendorPrice;
    private int salesPrice;
    private int profit;

    public OfferRequest(int confId) {
        this.confId = confId;
        this.compList = new HashMap<>();
        this.partList = new HashMap<>();
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
        //addLegter(); se metode.
        addStern();

    }//generateCompList


    //COMPONENTS
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

    }//addSper

//    private static void addLegter() { //TODO fremtidigt sprint, bruges til tag med rejsning.
//
//
//    }//addLegter

    private void addStern() {

        int max = 400;
        int countUnit = 1;
        int addUnit = 1;
        for (int i = carport.getConfLength(); i > 0; i -= max) {
            countUnit += 1;
        }

        addUnit += carport.getConfLength() / max;
        addUnit *= countUnit;
        addUnit *= 2;

        Component sternLength = ComponentMapper.getComponent("Stern", carport.getConfMat());
        sternLength.setCompLength(carport.getConfLength() / addUnit);
        compList.put(sternLength, addUnit);

        countUnit = 1;
        addUnit = 1;

        for (int i = carport.getConfWidth(); i > 0; i += max) {
            countUnit += 1;
        }

        addUnit += carport.getConfWidth() / max;
        addUnit *= countUnit;
        addUnit *= 2;

        Component sternWidth = ComponentMapper.getComponent("Stern", carport.getConfMat());
        sternWidth.setCompLength(carport.getConfWidth() / addUnit);
        compList.put(sternWidth, addUnit);

    }//addStern //OBS på navngivning til Component.
    //COMPONENTS SLUT



    //PARTS
    private void partList() {
        //addStolper();
        addPartsRemme();
        addPartsSper();
        //addLegter(); se metode.
        addPartsStern();

    }//generateCompList

    private void addPartsRemme() {
        //1 rem = 2 bræddebolte, 2 firkantskiver

        HashMap<String, HashMap> selects = new HashMap<String, HashMap>();

        for(Map.Entry<Component, Integer> entry : compList.entrySet()) {

            int countUnit = 0;

            if(){
               countUnit += entry.getValue();
            }

            String key = entry.getKey();
            HashMap value = entry.getValue();


        }



    }

    private void addPartsSper() {
    }

    private void addPartsStern() {
    }




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
