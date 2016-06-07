/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.biosis.biosislite.vistas.mantenimientos;

import com.personal.utiles.FormularioUtil;
import com.biosis.biosislite.controladores.Controlador;
import com.biosis.biosislite.controladores.DepartamentoControlador;
import com.biosis.biosislite.entidades.escalafon.Departamento;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeCellRenderer;
import javax.swing.tree.TreeModel;
import javax.swing.tree.TreeNode;
import com.biosis.biosislite.vistas.dialogos.DlgOficina;
import com.biosis.biosislite.vistas.renders.RenderArea;

/**
 *
 * @author RyuujiMD
 */
public class CRUDAreaSede extends javax.swing.JInternalFrame {

    /**
     * Creates new form CRUDAreaSede
     */
    public CRUDAreaSede() {
        initComponents();
        inicializar();
        activarControles(0);
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

        jPanel1 = new javax.swing.JPanel();
        pnlBotones = new javax.swing.JPanel();
        btnNuevo = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        trAreas = new javax.swing.JTree();
        pnlInformación = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtNivelSuperior = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtDescripcion = new javax.swing.JTextArea();
        txtNombre = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        txtCodigo = new javax.swing.JTextField();
        chkSede = new javax.swing.JCheckBox();
        btnLimpiarSuperior = new javax.swing.JButton();

        setClosable(true);
        setTitle("REGSTRO DE SEDES Y ÁREAS DE LA INSTITUCIÓN");

        java.awt.GridBagLayout jPanel1Layout = new java.awt.GridBagLayout();
        jPanel1Layout.columnWidths = new int[] {0, 5, 0};
        jPanel1Layout.rowHeights = new int[] {0, 5, 0};
        jPanel1.setLayout(jPanel1Layout);

        pnlBotones.setLayout(new java.awt.GridLayout(0, 1, 0, 5));

        btnNuevo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnNuevo.setText("Nuevo");
        btnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoActionPerformed(evt);
            }
        });
        pnlBotones.add(btnNuevo);

        btnModificar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnModificar.setText("Modificar");
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });
        pnlBotones.add(btnModificar);

        btnGuardar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });
        pnlBotones.add(btnGuardar);

        btnCancelar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });
        pnlBotones.add(btnCancelar);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 2;
        jPanel1.add(pnlBotones, gridBagConstraints);

        trAreas.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        trAreas.setRowHeight(30);
        trAreas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                trAreasMouseReleased(evt);
            }
        });
        jScrollPane1.setViewportView(trAreas);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.weighty = 0.2;
        jPanel1.add(jScrollPane1, gridBagConstraints);

        pnlInformación.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Información", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 14))); // NOI18N
        java.awt.GridBagLayout pnlInformaciónLayout = new java.awt.GridBagLayout();
        pnlInformaciónLayout.columnWidths = new int[] {0, 5, 0, 5, 0, 5, 0};
        pnlInformaciónLayout.rowHeights = new int[] {0, 5, 0, 5, 0, 5, 0, 5, 0};
        pnlInformación.setLayout(pnlInformaciónLayout);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("Nombre:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        pnlInformación.add(jLabel1, gridBagConstraints);

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Descripción:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        pnlInformación.add(jLabel2, gridBagConstraints);

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("Nivel superior:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        pnlInformación.add(jLabel4, gridBagConstraints);

        txtNivelSuperior.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        pnlInformación.add(txtNivelSuperior, gridBagConstraints);

        txtDescripcion.setColumns(20);
        txtDescripcion.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtDescripcion.setRows(5);
        jScrollPane2.setViewportView(txtDescripcion);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.weighty = 0.1;
        pnlInformación.add(jScrollPane2, gridBagConstraints);

        txtNombre.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        pnlInformación.add(txtNombre, gridBagConstraints);

        jButton1.setText("...");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 2;
        pnlInformación.add(jButton1, gridBagConstraints);

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("Código:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 8;
        pnlInformación.add(jLabel5, gridBagConstraints);

        txtCodigo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        pnlInformación.add(txtCodigo, gridBagConstraints);

        chkSede.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        chkSede.setText("Sede");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        pnlInformación.add(chkSede, gridBagConstraints);

        btnLimpiarSuperior.setText("X");
        btnLimpiarSuperior.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarSuperiorActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 6;
        gridBagConstraints.gridy = 2;
        pnlInformación.add(btnLimpiarSuperior, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.weighty = 0.1;
        jPanel1.add(pnlInformación, gridBagConstraints);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 753, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 470, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void trAreasMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_trAreasMouseReleased
        // TODO add your handling code here:
        DefaultMutableTreeNode nodo = (DefaultMutableTreeNode) trAreas.getLastSelectedPathComponent();
        if (nodo != null) {
            Object elemento = nodo.getUserObject();
            if (elemento instanceof Departamento) {
                mostrar((Departamento) elemento);
            }
        }

    }//GEN-LAST:event_trAreasMouseReleased

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        // TODO add your handling code here:
        FormularioUtil.limpiarComponente(pnlInformación);
        activarControles(Controlador.NUEVO);
        depc.prepararCrear();
    }//GEN-LAST:event_btnNuevoActionPerformed

    private void btnLimpiarSuperiorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarSuperiorActionPerformed
        // TODO add your handling code here:
        this.departamentoSeleccionado = null;
        this.txtNivelSuperior.setText("");
    }//GEN-LAST:event_btnLimpiarSuperiorActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        DlgOficina oficinas = new DlgOficina(this);
        this.departamentoSeleccionado = oficinas.getSeleccionado();
        this.mostrarSuperior(this.departamentoSeleccionado);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        DefaultMutableTreeNode nodo = (DefaultMutableTreeNode) trAreas.getLastSelectedPathComponent();
        Object elemento = nodo.getUserObject();
        if (elemento instanceof Departamento) {
            depc.setSeleccionado((Departamento) elemento);
            mostrar((Departamento) elemento);
        }
        activarControles(Controlador.MODIFICAR);
    }//GEN-LAST:event_btnModificarActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        // TODO add your handling code here:
        if(hayErrores()){
            return;
        }
        if (FormularioUtil.dialogoConfirmar(this, accion)) {
            Departamento dep = depc.getSeleccionado();
            dep.setNombre(txtNombre.getText());
            dep.setDescripcion(txtDescripcion.getText());
            dep.setDepartamento(this.departamentoSeleccionado);
            dep.setCodigo(txtCodigo.getText());
            dep.setSede(chkSede.isSelected());

            if (depc.accion(accion)) {
                FormularioUtil.mensajeExito(this, accion);
                FormularioUtil.limpiarComponente(this.pnlInformación);
                activarControles(0);
                this.inicializar();
            } else {
                FormularioUtil.mensajeError(this, accion);
            }
        }
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        // TODO add your handling code here:
        FormularioUtil.limpiarComponente(this.pnlInformación);
        activarControles(0);
    }//GEN-LAST:event_btnCancelarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnLimpiarSuperior;
    private javax.swing.JButton btnModificar;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JCheckBox chkSede;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JPanel pnlBotones;
    private javax.swing.JPanel pnlInformación;
    private javax.swing.JTree trAreas;
    private javax.swing.JTextField txtCodigo;
    private javax.swing.JTextArea txtDescripcion;
    private javax.swing.JTextField txtNivelSuperior;
    private javax.swing.JTextField txtNombre;
    // End of variables declaration//GEN-END:variables

    private int accion = 0;
    private Departamento departamentoSeleccionado;
    //CONTROLADORES
    private final DepartamentoControlador depc = DepartamentoControlador.getInstance();
    private TreeModel modeloDepartamento;
    private TreeCellRenderer renderDepartamento;

    private void inicializar() {
        TreeNode nodoPrincipal = new DefaultMutableTreeNode("SEDES Y ÁREAS");
        modeloDepartamento = new DefaultTreeModel(nodoPrincipal);
        renderDepartamento = new RenderArea();
        trAreas.setModel(modeloDepartamento);

        trAreas.setCellRenderer(renderDepartamento);
        List<Departamento> departamentos = depc.buscarXJerarquia();
        System.out.println("DEPARTAMENTOS JERARQUIA: " + departamentos.size());
        llenarArbol((DefaultTreeModel) modeloDepartamento, departamentos, (DefaultMutableTreeNode) nodoPrincipal);
        for (int i = 0; i < trAreas.getRowCount(); i++) {
            trAreas.expandRow(i);
        }
//        actualizarArbol();
    }

    private void llenarArbol(DefaultTreeModel modelo, List listado, DefaultMutableTreeNode padre) {
        for (Object elemento : listado) {
            DefaultMutableTreeNode nodo = new DefaultMutableTreeNode(elemento);
            modelo.insertNodeInto(nodo, padre, padre.getChildCount());
            if (elemento instanceof Departamento) {
                List<Departamento> deps = ((Departamento) elemento).getDepartamentoList();
                if (!deps.isEmpty()) {
                    llenarArbol(modelo, deps, nodo);
                }
            }
        }
    }

    private void llenarArbol(DefaultTreeModel modelo, Object objeto, DefaultMutableTreeNode padre) {
//        for (Object elemento : listado) {
        DefaultMutableTreeNode nodo = new DefaultMutableTreeNode(objeto);
        modelo.insertNodeInto(nodo, padre, padre.getChildCount());
//            if (elemento instanceof Departamento) {
//                List<Departamento> deps = ((Departamento)elemento).getDepartamentoList();
//                if (!deps.isEmpty()) {
//                    llenarArbol(modelo, deps, nodo);
//                }
//            }
//        }
    }

    private void mostrar(Departamento departamento) {
        this.txtNombre.setText(departamento.getNombre());
        this.chkSede.setSelected(departamento.isSede());
        this.txtDescripcion.setText(departamento.getDescripcion());
        this.txtCodigo.setText(departamento.getCodigo());
        mostrarSuperior(departamento.getDepartamento());
    }

    private void mostrarSuperior(Departamento departamento) {
        if (departamento != null) {
            this.txtNivelSuperior.setText(departamento.getNombre());
        }
    }

    private void activarControles(int accion) {
        boolean nom = accion == Controlador.NUEVO || accion == Controlador.MODIFICAR;
        FormularioUtil.activarComponente(pnlInformación, nom);
        FormularioUtil.activarComponente(txtNivelSuperior, false);
        FormularioUtil.activarComponente(trAreas, !nom);
        FormularioUtil.activarComponente(btnGuardar, nom);
        FormularioUtil.activarComponente(btnCancelar, nom);
        FormularioUtil.activarComponente(btnNuevo, !nom);
        FormularioUtil.activarComponente(btnModificar, !nom);
        trAreas.setEnabled(!nom);
        this.accion = accion;
    }

    private boolean hayErrores() {
        String mensajeError = "Se encontraron los siguientes errores:\n";
        int errores = 0;

        if (this.txtNombre.getText().trim().isEmpty()){
            errores++;
            mensajeError+="Debe especificar un nombre al área\n";
        }
        
        if(errores > 0){
            JOptionPane.showMessageDialog(this, mensajeError, "Mensaje del sistema", JOptionPane.WARNING_MESSAGE);
        }
        
        return errores > 0;
    }
}
