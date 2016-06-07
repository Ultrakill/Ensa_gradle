package com.biosis.biosislite.vistas.reportes;

import com.biosis.biosislite.algoritmo.AnalizadorAsistencia;
import com.personal.utiles.FechaUtil;
import com.biosis.biosislite.controladores.DetalleGrupoControlador;
import com.biosis.biosislite.controladores.EmpleadoControlador;
import com.biosis.biosislite.controladores.GrupoHorarioControlador;
import com.biosis.biosislite.controladores.PeriodoControlador;
import com.biosis.biosislite.entidades.DetalleGrupoHorario;
import com.biosis.biosislite.entidades.GrupoHorario;
import com.biosis.biosislite.entidades.Periodo;
import com.biosis.biosislite.vistas.dialogos.DlgEmpleado;
import com.biosis.biosislite.vistas.modelos.MTEmpleado;
import com.personal.utiles.FormularioUtil;
import com.personal.utiles.ReporteUtil;
import com.personal.utiles.ReporteUtil.Formato;
import com.biosis.biosislite.controladores.MarcacionControlador;
import com.biosis.biosislite.entidades.asistencia.Asistencia;
import com.biosis.biosislite.entidades.escalafon.Departamento;
import com.biosis.biosislite.entidades.escalafon.Empleado;
import com.biosis.biosislite.entidades.escalafon.FichaLaboral;
import com.biosis.biosislite.entidades.reportes.RptTardanzaMensual;
import com.biosis.biosislite.interpretes.InterpreteTardanzaMensual;
import java.awt.Component;
import java.io.File;
import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JList;
import net.sf.jasperreports.view.JasperViewer;
import org.jdesktop.beansbinding.AutoBinding;
import org.jdesktop.beansbinding.BindingGroup;
import org.jdesktop.observablecollections.ObservableCollections;
import org.jdesktop.swingbinding.JComboBoxBinding;
import org.jdesktop.swingbinding.SwingBindings;
import com.biosis.biosislite.utiles.UsuarioActivo;
import com.biosis.biosislite.vistas.dialogos.DlgOficina;
import javax.swing.JOptionPane;
import com.biosis.biosislite.Main;

/**
 *
 * @author RyuujiMD
 */
public class RptTardanzasMes extends javax.swing.JInternalFrame {

    /**
     * Creates new form RptRegistroAsistencia
     */
    private final ReporteUtil reporteador;
    private final DateFormat dfFecha;
    private final EmpleadoControlador ec;
    private final File archivo = new File("reportes/reporte_tardanzas_mensual.jasper");

