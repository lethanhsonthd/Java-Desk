/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tbl_user;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import utils.DBCore;

/**
 *
 * @author son
 */
public class UserDAO implements Serializable {

    public boolean checkLogin(String username, int password) throws SQLException, ClassNotFoundException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet rs = null;
        try {
            connection = DBCore.makeConnection();
            if (connection != null) {
                String sql = "select * from tbl_User where userId = ? and password = ?";
                preparedStatement = connection.prepareStatement(sql);

                preparedStatement.setString(1, username);
                preparedStatement.setInt(2, password);

                rs = preparedStatement.executeQuery();
                if (rs.next()) {
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
}
