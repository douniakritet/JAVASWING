package javaswingdev.form;

import java.awt.Component;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javaswingdev.card.ModelCard;
import javaswingdev.main.Add_Exposition;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import raven.cell.TableActionCellEditor;
import raven.cell.TableActionCellRender;
import raven.cell.TableActionEvent;
import java.sql.Date;
public class Exposition extends javax.swing.JPanel {

    public Exposition() {
        initComponents();
        init();
        Connect(); // Connexion à la base de données
        Fetch(); // Récupérer les données de la base de données
     // Initialiser les autres composants personnalisés
TableActionEvent event = new TableActionEvent() {
            @Override
            public void onEdit(int row) {
                System.out.println("Edit row : " + row);
            }

            @Override
            public void onDelete(int row) {
                if (table.isEditing()) {
                    table.getCellEditor().stopCellEditing();
                }
                DefaultTableModel model = (DefaultTableModel) table.getModel();
                model.removeRow(row);
            }

            
        };
        table.getColumnModel().getColumn(5).setCellRenderer(new TableActionCellRender());
        table.getColumnModel().getColumn(5).setCellEditor(new TableActionCellEditor(event));
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
              table.getColumnModel().getColumn(4).setCellRenderer(new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable jtable, Object o, boolean bln, boolean bln1, int i, int i1) {
                setHorizontalAlignment(SwingConstants.LEFT);
                return super.getTableCellRendererComponent(jtable, o, bln, bln1, i, i1);
            }
        });
    }

    private void init() {
        table.fixTable(jScrollPane1);
        

        //  init card data
        card1.setData(new ModelCard(null, null, null, "$ 500.00", "Report Income Monthly"));
        card2.setData(new ModelCard(null, null, null, "$ 800.00", "Report Expense Monthly"));
        card3.setData(new ModelCard(null, null, null, "$ 300.00", "Report Profit Monthly"));
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
   private void Fetch(){
    int q;
    try {
        pst = (com.mysql.jdbc.PreparedStatement) con.prepareStatement("SELECT * FROM exposition");
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
                "ID", "Name", "START DATE", "END DATE", "LOCATION", "Action"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(table);

        jButton3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton3.setForeground(new java.awt.Color(25, 118, 211));
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8-add-30.png"))); // NOI18N
        jButton3.setText("Add Exposition");
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
                .addComponent(jScrollPane1)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, roundPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18))
        );
        roundPanel1Layout.setVerticalGroup(
            roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel1Layout.createSequentialGroup()
                .addComponent(jButton3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(textFieldAnimation1, javax.swing.GroupLayout.PREFERRED_SIZE, 319, javax.swing.GroupLayout.PREFERRED_SIZE))
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
            Add_Exposition addArtisteFrame = new Add_Exposition();
            addArtisteFrame.setVisible(true);
        } catch (Exception ex) {
            ex.printStackTrace();
            // Add more specific error handling or logging here
        }
    }                                                

    private void searchExposition(String searchTerm) {
    try {
        // Prepare the SQL statement to search for expositions
        String query = "SELECT * FROM exposition WHERE nom LIKE ? OR lieu LIKE ?";
        pst = con.prepareStatement(query);
        pst.setString(1, "%" + searchTerm + "%"); // Search by name
        pst.setString(2, "%" + searchTerm + "%"); // Search by location
        rs = pst.executeQuery();

        // Clear the table before adding search results
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setRowCount(0);

        // Populate the table with search results
        while (rs.next()) {
            Vector<Object> row = new Vector<>();
            row.add(rs.getString("idE")); // Assuming "idE" is the column name for exposition ID
            row.add(rs.getString("nom")); // Name of the exposition
            row.add(rs.getString("dateDebut")); // Start date of the exposition
            row.add(rs.getString("dateFin")); // End date of the exposition
            row.add(rs.getString("lieu")); // Location of the exposition
            model.addRow(row);
        }
    } catch (SQLException ex) {
        Logger.getLogger(Exposition.class.getName()).log(Level.SEVERE, null, ex);
    }
}
    private void textFieldAnimation1ActionPerformed(java.awt.event.ActionEvent evt) {                                                    
        String searchTerm = textFieldAnimation1.getText().trim();
    searchExposition(searchTerm);
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
