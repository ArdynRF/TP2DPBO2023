/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package daftarAnime;

import com.mysql.jdbc.Blob;
import com.mysql.jdbc.Statement;
import java.io.FileOutputStream;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author Adin
 */
public class animePanel extends javax.swing.JPanel {

    private int id;
    private dbConnection db;
    private JPanel dataPanel;
    private Anime data;
    private String status;
    private boolean stat;
    
    /**
     * Creates new form animePanel
     */
    
    public animePanel(){
        initComponents();
    }
    
    public animePanel(JPanel dataPanel, int id, String title, String deskripsi, String studio, ImageIcon icon) {
        initComponents();
        db = new dbConnection();
        this.dataPanel = dataPanel;
        data = new Anime(id, title, deskripsi, studio);
        
        judulEx.setText(data.getTitle());
        deskEx.setText(data.getDeskripsi());
        studioEx.setText(data.getStudio());
        imgLbl.setIcon(icon);
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        imgLbl = new javax.swing.JLabel();
        judulLbl = new javax.swing.JLabel();
        deskripsiLbl = new javax.swing.JLabel();
        studioLbl = new javax.swing.JLabel();
        judulEx = new javax.swing.JLabel();
        deskEx = new javax.swing.JLabel();
        studioEx = new javax.swing.JLabel();
        deleteB = new javax.swing.JButton();
        editB = new javax.swing.JButton();

        setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        imgLbl.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        judulLbl.setText("Judul:");

        deskripsiLbl.setText("Deskripsi:");

        studioLbl.setText("Studio:");

        judulEx.setText("example judul");

        deskEx.setText("example desk");

        studioEx.setText("example studio");

        deleteB.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        deleteB.setText("Delete");
        deleteB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteBActionPerformed(evt);
            }
        });

        editB.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        editB.setText("Edit");
        editB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editBActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(imgLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(judulLbl)
                            .addComponent(deskripsiLbl)
                            .addComponent(studioLbl))
                        .addGap(30, 30, 30)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(studioEx)
                            .addComponent(deskEx)
                            .addComponent(judulEx))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(146, 146, 146)
                        .addComponent(deleteB)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(editB)
                        .addGap(18, 18, 18))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(judulLbl)
                            .addComponent(judulEx))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(deskripsiLbl)
                            .addComponent(deskEx))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(studioLbl)
                            .addComponent(studioEx))
                        .addGap(20, 20, 20)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(deleteB)
                            .addComponent(editB)))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(imgLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void deleteBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteBActionPerformed
        // TODO add your handling code here:
        try{
//            Statement s = (Statement) db.getStmt();
            String sql = "DELETE FROM anime WHERE 'id' = " + data.getId() + ";";
            db.updateQuery(sql);
            JOptionPane.showMessageDialog(null,"Data Berhasil Dihapus!");
            
            dataPanel.remove(this);
            dataPanel.revalidate();
            dataPanel.repaint();           
            
        } catch (Exception e){
            System.err.println("Read failed" + e.getMessage());
        }
    }//GEN-LAST:event_deleteBActionPerformed

    private void editBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editBActionPerformed
        // TODO add your handling code here:
        this.status = "EDIT ANIME";
        this.stat = false;
        this.id = data.getId();
        animeForm frame = new animeForm(this.status, this.stat, this.id);
        frame.setVisible(true);
    }//GEN-LAST:event_editBActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton deleteB;
    private javax.swing.JLabel deskEx;
    private javax.swing.JLabel deskripsiLbl;
    private javax.swing.JButton editB;
    private javax.swing.JLabel imgLbl;
    private javax.swing.JLabel judulEx;
    private javax.swing.JLabel judulLbl;
    private javax.swing.JLabel studioEx;
    private javax.swing.JLabel studioLbl;
    // End of variables declaration//GEN-END:variables
}
