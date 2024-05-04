package javaswingdev.form;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javaswingdev.main.Add_Arr;
import javaswingdev.card.ModelCard;
import java.sql.*;
import java.sql.Connection;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javaswingdev.main.Update_Arrr;
import javaswingdev.main.dashboard;
import javaswingdev.main.login;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import raven.cell.TableActionCellEditor;
import raven.cell.TableActionCellRender;
import raven.cell.TableActionEvent;
import swing.EventCallBack;
import swing.EventTextField;
import swing.TextFieldAnimation;


public class Artistes extends javax.swing.JPanel {
    private TextFieldAnimation textField;
    public Artistes() {
    initComponents(); // Initialiser les composants Swing
    Connect(); // Connexion à la base de données
    Fetch(); // Récupérer les données de la base de données
    init();
   
    
    // Initialisez votre TableActionEvent ici
    TableActionEvent event = new TableActionEvent() {
        @Override
        public void onEdit(int rowIndex) {
           int row = table.getSelectedRow();
            if (row != -1) {
                String idToUpdate = table.getModel().getValueAt(row, 0).toString();
                String name = table.getModel().getValueAt(row, 1).toString();
                String nationality = table.getModel().getValueAt(row, 2).toString();
                String dateOfBirth = table.getModel().getValueAt(row, 3).toString();

                // Assuming txtId is a JTextField for ID
                JTextField txtId = new JTextField();
                Update_Arrr updateForm = new Update_Arrr();
                updateForm.setVisible(true);
                updateForm.setArtistData(idToUpdate, name, nationality, dateOfBirth);
            } else {
                JOptionPane.showMessageDialog(null, "Please select a row to update.");
            }   // Add more specific error handling or logging here
    
           
        }

        @Override
public void onDelete(int row) {
    if (table.isEditing()) {
        table.getCellEditor().stopCellEditing();
    }
    DefaultTableModel model = (DefaultTableModel) table.getModel();
    
    // Get the ID of the artist to be deleted
    String idToDelete = model.getValueAt(row, 0).toString();
    
    // Remove the row from the table model
    model.removeRow(row);
    
    // Delete the corresponding record from the database
  try {
    // Establish database connection
    Connection con = DriverManager.getConnection("jdbc:mysql://localhost/art", "root", "");

    // Prepare the delete statement for "transaction" table
    PreparedStatement pstTransaction = con.prepareStatement("DELETE FROM transaction WHERE idOeuvre IN (SELECT idO FROM oeuvre WHERE idArtiste = ?)");
    pstTransaction.setString(1, idToDelete);
    pstTransaction.executeUpdate();

    // Prepare the delete statement for "oeuvre" table
    PreparedStatement pstOeuvre = con.prepareStatement("DELETE FROM oeuvre WHERE idArtiste = ?");
    pstOeuvre.setString(1, idToDelete);
    pstOeuvre.executeUpdate();
    
    // Prepare the delete statement for "artiste" table
    PreparedStatement pstArtiste = con.prepareStatement("DELETE FROM artiste WHERE idAr = ?");
    pstArtiste.setString(1, idToDelete);
    pstArtiste.executeUpdate();

    // Close the statements
    pstTransaction.close();
    pstOeuvre.close();
    pstArtiste.close();

    // Close the connection
    con.close();
} catch (SQLException ex) {
    // Handle any SQL exceptions
    ex.printStackTrace();
    // You might want to show an error message to the user here
}


}

    };

    // Ajoutez le renderer et l'éditeur à votre colonne de table
    table.getColumnModel().getColumn(4).setCellRenderer(new TableActionCellRender());
    table.getColumnModel().getColumn(4).setCellEditor(new TableActionCellEditor(event));
        table.getColumnModel().getColumn(0).setCellRenderer(new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable jtable, Object o, boolean bln, boolean bln1, int i, int i1) {
                setHorizontalAlignment(SwingConstants.LEFT);
                return super.getTableCellRendererComponent(jtable, o, bln, bln1, i, i1);
            }
        });
         table.getColumnModel().getColumn(1).setCellRenderer(new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable jtable, Object o, boolean bln, boolean bln1, int i, int i1) {
                setHorizontalAlignment(SwingConstants.LEFT);
                return super.getTableCellRendererComponent(jtable, o, bln, bln1, i, i1);
            }
        });
          table.getColumnModel().getColumn(2).setCellRenderer(new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable jtable, Object o, boolean bln, boolean bln1, int i, int i1) {
                setHorizontalAlignment(SwingConstants.LEFT);
                return super.getTableCellRendererComponent(jtable, o, bln, bln1, i, i1);
            }
        });
           table.getColumnModel().getColumn(3).setCellRenderer(new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable jtable, Object o, boolean bln, boolean bln1, int i, int i1) {
                setHorizontalAlignment(SwingConstants.LEFT);
                return super.getTableCellRendererComponent(jtable, o, bln, bln1, i, i1);
            }
        });
           
}

