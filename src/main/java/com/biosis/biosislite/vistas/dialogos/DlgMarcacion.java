/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.biosis.biosislite.vistas.dialogos;

import com.personal.utiles.FormularioUtil;
import com.biosis.biosislite.entidades.reportes.RptMarcacion;
import java.util.Date;
import javax.swing.JDialog;
import javax.swing.JOptionPane;

/**
 *
 * @author Francis
 */
public class DlgMarcacion extends javax.swing.JDialog {

    /**
     * Creates new form DlgMarcacion
     */
    private Date horaElegida;
    private final String horaPatron = "HH:mm";
    private RptMarcacion rptMarcacion;

    public DlgMarcacion(JDialog parent, boolean modal, RptMarcacion rptMarcacion) {
        super(JOptionPane.getFrameForComponent(parent), modal);
        initComponents();
        this.setLocationRelativeTo(parent);
        FormularioUtil.modeloSpinnerFechaHora(this.spReferencia, horaPatron);
        FormularioUtil.modeloSpinnerFechaHora(this.spTolerancia, horaPatron);
        FormularioUtil.modeloSpinnerFechaHora(this.spHoraRegistrar, horaPatron);
        this.rptMarcacion = rptMarcacion;
        mostrarDatos(this.rptMarcacion);
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
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        spReferencia = new javax.swing.JSpinner();
        jLabel2 = new javax.swing.JLabel();
        spTolerancia = new javax.swing.JSpinner();
        jLabel3 = new javax.swing.JLabel();
        spHoraRegistrar = new javax.swing.JSpinner();
        jPanel3 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel2.setLayout(new java.awt.BorderLayout(0, 5));

        jPanel1.setLayout(new java.awt.GridLayout(0, 2, 5, 5));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel1.setText("Hora de referencia:");
        jPanel1.add(jLabel1);

        spReferencia.setModel(new javax.swing.SpinnerDateModel());
        spReferencia.setEnabled(false);
        jPanel1.add(spReferencia);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel2.setText("Hora de tolerancia:");
        jPanel1.add(jLabel2);

        spTolerancia.setModel(new javax.swing.SpinnerDateModel());
        spTolerancia.setEnabled(false);
        jPanel1.add(spTolerancia);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel3.setText("Hora a registrar:");
        jPanel1.add(jLabel3);

        spHoraRegistrar.setModel(new javax.swing.SpinnerDateModel());
        jPanel1.add(spHoraRegistrar);

        jPanel2.add(jPanel1, java.awt.BorderLayout.CENTER);

        jPanel3.setLayout(new java.awt.GridLayout());

        jButton1.setText("Aceptar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton1);

        jButton2.setText("Cancelar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton2);

        jPanel2.add(jPanel3, java.awt.BorderLayout.SOUTH);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 367, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        this.rptMarcacion.setEvento((Date) this.spHoraRegistrar.getValue());
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JSpinner spHoraRegistrar;
    private javax.swing.JSpinner spReferencia;
    private javax.swing.JSpinner spTolerancia;
    // End of variables declaration//GEN-END:variables

    private void mostrarDatos(RptMarcacion rptMarcacion) {
        this.spReferencia.setValue(rptMarcacion.getReferencia());
        if (rptMarcacion.getTolerancia() != null) {
            this.spTolerancia.setValue(rptMarcacion.getTolerancia());
        }

        if (this.rptMarcacion.getEvento() != null) {
            this.spHoraRegistrar.setValue(rptMarcacion.getEvento());
        } else {
            this.spHoraRegistrar.setValue(rptMarcacion.getReferencia());
        }

    }

    Date getHoraElegida() {
        this.setVisible(true);
        return (Date) this.spHoraRegistrar.getValue();
    }
}
