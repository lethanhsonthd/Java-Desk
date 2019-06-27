/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utils;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javadesk_500loc.User;
import javax.swing.JOptionPane;

/**
 *
 * @author son
 */
public class DBCore implements Serializable {

    public static Connection makeConnection() throws ClassNotFoundException, SQLException {
        Connection cn = null;
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        String url = "jdbc:sqlserver://localhost:1433;databaseName=javadesk_500loc;";
        cn = DriverManager.getConnection(url, "son", "son");
        if (cn != null) {
            return cn;
        }
        return null;
    }

    public static int login(String username, String password) throws ClassNotFoundException, SQLException {
        Connection connection = null;
        PreparedStatement prepareStatement = null;
        ResultSet resultSet = null;
        int role;
        try {
            connection = makeConnection();
            if (connection != null) {
                String sql = "select username,password,firstname,lastname,role from users where username = ? and password = ?";
                prepareStatement = connection.prepareStatement(sql);
                prepareStatement.setString(1, username);
                prepareStatement.setString(2, password);

                resultSet = prepareStatement.executeQuery();

                if (resultSet.next()) {
                    role = resultSet.getInt("role");
                    return role;
                }
            }
        } finally {
            connection.close();
        }
        return 0;
    }

    public static Vector loadUsers() {
        Connection connection = null;
        PreparedStatement prepareStatement = null;
        ResultSet resultSet = null;
        Vector data = null;
        try {
            connection = makeConnection();
            if (connection != null) {
                data = new Vector();
                String sql = "select id,username,password,firstname,lastname,email,phone_number,role from users";
                prepareStatement = connection.prepareStatement(sql);
                resultSet = prepareStatement.executeQuery();

                while (resultSet.next()) {
                    Vector row = new Vector();
                    int id = resultSet.getInt("id");
                    String username = resultSet.getString("username");
                    String password = resultSet.getString("password");
                    String firstname = resultSet.getString("firstname");
                    String lastname = resultSet.getString("lastname");
                    String email = resultSet.getString("email");
                    String phone_number = resultSet.getString("phone_number");
                    int role = resultSet.getInt("role");

                    row.add(id);
                    row.add(username);
                    row.add(password);
                    row.add(firstname);
                    row.add(lastname);
                    row.add(phone_number);
                    row.add(email);
                    row.add(role);

                    data.add(row);
                }
            }
        } catch (Exception ex) {
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(DBCore.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }

        return data;
    }

    public static int updateUser(User user) {
        Connection connection = null;
        PreparedStatement prepareStatement = null;
        ResultSet resultSet = null;
        int[] result;
        int id = user.id;
        String username = user.username;
        String password = user.password;
        String firstName = user.firstName;
        String lastName = user.lastName;
        String phone = user.phoneNumber;
        String email = user.email;
        int role = user.role;

        try {
            connection = makeConnection();
            String sql = "update users set username=?,password=?,firstname=?,lastname=?,phone_number=?,email=?,role=? where id=?";
            prepareStatement = connection.prepareStatement(sql);
            connection.setAutoCommit(false);
            prepareStatement.setString(1, username);
            prepareStatement.setString(2, password);
            prepareStatement.setString(3, firstName);
            prepareStatement.setString(4, lastName);
            prepareStatement.setString(5, phone);
            prepareStatement.setString(6, email);
            prepareStatement.setInt(7, role);
            prepareStatement.setInt(8, id);

            prepareStatement.addBatch();
            result = prepareStatement.executeBatch();
            connection.commit();

            if (result.length > 0) {
                return result.length;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    public static int insertUser(User user) {
        Connection connection = null;
        PreparedStatement prepareStatement = null;
        int result;
        try {
            connection = makeConnection();
            String sql = "insert into users(id,username,password,firstname,lastname,phone_number,email,role) values(?,?,?,?,?,?,?,?)";
            prepareStatement = connection.prepareStatement(sql);

            prepareStatement.setInt(1, user.id);
            prepareStatement.setString(2, user.username);
            prepareStatement.setString(3, user.password);
            prepareStatement.setString(4, user.firstName);
            prepareStatement.setString(5, user.lastName);
            prepareStatement.setString(6, user.phoneNumber);
            prepareStatement.setString(7, user.email);
            prepareStatement.setInt(8, user.role);

            result = prepareStatement.executeUpdate();
            if (result == 1) {
                JOptionPane.showMessageDialog(null, "Inserted Successfully");
            } else {
                JOptionPane.showMessageDialog(null, "Something wrong!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(DBCore.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return 0;
    }

    public static int deleteUser(int id) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        int result;
        try {
            connection = makeConnection();
            String sql = "delete from users where id = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);

            result = preparedStatement.executeUpdate();
            if (result == 1) {
                return 1;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    public static Vector testGetProduct(String name) throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet rs = null;
        Vector result = null;
        try {
            connection = makeConnection();
            String sql = "select cate.id cate_id, cate.name cate_name, pro.id pro_id from category as cate, product as pro\n"
                    + "where cate.id = pro.category and pro.name = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, name);
            rs = preparedStatement.executeQuery();

            if (rs.next()) {
                result = new Vector();
                result.add(rs.getString("cate_id"));
                result.add(rs.getString("cate_name"));
                result.add(rs.getString("pro_id"));
                return result;
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DBCore.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(DBCore.class.getName()).log(Level.SEVERE, null, ex);
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

    public static Vector loadProducts() throws SQLException, ClassNotFoundException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Vector result = null;
        try {
            connection = makeConnection();
            if (connection != null) {
                result = new Vector();
                String sql = "select id,name,unitprice from product";
                preparedStatement = connection.prepareStatement(sql);

                resultSet = preparedStatement.executeQuery();
                while (resultSet.next()) {
                    int id = resultSet.getInt("id");
                    String name = resultSet.getString("name");
                    int unitprice = resultSet.getInt("unitprice");
                    String quantity = "0";
                    Vector row = new Vector();
                    row.add(id);
                    row.add(name);
                    row.add(unitprice);
                    row.add(quantity);
                    result.add(row);
                }
                return result;
            }
        } finally {
            if (resultSet != null) {
                resultSet.close();
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

    public static int addProductToBillDetails(int user_id, Vector<Integer> productIDArray, Vector<Integer> quantityArray) throws SQLException, ClassNotFoundException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet rs = null;
        String generatedColumns[] = {"id"};
        try {
            connection = makeConnection();
            if (connection != null) {
                // Insert into table bill

                String sql = "insert into bill(user_id) values(?)";
                preparedStatement = connection.prepareStatement(sql, generatedColumns);
                connection.setAutoCommit(false);
                preparedStatement.setInt(1, user_id);
                int bill_id = 0;
                int result = preparedStatement.executeUpdate();
                try {
                    rs = preparedStatement.getGeneratedKeys();
                    if (rs.next()) {
                        bill_id = rs.getInt(1);
                        String secondSql = "insert into bill_details(bill_id,product_id,quantity) values(?,?,?)";
                        preparedStatement = connection.prepareStatement(secondSql);
                        try {
                            for (int i = 0; i < productIDArray.size(); i++) {
                                int productID = productIDArray.get(i);
                                int quantity = quantityArray.get(i);
                                preparedStatement.setInt(1, bill_id);
                                preparedStatement.setInt(2, productID);
                                preparedStatement.setInt(3, quantity);
                                preparedStatement.addBatch();
                            }
                            int[] res = preparedStatement.executeBatch();
                            connection.commit();
                            return res.length;
                        } catch (SQLException e) {
                            connection.rollback();
                        }
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
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
        return -1;
    }

    public static int test() throws ClassNotFoundException, SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = makeConnection();
            String sql = "insert into test(id,user_id) values(?,?)";
            preparedStatement = connection.prepareStatement(sql);
            connection.setAutoCommit(false);
            try {
                preparedStatement.setInt(1, 1);
                preparedStatement.setInt(2, 1);
                preparedStatement.addBatch();

                preparedStatement.setInt(1, 1);
                preparedStatement.setString(2, "wtf");
                preparedStatement.addBatch();

                preparedStatement.setInt(1, 9);
                preparedStatement.setInt(2, 9);
                preparedStatement.addBatch();

                preparedStatement.setInt(1, 10);
                preparedStatement.setInt(2, 10);
                preparedStatement.addBatch();

                int[] res = preparedStatement.executeBatch();
                connection.setAutoCommit(true);
                return res.length;
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, e);
                connection.rollback();
            }
        } finally {
            if (preparedStatement != null) {
                preparedStatement.close();
            }
            if (connection != null) {
                connection.close();
            }
        }
        return -1;
    }

    public static Vector loadAllBillOfUser(int id) throws SQLException, ClassNotFoundException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet rs = null;
        Vector result = null;
        try {
            connection = makeConnection();
            if (connection != null) {
                result = new Vector();
                Vector listAllBillID = new Vector();
                String sql = "select id from bill where user_id = ?";
                preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setInt(1, id);

                rs = preparedStatement.executeQuery();

                while (rs.next()) {
                    listAllBillID.add(rs.getInt("id"));
                }
                for (int i = 0; i < listAllBillID.size(); i++) {
                    int bill_idx = (int) listAllBillID.get(i);
                    Vector temp = new Vector();
                    sql = "select bdt.id bdt_id, bdt.quantity bdt_quantity, bdt.bill_id bdt_bill_id, pro.name pro_name from dbo.product as pro, dbo.bill_details as bdt\n"
                            + "where bdt.bill_id = ? and bdt.product_id = pro.id";
                    preparedStatement = connection.prepareStatement(sql);
                    preparedStatement.setInt(1, bill_idx);

                    rs = preparedStatement.executeQuery();
                    while (rs.next()) {
                        Vector row = new Vector();
                        row.add(rs.getInt("bdt_id"));
                        row.add(rs.getInt("bdt_quantity"));
                        row.add(rs.getInt("bdt_bill_id"));
                        row.add(rs.getString("pro_name"));
                        temp.add(row);
                    }
                    result.add(temp);
                }
                return result;
            }
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
}
