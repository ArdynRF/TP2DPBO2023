/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package daftarAnime;

import com.mysql.jdbc.Blob;
import java.sql.ResultSet;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

/**
 *
 * @author Adin
 */
public class Display extends javax.swing.JFrame {

    private dbConnection db;
    private String currentPanel = "Anime";
    private ArrayList<animePanel> Anime;
    private ArrayList<studioPanel> Studio;
//    private boolean isUpdated;
    
    /**
     * Creates new form Display
     */
    public Display() {
        initComponents();
        db = new dbConnection();
        initAnime();
//        this.isUpdated = true;
        
    }
    
//    public void setIsUpdated(boolean isUpdated) {
//      this.isUpdated = isUpdated;
//    }
//    
//    public boolean getIsUpdated() {
//      return isUpdated;
//    }
    
    public void initAnime(){
        Anime = new ArrayList<animePanel>();
        mainPanel.removeAll();
        mainPanel.setLayout(new GridLayout(0, 1, 20, 20));
        
        String sql = "SELECT * FROM anime;";
        ResultSet res = db.selectQuery(sql);
        
        int i = 0;
        try {
            while(res.next()){     
                Blob image = (Blob) res.getBlob("image");
                String path = "D:\\SEMESTER 4\\DPBO\\TP2_DPBO\\src\\gambar\\anime.png";
                byte [] bytea = image.getBytes(1, (int)image.length()); 
                try {
                    FileOutputStream fos = new FileOutputStream(path);
                    try {
                        fos.write(bytea);
                    } catch (IOException ex) {
                        Logger.getLogger(Display.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(Display.class.getName()).log(Level.SEVERE, null, ex);
                }

                // read the image from file
                File file = new File(path);
                BufferedImage img;
                        img = null;
                        try {
                            img = ImageIO.read(file);
                        } catch (IOException ex) {
                            Logger.getLogger(Display.class.getName()).log(Level.SEVERE, null, ex);
                        }

                // resize the image
                if (img != null) {
                    int width =110; // set the desired width of the image
                    int height = (int) (img.getHeight() * ((double) width / img.getWidth())); // calculate the height based on the width and aspect ratio of the image
                    Image resizedImage = img.getScaledInstance(width, height, Image.SCALE_SMOOTH);

                    // save the resized image back to file
                    BufferedImage outputImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
                    outputImage.createGraphics().drawImage(resizedImage, 0, 0, null);
                    try {
                        ImageIO.write(outputImage, "png", file);
                    } catch (IOException ex) {
                        Logger.getLogger(Display.class.getName()).log(Level.SEVERE, null, ex);
                    }

                    ImageIcon icon = new ImageIcon(outputImage);
                    Anime.add(new animePanel(mainPanel, res.getInt("id"), res.getString("title"), res.getString("deskripsi"), res.getString("studio"), icon));
                    mainPanel.add(Anime.get(i));
                    i++;
                } else {
                    System.out.println("Failed to read image file: " + file.getAbsolutePath());
                }
                    }
        } catch (SQLException e) {
            System.err.println("Read failed: " + e.getMessage());
        }
        
        mainPanel.revalidate();
        mainPanel.repaint();       
        
    }
    
    public void initStudio(){
        Studio = new ArrayList<studioPanel>();
        mainPanel.removeAll();
        mainPanel.setLayout(new GridLayout(0, 1, 20, 20));
        
        String sql = "SELECT * FROM studio;";
        ResultSet res = db.selectQuery(sql);
        
        int i = 0;
        try {
            while(res.next()){
                Blob image = (Blob) res.getBlob("image");
                String path = "D:\\SEMESTER 4\\DPBO\\TP2_DPBO\\src\\gambar\\anime.png";
                byte [] bytea = image.getBytes(1, (int)image.length()); 
                try {
                    FileOutputStream fos = new FileOutputStream(path);
                    try {
                        fos.write(bytea);
                    } catch (IOException ex) {
                        Logger.getLogger(Display.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(Display.class.getName()).log(Level.SEVERE, null, ex);
                }

                // read the image from file
                File file = new File(path);
                BufferedImage img;
                        img = null;
                        try {
                            img = ImageIO.read(file);
                        } catch (IOException ex) {
                            Logger.getLogger(Display.class.getName()).log(Level.SEVERE, null, ex);
                        }

                // resize the image
                if (img != null) {
                    int width =108; // set the desired width of the image
                    int height = (int) (img.getHeight() * ((double) width / img.getWidth())); // calculate the height based on the width and aspect ratio of the image
                    Image resizedImage = img.getScaledInstance(width, height, Image.SCALE_SMOOTH);

                    // save the resized image back to file
                    BufferedImage outputImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
                    outputImage.createGraphics().drawImage(resizedImage, 0, 0, null);
                    try {
                        ImageIO.write(outputImage, "png", file);
                    } catch (IOException ex) {
                        Logger.getLogger(Display.class.getName()).log(Level.SEVERE, null, ex);
                    }

                    ImageIcon icon = new ImageIcon(outputImage);
                    Studio.add(new studioPanel(mainPanel, res.getInt("id"), res.getString("name"), res.getString("tahun"), icon));
                    mainPanel.add(Studio.get(i));
                    i++;
                } else {
                    System.out.println("Failed to read image file: " + file.getAbsolutePath());
                }
            }
        } catch (SQLException e) {
            System.err.println("Read failed: " + e.getMessage());
        }
        mainPanel.revalidate();
        mainPanel.repaint();       
        
    }


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        scrollPane = new javax.swing.JScrollPane();
        mainPanel = new javax.swing.JPanel();
        addB = new javax.swing.JButton();
        AnimeB = new javax.swing.JButton();
        StudioB = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(153, 153, 153));

        mainPanel.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout mainPanelLayout = new javax.swing.GroupLayout(mainPanel);
        mainPanel.setLayout(mainPanelLayout);
        mainPanelLayout.setHorizontalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 489, Short.MAX_VALUE)
        );
        mainPanelLayout.setVerticalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 367, Short.MAX_VALUE)
        );

        scrollPane.setViewportView(mainPanel);

        addB.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        addB.setText("Add");
        addB.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        addB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addBActionPerformed(evt);
            }
        });

        AnimeB.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        AnimeB.setText("Anime List");
        AnimeB.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        AnimeB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AnimeBActionPerformed(evt);
            }
        });

        StudioB.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        StudioB.setText("Studio List");
        StudioB.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        StudioB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                StudioBActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(AnimeB)
                .addGap(18, 18, 18)
                .addComponent(StudioB)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(addB)
                .addGap(26, 26, 26))
            .addGroup(layout.createSequentialGroup()
                .addComponent(scrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 491, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addB)
                    .addComponent(StudioB)
                    .addComponent(AnimeB))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
                .addComponent(scrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 369, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void StudioBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_StudioBActionPerformed
        // TODO add your handling code here:
        initStudio();
        currentPanel = "Studio";
    }//GEN-LAST:event_StudioBActionPerformed

    private void AnimeBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AnimeBActionPerformed
        // TODO add your handling code here:
        initAnime();
        currentPanel = "Anime";
    }//GEN-LAST:event_AnimeBActionPerformed

    private void addBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addBActionPerformed
        // TODO add your handling code here:
//        this.setIsUpdated(false);
        if(this.currentPanel.equals("Anime")){
            animeForm frame = new animeForm();
            
           frame.setVisible(true);
        } else {
            studioForm frame = new studioForm();
            
            frame.setVisible(true);
        }
    }//GEN-LAST:event_addBActionPerformed

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
            java.util.logging.Logger.getLogger(Display.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Display.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Display.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Display.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Display().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AnimeB;
    private javax.swing.JButton StudioB;
    private javax.swing.JButton addB;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JScrollPane scrollPane;
    // End of variables declaration//GEN-END:variables
}