/*public Artistes() {
    initComponents(); // Initialiser les composants Swing
    Connect(); // Connexion à la base de données
    Fetch(); // Récupérer les données de la base de données
    init(); // Initialiser les autres composants personnalisés
TableActionEvent event = new TableActionEvent() {
            @Override
            public void onEdit(int row) {
                int row = table.getSelectedRow();
                if (row != -1) {
                    String id = table.getModel().getValueAt(row, 0).toString();
                    String name = table.getModel().getValueAt(row, 1).toString();
                    String nationality = table.getModel().getValueAt(row, 2).toString();
                    String dateOfBirth = table.getModel().getValueAt(row, 3).toString();

                    // Assuming txtId is a JTextField for ID
                    JTextField txtId = new JTextField();
                    Update_Arr updateForm = new Update_Arr();
                    updateForm.setVisible(true);
                    updateForm.setArtistData(id, name, nationality, dateOfBirth);
                } else {
                    JOptionPane.showMessageDialog(null, "Please select a row to update.");
                }
            }
        });
    } catch (SQLException ex) {
        ex.printStackTrace();
        // Handle the SQL exception here
    }
}       }

            @Override
            public void onDelete(int row) {
                if (table.isEditing()) {
                    table.getCellEditor().stopCellEditing();
                }
                DefaultTableModel model = (DefaultTableModel) table.getModel();
                model.removeRow(row);
            }

            
        };
        table.getColumnModel().getColumn(4).setCellRenderer(new TableActionCellRender());
        table.getColumnModel().getColumn(4).setCellEditor(new TableActionCellEditor(event));
        table.getColumnModel().getColumn(0).setCellRenderer(new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable jtable, Object o, boolean bln, boolean bln1, int i, int i1) {
                setHorizontalAlignment(SwingConstants.LEFT);
                return super.getTableCellRendererComponent(jtable, o, bln, bln1, i, i1);
            }
        });
         table.getColumnModel().getColumn(1).setCellRenderer(new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable jtable, Object o, boolean bln, boolean bln1, int i, int i1) {
                setHorizontalAlignment(SwingConstants.LEFT);
                return super.getTableCellRendererComponent(jtable, o, bln, bln1, i, i1);
            }
        });
          table.getColumnModel().getColumn(2).setCellRenderer(new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable jtable, Object o, boolean bln, boolean bln1, int i, int i1) {
                setHorizontalAlignment(SwingConstants.LEFT);
                return super.getTableCellRendererComponent(jtable, o, bln, bln1, i, i1);
            }
        });
           table.getColumnModel().getColumn(3).setCellRenderer(new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable jtable, Object o, boolean bln, boolean bln1, int i, int i1) {
                setHorizontalAlignment(SwingConstants.LEFT);
                return super.getTableCellRendererComponent(jtable, o, bln, bln1, i, i1);
            }
        });
    // Ajoutez le reste de votre code personnalisé ici
}*/

    /*public Artistes() {
        //initComponents();
        Connect();
        init();
        Fetch();
        initComponents();
       
    }*/
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    // </editor-fold>


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
            java.util.logging.Logger.getLogger(Artistes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Artistes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Artistes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Artistes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Artistes().setVisible(true);
            }
        });
    }
    java.sql.Connection con;
