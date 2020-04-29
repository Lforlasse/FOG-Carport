package DBAccess;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MaterialMapper {

    public static List<String> getConfigMaterials() {
        List<String> materialList = new ArrayList<>();

        try {
            Connection con = Connector.connection();
            String SQL = "SELECT * FROM carport.materials;";
            PreparedStatement ps = con.prepareStatement(SQL);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                materialList.add(rs.getString("materialName"));
            }
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println(ex);
        }
        return materialList;
    }
}