/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vut.gui;

import javax.swing.*;
import vut.*;
import vut.PatientPD.PatientType;

/**
 *
 * @author Matimu Baloyi 219059802
 */
public class PatientManagementApp extends javax.swing.JFrame
{

    private PatientPD objPatient = null;

    /**
     * Creates new form PatientManagementApp
     */
    public PatientManagementApp()
    {
        initComponents();
        radButtonGroup();

        objPatient = new PatientPD();

        try
        {
            objPatient.getConnection();

            JOptionPane.showMessageDialog(null, "Welcome to Patient Management Application", "Patient Management App", JOptionPane.INFORMATION_MESSAGE);

        }
        catch (DataStorageException ex)
        {
            JOptionPane.showMessageDialog(null, "Data Storage connection \n" + ex.getMessage(), "Patient Management App", JOptionPane.ERROR_MESSAGE);
        }

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents()
    {

        pnlGeneral = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtSurname = new javax.swing.JTextField();
        txtID = new javax.swing.JTextField();
        txtAmount_Due = new javax.swing.JTextField();
        pnlTypePatient = new javax.swing.JPanel();
        radInPatient = new javax.swing.JRadioButton();
        radOutPatient = new javax.swing.JRadioButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        taDisplay = new javax.swing.JTextArea();
        btnViewAll = new javax.swing.JButton();
        btnSave = new javax.swing.JButton();
        btnViewPatients = new javax.swing.JButton();
        btnMore = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Patient Management App");
        setName("frmPatientManagementApp"); // NOI18N

        pnlGeneral.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "General", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.ABOVE_TOP, new java.awt.Font("Tahoma", 0, 14))); // NOI18N

        jLabel1.setText("Surname: ");

        jLabel2.setText("ID Number: ");

        jLabel3.setText("Amount Due:");

