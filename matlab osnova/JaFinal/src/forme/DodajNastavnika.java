/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package forme;

import domen.Nastavnik;
import domen.Zvanje;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import kontroler.Kontroler;

/**
 *
 * @author andri
 */
public class DodajNastavnika extends javax.swing.JDialog {

    /**
     * Creates new form DodajNastavnika
     */
    public DodajNastavnika(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        popuniCombo();
    }

    public DodajNastavnika(java.awt.Frame parent, boolean modal, Nastavnik nastavnik) {

        super(parent, modal);
        initComponents();

        //popuni combo
        cmbZvanja.removeAllItems();
        cmbZvanja.addItem(nastavnik.getZvanje().getNaziv());
        cmbZvanja.setEnabled(false);
//        cmbZvanja.setEnabled(false); opcija 2

        //popuni ostalo
        txtIme.setText(nastavnik.getIme());
        txtIme.setEditable(false);

        txtPrezime.setText(nastavnik.getPrezime());
        txtPrezime.setEditable(false);

        btnSacuvaj.setVisible(false);
        

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txtIme = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtPrezime = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        btnSacuvaj = new javax.swing.JButton();
        cmbZvanja = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("Ime");

        jLabel2.setText("Prezime");

        jLabel3.setText("Zvanje");

        btnSacuvaj.setText("Sacuvaj");
        btnSacuvaj.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSacuvajActionPerformed(evt);
            }
        });

        cmbZvanja.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnSacuvaj)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 63, Short.MAX_VALUE)
                        .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtPrezime)
                    .addComponent(txtIme)
                    .addComponent(cmbZvanja, 0, 169, Short.MAX_VALUE))
                .addGap(153, 153, 153))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtIme, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtPrezime, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(cmbZvanja, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 63, Short.MAX_VALUE)
                .addComponent(btnSacuvaj)
                .addGap(46, 46, 46))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSacuvajActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSacuvajActionPerformed
//            String greska = validacija();
//        if (!greska.isEmpty()) {//ako greska nije prazna to znaci da ce da mi ispise nesto
//            JOptionPane.showMessageDialog(rootPane, greska);
//            return;//ovo ako ne postoji onda ce samo ispisati koja je greska, ali ce sacuvati nastavnika,
//            //a nama treba da napise koja je greska i da ne sacuva onda nista
//            //return; prekida fju btnSacuvajActionPerformed 
//        }
        try {
            String ime = txtIme.getText();
            String prezime = txtPrezime.getText();

            Zvanje zvanje = (Zvanje) cmbZvanja.getSelectedItem();
            //ovde ces kastovati kao sto ti i preporucuje

            Nastavnik nastavnik = new Nastavnik(0, ime, prezime, zvanje);
            //sada je u objektu nastavnik sacuvan nastavnik kojeg smo uneli
            //dalji kod je samo da tog nastavnika posaljemo bazi
            boolean uspesno = new Kontroler().sacuvajNastavnika(nastavnik);
            if (uspesno) {
                JOptionPane.showMessageDialog(rootPane, "Sacuvan je nastavnik sa imenom " + ime);
                int opcija = JOptionPane.showConfirmDialog(rootPane, "Oces jos", ime, JOptionPane.YES_NO_OPTION);

                if (opcija == JOptionPane.YES_OPTION) {
                    DodajNastavnika dialog = new DodajNastavnika(null, true);
                   // DodajNastavnika dd = new DodajNastavnika(null, true);
                    //jako bitno da je u zagradi null
                    dialog.setVisible(true);

                    dispose();

                } else {
                    dispose();

                }
            } else {
                JOptionPane.showMessageDialog(rootPane, "Neuspesno cuvanje");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }//GEN-LAST:event_btnSacuvajActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(DodajNastavnika.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DodajNastavnika.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DodajNastavnika.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DodajNastavnika.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                DodajNastavnika dialog = new DodajNastavnika(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSacuvaj;
    private javax.swing.JComboBox<Object> cmbZvanja;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JTextField txtIme;
    private javax.swing.JTextField txtPrezime;
    // End of variables declaration//GEN-END:variables

    private void popuniCombo() {
        try {
            cmbZvanja.removeAllItems();
            List<Zvanje> zvanja = new Kontroler().vratiSvaZvanja();
            //sada je lista zvanja popunjena i sada moramo te elemente liste da ubacimo u combo
            cmbZvanja.addItem("");
            for (Zvanje zvanje : zvanja) {
                cmbZvanja.addItem(zvanje);
            }

        } catch (Exception ex) {
            throw new RuntimeException("Greska");
        }
    }

    private String validacija() {
        int izbor = cmbZvanja.getSelectedIndex();
        if (izbor == 0) {
            return "Nije odabran combo";
        }
        //ime je ime, prezime je jmbg
        //ime validacija
        String ime = txtIme.getText();
        if (ime.length() < 2 || ime.length() > 30) {
            return "Previse duzacak ili previse kratak naziv";
        }

        for (int i = 0; i < ime.length(); i++) {
            Character c = ime.charAt(i);
            if (!Character.isAlphabetic(c)) {

                return "Ime nije samo od slova";
            }
        }

        //jmbg validacija
        String prezime = txtPrezime.getText();
        if (prezime.length() != 5) {
            return "Prezime mora da ima tacno 13 karaktera";
        }

//        for (int i = 0; i < prezime.length(); i++) {
//            Character c = prezime.charAt(i);
//            if (!Character.isDigit(c)){
//                return "Ovo je slucaj da prezime mora da ima smo brojeve";
//            }
//        }
//        
        return "";//ovo je ako nema greske
    }

}
