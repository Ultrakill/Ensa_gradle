/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.biosis.biosislite.vistas.mantenimientos;

import com.biosis.biosislite.controladores.Controlador;
import com.biosis.biosislite.controladores.JornadaControlador;
import com.biosis.biosislite.entidades.Jornada;
import com.biosis.biosislite.vistas.modelos.MTJornada;
import com.personal.utiles.FormularioUtil;
import com.biosis.biosislite.entidades.DetalleJornada;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.swing.JSpinner;
import javax.swing.text.DateFormatter;
import org.jdesktop.beansbinding.BindingGroup;
import org.jdesktop.observablecollections.ObservableCollections;
import com.biosis.biosislite.vistas.dialogos.DlgDetalleJornada;
import com.biosis.biosislite.vistas.modelos.MTDetalleJornada;

/**
 *
 * @author fesquivelc
 */
public class CRUDJornada extends javax.swing.JInternalFrame {

    /**
     * Creates new form CRUDJornada
     */
    private int accion;
    private final JornadaControlador jornadaControlador;
    private List<Jornada> jornadaList;

    public CRUDJornada() {
        initComponents();
//        modeloHoraSpinner(spTurnoHE);
//        modeloHoraSpinner(spDesdeHE);
//        modeloHoraSpinner(spToleranciaHE);
//        modeloHoraSpinner(spRefrigerioHS);
//        modeloHoraSpinner(spRefrigerioHE);
//        modeloHoraSpinner(spTardanzaHE);
//        modeloHoraSpinner(spTurnoHS);
//        modeloHoraSpinner(spToleranciaRefrigerioHE);
        jornadaControlador = JornadaControlador.getInstance();
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

        pnlDatosJornada = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txtCodigo = new javax.swing.JTextField();
        txtNombre = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtDescripcion = new javax.swing.JTextArea();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblDetalleJornada = new org.jdesktop.swingx.JXTable();
        jPanel5 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        btnGuardar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        pnlListado = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        btnNuevo = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblJornadas = new org.jdesktop.swingx.JXTable();

        setClosable(true);
        setMaximizable(true);
        setTitle("Mantenimiento jornadas");
        getContentPane().setLayout(new java.awt.GridBagLayout());

        pnlDatosJornada.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos de jornada"));
        pnlDatosJornada.setLayout(new java.awt.GridBagLayout());

        java.awt.GridBagLayout jPanel1Layout = new java.awt.GridBagLayout();
        jPanel1Layout.columnWidths = new int[] {0, 5, 0};
        jPanel1Layout.rowHeights = new int[] {0, 5, 0, 5, 0, 5, 0};
        jPanel1.setLayout(jPanel1Layout);

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
        gridBagConstraints.weightx = 0.1;
        jPanel1.add(txtCodigo, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.1;
        jPanel1.add(txtNombre, gridBagConstraints);

        jLabel15.setText("Descripción:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        jPanel1.add(jLabel15, gridBagConstraints);

        txtDescripcion.setColumns(20);
        txtDescripcion.setRows(5);
        jScrollPane2.setViewportView(txtDescripcion);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weighty = 0.1;
        jPanel1.add(jScrollPane2, gridBagConstraints);

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Turnos"));
        jPanel3.setLayout(new java.awt.GridBagLayout());

        jScrollPane3.setViewportView(tblDetalleJornada);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.weighty = 0.1;
        jPanel3.add(jScrollPane3, gridBagConstraints);

        jPanel5.setLayout(new java.awt.GridLayout(1, 0));

        jButton1.setText("Agregar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel5.add(jButton1);

        jButton2.setText("Editar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel5.add(jButton2);

        jButton3.setText("Quitar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel5.add(jButton3);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        jPanel3.add(jPanel5, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weighty = 0.4;
        jPanel1.add(jPanel3, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.weighty = 0.1;
        pnlDatosJornada.add(jPanel1, gridBagConstraints);

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

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.SOUTH;
        gridBagConstraints.weighty = 0.1;
        pnlDatosJornada.add(jPanel2, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 151;
        gridBagConstraints.ipady = 148;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.weighty = 0.1;
        getContentPane().add(pnlDatosJornada, gridBagConstraints);

        pnlListado.setBorder(javax.swing.BorderFactory.createTitledBorder("Jornadas"));
        java.awt.GridBagLayout pnlListadoLayout = new java.awt.GridBagLayout();
        pnlListadoLayout.columnWidths = new int[] {0};
        pnlListadoLayout.rowHeights = new int[] {0, 5, 0};
        pnlListado.setLayout(pnlListadoLayout);

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

        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });
        jPanel4.add(btnEliminar);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        pnlListado.add(jPanel4, gridBagConstraints);

        tblJornadas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                tblJornadasMouseReleased(evt);
            }
        });
        jScrollPane1.setViewportView(tblJornadas);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.weighty = 0.1;
        pnlListado.add(jScrollPane1, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 310;
        gridBagConstraints.ipady = 395;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 0.2;
        gridBagConstraints.weighty = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(12, 12, 12, 0);
        getContentPane().add(pnlListado, gridBagConstraints);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        // TODO add your handling code here:
        this.accion = Controlador.NUEVO;
        jornadaControlador.prepararCrear();
        this.detalleJornadaList.clear();
        this.jornadaControlador.getSeleccionado().setDetalleJornadaList(detalleJornadaList);
        this.controles(accion);
    }//GEN-LAST:event_btnNuevoActionPerformed

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        // TODO add your handling code here:
        int fila = this.tblJornadas.getSelectedRow();
        if (fila != -1) {
            this.accion = Controlador.MODIFICAR;
            this.jornadaControlador.setSeleccionado(this.jornadaList.get(fila));
            this.mostrar(jornadaControlador.getSeleccionado());
            this.controles(accion);
            FormularioUtil.activarComponente(txtCodigo, false);
        }

    }//GEN-LAST:event_btnModificarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        // TODO add your handling code here:
        this.accion = Controlador.ELIMINAR;
        int fila = tblJornadas.getSelectedRow();
        if (fila != -1 && FormularioUtil.dialogoConfirmar(this, accion)) {
            if (jornadaControlador.accion(accion)) {
                FormularioUtil.mensajeExito(this, accion);
                this.accion = 0;
                this.actualizarTabla();
            } else {
                FormularioUtil.mensajeError(this, accion);
            }

        }

    }//GEN-LAST:event_btnEliminarActionPerformed

    private void tblJornadasMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblJornadasMouseReleased
        // TODO add your handling code here:
        int fila = tblJornadas.getSelectedRow();
        if (fila != -1) {
            mostrar(jornadaList.get(fila));
        }

    }//GEN-LAST:event_tblJornadasMouseReleased

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        // TODO add your handling code here:
        this.accion = 0;
        this.controles(accion);
        FormularioUtil.limpiarComponente(this.pnlDatosJornada);
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        // TODO add your handling code here:
//        if(hayErrores()){
//            return;
//        }
        if (FormularioUtil.dialogoConfirmar(this, accion)) {
//            char tipo = cboTipo.getSelectedItem().toString().charAt(0);
            Jornada seleccionada = jornadaControlador.getSeleccionado();

            FormularioUtil.convertirMayusculas(this.pnlDatosJornada);

            if (accion == Controlador.NUEVO) {
                seleccionada.setCodigo(txtCodigo.getText());
            }           
            seleccionada.setNombre(txtNombre.getText());
            seleccionada.setDescripcion(txtDescripcion.getText());
            
//            seleccionada.setDesdeHE((Date) spDesdeHE.getValue());
//            if (tipo == 'A') {
//                seleccionada.setRefrigerioHS((Date) spRefrigerioHS.getValue());
//                seleccionada.setRefrigerioHE((Date) spRefrigerioHE.getValue());
//                seleccionada.setTerminaDiaSiguiente(false);
//                seleccionada.setRefrigerioEspecial(chkRefrigerioEspecial.isSelected());
//            }else if(tipo == 'T'){
//                seleccionada.setTerminaDiaSiguiente(chkSalida.isSelected());
//            }
//
//            seleccionada.setTardanzaHE((Date) spTardanzaHE.getValue());
//            seleccionada.setToleranciaHE((Date) spToleranciaHE.getValue());
//            seleccionada.setTurnoHE((Date) spTurnoHE.getValue());
//            seleccionada.setTurnoHS((Date) spTurnoHS.getValue());

//            seleccionada.setTipo(tipo);
//            if (chkRefrigerioEspecial.isSelected()) {
//                seleccionada.setMinRefrigerio(Integer.parseInt(spMinutosRefrigerio.getValue().toString()));
//            } else {
//                seleccionada.setToleranciaRefrigerioHE((Date) spToleranciaRefrigerioHE.getValue());
//            }
            if (jornadaControlador.accion(accion)) {
                FormularioUtil.mensajeExito(this, accion);
                this.accion = 0;
                this.controles(accion);
                this.actualizarTabla();
            } else {
                FormularioUtil.mensajeError(this, accion);
            }

        } else {
            return;
        }
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        DlgDetalleJornada dlgDetalle = new DlgDetalleJornada(this, true);
        DetalleJornada detalle = dlgDetalle.getDetalleJornada();
        if (detalle != null) {
            detalle.setJornada(this.jornadaControlador.getSeleccionado());
            this.detalleJornadaList.add(detalle);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        int fila;
        if((fila = this.tblDetalleJornada.getSelectedRow()) != -1){
            DetalleJornada dtJornada = this.detalleJornadaList.get(fila);
            DlgDetalleJornada dlgDetalle = new DlgDetalleJornada(this, true);
            dlgDetalle.setDetalleJornada(dtJornada);
            
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        int fila;
        if((fila = this.tblDetalleJornada.getSelectedRow()) != -1){
            DetalleJornada dtJornada = this.detalleJornadaList.get(fila);            
            this.detalleJornadaList.remove(dtJornada);
        }
    }//GEN-LAST:event_jButton3ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnModificar;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JPanel pnlDatosJornada;
    private javax.swing.JPanel pnlListado;
    private org.jdesktop.swingx.JXTable tblDetalleJornada;
    private org.jdesktop.swingx.JXTable tblJornadas;
    private javax.swing.JTextField txtCodigo;
    private javax.swing.JTextArea txtDescripcion;
    private javax.swing.JTextField txtNombre;
    // End of variables declaration//GEN-END:variables

    private void modeloHoraSpinner(JSpinner spinner) {
        JSpinner.DateEditor editor = new JSpinner.DateEditor(spinner, "HH:mm");
        DateFormatter formatter = (DateFormatter) editor.getTextField().getFormatter();
        formatter.setAllowsInvalid(false); // this makes what you want
        formatter.setOverwriteMode(true);
        spinner.setEditor(editor);
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.HOUR, 7);
        cal.set(Calendar.MINUTE, 30);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.AM_PM, Calendar.AM);
        spinner.setValue(cal.getTime());
    }

    private void modeloFechaSpinner(JSpinner spinner) {
        JSpinner.DateEditor editor = new JSpinner.DateEditor(spinner, "dd/MM/yyyy");
        DateFormatter formatter = (DateFormatter) editor.getTextField().getFormatter();
        formatter.setAllowsInvalid(false); // this makes what you want
        formatter.setOverwriteMode(true);
        spinner.setEditor(editor);
    }

    private void controles(int accion) {
        boolean bandera = accion == Controlador.NUEVO || accion == Controlador.MODIFICAR;

        FormularioUtil.activarComponente(this.pnlListado, !bandera);
        FormularioUtil.activarComponente(this.pnlDatosJornada, bandera);

//        checkbox();
        if (accion != Controlador.MODIFICAR) {
            FormularioUtil.limpiarComponente(this.pnlDatosJornada);
        }

    }
    List<DetalleJornada> detalleJornadaList;

    private void bindeoSalvaje() {
        jornadaList = new ArrayList<>();
        jornadaList = ObservableCollections.observableList(jornadaList);

        detalleJornadaList = ObservableCollections.observableList(new ArrayList<DetalleJornada>());

        BindingGroup bg = new BindingGroup();

        String[] columnas = {"Codigo", "Nombre", "Descripción"};

        MTDetalleJornada mtDetalleJornada = new MTDetalleJornada(detalleJornadaList);
        MTJornada mt = new MTJornada(jornadaList, columnas);
        tblJornadas.setModel(mt);
        tblDetalleJornada.setModel(mtDetalleJornada);
        actualizarTabla();
    }

    private void mostrar(Jornada seleccionado) {
        txtCodigo.setText(seleccionado.getCodigo());
        txtNombre.setText(seleccionado.getNombre());
        txtDescripcion.setText(seleccionado.getDescripcion());
        this.detalleJornadaList.clear();
        this.detalleJornadaList.addAll(seleccionado.getDetalleJornadaList());
        
        
//        spDesdeHE.setValue(seleccionado.getDesdeHE());
//        spRefrigerioHS.setValue(seleccionado.getRefrigerioHS());
//        spRefrigerioHE.setValue(seleccionado.getRefrigerioHE());
//        spTardanzaHE.setValue(seleccionado.getTardanzaHE());
//        spToleranciaHE.setValue(seleccionado.getToleranciaHE());
//        spTurnoHE.setValue(seleccionado.getTurnoHE());
//        spTurnoHS.setValue(seleccionado.getTurnoHS());
//        chkRefrigerioEspecial.setSelected(seleccionado.isRefrigerioEspecial());
//        char tipo = seleccionado.getTipo();
//        
//        cboTipo.setSelectedIndex(tipo == 'A' ? 0 : 1);
//        if (seleccionado.isRefrigerioEspecial()) {
//            spMinutosRefrigerio.setValue(seleccionado.getMinRefrigerio());
//        } else {
//            spToleranciaRefrigerioHE.setValue(seleccionado.getToleranciaRefrigerioHE());
//        }
    }

    private void actualizarTabla() {
        jornadaList.clear();
        jornadaList.addAll(jornadaControlador.buscarTodos());
        tblJornadas.packAll();
    }

