/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.biosis.biosislite.vistas.mantenimientos;

import com.biosis.biosislite.controladores.Controlador;
import com.biosis.biosislite.controladores.TipoPermisoControlador;
import com.biosis.biosislite.entidades.TipoPermiso;
import com.biosis.biosislite.vistas.modelos.MTTipoPermiso;
import com.personal.utiles.FormularioUtil;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.text.DateFormatter;
import org.jdesktop.observablecollections.ObservableCollections;

/**
 *
 * @author fesquivelc
 */
public class CRUDTipoPermiso extends javax.swing.JInternalFrame {

    /**
     * Creates new form CRUDJornada
     */
    private int accion;
    private final TipoPermisoControlador controlador;
    private List<TipoPermiso> listado;
    private TipoPermiso jornadaSeleccionada;

    public CRUDTipoPermiso() {
        initComponents();
        controlador = new TipoPermisoControlador();
        bindeoSalvaje();
        accion = 0;
        this.controles(accion);
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

        pnlDatos = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txtCodigo = new javax.swing.JTextField();
        txtNombre = new javax.swing.JTextField();
        cboTipo = new javax.swing.JComboBox();
        jLabel2 = new javax.swing.JLabel();
        cboCuenta = new javax.swing.JComboBox();
        jPanel2 = new javax.swing.JPanel();
        btnGuardar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        pnlListado = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        btnNuevo = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblTabla = new org.jdesktop.swingx.JXTable();

        setClosable(true);
        setMaximizable(true);
        setTitle("MANTENIMIENTO TIPOS DE PERMISO");
        getContentPane().setLayout(new java.awt.GridBagLayout());

        pnlDatos.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos de tipo de permiso"));

        java.awt.GridBagLayout jPanel1Layout = new java.awt.GridBagLayout();
        jPanel1Layout.columnWidths = new int[] {0, 5, 0};
        jPanel1Layout.rowHeights = new int[] {0, 5, 0, 5, 0, 5, 0};
        jPanel1.setLayout(jPanel1Layout);

        jLabel1.setText("Tipo:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        jPanel1.add(jLabel1, gridBagConstraints);

        jLabel9.setText("Código:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        jPanel1.add(jLabel9, gridBagConstraints);

        jLabel10.setText("Nombre:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        jPanel1.add(jLabel10, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.weightx = 0.1;
        jPanel1.add(txtCodigo, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.weightx = 0.1;
        jPanel1.add(txtNombre, gridBagConstraints);

        cboTipo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "PERMISO", "LICENCIA", "COMISION DE SERVICIOS", "SUSPENCION" }));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.weightx = 0.1;
        jPanel1.add(cboTipo, gridBagConstraints);

        jLabel2.setText("A cuenta:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        jPanel1.add(jLabel2, gridBagConstraints);

        cboCuenta.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "CON GOCE", "SIN GOCE", "CTA DE VACACIONES" }));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 0.1;
        jPanel1.add(cboCuenta, gridBagConstraints);

