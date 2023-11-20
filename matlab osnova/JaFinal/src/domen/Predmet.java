/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domen;

/**
 *
 * @author andri
 */
public class Predmet {
    private long id;
    private String naziv;
    private String espb;

    public Predmet() {
    }

    public Predmet(long id, String naziv, String espb) {
        this.id = id;
        this.naziv = naziv;
        this.espb = espb;
    }

    public String getEspb() {
        return espb;
    }

    public void setEspb(String espb) {
        this.espb = espb;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }
    
    
}
