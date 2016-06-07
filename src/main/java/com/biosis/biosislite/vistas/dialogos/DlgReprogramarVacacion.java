/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.biosis.biosislite.vistas.dialogos;

import com.personal.utiles.FechaUtil;
import com.personal.utiles.FormularioUtil;
import com.biosis.biosislite.controladores.Controlador;
import com.biosis.biosislite.controladores.EmpleadoControlador;
import com.biosis.biosislite.controladores.HorarioControlador;
import com.biosis.biosislite.controladores.SaldoVacacionalControlador;
import com.biosis.biosislite.controladores.TCAnalisisControlador;
import com.biosis.biosislite.controladores.VacacionControlador;
import com.biosis.biosislite.entidades.Horario;
import com.biosis.biosislite.entidades.Periodo;
import com.biosis.biosislite.entidades.SaldoVacacional;
import com.biosis.biosislite.entidades.Turno;
import com.biosis.biosislite.entidades.Vacacion;
import com.biosis.biosislite.entidades.escalafon.Empleado;
import java.awt.Component;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author fesquivelc
 */
public class DlgReprogramarVacacion extends javax.swing.JDialog {

    /**
     * Creates new form DlgInterrupcionVacacion
     */
    private final Vacacion vacacion;
    private final VacacionControlador vc;
    private final EmpleadoControlador ec;
    private final HorarioControlador horc = new HorarioControlador();

