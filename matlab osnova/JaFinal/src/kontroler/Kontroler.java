/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package kontroler;

import broker.DBBroker;
import domen.Nastavnik;
import domen.Zvanje;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author andri
 */
public class Kontroler {

    DBBroker dbBroker;

    public Kontroler() {
        dbBroker = new DBBroker();
    }

    public List<Zvanje> vratiSvaZvanja() throws Exception {
        try {
            return dbBroker.vratiZvanja();
        } catch (SQLException ex) {
            ex.printStackTrace();
            throw new Exception("Greska pri vracanju zvanja");
        }
    }

        public boolean sacuvajNastavnika(Nastavnik nastavnik) throws SQLException {
        return dbBroker.sacuvajNastavnika(nastavnik);
    }

    public List<Nastavnik> vratiSveNastavnike() {
        try {
            return dbBroker.vratiSveNastavnike();
        } catch (SQLException ex) {
            throw new RuntimeException("Greska pri vrcanju nastavnika");
        }
        
    }

}
