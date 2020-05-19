package DBAccess;

import FunctionLayer.Component;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ComponentMapper {

    /**
     *
     * @param type henter typen valgt af bruger fra DB
     * @param compMaterial henter materiale valgt af bruger fra DB
     * @return retunerer komponent
     */
    public static Component getComponent(String type, String compMaterial) {

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
                compId = rs.getInt(1);
                compDesc = rs.getString(2);
                material = rs.getString(3);
                compHeight = rs.getInt(4);
                compWidth = rs.getInt(5);
                compLength = rs.getInt(6);
                vendorPrice = rs.getInt(7);
                salesPrice = rs.getInt(8);

            }//if
        } catch (ClassNotFoundException | SQLException ex) {

        }//catch
        Component component = new Component(compId, compDesc, material, compHeight, compWidth, compLength, vendorPrice, salesPrice);
        return component;
    }//getComponent

    /**
     *
     * @param compId henter komponent fra DB på komponents id.
     * @return komponent
     */
    public static Component getComponentById(int compId) {

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
                compDesc = rs.getString("compDesc");
                material = rs.getString("material");
                compHeight = rs.getInt("compHeigth");
                compWidth = rs.getInt("compWidth");
                compLength = rs.getInt("compLength");
                vendorPrice = rs.getInt("vendorPrice");
                salesPrice = rs.getInt("salesPrice");

            }//if
        } catch (ClassNotFoundException | SQLException ex) {

        }//catch
        Component component = new Component(compId, compDesc, material, compHeight, compWidth, compLength, vendorPrice, salesPrice);
        return component;
    }//getComponent

    /**
     *
     * @param compId finder komponent på id
     * @param newSalesPrice tager ny salgpris
     * @return komponent med ny salgspris
     */
    public static boolean updateComponentSalesPrice(int compId, int newSalesPrice) {
        try {
            Connection con = Connector.connection();
            String SQL = "UPDATE components SET salesPrice = ? WHERE compId = ?";
            PreparedStatement ps = con.prepareStatement(SQL);
            ps.setInt(1, newSalesPrice);
            ps.setInt(2, compId);
            ps.executeUpdate();
            return true;
        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println(ex);
            return false;
        }
    }

    /**
     *
     * @param compDesc tager imod beskrivelse til DB
     * @param compMaterial tager imod materiale til DB
     * @param compHeight tager imod højde til DB
     * @param compWidth tager imod bredde til DB
     * @param compLenght tager imod længde til DB
     * @param compVendorPrice tager imod indkøbspris til DB
     * @param compSalesPrice tager imod salgspris til DB
     * @return
     */
    public static boolean insertNewComponent(String compDesc, String compMaterial, int compHeight, int compWidth, int compLenght, int compVendorPrice, int compSalesPrice) {
        try {
            Connection con = Connector.connection();
            String SQL ="INSERT INTO components (compDesc, material, compHeigth, compWidth, compLength, vendorPrice, salesPrice) " +
                    "VALUES (?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(SQL);
            ps.setString(1, compDesc);
            ps.setString(2, compMaterial);
            ps.setInt(3, compHeight);
            ps.setInt(4, compWidth);
            ps.setInt(5, compLenght);
            ps.setInt(6, compVendorPrice);
            ps.setInt(7, compSalesPrice);
            ps.executeUpdate();
            return true;
        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println(ex);
            return false;
        }
    }

    /**
     *
     * @return alle komponenter som en Liste
     */
    public static List<Component> getAllComponents() {
        List<Component> compList = new ArrayList<>();
        try {
            Connection con = Connector.connection();
            String SQL="SELECT * FROM components";
            PreparedStatement ps = con.prepareStatement(SQL);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int compId = rs.getInt("compId");
                String compDesc = rs.getString("compDesc");
                String material = rs.getString("material");
                int compHeight = rs.getInt("compHeigth");
                int compWidth = rs.getInt("compWidth");
                int compLength = rs.getInt("compLength");
                int vendorPrice = rs.getInt("vendorPrice");
                int salesPrice = rs.getInt("salesPrice");
                compList.add(new Component(compId,compDesc, material, compHeight,
                        compWidth, compLength, vendorPrice, salesPrice ));
            }
        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println(ex);;
        }
        return compList;
    }
}//ComponentMapper
