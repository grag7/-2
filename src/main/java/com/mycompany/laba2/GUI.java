
package com.mycompany.laba2;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

public class GUI extends javax.swing.JFrame {
    private Mediator mediator;

  
    public GUI(Mediator mediator) {
        this.mediator = mediator;
        initComponents();
        jChoosingSheet.setVisible(false);
        calculationButton.setVisible(false);
        saveToButton.setVisible(false);
        
        try {
            configureFileChooser();
        } catch (URISyntaxException ex) {
            
        }
        
        
        
        
    }

    
    private void configureFileChooser() throws URISyntaxException {
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Excel files",
                "xlsx", "xls");
        File currentDirectory = new File(getClass().getProtectionDomain()
                    .getCodeSource().getLocation().toURI().getPath()).getParentFile();
        fileChooser = new JFileChooser(currentDirectory);
        fileChooser.setFileFilter(filter);
        fileChooser.setAcceptAllFileFilterUsed(false);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        fileChooser = new javax.swing.JFileChooser();
        panel = new javax.swing.JPanel();
        jChoosingSheet = new javax.swing.JComboBox<>();
        readFileButton = new javax.swing.JButton();
        calculationButton = new javax.swing.JButton();
        saveToButton = new javax.swing.JButton();
        exitButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jChoosingSheet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jChoosingSheetActionPerformed(evt);
            }
        });
        panel.add(jChoosingSheet, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 70, 170, -1));

        readFileButton.setText("Считать файл");
        readFileButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                readFileButtonActionPerformed(evt);
            }
        });
        panel.add(readFileButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 30, 170, -1));

        calculationButton.setText("Расчитать");
        calculationButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                calculationButtonActionPerformed(evt);
            }
        });
        panel.add(calculationButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 110, 170, -1));

        saveToButton.setText("Сохранить ");
        saveToButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveToButtonActionPerformed(evt);
            }
        });
        panel.add(saveToButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 150, 170, -1));

        exitButton.setText("Выход");
        exitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitButtonActionPerformed(evt);
            }
        });
        panel.add(exitButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 190, 90, -1));

        getContentPane().add(panel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 290, 240));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jChoosingSheetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jChoosingSheetActionPerformed
        try {
            loadDataFromSheet(jChoosingSheet.getSelectedItem().toString());
            saveToButton.setVisible(false);
        } catch (IOException ex) {
            showErrorMessage();
        }
    }//GEN-LAST:event_jChoosingSheetActionPerformed
    private void configureComboBox(ArrayList<String> namesList) {
        jChoosingSheet.setModel(new DefaultComboBoxModel<>(namesList.toArray(
                        new String[namesList.size()])));
    }
    
    private void loadDataFromSheet(String sheetName) throws IOException {
        try{
            mediator.getDataFromFile(sheetName);
        } catch (Exception ex) {
            throw new IOException();
        }
    }
    
    private void readFileButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_readFileButtonActionPerformed
        int returnValue = fileChooser.showOpenDialog(null);
        
        if (returnValue == JFileChooser.APPROVE_OPTION) {
              File file = fileChooser.getSelectedFile();
            try {
                ArrayList<String> sheetNames = mediator.getExcelReader().
                        getSheetNames(file);
                configureComboBox(sheetNames);
                jChoosingSheet.setVisible(true);
                loadDataFromSheet(jChoosingSheet.getSelectedItem().toString());
                calculationButton.setVisible(true);

            } catch (FileNotFoundException ex) {
                showErrorMessage();
            } catch (IOException ex) {
                showErrorMessage();
            }
              
              
        }
    }//GEN-LAST:event_readFileButtonActionPerformed

    private void calculationButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_calculationButtonActionPerformed
        try {
            mediator.Calculation();
            saveToButton.setVisible(true);
        } catch (Exception ex) {
            saveToButton.setVisible(false);
            JOptionPane.showMessageDialog(rootPane,
                    "Ошибка при вычислении. Попробуйте другой файл.", "Ошибка",
                    JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_calculationButtonActionPerformed

    private void saveToButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveToButtonActionPerformed
        int returnValue = fileChooser.showSaveDialog(null);
        if (returnValue == JFileChooser.APPROVE_OPTION) {
            File fileToSave = fileChooser.getSelectedFile();
            if (!fileToSave.getAbsolutePath().endsWith(".xlsx")) {
                fileToSave = new File(fileToSave.getAbsolutePath() + ".xlsx");
           }
            try {
                mediator.writeToFile(fileToSave);
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(rootPane, "Ошибка записи.",
                        "Ошибка записи", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_saveToButtonActionPerformed

    private void exitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitButtonActionPerformed
        System.exit(0);
    }//GEN-LAST:event_exitButtonActionPerformed

    private void showErrorMessage() {
        JOptionPane.showMessageDialog(rootPane, "Ошибка чтения файла", "Ошибка",
                JOptionPane.ERROR_MESSAGE);
    }
 

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton calculationButton;
    private javax.swing.JButton exitButton;
    private javax.swing.JFileChooser fileChooser;
    private javax.swing.JComboBox<String> jChoosingSheet;
    private javax.swing.JPanel panel;
    private javax.swing.JButton readFileButton;
    private javax.swing.JButton saveToButton;
    // End of variables declaration//GEN-END:variables
}