java.sql.PreparedStatement pst;
    ResultSet rs;
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
 /* private void Fetch(){
    int q;
    try {
        pst = (com.mysql.jdbc.PreparedStatement) con.prepareStatement("SELECT * FROM artiste");
        rs = pst.executeQuery();
        ResultSetMetaData rss = rs.getMetaData();
        q = rss.getColumnCount();
        DefaultTableModel df = (DefaultTableModel)table.getModel();
        df.setRowCount(0);
        while(rs.next()){
            Vector v2 = new Vector();
            for(int a=0;a<=q;a++){
                v2.add(rs.getString("idAr"));
                v2.add(rs.getString("nom"));
                v2.add(rs.getString("nationalite"));
                v2.add(rs.getString("dateNaissance"));
            }
         
            df.addRow(v2);
        }
        
    } catch (SQLException ex) {
        Logger.getLogger(Artistes.class.getName()).log(Level.SEVERE, null, ex);
    }
}*/
 private void Fetch(){
    int q;
    try {
        pst = (com.mysql.jdbc.PreparedStatement) con.prepareStatement("SELECT * FROM artiste");
        rs = pst.executeQuery();
        ResultSetMetaData rss = rs.getMetaData();
        q = rss.getColumnCount();
        DefaultTableModel df = (DefaultTableModel)table.getModel();
        df.setRowCount(0);
        while(rs.next()){
            Vector<Object> v2 = new Vector<>();
            for(int a=1;a<=q;a++){
                v2.add(rs.getString(a)); // Use a 1-based index for ResultSet
            }
           
           
            df.addRow(v2);
        }
    } catch (SQLException ex) {
        Logger.getLogger(Artistes.class.getName()).log(Level.SEVERE, null, ex);
    }
}

