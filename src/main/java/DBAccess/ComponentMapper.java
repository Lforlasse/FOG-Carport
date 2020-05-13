package DBAccess;

import FunctionLayer.Component;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class ComponentMapper {

    public static Component getComponent(String type, String compMaterial){

        int compId = 0;
        String compDesc = "Ingen komponent fundet";
        String material = "0";
        int compHeight = 0;
        int compWidth = 0;
        int compLength = 0;
        int vendorPrice = 0;
        int salesPrice = 0;

        try {
            Connection con = Connector.connection();
            String SQL = "SELECT compId, compDesc, material, compHeigth, compWidth, compLength, vendorPrice," +
                    " salesPrice FROM Components WHERE compDesc =? AND material =?";
            PreparedStatement ps = con.prepareStatement(SQL);
            ps.setString(1, type);
            ps.setString(2, compMaterial);

            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                compId=rs.getInt(1);
                compDesc=rs.getString(2);
                material=rs.getString(3);
                compHeight=rs.getInt(4);
                compWidth=rs.getInt(5);
                compLength=rs.getInt(6);
                vendorPrice=rs.getInt(7);
                salesPrice=rs.getInt(8);

            }//if
        } catch (ClassNotFoundException | SQLException ex) {

        }//catch
        Component component = new Component(compId, compDesc, material, compHeight, compWidth, compLength, vendorPrice, salesPrice);
        return component;
    }//getComponent

    public static Component getComponentById(int compId){

        String compDesc = "Ingen komponent fundet";
        String material = "0";
        int compHeight = 0;
        int compWidth = 0;
        int compLength = 0;
        int vendorPrice = 0;
        int salesPrice = 0;

        try {
            Connection con = Connector.connection();
            String SQL = "SELECT compDesc, material, compHeigth, compWidth, compLength, vendorPrice," +
                    " salesPrice FROM Components WHERE compId = ?";
            PreparedStatement ps = con.prepareStatement(SQL);
            ps.setInt(1, compId);

            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                compDesc=rs.getString(1);
                material=rs.getString(2);
                compHeight=rs.getInt("compHeigth");
                compWidth=rs.getInt("compWidth");
                compLength=rs.getInt("compLength");
                vendorPrice=rs.getInt("vendorPrice");
                salesPrice=rs.getInt("salesPrice");

            }//if
        } catch (ClassNotFoundException | SQLException ex) {

        }//catch
        Component component = new Component(compId, compDesc, material, compHeight, compWidth, compLength, vendorPrice, salesPrice);
        return component;
    }//getComponent

}//ComponentMapper
