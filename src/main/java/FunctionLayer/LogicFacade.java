package FunctionLayer;

import DBAccess.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class LogicFacade {

    public static List<String> carportMaterials() {
        /*
        List<String> list = new ArrayList<>();
        list.add("Materiale 1");
        list.add("Materiale 2");
        list.add("Materiale 3");
        list.add("Materiale 4");
        */
        // Test data end
        return MaterialMapper.getConfigMaterials();
    }

    public static List<String> roofMaterials() {
        /*
        List<String> list = new ArrayList<>();
        list.add("Tag materiale 1");
        list.add("Tag materiale 2");
        list.add("Tag materiale 3");
        list.add("Tag materiale 4");
         */
        // Test data end
        return RoofMapper.getRoofMaterials();
    }

    public static List<Integer> widthLimits() {
        //TODO Test data, replace with DBAccess method
        List<Integer> list = new ArrayList<>();
        list.add(300);
        list.add(600);
        // Test data end
        return list;
    }

    public static List<Integer> lengthLimits() {
        //TODO Test data, replace with DBAccess method
        List<Integer> list = new ArrayList<>();
        list.add(300);
        list.add(600);
        // Test data end
        return list;
    }

    public static List<Integer> heightLimits() {
        //TODO Test data, replace with DBAccess method
        List<Integer> list = new ArrayList<>();
        list.add(200);
        list.add(300);
        // Test data end
        return list;
    }

    public static List<Integer> roofAngleLimits() {
        //TODO Test data, replace with DBAccess method
        List<Integer> list = new ArrayList<>();
        list.add(10);
        list.add(20);
        // Test data end
        return list;
    }

    public static int submitOfferRequest(int length, int width, int height, String confMaterial,
                                          int roofAngle, String roofMaterial,
                                          String custName, String custPhone, String custEmail, String custPostal)
            throws LoginSampleException {
        //TODO Test data, replace with DBAccess method
        int confId = ConfigurationMapper.newOfferRequest(length, width, height, confMaterial,
                roofAngle, roofMaterial, custName, custPhone, custEmail, custPostal);

        System.out.println();
        System.out.println("NEW offer request: " + confId);
        /*
        System.out.println("length: " + length);
        System.out.println("width: " + width);
        System.out.println("height: " + height);
        System.out.println("configMaterial: " + configMaterial);
        System.out.println("roofAngle: " + roofAngle);
        System.out.println("roofMaterial: " + roofMaterial);
        System.out.println("name: " + name);
        System.out.println("email: " + email);
        System.out.println("phone: " + phone);
        System.out.println("postcode: " + postcode);
        */
        return confId;
    }

    public static ArrayList<Carport> getAllOfferRequests() {
        return ConfigurationMapper.getAllConfigs();
    }

    public static OfferRequest getOfferRequest(int confId) {
        return new OfferRequest(confId);
    }
}
