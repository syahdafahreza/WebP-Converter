package SF.WebPConverter;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.*;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import com.luciad.imageio.webp.*;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.List;
import javax.swing.JComponent;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.TransferHandler;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Umarkov
 */
public class MainUI extends javax.swing.JFrame {

    /**
     * Creates new form MainUI
     */
    public MainUI() {
        initComponents();
        modifyLabel();
        //System.loadLibrary("webp-imageio");
        //ImageIcon imageIcon = new ImageIcon(new ImageIcon("helpicon.png").getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT));
        //btnhelp.setIcon(imageIcon);
    }
    
    public void modifyLabel(){
        TransferHandler th = new TransferHandler(){
            @Override
            public boolean canImport(JComponent comp, DataFlavor[] transferFlavors) {
                return true;
            }

            @Override
            public boolean importData(JComponent comp, Transferable t) {
                try {
                    List<File> files = (List<File>) t.getTransferData(DataFlavor.javaFileListFlavor);
                    for (File file : files){
                        BufferedImage img = null;
                        selectedfield.setText(file.toString());
                        img = ImageIO.read(new File(file.toString()));
                        Image dimg = img.getScaledInstance(imgcontainer.getWidth(), imgcontainer.getHeight(),
                        Image.SCALE_SMOOTH);
                        ImageIcon imageIcon = new ImageIcon(dimg);
                        imgcontainer.setIcon(imageIcon);
                        System.out.println(file.getName());
                    }
                } catch (UnsupportedFlavorException ex) {
                    Logger.getLogger(MainUI.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    Logger.getLogger(MainUI.class.getName()).log(Level.SEVERE, null, ex);
                }
                return true;
            }
        };
        imgcontainer.setTransferHandler(th);
    }

    //Create a file chooser
    final JFileChooser fc = new JFileChooser();
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnconvert = new javax.swing.JButton();
        imgcontainer = new javax.swing.JLabel();
        btnbrowse = new javax.swing.JButton();
        imgformatcombo = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        selectedfield = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        btnhelp = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("WebP Converter");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        btnconvert.setText("Convert Now!");
        btnconvert.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnconvertActionPerformed(evt);
            }
        });

        imgcontainer.setBackground(new java.awt.Color(255, 255, 255));
        imgcontainer.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        btnbrowse.setText("Browse");
        btnbrowse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnbrowseActionPerformed(evt);
            }
        });

        imgformatcombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "jpg", "png" }));
        imgformatcombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                imgformatcomboActionPerformed(evt);
            }
        });

        jLabel2.setText("Convert image to:");

        selectedfield.setEditable(false);
        selectedfield.setText("Please select your image...");

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("Image preview");

        btnhelp.setIcon(new javax.swing.ImageIcon(getClass().getResource("/SF/WebPConverter/helpicon16px.png"))); // NOI18N
        btnhelp.setAlignmentY(0.0F);
        btnhelp.setFocusPainted(false);
        btnhelp.setPreferredSize(new java.awt.Dimension(23, 23));
        btnhelp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnhelpActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(152, 152, 152)
                        .addComponent(btnhelp, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(imgcontainer, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(imgformatcombo, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(1, 1, 1)
                                .addComponent(selectedfield, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnconvert, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnbrowse, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnhelp, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(imgcontainer, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnbrowse)
                    .addComponent(selectedfield, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(7, 7, 7)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(imgformatcombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnconvert))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnbrowseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnbrowseActionPerformed
        // TODO add your handling code here:
        //In response to a button click:
        //Handle open button action.
        BufferedImage img = null;
        
    if (evt.getSource() == btnbrowse) {
        int returnVal = fc.showOpenDialog(this);

        if (returnVal == JFileChooser.APPROVE_OPTION) {
            File file = fc.getSelectedFile();
            String FileInputName = fc.getSelectedFile().getName();
            //This is where a real application would open the file.
            String SelectedFile = fc.getSelectedFile().toString();
            selectedfield.setText(SelectedFile);
            System.out.println(file.getName());
            //FileInputName.replaceAll(".webp","");
            //System.out.println(FileInputName.replaceAll(".webp",""));
            try {
    img = ImageIO.read(new File(SelectedFile));
} catch (IOException e) {
    e.printStackTrace();
}
            Image dimg = img.getScaledInstance(imgcontainer.getWidth(), imgcontainer.getHeight(),
        Image.SCALE_SMOOTH);
            
            ImageIcon imageIcon = new ImageIcon(dimg);
            imgcontainer.setIcon(imageIcon);
        } else {
            
        }
    }
    }//GEN-LAST:event_btnbrowseActionPerformed

    private void btnconvertActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnconvertActionPerformed
        // TODO add your handling code here:
        //File file = fc.getSelectedFile();
        //This is where a real application would open the file.
        String SelectedFile = selectedfield.getText();
        String FileInputName = selectedfield.getText();
        String FINameOnly = FileInputName.substring(0,FileInputName.length()-5);
        System.out.println("FI Name Only: "+FINameOnly);
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Specify a file to save");   
        fileChooser.setSelectedFile(new File(FINameOnly));
        int userSelection = fileChooser.showSaveDialog(this);
 
        if (userSelection == JFileChooser.APPROVE_OPTION) {
        File fileToSave = fileChooser.getSelectedFile();
        
        System.out.println("Save as file: " + fileToSave.getAbsolutePath());
        }
        String Format = imgformatcombo.getSelectedItem().toString();
        System.out.println("Value: " + imgformatcombo.getSelectedItem().toString());
        System.out.println("String Format: " + Format);
        File fileToSave = fileChooser.getSelectedFile();
        String FileSave = fileToSave.toString()+"."+Format;
        File file1= new File(SelectedFile);
        File file2= new File(FileSave);  

try {  
    BufferedImage im = ImageIO.read(file1);   
    ImageIO.write(im, Format, file2); 
    selectedfield.setText("Converted successfully!");
} catch (IOException e) {  
    e.printStackTrace();  
}  
    }//GEN-LAST:event_btnconvertActionPerformed

    private void imgformatcomboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_imgformatcomboActionPerformed
        // TODO add your handling code here:
        String Format = imgformatcombo.getSelectedItem().toString();
        System.out.println("Value: " + imgformatcombo.getSelectedItem().toString());
        System.out.println("String Format: " + Format);
    }//GEN-LAST:event_imgformatcomboActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        // TODO add your handling code here:

    }//GEN-LAST:event_formWindowOpened

    private void btnhelpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnhelpActionPerformed
        // TODO add your handling code here:
        new AboutUI().setVisible(true);
    }//GEN-LAST:event_btnhelpActionPerformed

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
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnbrowse;
    private javax.swing.JButton btnconvert;
    private javax.swing.JButton btnhelp;
    private javax.swing.JLabel imgcontainer;
    private javax.swing.JComboBox<String> imgformatcombo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JTextField selectedfield;
    // End of variables declaration//GEN-END:variables
}
