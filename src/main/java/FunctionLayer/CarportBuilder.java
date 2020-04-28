package FunctionLayer;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CarportBuilder {

    ArrayList<Object> components = new ArrayList();

    public CarportBuilder(ArrayList components) {
        this.components = components;
    }

    public CarportBuilder() {
    }

    //Metoder
    public static void buildCarport(ArrayList<Roof> myRoofList, ArrayList<Stolpe> myStolpeList){
        for(int i = 0; i < myRoofList.size(); i++){
            System.out.println(myRoofList.toString());
        }

    }

}//Class
