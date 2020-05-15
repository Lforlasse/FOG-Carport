package FunctionLayer;

import DBAccess.ComponentMapper;
import DBAccess.ConfigurationMapper;
import DBAccess.PartMapper;
import DBAccess.RoofMapper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class OfferRequest {

    private Carport carport;
    private int confId;
    private LinkedHashMap<Component, Integer> compList;
    private LinkedHashMap<Part, Integer> partList;
    private LinkedHashMap<RoofUnit, Integer> roofUnitList;
    private int vendorPrice;
    private int salesPrice;
    private Blueprint blueprint;

    public OfferRequest(int confId) {
        this.confId = confId;
        this.compList = new LinkedHashMap<>();
        this.partList = new LinkedHashMap<>();
        this.roofUnitList = new LinkedHashMap<>();
        this.carport = ConfigurationMapper.getOneConfig(confId);

        generateCompList();
        generateRoofList();
        generatePartList();
        calcVendorPrice();
        calcSalesPrice();

        this.blueprint = new Blueprint();
        generateBlueprint();
    }

    public OfferRequest() {
    }//tom constructor

    //COMPONENTS
    private void generateCompList() {
        addStolpe();
        addRem();
        addSper();

        if (carport.getRoof().inclination > 0) {
            addLegte();
        }

        addStern();
        addRoof();

        //Skal der være tilvalg af beklædning?
        addListeBekledning();
        addBekledning();

    }//generateCompList

    private void addStolpe() {

        int stolpeLength = carport.getConfLength() - 400;
        int countUnit = 4;

        for (int i = stolpeLength; i > 0; i -= 200) {
            countUnit += 2;
        }

//Udkommenteret fordi vi lige nu ikke skal have midterstolper på denne side.
/*        int stolpeWidth = carport.getConfWidth() - 400;
        for (int i = stolpeWidth; i > 0; i -= 200) {
            countUnit += 2;
        }
*/
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

        boolean hasInclination;
        if (carport.getRoof().inclination == 0) {
            hasInclination = false;
        } else {
            hasInclination = true;
        }//else
        int max = 400;
        int maxSpread = 50;
        int countUnit = 1;
        int addUnit = 1;

        for (int i = carport.getConfLength(); i > 0; i -= maxSpread) {
            countUnit += 1;
        }

        if (!hasInclination) {
            addUnit += carport.getConfWidth() / max;

        Component sper = ComponentMapper.getComponent("Spær", carport.getConfMat());
        sper.setCompLength(carport.getConfWidth() / addUnit);
        sper.setCompInfo("Grundspær");
        compList.put(sper, addUnit * countUnit);
            Component sper = ComponentMapper.getComponent("Spær", carport.getConfMat());
            sper.setCompLength(carport.getConfWidth() / addUnit);
            compList.put(sper, addUnit * countUnit);
        } else {

        if (hasInclination) {

            Component sperTag = ComponentMapper.getComponent("Spær", carport.getConfMat());
            sper.setCompLength(carport.getConfWidth() / addUnit);
            sper.setCompInfo("Singlecut " + carport.getRoof().inclination + "°");
            compList.put(sper, addUnit * countUnit);

            Component sperMidt = ComponentMapper.getComponent("Spær", carport.getConfMat());
            sper.setCompLength(carport.getConfWidth() / addUnit);
            sper.setCompInfo("Singlecut " + carport.getRoof().inclination + "°");
            compList.put(sper, addUnit * countUnit);


        }//if
        }//else
        if (hasInclination) {

            Component sperTag = ComponentMapper.getComponent("Spær", carport.getConfMat());
            sper.setCompLength(carport.getConfWidth() / addUnit);
            sper.setCompDesc("Tagspær");
            sper.setCompInfo("Singlecut " + carport.getRoof().inclination + "° Tagspær");
            compList.put(sper, addUnit * countUnit);

            Component sperMidt = ComponentMapper.getComponent("Spær", carport.getConfMat());
            sper.setCompLength(sper.getCompWidth() + carport.getRoof().roofHeight - carport.getRoof().sideC);
            sper.setCompDesc("Midterspær");
            sper.setCompInfo("Topcut " + carport.getRoof().inclination + "° Midterspær");
            compList.put(sper, countUnit);

        }//if
    }//addSper

    private void addLegte() {

        int bottomSpace = 35;
        int Spread = 30;
        int countUnit = 2;
        int sideC = carport.getRoof().getSideC() - bottomSpace;

        for (int i = sideC; i > Spread; i -= Spread) {
            countUnit += 1;
        }

        countUnit += countUnit;


        if (carport.getConfLength() > carport.getRoof().maxLengthComponent) {
            countUnit *= countUnit;

            Component legte = ComponentMapper.getComponent("Lægte", carport.getConfMat());
            legte.setCompLength(carport.getConfLength() / 2);
            compList.put(legte, countUnit);

        } else {

            Component legte = ComponentMapper.getComponent("Lægte", carport.getConfMat());
            legte.setCompLength(carport.getConfLength());
            compList.put(legte, countUnit);

        }//else
    }//addLegte

    private void addStern() {

        boolean hasInclination;
        if (carport.getRoof().inclination == 0) {
            hasInclination = false;
        } else {
            hasInclination = true;
        }//else
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

        //flat tag
        if (!hasInclination) {
            addUnit += carport.getConfWidth() / max;
            addUnit *= countUnit;

            Component sternWidthOver = ComponentMapper.getComponent("Stern, over", carport.getConfMat());
            Component sternWidthUnder = ComponentMapper.getComponent("Stern, under", carport.getConfMat());

            sternWidthOver.setCompLength(carport.getConfWidth() / addUnit);
            sternWidthUnder.setCompLength(carport.getConfWidth() / addUnit);
            addUnit *= 2;

            compList.put(sternWidthOver, addUnit);
            compList.put(sternWidthUnder, addUnit);
        }//if
        //tag med rejsning
        else {

            Component sternWidthOver = ComponentMapper.getComponent("Stern, over", carport.getConfMat());
            Component sternWidthUnder = ComponentMapper.getComponent("Stern, under", carport.getConfMat());

            sternWidthOver.setCompLength(carport.getConfWidth() / addUnit);
            sternWidthOver.setCompInfo("Singlecut " + carport.getRoof().inclination + "°");
            sternWidthUnder.setCompLength(carport.getConfWidth() / addUnit);
            sternWidthUnder.setCompInfo("Singlecut " + carport.getRoof().inclination + "°");
            addUnit *= 2;

            compList.put(sternWidthOver, addUnit);
            compList.put(sternWidthUnder, addUnit);
        }//else
    }//addStern

    //lister til beklædning
    private void addListeBekledning() {

        //TODO Mangler bekræftelse og refactoring af logik
        int max = 200;
        int countUnit = 1;

        for(int i = 200; i < carport.getConfLength(); i += max){
            countUnit += 2;
        }

        Component liste = ComponentMapper.getComponent("Liste", carport.getConfMat());
        liste.setCompLength(carport.getConfLength() / countUnit);
        compList.put(liste, countUnit);
    }

    private void addBekledning() {
        //4 skruer per bræt, 2 i toppen 2 i bunden.
        //30mm overlap på bræt til bræt.

        //parts, lister, coordination med frontend.
        //not done

        int bekledningCarportLengthX = carport.getConfLength() - 10;
        int bekledningCarportLengthX1 = carport.getConfLength() - 10;
        int bekledningCarportWidth = carport.getConfWidth() - 10;
        int countUnit = 1;

        //Den ene side af længden
        for(int i = bekledningCarportLengthX; i >= 0; i -= 7){
            countUnit += 1;
        }

        Component bekledningLengthX = ComponentMapper.getComponent("Beklædning", carport.getConfMat());
        bekledningLengthX.setCompLength(carport.getConfHeight());
        compList.put(bekledningLengthX, countUnit);

        //Reset count
        countUnit = 1;

        //Den anden side af længden
        for(int i = bekledningCarportLengthX1; i >= 0; i -= 7){
            countUnit += 1;
        }

    }
        Component bekledningLengthX1 = ComponentMapper.getComponent("Beklædning", carport.getConfMat());
        bekledningLengthX1.setCompLength(carport.getConfHeight());
        compList.put(bekledningLengthX1, countUnit);

        //Reset count
        countUnit = 1;

        //Bagsiden af carporten
        for(int i = bekledningCarportWidth; i >= 0; i -= 7){
            countUnit += 1;
        }

        Component bekledningWidth = ComponentMapper.getComponent("Beklædning", carport.getConfMat());
        bekledningWidth.setCompLength(carport.getConfHeight());
        compList.put(bekledningWidth, countUnit);

    }//addBekledning
    //COMPONENTS END

    //ROOFUNIT
    private void generateRoofList() {
        addRoof();

    }//generateRoofList

    private void addRoof() {

        boolean hasInclination;
        if (carport.getRoof().inclination == 0) {
            hasInclination = false;
        } else {
            hasInclination = true;
        }//else
        int quantityX = 0;
        int quantityY = 0;
        int quantityAll = 0;
        int sizeX = 0;
        int sizeY = 0;

        if (carport.getRoof().material.equalsIgnoreCase("PLASTMO")) {
            if (!hasInclination) {

                for (int i = carport.getConfLength(); i > carport.getRoof().compWidth; i -= carport.getRoof().compWidth) {
                    quantityX++;

                }//for
                for (int i = carport.getConfWidth(); i > carport.getRoof().compLength; i -= carport.getRoof().compLength) {
                    quantityY++;
                }//for
                quantityAll = quantityX * quantityY;
                RoofUnit roofComp = RoofMapper.getRoofUnit(carport.getRoof().material);
                sizeX = carport.getConfLength() / quantityX;
                sizeX += 5;
                roofComp.setUnitLength(sizeX);
                sizeY = carport.getConfWidth() / quantityY;
                sizeY += 5;
                roofComp.setUnitWidth(sizeY);
                roofComp.setUnitInfo("5cm overlap");
                roofUnitList.put(roofComp, quantityAll);

            } else {


                for (int i = carport.getRoof().sideC; i > carport.getRoof().compLength; i -= carport.getRoof().compLength) {
                    quantityX++;

                }//for
                for (int i = carport.getConfLength(); i > carport.getRoof().compWidth; i -= carport.getRoof().compWidth) {
                    quantityY++;
                }//for
                quantityAll = quantityX * quantityY;
                quantityAll *= 2;
                RoofUnit roofComp = RoofMapper.getRoofUnit(carport.getRoof().material);
                sizeX = carport.getConfLength() / quantityX;
                sizeX += 5;
                roofComp.setUnitLength(sizeX);
                sizeY = carport.getConfWidth() / quantityY;
                sizeY += 5;
                roofComp.setUnitWidth(sizeY);
                roofComp.setUnitInfo("5cm overlap");
                roofUnitList.put(roofComp, quantityAll);
            }//else
        }/* PLASTMO */ else {
            for (int i = carport.getRoof().sideC; i > carport.getRoof().compLength - 3; i -= carport.getRoof().compLength) {
                quantityX++;

            }//for
            for (int i = carport.getConfLength(); i > carport.getRoof().compWidth - 2; i -= carport.getRoof().compWidth) {
                quantityY++;
            }//for
            quantityAll = quantityX * quantityY;
            quantityAll *= 2;
            RoofUnit roofComp = RoofMapper.getRoofUnit(carport.getRoof().material);

            roofUnitList.put(roofComp, quantityAll);

        }/* NOT PLASMO */

    }//addRoof
    //ROOFUNIT END

    //PARTS
    private void generatePartList() {
        addPartRem();
        addPartSper();

        if (carport.getRoof().inclination > 0) {
            addPartLegte();
        }

        addPartStern();
        addPartRoof();

        //husk tilvalg af beklædning
        addPartBekledning();
        addPartListe();

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

        partBolt.setPartInfo("Samler rem og stolpe");
        partSkive.setPartInfo("Samler rem og stolpe");

        partList.put(partBolt, countUnit);
        partList.put(partSkive, countUnit);

    }//addPartRem

    private void addPartSper() {
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

        partBeslagH.setPartInfo("Samler spær og rem");
        partBeslagV.setPartInfo("Samler spær og rem");
        partSkruer.setPartInfo("Anvendes med Universalbeslag");

        partList.put(partBeslagH, countUnit);
        partList.put(partBeslagV, countUnit);
        partList.put(partSkruer, countBox);

        //Parts extra
        if (carport.getRoof().inclination != 0) {
            int countExtra = 1;
            for (Map.Entry<Component, Integer> entry : compList.entrySet()) {
                if (entry.getKey().getCompDesc().equalsIgnoreCase("Midterspær")) {
                    countExtra *= entry.getValue();
                }//if
            }//for

            Part partBraeddebolt = PartMapper.getPart("Bræddebolt 10 x 120mm");
            Part partBraeddesskive = PartMapper.getPart("Bræddeplade 200 x 150 x 5mm");
            partBraeddebolt.setPartInfo("Samler spær, tagspær og midterspær");
            partBraeddesskive.setPartInfo("Samler tagspær og midterspær");
            partList.put(partBraeddebolt, countExtra * 12);
            partList.put(partBraeddesskive, countExtra);
        }//if
    }//addPartSper

    private void addPartLegte() {

        int countLegte = 0;
        int countSper = 0;
        int countScrew = 2;
        int countBox = 1;

        for (Map.Entry<Component, Integer> entry : compList.entrySet()) {
            if (entry.getKey().getCompDesc().equalsIgnoreCase("Spær")) {
                countSper = entry.getValue();
            }

            if (entry.getKey().getCompDesc().equalsIgnoreCase("Lægte")) {
                countLegte = entry.getValue();
            }

        }//for

        if (carport.getConfLength() > carport.getRoof().maxLengthComponent) {
            countSper /= 2;
        }

        countScrew *= countSper;
        countScrew *= countLegte;

        countBox += countScrew / 100;

        //Parts
        Part partScrew = PartMapper.getPart("Skruer 5 x 100mm 100stk");

        partScrew.setPartInfo("Samler lægte og spær");

        partList.put(partScrew, countBox);
    }//addPartLegte

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

        partSkruer.setPartInfo("Samler stern og spær");

        partList.put(partSkruer, countBox);

    }//addPartStern

    private void addPartBekledning() {
        //1 bræt = 4 skruer
        int countScrew70mm = 0;
        int countScrew50mm = 0;
        int countBox70mm = 1;
        int countBox50mm = 1;
        int countUnitBekledning = 0;
        int countUnitListe = 0;

        for(Map.Entry<Component, Integer> entry : compList.entrySet()){

            if(entry.getKey().getCompDesc().equalsIgnoreCase("Beklædning")) {
                countUnitBekledning++;
            }//if

            if (entry.getKey().getCompDesc().equalsIgnoreCase("Liste")) {
                countUnitListe += entry.getValue();
            }//if
        }//for

        //Parts
        Part partSkrueYdre = PartMapper.getPart("Skruer 4,5 x 70mm 200stk");
        countScrew70mm += countUnitBekledning + countUnitListe;
        countBox70mm += countScrew70mm / 200;

        partSkrueYdre.setPartInfo("Til ydre brædder");

        Part partSkrueIndre = PartMapper.getPart("Skruer 4,5 x 50mm 350stk");
        countScrew50mm += countUnitBekledning + countUnitListe;
        countBox50mm += countScrew50mm / 350;

        partSkrueIndre.setPartInfo("Til inder brædder");

        partList.put(partSkrueYdre, countBox70mm);
        partList.put(partSkrueIndre, countBox50mm);

    }//addPartBekledning

    private void addPartListe() {
        int countCompListe = 0;
        int countPart = 2;

        for (Map.Entry<Component, Integer> entry : compList.entrySet()) {

            if (entry.getKey().getCompDesc().equalsIgnoreCase("Liste")) {
                countCompListe += entry.getValue();
            }//if
        }//for

        //Parts
        Part partVinkelbeslag = PartMapper.getPart("Vinkelbeslag");
        countPart *= countCompListe;

        partList.put(partVinkelbeslag, countPart);
    }//addPartListe

    private void addPartRoof() {
        int countUnit = 0;
        int countbox;

        if (carport.getRoof().material.equalsIgnoreCase("PLASTMO")) {
            for (Map.Entry<RoofUnit, Integer> entry : roofUnitList.entrySet()) {

                if (entry.getKey().getUnitDesc().equalsIgnoreCase("PLASTMO")) {
                    countUnit += entry.getValue();
                }//if
            }//for
            Part partSkruer = PartMapper.getPart("PLASTMO bundskruer 200stk");
            partSkruer.setPartInfo("Skruer til PLASTMO plader");

            countbox = countUnit/2;
            partList.put(partSkruer,countbox);

        }//if

        //Betontagsten har ingen parts.
    }//addPartRoof

    private void calcVendorPrice() {
        int price = 0;

        for (Map.Entry<Component, Integer> entry : compList.entrySet()) {
            price += entry.getKey().getVendorPrice() * entry.getValue();
        }

        for (Map.Entry<RoofUnit, Integer> entry : roofUnitList.entrySet()) {
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

        for (Map.Entry<RoofUnit, Integer> entry : roofUnitList.entrySet()) {
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
        int canvasBorderSides = 50;
        int canvasBorderTopBot = 50;
        int canvasBackX = canvasBorderSides + carport.getConfLength() + canvasBorderSides;
        int canvasBackY = canvasBorderTopBot + carport.getConfWidth() + canvasBorderTopBot;

        assignCanvasBack(canvasBackX, canvasBackY);
        assignMarkerHead();
        assignMarkers(canvasBorderSides, canvasBorderTopBot);
        assignCanvasFront(canvasBorderSides, canvasBorderTopBot);
        assignCanvasFill();
        assignText(canvasBorderSides, canvasBorderTopBot);
        assignStolpe();
        assignRem();
        assignSper();
        assignStern();

        blueprint.setBlueprintSVG(blueprint.composeSVG());


    }//generateBlueprint

    //MARKERS + carport canvas
    private void assignCanvasBack(int canvasX, int canvasY) {


        blueprint.setCanvasBack("<svg version=\"1.1\"\n" +
                "     xmlns=\"http://www.w3.org/2000/svg\"\n" +
                "     xmlns:xlink=\"http://www.w3.org/1999/xlink\"\n" +
                "     height=\"" + canvasY + "\" width=\"" + canvasX + "\" viewBox=\"0 0 " + canvasX + " " + canvasY + "\"\n" +
                "     preserveAspectRatio=\"xMinYMin\">");

    }//assignCanvasBack

    private void assignMarkerHead() {

        blueprint.setMarkerHead("        <defs>\n" +
                "            <marker\n" +
                "                    id=\"beginArrow\"\n" +
                "                    markerWidth=\"12\"\n" +
                "                    markerHeight=\"12\"\n" +
                "                    refX=\"0\"\n" +
                "                    refY=\"6\"\n" +
                "                    orient=\"auto\">\n" +
                "                <path d=\"M0,6 L12,0 L12,12 L0,6\" style=\"fill: #000000;\" />\n" +
                "            </marker>\n" +
                "            <marker\n" +
                "                    id=\"endArrow\"\n" +
                "                    markerWidth=\"12\"\n" +
                "                    markerHeight=\"12\"\n" +
                "                    refX=\"12\"\n" +
                "                    refY=\"6\"\n" +
                "                    orient=\"auto\">\n" +
                "                <path d=\"M0,0 L12,6 L0,12 L0,0 \" style=\"fill: #000000;\" />\n" +
                "            </marker>\n" +
                "        </defs>");

    }//assignMarkerHead

    private void assignMarkers(int positionRight, int positionDown) {

        int headStartX;
        int headStartY;
        int headEndX;
        int headEndY;


        headStartX = positionRight - 15;
        headStartY = positionDown + 5;
        headEndX = headStartX;
        headEndY = carport.getConfWidth() + positionDown - 5;

        blueprint.setMarkerX("<line x1=\"" + headStartX + "\"  y1=\"" + headStartY + "\" x2=\"" + headEndX + "\"   y2=\"" + headEndY + "\"\n" +
                "              style=\"stroke: #000000;\n" +
                "\tmarker-start: url(#beginArrow);\n" +
                "\tmarker-end: url(#endArrow);\"/>");


        headStartX = positionRight + 5;
        headStartY = positionDown + carport.getConfWidth() + 15;
        headEndX = positionRight + carport.getConfLength() - 5;
        headEndY = headStartY;

        blueprint.setMarkerY("<line x1=\"" + headStartX + "\"  y1=\"" + headStartY + "\" x2=\"" + headEndX + "\"   y2=\"" + headEndY + "\"\n" +
                "              style=\"stroke: #000000;\n" +
                "\tmarker-start: url(#beginArrow);\n" +
                "\tmarker-end: url(#endArrow);\"/>");

    }//assignMarkers

    private void assignText(int positionRigth, int positionDown) {

        int x1 = positionRigth - 30;
        int y1 = positionDown + (carport.getConfWidth() / 2);

        int x2 = positionRigth + (carport.getConfLength() / 2);
        int y2 = positionDown + carport.getConfWidth() + 30;

        int value1 = carport.getConfWidth();
        int value2 = carport.getConfLength();

        blueprint.setCanvasText("    <text style=\"text-anchor: middle\" transform=\"translate(" + x1 + "," + y1 + ") rotate(-90)\"> " + value1 + "cm </text>\n" +
                "    <text style=\"text-anchor: middle\" x=\"" + x2 + "\" y=\"" + y2 + "\">" + value2 + "cm </text>");
    }//assignText

    //CARPORTSVG
    private void assignCanvasFront(int positionRight, int positionDown) {

        blueprint.setCanvasFront("<svg x=\"" + positionRight + "\" y=\"" + positionDown + "\" width=\"" + carport.getConfLength() + "\" height=\"" + carport.getConfWidth() + "\">");

    }//assignCanvasFront

    private void assignCanvasFill() {

        blueprint.setCanvasFill("<rect x=\"0\" y=\"0\" height=\"" + carport.getConfWidth() + "\" width=\"" + carport.getConfLength() + "\" style=\"stroke:#000000; fill:#797D7F\" />");

    }//assignCanvasFront

    private void assignStolpe() {

        int height = defineStolpeHeight();
        int width = defineStolpeWidth();

        blueprint.setStolpe(placeStolpe(height, width));

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

    private ArrayList<String> placeStolpe(int height, int width) {
        ArrayList<String> stolper = new ArrayList<>();
        int quantity = 0;
        int halfWidth = width / 2;
        int distance = carport.getConfLength() - 200;
        int pushRight = 100;
        int insertRight = pushRight - halfWidth;
        int pushDown = carport.getConfWidth() - height;


        for (Map.Entry<Component, Integer> entry : compList.entrySet()) {
            if (entry.getKey().getCompDesc().equalsIgnoreCase("stolpe")) {
                quantity = entry.getValue() / 2;
            }//if
        }//for
        distance /= quantity - 1;


        stolper.add("<rect x=\"" + insertRight + "\" y=\"" + 0 + "\" height=\"" + height + "\" width=\"" + width + "\" " +
                "style=\"stroke:#000000; fill:#ffffff\"/>");

        for (int i = 1; i < quantity; i++) {
            pushRight += distance;
            insertRight = pushRight - halfWidth;
            stolper.add("<rect x=\"" + insertRight + "\" y=\"" + 0 + "\" height=\"" + height + "\" width=\"" + width + "\" " +
                    "style=\"stroke:#000000; fill:#ffffff\"/>");
        }//for

        pushRight = 100;
        insertRight = pushRight - halfWidth;
        stolper.add("<rect x=\"" + insertRight + "\" y=\"" + pushDown + "\" height=\"" + height + "\" width=\"" + width + "\" " +
                "style=\"stroke:#000000; fill:#ffffff\"/>");

        for (int i = 1; i < quantity; i++) {
            pushRight += distance;
            insertRight = pushRight - halfWidth;
            stolper.add("<rect x=\"" + insertRight + "\" y=\"" + pushDown + "\" height=\"" + height + "\" width=\"" + width + "\" " +
                    "style=\"stroke:#000000; fill:#ffffff\"/>");
        }//for
        return stolper;
    }//placeStolpe

    private void assignRem() {

        int height = defineRemHeight();
        int width = defineRemWidth();


        blueprint.setRem(placeRem(height, width)); //indsæt fra blueprintSVG

    }//assignRem

    private int defineRemWidth() {

        int width = 0;

        for (Map.Entry<Component, Integer> entry : compList.entrySet()) {
            if (entry.getKey().getCompDesc().equalsIgnoreCase("Rem")) {
                width = entry.getKey().getCompLength();
            }//if
        }//for
        return width;

    }//defineRemWidth

    private int defineRemHeight() {

        int height = 0;

        for (Map.Entry<Component, Integer> entry : compList.entrySet()) {
            if (entry.getKey().getCompDesc().equalsIgnoreCase("Rem")) {
                height = entry.getKey().getCompHeight();
            }//if
        }//for
        return height;

    }//defineRemHeight

    private ArrayList<String> placeRem(int heigth, int width) {
        ArrayList<String> remme = new ArrayList<>();
        int quantity = 0;
        int pushRight = 0;
        int pushDown = carport.getConfWidth() - heigth;

        for (Map.Entry<Component, Integer> entry : compList.entrySet()) {
            if (entry.getKey().getCompDesc().equalsIgnoreCase("rem")) {
                quantity = entry.getValue() / 2;
            }//if
        }//for

        remme.add("<rect x=\"" + pushRight + "\" y=\"" + 0 + "\" height=\"" + heigth + "\" width=\"" + width + "\" style=\"stroke:#000000; fill:#ffffff\" />");

        for (int i = 1; i < quantity; i++) {
            pushRight += width;
            remme.add("<rect x=\"" + pushRight + "\" y=\"" + 0 + "\" height=\"" + heigth + "\" width=\"" + width + "\" style=\"stroke:#000000; fill:#ffffff\" />");

        }//for

        pushRight = 0;
        remme.add("<rect x=\"" + pushRight + "\" y=\"" + pushDown + "\" height=\"" + heigth + "\" width=\"" + width + "\" style=\"stroke:#000000; fill:#ffffff\" />");

        for (int i = 1; i < quantity; i++) {
            pushRight += width;
            remme.add("<rect x=\"" + pushRight + "\" y=\"" + pushDown + "\" height=\"" + heigth + "\" width=\"" + width + "\" style=\"stroke:#000000; fill:#ffffff\" />");

        }//for

        return remme;

    }//placeRem

    private void assignSper() {

        int width = defineSperWidth();
        int heigth = defineSperHeigth();

        blueprint.setSper(placeSper(heigth, width)); //indsæt fra blueprintSVG

    }//assignSper

    private int defineSperWidth() {

        int width = 0;

        for (Map.Entry<Component, Integer> entry : compList.entrySet()) {
            if (entry.getKey().getCompDesc().equalsIgnoreCase("Spær")) {
                width = entry.getKey().getCompHeight();
            }//if
        }//for
        return width;

    }//defineSperWidth

    private int defineSperHeigth() {

        int height = 0;

        for (Map.Entry<Component, Integer> entry : compList.entrySet()) {
            if (entry.getKey().getCompDesc().equalsIgnoreCase("Spær")) {
                height = entry.getKey().getCompLength();
            }//if
        }//for
        return height;

    }//defineSperHeigth

    private ArrayList<String> placeSper(int heigth, int width) {
        ArrayList<String> sper = new ArrayList<>();
        int quantity = 0;
        int pushRight = 0;
        int insertRight;
        int distance;
        int halfWidth = width / 2;
        int sperLength = 0;

        for (Map.Entry<Component, Integer> entry : compList.entrySet()) {
            if (entry.getKey().getCompDesc().equalsIgnoreCase("Spær")) {
                quantity = entry.getValue();
                sperLength = entry.getKey().getCompLength();
            }//if
        }//for

        if (carport.getConfWidth() == sperLength) {
            distance = carport.getConfLength() / (quantity - 1);

            sper.add("<rect x=\"" + pushRight + "\" y=\"" + 0 + "\" height=\"" + heigth + "\" width=\"" + width + "\" style=\"stroke:#000000; fill:#ffffff\" />");
            for (int i = 1; i < quantity; i++) {
                pushRight += distance;
                insertRight = pushRight - halfWidth;
                sper.add("<rect x=\"" + insertRight + "\" y=\"" + 0 + "\" height=\"" + heigth + "\" width=\"" + width + "\" style=\"stroke:#000000; fill:#ffffff\" />");
            }//for
        } else {
            quantity /= 2;
            distance = carport.getConfLength() / (quantity - 1);

            sper.add("<rect x=\"" + pushRight + "\" y=\"" + 0 + "\" height=\"" + heigth + "\" width=\"" + width + "\" style=\"stroke:#000000; fill:#ffffff\" />");
            sper.add("<rect x=\"" + pushRight + "\" y=\"" + sperLength + "\" height=\"" + heigth + "\" width=\"" + width + "\" style=\"stroke:#000000; fill:#ffffff\" />");

            for (int i = 1; i < quantity; i++) {
                pushRight += distance;
                insertRight = pushRight - halfWidth;
                sper.add("<rect x=\"" + insertRight + "\" y=\"" + 0 + "\" height=\"" + heigth + "\" width=\"" + width + "\" style=\"stroke:#000000; fill:#ffffff\" />");
                sper.add("<rect x=\"" + insertRight + "\" y=\"" + sperLength + "\" height=\"" + heigth + "\" width=\"" + width + "\" style=\"stroke:#000000; fill:#ffffff\" />");
            }//for
        }//else

        return sper;
    }//placeSper

    private void assignStern() {

        int width = defineSternWidth();

        int length1 = defineSternOver1Length();
        int length2 = defineSternOver2Length(length1);

        blueprint.setStern(placeStern(length1, width, length2)); //indsæt fra blueprintSVG

    }//assignStern

    private int defineSternWidth() {

        int width = 0;

        for (Map.Entry<Component, Integer> entry : compList.entrySet()) {
            if (entry.getKey().getCompDesc().equalsIgnoreCase("Stern, over")) {
                width = entry.getKey().getCompWidth();
            }//if
        }//for
        return width;

    }//defineSternOverWidth

    private int defineSternOver1Length() {

        int length = 0;

        for (Map.Entry<Component, Integer> entry : compList.entrySet()) {
            if (entry.getKey().getCompDesc().equalsIgnoreCase("Stern, over")) {
                length = entry.getKey().getCompLength();
            }//if
        }//for
        return length;

    }//defineSternOver1Length

    private int defineSternUnder1Length() {

        int length = 0;

        for (Map.Entry<Component, Integer> entry : compList.entrySet()) {
            if (entry.getKey().getCompDesc().equalsIgnoreCase("Stern, under")) {
                length = entry.getKey().getCompLength();
            }//if
        }//for
        return length;

    }//defineSternUnder1Length

    private int defineSternOver2Length(int length1) {

        int length = 0;

        for (Map.Entry<Component, Integer> entry : compList.entrySet()) {
            if (entry.getKey().getCompDesc().equalsIgnoreCase("Stern, over") &&
                    entry.getKey().getCompLength() != length1) {
                length = entry.getKey().getCompLength();
            }//if
            if (length == 0) {
                length = length1;
            }
        }//for
        return length;

    }//defineSternOver2Length

    private int defineSternUnder2Length() {

        int length = 0;

        for (Map.Entry<Component, Integer> entry : compList.entrySet()) {
            if (entry.getKey().getCompDesc().equalsIgnoreCase("Stern, under")) {
                length = entry.getKey().getCompLength();
            }//if
        }//for

        return length;

    }//defineSternUnder2Length

    private ArrayList<String> placeStern(int height1, int width, int height2) {
        ArrayList<String> stern = new ArrayList<>();
        int quantity = 0;
        int pushRight = 0;
        int pushDown;

        for (Map.Entry<Component, Integer> entry1 : compList.entrySet()) {
            if (entry1.getKey().getCompDesc().equalsIgnoreCase("sper") && entry1.getKey().getCompLength() != height2) {
                quantity = entry1.getValue();
            }//if
        }//for

        pushDown = carport.getConfWidth() - width;
        for (int i = 0; i < quantity; i++) {
            stern.add("<rect x=\"" + pushRight + "\" y=\"" + 0 + "\" height=\"" + width + "\" width=\"" + height1 + "\" style=\"stroke:#000000; fill:#ffffff\" />");
            stern.add("<rect x=\"" + pushRight + "\" y=\"" + pushDown + "\" height=\"" + width + "\" width=\"" + height1 + "\" style=\"stroke:#000000; fill:#ffffff\" />");
            pushRight += height1;
        }//for


        for (Map.Entry<Component, Integer> entry2 : compList.entrySet()) {
            if (entry2.getKey().getCompDesc().equalsIgnoreCase("sper") && entry2.getKey().getCompLength() != height1) {
                quantity = entry2.getValue();
            }//if
        }//for

        pushRight = carport.getConfLength() - width;
        pushDown = 0;
        for (int i = 0; i < quantity; i++) {
            stern.add("<rect x=\"" + 0 + "\" y=\"" + pushDown + "\" height=\"" + height2 + "\" width=\"" + width + "\" style=\"stroke:#000000; fill:#ffffff\" />");
            stern.add("<rect x=\"" + pushRight + "\" y=\"" + pushDown + "\" height=\"" + height2 + "\" width=\"" + width + "\" style=\"stroke:#000000; fill:#ffffff\" />");
            pushDown += height2;
        }//for

        return stern;
    }//placeStern
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

    public Blueprint getBlueprint() {
        return blueprint;
    }
}//class
