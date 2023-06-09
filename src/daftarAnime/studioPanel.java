/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package daftarAnime;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author Adin
 */
public class studioPanel extends javax.swing.JPanel {

    /**
     * Creates new form animePanel
     */
    private int id;
    private dbConnection db;
    private JPanel dataPanel;
    private Studio data;
    private String status;
    private boolean stat;
    
    /**
     * Creates new form animePanel
     */
    
    public studioPanel(){
        initComponents();
    }
    
    public studioPanel(JPanel dataPanel, int id, String name, String tahun, ImageIcon icon) {
        initComponents();
        db = new dbConnection();
        this.dataPanel = dataPanel;
        data = new Studio(id, name, tahun);
        
        namaEx.setText(data.getName());
        tahunEx.setText(data.getTahun());
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

        namaLbl = new javax.swing.JLabel();
        tahunLbl = new javax.swing.JLabel();
        namaEx = new javax.swing.JLabel();
        tahunEx = new javax.swing.JLabel();
        deleteB = new javax.swing.JButton();
        editB = new javax.swing.JButton();
        imgLbl = new javax.swing.JLabel();

        setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        setAutoscrolls(true);

        namaLbl.setText("nama:");

        tahunLbl.setText("Didirikan:");

        namaEx.setText("example nama");

        tahunEx.setText("example tahun");

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

        imgLbl.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(imgLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(namaLbl)
                            .addComponent(tahunLbl))
                        .addGap(30, 30, 30)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tahunEx)
                            .addComponent(namaEx))
                        .addContainerGap(129, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
                            .addComponent(namaLbl)
                            .addComponent(namaEx))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tahunLbl)
                            .addComponent(tahunEx))
                        .addGap(42, 42, 42)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(deleteB)
                            .addComponent(editB)))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(imgLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void deleteBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteBActionPerformed
        // TODO add your handling code here:
        try{
            //            Statement s = (Statement) db.getStmt();
            String sql = "DELETE FROM studio WHERE 'id' = " + data.getId() + ";";
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
        this.status = "EDIT STUDIO";
        this.stat = false;
        this.id = data.getId();
        studioForm frame = new studioForm(this.status, this.stat, this.id);
        frame.setVisible(true);
    }//GEN-LAST:event_editBActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton deleteB;
    private javax.swing.JButton editB;
    private javax.swing.JLabel imgLbl;
    private javax.swing.JLabel namaEx;
    private javax.swing.JLabel namaLbl;
    private javax.swing.JLabel tahunEx;
    private javax.swing.JLabel tahunLbl;
    // End of variables declaration//GEN-END:variables
}