    public RptTardanzasMes() {
        initComponents();

        ec = new EmpleadoControlador();
        pc = new PeriodoControlador();
        dfFecha = new SimpleDateFormat("dd/MM/yyyy");
        reporteador = new ReporteUtil();
//        FormularioUtil.modeloSpinnerFechaHora(spFechaInicio, "dd/MM/yyyy");
//        FormularioUtil.modeloSpinnerFechaHora(spFechaFin, "dd/MM/yyyy");
        inicializar();
        bindeoSalvaje();
        controles();
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

        grpRango = new javax.swing.ButtonGroup();
        grpSeleccion = new javax.swing.ButtonGroup();
        pnlRango = new javax.swing.JPanel();
        radMes = new javax.swing.JRadioButton();
        cboMes = new com.toedter.calendar.JMonthChooser();
        cboPeriodo1 = new javax.swing.JComboBox();
        pnlEmpleados = new javax.swing.JPanel();
        radGrupo = new javax.swing.JRadioButton();
        radPersonalizado = new javax.swing.JRadioButton();
        cboGrupoHorario = new javax.swing.JComboBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblTabla = new org.jdesktop.swingx.JXTable();
        btnAgregar = new javax.swing.JButton();
        btnQuitar = new javax.swing.JButton();
        radOficina = new javax.swing.JRadioButton();
        txtOficina = new javax.swing.JTextField();
        btnOficina = new javax.swing.JButton();
        pnlBotones = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();
        pnlReporte = new javax.swing.JPanel();
        pnlExportar = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        cboExportarFormato = new javax.swing.JComboBox();
        jButton1 = new javax.swing.JButton();
        pnlTab = new javax.swing.JTabbedPane();
        grpRango.add(radMes);

        grpSeleccion.add(radGrupo);
        grpSeleccion.add(radPersonalizado);
        grpSeleccion.add(radOficina);

        setClosable(true);
        setMaximizable(true);
        setTitle("REPORTE DE TARDANZAS POR MES");
        setToolTipText("");
        getContentPane().setLayout(new java.awt.GridBagLayout());

        pnlRango.setBorder(javax.swing.BorderFactory.createTitledBorder("Rango"));
        pnlRango.setLayout(new java.awt.GridBagLayout());

        radMes.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        radMes.setSelected(true);
        radMes.setText("Por mes:");
        radMes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radMesActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        pnlRango.add(radMes, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        pnlRango.add(cboMes, gridBagConstraints);

        cboPeriodo1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cboPeriodo1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.weightx = 0.1;
        pnlRango.add(cboPeriodo1, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.weightx = 0.1;
        getContentPane().add(pnlRango, gridBagConstraints);

        pnlEmpleados.setBorder(javax.swing.BorderFactory.createTitledBorder("Selección de empleados"));
        pnlEmpleados.setLayout(new java.awt.GridBagLayout());

        radGrupo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        radGrupo.setText("Por grupo horario:");
        radGrupo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radGrupoActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        pnlEmpleados.add(radGrupo, gridBagConstraints);

        radPersonalizado.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        radPersonalizado.setSelected(true);
        radPersonalizado.setText("Personalizado:");
        radPersonalizado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radPersonalizadoActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        pnlEmpleados.add(radPersonalizado, gridBagConstraints);

        cboGrupoHorario.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cboGrupoHorario.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cboGrupoHorario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboGrupoHorarioActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        pnlEmpleados.add(cboGrupoHorario, gridBagConstraints);

        tblTabla.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jScrollPane1.setViewportView(tblTabla);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridheight = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.weighty = 0.1;
        pnlEmpleados.add(jScrollPane1, gridBagConstraints);

        btnAgregar.setText("+");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        pnlEmpleados.add(btnAgregar, gridBagConstraints);

        btnQuitar.setText("-");
        btnQuitar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQuitarActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        pnlEmpleados.add(btnQuitar, gridBagConstraints);

        radOficina.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        radOficina.setText("Por oficina:");
        radOficina.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radOficinaActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        pnlEmpleados.add(radOficina, gridBagConstraints);

        txtOficina.setEditable(false);
        txtOficina.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        pnlEmpleados.add(txtOficina, gridBagConstraints);

        btnOficina.setText("...");
        btnOficina.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOficinaActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 1;
        pnlEmpleados.add(btnOficina, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridheight = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.weighty = 0.1;
        getContentPane().add(pnlEmpleados, gridBagConstraints);

        pnlBotones.setLayout(new java.awt.GridBagLayout());

        jButton2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton2.setText("GENERAR REPORTE");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        pnlBotones.add(jButton2, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        getContentPane().add(pnlBotones, gridBagConstraints);

        pnlReporte.setLayout(new java.awt.GridBagLayout());

        pnlExportar.setLayout(new javax.swing.BoxLayout(pnlExportar, javax.swing.BoxLayout.LINE_AXIS));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("Elegir formato:");
        pnlExportar.add(jLabel1);

        cboExportarFormato.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cboExportarFormato.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "PDF (*.pdf)", "Excel 2007 - 2013 (*.xlsx)", "Excel 97 - 2003 (*.xls)", "CSV (*.csv)", "DBF (*.dbf)" }));
        pnlExportar.add(cboExportarFormato);

        jButton1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton1.setText("Exportar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        pnlExportar.add(jButton1);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        pnlReporte.add(pnlExportar, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.6;
        gridBagConstraints.weighty = 0.2;
        pnlReporte.add(pnlTab, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridheight = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.2;
        getContentPane().add(pnlReporte, gridBagConstraints);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        imprimir();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        // TODO add your handling code here:
        DlgEmpleado dialogo = new DlgEmpleado(this);
        Empleado empleado = dialogo.getSeleccionado();
        if (empleado != null) {
            if (!empleadoList.contains(empleado)) {
                empleadoList.add(empleado);
                tblTabla.packAll();
            }

        }
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void radMesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radMesActionPerformed
        // TODO add your handling code here:
        controles();
    }//GEN-LAST:event_radMesActionPerformed

    private GrupoHorario grupoSeleccionado;
    private void cboGrupoHorarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboGrupoHorarioActionPerformed
        // TODO add your handling code here:
        obtenerGrupo();
    }//GEN-LAST:event_cboGrupoHorarioActionPerformed

    private void radGrupoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radGrupoActionPerformed
        // TODO add your handling code here:
        controles();
    }//GEN-LAST:event_radGrupoActionPerformed

    private void radPersonalizadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radPersonalizadoActionPerformed
        // TODO add your handling code here:
        controles();
    }//GEN-LAST:event_radPersonalizadoActionPerformed

