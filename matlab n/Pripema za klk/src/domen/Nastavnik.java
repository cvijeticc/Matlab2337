/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domen;

/**
 *
 * @author andri
 */
public class Nastavnik {
    private String ime;
    private String prezime;
    private int id;
    private Zvanje zvanje;

    public Nastavnik() {
    }

    public Nastavnik(String ime, String prezime, int id, Zvanje zvanje) {
        this.ime = ime;
        this.prezime = prezime;
        this.id = id;
        this.zvanje = zvanje;
    }

    public Zvanje getZvanje() {
        return zvanje;
    }
    
    public void setZvanje(Zvanje zvanje) {
        this.zvanje = zvanje;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Nastavnik{" + "ime=" + ime + ", prezime=" + prezime + ", id=" + id + ", zvanje=" + zvanje + '}';
    }

    public String opis(){
    
    
        return "Nastavnik: \n" + ime + " " + prezime + ", " + zvanje.getNaziv();
    
    
    }
    
    public Object ispis() {
        return ime + " " + prezime + " " + zvanje.getNaziv();
    }

    
    
}
