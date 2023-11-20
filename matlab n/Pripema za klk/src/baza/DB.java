/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package baza;

import domen.Nastavnik;
import domen.Zvanje;
import java.sql.*;
import java.util.ArrayList;
import java.util.*;

/**
 *
 * @author andri
 */
public class DB {
    Connection connection;
    
    public List<Zvanje> getAllZvanja(){
    //ovo je fja cija je povratna vrednost lista zvanja i zove se getAllZvanja
    List<Zvanje> vrati = new ArrayList<>();
        
    //Konekcija konekcija = new Konekcija();
    try{
    Konekcija.getInstance().connect();
    
    Connection connection = Konekcija.getInstance().getConnection();
    
    Statement statement = connection.createStatement();
    String query = "SELECT * FROM zvanje";//znaci query ima onu tabelu kao u sqlyogu
    
    ResultSet rs = statement.executeQuery(query);//executeQuery to je kao izvrsi query
    //ResultSet pretstavlja rezultate upita iz baze podataka u javi
    
        while (rs.next()) {            
            int id = rs.getInt("id");
            String naziv = rs.getString("naziv");
            
            Zvanje zvanje = new Zvanje(id, naziv);
            vrati.add(zvanje);
            
            
            
        }
    
    
    return vrati;
    }
    catch(Exception e){
            e.printStackTrace();
            throw new RuntimeException();
    }    finally{Konekcija.getInstance().disconnect();       
}
    
}

    public void saveNastavnik(Nastavnik nastavnik) throws SQLException {
        //na dugme sacuvaj(saveNastavnik) sacuvavamo nastavnika u bazu podataka
        //Konekcija konekcija = new Konekcija();
        try{
            Konekcija.getInstance().connect();
            Connection connection = Konekcija.getInstance().getConnection();
        // onaj prvi nacin je sledeci(Chat GPT)
//"INSERT INTO nastavnik (id, ime, prezime, zvanje_id) VALUES (vrednost_id, 'Ime', 'Prezime', vrednost_zvanje_id);
        // a treba da se napise ovako
//"INSERT INTO nastavnik (id, ime, prezime, zvanje_id) VALUES (" + nastavnik.getId + ", '" + nastavnik.getIme() + "', '" + nastavnik.getPrezime() +"', " + nastavnik.getZvanje().getId() + ")";


            String query = "INSERT INTO nastavnik (id, ime, prezime, zvanje_id) "
                    + "VALUES (?,?,?,?);";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, nastavnik.getId());
            ps.setString(2, nastavnik.getIme());
            ps.setString(3, nastavnik.getPrezime());
            ps.setInt(4, nastavnik.getZvanje().getId());
            
            ps.execute();
        
            
            connection.commit();
         
        } catch (Exception ex){
        ex.printStackTrace();
        connection.rollback();
            
        
        }
        
        
    }

    public List<Nastavnik> getAllNastavnik() {
        
        try {
            String query = "SELECT * FROM Nastavnik";
            List<Nastavnik> vrati = new ArrayList<>();
            
            //Konekcija konekcija = new Konekcija();
            Konekcija.getInstance().connect();
            Connection connection = Konekcija.getInstance().getConnection();
            
            Statement st = connection.createStatement();
            st.executeQuery(query);
            ResultSet rs = st.executeQuery(query);
            
            
            List<Zvanje> zvanja = getAllZvanja();
            
            
            while (rs.next()) {                
             int id = rs.getInt(1);
             String ime = rs.getString(2);
             String prezime = rs.getString(3);
             int idZvanje = rs.getInt(4);
             
             Zvanje zvanje = new Zvanje();
             
             for(Zvanje z: zvanja){
                  if (z.getId() == idZvanje) {
                     zvanje = z;
                     break; 
                  }
 
             }
             
             
             Nastavnik nastavnik = new Nastavnik(ime, prezime, id, zvanje);
             //tek kada si to iskucao new Nastavnik() i kada ti je u zagradi izbacilo ove 4 stvari tek
             //tada kapiras da nemas zvanje i da treba da ga pravis
             vrati.add(nastavnik); 
             
            }
            
            System.out.println(vrati.size());
            
            return vrati;
        } catch (SQLException ex) {
            ex.printStackTrace();
            throw new RuntimeException("Neuspesno");
        }
    }
    public void deleteNastavnik(Nastavnik nastavnik) throws SQLException{
    try{
        String upit = "DELETE FROM nastavnik WHERE id = ?";
        Konekcija.getInstance().connect();
        Connection connection = Konekcija.getInstance().getConnection();
        PreparedStatement ps = connection.prepareStatement(upit);
        ps.setLong(1, nastavnik.getId());
        ps.executeUpdate();
        
        Konekcija.getInstance().getConnection().commit(); 
            } catch (Exception e){
            e.printStackTrace();
            Konekcija.getInstance().getConnection().rollback();
            } finally{
            Konekcija.getInstance().disconnect();
    }
        
    
    }

    public void editNastavnik(Nastavnik nastavnik)throws SQLException{
    
        deleteNastavnik(nastavnik);
        saveNastavnik(nastavnik);
    
    }
    
    
    
}