    private void radOficinaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radOficinaActionPerformed
        // TODO add your handling code here:
        controles();
    }//GEN-LAST:event_radOficinaActionPerformed

    private void btnOficinaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOficinaActionPerformed
        // TODO add your handling code here:
        DlgOficina oficinas = new DlgOficina(this);
        oficinaSeleccionada = oficinas.getSeleccionado();
        if (oficinaSeleccionada != null) {
            txtOficina.setText(oficinaSeleccionada.getNombre());

        }
    }//GEN-LAST:event_btnOficinaActionPerformed

    private void btnQuitarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQuitarActionPerformed
        // TODO add your handling code here:
        int fila;
        if ((fila = tblTabla.getSelectedRow()) != -1) {
            empleadoList.remove(fila);
        }
    }//GEN-LAST:event_btnQuitarActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        Formato formato = obtenerFormato();
        String ruta;
        ruta = FormularioUtil.guardarFichero(this, "Seleccione el destino donde guardará el resporte");
        System.out.println("RUTA ENVIADA: " + ruta);
        if (ruta.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Debe seleccionar un destino correcto", "Mensaje del sistema", JOptionPane.WARNING_MESSAGE);
        } else {
            exportar(formato, ruta);
        }

    }//GEN-LAST:event_jButton1ActionPerformed

    private Departamento oficinaSeleccionada;

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnOficina;
    private javax.swing.JButton btnQuitar;
    private javax.swing.JComboBox cboExportarFormato;
    private javax.swing.JComboBox cboGrupoHorario;
    private com.toedter.calendar.JMonthChooser cboMes;
    private javax.swing.JComboBox cboPeriodo1;
    private javax.swing.ButtonGroup grpRango;
    private javax.swing.ButtonGroup grpSeleccion;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel pnlBotones;
    private javax.swing.JPanel pnlEmpleados;
    private javax.swing.JPanel pnlExportar;
    private javax.swing.JPanel pnlRango;
    private javax.swing.JPanel pnlReporte;
    private javax.swing.JTabbedPane pnlTab;
    private javax.swing.JRadioButton radGrupo;
    private javax.swing.JRadioButton radMes;
    private javax.swing.JRadioButton radOficina;
    private javax.swing.JRadioButton radPersonalizado;
    private org.jdesktop.swingx.JXTable tblTabla;
    private javax.swing.JTextField txtOficina;
    // End of variables declaration//GEN-END:variables

    private List<Empleado> empleadoList;
    private List<Periodo> periodoList;
    private final PeriodoControlador pc;

    private void inicializar() {
        JasperViewer jv = new JasperViewer(null);
        pnlTab.add("Vista previa", jv.getContentPane());
        empleadoList = ObservableCollections.observableList(new ArrayList<Empleado>());
        periodoList = pc.buscarTodosOrden();
        grupoList = gc.buscarTodos();
    }

    private void controles() {
//        FormularioUtil.activarComponente(chkMarcaciones, radDetallado.isSelected());

        FormularioUtil.activarComponente(cboMes, radMes.isSelected());
        FormularioUtil.activarComponente(cboPeriodo1, radMes.isSelected());

        FormularioUtil.activarComponente(cboGrupoHorario, radGrupo.isSelected());
//        FormularioUtil.activarComponente(btnOficina, radGrupo.isSelected());
        FormularioUtil.activarComponente(tblTabla, radPersonalizado.isSelected());
        FormularioUtil.activarComponente(btnAgregar, radPersonalizado.isSelected());
        FormularioUtil.activarComponente(btnQuitar, radPersonalizado.isSelected());

        FormularioUtil.activarComponente(btnOficina, radOficina.isSelected());
    }

    private List<GrupoHorario> grupoList;

    private void bindeoSalvaje() {
        MTEmpleado mt = new MTEmpleado(empleadoList);
        tblTabla.setModel(mt);

        BindingGroup bindeo = new BindingGroup();

        JComboBoxBinding binding2 = SwingBindings.createJComboBoxBinding(AutoBinding.UpdateStrategy.READ, periodoList, cboPeriodo1);
        JComboBoxBinding binding3 = SwingBindings.createJComboBoxBinding(AutoBinding.UpdateStrategy.READ, grupoList, cboGrupoHorario);

//        bindeo.addBinding(binding);
        bindeo.addBinding(binding2);
        bindeo.addBinding(binding3);
        bindeo.bind();

        DefaultListCellRenderer renderGrupo = new DefaultListCellRenderer() {

            @Override
            public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
                if (value != null) {
                    if (value instanceof GrupoHorario) {
                        value = ((GrupoHorario) value).getNombre();
                    }
                }
                return super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus); //To change body of generated methods, choose Tools | Templates.
            }

        };
        DefaultListCellRenderer renderPeriodo = new DefaultListCellRenderer() {

            @Override
            public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
                if (value != null) {
                    if (value instanceof Periodo) {
                        value = ((Periodo) value).getAnio();
                    }
                }
                return super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
            }

        };

