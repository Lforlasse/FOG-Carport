package FunctionLayer;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

import java.util.HashMap;
import java.util.Map;

public class YES {
    public static void main(String[]args){
        OfferRequest yes = new OfferRequest(224466);
        System.out.println(yes.getCarport().getCustName());

        for (Map.Entry<Component, Integer> entry : yes.getCompList().entrySet()) {
            //System.out.println(yes.getCompList().);
            System.out.println(entry.getKey().getCompDesc());
        }

        }

    }




//    HashMap<String, HashMap> selects = new HashMap<String, HashMap>();
//
//  for(Map.Entry<String, HashMap> entry : selects.entrySet()) {
//        String key = entry.getKey();
//        HashMap value = entry.getValue();