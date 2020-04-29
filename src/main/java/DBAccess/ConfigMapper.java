package DBAccess;

import FunctionLayer.LoginSampleException;

import java.sql.*;

public class ConfigMapper {

    public static int configRequestToDB(int length, int width, int height, String configMaterial,
                                        int roofAngle, String roofMaterial,
                                        String name, String email, String phone, String postcode) throws LoginSampleException {
        int configId;
        try {
            //TODO Implement remaining data/variables
            Connection con = Connector.connection();
            String SQL = "INSERT INTO configurations (configStatus, custName, custPhone, custPostal, length, width, height, material) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, "Ny");
            ps.setString(2, name);
            ps.setString(3, phone);
            ps.setString(4, postcode);
            ps.setInt(5, length);
            ps.setInt(6, width);
            ps.setInt(7, height);
            ps.setString(8, configMaterial);
            ps.executeUpdate();

            ResultSet ids = ps.getGeneratedKeys();
            ids.next();
            configId = ids.getInt(1);

        } catch (SQLException | ClassNotFoundException e) {
            throw new LoginSampleException(e.getMessage());
        }
        return configId;
    }
}
