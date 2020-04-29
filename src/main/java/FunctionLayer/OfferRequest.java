package FunctionLayer;

import DBAccess.ComponentMapper;
import DBAccess.ConfigurationMapper;
import DBAccess.PartMapper;

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

        Component rem = ComponentMapper.getComponent("Rem", carport.getConfMat());
        rem.setCompLength(carport.getConfLength() / countUnit);
        compList.put(rem, countUnit * 2);

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

        Component sternLengthOver = ComponentMapper.getComponent("Stern, over", carport.getConfMat());
        Component sternLengthUnder = ComponentMapper.getComponent("Stern, under", carport.getConfMat());

        sternLengthOver.setCompLength(carport.getConfLength() / addUnit);
        sternLengthUnder.setCompLength(carport.getConfLength() / addUnit);

        compList.put(sternLengthOver, addUnit);
        compList.put(sternLengthUnder, addUnit);

        //reset count
        countUnit = 1;
        addUnit = 1;

        for (int i = carport.getConfWidth(); i > 0; i += max) {
            countUnit += 1;
        }

        addUnit += carport.getConfWidth() / max;
        addUnit *= countUnit;
        addUnit *= 2;

        Component sternWidthOver = ComponentMapper.getComponent("Stern, over", carport.getConfMat());
        Component sternWidthUnder = ComponentMapper.getComponent("Stern, under", carport.getConfMat());

        sternWidthOver.setCompLength(carport.getConfWidth() / addUnit);
        sternWidthUnder.setCompLength(carport.getConfWidth() / addUnit);

        compList.put(sternWidthOver, addUnit);
        compList.put(sternWidthUnder, addUnit);

    }//addStern
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
        //1 stolpe = 1 bræddebolt, 1 firkantskive
        int countUnit = 0;

        for (Map.Entry<Component, Integer> entry : compList.entrySet()) {

            if (entry.getKey().getCompDesc().equalsIgnoreCase("Stolpe")) {
                countUnit += entry.getValue();
            }//if
        }//for

        //Parts
        Part partBolt = PartMapper.getPart("Bræddebolt 10 x 120mm");
        Part partSkive = PartMapper.getPart("Firkantskive 40 x 40 x 11mm");

        partList.put(partBolt, countUnit);
        partList.put(partSkive, countUnit);

    }//addPartsRemme

    private void addPartsSper() {
        //1 spær = 1 højre, 1 venstre uni.
        //1 spær = 18 skruer - spild 2?.
        int countUnit = 0;
        int countScrew = 18;
        int countBox = 1;

        for (Map.Entry<Component, Integer> entry : compList.entrySet()) {
            if (entry.getKey().getCompDesc().equalsIgnoreCase("Spær")) {
                countUnit += entry.getValue();
            }//if
        }//for

        //Parts
        Part partBeslagH = PartMapper.getPart("Universalbeslag 190mm højre");
        Part partBeslagV = PartMapper.getPart("Universalbeslag 190mm venstre");

        Part partSkruer = PartMapper.getPart("Skruer 4,5 x 60mm 200stk");
        countScrew *= countUnit;
        countBox += countScrew / 200;

        partList.put(partBeslagH, countUnit);
        partList.put(partBeslagV, countUnit);
        partList.put(partSkruer, countBox);

    }//addPartsSper // HUSK RIGTIGE SKRUER

    private void addPartsStern() {
        //1 sternbræt(over el. mellem el. under) = 2 skruer pr spær.
        // OG 2 pr bræt pr 50cm. på sider langs med spær.
        int countUnit = 0;
        int countUnitLength = 0;
        int countUnitSper = 0;
        int countScrew = 0;
        int countBox = 1;

        for (Map.Entry<Component, Integer> entry : compList.entrySet()) {
            if (entry.getKey().equals("sternLengthOver")) {
                countUnit += entry.getValue();
            }
            if (entry.getKey().getCompDesc().equalsIgnoreCase("Stern, mellem")) {
                countUnit += entry.getValue();
            }
            if (entry.getKey().getCompDesc().equalsIgnoreCase("Stern, under")) {
                countUnit += entry.getValue();
            }
            if (entry.getKey().getCompDesc().equalsIgnoreCase("Spær")) {
                countUnitSper += entry.getValue();
            }//if
        }//for

        //Parts
        Part partSkruer = PartMapper.getPart("Skruer 4,5 x 60mm 200stk");

        countUnitSper *= countUnit
        countScrew *= countUnitSper*8;
        countBox += countScrew/200;

        }










        Part partBeslagV = PartMapper.getPart("Universalbeslag 190mm venstre");

        Part partSkruer = PartMapper.getPart("Skruer 4,5 x 60mm 200stk");
        countScrew *= countUnit;
        countBox += countScrew / 200;

        partList.put(partBeslagH, countUnit);
        partList.put(partBeslagV, countUnit);
        partList.put(partSkruer, countBox);





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
