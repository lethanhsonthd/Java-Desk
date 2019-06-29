/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tbl_user_mobile;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Vector;
import utils.DBCore;

/**
 *
 * @author son
 */
public class UserMobileDAO implements Serializable{

    public boolean insert(String userID, Vector<String> mobiles) throws ClassNotFoundException, SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = DBCore.makeConnection();
            if (connection != null) {
                String sql = "insert into tbl_User_mobile(userId,mobileId) values(?,?)";
                preparedStatement = connection.prepareStatement(sql);
                connection.setAutoCommit(false);
                try {
                    for (int i = 0; i < mobiles.size(); i++) {
                        String mobileID = mobiles.get(i);
                        preparedStatement.setString(1, userID);
                        preparedStatement.setString(2, mobileID);

                        preparedStatement.executeUpdate();
                    }
                    connection.commit();
                    return true;
                } catch (SQLException e) {
                    connection.rollback();
                    return false;
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
