package DBAccess;

import FunctionLayer.Roof;
import FunctionLayer.RoofUnit;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RoofMapper {

    /**
     *
     * @return en liste med materialer til tag
     */
    public static List<String> getRoofMaterials() {
        List<String> materialList = new ArrayList<>();

        try {
            Connection con = Connector.connection();
            String SQL = "SELECT roofDesc FROM carport.roof;";
            PreparedStatement ps = con.prepareStatement(SQL);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                materialList.add(rs.getString("roofDesc"));
            }
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println(ex);
        }
        return materialList;
    }

    /**
     *
     * @param roofUnitIdentifier tager imod roofUnitId
     * @return roofUnit på dette id
     */
    public static RoofUnit getRoofUnit(String roofUnitIdentifier) {

        int unitId = 0;
        String unitDesc = "Ingen tagdel fundet";
        int unitLength = 0;
        int unitWidth = 0;
        int vendorPrice = 0;
        int salesPrice = 0;

        try {
            Connection con = Connector.connection();
            String SQL = "SELECT roofId, roofDesc, roofLength, roofWidth, vendorPrice, salesPrice " +
                    "FROM roof WHERE roofDesc =?";
            PreparedStatement ps = con.prepareStatement(SQL);
            ps.setString(1, roofUnitIdentifier);

            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                unitId=rs.getInt(1);
                unitDesc=rs.getString(2);
                unitLength=rs.getInt(3);
                unitWidth=rs.getInt(4);
                vendorPrice=rs.getInt(5);
                salesPrice=rs.getInt(6);

            }//if
        } catch (ClassNotFoundException | SQLException ex) {

        }//catch

        RoofUnit roofUnit = new RoofUnit(unitId,unitDesc,unitLength,unitWidth,vendorPrice,salesPrice);
        return roofUnit;
    }

    /**
     *
     * @param material tager imod materiale
     * @return sætter materialet til tagets ønskede længde
     */
    public static int getRoofCompLength(String material) {

        int roofCompLength = 0;
        try {
            Connection con = Connector.connection();
            String SQL = "SELECT roofLength FROM roof WHERE roofDesc =?";
            PreparedStatement ps = con.prepareStatement(SQL);
            ps.setString(1,material);

            ResultSet rs = ps.executeQuery();
            if(rs.next()) {
                roofCompLength = rs.getInt(1);
            }//if

        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println(ex);
        }//catch
        return roofCompLength;
    }//getRoofCompLength

    /**
     *
     * @param material tager imod materiale
     * @return sætter materialet til tagets ønskede bredde
     */
    public static int getRoofCompWidth(String material) {

        int roofCompWidth = 0;
        try {
            Connection con = Connector.connection();
            String SQL = "SELECT roofWidth FROM roof WHERE roofDesc =?";
            PreparedStatement ps = con.prepareStatement(SQL);
            ps.setString(1,material);

            ResultSet rs = ps.executeQuery();
            if(rs.next()) {
                roofCompWidth = rs.getInt(1);
            }//if

        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println(ex);
        }//catch
        return roofCompWidth;

    }//getRoofCompWidth
}//class