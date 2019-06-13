/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javadesk_500loc;

import Utils.DBCore;
import java.sql.Connection;
import java.sql.SQLException;
import javax.rmi.CORBA.Util;

/**
 *
 * @author son
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        String language = "vn";
        String country = "VN";
        LoginFrame loginFram = new LoginFrame(language, country);
        loginFram.setVisible(true);
    }
    
}
