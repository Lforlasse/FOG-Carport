package FunctionLayer;

import DBAccess.*;

import java.util.ArrayList;
import java.util.LinkedList;
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
                                         int roofInclination, String roofMaterial,
                                         String custName, String custPhone, String custEmail, String custPostal,
                                         boolean right, boolean left, boolean back)
            throws LoginSampleException {
        //TODO Test data, replace with DBAccess method
        int confId = ConfigurationMapper.newOfferRequest(length, width, height, confMaterial,
                roofInclination, roofMaterial, custName, custPhone, custEmail, custPostal, right, left, back);

        //ekstra
        System.out.println();
        System.out.println("NEW offer request: " + confId);
        return confId;
    }

    public static ArrayList<Carport> getAllOfferRequests() {
        return ConfigurationMapper.getAllConfigs();
    }

    public static OfferRequest getOfferRequest(int confId) {
        return new OfferRequest(confId);
    }

    public static String getOfferRequestStatus(int confId) {
        return ConfigurationMapper.getConfigStatus(confId);
    }

    public static List<String> getOfferRequestStatusTypes() {
        return new LinkedList<>(ConfigurationStatusMapper.getAllConfigStatusTypes());
    }

    public static boolean updateOfferRequestStatus(int confId, String offerRequestStatus) {
        return ConfigurationMapper.setConfigStatus(confId, offerRequestStatus);
    }
}
