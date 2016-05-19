/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.biosis.biosislite.vistas;

import com.biosis.biosislite.controladores.ConceptoControlador;
import com.biosis.biosislite.controladores.Controlador;
import com.biosis.biosislite.controladores.EmpleadoControlador;
import com.biosis.biosislite.controladores.GradoControlador;
import com.biosis.biosislite.controladores.MarcacionControlador;
import com.biosis.biosislite.controladores.NivelControlador;
import com.biosis.biosislite.controladores.SeccionControlador;
import com.biosis.biosislite.entidades.Concepto;
import com.biosis.biosislite.entidades.educativo.AsignacionNGS;
import com.biosis.biosislite.entidades.educativo.Grado;
import com.biosis.biosislite.entidades.educativo.Nivel;
import com.biosis.biosislite.entidades.educativo.Seccion;
import com.biosis.biosislite.entidades.escalafon.Empleado;
import com.biosis.biosislite.utiles.UsuarioActivo;
import com.biosis.biosislite.vistas.dialogos.DlgAsignacionSeccion;
import com.biosis.biosislite.vistas.dialogos.DlgDatosEmpleado;
import com.biosis.biosislite.vistas.dialogos.DlgEmpleadoCRUD;
import com.biosis.biosislite.vistas.modelos.MTAsignacionNGS;
import com.biosis.biosislite.vistas.modelos.MTEmpleado;
import com.biosis.biosislite.vistas.render.RenderNivelGradoSeccion;
import com.personal.utiles.ReporteUtil;
import java.awt.Component;
import java.awt.Point;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.SpinnerNumberModel;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeCellRenderer;
import javax.swing.tree.TreeModel;
import javax.swing.tree.TreeNode;
import org.jdesktop.beansbinding.AutoBinding;
import org.jdesktop.beansbinding.BeanProperty;
import org.jdesktop.observablecollections.ObservableCollections;
import org.jdesktop.swingbinding.JTableBinding;
import org.jdesktop.swingbinding.SwingBindings;

/**
 *
 * @author Aldo
 */
public class GestionAsignacionSeccion extends javax.swing.JInternalFrame {

    /**
     * Creates new form GestionAsignacionSeccion
     */
    private List<Empleado> lista;
    private List<AsignacionNGS> listaAsignaciones;
    
    //Controladores
    private EmpleadoControlador ec;
    private NivelControlador nc;
    private GradoControlador gc;
    private SeccionControlador sc;
    private final ConceptoControlador cptc = ConceptoControlador.getInstance();
    
