package DBAccess;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class ConfigurationStatusMapper {

    public static List<String> getAllConfigStatusTypes() {
        List<String> configs = new LinkedList<>();

        try {
            Connection con = Connector.connection();
            String SQL = "SELECT confStatus FROM configurationstatus ORDER BY confStatusId;";
            PreparedStatement ps = con.prepareStatement(SQL);

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                System.out.println(rs.getString(1));
                configs.add(rs.getString(1));
            }//while
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println(ex);
        }//catch

        return configs;
    }//getAllConfigs
}