    public DlgReprogramarVacacion(Component padre, Vacacion vacacion) {
        super(JOptionPane.getFrameForComponent(padre), true);
        initComponents();
        this.vacacion = vacacion;
        ec = new EmpleadoControlador();
        vc = new VacacionControlador();
        
        dcInterrupcionDesde.setDate(vacacion.getFechaInicio());
        dcFechaHasta.setDate(vacacion.getFechaFin());
        
//        dcInterrupcionDesde.setMinSelectableDate(vacacion.getFechaInicio());
//        dcInterrupcionDesde.setMaxSelectableDate(vacacion.getFechaFin());
//        dcFechaHasta.setMinSelectableDate(vacacion.getFechaFin());
        controles();
        this.setLocationRelativeTo(padre);
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
        jPanel2 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtEmpleado = new javax.swing.JTextField();
        dcInterrupcionDesde = new com.toedter.calendar.JDateChooser();
        dcFechaHasta = new com.toedter.calendar.JDateChooser();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtDocumento = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("REPROGRAMAR VACACIONES");
        getContentPane().setLayout(new java.awt.GridLayout(1, 0));

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Definir fecha de interrupción"));
        jPanel1.setToolTipText("");
        java.awt.GridBagLayout jPanel1Layout = new java.awt.GridBagLayout();
        jPanel1Layout.columnWidths = new int[] {0, 5, 0, 5, 0};
        jPanel1Layout.rowHeights = new int[] {0, 5, 0, 5, 0, 5, 0, 5, 0, 5, 0};
        jPanel1.setLayout(jPanel1Layout);

        jPanel2.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jPanel2.setLayout(new java.awt.GridLayout(1, 0, 5, 0));

        jButton1.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        jButton1.setText("Guardar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton1);

        jButton2.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        jButton2.setText("Cancelar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton2);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 10;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.PAGE_END;
        gridBagConstraints.weighty = 0.1;
        jPanel1.add(jPanel2, gridBagConstraints);

        jLabel1.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        jLabel1.setText("Empleado:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        jPanel1.add(jLabel1, gridBagConstraints);

        jLabel2.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        jLabel2.setText("Inicio reprogramación: ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        jPanel1.add(jLabel2, gridBagConstraints);

        jLabel3.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        jLabel3.setText("Fin reprogramación: ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        jPanel1.add(jLabel3, gridBagConstraints);

        txtEmpleado.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.weightx = 0.1;
        jPanel1.add(txtEmpleado, gridBagConstraints);

        dcInterrupcionDesde.setDateFormatString("dd.MM.yyyy");
        dcInterrupcionDesde.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        jPanel1.add(dcInterrupcionDesde, gridBagConstraints);

        dcFechaHasta.setDateFormatString("dd.MM.yyyy");
        dcFechaHasta.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        jPanel1.add(dcFechaHasta, gridBagConstraints);

        jLabel5.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        jLabel5.setText("Motivo: ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        jPanel1.add(jLabel5, gridBagConstraints);

        txtDocumento.setColumns(20);
        txtDocumento.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        txtDocumento.setRows(5);
        jScrollPane1.setViewportView(txtDocumento);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.gridheight = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.weighty = 0.1;
        jPanel1.add(jScrollPane1, gridBagConstraints);

        getContentPane().add(jPanel1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        int accion = Controlador.MODIFICAR;
        if (FormularioUtil.dialogoConfirmar(this, accion)) {
//            Date fechaFin = obtenerFechaFin(vacacion.getEmpleado(), this.dcInterrupcionDesde.getDate(), this.vacacion.getFechaFin(), dcInicioReprogramacion.getDate());
            
            
            
            Vacacion reprogramacion = new Vacacion();
            reprogramacion.setFechaInicio(dcInterrupcionDesde.getDate());
            reprogramacion.setFechaFin(dcFechaHasta.getDate());
            reprogramacion.setDocumento(txtDocumento.getText());
            reprogramacion.setEmpleado(this.vacacion.getEmpleado());
            reprogramacion.setVacacionOrigen(this.vacacion);
            reprogramacion.setPeriodo(this.vacacion.getPeriodo());
            
            this.vacacion.setVacacionReprogramacion(reprogramacion);
            this.vacacion.setFechaInterrupcion(dcInterrupcionDesde.getDate());
            this.vacacion.setHayReprogramacion(true);
//            vacacion.setFechaInterrupcion(dcInterrupcionDesde.getDate());
            vc.setSeleccionado(vacacion);
            if (vc.accion(accion)) {
                this.dispose();
            }
        }
    }//GEN-LAST:event_jButton1ActionPerformed
    private final TCAnalisisControlador tcac = new TCAnalisisControlador();

    private void retrocederTiempo(List<String> dnis, Date fechaInicio) {
        tcac.retrocederTiempo(dnis, fechaInicio);
    }
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.toedter.calendar.JDateChooser dcFechaHasta;
    private com.toedter.calendar.JDateChooser dcInterrupcionDesde;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea txtDocumento;
    private javax.swing.JTextField txtEmpleado;
    // End of variables declaration//GEN-END:variables

    private void controles() {
        Empleado empleado = vacacion.getEmpleado();
        txtEmpleado.setText(empleado.getNombreCompleto());
        dcInterrupcionDesde.setDate(vacacion.getFechaInicio());
        dcFechaHasta.setDate(vacacion.getFechaFin());

        FormularioUtil.activarComponente(txtEmpleado, false);
        FormularioUtil.activarComponente(dcInterrupcionDesde, true);
        FormularioUtil.activarComponente(dcFechaHasta, true);
    }

    private final Calendar cal = Calendar.getInstance();
    private final SaldoVacacionalControlador svc = new SaldoVacacionalControlador();

    private int[] obtenerSaldos(Empleado empleado, Periodo periodo) {
        List<Vacacion> vacaciones = vc.buscarXEmpleadoXPeriodo(empleado, periodo);
        int[] saldo = new int[3];
        int lunesViernes = 0;
        int sabado = 0;
        int domingo = 0;

        for (Vacacion v : vacaciones) {
            Date fechaInicio = v.getFechaInicio();
            Date fechaFin = v.isHayInterrupcion() ? v.getFechaInterrupcion() : v.getFechaFin();

            while (fechaInicio.compareTo(fechaFin) <= 0) {
                cal.setTime(fechaInicio);
                if (cal.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY || cal.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY) {
//                    sabadoADomingo++;
                } else {
                    lunesViernes++;
                }
                cal.add(Calendar.DAY_OF_MONTH, 1);
                fechaInicio = cal.getTime();
            }
        }
        int division = lunesViernes / 5;
        sabado = division;
        domingo = division;

        saldo[0] = lunesViernes;
        saldo[1] = sabado;
        saldo[2] = domingo;
        return saldo;
    }
    private final Calendar calendar = Calendar.getInstance();

    private Date obtenerFechaFin(Empleado empleado, Date interrupcionDesde, Date fechaFin, Date fechaInicioReprogramacion) {
        List<Horario> horarios = horc.buscarXEmpleado(empleado, interrupcionDesde, fechaFin);
        boolean lunes = false;
        boolean martes = false;
        boolean miercoles = false;
        boolean jueves = false;
        boolean viernes = false;
        boolean sabado = false;
        boolean domingo = false;
        for (Horario horario : horarios) {
            List<Turno> turnos = horario.getTurnoList();
            for (Turno turno : turnos) {
                lunes = lunes || turno.isLunes();
                martes = martes || turno.isMartes();
                miercoles = miercoles || turno.isMiercoles();
                jueves = jueves || turno.isJueves();
                viernes = viernes || turno.isViernes();
                sabado = sabado || turno.isSabado();
                domingo = domingo || turno.isDomingo();
            }
        }

        Calendar iterador = Calendar.getInstance();
        iterador.setTime(fechaInicioReprogramacion);
        int contador = 1;
        //LA DIFERENCIA DEBEN SER DIAS LABORALES
        int diferencia = diferencia(interrupcionDesde, fechaFin, lunes, martes, miercoles, jueves, viernes, sabado, domingo);
        while (contador <= diferencia) {
            if (isLaboral(iterador.getTime(), lunes, martes, miercoles, jueves, viernes, sabado, domingo)) {
                contador++;
            }
            iterador.add(Calendar.DATE, 1);
        }

        return iterador.getTime();
    }

    int diferencia(Date menor, Date mayor, boolean lunes, boolean martes, boolean miercoles, boolean jueves, boolean viernes, boolean sabado, boolean domingo) {
        Calendar cl = Calendar.getInstance();
        int conteo = 0;
        cl.setTime(menor);
        while (cl.getTime().compareTo(mayor) <= 0) {
            if(isLaboral(cl.getTime(), lunes, martes, miercoles, jueves, viernes, sabado, domingo)){
                conteo++;
            }
            cl.add(Calendar.DATE, 1);
        }
        return conteo;
    }

    private boolean isLaboral(Date fecha, boolean lunes, boolean martes, boolean miercoles, boolean jueves, boolean viernes, boolean sabado, boolean domingo) {
        Calendar cl = Calendar.getInstance();
        cl.setTime(fecha);
        switch (cl.get(Calendar.DAY_OF_WEEK)) {
            case Calendar.MONDAY:
                return lunes;
            case Calendar.TUESDAY:
                return martes;
            case Calendar.WEDNESDAY:
                return miercoles;
            case Calendar.THURSDAY:
                return jueves;
            case Calendar.FRIDAY:
                return viernes;
            case Calendar.SATURDAY:
                return sabado;
            case Calendar.SUNDAY:
                return domingo;
            default:
                return false;
        }
    }

}
