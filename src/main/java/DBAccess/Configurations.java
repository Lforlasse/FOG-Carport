package DBAccess;

import FunctionLayer.Carport;
import FunctionLayer.LoginSampleException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Configurations {

    public Carport makeConfigObject(int configId){
        ArrayList<Carport> configs = new ArrayList<>();
        int confId = 0;
        String custName = "Ingen konfiguration fundet";
        int custPhone = 0;
        int custPostal = 0;
        int confLength = 0;
        int confWidth = 0;
        int confHeight = 0;
        String confMat = "0";


        try {
            Connection con = Connector.connection();
            String SQL = "SELECT configId, custName, custPhone, custPostal, width, length, height, material FROM configurations WHERE configId = " + configId +" ;";
            PreparedStatement ps = con.prepareStatement(SQL);

            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                    confId=rs.getInt(1);
                    custName=rs.getString(2);
                    custPhone=rs.getInt(3);
                    custPostal=rs.getInt(4);
                    confWidth=rs.getInt(5);
                    confLength=rs.getInt(6);
                    confHeight=rs.getInt(7);
                    confMat=rs.getString(8);

            }//if
        } catch (ClassNotFoundException | SQLException ex) {

        }//catch
        Carport carport = new Carport(confId,custName,custPhone,custPostal,confLength,confWidth,confHeight,confMat);
        return carport;
    }//makeConfigObject

    public ArrayList<Carport> getOneConfig(int configId){
        ArrayList<Carport> configs = new ArrayList<>();

        try {
            Connection con = Connector.connection();
            String SQL = "SELECT configId, custName, custPhone, custPostal, width, length, height, material FROM configurations WHERE configId = " + configId +" ;";
            PreparedStatement ps = con.prepareStatement(SQL);

            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                while (rs.next()) {
                    configs.add(new Carport(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getInt(4),
                            rs.getInt(5), rs.getInt(6), rs.getInt(7), rs.getString(8)));

                }//while
            }//if
        } catch (ClassNotFoundException | SQLException ex) {

        }//catch

        return configs;

    }//getOneConfig

    public ArrayList<Carport> getAllConfigs(){
        ArrayList<Carport> configs = new ArrayList<>();

        try {
        Connection con = Connector.connection();
        String SQL = "SELECT configId, custName, custPhone, custPostal, width, length, height, material FROM configurations;";
        PreparedStatement ps = con.prepareStatement(SQL);

        ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                while (rs.next()) {
                    configs.add(new Carport(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getInt(4),
                            rs.getInt(5), rs.getInt(6), rs.getInt(7), rs.getString(8)));

                }//while
            }//if
        } catch (ClassNotFoundException | SQLException ex) {

        }//catch

        return configs;
    }//getAllConfigs

    public ArrayList<Carport> getNewConfigs(){
        ArrayList<Carport> configs = new ArrayList<>();

        try {
            Connection con = Connector.connection();
            String SQL = "SELECT configId, custName, custPhone, custPostal, width, length, height, material FROM configurations WHERE configStatus = \"ny\";";
            PreparedStatement ps = con.prepareStatement(SQL);

            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                while (rs.next()) {
                    configs.add(new Carport(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getInt(4),
                            rs.getInt(5), rs.getInt(6), rs.getInt(7), rs.getString(8)));

                }//while
            }//if
        } catch (ClassNotFoundException | SQLException ex) {

        }//catch

        return configs;
    }//getNewConfigs

    public ArrayList<Carport> getInProgressConfigs(){
        ArrayList<Carport> configs = new ArrayList<>();

        try {
            Connection con = Connector.connection();
            String SQL = "SELECT configId, custName, custPhone, custPostal, width, length, height, material FROM configurations WHERE configStatus = \"behandles\";";
            PreparedStatement ps = con.prepareStatement(SQL);

            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                while (rs.next()) {
                    configs.add(new Carport(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getInt(4),
                            rs.getInt(5), rs.getInt(6), rs.getInt(7), rs.getString(8)));

                }//while
            }//if
        } catch (ClassNotFoundException | SQLException ex) {

        }//catch

        return configs;
    }//getInProgressConfigs

    public ArrayList<Carport> getFinishedConfigs(){
        ArrayList<Carport> configs = new ArrayList<>();

        try {
            Connection con = Connector.connection();
            String SQL = "SELECT configId, custName, custPhone, custPostal, width, length, height, material FROM configurations WHERE configStatus = \"afsluttet\";";
            PreparedStatement ps = con.prepareStatement(SQL);

            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                while (rs.next()) {
                    configs.add(new Carport(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getInt(4),
                            rs.getInt(5), rs.getInt(6), rs.getInt(7), rs.getString(8)));

                }//while
            }//if
        } catch (ClassNotFoundException | SQLException ex) {

        }//catch

        return configs;
    }//getFinishedConfigs


}//class
