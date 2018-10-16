////////////////////////////////////////////////////////////////////////////////
//
// MULe Final Project:
// MetaMP3Editor: A Java MP3 metadata editor.
// Based on mp3agic library --> https://github.com/mpatric/mp3agic
//
// Authors:
//  - Guillermo Montes Martos (xmonte03)
//  - Norma Schulze Giménez (xschul04)
//
////////////////////////////////////////////////////////////////////////////////

package MULe;

import com.mpatric.mp3agic.ID3v1;
import com.mpatric.mp3agic.ID3v2;
import com.mpatric.mp3agic.ID3v24Tag;
import com.mpatric.mp3agic.InvalidDataException;
import com.mpatric.mp3agic.Mp3File;
import com.mpatric.mp3agic.NotSupportedException;
import com.mpatric.mp3agic.UnsupportedTagException;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Arrays;
import java.util.UUID;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;



public class View extends javax.swing.JFrame {

    /**
     * Creates new form View
     */
    public View() {
        initComponents();
        setVisible(true);
        setLocationRelativeTo(null);
        setResizable(false);
        setTitle("MetaMP3Editor");
        
        // Centering the window
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        setLocation(dim.width / 2 - getSize().width / 2, dim.height / 2 - getSize().height / 2);
        
        // Setting propierties on fields and menu items
        filenameField.setEditable(false);
        trackField.setEditable(false);
        titleField.setEditable(false);
        artistField.setEditable(false);
        albumField.setEditable(false);
        yearField.setEditable(false);
        genreDescriptionField.setEditable(false);
        commentField.setEditable(false);
        composerField.setEditable(false);
        publisherField.setEditable(false);
        oArtistField.setEditable(false);
        aArtistField.setEditable(false);
        urlField.setEditable(false);
        copyrightField.setEditable(false);
        encoderField.setEditable(false);
        bitrateField.setEditable(false);
        sampleRateField.setEditable(false);
        saveMenuItem.setEnabled(false);
        saveAsMenuItem.setEnabled(false);
        discardMenuItem.setEnabled(false);
        editImageMenuItem.setEnabled(false);
        exportImageMenuItem.setEnabled(false);
        imageLabel.setVisible(false);
        imageLabel.setSize(300, 300);
        
        // Array of bytes for holding the cover album image
        imageBytes = null;
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
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        filenameField = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        trackField = new javax.swing.JTextField();
        titleField = new javax.swing.JTextField();
        artistField = new javax.swing.JTextField();
        yearField = new javax.swing.JTextField();
        albumField = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        commentField = new javax.swing.JTextArea();
        composerField = new javax.swing.JTextField();
        oArtistField = new javax.swing.JTextField();
        publisherField = new javax.swing.JTextField();
        copyrightField = new javax.swing.JTextField();
        urlField = new javax.swing.JTextField();
        aArtistField = new javax.swing.JTextField();
        bitrateField = new javax.swing.JTextField();
        sampleRateField = new javax.swing.JTextField();
        encoderField = new javax.swing.JTextField();
        genreDescriptionField = new javax.swing.JTextField();
        imageLabel = new javax.swing.JLabel();
        bar = new javax.swing.JMenuBar();
        fileMenu = new javax.swing.JMenu();
        openMenuItem = new javax.swing.JMenuItem();
        exportImageMenuItem = new javax.swing.JMenuItem();
        exitMenuItem = new javax.swing.JMenuItem();
        editMenu = new javax.swing.JMenu();
        saveMenuItem = new javax.swing.JMenuItem();
        saveAsMenuItem = new javax.swing.JMenuItem();
        editImageMenuItem = new javax.swing.JMenuItem();
        discardMenuItem = new javax.swing.JMenuItem();
        helpMenu = new javax.swing.JMenu();
        aboutMenuItem = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Filename");

        jLabel2.setText("Track");

        jLabel3.setText("Artist");

        jLabel4.setText("Title");

        jLabel5.setText("Album");

        jLabel6.setText("Year");

        jLabel7.setText("Genre");

        jLabel8.setText("Comment");

        jLabel9.setText("Composer");

        jLabel10.setText("Publisher");

        jLabel11.setText("Original artist");

        jLabel12.setText("Album artist");

        jLabel13.setText("Copyright");

        jLabel14.setText("URL");

        jLabel15.setText("Encoder");

        jLabel16.setText("Bitrate");

        jLabel17.setText("Sample rate");

        commentField.setColumns(20);
        commentField.setRows(5);
        jScrollPane1.setViewportView(commentField);

        fileMenu.setText("File");

        openMenuItem.setText("Open");
        openMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                openMenuItemActionPerformed(evt);
            }
        });
        fileMenu.add(openMenuItem);

        exportImageMenuItem.setText("Export album image");
        exportImageMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exportImageMenuItemActionPerformed(evt);
            }
        });
        fileMenu.add(exportImageMenuItem);

        exitMenuItem.setText("Exit");
        exitMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitMenuItemActionPerformed(evt);
            }
        });
        fileMenu.add(exitMenuItem);

        bar.add(fileMenu);

        editMenu.setText("Edit");

        saveMenuItem.setText("Save");
        saveMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveMenuItemActionPerformed(evt);
            }
        });
        editMenu.add(saveMenuItem);

        saveAsMenuItem.setText("Save as");
        saveAsMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveAsMenuItemActionPerformed(evt);
            }
        });
        editMenu.add(saveAsMenuItem);

        editImageMenuItem.setText("Edit album image");
        editImageMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editImageMenuItemActionPerformed(evt);
            }
        });
        editMenu.add(editImageMenuItem);

        discardMenuItem.setText("Discard changes");
        discardMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                discardMenuItemActionPerformed(evt);
            }
        });
        editMenu.add(discardMenuItem);

        bar.add(editMenu);

        helpMenu.setText("Help");

        aboutMenuItem.setText("About");
        aboutMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aboutMenuItemActionPerformed(evt);
            }
        });
        helpMenu.add(aboutMenuItem);

        bar.add(helpMenu);

        setJMenuBar(bar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel16, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel15, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel14, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel13, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel12, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel17, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(composerField)
                                .addComponent(publisherField)
                                .addComponent(oArtistField)
                                .addComponent(aArtistField)
                                .addComponent(copyrightField)
                                .addComponent(urlField, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(encoderField, javax.swing.GroupLayout.Alignment.TRAILING))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(bitrateField)
                                .addComponent(sampleRateField, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(imageLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(trackField, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(artistField, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(titleField, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(albumField, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(yearField, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(genreDescriptionField, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(filenameField, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 618, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(filenameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel2))
                    .addComponent(trackField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(artistField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(titleField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(albumField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(yearField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(genreDescriptionField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(composerField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(20, 20, 20)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(publisherField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(23, 23, 23)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11)
                            .addComponent(oArtistField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel12)
                            .addComponent(aArtistField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel13)
                            .addComponent(copyrightField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel14)
                            .addComponent(urlField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(16, 16, 16)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel15)
                            .addComponent(encoderField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel16)
                            .addComponent(bitrateField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel17)
                            .addComponent(sampleRateField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(imageLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void exitMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitMenuItemActionPerformed
        System.exit(1);
    }//GEN-LAST:event_exitMenuItemActionPerformed

    private void openMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_openMenuItemActionPerformed
        // Displaying a file chooser frame
        JFileChooser fileChooser = new JFileChooser();
        if (fileChooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();
            filePath = file.getAbsolutePath();
            
            try {
                // Creating object MP3File, provided by the library
                mp3 = new Mp3File(filePath);
                
                if (mp3.hasId3v2Tag())      // if mp3 has id3v2 tag
                    id3v2tag = mp3.getId3v2Tag();
                else if (mp3.hasId3v1Tag()) // else if mp3 has id3v1 tag
                    id3v2tag = getId3v2FromId3v1(mp3.getId3v1Tag());
                else
                    id3v2tag = new ID3v24Tag(); // else, empty id3v2 tag is created
                
                displayMetadata();
            
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(this, "File not found.");
            } catch (UnsupportedTagException ex) {
                JOptionPane.showMessageDialog(this, "Unsupported tag.");
            } catch (InvalidDataException ex) {
                JOptionPane.showMessageDialog(this, "Invalid data.");
            }
        }
    }//GEN-LAST:event_openMenuItemActionPerformed

    private void saveMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveMenuItemActionPerformed
        saveMP3();
    }//GEN-LAST:event_saveMenuItemActionPerformed

    private void saveAsMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveAsMenuItemActionPerformed
        if (mp3 != null) {
            JFileChooser fileChooser = new JFileChooser();
            if (fileChooser.showSaveDialog(this) == JFileChooser.APPROVE_OPTION) {
                File file = fileChooser.getSelectedFile();
                
                if (file.getAbsolutePath().equals(filePath)) {  // if new filename is same as old one
                    saveMP3();
                }
                else {
                    try {
                        saveTags();     // saving tags in mp3 object
                        mp3.save(file.getAbsolutePath());       // saving mp3 file
                        JOptionPane.showMessageDialog(this, "File saved");
                    } catch (IOException ex) {
                        JOptionPane.showMessageDialog(this, "Error while saving file.");
                    } catch (NotSupportedException ex) {
                        JOptionPane.showMessageDialog(this, "Unknown error.");
                    }
                }
            }
        }
    }//GEN-LAST:event_saveAsMenuItemActionPerformed

    private void discardMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_discardMenuItemActionPerformed
        // discard the modified information is the same as reprinting the information of the mp3 object
        if (mp3 != null)
            displayMetadata();
    }//GEN-LAST:event_discardMenuItemActionPerformed

    private void aboutMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aboutMenuItemActionPerformed
        JOptionPane.showMessageDialog(this, "MetaMP3Editor: A Java MP3 metadata editor.\n" +
                "Based on mp3agic library (https://github.com/mpatric/mp3agic).\n\n" +
                "Authors:\n\t- Guillermo Montes Martos (xmonte03)\n\t- Norma Schulze Giménez (xschul04)");
    }//GEN-LAST:event_aboutMenuItemActionPerformed

    private void editImageMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editImageMenuItemActionPerformed
        // Opening file chooser menu
        JFileChooser fileChooser = new JFileChooser();
        if (fileChooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();
            try {
                BufferedImage image = ImageIO.read(file);   // gettin image from file
                if (image != null){
                    // Converting image to binary bytes
                    ByteArrayOutputStream out = new ByteArrayOutputStream();
                    ImageIO.write(image, getFileExtension(file), out);
                    imageBytes = out.toByteArray();
                    
                    // Scale image 
                    Image dimg = image.getScaledInstance(300, 300, Image.SCALE_SMOOTH);
                    imageLabel.setIcon(new ImageIcon(dimg));
                    imageLabel.setVisible(true);
                    imageLabel.repaint();
                }
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(this, "Error opening image.");
            }
        }

    }//GEN-LAST:event_editImageMenuItemActionPerformed

    private void exportImageMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exportImageMenuItemActionPerformed
        if (imageBytes != null) {
            // Selecting file
            JFileChooser fileChooser = new JFileChooser();
            if (fileChooser.showSaveDialog(this) == JFileChooser.APPROVE_OPTION) {
                File file = fileChooser.getSelectedFile();
                RandomAccessFile randomfile = null;
                
                try {
                    // creating new file with rw permissions
                    randomfile = new RandomAccessFile(file.getAbsolutePath(), "rw");
                } catch (FileNotFoundException ex) {
                    JOptionPane.showMessageDialog(this, "Error opening image.");
                }
                try {
                    // writing bytes to file
                    randomfile.write(imageBytes);
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(this, "Error while exporting image.");
                }
                try {
                    // closing files
                    randomfile.close();
                    JOptionPane.showMessageDialog(this, "Image exported!");
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(this, "Error while closing exported image.");            
                }
            }
        }
    }//GEN-LAST:event_exportImageMenuItemActionPerformed

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
            java.util.logging.Logger.getLogger(View.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(View.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(View.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(View.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new View().setVisible(true);
            }
        });
    }

    
    public void displayMetadata() {
        // enabling fields 
        trackField.setEditable(true);
        titleField.setEditable(true);
        artistField.setEditable(true);
        albumField.setEditable(true);
        yearField.setEditable(true);
        genreDescriptionField.setEditable(true);
        commentField.setEditable(true);
        composerField.setEditable(true);
        publisherField.setEditable(true);
        oArtistField.setEditable(true);
        aArtistField.setEditable(true);
        urlField.setEditable(true);
        copyrightField.setEditable(true);
        encoderField.setEditable(true);
        saveMenuItem.setEnabled(true);
        saveAsMenuItem.setEnabled(true);
        discardMenuItem.setEnabled(true);
        editImageMenuItem.setEnabled(true);
        exportImageMenuItem.setEnabled(true);

        // displaying information
        filenameField.setText(filePath);
        trackField.setText(id3v2tag.getTrack());
        artistField.setText(id3v2tag.getArtist());
        titleField.setText(id3v2tag.getTitle());
        albumField.setText(id3v2tag.getAlbum());
        genreDescriptionField.setText(id3v2tag.getGenreDescription());
        commentField.setText(id3v2tag.getComment());
        yearField.setText(id3v2tag.getYear());
        publisherField.setText(id3v2tag.getPublisher());
        composerField.setText(id3v2tag.getComposer());
        oArtistField.setText(id3v2tag.getOriginalArtist());
        aArtistField.setText(id3v2tag.getAlbumArtist());
        urlField.setText(id3v2tag.getUrl());
        encoderField.setText(id3v2tag.getEncoder());
        copyrightField.setText(id3v2tag.getCopyright());
        bitrateField.setText(mp3.getBitrate() + "Kbps " + (mp3.isVbr()? "(VBR)" : "(CBR)"));
        sampleRateField.setText(mp3.getSampleRate() + "Hz");
        getCoverImage();
    }
    
    
    public void saveTags() {
        // saving info on tag
        id3v2tag.setTrack(trackField.getText());
        id3v2tag.setArtist(artistField.getText());
        id3v2tag.setTitle(titleField.getText());
        id3v2tag.setAlbum(albumField.getText());
        id3v2tag.setGenreDescription(genreDescriptionField.getText());
        id3v2tag.setComment(commentField.getText());
        id3v2tag.setYear(yearField.getText());
        id3v2tag.setPublisher(publisherField.getText());
        id3v2tag.setComposer(composerField.getText());
        id3v2tag.setOriginalArtist(oArtistField.getText());
        id3v2tag.setAlbumArtist(aArtistField.getText());
        id3v2tag.setUrl(urlField.getText());
        id3v2tag.setEncoder(encoderField.getText());
        id3v2tag.setCopyright(copyrightField.getText());
        id3v2tag.setAlbumImage(imageBytes, "image/jpg");
        if ( !Arrays.equals(imageBytes, id3v2tag.getAlbumImage()) )
            JOptionPane.showMessageDialog(this, "Error saving album image.");
        
        // saving tag on mp3
        mp3.setId3v2Tag(id3v2tag);
    }
    
    
    public void saveMP3() {
        if (mp3 != null) {
            // random filename because limitations of mp3agic library
            String filename = new File(filePath).getParent() + "/" + UUID.randomUUID().toString() + ".mp3";
            try {
                saveTags();
                mp3.save(filename);
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(this, "Error while saving fileasdfasdf.");
            } catch (NotSupportedException ex) {
                JOptionPane.showMessageDialog(this, "Unknown error.");
            }

            // Remove the old one 
            File file = new File(filePath);
            if (!file.delete()) {
                JOptionPane.showMessageDialog(this, "Internal error.");
                System.exit(-1);
            }

            // Rename the new one
            file = new File(filename);
            if (file.renameTo(new File(filePath))) {
                JOptionPane.showMessageDialog(this, "File saved");
            } else {
                JOptionPane.showMessageDialog(this, "Error while saving file.");
            }
        }
    }
    
    
    public void getCoverImage() {
        imageBytes = id3v2tag.getAlbumImage();
        BufferedImage img = null;
        try {
            img = ImageIO.read(new ByteArrayInputStream(imageBytes));
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, "Error getting album image.");
        }
        
        // Scaling image
        Image dimg = img.getScaledInstance(300, 300, Image.SCALE_SMOOTH);

        if (imageBytes != null) {
            imageLabel.setIcon(new ImageIcon(dimg));
            imageLabel.setVisible(true);
            imageLabel.repaint();
        }
        else
            imageLabel.setVisible(false);
    }
    
    
    private ID3v2 getId3v2FromId3v1(ID3v1 id3v1tag) {
        // just get info from id3v1 tag and put it on a new id3v2
        ID3v2 newtag = new ID3v24Tag();
        newtag.setTitle(id3v1tag.getTitle());
        newtag.setArtist(id3v1tag.getArtist());
        newtag.setAlbum(id3v1tag.getAlbum());
        newtag.setYear(id3v1tag.getYear());
        newtag.setComment(id3v1tag.getComment());
        newtag.setGenre(id3v1tag.getGenre());
        
        return newtag;
    }
    
    
    private static String getFileExtension(File file) {
        String fileName = file.getName();
        if (fileName.lastIndexOf(".") != -1 && fileName.lastIndexOf(".") != 0) {
            return fileName.substring(fileName.lastIndexOf(".") + 1);
        } else {
            return "";
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField aArtistField;
    private javax.swing.JMenuItem aboutMenuItem;
    private javax.swing.JTextField albumField;
    private javax.swing.JTextField artistField;
    private javax.swing.JMenuBar bar;
    private javax.swing.JTextField bitrateField;
    private javax.swing.JTextArea commentField;
    private javax.swing.JTextField composerField;
    private javax.swing.JTextField copyrightField;
    private javax.swing.JMenuItem discardMenuItem;
    private javax.swing.JMenuItem editImageMenuItem;
    private javax.swing.JMenu editMenu;
    private javax.swing.JTextField encoderField;
    private javax.swing.JMenuItem exitMenuItem;
    private javax.swing.JMenuItem exportImageMenuItem;
    private javax.swing.JMenu fileMenu;
    private javax.swing.JTextField filenameField;
    private javax.swing.JTextField genreDescriptionField;
    private javax.swing.JMenu helpMenu;
    private javax.swing.JLabel imageLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField oArtistField;
    private javax.swing.JMenuItem openMenuItem;
    private javax.swing.JTextField publisherField;
    private javax.swing.JTextField sampleRateField;
    private javax.swing.JMenuItem saveAsMenuItem;
    private javax.swing.JMenuItem saveMenuItem;
    private javax.swing.JTextField titleField;
    private javax.swing.JTextField trackField;
    private javax.swing.JTextField urlField;
    private javax.swing.JTextField yearField;
    // End of variables declaration//GEN-END:variables

    private Mp3File mp3;    // MP3 object
    private ID3v2 id3v2tag; // information tag
    private String filePath;    
    private byte[] imageBytes;  // album cover image
}
