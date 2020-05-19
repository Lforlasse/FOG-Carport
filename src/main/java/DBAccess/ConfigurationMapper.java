package DBAccess;

import FunctionLayer.Carport;
import FunctionLayer.LoginSampleException;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ConfigurationMapper {

    /**
     *
     * @param getConfId henter configuration på id
     * @return carport objekt på det hentede id
     */
    public static Carport makeConfigObject(int getConfId) {
        Carport carport = null;

        try {
            Connection con = Connector.connection();
            String SQL = "SELECT confId, custName, custPhone, custEmail, custPostal, width, length, height, material, roofInclination, roofMaterial FROM configurations WHERE confId =?;";
            PreparedStatement ps = con.prepareStatement(SQL);
            ps.setInt(1, getConfId);

            ResultSet rs = ps.executeQuery();
            rs.next();
            carport = new Carport(
                    rs.getInt(1),
                    rs.getString(2),
                    rs.getInt(3),
                    rs.getString(4),
                    rs.getInt(5),
                    rs.getInt(6),
                    rs.getInt(7),
                    rs.getInt(8),
                    rs.getString(9),
                    rs.getInt(10),
                    rs.getString(11));

        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println(ex);
        }//catch

        //Når ROOF er skabt
//        try {
//            Connection con = Connector.connection();
//            String SQL = "SELECT compDesc FROM roof WHERE compDesc = ?";
//            PreparedStatement ps = con.prepareStatement(SQL);
//            ps.setString(1, confRoof);
//
//            ResultSet rs = ps.executeQuery();
//            if (rs.next()) {
//                confRoof = rs.getString(1);
//
//            }//if
//        } catch (ClassNotFoundException | SQLException ex) {
//            System.out.println(ex);
//        }//catch
        return carport;
    }//makeConfigObject

    /**
     *
     * @param length tager imod længde
     * @param width tager imod bredde
     * @param height tager imod højde
     * @param confMaterial tager imod materiale
     * @param inclination tager imod hældning
     * @param roofMaterial tager imod materiale til tag
     * @param custName tager imod kundens navn
     * @param custPhone tager imod kundes tlfnr
     * @param custEmail tager imod kundes email
     * @param custPostal tager imod kundens postnummer
     * @param right tager imod valg af beklædning højre
     * @param left tager imod valg af beklædning venstre
     * @param back tager imod valg af beklædning bagside
     * @return offerequestid
     * @throws LoginSampleException
     */
    public static int newOfferRequest(int length, int width, int height, String confMaterial,
                                      int inclination, String roofMaterial,
                                      String custName, String custPhone, String custEmail, String custPostal,
                                      boolean right, boolean left, boolean back) throws LoginSampleException {
        int offerRequestId;
        try {
            //TODO Implement remaining data/variables
            Connection con = Connector.connection();
            String SQL = "INSERT INTO configurations (confStatus, custName, custPhone, custEmail, custPostal, " +
                    "length, width, height, material, rightSide, leftSide, backSide, roofInclination, roofMaterial) " +
                    "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, "Ny");
            ps.setString(2, custName);
            ps.setString(3, custPhone);
            ps.setString(4, custEmail);
            ps.setString(5, custPostal);
            ps.setInt(6, length);
            ps.setInt(7, width);
            ps.setInt(8, height);
            ps.setString(9, confMaterial);
            ps.setBoolean(10, right);
            ps.setBoolean(11, left);
            ps.setBoolean(12, back);
            ps.setInt(13, inclination);
            ps.setString(14, roofMaterial);
            ps.executeUpdate();

            ResultSet ids = ps.getGeneratedKeys();
            ids.next();
            offerRequestId = ids.getInt(1);

        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println(ex);
            throw new LoginSampleException(ex.getMessage());
        }
        return offerRequestId;
    }

    /**
     *
     * @param confId tager imod konfigurations id
     * @param confStatus sætter status for id
     * @return opdateret status
     */
    public static boolean setConfigStatus(int confId, String confStatus) {
        boolean result = false;
        try {
            Connection con = Connector.connection();
            String SQL = "UPDATE configurations SET confStatus = ? WHERE confId = ?;";
            PreparedStatement ps = con.prepareStatement(SQL);
            ps.setString(1, confStatus);
            ps.setInt(2, confId);
            ps.executeUpdate();
            result = true;
        } catch (ClassNotFoundException | SQLException ex) {

        }
        return result;
    }

    /**
     *
     * @param confId tager imod konfigurations id
     * @return konfiguration af carport på dette id
     */
    public static Carport getOneConfig(int confId) {
        Carport carport = null;
        try {
            Connection con = Connector.connection();
            String SQL = "SELECT confId, custName, custPhone, custEmail, custPostal, width, length, height, material, roofInclination, roofMaterial FROM configurations WHERE confId =?;";
            PreparedStatement ps = con.prepareStatement(SQL);
            ps.setInt(1, confId);

            ResultSet rs = ps.executeQuery();
            rs.next();
            carport = new Carport(rs.getInt(1),
                    rs.getString(2),
                    rs.getInt(3),
                    rs.getString(4),
                    rs.getInt(5),
                    rs.getInt(6),
                    rs.getInt(7),
                    rs.getInt(8),
                    rs.getString(9),
                    rs.getInt(10),
                    rs.getString(11));
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println(ex);
        }//catch
        return carport;
    }//getOneConfig

    /**
     *
     * @return en liste af alle carport konfigurationer
     */
    public static ArrayList<Carport> getAllConfigs() {
        ArrayList<Carport> configs = new ArrayList<>();

        try {
            Connection con = Connector.connection();
            String SQL = "SELECT confId, custName, custPhone, custEmail, custPostal, width, length, height, material, roofInclination, roofmaterial FROM configurations;";
            PreparedStatement ps = con.prepareStatement(SQL);

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                configs.add(new Carport(rs.getInt(1),
                        rs.getString(2),
                        rs.getInt(3),
                        rs.getString(4),
                        rs.getInt(5),
                        rs.getInt(6),
                        rs.getInt(7),
                        rs.getInt(8),
                        rs.getString(9),
                        rs.getInt(10),
                        rs.getString(11)));
            }//while
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println(ex);
        }//catch

        return configs;
    }//getAllConfigs

    /**
     *
     * @param confId tager imod konfigurations id
     * @return status på dette id
     */
    public static String getConfigStatus(int confId) {
        String confStatus = "";
        try {
            Connection con = Connector.connection();
            String SQL = "SELECT confStatus FROM configurations WHERE confId = ?;";
            PreparedStatement ps = con.prepareStatement(SQL);
            ps.setInt(1, confId);
            ResultSet rs = ps.executeQuery();
            rs.next();
            confStatus = rs.getString("confStatus");
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println(ex);
        }
        return confStatus;
    }

    /**
     *
     * @param confId tager imod konfigurations id
     * @return oprettelsesdatoen for dette id
     */
    public static Date getCreatedDate(int confId) {
        Date createdDate = null;
        try {
            Connection con = Connector.connection();
            String SQL = "SELECT createdDate FROM configurations WHERE confId = ?;";
            PreparedStatement ps = con.prepareStatement(SQL);
            ps.setInt(1, confId);
            ResultSet rs = ps.executeQuery();
            rs.next();
            createdDate = rs.getDate("createdDate");
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println(ex);
        }
        return createdDate;
    }

    /**
     *
     * @param confId tager imod konfigurations id
     * @return datoen for ændringe rlavet på konfig id
     */
    public static Date getChangedDate(int confId) {
        Date changedDate = null;
        try {
            Connection con = Connector.connection();
            String SQL = "SELECT changedDate FROM configurations WHERE confId = ?;";
            PreparedStatement ps = con.prepareStatement(SQL);
            ps.setInt(1, confId);
            ResultSet rs = ps.executeQuery();
            rs.next();
            changedDate = rs.getDate("changedDate");
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println(ex);
        }
        return changedDate;
    }

    /**
     *
     * @param confId tager imod konfig id
     * @param changedDate tager imod ny dato
     * @return konfig med dato af ændringer
     */
    public static boolean setChangedDate(int confId, Date changedDate) {
        boolean result = false;
        try {
            Connection con = Connector.connection();
            String SQL = "UPDATE configurations SET changedDate = ? WHERE confId = ?;";
            PreparedStatement ps = con.prepareStatement(SQL);
            ps.setDate(1, (java.sql.Date) changedDate);
            ps.setInt(2, confId);
            ps.executeUpdate();
            result = true;
        } catch (ClassNotFoundException | SQLException ex) {

        }
        return result;
    }

    /**
     *
     * @return en liste med alle konfig under status NY
     */
    public ArrayList<Carport> getNewConfigs() {
        ArrayList<Carport> configs = new ArrayList<>();

        try {
            Connection con = Connector.connection();
            String SQL = "SELECT confId, custName, custPhone, custEmail, custPostal, width, length, height, material, roofInclination, roofMaterial FROM configurations WHERE confStatus = \"ny\";";
            PreparedStatement ps = con.prepareStatement(SQL);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                configs.add(new Carport(rs.getInt(1),
                        rs.getString(2),
                        rs.getInt(3),
                        rs.getString(4),
                        rs.getInt(5),
                        rs.getInt(6),
                        rs.getInt(7),
                        rs.getInt(8),
                        rs.getString(9),
                        rs.getInt(10),
                        rs.getString(11)));
            }//while

        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println(ex);
        }//catch

        return configs;
    }//getNewConfigs

    /**
     *
     * @return en liste med alle konfig under status behandles
     */
    public ArrayList<Carport> getInProgressConfigs() {
        ArrayList<Carport> configs = new ArrayList<>();

        try {
            Connection con = Connector.connection();
            String SQL = "SELECT confId, custName, custPhone, custEmail, custPostal, width, length, height, material, roofInclination, roofMaterial FROM configurations WHERE confStatus = \"behandles\";";
            PreparedStatement ps = con.prepareStatement(SQL);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                configs.add(new Carport(rs.getInt(1),
                        rs.getString(2),
                        rs.getInt(3),
                        rs.getString(4),
                        rs.getInt(5),
                        rs.getInt(6),
                        rs.getInt(7),
                        rs.getInt(8),
                        rs.getString(9),
                        rs.getInt(10),
                        rs.getString(11)));
            }//while

        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println(ex);
        }//catch

        return configs;
    }//getInProgressConfigs

    /**
     *
     * @return en liste med alle afsluttede konfig
     */
    public ArrayList<Carport> getFinishedConfigs() {
        ArrayList<Carport> configs = new ArrayList<>();

        try {
            Connection con = Connector.connection();
            String SQL = "SELECT confId, custName, custPhone, custEmail, custPostal, width, length, height, material, roofInclination, roofMaterial FROM configurations WHERE confStatus = \"afsluttet\";";
            PreparedStatement ps = con.prepareStatement(SQL);

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                configs.add(new Carport(rs.getInt(1),
                        rs.getString(2),
                        rs.getInt(3),
                        rs.getString(4),
                        rs.getInt(5),
                        rs.getInt(6),
                        rs.getInt(7),
                        rs.getInt(8),
                        rs.getString(9),
                        rs.getInt(10),
                        rs.getString(11)));
            }//while

        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println(ex);
        }//catch

        return configs;
    }//getFinishedConfigs
}//class
