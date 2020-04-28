package FunctionLayer;

import java.util.ArrayList;

public class YES {
    public static void main(String[]args){

        ArrayList<Roof> myRoofList = new ArrayList();
        ArrayList<Stolpe> myStolpeList = new ArrayList();

        Stolpe myStolpe1 = new Stolpe(10, 250, "jaja", "stolper");
        Stolpe myStolpe2 = new Stolpe(10, 250, "jaja", "stolper");
        Stolpe myStolpe3 = new Stolpe(10, 250, "jaja", "stolper");
        Stolpe myStolpe4 = new Stolpe(10, 250, "jaja", "stolper");
        Roof myRoof = new Roof(59, 200, 200, 20, "rem", "spaer", "stern", "vandbraet", "traeSort");

        CarportBuilder myCarport = new CarportBuilder();

        myRoofList.add(myRoof);
        myStolpeList.add(myStolpe1);
        myStolpeList.add(myStolpe2);
        myStolpeList.add(myStolpe3);
        myStolpeList.add(myStolpe4);

        myCarport.buildCarport(myRoofList, myStolpeList);
    }
}