//    private void checkbox() {
//        if (accion != 0) {
//            FormularioUtil.activarComponente(spToleranciaRefrigerioHE, !chkRefrigerioEspecial.isSelected());
//            FormularioUtil.activarComponente(spMinutosRefrigerio, chkRefrigerioEspecial.isSelected());
//        }
//
//    }
//    private boolean hayErrores() {
//        Date refrigerioInicio = (Date)spRefrigerioHS.getValue();
//        Date refrigerioFin = (Date)spRefrigerioHE.getValue();
//        Date turnoInicio = (Date)spTurnoHE.getValue();
//        Date turnoFin = (Date)spTurnoHS.getValue();
//        
//        
//    }
//    private void tipo() {
//        if (accion != 0) {
//            char tipo = cboTipo.getSelectedItem().toString().charAt(0);
//            FormularioUtil.activarComponente(spToleranciaRefrigerioHE, tipo == 'A');
//            FormularioUtil.activarComponente(spMinutosRefrigerio, tipo == 'A');
//            FormularioUtil.activarComponente(spRefrigerioHE, tipo == 'A');
//            FormularioUtil.activarComponente(spRefrigerioHS, tipo == 'A');
//            FormularioUtil.activarComponente(chkRefrigerioEspecial, tipo == 'A');
//            FormularioUtil.activarComponente(spMinutosRefrigerio, tipo == 'A');
//            FormularioUtil.activarComponente(chkSalida, tipo != 'A');
//        }
//    }
}
