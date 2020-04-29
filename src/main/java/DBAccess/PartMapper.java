package DBAccess;

import FunctionLayer.Part;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class PartMapper {

    public static Part getPart(String type, String compMaterial){

        int partsId = 0;
        String partDescription = "Ingen del fundet";
        String itemType = "0";
        int currentStock = 0;
        int vendorPrice = 0;
        int salesPrice = 0;

        try {
            Connection con = Connector.connection();
            String SQL = "SELECT partsId, partDescription, itemType, currentStock, vendorPrice, salesPrice " +
                    "FROM parts WHERE partDescription =? and itemType =?";
            PreparedStatement ps = con.prepareStatement(SQL);
            ps.setString(1, partDescription);
            ps.setString(2, itemType);

            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                partsId=rs.getInt(1);
                partDescription=rs.getString(2);
                itemType=rs.getString(3);
                currentStock=rs.getInt(4);
                vendorPrice=rs.getInt(5);
                salesPrice=rs.getInt(6);

            }//if
        } catch (ClassNotFoundException | SQLException ex) {

        }//catch
        Part part = new Part(partsId, partDescription, itemType, currentStock, vendorPrice, salesPrice);
        return part;
    }//getPart

}//PartMapper