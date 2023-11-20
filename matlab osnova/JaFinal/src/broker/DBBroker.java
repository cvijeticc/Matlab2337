/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package broker;

import domen.Nastavnik;
import domen.Zvanje;
import java.util.List;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author andri
 */
public class DBBroker {

    public static List<Zvanje> vratiZvanja() throws SQLException {

        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/studentska_sluzba", "root", "");
        System.out.println("Otvorena konekcija");
        String query = "SELECT * FROM zvanje";
        Statement st = connection.createStatement();
        ResultSet rs = st.executeQuery(query);

        List<Zvanje> zvanja = new ArrayList<>();
        while (rs.next()) {
            Zvanje zvanje = new Zvanje();
            zvanje.setId(rs.getLong("id"));
            zvanje.setNaziv(rs.getString("naziv"));
            zvanja.add(zvanje);
        }

        rs.close();
        st.close();
        connection.close();
        System.out.println("Zatvorena konekcija");
        return zvanja;

    }

    public static boolean sacuvajNastavnika(Nastavnik nastavnik) throws SQLException {
        Connection connection = null;
        try {

            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/studentska_sluzba", "root", "");
            System.out.println("Otvorena konekcija");

            String query = "INSERT INTO nastavnik (ime, prezime, zvanje_id) VALUES (?,?,?)";
            //ovde ne stavljas id, jer kada uneses novog nastavnika onda ce id sam da se generise(poveca)
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, nastavnik.getIme());
            ps.setString(2, nastavnik.getPrezime());
            ps.setLong(3, nastavnik.getZvanje().getId());

            ps.executeUpdate();
            ps.close();
        } catch (SQLException ex) {

            return false;

        } finally {
            if (connection != null || !connection.isClosed()) {
                connection.close();
                System.out.println("Zatvorena konekcija");
            }
        }
        return true;

    }

//    public List<Nastavnik> vratiSveNastavnike() {
//        
//    }
    public List<Nastavnik> vratiSveNastavnike() throws SQLException {
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/studentska_sluzba", "root", "");
            String query = "SELECT * FROM nastavnik ORDER BY prezime DESC";
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(query);

            List<Nastavnik> vratiNastavnike = new ArrayList<>();
            while (rs.next()) {
                Nastavnik nastavnik = new Nastavnik();
                nastavnik.setId(rs.getLong("id"));
                nastavnik.setIme(rs.getString("ime"));
                nastavnik.setPrezime(rs.getString("prezime"));

//            Zvanje zvanje = new Zvanje(); //OVO BI BILO DA KORISTIS JOIN*****
//            zvanje.setId(rs.getLong("zvanje_id"));
//            zvanje.setNaziv(rs.getString("naziv"));
                long zvanjeId = rs.getLong("zvanje_id");
                List<Zvanje> zvanja = vratiZvanja();
                //u listi zvanja se nalaze sva zvanja
                Zvanje zvanje = null;

                for (Zvanje z : zvanja) {//sada prolazimo kroz sve elemente liste zvanja
                    if (z.getId() == zvanjeId) {
                        zvanje = z;
                        break;
                    }
                }

                nastavnik.setZvanje(zvanje);
                vratiNastavnike.add(nastavnik);
            }
            rs.close();
            st.close();
            connection.close();

            System.out.println(vratiNastavnike.size());

            return vratiNastavnike;

        } catch (RuntimeException e) {
            throw new RuntimeException("Greska pri vrcanju nastavnika");
        }
    }

}
