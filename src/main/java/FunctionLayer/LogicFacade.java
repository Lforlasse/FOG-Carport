package FunctionLayer;

import DBAccess.UserMapper;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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
        //TODO Test data, replace with DBAccess method
        List<String> list = new ArrayList<>();
        list.add("Materiale 1");
        list.add("Materiale 2");
        list.add("Materiale 3");
        list.add("Materiale 4");
        // Test data end
        return list;
    }

    public static List<String> roofMaterials() {
        //TODO Test data, replace with DBAccess method
        List<String> list = new ArrayList<>();
        list.add("Tag materiale 1");
        list.add("Tag materiale 2");
        list.add("Tag materiale 3");
        list.add("Tag materiale 4");
        // Test data end
        return list;
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

    public static int submitConfigRequest(int length, int width, int height, String configMaterial,
                                          int roofAngle, String roofMaterial,
                                          String name, String email, String phone, String postcode) {
        //TODO Test data, replace with DBAccess method
        int configRequestId = 6969;
        System.out.println();
        System.out.println("configRequestId: " + configRequestId);
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
        return configRequestId;
    }
}
