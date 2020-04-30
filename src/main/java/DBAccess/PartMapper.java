package DBAccess;

import FunctionLayer.Part;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class PartMapper {

    public static Part getPart(String partIdentifier){

        int partId = 0;
        String partDesc = "Ingen del fundet";
        String itemType = "0";
        int vendorPrice = 0;
        int salesPrice = 0;

        try {
            Connection con = Connector.connection();
            String SQL = "SELECT partId, partDesc, itemType, vendorPrice, salesPrice " +
                    "FROM parts WHERE partDesc =?";
            PreparedStatement ps = con.prepareStatement(SQL);
            ps.setString(1, partIdentifier);

            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                partId=rs.getInt(1);
                partDesc=rs.getString(2);
                itemType=rs.getString(3);
                vendorPrice=rs.getInt(4);
                salesPrice=rs.getInt(5);

            }//if
        } catch (ClassNotFoundException | SQLException ex) {

        }//catch
        Part part = new Part(partId, partDesc, itemType, vendorPrice, salesPrice);
        return part;
    }//getPart

}//PartMapper