// Set custom renderer and editor for the button columns

    private void init() {
        table.fixTable(jScrollPane1);
         
      /*  table.addRow(new Object[]{"1", "Mike Bhand", "mikebhand@gmail.com", "Admin", "25 Apr,2018"});
        table.addRow(new Object[]{"2", "Andrew Strauss", "andrewstrauss@gmail.com", "Editor", "25 Apr,2018"});
        table.addRow(new Object[]{"3", "Ross Kopelman", "rosskopelman@gmail.com", "Subscriber", "25 Apr,2018"});
        table.addRow(new Object[]{"4", "Mike Hussy", "mikehussy@gmail.com", "Admin", "25 Apr,2018"});
        table.addRow(new Object[]{"5", "Kevin Pietersen", "kevinpietersen@gmail.com", "Admin", "25 Apr,2018"});
        table.addRow(new Object[]{"6", "Andrew Strauss", "andrewstrauss@gmail.com", "Editor", "25 Apr,2018"});
        table.addRow(new Object[]{"7", "Ross Kopelman", "rosskopelman@gmail.com", "Subscriber", "25 Apr,2018"});
        table.addRow(new Object[]{"8", "Mike Hussy", "mikehussy@gmail.com", "Admin", "25 Apr,2018"});
        table.addRow(new Object[]{"9", "Kevin Pietersen", "kevinpietersen@gmail.com", "Admin", "25 Apr,2018"});
        table.addRow(new Object[]{"10", "Kevin Pietersen", "kevinpietersen@gmail.com", "Admin", "25 Apr,2018"});
        table.addRow(new Object[]{"11", "Andrew Strauss", "andrewstrauss@gmail.com", "Editor", "25 Apr,2018"});
        table.addRow(new Object[]{"12", "Ross Kopelman", "rosskopelman@gmail.com", "Subscriber", "25 Apr,2018"});
        table.addRow(new Object[]{"13", "Mike Hussy", "mikehussy@gmail.com", "Admin", "25 Apr,2018"});
        table.addRow(new Object[]{"14", "Kevin Pietersen", "kevinpietersen@gmail.com", "Admin", "25 Apr,2018"});
*/
        //  init card data
        card1.setData(new ModelCard(null, null, null, "$ 500.00", "Report Income Monthly"));
        card2.setData(new ModelCard(null, null, null, "$ 800.00", "Report Expense Monthly"));
        card3.setData(new ModelCard(null, null, null, "$ 300.00", "Report Profit Monthly"));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        card1 = new javaswingdev.card.Card();
        card2 = new javaswingdev.card.Card();
        card3 = new javaswingdev.card.Card();
        roundPanel1 = new javaswingdev.swing.RoundPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javaswingdev.swing.table.Table();
        jButton3 = new javax.swing.JButton();
        textFieldAnimation1 = new swing.TextFieldAnimation();

        setOpaque(false);

        card2.setColor1(new java.awt.Color(95, 211, 226));
        card2.setColor2(new java.awt.Color(26, 166, 170));
        card2.setIcon(javaswingdev.GoogleMaterialDesignIcon.PIE_CHART);

        card3.setColor1(new java.awt.Color(95, 243, 140));
        card3.setColor2(new java.awt.Color(3, 157, 27));
        card3.setIcon(javaswingdev.GoogleMaterialDesignIcon.RING_VOLUME);

        roundPanel1.setBackground(new java.awt.Color(255, 255, 255));
        roundPanel1.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 5, 5, 5));
        roundPanel1.setRound(10);

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Name", "NATIONALITY", "DATE OF BIRTH", "ACTION"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(table);

        jButton3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton3.setForeground(new java.awt.Color(25, 118, 211));
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8-add-30.png"))); // NOI18N
        jButton3.setText("Add Artiste");
        jButton3.setBorder(null);
        jButton3.setContentAreaFilled(false);
        jButton3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout roundPanel1Layout = new javax.swing.GroupLayout(roundPanel1);
        roundPanel1.setLayout(roundPanel1Layout);
        roundPanel1Layout.setHorizontalGroup(
            roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, roundPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        roundPanel1Layout.setVerticalGroup(
            roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(72, Short.MAX_VALUE))
        );

        textFieldAnimation1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textFieldAnimation1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(roundPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(card1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(30, 30, 30)
                        .addComponent(card2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(30, 30, 30)
                        .addComponent(card3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(30, 30, 30))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(textFieldAnimation1, javax.swing.GroupLayout.PREFERRED_SIZE, 319, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(textFieldAnimation1, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(card3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(card2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(card1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addComponent(roundPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(30, 30, 30))
        );
    }// </editor-fold>                        

    private void jButton3jButton1ActionPerformed(java.awt.event.ActionEvent evt) {                                                 
        // TODO add your handling code here:
        try {
        setVisible(false);
        
        // Create and display the Add_Artiste frame
        Add_Arr addArtisteFrame = new Add_Arr();
        addArtisteFrame.setVisible(true);
    } catch (Exception ex) {
        ex.printStackTrace();
        // Add more specific error handling or logging here
    }
    }                                                

    private void searchArtist(String searchTerm) {
    try {
        // Prepare the SQL statement to search for artists
        String query = "SELECT * FROM artiste WHERE nom LIKE ? OR nationalite LIKE ?";
        pst = con.prepareStatement(query);
        pst.setString(1, "%" + searchTerm + "%"); // Search by name
        pst.setString(2, "%" + searchTerm + "%"); // Search by nationality
        rs = pst.executeQuery();

        // Clear the table before adding search results
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setRowCount(0);

        // Populate the table with search results
        while (rs.next()) {
            Vector<Object> row = new Vector<>();
            row.add(rs.getString("idAr"));
            row.add(rs.getString("nom"));
            row.add(rs.getString("nationalite"));
            row.add(rs.getString("dateNaissance"));
            model.addRow(row);
        }
    } catch (SQLException ex) {
        Logger.getLogger(Artistes.class.getName()).log(Level.SEVERE, null, ex);
    }
}

    private void textFieldAnimation1ActionPerformed(java.awt.event.ActionEvent evt) {                                                    
       String searchTerm = textFieldAnimation1.getText().trim();
    searchArtist(searchTerm); // TODO add your handling code here:
    }                                                   


    // Variables declaration - do not modify                     
    private javaswingdev.card.Card card1;
    private javaswingdev.card.Card card2;
    private javaswingdev.card.Card card3;
    private javax.swing.JButton jButton3;
    private javax.swing.JScrollPane jScrollPane1;
    private javaswingdev.swing.RoundPanel roundPanel1;
    private javaswingdev.swing.table.Table table;
    private swing.TextFieldAnimation textFieldAnimation1;
    // End of variables declaration                   
}
