/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tbl_mobile;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import utils.DBCore;

/**
 *
 * @author son
 */
public class MobileDAO implements Serializable {

    public MobileDTO searchById(String id) throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet rs = null;
        try {
            connection = DBCore.makeConnection();
            if (connection != null) {
                String sql = "select mobileId,description,price,mobileName,yearOfProduction,quantity,notSale from tbl_Mobile "
                        + "where mobileId = ?";

                preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setString(1, id);

                rs = preparedStatement.executeQuery();

                if (rs.next()) {
                    String mobileId = rs.getString("mobileId");
                    String description = rs.getString("description");
                    float price = rs.getFloat("price");
                    String mobileName = rs.getString("mobileName");
                    int yearOfProduction = rs.getInt("yearOfProduction");
                    int quantity = rs.getInt("quantity");
                    boolean notSale = rs.getBoolean("notSale");

                    return new MobileDTO(mobileId, description, price, mobileName, yearOfProduction, quantity, notSale);
                }
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(MobileDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(MobileDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (preparedStatement != null) {
                preparedStatement.close();
            }
            if (connection != null) {
                connection.close();
            }
        }
        return null;
    }

    public Vector<MobileDTO> searchByName(String name) throws SQLException, ClassNotFoundException {
        Connection connection = null;
        PreparedStatement preparedStatment = null;
        ResultSet rs = null;
        Vector<MobileDTO> res;
        try {
            connection = DBCore.makeConnection();
            if (connection != null) {
                res = new Vector();
                String sql = "select mobileId,description,price,mobileName,yearOfProduction,quantity,notSale from tbl_Mobile "
                        + "where mobileName like ?";
                preparedStatment = connection.prepareStatement(sql);

                preparedStatment.setString(1, "%" + name + "%");

                rs = preparedStatment.executeQuery();

                while (rs.next()) {
                    String mobileId = rs.getString("mobileId");
                    String description = rs.getString("description");
                    float price = rs.getFloat("price");
                    String mobileName = rs.getString("mobileName");
                    int yearOfProduction = rs.getInt("yearOfProduction");
                    int quantity = rs.getInt("quantity");
                    boolean notSale = rs.getBoolean("notSale");

                    MobileDTO dto = new MobileDTO(mobileId, description, price, mobileName, yearOfProduction, quantity, notSale);
                    res.add(dto);
                }
                return res;
            }
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (preparedStatment != null) {
                preparedStatment.close();
            }
            if (connection != null) {
                connection.close();
            }
        }
        return null;
    }

    public boolean deleteMobile(String id) throws SQLException, ClassNotFoundException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = DBCore.makeConnection();
            if (connection != null) {
                String sql = "delete from tbl_Mobile where mobileId = ?";
                preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setString(1, id);

                int row = preparedStatement.executeUpdate();

                if (row > 0) {
                    return true;
                }
            }
        } finally {
            if (preparedStatement != null) {
                preparedStatement.close();
            }
            if (connection != null) {
                connection.close();
            }
        }
        return false;
    }

    public boolean updateMobile(String mobileId, String description, float price, String mobileName, int yearOfProduction, int quantity, boolean notSale) throws SQLException, ClassNotFoundException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = DBCore.makeConnection();
            if (connection != null) {
                String sql = "update tbl_Mobile "
                        + "set description = ?,price=?,mobileName=?,yearOfProduction=?,quantity=?,notSale=? "
                        + "where mobileId=?";
                preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setString(1, description);
                preparedStatement.setFloat(2, price);
                preparedStatement.setString(3, mobileName);
                preparedStatement.setInt(4, yearOfProduction);
                preparedStatement.setInt(5, quantity);
                preparedStatement.setBoolean(6, notSale);
                preparedStatement.setString(7, mobileId);
                int res = preparedStatement.executeUpdate();
                if (res > 0) {
                    return true;
                }
            }
        } finally {
            if (preparedStatement != null) {
                preparedStatement.close();
            }
            if (connection != null) {
                connection.close();
            }
        }
        return false;
    }

    public boolean createMobile(String mobileId, String description, float price, String mobileName, int yearOfProduction, int quantity, boolean notSale) throws SQLException, ClassNotFoundException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = DBCore.makeConnection();
            if (connection != null) {
                String sql = "insert into tbl_Mobile(mobileId,description,price,mobileName,yearOfProduction,quantity,notSale) values(?,?,?,?,?,?,?)";
                preparedStatement = connection.prepareStatement(sql);

                preparedStatement.setString(1, mobileId);
                preparedStatement.setString(2, description);
                preparedStatement.setFloat(3, price);
                preparedStatement.setString(4, mobileName);
                preparedStatement.setInt(5, yearOfProduction);
                preparedStatement.setInt(6, quantity);
                preparedStatement.setBoolean(7, notSale);

                int res = preparedStatement.executeUpdate();
                System.out.println(res);
                if (res > 0) {
                    return true;
                }
            }
        } finally {
            if (preparedStatement != null) {
                preparedStatement.close();
            }
            if (connection != null) {
                connection.close();
            }
        }
        return false;
    }

    public Vector<MobileDTO> searchByPrice(int minPrice, int maxPrice) throws SQLException, ClassNotFoundException {
        Vector<MobileDTO> res;
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet rs = null;
        try {
            connection = DBCore.makeConnection();
            if (connection != null) {
                res = new Vector();
                String sql = "select mobileId,description,price,mobileName,yearOfProduction,quantity,notSale from tbl_Mobile "
                        + "where price >= ? and price <= ?";
                preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setFloat(1, minPrice);
                preparedStatement.setFloat(2, maxPrice);

                rs = preparedStatement.executeQuery();

                while (rs.next()) {
                    String mobileId = rs.getString("mobileId");
                    String description = rs.getString("description");
                    float price = rs.getFloat("price");
                    String mobileName = rs.getString("mobileName");
                    int yearOfProduction = rs.getInt("yearOfProduction");
                    int quantity = rs.getInt("quantity");
                    boolean notSale = rs.getBoolean("notSale");

                    MobileDTO dto = new MobileDTO(mobileId, description, price, mobileName, yearOfProduction, quantity, notSale);
                    res.add(dto);
                }
                return res;
            }
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (preparedStatement != null) {
                preparedStatement.close();
            }
            if (connection != null) {
                connection.close();
            }
        }
        return null;
    }
}
