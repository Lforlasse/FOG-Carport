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
        int custPostal = 0;
        int confLength = 0;
        int confWidth = 0;
        int confHeight = 0;
        String confMat = "0";
        String confRoof = "0";

        try {
            Connection con = Connector.connection();
            String SQL = "SELECT configId, custName, custPhone, custPostal, width, length, height, material,  FROM configurations WHERE configId =?;";
            PreparedStatement ps = con.prepareStatement(SQL);
            ps.setInt(1, configId);

            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                confId = rs.getInt(1);
                custName = rs.getString(2);
                custPhone = rs.getInt(3);
                custPostal = rs.getInt(4);
                confWidth = rs.getInt(5);
                confLength = rs.getInt(6);
                confHeight = rs.getInt(7);
                confMat = rs.getString(8);

            }//if
        } catch (ClassNotFoundException | SQLException ex) {

        }//catch

        try {
            Connection con = Connector.connection();
            String SQL = "SELECT compDescription FROM roof WHERE compDescription = ?";
            PreparedStatement ps = con.prepareStatement(SQL);
            ps.setString(1, confRoof);

            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                confRoof = rs.getString(1);

            }//if
        } catch (ClassNotFoundException | SQLException ex) {

        }//catch
        Carport carport = new Carport(confId, custName, custPhone, custPostal, confWidth, confLength, confHeight, confMat, confRoof);
        return carport;
    }//makeConfigObject

    public static int newOfferRequest(int length, int width, int height, String configMaterial,
                                      int roofAngle, String roofMaterial,
                                      String name, String email, String phone, String postcode) throws LoginSampleException {
        int offerRequestId;
        try {
            //TODO Implement remaining data/variables
            Connection con = Connector.connection();
            String SQL = "INSERT INTO configurations (configStatus, custName, custPhone, custPostal, length, width, height, material) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, "Ny");
            ps.setString(2, name);
            ps.setString(3, phone);
            ps.setString(4, postcode);
            ps.setInt(5, length);
            ps.setInt(6, width);
            ps.setInt(7, height);
            ps.setString(8, configMaterial);
            ps.executeUpdate();

            ResultSet ids = ps.getGeneratedKeys();
            ids.next();
            offerRequestId = ids.getInt(1);

        } catch (SQLException | ClassNotFoundException e) {
            throw new LoginSampleException(e.getMessage());
        }
        return offerRequestId;
    }

    public ArrayList<Carport> getOneConfig(int configId) {
        ArrayList<Carport> configs = new ArrayList<>();

        try {
            Connection con = Connector.connection();
            String SQL = "SELECT configId, custName, custPhone, custPostal, width, length, height, material FROM configurations WHERE configId =?;";
            PreparedStatement ps = con.prepareStatement(SQL);
            ps.setInt(1, configId);

            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                while (rs.next()) {
                    configs.add(new Carport(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getInt(4),
                            rs.getInt(5), rs.getInt(6), rs.getInt(7), rs.getString(8), rs.getString(9)));

                }//while
            }//if
        } catch (ClassNotFoundException | SQLException ex) {

        }//catch


        return configs;

    }//getOneConfig

    public ArrayList<Carport> getAllConfigs() {
        ArrayList<Carport> configs = new ArrayList<>();

        try {
            Connection con = Connector.connection();
            String SQL = "SELECT configId, custName, custPhone, custPostal, width, length, height, material FROM configurations;";
            PreparedStatement ps = con.prepareStatement(SQL);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                while (rs.next()) {
                    configs.add(new Carport(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getInt(4),
                            rs.getInt(5), rs.getInt(6), rs.getInt(7), rs.getString(8), rs.getString(9)));

                }//while
            }//if
        } catch (ClassNotFoundException | SQLException ex) {

        }//catch

        return configs;
    }//getAllConfigs

    public ArrayList<Carport> getNewConfigs() {
        ArrayList<Carport> configs = new ArrayList<>();

        try {
            Connection con = Connector.connection();
            String SQL = "SELECT configId, custName, custPhone, custPostal, width, length, height, material FROM configurations WHERE configStatus = \"ny\";";
            PreparedStatement ps = con.prepareStatement(SQL);

            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                while (rs.next()) {
                    configs.add(new Carport(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getInt(4),
                            rs.getInt(5), rs.getInt(6), rs.getInt(7), rs.getString(8), rs.getString(9)));

                }//while
            }//if
        } catch (ClassNotFoundException | SQLException ex) {

        }//catch

        return configs;
    }//getNewConfigs

    public ArrayList<Carport> getInProgressConfigs() {
        ArrayList<Carport> configs = new ArrayList<>();

        try {
            Connection con = Connector.connection();
            String SQL = "SELECT configId, custName, custPhone, custPostal, width, length, height, material FROM configurations WHERE configStatus = \"behandles\";";
            PreparedStatement ps = con.prepareStatement(SQL);

            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                while (rs.next()) {
                    configs.add(new Carport(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getInt(4),
                            rs.getInt(5), rs.getInt(6), rs.getInt(7), rs.getString(8), rs.getString(9)));

                }//while
            }//if
        } catch (ClassNotFoundException | SQLException ex) {

        }//catch

        return configs;
    }//getInProgressConfigs

    public ArrayList<Carport> getFinishedConfigs() {
        ArrayList<Carport> configs = new ArrayList<>();

        try {
            Connection con = Connector.connection();
            String SQL = "SELECT configId, custName, custPhone, custPostal, width, length, height, material FROM configurations WHERE configStatus = \"afsluttet\";";
            PreparedStatement ps = con.prepareStatement(SQL);

            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                while (rs.next()) {
                    configs.add(new Carport(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getInt(4),
                            rs.getInt(5), rs.getInt(6), rs.getInt(7), rs.getString(8), rs.getString(9)));

                }//while
            }//if
        } catch (ClassNotFoundException | SQLException ex) {

        }//catch

        return configs;
    }//getFinishedConfigs

}//class