    public GestionAsignacionSeccion() {
        initComponents();
        inicializar();
        bind();
        bindArbol();
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

        popOpciones = new javax.swing.JPopupMenu();
        mnuAsignarSeccion = new javax.swing.JMenuItem();
        mnuVerDatos = new javax.swing.JMenuItem();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        pnlAsignacion = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        cboTipoEmpleado = new javax.swing.JComboBox();
        jLabel2 = new javax.swing.JLabel();
        txtBusqueda = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblEmpleado = new org.jdesktop.swingx.JXTable();
        pnlNavegacion = new javax.swing.JPanel();
        btnPrimero = new javax.swing.JButton();
        btnAnterior = new javax.swing.JButton();
        spPagina = new javax.swing.JSpinner();
        txtTotal = new javax.swing.JTextField();
        btnSiguiente = new javax.swing.JButton();
        btnUltimo = new javax.swing.JButton();
        cboTamanio = new javax.swing.JComboBox();
        pnlBotonesAsignacion = new javax.swing.JPanel();
        btnAsignar = new javax.swing.JButton();
        btnMostrarDatos = new javax.swing.JButton();
        pnlRevision = new javax.swing.JPanel();
        pnlSecciones = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        treeNGS = new javax.swing.JTree();
        pnlListaAsignaciones = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblAsignaciones = new org.jdesktop.swingx.JXTable();

        mnuAsignarSeccion.setText("Asignar sección");
        mnuAsignarSeccion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuAsignarSeccionActionPerformed(evt);
            }
        });
        popOpciones.add(mnuAsignarSeccion);

        mnuVerDatos.setText("Ver datos de persona");
        popOpciones.add(mnuVerDatos);

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("GESTION DE ASIGNACION DE SECCIONES");

        java.awt.GridBagLayout pnlAsignacionLayout = new java.awt.GridBagLayout();
        pnlAsignacionLayout.columnWidths = new int[] {0, 8, 0, 8, 0, 8, 0, 8, 0, 8, 0};
        pnlAsignacionLayout.rowHeights = new int[] {0, 8, 0, 8, 0, 8, 0};
        pnlAsignacion.setLayout(pnlAsignacionLayout);

        jLabel1.setText("Tipo:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        pnlAsignacion.add(jLabel1, gridBagConstraints);

        cboTipoEmpleado.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cboTipoEmpleado.setEnabled(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        pnlAsignacion.add(cboTipoEmpleado, gridBagConstraints);

        jLabel2.setText("Empleado:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 6;
        gridBagConstraints.gridy = 0;
        pnlAsignacion.add(jLabel2, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 8;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 0.1;
        pnlAsignacion.add(txtBusqueda, gridBagConstraints);

        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 10;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        pnlAsignacion.add(btnBuscar, gridBagConstraints);

        tblEmpleado.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblEmpleado.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tblEmpleadoMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(tblEmpleado);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 11;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.weighty = 0.1;
        pnlAsignacion.add(jScrollPane1, gridBagConstraints);

        pnlNavegacion.setLayout(new java.awt.GridBagLayout());

        btnPrimero.setText("<<");
        btnPrimero.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPrimeroActionPerformed(evt);
            }
        });
        pnlNavegacion.add(btnPrimero, new java.awt.GridBagConstraints());

        btnAnterior.setText("<");
        btnAnterior.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAnteriorActionPerformed(evt);
            }
        });
        pnlNavegacion.add(btnAnterior, new java.awt.GridBagConstraints());

        spPagina.setModel(new javax.swing.SpinnerNumberModel(Integer.valueOf(1), Integer.valueOf(1), null, Integer.valueOf(1)));
        spPagina.setMinimumSize(new java.awt.Dimension(60, 20));
        spPagina.setPreferredSize(new java.awt.Dimension(60, 20));
        spPagina.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                spPaginaStateChanged(evt);
            }
        });
        pnlNavegacion.add(spPagina, new java.awt.GridBagConstraints());

        txtTotal.setEditable(false);
        txtTotal.setColumns(3);
        txtTotal.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtTotal.setText("1");
        pnlNavegacion.add(txtTotal, new java.awt.GridBagConstraints());

        btnSiguiente.setText(">");
        btnSiguiente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSiguienteActionPerformed(evt);
            }
        });
        pnlNavegacion.add(btnSiguiente, new java.awt.GridBagConstraints());

        btnUltimo.setText(">>");
        btnUltimo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUltimoActionPerformed(evt);
            }
        });
        pnlNavegacion.add(btnUltimo, new java.awt.GridBagConstraints());

        cboTamanio.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "5", "10", "15", "20", "25", "40", "50" }));
        cboTamanio.setMinimumSize(new java.awt.Dimension(53, 24));
        cboTamanio.setPreferredSize(new java.awt.Dimension(53, 24));
        cboTamanio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboTamanioActionPerformed(evt);
            }
        });
        pnlNavegacion.add(cboTamanio, new java.awt.GridBagConstraints());

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridwidth = 11;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 0.1;
        pnlAsignacion.add(pnlNavegacion, gridBagConstraints);

        pnlBotonesAsignacion.setLayout(new java.awt.GridLayout(1, 0, 5, 0));

        btnAsignar.setText("Asignar Seccion");
        pnlBotonesAsignacion.add(btnAsignar);

        btnMostrarDatos.setText("Mostrar datos");
        pnlBotonesAsignacion.add(btnMostrarDatos);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.gridwidth = 11;
        pnlAsignacion.add(pnlBotonesAsignacion, gridBagConstraints);

        jTabbedPane1.addTab("Asignar secciones", pnlAsignacion);

        pnlRevision.setLayout(new java.awt.GridBagLayout());

        pnlSecciones.setBorder(javax.swing.BorderFactory.createTitledBorder("Niveles, Grados y Secciones"));
        pnlSecciones.setLayout(new java.awt.GridBagLayout());

        treeNGS.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                treeNGSMouseReleased(evt);
            }
        });
        jScrollPane2.setViewportView(treeNGS);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.weighty = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        pnlSecciones.add(jScrollPane2, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.2;
        gridBagConstraints.weighty = 0.1;
        pnlRevision.add(pnlSecciones, gridBagConstraints);

        pnlListaAsignaciones.setBorder(javax.swing.BorderFactory.createTitledBorder("Asignaciones"));
        pnlListaAsignaciones.setLayout(new java.awt.GridBagLayout());

        tblAsignaciones.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane3.setViewportView(tblAsignaciones);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.weighty = 0.1;
        pnlListaAsignaciones.add(jScrollPane3, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.2;
        gridBagConstraints.weighty = 0.1;
        pnlRevision.add(pnlListaAsignaciones, gridBagConstraints);

        jTabbedPane1.addTab("Revisar asignaciones", pnlRevision);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 779, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 405, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnPrimeroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrimeroActionPerformed
        // TODO add your handling code here:
        primero();
    }//GEN-LAST:event_btnPrimeroActionPerformed

    private void btnAnteriorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAnteriorActionPerformed
        // TODO add your handling code here:
        anterior();
    }//GEN-LAST:event_btnAnteriorActionPerformed

    private void spPaginaStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_spPaginaStateChanged
        // TODO add your handling code here:
        this.seleccionPagina();
    }//GEN-LAST:event_spPaginaStateChanged

    private void btnSiguienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSiguienteActionPerformed
        // TODO add your handling code here:
        siguiente();
    }//GEN-LAST:event_btnSiguienteActionPerformed

    private void btnUltimoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUltimoActionPerformed
        // TODO add your handling code here:
        ultimo();
    }//GEN-LAST:event_btnUltimoActionPerformed

    private void cboTamanioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboTamanioActionPerformed
        // TODO add your handling code here:
        this.paginaActual = 1;
        buscar();
        this.actualizarControlesNavegacion();
    }//GEN-LAST:event_cboTamanioActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        // TODO add your handling code here:
        paginaActual = 1;
        buscar();
        actualizarControlesNavegacion();
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void tblEmpleadoMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblEmpleadoMousePressed
        // TODO add your handling code here:
        Point point = evt.getPoint();
        int currentRow = tblEmpleado.rowAtPoint(point);
        tblEmpleado.setRowSelectionInterval(currentRow, currentRow);
    }//GEN-LAST:event_tblEmpleadoMousePressed

    private void mnuAsignarSeccionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuAsignarSeccionActionPerformed
        // TODO add your handling code here:
        int fila = tblEmpleado.getSelectedRow();
        if (fila != -1) {
            DlgAsignacionSeccion asignacionSeccion = new DlgAsignacionSeccion(this, lista.get(fila),Controlador.NUEVO);
            asignacionSeccion.setVisible(true);

            paginaActual = 1;
            buscar();
            actualizarControlesNavegacion();
        }
    }//GEN-LAST:event_mnuAsignarSeccionActionPerformed

    private void treeNGSMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_treeNGSMouseReleased
        // TODO add your handling code here:
        DefaultMutableTreeNode nodo = (DefaultMutableTreeNode) treeNGS.getLastSelectedPathComponent();
        if (nodo != null) {
            Object elemento = nodo.getUserObject();
            if (elemento instanceof Seccion) {
                mostrar((Seccion) elemento);
            }
        }
    }//GEN-LAST:event_treeNGSMouseReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAnterior;
    private javax.swing.JButton btnAsignar;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnMostrarDatos;
    private javax.swing.JButton btnPrimero;
    private javax.swing.JButton btnSiguiente;
    private javax.swing.JButton btnUltimo;
    private javax.swing.JComboBox cboTamanio;
    private javax.swing.JComboBox cboTipoEmpleado;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JMenuItem mnuAsignarSeccion;
    private javax.swing.JMenuItem mnuVerDatos;
    private javax.swing.JPanel pnlAsignacion;
    private javax.swing.JPanel pnlBotonesAsignacion;
    private javax.swing.JPanel pnlListaAsignaciones;
    private javax.swing.JPanel pnlNavegacion;
    private javax.swing.JPanel pnlRevision;
    private javax.swing.JPanel pnlSecciones;
    private javax.swing.JPopupMenu popOpciones;
    private javax.swing.JSpinner spPagina;
    private org.jdesktop.swingx.JXTable tblAsignaciones;
    private org.jdesktop.swingx.JXTable tblEmpleado;
    private javax.swing.JTree treeNGS;
    private javax.swing.JTextField txtBusqueda;
    private javax.swing.JTextField txtTotal;
    // End of variables declaration//GEN-END:variables
    
    private void inicializar(){
        ec = new EmpleadoControlador();
        nc = new NivelControlador();
        gc = new GradoControlador();
        sc = new SeccionControlador();
    }
    private void bind(){
        cboTipoEmpleado.setModel(new DefaultComboBoxModel(cptc.buscarXPrefijo(4).toArray()));
        cboTipoEmpleado.setRenderer(new DefaultListCellRenderer(){
            @Override
            public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
                if (value instanceof Concepto) {
                    value = ((Concepto) value).getDescripcion();
                }
                return super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus); //To change body of generated methods, choose Tools | Templates.
            }
        });
        Concepto administrativo = cptc.buscarXPrefijoXCorrelativo(4, 2);
        cboTipoEmpleado.setSelectedItem(administrativo);
        
        lista = ObservableCollections.observableList(new ArrayList<Empleado>());
        String [] columnasIntegrantes = {"Nro Documento","Tipo de documento","Nombre","Apellido Paterno","Apellido Materno"};
        MTEmpleado mtIntegrantes = new MTEmpleado(lista,columnasIntegrantes);
        tblEmpleado.setModel(mtIntegrantes);
        tblEmpleado.setComponentPopupMenu(popOpciones);
        
        listaAsignaciones = ObservableCollections.observableList(new ArrayList<AsignacionNGS>());
        //String [] columnasIntegrantesAsignaciones = {"Responsable","Rol","Fecha Inicio","Fecha Fin"};
        MTAsignacionNGS mtAsignaciones = new MTAsignacionNGS(listaAsignaciones);
        tblAsignaciones.setModel(mtAsignaciones);
        
    }
    
    private TreeModel modeloNGS;
    private TreeCellRenderer renderNGS;
    private void bindArbol(){
        TreeNode nodoPrincipal = new DefaultMutableTreeNode("Nivel - Grados - Secciones");
        modeloNGS = new DefaultTreeModel(nodoPrincipal);
        renderNGS = new RenderNivelGradoSeccion();
        treeNGS.setModel(modeloNGS);
        treeNGS.setCellRenderer(renderNGS);
        
        List<Nivel> nivelList = nc.buscarTodos();
//        List<Concepto> ngs = cptc.buscarXPrefijo(1);
//        cptc.buscarXPrefijo(2).stream().forEach((c) -> {
//           ngs.add(c);
//        });
//
//        ngs.stream().forEach((c) -> {
//            System.out.println("Concepto: "+c.getDescripcion()+" "+c.getId().getPrefijo()+" "+c.getId().getCorrelativo());
//        });
        llenarArbol((DefaultTreeModel)modeloNGS,nivelList,(DefaultMutableTreeNode) nodoPrincipal);
        for (int i = 0; i < treeNGS.getRowCount(); i++) {
            treeNGS.expandRow(i);
        }
    }
    
    private void llenarArbol(DefaultTreeModel modelo, List listado, DefaultMutableTreeNode padre){
        for(Object elemento:listado){
            DefaultMutableTreeNode nodo = new DefaultMutableTreeNode(elemento);
            modelo.insertNodeInto(nodo, padre, padre.getChildCount());
            if(elemento instanceof Nivel){
                List<Grado> grados = ((Nivel) elemento).getGradoList();
                if(!grados.isEmpty()){
                    llenarArbol(modelo, grados, nodo);
                } 
            }else if(elemento instanceof Grado){
                List<Seccion> secciones = ((Grado) elemento).getSeccionList();
                if(!secciones.isEmpty()){
                    llenarArbol(modelo, secciones, nodo);
                } 
            } 
//            if(elemento instanceof Concepto){
//                
//                if(((Concepto)elemento).getId().getPrefijo()==1){
//                    List<Concepto> ngs = cptc.buscarXPrefijo(2);
//                    if(!ngs.isEmpty()){
//                        llenarArbol(modelo, ngs, nodo);
//                    }               
////                    if(ngs.isEmpty()){
////                        List<Concepto> ngs = ((Concepto) elemento).();
////                        llenarArbol(modelo,ngs,nodo);
////                    }
//                }else if(((Concepto)elemento).getId().getPrefijo()==2){
//                    List<Concepto> ngs = cptc.buscarXPrefijo(3);
//                    if(!ngs.isEmpty()){
//                        llenarArbol(modelo, ngs, nodo);
//                    }               
////                    if(ngs.isEmpty()){
////                        List<EmpleadoBiostar> empleadosBio = ((Departamento) elemento).getEmpleadoList();
////                        llenarArbol(modelo,empleadosBio,nodo);
////                    }
//                }
//            }
        }
    }
    private int paginaActual = 1;
    private int totalPaginas = 0;
    private int tamanioPagina = 0;

    private void buscar() {
        Concepto tipoBuscado = (Concepto)cboTipoEmpleado.getSelectedItem();
        String busqueda = txtBusqueda.getText();
        tamanioPagina = Integer.parseInt(cboTamanio.getSelectedItem().toString());

        lista.clear();

        if(tipoBuscado.getId().getCorrelativo()==0){
            System.out.println("Patron 1: "+busqueda);
            System.out.println("Tipo persona 1: "+tipoBuscado.getDescripcion());
            lista.addAll(this.listar(busqueda, paginaActual, tamanioPagina));
        }
        
        if(busqueda.isEmpty() && (tipoBuscado.getId().getCorrelativo() != 0)){
            System.out.println("Patron 2: "+busqueda);
            System.out.println("Tipo persona 2: "+tipoBuscado.getDescripcion());
            lista.addAll(this.listar(tipoBuscado.getId().getCorrelativo(), paginaActual, tamanioPagina));
        }
        
        if(!busqueda.isEmpty() && (tipoBuscado.getId().getCorrelativo() != 0)){
            System.out.println("Patron 3: "+busqueda);
            System.out.println("Tipo persona 3: "+tipoBuscado.getDescripcion());
            lista.addAll(this.listar(busqueda,tipoBuscado.getId().getCorrelativo(), paginaActual, tamanioPagina));
        }
       

        tblEmpleado.packAll();
    }

    private List<Empleado> listar(String busqueda, int pagina, int tamanio) {
        int total = ec.totalXPatron(busqueda);

        if (total % tamanio == 0) {
            totalPaginas = total / tamanio;
        } else {
            totalPaginas = (total / tamanio) + 1;
        }

        if (totalPaginas == 0) {
            totalPaginas = 1;
        }

        return ec.buscarXPatron(busqueda, (pagina - 1) * tamanio, tamanio);

    }
    
    private List<Empleado> listar(String busqueda, int tipo, int pagina, int tamanio) {
        int total = ec.totalXPatronXTipo(busqueda,tipo);

        if (total % tamanio == 0) {
            totalPaginas = total / tamanio;
        } else {
            totalPaginas = (total / tamanio) + 1;
        }

        if (totalPaginas == 0) {
            totalPaginas = 1;
        }

        return ec.buscarXPatronXTipo(busqueda, tipo, (pagina - 1) * tamanio, tamanio);

    }
    
    private List<Empleado> listar(int tipo, int pagina, int tamanio) {
        int total = ec.totalXTipo(tipo);

        if (total % tamanio == 0) {
            totalPaginas = total / tamanio;
        } else {
            totalPaginas = (total / tamanio) + 1;
        }

        if (totalPaginas == 0) {
            totalPaginas = 1;
        }

        return ec.buscarXTipo(tipo, (pagina - 1) * tamanio, tamanio);

    }
    
    private void siguiente() {
        paginaActual++;
        buscar();
        this.actualizarControlesNavegacion();
    }

    private void ultimo() {
        paginaActual = totalPaginas;
        buscar();
        this.actualizarControlesNavegacion();
    }

    private void primero() {
        paginaActual = 1;
        buscar();
        this.actualizarControlesNavegacion();
    }

    private void anterior() {
        paginaActual--;
        buscar();
        this.actualizarControlesNavegacion();
    }
    
    private void seleccionPagina() {
        paginaActual = (int) spPagina.getValue();
        buscar();
        this.actualizarControlesNavegacion();
    }
    
    private void actualizarControlesNavegacion() {
        spPagina.setValue(paginaActual);
        txtTotal.setText(totalPaginas + "");

        SpinnerNumberModel modeloSP = (SpinnerNumberModel) spPagina.getModel();
        Comparable<Integer> maximo = totalPaginas;
        modeloSP.setMaximum(maximo);

        this.btnSiguiente.setEnabled(paginaActual != totalPaginas);
        this.btnUltimo.setEnabled(paginaActual != totalPaginas);

        this.btnAnterior.setEnabled(paginaActual != 1);
        this.btnPrimero.setEnabled(paginaActual != 1);
    }
    
    private void mostrar(Seccion seccion){
        List<AsignacionNGS> asignacionLista = seccion.getAsignacionNGSList();
        listaAsignaciones.clear();
        listaAsignaciones.addAll(asignacionLista);
        tblAsignaciones.packAll();
    }
}
