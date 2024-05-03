/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaswingdev.main;
import com.mysql.jdbc.PreparedStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javaswingdev.form.Form_Dashboard;

import javaswingdev.form.Artistes;
import javaswingdev.form.Artistes;
import javax.swing.JOptionPane;
/**
 *
 * @author ME1
 */
public class Update_Arr extends javax.swing.JFrame {

    private String artistId;

    /**
     * Creates new form login
     */
    public Update_Arr(String artistInfo) {
        initComponents();
        txtusername.setBackground(new java.awt.Color(0,0,0,1));
        txtusername1.setBackground(new java.awt.Color(0,0,0,1));
        jDateChooser1.setBackground(new java.awt.Color(0,0,0,1));
        Connect();
        setArtistData(artistId);
        
    }
Connection con;
PreparedStatement pst;

    private Update_Arr() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    public void Connect(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/art","root","");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Artistes.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Artistes.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtusername = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        txtusername1 = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(25, 118, 211));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 32)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Add Artiste");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 10, 420, 41));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(199, 226, 255));
        jLabel5.setText("Nmae");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 80, 341, -1));

        txtusername.setFont(txtusername.getFont().deriveFont(txtusername.getFont().getSize()+2f));
        txtusername.setForeground(new java.awt.Color(255, 255, 255));
        txtusername.setBorder(null);
        jPanel2.add(txtusername, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 100, 240, 30));

        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("_________________________________________");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 110, 290, 39));

        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 0, 0));
        jButton1.setText("Cancel");
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 340, 100, 30));

        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(199, 226, 255));
        jLabel10.setText("Nationality");
        jPanel2.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 150, 341, -1));

        txtusername1.setFont(txtusername1.getFont().deriveFont(txtusername1.getFont().getSize()+2f));
        txtusername1.setForeground(new java.awt.Color(255, 255, 255));
        txtusername1.setBorder(null);
        jPanel2.add(txtusername1, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 170, 240, 30));

        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("_________________________________________");
        jPanel2.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 180, 290, 39));

        jLabel12.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(199, 226, 255));
        jLabel12.setText("Date of birth");
        jPanel2.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 220, 341, -1));

        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("_________________________________________");
        jPanel2.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 250, 290, 39));

        jButton2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton2.setForeground(new java.awt.Color(25, 118, 211));
        jButton2.setText("Update");
        jButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 340, 100, 30));
        jPanel2.add(jDateChooser1, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 240, 240, 30));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 920, 440));

        setSize(new java.awt.Dimension(588, 438));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        for (double i = 0.0; i <=1.0; i = i+0.1){
            String val = i+ "";
            float f = Float.valueOf(val);
            this.setOpacity(f);
            try{
                Thread.sleep(50);
            }catch(Exception e){
                
            }
        }
    }//GEN-LAST:event_formWindowOpened

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        setVisible(false);
        // Create and display the Add_Artiste frame
        dashboard addArtisteFrame = new dashboard();
        addArtisteFrame.setVisible(true);
        /*try {
        setVisible(false);
        // Create and display the Add_Artiste frame
        Artistes addArtisteFrame = new Artistes();
        addArtisteFrame.setVisible(true);    } catch (Exception ex) {
        ex.printStackTrace();
        // Add more specific error handling or logging here
        }*/
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // Récupérez les nouvelles informations saisies par l'utilisateur dans les champs de texte
        String nom = txtusername.getText();
        String nationalite = txtusername1.getText();
        Date dateNaissance = jDateChooser1.getDate();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String dateNaissanceStr = dateFormat.format(dateNaissance);
        // Effectuez la mise à jour dans la base de données
        updateArtistInDatabase(nom, nationalite, dateNaissanceStr);

    }//GEN-LAST:event_jButton2ActionPerformed

 
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
            java.util.logging.Logger.getLogger(Update_Arr.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Update_Arr.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Update_Arr.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Update_Arr.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Update_Arr().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField txtusername;
    private javax.swing.JTextField txtusername1;
    // End of variables declaration//GEN-END:variables

    public void setArtistData(String idToUpdate, String name, String nationality, String dateOfBirth) {
txtusername.setText(name);
        txtusername1.setText(nationality);
        // Utilisez SimpleDateFormat pour convertir la date de naissance de String en Date
        try {
            Date date = new SimpleDateFormat("yyyy-MM-dd").parse(dateOfBirth);
            jDateChooser1.setDate(date);
        } catch (ParseException ex) {
            Logger.getLogger(Update_Arr.class.getName()).log(Level.SEVERE, null, ex);
        }    }

    private void updateArtistInDatabase(String nom, String nationalite, String dateNaissanceStr) {
try {
        // Préparez la requête SQL pour mettre à jour l'artiste
        String query = "UPDATE artiste SET nom=?, nationalite=?, dateNaissance=? WHERE id=?";
        pst = (PreparedStatement) con.prepareStatement(query);
        pst.setString(1, nom);
        pst.setString(2, nationalite);
        pst.setString(3, dateNaissanceStr);
        // Remplacez "id" par le nom de votre colonne d'identifiant d'artiste dans la base de données
       // pst.setString(4, /* id de l'artiste à mettre à jour */);
        
        // Exécutez la requête de mise à jour
        int rowsAffected = pst.executeUpdate();
        
        // Vérifiez si la mise à jour a réussi
        if (rowsAffected > 0) {
            JOptionPane.showMessageDialog(this, "Artist Updated Successfully!");
        } else {
            JOptionPane.showMessageDialog(this, "Failed to Update Artist!");
        }
    } catch (SQLException ex) {
        Logger.getLogger(Update_Arr.class.getName()).log(Level.SEVERE, null, ex);
    }    }
public void setArtistData(String artistId) {
    // Utilisez l'identifiant de l'artiste pour récupérer les informations de l'artiste depuis la base de données
    // Assurez-vous de remplacer cet exemple par votre propre logique pour récupérer les données de l'artiste
    String name = ""; // Remplacez "" par le nom de l'artiste récupéré depuis la base de données
    String nationality = ""; // Remplacez "" par la nationalité de l'artiste récupérée depuis la base de données
    String dateOfBirth = ""; // Remplacez "" par la date de naissance de l'artiste récupérée depuis la base de données
    
    txtusername.setText(name);
    txtusername1.setText(nationality);
    
    // Utilisez SimpleDateFormat pour convertir la date de naissance de String en Date
    try {
        Date date = new SimpleDateFormat("yyyy-MM-dd").parse(dateOfBirth);
        jDateChooser1.setDate(date);
    } catch (ParseException ex) {
        Logger.getLogger(Update_Arr.class.getName()).log(Level.SEVERE, null, ex);
    }
}

    
}