        jPanel2.setLayout(new java.awt.GridLayout(1, 0, 10, 0));

        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });
        jPanel2.add(btnGuardar);

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });
        jPanel2.add(btnCancelar);

        javax.swing.GroupLayout pnlDatosLayout = new javax.swing.GroupLayout(pnlDatos);
        pnlDatos.setLayout(pnlDatosLayout);
        pnlDatosLayout.setHorizontalGroup(
            pnlDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDatosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlDatosLayout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        pnlDatosLayout.setVerticalGroup(
            pnlDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDatosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 331, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipady = 127;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        getContentPane().add(pnlDatos, gridBagConstraints);

        pnlListado.setBorder(javax.swing.BorderFactory.createTitledBorder("Tipos de permiso"));
        pnlListado.setToolTipText("");
        pnlListado.setLayout(new java.awt.GridBagLayout());

        jPanel4.setLayout(new java.awt.GridLayout(1, 0, 10, 0));

        btnNuevo.setText("Nuevo");
        btnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoActionPerformed(evt);
            }
        });
        jPanel4.add(btnNuevo);

        btnModificar.setText("Modificar");
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });
        jPanel4.add(btnModificar);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        pnlListado.add(jPanel4, gridBagConstraints);

        tblTabla.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                tblTablaMouseReleased(evt);
            }
        });
        jScrollPane1.setViewportView(tblTabla);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.weighty = 0.1;
        pnlListado.add(jScrollPane1, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 310;
        gridBagConstraints.ipady = 430;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 0.2;
        gridBagConstraints.weighty = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 0);
        getContentPane().add(pnlListado, gridBagConstraints);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        // TODO add your handling code here:
        this.accion = Controlador.NUEVO;
        controlador.prepararCrear();
        this.controles(accion);
    }//GEN-LAST:event_btnNuevoActionPerformed

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        // TODO add your handling code here:
        int fila = this.tblTabla.getSelectedRow();
        if (fila != -1) {
            this.accion = Controlador.MODIFICAR;
            this.controlador.setSeleccionado(this.listado.get(fila));
            this.mostrar(controlador.getSeleccionado());
            this.controles(accion);
            FormularioUtil.activarComponente(txtCodigo, false);
        }

    }//GEN-LAST:event_btnModificarActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        // TODO add your handling code here:
        if(hayErrores()){
            return;
        }
        if (FormularioUtil.dialogoConfirmar(this, accion)) {
            TipoPermiso seleccionada = controlador.getSeleccionado();
            FormularioUtil.convertirMayusculas(this.pnlDatos);
            if (accion == Controlador.NUEVO) {
                seleccionada.setCodigo(txtCodigo.getText());
            }
            seleccionada.setNombre(txtNombre.getText());
            seleccionada.setClase(getClase());
            seleccionada.setTipoDescuento(getDescuento());

            if (controlador.accion(accion)) {
                FormularioUtil.mensajeExito(this, accion);
                this.accion = 0;
                this.controles(accion);
                this.actualizarTabla();
            } else {
                FormularioUtil.mensajeError(this, accion);
            }

        }
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void tblTablaMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblTablaMouseReleased
        // TODO add your handling code here:
        int fila = tblTabla.getSelectedRow();
        if (fila != -1) {
            mostrar(listado.get(fila));
        }

    }//GEN-LAST:event_tblTablaMouseReleased

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        // TODO add your handling code here:
        this.accion = 0;
        this.controles(accion);
        FormularioUtil.limpiarComponente(this.pnlDatos);
    }//GEN-LAST:event_btnCancelarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnModificar;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JComboBox cboCuenta;
    private javax.swing.JComboBox cboTipo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel pnlDatos;
    private javax.swing.JPanel pnlListado;
    private org.jdesktop.swingx.JXTable tblTabla;
    private javax.swing.JTextField txtCodigo;
    private javax.swing.JTextField txtNombre;
    // End of variables declaration//GEN-END:variables

    private void controles(int accion) {
        boolean bandera = accion == Controlador.NUEVO || accion == Controlador.MODIFICAR;

        FormularioUtil.activarComponente(this.pnlListado, !bandera);
        FormularioUtil.activarComponente(this.pnlDatos, bandera);

        if (accion != Controlador.MODIFICAR) {
            FormularioUtil.limpiarComponente(this.pnlDatos);
        }

    }

    private void bindeoSalvaje() {
        listado = new ArrayList<>();
        listado = ObservableCollections.observableList(listado);

        String[] columnas = {"Codigo", "Nombre", "Tipo", "Descuento"};

        MTTipoPermiso mt = new MTTipoPermiso(listado, columnas);
        tblTabla.setModel(mt);
        actualizarTabla();
    }

    private void mostrar(TipoPermiso seleccionado) {
        txtCodigo.setText(seleccionado.getCodigo());
        txtNombre.setText(seleccionado.getNombre());
        cboTipo.setSelectedItem(clase(seleccionado.getClase()));
        cboCuenta.setSelectedItem(tipoDescuento(seleccionado.getTipoDescuento()));
    }

    private void actualizarTabla() {
        listado.clear();
        listado.addAll(controlador.buscarTodos());
        tblTabla.packAll();
    }

    private char getClase() {
        String valor = cboTipo.getSelectedItem().toString();

        return valor.charAt(0);
    }

    private char getDescuento() {
        String valor = cboCuenta.getSelectedItem().toString();
        return valor.charAt(0);
    }

    private String clase(char clase) {
        switch (clase) {
            case 'C':
                return "COMISION DE SERVICIOS";
            case 'P':
                return "PERMISO";
            case 'L':
                return "LICENCIA";
            case 'S':
                return "SUSPENCION";
            default:
                return "";
        }
    }

    private String tipoDescuento(char tipo) {
        switch (tipo) {
            case 'C':
                return "CON GOCE";
            case 'S':
                return "SIN GOCE";
            case 'V':
                return "CTA DE VACACIONES";
            default:
                return "";
        }
    }

    private boolean hayErrores() {
        String mensajeError = "Se encontraron los siguientes errores:\n";
        int errores = 0;
        
        
        
        if(this.txtCodigo.getText().trim().isEmpty()){
            errores++;
            mensajeError += "- El campo código no debe estar en blanco\n";
        }
        
        if(this.txtNombre.getText().trim().isEmpty()){
            errores++;
            mensajeError += "- El campo nombre no debe estar en blanco\n";
        }
        
        if(errores > 0){
            JOptionPane.showMessageDialog(this, mensajeError, "Mensaje del sistema", JOptionPane.WARNING_MESSAGE);
        }
        
        return errores > 0;
    }
}
