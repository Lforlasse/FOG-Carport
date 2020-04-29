package DBAccess;

import FunctionLayer.Component;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class ComponentMapper {

    public static Component getComponent(String type, String compMaterial){

        int compId = 0;
        String compDescription = "Ingen komponent fundet";
        String material = "0";
        int compLength = 0;
        int vendorPrice = 0;
        int salesPrice = 0;

        try {
            Connection con = Connector.connection();
            String SQL = "SELECT compId, compDescription, material, compHeigth, compWidth, compLength, vendorPrice," +
                    " salesPrice FROM Components WHERE compDescription =? AND material =?";
            PreparedStatement ps = con.prepareStatement(SQL);
            ps.setString(1, type);
            ps.setString(2, compMaterial);

            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                compId=rs.getInt(1);
                compDescription=rs.getString(2);
                material=rs.getString(3);
                compLength=rs.getInt(4);
                vendorPrice=rs.getInt(5);
                salesPrice=rs.getInt(6);

            }//if
        } catch (ClassNotFoundException | SQLException ex) {

        }//catch
        Component component = new Component(compId, compDescription, material, compLength, vendorPrice, salesPrice);
        return component;
    }//getComponent

}//ComponentMapper
