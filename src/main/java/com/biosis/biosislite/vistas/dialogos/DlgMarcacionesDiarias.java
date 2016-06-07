/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.biosis.biosislite.vistas.dialogos;

import com.biosis.biosislite.controladores.MarcacionControlador;
import com.biosis.biosislite.entidades.Marcacion;
import com.biosis.biosislite.entidades.escalafon.Empleado;
import java.awt.Component;
import java.awt.Frame;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import org.jdesktop.beansbinding.AutoBinding;
import org.jdesktop.beansbinding.BeanProperty;
import org.jdesktop.beansbinding.BindingGroup;
import org.jdesktop.observablecollections.ObservableCollections;
import org.jdesktop.swingbinding.JTableBinding;
import org.jdesktop.swingbinding.SwingBindings;
import com.biosis.biosislite.utiles.HerramientaGeneral;

/**
 *
 * @author Francis
 */
public class DlgMarcacionesDiarias extends javax.swing.JDialog {

    /**
     * Creates new form DlgMarcacionesDiarias
     */
    private Empleado empleado;
    private Date fecha;
    private List<Marcacion> marcaciones;
    private final MarcacionControlador marcc;

    public DlgMarcacionesDiarias(Empleado empleado, Date fecha, Frame owner) {
        super(owner, true);
        this.setLocationRelativeTo(owner);
        this.initComponents();
        this.empleado = empleado;
        this.fecha = fecha;
        this.marcaciones = ObservableCollections.observableList(new ArrayList<Marcacion>());
        this.marcc = new MarcacionControlador();
        this.mostrarDatos(empleado,fecha);
    }
    
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        lblEmpleado = new javax.swing.JLabel();
        lblFecha = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblMarcaciones = new org.jdesktop.swingx.JXTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Marcaciones en el día");

        jPanel1.setLayout(new java.awt.BorderLayout());

        jPanel2.setLayout(new java.awt.GridLayout(2, 0));

        lblEmpleado.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        lblEmpleado.setText("EMPLEADO:");
        jPanel2.add(lblEmpleado);

        lblFecha.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        lblFecha.setText("FECHA:");
        jPanel2.add(lblFecha);

        jPanel1.add(jPanel2, java.awt.BorderLayout.PAGE_START);

        tblMarcaciones.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(tblMarcaciones);

        jPanel1.add(jScrollPane2, java.awt.BorderLayout.CENTER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 551, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 299, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblEmpleado;
    private javax.swing.JLabel lblFecha;
    private org.jdesktop.swingx.JXTable tblMarcaciones;
    // End of variables declaration//GEN-END:variables

    private void mostrarDatos(Empleado empleado, Date fecha) {
//        System.out.println(String.format("EMPLEADO: %s FECHA: %s", empleado,fecha));
        this.lblEmpleado.setText(String.format("EMPLEADO: %s", empleado.getNombreCompleto()));
        this.lblFecha.setText(String.format("FECHA: %s", HerramientaGeneral.formatoFecha.format(fecha)));
        
        this.bindeoSalvaje();
        
        this.mostrarMarcaciones(empleado,fecha);
    }

    private void mostrarMarcaciones(Empleado empleado, Date fecha) {
        this.marcaciones.clear();
        this.marcaciones.addAll(this.marcc.buscarXFecha(empleado, fecha));
        this.tblMarcaciones.packAll();
    }

    private void bindeoSalvaje() {
        BindingGroup bindeo = new BindingGroup();
        JTableBinding bindeoMarcacion = SwingBindings.createJTableBinding(AutoBinding.UpdateStrategy.READ, marcaciones, tblMarcaciones);
        
        BeanProperty pHora = BeanProperty.create("fechaHora");
        BeanProperty pEquipo = BeanProperty.create("equipo");
        
        bindeoMarcacion.addColumnBinding(pHora).setColumnName("HORA").setEditable(false).setColumnClass(Date.class);
        bindeoMarcacion.addColumnBinding(pEquipo).setColumnName("EQUIPO").setEditable(false).setColumnClass(String.class);
        
        bindeo.addBinding(bindeoMarcacion);
        bindeo.bind();
        
        this.tblMarcaciones.setDefaultRenderer(Date.class, new DefaultTableCellRenderer(){

            @Override
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                if(value != null){
                    value = HerramientaGeneral.formatoHoraMinutoSegundo.format((Date)value);
                }
                return super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column); //To change body of generated methods, choose Tools | Templates.
            }
            
        });
    }
}
