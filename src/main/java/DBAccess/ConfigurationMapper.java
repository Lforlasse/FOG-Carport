package DBAccess;

import FunctionLayer.Carport;
import FunctionLayer.LoginSampleException;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ConfigurationMapper {

    public static Carport makeConfigObject(int configId) {
        ArrayList<Carport> configs = new ArrayList<>();
        int confId = 0;
        String custName = "Ingen konfiguration fundet";
        int custPhone = 0;
        String custEmail = "0";
        int custPostal = 0;
        int confLength = 0;
        int confWidth = 0;
        int confHeight = 0;
        String confMat = "0";
        String confRoof = "0";

        try {
            Connection con = Connector.connection();
            String SQL = "SELECT confId, custName, custPhone, custEmail, custPostal, width, length, height, material,  FROM configurations WHERE confId =?;";
            PreparedStatement ps = con.prepareStatement(SQL);
            ps.setInt(1, confId);

            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                confId = rs.getInt(1);
                custName = rs.getString(2);
                custPhone = rs.getInt(3);
                custEmail = rs.getString(4);
                custPostal = rs.getInt(5);
                confWidth = rs.getInt(6);
                confLength = rs.getInt(7);
                confHeight = rs.getInt(8);
                confMat = rs.getString(9);

            }//if
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println(ex);
        }//catch

        try {
            Connection con = Connector.connection();
            String SQL = "SELECT compDesc FROM roof WHERE compDesc = ?";
            PreparedStatement ps = con.prepareStatement(SQL);
            ps.setString(1, confRoof);

            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                confRoof = rs.getString(1);

            }//if
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println(ex);
        }//catch
        Carport carport = new Carport(confId, custName, custPhone, custEmail, custPostal, confWidth, confLength, confHeight, confMat, confRoof);
        return carport;
    }//makeConfigObject

    public static int newOfferRequest(int length, int width, int height, String confMaterial,
                                      int roofAngle, String roofMaterial,
                                      String custName, String custPhone, String custEmail, String custPostal) throws LoginSampleException {
        int offerRequestId;
        try {
            //TODO Implement remaining data/variables
            Connection con = Connector.connection();
            String SQL = "INSERT INTO configurations (confStatus, custName, custPhone, custEmail, custPostal, length, width, height, material) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
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

    public static Carport getOneConfig(int confId) {
        Carport carport = null;
        try {
            Connection con = Connector.connection();
            String SQL = "SELECT confId, custName, custPhone, custEmail, custPostal, width, length, height, material FROM configurations WHERE confId =?;";
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
                    rs.getString(10));
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println(ex);
        }//catch
        return carport;
    }//getOneConfig

    public static ArrayList<Carport> getAllConfigs() {
        ArrayList<Carport> configs = new ArrayList<>();

        try {
            Connection con = Connector.connection();
            String SQL = "SELECT confId, custName, custPhone, custEmail, custPostal, width, length, height, material, roofmaterial FROM configurations;";
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
                        rs.getString(10)));
            }//while
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println(ex);
        }//catch

        return configs;
    }//getAllConfigs

    public ArrayList<Carport> getNewConfigs() {
        ArrayList<Carport> configs = new ArrayList<>();

        try {
            Connection con = Connector.connection();
            String SQL = "SELECT confId, custName, custPhone, custEmail, custPostal, width, length, height, material FROM configurations WHERE confStatus = \"ny\";";
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
                        rs.getString(10)));
            }//while

        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println(ex);
        }//catch

        return configs;
    }//getNewConfigs

    public ArrayList<Carport> getInProgressConfigs() {
        ArrayList<Carport> configs = new ArrayList<>();

        try {
            Connection con = Connector.connection();
            String SQL = "SELECT confId, custName, custPhone, custEmail, custPostal, width, length, height, material FROM configurations WHERE confStatus = \"behandles\";";
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
                        rs.getString(10)));
            }//while

        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println(ex);
        }//catch

        return configs;
    }//getInProgressConfigs

    public ArrayList<Carport> getFinishedConfigs() {
        ArrayList<Carport> configs = new ArrayList<>();

        try {
            Connection con = Connector.connection();
            String SQL = "SELECT confId, custName, custPhone, custEmail, custPostal, width, length, height, material FROM configurations WHERE confStatus = \"afsluttet\";";
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
                        rs.getString(10)));
            }//while

        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println(ex);
        }//catch

        return configs;
    }//getFinishedConfigs
}//class