//        cboPeriodo.setRenderer(renderPeriodo);
        cboPeriodo1.setRenderer(renderPeriodo);
        cboGrupoHorario.setRenderer(renderGrupo);
    }
    private AnalizadorAsistencia analisis = new AnalizadorAsistencia();
    private final MarcacionControlador mc = new MarcacionControlador();
    private final InterpreteTardanzaMensual interpreteTardanza = new InterpreteTardanzaMensual();

    private void imprimir() {
        Map<String, Object> parametros = this.obtenerParametros();
        List<Empleado> empleados = obtenerDNI();
        List<Asistencia> asistenciaList = analisis.analizarAsistencia(empleados, (Date) parametros.get("fecha_inicio"), (Date) parametros.get("fecha_fin"));

        List<RptTardanzaMensual> tardanzasMes = this.interpreteTardanza.interpretar(
                asistenciaList
                .stream()
                .sorted((a1, a2) -> a1.getEmpleado().getNombreCompleto().compareTo(a2.getEmpleado().getNombreCompleto()))
                .collect(Collectors.toList())
        );

        Component report = reporteador.obtenerReporte(tardanzasMes, archivo, parametros);
        pnlTab.removeTabAt(0);
        pnlTab.add("Vista previa", report);
        bandera = true;

    }

    private Map<String, Object> obtenerParametros() {
        Calendar cal = Calendar.getInstance();

        String usuario = UsuarioActivo.getUsuario().getLogin();

        int anio;
        int mes;
        Date fechaInicio = new Date();
        Date fechaFin = new Date();
        String rangoTitulo = "";
        String rangoValor = "";
        rangoTitulo = "MES: ";
        anio = periodoList.get(cboPeriodo1.getSelectedIndex()).getAnio();
        mes = cboMes.getMonth();
        cal.set(anio, mes, 1);
        fechaInicio = cal.getTime();
        cal.set(Calendar.DAY_OF_MONTH, cal.getActualMaximum(Calendar.DAY_OF_MONTH));
        fechaFin = cal.getTime();
        rangoValor = (cboMes.getMonth() + 1) + " / " + anio;

        Map<String, Object> parametros = new HashMap<>();
        parametros.put("usuario", usuario);
        parametros.put("fecha_inicio", fechaInicio);
        parametros.put("fecha_fin", fechaFin);
        parametros.put("reporte_ruc", Main.REPORTE_RUC);
        parametros.put("reporte_logo", Main.REPORTE_LOGO);
        parametros.put("reporte_institucion", Main.REPORTE_INSTITUCION);
        parametros.put("rangoValor", rangoValor);
        parametros.put("maximo_dias", cal.getActualMaximum(Calendar.DAY_OF_MONTH));
//        parametros.put("mostrar_he", chkHFH.isSelected());

        return parametros;
    }

    boolean bandera = false;

    private List<Empleado> obtenerDNI() {

        List<Empleado> lista = new ArrayList<>();
        if (radGrupo.isSelected()) {
            obtenerGrupo();
            List<DetalleGrupoHorario> detalleGrupo = dgc.buscarXGrupo(grupoSeleccionado);
            for (DetalleGrupoHorario detalle : detalleGrupo) {
                lista.add(detalle.getEmpleado());
            }
        } else if (radPersonalizado.isSelected()) {
            for (Empleado empleado : empleadoList) {
                lista.add(empleado);
            }
        } else if (radOficina.isSelected()) {
            List<FichaLaboral> fichas = oficinaSeleccionada.getFichaLaboralList();
            for (FichaLaboral f : fichas) {
                lista.add(f.getEmpleado());
            }
        }

        return lista;
    }

    public void agregarEmpleado(Empleado empleado) {
        empleadoList.add(empleado);
        tblTabla.packAll();
    }

    private GrupoHorarioControlador gc = new GrupoHorarioControlador();
    private DetalleGrupoControlador dgc = new DetalleGrupoControlador();

    private void obtenerGrupo() {
        int seleccionado = cboGrupoHorario.getSelectedIndex();
        if (seleccionado != -1) {
            grupoSeleccionado = this.grupoList.get(seleccionado);
        }
    }

    private Formato obtenerFormato() {
        int seleccionado = cboExportarFormato.getSelectedIndex();

        switch (seleccionado) {
            case 0:
                return Formato.PDF;
            case 1:
                return Formato.XLSX;
            case 2:
                return Formato.XLS;
            case 3:
                return Formato.CSV;
            case 4:
                return Formato.DBF;
            default:
                return null;
        }
    }

    private void exportar(Formato formato, String ruta) {
        String reporte = "";
//        if (radConsolidado.isSelected()) {
//            reporte = "reportes/r_registro_asistencia_consolidado.jasper";
//        } else if (radDetallado.isSelected()) {
//            reporte = "reportes/r_registro_asistencia_detallado_sm.jasper";
//        }
        File archivo = new File(reporte);
        Map<String, Object> parametros = this.obtenerParametros();
        if (formato != Formato.PDF) {
            parametros.put("MOSTRAR_TITULO", false);
        }
        reporteador.setConn(pc.getDao().getConexion());
        reporteador.exportarReporte(archivo, parametros, formato, ruta);
    }

