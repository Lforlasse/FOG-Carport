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

    public static String getMaterialByName(String compMaterial) {
        String material = "";
        try {
            Connection con = Connector.connection();
            String SQL = "SELECT materialName FROM materials WHERE materialName = ?";
            PreparedStatement ps = con.prepareStatement(SQL);
            ps.setString(1, compMaterial);
            ps.executeUpdate();
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println(ex);
        }
        return material;
    }

    public static boolean insertNewMaterial(String compMaterial) {
        try {
            Connection con = Connector.connection();
            String SQL = "INSERT INTO materials (materialName) VALUES (?)";
            PreparedStatement ps = con.prepareStatement(SQL);
            ps.setString(1, compMaterial);
            ps.executeUpdate();
            return true;
        } catch (ClassNotFoundException | SQLException ex) {
            return false;
        }
    }
}