package FunctionLayer;

import DBAccess.ComponentMapper;
import DBAccess.ConfigurationMapper;
import DBAccess.PartMapper;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class OfferRequest {

    private Carport carport;
    private int confId;
    private LinkedHashMap<Component, Integer> compList;
    private LinkedHashMap<Part, Integer> partList;
    private int vendorPrice;
    private int salesPrice;
    private Blueprint blueprint;

    public OfferRequest(int confId) {
        this.confId = confId;
        this.compList = new LinkedHashMap<>();
        this.partList = new LinkedHashMap<>();
        this.carport = ConfigurationMapper.getOneConfig(confId);

        generateCompList();
        generatePartList();
        calcVendorPrice();
        calcSalesPrice();

        this.blueprint = new Blueprint();
    }

    public OfferRequest() {
    }//tom constructor

    //metoder
    private void generateCompList() {
        addStolpe();
        addRem();
        addSper();
        //addLegter(); se metode.
        addStern();

    }//generateCompList


    //COMPONENTS
    private void addStolpe() {

        int stolpeLength = carport.getConfLength() - 400;
        int countUnit = 4;
        for (int i = stolpeLength; i > 0; i -= 200) {
            countUnit += 2;
        }

        int stolpeWidth = carport.getConfWidth() - 400;
        for (int i = stolpeWidth; i > 0; i -= 200) {
            countUnit += 2;
        }

        Component Stolpe = ComponentMapper.getComponent("Stolpe", carport.getConfMat());
        Stolpe.setCompLength(carport.getConfHeight() + 90);
        compList.put(Stolpe, countUnit);

    }//addStolpe

    private void addRem() {
        int max = 400;

        int countUnit = 1;
        for (int i = 400; i < carport.getConfLength(); i += max) {
            countUnit += 1;
        }

        Component rem = ComponentMapper.getComponent("Rem", carport.getConfMat());
        rem.setCompLength(carport.getConfLength() / countUnit);
        compList.put(rem, countUnit * 2);

    }//addRem

    private void addSper() {

        int max = 400;
        int maxSpread = 50;
        int countUnit = 1;
        int addUnit = 1;
        for (int i = carport.getConfLength(); i > 0; i -= maxSpread) {
            countUnit += 1;
        }

        addUnit += carport.getConfWidth() / max;

        Component sper = ComponentMapper.getComponent("Spær", carport.getConfMat());
        sper.setCompLength(carport.getConfWidth() / addUnit);
        compList.put(sper, addUnit * countUnit);

    }//addSper

//    private static void addLegter() { //TODO fremtidigt sprint, bruges til tag med rejsning.
//
//
//    }//addLegte

    private void addStern() {

        int max = 400;
        int countUnit = 1;
        int addUnit = 1;
        for (int i = carport.getConfLength(); i > 0; i -= max) {
            countUnit += 1;
        }

        addUnit += carport.getConfLength() / max;
        addUnit *= countUnit;

        Component sternLengthOver = ComponentMapper.getComponent("Stern, over", carport.getConfMat());
        Component sternLengthUnder = ComponentMapper.getComponent("Stern, under", carport.getConfMat());

        sternLengthOver.setCompLength(carport.getConfLength() / addUnit);
        sternLengthUnder.setCompLength(carport.getConfLength() / addUnit);
        addUnit *= 2;

        compList.put(sternLengthOver, addUnit);
        compList.put(sternLengthUnder, addUnit);

        //reset count
        countUnit = 1;
        addUnit = 1;

        for (int i = carport.getConfWidth(); i > 0; i -= max) {
            countUnit += 1;
        }

        addUnit += carport.getConfWidth() / max;
        addUnit *= countUnit;

        Component sternWidthOver = ComponentMapper.getComponent("Stern, over", carport.getConfMat());
        Component sternWidthUnder = ComponentMapper.getComponent("Stern, under", carport.getConfMat());

        sternWidthOver.setCompLength(carport.getConfWidth() / addUnit);
        sternWidthUnder.setCompLength(carport.getConfWidth() / addUnit);
        addUnit *= 2;

        compList.put(sternWidthOver, addUnit);
        compList.put(sternWidthUnder, addUnit);

    }//addStern
    //COMPONENTS END

    //PARTS
    private void generatePartList() {
        addPartRem();
        addPartSper();
        //addPartLegte(); se metode.
        addPartStern();

    }//generateCompList

    private void addPartRem() {
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

    }//addPartRem

    private void addPartSper() {
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

        Part partSkruer = PartMapper.getPart("Skruer 4,0 x 50mm 250stk");
        countScrew *= countUnit;
        countBox += countScrew / 250;

        partList.put(partBeslagH, countUnit);
        partList.put(partBeslagV, countUnit);
        partList.put(partSkruer, countBox);

    }//addPartSper

    private void addPartStern() {
        //1 sternbræt(over el. mellem el. under) = 2 skruer pr spær.
        // OG 2 pr bræt pr 50cm. på sider langs med spær.
        int countUnitStern = 0;
        int countWidth = 1;
        int countUnitSper = 0;
        int countScrew = 0;
        int countBox = 1;

        for (Map.Entry<Component, Integer> entry : compList.entrySet()) {
            if (entry.getKey().getCompDesc().equalsIgnoreCase("Stern, over")) {
                countUnitStern++;
            }
            if (entry.getKey().getCompDesc().equalsIgnoreCase("Stern, mellem")) {
                countUnitStern++;
            }
            if (entry.getKey().getCompDesc().equalsIgnoreCase("Stern, under")) {
                countUnitStern++;
            }
            if (entry.getKey().getCompDesc().equalsIgnoreCase("Spær")) {
                countUnitSper += entry.getValue();
            }//if
        }//for

        //Parts
        Part partSkruer = PartMapper.getPart("Skruer 4,5 x 60mm 200stk");

        countUnitStern *= 2;                            //Hvert sternbrædde skal have 2 skruer per spær
        countUnitSper *= 2;                             //Sper skal have skruer i begge ender
        countScrew += countUnitStern * countUnitSper;
        countWidth += this.carport.getConfWidth() / 50;
        countWidth *= countUnitStern;
        countScrew += countWidth;

        countBox += countScrew / 200;

        partList.put(partSkruer, countBox);

    }//addPartStern

    private void calcVendorPrice() {
        int price = 0;

        for (Map.Entry<Component, Integer> entry : compList.entrySet()) {
            price += entry.getKey().getVendorPrice() * entry.getValue();
        }

        for (Map.Entry<Part, Integer> entry : partList.entrySet()) {
            price += entry.getKey().getVendorPrice() * entry.getValue();
        }

        setVendorPrice(price);
    }//calcVendorPrice

    private void calcSalesPrice() {
        int price = 0;

        for (Map.Entry<Component, Integer> entry : compList.entrySet()) {
            price += entry.getKey().getSalesPrice() * entry.getValue();
        }

        for (Map.Entry<Part, Integer> entry : partList.entrySet()) {
            price += entry.getKey().getSalesPrice() * entry.getValue();
        }

        setSalesPrice(price);
    }//calcSalesPrice

    public int profit(int price) {

        return price - getVendorPrice();
    }//profit
    //PARTS END

    //BLUEPRINT
    private void generateBlueprint() {
        assignCanvasBack();
        assignCanvasFront();
        placeStolpe(); //TODO mangler logik i metode


    }//generateBlueprint

    //TIL MARKERS + carport canvas
    private void assignCanvasBack() {

        int canvasX = 750;
        int canvasY = 750;

        blueprint.setCanvasBack("<svg version=\"1.1\"\n" +
                "     xmlns=\"http://www.w3.org/2000/svg\"\n" +
                "     xmlns:xlink=\"http://www.w3.org/1999/xlink\"\n" +
                "     height=\"100%\" viewBox=\"0 0 " + canvasX + " " + canvasY + "\n" +
                "     preserveAspectRatio=\"xMinYMin\">");

    }//assignCanvasBack

    //TIL CARPORT
    private void assignCanvasFront() {

        int positionRight = 100;
        int positionDown = 100;

        blueprint.setCanvasFront("<svg version=\"1.1\" xmlns=\"http://www.w3.org/2000/svg\" " +
                "xmlns:xlink=\"http://www.w3.org/1999/xlink\"\n" +
                "     viewBox=\"" + positionRight + " " + positionDown + " " + carport.getConfLength() + " " +
                carport.getConfWidth() + "\">");

    }//assignCanvasFront

    private void assignStolper() {

        int height = defineStolpeHeight();
        int width = defineStolpeWidth();


        blueprint.setStolpe("<rect x=\"110\" y=\"32\" height=\"\" width=\"10\" " +
                "style=\"stroke:#000000; fill:#ffffff\"/>");

    }//assignStolper

    private int defineStolpeWidth() {

        int width = 0;

        for (Map.Entry<Component, Integer> entry : compList.entrySet()) {
            if (entry.getKey().getCompDesc().equalsIgnoreCase("Stolpe")) {
                width = entry.getKey().getCompWidth();
            }//if
        }//for

        return width;
    } //defineStolpeWidth

    private int defineStolpeHeight() {

        int height = 0;

        for (Map.Entry<Component, Integer> entry : compList.entrySet()) {
            if (entry.getKey().getCompDesc().equalsIgnoreCase("Stolpe")) {
                height = entry.getKey().getCompHeight();
            }//if
        }//for

        return height;
    }//defineStolpeHeight

    private void placeStolpe() {

        blueprint.setStolpe();

    }//placeStolpe

    private int defineRemWidth(){

        int width = 0;

        for (Map.Entry<Component, Integer> entry : compList.entrySet()) {
            if (entry.getKey().getCompDesc().equalsIgnoreCase("Rem")) {
                width = entry.getKey().getCompWidth();
            }//if
        }//for
        return width;

    }//defineRemWidth

    private int defineRemLength(){

        int length = 0;

        for (Map.Entry<Component, Integer> entry : compList.entrySet()) {
            if (entry.getKey().getCompDesc().equalsIgnoreCase("Rem")) {
                length = entry.getKey().getCompLength();
            }//if
        }//for
        return length;

    }//defineRemLength

    private void placeRem() {

        blueprint.setRem();

    }//placeRem


    private int defineSperWidth(){

        int width = 0;

        for (Map.Entry<Component, Integer> entry : compList.entrySet()) {
            if (entry.getKey().getCompDesc().equalsIgnoreCase("Sper")) {
                width = entry.getKey().getCompWidth();
            }//if
        }//for
        return width;

    }//defineSperWidth

    private int defineSperLength(){

        int length = 0;

        for (Map.Entry<Component, Integer> entry : compList.entrySet()) {
            if (entry.getKey().getCompDesc().equalsIgnoreCase("Sper")) {
                length = entry.getKey().getCompLength();
            }//if
        }//for
        return length;

    }//defineSperLength

    private void placeSper(){

        blueprint.setSper();

    }//placeSper

    private int defineSternOverWidth(){

        int width = 0;

        for (Map.Entry<Component, Integer> entry : compList.entrySet()) {
            if (entry.getKey().getCompDesc().equalsIgnoreCase("Stern, over")) {
                width = entry.getKey().getCompWidth();
            }//if
        }//for
        return width;

    }//defineSternOverWidth

    private int defineSternUnderWidth(){

        int width = 0;

        for (Map.Entry<Component, Integer> entry : compList.entrySet()) {
            if (entry.getKey().getCompDesc().equalsIgnoreCase("Stern, under")) {
                width = entry.getKey().getCompWidth();
            }//if
        }//for
        return width;

    }//defineSternUnderWidth

    private int defineSternOverLength(){

        int length = 0;

        for (Map.Entry<Component, Integer> entry : compList.entrySet()) {
            if (entry.getKey().getCompDesc().equalsIgnoreCase("Stern, over")) {
                length = entry.getKey().getCompLength();
            }//if
        }//for
        return length;

    }//defineSternOverLength

    private int defineSternUnderLength(){

        int length = 0;

        for (Map.Entry<Component, Integer> entry : compList.entrySet()) {
            if (entry.getKey().getCompDesc().equalsIgnoreCase("Stern, under")) {
                length = entry.getKey().getCompLength();
            }//if
        }//for
        return length;

    }//defineSternUnderLength

    private void placeStern(){

        blueprint.setSper();

    }//placeSper
    //BLUEPRINT END

    //Getter & setter
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

    public LinkedHashMap<Component, Integer> getCompList() {
        return compList;
    }

    public void setCompList(LinkedHashMap<Component, Integer> compList) {
        this.compList = compList;
    }

    public LinkedHashMap<Part, Integer> getPartList() {
        return partList;
    }

    public void setPartList(LinkedHashMap<Part, Integer> partList) {
        this.partList = partList;
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
}//class