//    private List<RptTardanza> obtenerTardanzasMensuales(List<Empleado> empleados, List<RptAsistencia> asistenciaList) {
//        List<RptTardanza> tardanzas = new ArrayList<>();
//        Calendar calendar = Calendar.getInstance();
//        empleados.stream().sorted((p1, p2) -> p1.getNombreCompleto().compareTo(p2.getNombreCompleto())).forEach(emp -> {
//            RptTardanza tardanzaMes = new RptTardanza();
//            tardanzaMes.setEmpleado(emp);
//            tardanzaMes.setTardanzas(new BigDecimal[31]);            
//            tardanzaMes.setTotalMes(BigDecimal.ZERO);
//            asistenciaList.stream().filter(a -> a.getEmpleado().equals(emp)).forEach(asistencia -> {
//                calendar.setTime(asistencia.getFecha());
//                tardanzaMes.setFecha(asistencia.getFecha());
//                long totalDia = 0;
//                if (asistencia.getDetalle1() != null) {
//                    if(asistencia.getDetalle1().getHoraEntrada() != null){
//                        Date entrada1 = FechaUtil.soloHora(asistencia.getDetalle1().getHoraEntrada());
//                        Date tolerancia1 = FechaUtil.soloHora(asistencia.getDetalle1().getDetalleJornada().getEntradaTolerancia());
//                        totalDia += entrada1.after(tolerancia1) ? entrada1.getTime() - tolerancia1.getTime() : 0;
//                    }
//                }
//
//                if (asistencia.getDetalle2() != null) {
//                    if(asistencia.getDetalle2().getHoraEntrada() != null){
//                        Date entrada2 = FechaUtil.soloHora(asistencia.getDetalle2().getHoraEntrada());
//                        Date tolerancia2 = FechaUtil.soloHora(asistencia.getDetalle2().getDetalleJornada().getEntradaTolerancia());
//                        totalDia += entrada2.after(tolerancia2) ? entrada2.getTime() - tolerancia2.getTime() : 0;
//                    }
//                }
//                BigDecimal totalDiaBD = BigDecimal.valueOf(totalDia / (1000*60));
//                tardanzaMes.getTardanzas()[calendar.get(Calendar.DAY_OF_MONTH) - 1] = totalDiaBD;
//                tardanzaMes.getTotalMes().add(totalDiaBD);
//            });
//            System.out.println("TOTAL MES: "+tardanzaMes.getTotalMes());
//            tardanzas.add(tardanzaMes);
//        });
//
//        return tardanzas;
//    }
}
