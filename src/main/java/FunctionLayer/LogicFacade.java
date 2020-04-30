package FunctionLayer;

import DBAccess.*;

import java.util.ArrayList;
import java.util.List;

public class LogicFacade {

    public static User login(String email, String password) throws LoginSampleException {
        return UserMapper.login(email, password);
    }

    public static User createUser(String email, String password) throws LoginSampleException {
        User user = new User(email, password, "customer");
        UserMapper.createUser(user);
        return user;
    }

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

    public static int submitOfferRequest(int length, int width, int height, String configMaterial,
                                          int roofAngle, String roofMaterial,
                                          String name, String email, String phone, String postcode)
            throws LoginSampleException {
        //TODO Test data, replace with DBAccess method
        int offerRequestId = ConfigurationMapper.newOfferRequest(length, width, height, configMaterial,
                roofAngle, roofMaterial, name, email, phone, postcode);

        System.out.println();
        System.out.println("NEW offer request: " + offerRequestId);
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
        return offerRequestId;
    }

    public static ArrayList<Carport> getAllOfferRequests() {
        return ConfigurationMapper.getAllConfigs();
    }

    public static Carport getOfferRequest(int configId) {
        return ConfigurationMapper.getOneConfig(configId);
    }
}
