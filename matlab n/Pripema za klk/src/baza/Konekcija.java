/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package baza;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author andri
 */
public class Konekcija {

    private static Konekcija instance;
    private Connection connection = null;

    public static Konekcija getInstance() {
        if (instance == null) {
            instance = new Konekcija();
        }
        return instance;
    }

    private Konekcija() {

    }

    public void connect() {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/studentska_sluzba";
            String user = "root";
            String pass = "";

            connection = DriverManager.getConnection(url, user, pass);

            connection.setAutoCommit(false);

        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("Greska u konekciji");
        }

    }

    public void disconnect() {
        try {
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException ex) {
            // Logger.getLogger(Konekcija.class.getName()).log(Level.SEVERE, null, ex);
            ex.printStackTrace();
        }
    }

    public Connection getConnection() {
        //znaci ovo je fja koja vraca nesto ipa Connection
        return connection;

    }

}