        javax.swing.GroupLayout pnlGeneralLayout = new javax.swing.GroupLayout(pnlGeneral);
        pnlGeneral.setLayout(pnlGeneralLayout);
        pnlGeneralLayout.setHorizontalGroup(
            pnlGeneralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlGeneralLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlGeneralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(pnlGeneralLayout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addComponent(txtAmount_Due, javax.swing.GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE))
                    .addGroup(pnlGeneralLayout.createSequentialGroup()
                        .addGroup(pnlGeneralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1))
                        .addGap(23, 23, 23)
                        .addGroup(pnlGeneralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtSurname, javax.swing.GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE)
                            .addComponent(txtID))))
                .addContainerGap(57, Short.MAX_VALUE))
        );
        pnlGeneralLayout.setVerticalGroup(
            pnlGeneralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlGeneralLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlGeneralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtSurname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnlGeneralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnlGeneralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtAmount_Due, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnlTypePatient.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Type of Patient:", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 14))); // NOI18N

        radInPatient.setText("In-Patient");

        radOutPatient.setText("Out-Patient");

        javax.swing.GroupLayout pnlTypePatientLayout = new javax.swing.GroupLayout(pnlTypePatient);
        pnlTypePatient.setLayout(pnlTypePatientLayout);
        pnlTypePatientLayout.setHorizontalGroup(
            pnlTypePatientLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlTypePatientLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(radInPatient)
                .addGap(18, 18, 18)
                .addComponent(radOutPatient)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlTypePatientLayout.setVerticalGroup(
            pnlTypePatientLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlTypePatientLayout.createSequentialGroup()
                .addGroup(pnlTypePatientLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(radInPatient)
                    .addComponent(radOutPatient))
                .addGap(0, 7, Short.MAX_VALUE))
        );

        taDisplay.setColumns(20);
        taDisplay.setRows(5);
        jScrollPane1.setViewportView(taDisplay);

        btnViewAll.setText("View All");
        btnViewAll.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btnViewAllActionPerformed(evt);
            }
        });

        btnSave.setText("Save Patient");
        btnSave.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btnSaveActionPerformed(evt);
            }
        });

        btnViewPatients.setText("View Patients");
        btnViewPatients.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btnViewPatientsActionPerformed(evt);
            }
        });

        btnMore.setText("More OPtions...");
        btnMore.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btnMoreActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(pnlGeneral, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnSave, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnViewAll, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(btnMore, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnViewPatients, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(9, 9, 9))
                            .addComponent(pnlTypePatient, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnViewPatients)
                            .addComponent(btnSave))
                        .addGap(4, 4, 4)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnMore)
                            .addComponent(btnViewAll))
                        .addGap(11, 11, 11)
                        .addComponent(pnlTypePatient, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(pnlGeneral, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(46, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Group Radio Buttons and select default
     */
    private void radButtonGroup()
    {
        ButtonGroup radButtonGroup = new ButtonGroup();

        radButtonGroup.add(radOutPatient);
        radButtonGroup.add(radInPatient);

        radOutPatient.setSelected(true);

    }

    private void header()
    {
        taDisplay.setText("ID_Number" + "\t\t" + "Surname" + "\t" + "Patient_Type" + "\t" + "Amount_Due" + "\n" + "...................................................................................................................................................." + "\n");
    }

    private void btnViewAllActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btnViewAllActionPerformed
    {//GEN-HEADEREND:event_btnViewAllActionPerformed

        header();
        try
        {

            taDisplay.append(objPatient.getAll().toString().replace(",", "").replace("[", "").replace("]", ""));
        }
        catch (NotFoundException ex)
        {
            JOptionPane.showMessageDialog(this, "Data Not Found" + ex.getMessage());
        }


    }//GEN-LAST:event_btnViewAllActionPerformed

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btnSaveActionPerformed
    {//GEN-HEADEREND:event_btnSaveActionPerformed
        String idNr = txtID.getText();
        String surname = txtSurname.getText();
        double amountDue;
        objPatient = new PatientPD();
        PatientType typeOfPatient = null;

        if (radInPatient.isSelected())
        {
            typeOfPatient = PatientType.IN_PATIENT;

        }
        else if (radOutPatient.isSelected())
        {
            typeOfPatient = PatientType.OUT_PATIENT;

        }

        try
        {
            amountDue = Double.parseDouble(txtAmount_Due.getText());

            objPatient = new PatientPD(surname, idNr, typeOfPatient, amountDue);
            objPatient.addPatient(objPatient);

            JOptionPane.showMessageDialog(this, "Object Saved In The Database", "Save", JOptionPane.INFORMATION_MESSAGE);
        }
        catch (NumberFormatException ex)
        {
            JOptionPane.showMessageDialog(this, "Invalid Numeric value: " + ex.getMessage());
        }
        catch (IllegalArgumentException | DuplicateException ex)
        {
            JOptionPane.showMessageDialog(this, "Error!" + ex.getMessage());
        }


    }//GEN-LAST:event_btnSaveActionPerformed

    private void btnViewPatientsActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btnViewPatientsActionPerformed
    {//GEN-HEADEREND:event_btnViewPatientsActionPerformed
        String patientType = JOptionPane.showInputDialog("Enter type of patients to view(type in,in_P, out or out_P)");
      taDisplay.removeAll();
      header();
      
      
      
      
      
      
      
      
      
      
      
      
      
        try
        {

            taDisplay.append(objPatient.returnPatientType(patientType).toString().replace(",", "").replace("[", "").replace("]", ""));

        }
        catch (NotFoundException ex)
        {
            JOptionPane.showMessageDialog(null, "No Data Found" + ex.getMessage());
        }

    }//GEN-LAST:event_btnViewPatientsActionPerformed

    private void btnMoreActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btnMoreActionPerformed
    {//GEN-HEADEREND:event_btnMoreActionPerformed
       // this.setVisible(false);
        PatientDataManipulationApp frmChild = new PatientDataManipulationApp();

        frmChild.setTitle("Patient Data Manipulation App");
        frmChild.setVisible(true);
         
    }//GEN-LAST:event_btnMoreActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[])
    {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try
        {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels())
            {
                if ("Nimbus".equals(info.getName()))
                {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        }
        catch (ClassNotFoundException ex)
        {
            java.util.logging.Logger.getLogger(PatientManagementApp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        catch (InstantiationException ex)
        {
            java.util.logging.Logger.getLogger(PatientManagementApp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        catch (IllegalAccessException ex)
        {
            java.util.logging.Logger.getLogger(PatientManagementApp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        catch (javax.swing.UnsupportedLookAndFeelException ex)
        {
            java.util.logging.Logger.getLogger(PatientManagementApp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable()
        {
            public void run()
            {
                new PatientManagementApp().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnMore;
    private javax.swing.JButton btnSave;
    private javax.swing.JButton btnViewAll;
    private javax.swing.JButton btnViewPatients;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel pnlGeneral;
    private javax.swing.JPanel pnlTypePatient;
    private javax.swing.JRadioButton radInPatient;
    private javax.swing.JRadioButton radOutPatient;
    private javax.swing.JTextArea taDisplay;
    private javax.swing.JTextField txtAmount_Due;
    private javax.swing.JTextField txtID;
    private javax.swing.JTextField txtSurname;
    // End of variables declaration//GEN-END:variables
}
