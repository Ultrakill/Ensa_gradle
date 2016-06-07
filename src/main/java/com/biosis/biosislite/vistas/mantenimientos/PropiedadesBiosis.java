/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.biosis.biosislite.vistas.mantenimientos;

import com.personal.utiles.FormularioUtil;
import com.personal.utiles.PropertiesUtil;
import java.io.File;
import java.util.Properties;
import javax.swing.ImageIcon;

/**
 *
 * @author Aldo
 */
public class PropiedadesBiosis extends javax.swing.JFrame {

    /**
     * Creates new form PropiedadesBiosis
     */
    String rutaImgReporte;
    String rutaFondoApp;
    String rutaFondoLogin;
    public PropiedadesBiosis() {
        Properties props = PropertiesUtil.cargarProperties("config/interfaz.properties");
        rutaImgReporte = props.getProperty("reporte_logo");
        rutaFondoApp = props.getProperty("aplicacion_fondo");
        rutaFondoLogin = props.getProperty("login_imagen");
        
        File file1 = new File(rutaImgReporte);
        File file2 = new File(rutaFondoApp);
        File file3 = new File(rutaFondoLogin);
        
        if(file1.exists()){
            System.out.println(rutaImgReporte);
            FormularioUtil.imagenALabel(rutaImgReporte, lblLogoReporte);
        }
        if(file2.exists()){
            FormularioUtil.imagenALabel(rutaFondoApp, lblAplicacionImage);
        }
        if(file3.exists()){
            FormularioUtil.imagenALabel(rutaFondoLogin, lblLoginImg);
        }      
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        pnlPropiedades = new javax.swing.JPanel();
        lblInstitucion = new javax.swing.JLabel();
        lblRuc = new javax.swing.JLabel();
        lblNombreAplicacion = new javax.swing.JLabel();
        lblNombreLogin = new javax.swing.JLabel();
        lblNombreSubtitulo = new javax.swing.JLabel();
        lblLogo = new javax.swing.JLabel();
        lblAplicacion = new javax.swing.JLabel();
        lblLoginImage = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        jTextField5 = new javax.swing.JTextField();
        lblLogoReporte = new javax.swing.JLabel();
        lblAplicacionImage = new javax.swing.JLabel();
        lblLoginImg = new javax.swing.JLabel();
        btnCargarImg1 = new javax.swing.JButton();
        btnCargarImg2 = new javax.swing.JButton();
        btnCargarImg3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        java.awt.GridBagLayout pnlPropiedadesLayout = new java.awt.GridBagLayout();
        pnlPropiedadesLayout.columnWidths = new int[] {0, 8, 0, 8, 0, 8, 0};
        pnlPropiedadesLayout.rowHeights = new int[] {0, 8, 0, 8, 0, 8, 0, 8, 0, 8, 0, 8, 0, 8, 0, 8, 0, 8, 0, 8, 0};
        pnlPropiedades.setLayout(pnlPropiedadesLayout);

        lblInstitucion.setText("Institución:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 0, 0);
        pnlPropiedades.add(lblInstitucion, gridBagConstraints);

        lblRuc.setText("Ruc:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(0, 10, 0, 0);
        pnlPropiedades.add(lblRuc, gridBagConstraints);

        lblNombreAplicacion.setText("Nombre Aplicacion:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(0, 10, 0, 0);
        pnlPropiedades.add(lblNombreAplicacion, gridBagConstraints);

        lblNombreLogin.setText("Título de Login:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(0, 10, 0, 0);
        pnlPropiedades.add(lblNombreLogin, gridBagConstraints);

        lblNombreSubtitulo.setText("Subtítulo de Login:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(0, 10, 0, 0);
        pnlPropiedades.add(lblNombreSubtitulo, gridBagConstraints);

        lblLogo.setText("Logo de reportes:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 10;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(0, 10, 0, 0);
        pnlPropiedades.add(lblLogo, gridBagConstraints);

        lblAplicacion.setText("Fondo de Aplicacion:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 14;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(0, 10, 0, 0);
        pnlPropiedades.add(lblAplicacion, gridBagConstraints);

        lblLoginImage.setText("Imagen para Login:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 18;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(0, 10, 0, 0);
        pnlPropiedades.add(lblLoginImage, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(9, 0, 0, 0);
        pnlPropiedades.add(jTextField1, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 0.1;
        pnlPropiedades.add(jTextField2, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 0.1;
        pnlPropiedades.add(jTextField3, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 0.1;
        pnlPropiedades.add(jTextField4, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 0.1;
        pnlPropiedades.add(jTextField5, gridBagConstraints);

        lblLogoReporte.setBackground(new java.awt.Color(204, 255, 255));
        lblLogoReporte.setMaximumSize(new java.awt.Dimension(200, 100));
        lblLogoReporte.setMinimumSize(new java.awt.Dimension(200, 100));
        lblLogoReporte.setName(""); // NOI18N
        lblLogoReporte.setOpaque(true);
        lblLogoReporte.setPreferredSize(new java.awt.Dimension(200, 100));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 10;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.gridheight = 3;
        pnlPropiedades.add(lblLogoReporte, gridBagConstraints);

        lblAplicacionImage.setBackground(new java.awt.Color(204, 255, 255));
        lblAplicacionImage.setMaximumSize(new java.awt.Dimension(200, 100));
        lblAplicacionImage.setMinimumSize(new java.awt.Dimension(200, 100));
        lblAplicacionImage.setOpaque(true);
        lblAplicacionImage.setPreferredSize(new java.awt.Dimension(200, 100));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 14;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.gridheight = 3;
        pnlPropiedades.add(lblAplicacionImage, gridBagConstraints);

        lblLoginImg.setBackground(new java.awt.Color(204, 255, 255));
        lblLoginImg.setMaximumSize(new java.awt.Dimension(200, 100));
        lblLoginImg.setMinimumSize(new java.awt.Dimension(200, 100));
        lblLoginImg.setOpaque(true);
        lblLoginImg.setPreferredSize(new java.awt.Dimension(200, 100));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 18;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.gridheight = 3;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 10, 0);
        pnlPropiedades.add(lblLoginImg, gridBagConstraints);

        btnCargarImg1.setText("+");
        btnCargarImg1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCargarImg1ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 6;
        gridBagConstraints.gridy = 10;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 10);
        pnlPropiedades.add(btnCargarImg1, gridBagConstraints);

        btnCargarImg2.setText("+");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 6;
        gridBagConstraints.gridy = 14;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 10);
        pnlPropiedades.add(btnCargarImg2, gridBagConstraints);

        btnCargarImg3.setText("+");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 6;
        gridBagConstraints.gridy = 18;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 10);
        pnlPropiedades.add(btnCargarImg3, gridBagConstraints);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlPropiedades, javax.swing.GroupLayout.DEFAULT_SIZE, 607, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlPropiedades, javax.swing.GroupLayout.DEFAULT_SIZE, 691, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCargarImg1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCargarImg1ActionPerformed
        // TODO add your handling code here:
//        url = FormularioUtil.chooserFichero(this,"Seleccione el fichero CSV");
//        lblURL.setText(url);
    }//GEN-LAST:event_btnCargarImg1ActionPerformed

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
            java.util.logging.Logger.getLogger(PropiedadesBiosis.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PropiedadesBiosis.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PropiedadesBiosis.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PropiedadesBiosis.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                PropiedadesBiosis propiedadesBiosis = new PropiedadesBiosis();
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCargarImg1;
    private javax.swing.JButton btnCargarImg2;
    private javax.swing.JButton btnCargarImg3;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JLabel lblAplicacion;
    private javax.swing.JLabel lblAplicacionImage;
    private javax.swing.JLabel lblInstitucion;
    private javax.swing.JLabel lblLoginImage;
    private javax.swing.JLabel lblLoginImg;
    private javax.swing.JLabel lblLogo;
    private javax.swing.JLabel lblLogoReporte;
    private javax.swing.JLabel lblNombreAplicacion;
    private javax.swing.JLabel lblNombreLogin;
    private javax.swing.JLabel lblNombreSubtitulo;
    private javax.swing.JLabel lblRuc;
    private javax.swing.JPanel pnlPropiedades;
    // End of variables declaration//GEN-END:variables
 
}
