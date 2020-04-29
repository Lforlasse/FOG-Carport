package DBAccess;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RoofMapper {

    public static List<String> getRoofMaterials() {
        List<String> materialList = new ArrayList<>();

        try {
            Connection con = Connector.connection();
            String SQL = "SELECT compDescription FROM carport.roof;";
            PreparedStatement ps = con.prepareStatement(SQL);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                materialList.add(rs.getString("compDescription"));
            }
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println(ex);
        }
        return materialList;
    }
}