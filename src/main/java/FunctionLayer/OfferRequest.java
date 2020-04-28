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
        this.vendorPrice = totalVendorPrice(); //TODO metode til total vendor pris.
        this.salesPrice = totalSalesPrice(); //TODO metode til total salgspris.
        this.profit = totalProfit(); //TODO metode til total profit.
    }

    public OfferRequest() { //OBS. mangler svar fra EMIL.
    }

    //metoder
    private void generateCompList(){
        addStolper();
        addRemme();
        addSper();
        addLegter();
        addStern();

    }//generateCompList

    private void addStolper(){

        carport.setConfLength(-400);
        int countUnit = 4;
        for (int i = carport.getConfLength() ;i > 0; i -= 200 ){
            countUnit += 2;
        }

        carport.setConfWidth(-400);
        for (int i = carport.getConfWidth() ;i > 0; i -= 200 ){
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

    private static void addRemme(){


    }//addStolper

    private static void addSper(){
        // et spær lægges for hver meter
        // L/100 = Sper


    }//addStolper

    private static void addLegter(){
        //

    }//addStolper

    private static void addStern(){
        //en stern er går rundt i omkredsen af carporten
        //L+L+B+B = Stern


    }//addStolper

}//class
