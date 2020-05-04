package DBAccess;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ConfigurationStatusMapper {

    public static ArrayList<String> getAllConfigStatusTypes() {
        ArrayList<String> configs = new ArrayList<>();

        try {
            Connection con = Connector.connection();
            String SQL = "SELECT * FROM configurationstatus;";
            PreparedStatement ps = con.prepareStatement(SQL);

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                configs.add(rs.getString(1));
            }//while
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println(ex);
        }//catch

        return configs;
    }//getAllConfigs
}
