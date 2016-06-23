package com.biosis.biosislite.vistas.reportes;

import com.biosis.biosislite.Main;
import com.biosis.biosislite.algoritmo.AnalisisAsistencia;
import com.biosis.biosislite.algoritmo.AnalizadorAsistencia;
import com.biosis.biosislite.algoritmo.Interprete;
import com.biosis.biosislite.controladores.AreaEmpleadoControlador;
import com.biosis.biosislite.controladores.DetalleGrupoControlador;
import com.biosis.biosislite.controladores.EmpleadoControlador;
import com.biosis.biosislite.controladores.GrupoHorarioControlador;
import com.biosis.biosislite.controladores.MarcacionControlador;
import com.biosis.biosislite.controladores.PeriodoControlador;
import com.biosis.biosislite.entidades.DetalleGrupoHorario;
import com.biosis.biosislite.entidades.GrupoHorario;
import com.biosis.biosislite.entidades.Periodo;
import com.biosis.biosislite.entidades.asistencia.Asistencia;
import com.biosis.biosislite.entidades.asistencia.DetalleAsistencia;
import com.biosis.biosislite.entidades.escalafon.AreaEmpleado;
import com.biosis.biosislite.entidades.escalafon.Departamento;
import com.biosis.biosislite.entidades.escalafon.Empleado;
import com.biosis.biosislite.entidades.escalafon.Gerencia;
import com.biosis.biosislite.entidades.escalafon.UnidadNegocio;
import com.biosis.biosislite.entidades.reportes.RptAsistenciaDetallado;
import com.biosis.biosislite.entidades.reportes.RptMarcacion;
import com.biosis.biosislite.interpretes.InterpreteDetalleGRP;
import com.biosis.biosislite.interpretes.InterpreteResumenGRP;
import com.biosis.biosislite.utiles.ButtonTabComponent;
import com.biosis.biosislite.utiles.Exportador;
import com.biosis.biosislite.utiles.ExportadorTXT;
import com.biosis.biosislite.utiles.HerramientaGeneral;
import com.biosis.biosislite.utiles.UsuarioActivo;
import com.biosis.biosislite.vistas.dialogos.DlgAgregarMarcacion;
import com.biosis.biosislite.vistas.dialogos.DlgEmpleado;
import com.biosis.biosislite.vistas.dialogos.DlgGerencia;
import com.biosis.biosislite.vistas.dialogos.DlgMarcacionesDiarias;
import com.biosis.biosislite.vistas.dialogos.DlgOficina;
import com.biosis.biosislite.vistas.dialogos.DlgUnidadNegocio;
import com.biosis.biosislite.vistas.modelos.MTAsistencia;
import com.biosis.biosislite.vistas.modelos.MTEmpleado;
import com.personal.utiles.FechaUtil;
import com.personal.utiles.FormularioUtil;
import com.personal.utiles.ReporteUtil;
import com.personal.utiles.ReporteUtil.Formato;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Font;
import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import javax.swing.BoxLayout;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.SwingWorker;
import javax.swing.filechooser.FileNameExtensionFilter;
import org.jdesktop.beansbinding.AutoBinding;
import org.jdesktop.beansbinding.BindingGroup;
import org.jdesktop.observablecollections.ObservableCollections;
import org.jdesktop.swingbinding.JComboBoxBinding;
import org.jdesktop.swingbinding.JTableBinding;
import org.jdesktop.swingbinding.SwingBindings;

/**
 *
 * @author RyuujiMD
 */
public class RptRegistroAsistencia extends javax.swing.JInternalFrame {

    /**
     * Creates new form RptRegistroAsistencia
     */
    private final ReporteUtil reporteador;
    private final DateFormat dfFecha;
    private final EmpleadoControlador ec;
    private final File archivo = new File("reportes/reporte_asistencia_detallado_SUNARP.jasper");
    private final Font fuente;
    private final Interprete interprete = new InterpreteDetalleGRP();
    private final AreaEmpleadoControlador aempc = new AreaEmpleadoControlador();

    public RptRegistroAsistencia() {
        initComponents();

        ec = new EmpleadoControlador();
        pc = new PeriodoControlador();
        dfFecha = new SimpleDateFormat("dd/MM/yyyy");
        reporteador = new ReporteUtil();

//        FormularioUtil.modeloSpinnerFechaHora(spFechaInicio, "dd/MM/yyyy");
//        FormularioUtil.modeloSpinnerFechaHora(spFechaFin, "dd/MM/yyyy");
        this.dcFechaFin.setMaxSelectableDate(new Date());
        this.dcFechaInicio.setMaxSelectableDate(new Date());
        inicializar();
        bindeoSalvaje();
        controles();
        lblCargando.setVisible(false);
//        btnMarcacionManual.setVisible(false);
//        this.btnMarcacionManual.setEnabled(false);
        fuente = new Font(Font.SANS_SERIF, 0, 14);
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
        radPorFecha = new javax.swing.JRadioButton();
        radMes = new javax.swing.JRadioButton();
        radAnio = new javax.swing.JRadioButton();
        cboMes = new com.toedter.calendar.JMonthChooser();
        cboPeriodo = new javax.swing.JComboBox();
        cboPeriodo1 = new javax.swing.JComboBox();
        dcFechaInicio = new com.toedter.calendar.JDateChooser("dd/MM/yyyy","##/##/####", '_');
        dcFechaFin = new com.toedter.calendar.JDateChooser("dd/MM/yyyy","##/##/####", '_');
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
        radTodos = new javax.swing.JRadioButton();
        radGerencia = new javax.swing.JRadioButton();
        txtGerencia = new javax.swing.JTextField();
        btnGerencia = new javax.swing.JButton();
        radUnidad = new javax.swing.JRadioButton();
        txtUnidad = new javax.swing.JTextField();
        btnUnidad = new javax.swing.JButton();
        pnlBotones = new javax.swing.JPanel();
        btnGenerarReporte = new javax.swing.JButton();
        pnlReporte = new javax.swing.JPanel();
        pnlTab = new javax.swing.JTabbedPane();
        tabDetallado = new javax.swing.JPanel();
        pnlOpciones = new javax.swing.JPanel();
        jButton4 = new javax.swing.JButton();
        btnImprimir = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        cmbFormatos = new javax.swing.JComboBox();
        btnExportar = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        tblAsistenciaDetallado = new org.jdesktop.swingx.JXTable();
        pnlCerrarTab = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        cboFiltro = new javax.swing.JComboBox<String>();
        jLabel1 = new javax.swing.JLabel();
        lblCargando = new org.jdesktop.swingx.JXBusyLabel();
        grpRango.add(radPorFecha);
        grpRango.add(radMes);
        grpRango.add(radAnio);

        grpSeleccion.add(radGrupo);
        grpSeleccion.add(radPersonalizado);
        grpSeleccion.add(radOficina);
        grpSeleccion.add(radTodos);
        grpSeleccion.add(radGerencia);
        grpSeleccion.add(radUnidad);

        setClosable(true);
        setMaximizable(true);
        setTitle("REPORTE DE REGISTRO DE ASISTENCIA");
        getContentPane().setLayout(new java.awt.GridBagLayout());

        pnlRango.setBorder(javax.swing.BorderFactory.createTitledBorder("Rango"));
        pnlRango.setLayout(new java.awt.GridBagLayout());

        radPorFecha.setFont(new java.awt.Font("SansSerif", 0, 11)); // NOI18N
        radPorFecha.setSelected(true);
        radPorFecha.setText("Por fechas:");
        radPorFecha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radPorFechaActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        pnlRango.add(radPorFecha, gridBagConstraints);

        radMes.setFont(new java.awt.Font("SansSerif", 0, 11)); // NOI18N
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

        radAnio.setFont(new java.awt.Font("SansSerif", 0, 11)); // NOI18N
        radAnio.setText("Por año:");
        radAnio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radAnioActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        pnlRango.add(radAnio, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        pnlRango.add(cboMes, gridBagConstraints);

        cboPeriodo.setFont(new java.awt.Font("SansSerif", 0, 11)); // NOI18N
        cboPeriodo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        pnlRango.add(cboPeriodo, gridBagConstraints);

        cboPeriodo1.setFont(new java.awt.Font("SansSerif", 0, 11)); // NOI18N
        cboPeriodo1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        pnlRango.add(cboPeriodo1, gridBagConstraints);

        dcFechaInicio.setFont(new java.awt.Font("SansSerif", 0, 11)); // NOI18N
        dcFechaInicio.setMinSelectableDate(new java.util.Date(21667000L));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.weightx = 0.1;
        pnlRango.add(dcFechaInicio, gridBagConstraints);

        dcFechaFin.setFont(new java.awt.Font("SansSerif", 0, 11)); // NOI18N
        dcFechaFin.setMinSelectableDate(new java.util.Date(21667000L));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.weightx = 0.1;
        pnlRango.add(dcFechaFin, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.weightx = 0.1;
        getContentPane().add(pnlRango, gridBagConstraints);

        pnlEmpleados.setBorder(javax.swing.BorderFactory.createTitledBorder("Selección de empleados"));
        pnlEmpleados.setLayout(new java.awt.GridBagLayout());

        radGrupo.setFont(new java.awt.Font("SansSerif", 0, 11)); // NOI18N
        radGrupo.setText("Por grupo horario:");
        radGrupo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radGrupoActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        pnlEmpleados.add(radGrupo, gridBagConstraints);

        radPersonalizado.setFont(new java.awt.Font("SansSerif", 0, 11)); // NOI18N
        radPersonalizado.setText("Personalizado:");
        radPersonalizado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radPersonalizadoActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        pnlEmpleados.add(radPersonalizado, gridBagConstraints);

        cboGrupoHorario.setFont(new java.awt.Font("SansSerif", 0, 11)); // NOI18N
        cboGrupoHorario.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cboGrupoHorario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboGrupoHorarioActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        pnlEmpleados.add(cboGrupoHorario, gridBagConstraints);

        tblTabla.setFont(new java.awt.Font("SansSerif", 0, 11)); // NOI18N
        jScrollPane1.setViewportView(tblTabla);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.gridheight = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.weighty = 0.1;
        pnlEmpleados.add(jScrollPane1, gridBagConstraints);

        btnAgregar.setFont(new java.awt.Font("SansSerif", 0, 11)); // NOI18N
        btnAgregar.setText("+");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        pnlEmpleados.add(btnAgregar, gridBagConstraints);

        btnQuitar.setFont(new java.awt.Font("SansSerif", 0, 11)); // NOI18N
        btnQuitar.setText("-");
        btnQuitar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQuitarActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        pnlEmpleados.add(btnQuitar, gridBagConstraints);

        radOficina.setFont(new java.awt.Font("SansSerif", 0, 11)); // NOI18N
        radOficina.setText("Por oficina:");
        radOficina.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radOficinaActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        pnlEmpleados.add(radOficina, gridBagConstraints);

        txtOficina.setEditable(false);
        txtOficina.setFont(new java.awt.Font("SansSerif", 0, 11)); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        pnlEmpleados.add(txtOficina, gridBagConstraints);

        btnOficina.setFont(new java.awt.Font("SansSerif", 0, 11)); // NOI18N
        btnOficina.setText("...");
        btnOficina.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOficinaActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 4;
        pnlEmpleados.add(btnOficina, gridBagConstraints);

        radTodos.setFont(new java.awt.Font("SansSerif", 0, 11)); // NOI18N
        radTodos.setSelected(true);
        radTodos.setText("Todos");
        radTodos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radTodosActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        pnlEmpleados.add(radTodos, gridBagConstraints);

        radGerencia.setFont(new java.awt.Font("SansSerif", 0, 11)); // NOI18N
        radGerencia.setText("Por gerencia:");
        radGerencia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radGerenciaActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        pnlEmpleados.add(radGerencia, gridBagConstraints);

        txtGerencia.setEditable(false);
        txtGerencia.setFont(new java.awt.Font("SansSerif", 0, 11)); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        pnlEmpleados.add(txtGerencia, gridBagConstraints);

        btnGerencia.setFont(new java.awt.Font("SansSerif", 0, 11)); // NOI18N
        btnGerencia.setText("...");
        btnGerencia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGerenciaActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 3;
        pnlEmpleados.add(btnGerencia, gridBagConstraints);

        radUnidad.setFont(new java.awt.Font("SansSerif", 0, 11)); // NOI18N
        radUnidad.setText("Por UUNN:");
        radUnidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radUnidadActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        pnlEmpleados.add(radUnidad, gridBagConstraints);

        txtUnidad.setEditable(false);
        txtUnidad.setFont(new java.awt.Font("SansSerif", 0, 11)); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        pnlEmpleados.add(txtUnidad, gridBagConstraints);

        btnUnidad.setFont(new java.awt.Font("SansSerif", 0, 11)); // NOI18N
        btnUnidad.setText("...");
        btnUnidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUnidadActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 2;
        pnlEmpleados.add(btnUnidad, gridBagConstraints);

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

        btnGenerarReporte.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        btnGenerarReporte.setText("GENERAR REPORTE");
        btnGenerarReporte.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGenerarReporteActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        pnlBotones.add(btnGenerarReporte, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        getContentPane().add(pnlBotones, gridBagConstraints);

        pnlReporte.setLayout(new java.awt.BorderLayout());

        pnlTab.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        pnlTab.setMinimumSize(new java.awt.Dimension(800, 74));
        pnlTab.setPreferredSize(new java.awt.Dimension(800, 413));

        tabDetallado.setLayout(new java.awt.BorderLayout());

        pnlOpciones.setPreferredSize(new java.awt.Dimension(1215, 23));
        pnlOpciones.setLayout(new java.awt.GridLayout());

        jButton4.setFont(new java.awt.Font("SansSerif", 1, 11)); // NOI18N
        jButton4.setText("Ver marcaciones en el día");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        pnlOpciones.add(jButton4);

        btnImprimir.setFont(new java.awt.Font("SansSerif", 1, 11)); // NOI18N
        btnImprimir.setText("Imprimir");
        btnImprimir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnImprimirActionPerformed(evt);
            }
        });
        pnlOpciones.add(btnImprimir);

        jButton3.setFont(new java.awt.Font("SansSerif", 1, 11)); // NOI18N
        jButton3.setText("Imprimir Resumen");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        pnlOpciones.add(jButton3);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("Elegir formato:");
        pnlOpciones.add(jLabel3);

        cmbFormatos.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        cmbFormatos.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Excel (*.xls)", "Texto (*.txt)" }));
        pnlOpciones.add(cmbFormatos);

        btnExportar.setFont(new java.awt.Font("SansSerif", 1, 11)); // NOI18N
        btnExportar.setText("Exportar");
        btnExportar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExportarjButton5ActionPerformed(evt);
            }
        });
        pnlOpciones.add(btnExportar);

        tabDetallado.add(pnlOpciones, java.awt.BorderLayout.PAGE_END);

        tblAsistenciaDetallado.setModel(new javax.swing.table.DefaultTableModel(
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
        tblAsistenciaDetallado.setFont(new java.awt.Font("SansSerif", 0, 11)); // NOI18N
        tblAsistenciaDetallado.setHorizontalScrollEnabled(true);
        jScrollPane4.setViewportView(tblAsistenciaDetallado);

        tabDetallado.add(jScrollPane4, java.awt.BorderLayout.CENTER);

        pnlTab.addTab("Detallado", tabDetallado);

        pnlReporte.add(pnlTab, java.awt.BorderLayout.CENTER);

        pnlCerrarTab.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 2, 2));

        jLabel2.setText("Filtrar resultados:");
        pnlCerrarTab.add(jLabel2);

        cboFiltro.setEditable(true);
        cboFiltro.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "TODOS", "ASISTENCIA REGULAR", "TARDANZAS", "FALTAS", "INCONSISTENCIAS", "VACACIONES", "FERIADOS", "PERMISOS" }));
        cboFiltro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboFiltroActionPerformed(evt);
            }
        });
        pnlCerrarTab.add(cboFiltro);

        jLabel1.setText("    ");
        pnlCerrarTab.add(jLabel1);

        lblCargando.setText("Cargando resultados...");
        pnlCerrarTab.add(lblCargando);

        pnlReporte.add(pnlCerrarTab, java.awt.BorderLayout.PAGE_START);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridheight = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.2;
        getContentPane().add(pnlReporte, gridBagConstraints);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void agregarPestaña(String titulo, Component ventana) {
        int index = pnlTab.indexOfComponent(ventana);
        if (index >= 0) {
            pnlTab.setSelectedIndex(index);
        } else {
            ButtonTabComponent tab = new ButtonTabComponent(pnlTab);
            pnlTab.add(titulo, ventana);
            pnlTab.setTabComponentAt(pnlTab.getTabCount() - 1, tab);
            pnlTab.setSelectedIndex(pnlTab.getTabCount() - 1);
        }
    }

    RptRegistroAsistencia rpt = this;
    List<RptAsistenciaDetallado> registroAsistenciaPreList = new ArrayList<>();

    private void filtrar(List<RptAsistenciaDetallado> registroAsistenciaPreList, int valorFiltro) {

        if (valorFiltro == -10) {
            this.asistenciaDetalleList.clear();
            this.asistenciaDetalleList.addAll(registroAsistenciaPreList);
        } else {
            this.asistenciaDetalleList.clear();
            this.asistenciaDetalleList.addAll(registroAsistenciaPreList.stream().filter(ra -> ra.getTipo() == valorFiltro).collect(Collectors.toList()));

        }
    }

    private class GenerarReporte extends SwingWorker<Double, Void> {

//        DlgEsperaTest test = new DlgEsperaTest(rpt);
        @Override
        protected Double doInBackground() throws Exception {
            FormularioUtil.activarComponente(pnlTab, false);
            FormularioUtil.activarComponente(pnlEmpleados, false);
            FormularioUtil.activarComponente(pnlRango, false);
            FormularioUtil.activarComponente(pnlCerrarTab, false);
            FormularioUtil.activarComponente(btnGenerarReporte, false);
            lblCargando.setEnabled(true);
            lblCargando.setVisible(true);
            lblCargando.setBusy(true);

//            test.setVisible(true);
//            test.setEnabled(true);
            generarReporte();
            return 0.0;
        }

        @Override
        protected void done() {
            FormularioUtil.activarComponente(pnlTab, true);
            FormularioUtil.activarComponente(pnlEmpleados, true);
            FormularioUtil.activarComponente(pnlRango, true);
            FormularioUtil.activarComponente(pnlCerrarTab, true);
            FormularioUtil.activarComponente(btnGenerarReporte, true);
//            FormularioUtil.activarComponente(btnMarcacionManual, false);
            lblCargando.setBusy(false);
            lblCargando.setVisible(false);
//            test.setVisible(false);
//            test.setEnabled(false);
//            test.dispose();

        }

    }

    private void btnGenerarReporteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGenerarReporteActionPerformed
        // TODO add your handling code here:       

        asistenciaDetalleList.clear();
        Date hoy = new Date();
        boolean flag = false;
        if (!radMes.isSelected()) {
            if (!radAnio.isSelected()) {
                if (!radPorFecha.isSelected()) {
                    JOptionPane.showMessageDialog(this, "Debe seleccionar algún rango.\n", "Mensaje del sistema", JOptionPane.ERROR_MESSAGE);
                    if (dcFechaInicio.getDate() == null || dcFechaFin.getDate() == null) {
                        JOptionPane.showMessageDialog(this, "El rango está incompleto o no se ha seleccionado adecuadamente.\n", "Mensaje del sistema", JOptionPane.ERROR_MESSAGE);
                    }
                } else if (dcFechaInicio.getDate() != null && dcFechaFin.getDate() != null) {
                    if (radPorFecha.isSelected() && (dcFechaInicio.getDate().compareTo(hoy) <= 0 && dcFechaFin.getDate().compareTo(hoy) <= 0)) {
                        GenerarReporte reporte = new GenerarReporte();
                        reporte.execute();
                    } else {
                        flag = true;
                        JOptionPane.showMessageDialog(this, "La fecha seleccionada es superior a la actual\n", "Mensaje del sistema", JOptionPane.ERROR_MESSAGE);
                    }

                } else {
                    JOptionPane.showMessageDialog(this, "El rango está incompleto o no se ha seleccionado adecuadamente.\n", "Mensaje del sistema", JOptionPane.ERROR_MESSAGE);
                }
            } else if (!flag) {
                GenerarReporte reporte = new GenerarReporte();
                reporte.execute();
            }
        } else if (!flag) {
            GenerarReporte reporte = new GenerarReporte();
            reporte.execute();
        }

//        imprimir();
    }//GEN-LAST:event_btnGenerarReporteActionPerformed

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        // TODO add your handling code here:
        DlgEmpleado dialogo = new DlgEmpleado(this);
        dialogo.setVisible(true);
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void radAnioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radAnioActionPerformed
        // TODO add your handling code here:control
        controles();
    }//GEN-LAST:event_radAnioActionPerformed

    private void radMesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radMesActionPerformed
        // TODO add your handling code here:
        controles();
    }//GEN-LAST:event_radMesActionPerformed

    private void radPorFechaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radPorFechaActionPerformed
        // TODO add your handling code here:
        controles();
    }//GEN-LAST:event_radPorFechaActionPerformed

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

    private void radTodosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radTodosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_radTodosActionPerformed

    private void btnImprimirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnImprimirActionPerformed
        // TODO add your handling code here:
        if (!this.asistenciaDetalleList.isEmpty()) {

            imprimir();
        }
//        Formato formato = obtenerFormato();
//        String ruta;
//        ruta = FormularioUtil.guardarFichero(this, "Seleccione el destino donde guardará el resporte");
//        System.out.println("RUTA ENVIADA: "+ruta);
//        if (ruta.isEmpty()) {
//            JOptionPane.showMessageDialog(this, "Debe seleccionar un destino correcto", "Mensaje del sistema", JOptionPane.WARNING_MESSAGE);
//        } else {
//            exportar(formato, ruta);
//        }
    }//GEN-LAST:event_btnImprimirActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        if (!this.asistenciaDetalleList.isEmpty()) {
            imprimirResumen();
        }

    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        int fila = this.tblAsistenciaDetallado.getSelectedRow();
        if (fila != -1) {
            RptAsistenciaDetallado detalle = this.asistenciaDetalleList.get(fila);
            System.out.println(String.format("DETALLE: %s %s", detalle.getEmpleado(), detalle.getFecha()));
            DlgMarcacionesDiarias marcaciones = new DlgMarcacionesDiarias(detalle.getEmpleado(), detalle.getFecha(), JOptionPane.getFrameForComponent(this));
            marcaciones.setVisible(true);
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void cboFiltroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboFiltroActionPerformed
        // TODO add your handling code here:
        /**
         * Procedemos a cambiar
         */
        int valorFiltro;
        switch (cboFiltro.getSelectedIndex()) {
            case 0:
                // TODOS
                valorFiltro = -10;
                break;
            case 1:
                //REGULAR
                valorFiltro = AnalizadorAsistencia.REGULAR;
                break;
            case 2:
                valorFiltro = AnalizadorAsistencia.TARDANZA;
                break;
            case 3:
                valorFiltro = AnalizadorAsistencia.INASISTENCIA;
                break;
            case 4:
                valorFiltro = AnalizadorAsistencia.INCONSISTENCIA;
                break;
            case 5:
                valorFiltro = AnalizadorAsistencia.VACACION;
                break;
            case 6:
                valorFiltro = AnalizadorAsistencia.FERIADO;
                break;
            case 7:
                valorFiltro = AnalizadorAsistencia.PERMISO_FECHA;
                break;
            default:
                valorFiltro = -10;
                break;

        }
        filtrar(this.registroAsistenciaPreList, valorFiltro);
    }//GEN-LAST:event_cboFiltroActionPerformed

    private void radGerenciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radGerenciaActionPerformed
        // TODO add your handling code here:
        controles();
    }//GEN-LAST:event_radGerenciaActionPerformed

    private void btnGerenciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGerenciaActionPerformed
        // TODO add your handling code here:
        DlgGerencia gerenciaB = new DlgGerencia(this);
        gerenciaB.setVisible(true);
        gerenciaSeleccionada = gerenciaB.getGerencia();
        
        if (gerenciaSeleccionada != null) {
            txtGerencia.setText(gerenciaSeleccionada.getNombre());

        }
    }//GEN-LAST:event_btnGerenciaActionPerformed

    private void radUnidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radUnidadActionPerformed
        // TODO add your handling code here:
        controles();
    }//GEN-LAST:event_radUnidadActionPerformed

    UnidadNegocio unidadSeleccionada = new UnidadNegocio();
    private void btnUnidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUnidadActionPerformed
        // TODO add your handling code here:
        DlgUnidadNegocio unidad = new DlgUnidadNegocio(this);
        unidad.setVisible(true);
        unidadSeleccionada = unidad.getUnidadNegocio();

        if(unidadSeleccionada != null){
            txtUnidad.setText(unidadSeleccionada.getNombre());
        }
    }//GEN-LAST:event_btnUnidadActionPerformed

    private void btnExportarjButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExportarjButton5ActionPerformed
        // TODO add your handling code here:

        if(cmbFormatos.getSelectedIndex()==0){
            ExportarXLS();
        }else if(cmbFormatos.getSelectedIndex()==1){
            ExportarTXT();
        }
    }//GEN-LAST:event_btnExportarjButton5ActionPerformed

    private Departamento oficinaSeleccionada;
    
    private Gerencia gerenciaSeleccionada;

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnExportar;
    private javax.swing.JButton btnGenerarReporte;
    private javax.swing.JButton btnGerencia;
    private javax.swing.JButton btnImprimir;
    private javax.swing.JButton btnOficina;
    private javax.swing.JButton btnQuitar;
    private javax.swing.JButton btnUnidad;
    private javax.swing.JComboBox<String> cboFiltro;
    private javax.swing.JComboBox cboGrupoHorario;
    private com.toedter.calendar.JMonthChooser cboMes;
    private javax.swing.JComboBox cboPeriodo;
    private javax.swing.JComboBox cboPeriodo1;
    private javax.swing.JComboBox cmbFormatos;
    private com.toedter.calendar.JDateChooser dcFechaFin;
    private com.toedter.calendar.JDateChooser dcFechaInicio;
    private javax.swing.ButtonGroup grpRango;
    private javax.swing.ButtonGroup grpSeleccion;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane4;
    private org.jdesktop.swingx.JXBusyLabel lblCargando;
    private javax.swing.JPanel pnlBotones;
    private javax.swing.JPanel pnlCerrarTab;
    private javax.swing.JPanel pnlEmpleados;
    private javax.swing.JPanel pnlOpciones;
    private javax.swing.JPanel pnlRango;
    private javax.swing.JPanel pnlReporte;
    private javax.swing.JTabbedPane pnlTab;
    private javax.swing.JRadioButton radAnio;
    private javax.swing.JRadioButton radGerencia;
    private javax.swing.JRadioButton radGrupo;
    private javax.swing.JRadioButton radMes;
    private javax.swing.JRadioButton radOficina;
    private javax.swing.JRadioButton radPersonalizado;
    private javax.swing.JRadioButton radPorFecha;
    private javax.swing.JRadioButton radTodos;
    private javax.swing.JRadioButton radUnidad;
    private javax.swing.JPanel tabDetallado;
    private org.jdesktop.swingx.JXTable tblAsistenciaDetallado;
    private org.jdesktop.swingx.JXTable tblTabla;
    private javax.swing.JTextField txtGerencia;
    private javax.swing.JTextField txtOficina;
    private javax.swing.JTextField txtUnidad;
    // End of variables declaration//GEN-END:variables

    private List<Empleado> empleadoList;
    private List<Periodo> periodoList;
    private final PeriodoControlador pc;

    private void inicializar() {
//        JasperViewer jv = new JasperViewer(null);
//        pnlTab.add("Vista previa", jv.getContentPane());
        empleadoList = ObservableCollections.observableList(new ArrayList<Empleado>());
        periodoList = pc.buscarTodosOrden();
        grupoList = gc.buscarTodos();
        dcFechaFin.setMaxSelectableDate(new Date());
    }

    private void controles() {
//        FormularioUtil.activarComponente(chkMarcaciones, radDetallado.isSelected());

        FormularioUtil.activarComponente(dcFechaInicio, radPorFecha.isSelected());
        FormularioUtil.activarComponente(dcFechaFin, radPorFecha.isSelected());
        FormularioUtil.activarComponente(cboMes, radMes.isSelected());
        FormularioUtil.activarComponente(cboPeriodo1, radMes.isSelected());
        FormularioUtil.activarComponente(cboPeriodo, radAnio.isSelected());

        FormularioUtil.activarComponente(cboGrupoHorario, radGrupo.isSelected());
//        FormularioUtil.activarComponente(btnOficina, radGrupo.isSelected());
        FormularioUtil.activarComponente(tblTabla, radPersonalizado.isSelected());
        FormularioUtil.activarComponente(btnAgregar, radPersonalizado.isSelected());
        FormularioUtil.activarComponente(btnQuitar, radPersonalizado.isSelected());

        FormularioUtil.activarComponente(btnOficina, radOficina.isSelected());
        
        FormularioUtil.activarComponente(btnGerencia, radGerencia.isSelected());
        FormularioUtil.activarComponente(btnUnidad, radUnidad.isSelected());
    }

    private List<GrupoHorario> grupoList;

    private void bindeoSalvaje() {
        MTEmpleado mt = new MTEmpleado(empleadoList);
        this.mtRegistroAsistencia = new MTAsistencia(this.asistenciaDetalleList);
        tblTabla.setModel(mt);
        tblAsistenciaDetallado.setModel(this.mtRegistroAsistencia);

        BindingGroup bindeo = new BindingGroup();

        JComboBoxBinding binding = SwingBindings.createJComboBoxBinding(AutoBinding.UpdateStrategy.READ, periodoList, cboPeriodo);
        JComboBoxBinding binding2 = SwingBindings.createJComboBoxBinding(AutoBinding.UpdateStrategy.READ, periodoList, cboPeriodo1);
        JComboBoxBinding binding3 = SwingBindings.createJComboBoxBinding(AutoBinding.UpdateStrategy.READ, grupoList, cboGrupoHorario);
        JTableBinding bindeoDetalle = SwingBindings.createJTableBinding(AutoBinding.UpdateStrategy.READ, grupoList, tblAsistenciaDetallado);

        bindeo.addBinding(binding);
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

//        tblAsistenciaDetallado.setDefaultRenderer(Date.class, new DefaultTableCellRenderer(){
//            @Override
//            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
//                if(value != null){
//                    value = HerramientaGeneral.formatoHora.format((Date)value);
//                }
//                return super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column); //To change body of generated methods, choose Tools | Templates.
//            }
//            
//        });
        cboPeriodo.setRenderer(renderPeriodo);
        cboPeriodo1.setRenderer(renderPeriodo);
        cboGrupoHorario.setRenderer(renderGrupo);
    }
    private AnalizadorAsistencia analisis = new AnalizadorAsistencia();
    private final MarcacionControlador mc = new MarcacionControlador();
    private final List<RptAsistenciaDetallado> asistenciaDetalleList = ObservableCollections.observableList(new ArrayList());
    private List<RptAsistenciaDetallado> asistenciaResumenList = ObservableCollections.observableList(new ArrayList());
    private MTAsistencia mtRegistroAsistencia;

    private void imprimir() {
        Map<String, Object> parametros = this.obtenerParametros();
        Component report = reporteador.obtenerReporte(this.asistenciaDetalleList, archivo, parametros);
//        pnlTab.removeTabAt(0);
        agregarPestaña("Vista previa", report);
//        pnlTab.add("Vista previa " + pnlTab.getTabCount(), report);
        pnlTab.setSelectedIndex(pnlTab.getTabCount() - 1);
    }

    private Map<String, Object> obtenerParametros() {
        DlgAsistenciaOpcion opcionesAdicionales = new DlgAsistenciaOpcion(this, true);
        Map<Integer, Boolean> mapOpcionesAd = opcionesAdicionales.obtenerOpciones();
        Calendar cal = Calendar.getInstance();

        String usuario = UsuarioActivo.getUsuario().getLogin();

        Date[] fechas = this.obtenerFechasLimite();
        Map<String, Object> parametros = new HashMap<>();
        parametros.put("usuario", usuario);
        parametros.put("ver_inconsistencias_como_falta", mapOpcionesAd.get(1));
        parametros.put("ver_horas_extra", mapOpcionesAd.get(2));
        parametros.put("fecha_inicio", fechas[0]);
        parametros.put("fecha_fin", fechas[1]);
        parametros.put("reporte_ruc", Main.REPORTE_RUC);
        parametros.put("reporte_logo", Main.REPORTE_LOGO);
        parametros.put("reporte_institucion", Main.REPORTE_INSTITUCION);
        parametros.put("reporte_usuario", UsuarioActivo.getUsuario().getLogin());
        parametros.put("rangoValor", String.format("%s - %s", HerramientaGeneral.formatoFecha.format(fechas[0]), HerramientaGeneral.formatoFecha.format(fechas[1])));
//        parametros.put("mostrar_he", chkHFH.isSelected());

        return parametros;
    }

    boolean bandera = false;

    private List<Empleado> obtenerDNI() {

        List<Empleado> lista = new ArrayList<>();
        Date fechas[] = this.obtenerFechasLimite();
        if (radTodos.isSelected()) {
            lista = this.ec.buscarPorBaja();
        } else if (radGrupo.isSelected()) {
            obtenerGrupo();
            List<DetalleGrupoHorario> detalleGrupo = dgc.buscarXGrupo(grupoSeleccionado);
            for (DetalleGrupoHorario detalle : detalleGrupo) {
                if (detalle.getEmpleado().getBaja() == false) {
                    lista.add(detalle.getEmpleado());
                }
            }
        } else if (radPersonalizado.isSelected()) {
            for (Empleado empleado : empleadoList) {
                if (empleado.getBaja() == false) {
                    lista.add(empleado);
                }
            }
        }else if (radGerencia.isSelected()) {
            List<AreaEmpleado> areaEmpleadoList = aempc.buscarXEmpleadoXFechaXGerencia(fechas[0], fechas[1],gerenciaSeleccionada);
            for (AreaEmpleado areaEmpleado : areaEmpleadoList) {
                if (areaEmpleado.getEmpleado().getBaja() == false) {
                    lista.add(areaEmpleado.getEmpleado());
                }
            }
        }else if (radUnidad.isSelected()) {
            List<AreaEmpleado> areaEmpleadoList = aempc.buscarXEmpleadoXFechaXUnidad(fechas[0], fechas[1],unidadSeleccionada);
            for (AreaEmpleado areaEmpleado : areaEmpleadoList) {
                if (areaEmpleado.getEmpleado().getBaja() == false) {
                    lista.add(areaEmpleado.getEmpleado());
                }
            }
        }else if (radOficina.isSelected()) {
            List<AreaEmpleado> areaEmpleadoList = aempc.buscarXEmpleadoXFecha(oficinaSeleccionada, fechas[0], fechas[1]);
            for (AreaEmpleado areaEmpleado : areaEmpleadoList) {
                if (areaEmpleado.getEmpleado().getBaja() == false) {
                    lista.add(areaEmpleado.getEmpleado());
                }
            }
//            List<FichaLaboral> fichas = oficinaSeleccionada.getFichaLaboralList();
//            for (FichaLaboral f : fichas) {
//                lista.add(f.getEmpleado());
//            }
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
//
//    private Formato obtenerFormato() {
//        int seleccionado = cboExportarFormato.getSelectedIndex();
//
//        switch (seleccionado) {
//            case 0:
//                return Formato.PDF;
//            case 1:
//                return Formato.XLSX;
//            case 2:
//                return Formato.XLS;
//            case 3:
//                return Formato.CSV;
//            case 4:
//                return Formato.DBF;
//            default:
//                return null;
//        }
//    }

    private void exportar(Formato formato, String ruta) {
        String reporte = "";
        File archivo = new File(reporte);
        Map<String, Object> parametros = this.obtenerParametros();
        if (formato != Formato.PDF) {
            parametros.put("MOSTRAR_TITULO", false);
        }
        reporteador.setConn(pc.getDao().getConexion());
        reporteador.exportarReporte(archivo, parametros, formato, ruta);
    }

    private List<Asistencia> asistenciaList;
    private Interprete interpreteResumen = new InterpreteResumenGRP();

    public static boolean band = false;

    private void generarReporte() {

        band = false;

        List<Empleado> empleados = obtenerDNI();
        Date[] fechasLimite = this.obtenerFechasLimite();
        asistenciaList = analisis.analizarAsistencia(empleados, fechasLimite[0], fechasLimite[1]);
        System.out.println("ASISTENCIA LISt: " + asistenciaList.size());
        List<RptAsistenciaDetallado> asistenciaDetallado = interprete.interpretar(asistenciaList);
        System.out.println("LUEGO DE INTERPRETAR: " + asistenciaDetallado.size());
        this.asistenciaDetalleList.clear();
        this.asistenciaDetalleList.addAll(asistenciaDetallado.stream().sorted((a1, a2) -> {
            int comparacion = a1.getRegimenLaboral().compareTo(a2.getRegimenLaboral());
            if (comparacion == 0) {
                comparacion = a1.getEmpleado().getNombreCompleto().compareTo(a2.getEmpleado().getNombreCompleto());
                if (comparacion == 0) {
                    comparacion = a1.getFecha().compareTo(a2.getFecha());
                }
            }
            return comparacion;
        }).collect(Collectors.toList()));

        //Iniciamos la lista antes del filtro
        registroAsistenciaPreList.addAll(this.asistenciaDetalleList);
        //seleccion del primer registro existente en el combo que es TODOS
        cboFiltro.setSelectedIndex(0);
//        this.asistenciaDetalleList.stream().forEach(asistencia -> System.out.println("--MES: "+asistencia.getMes()+" --"));
        this.tblAsistenciaDetallado.packAll();
        band = true;
        JOptionPane.showMessageDialog(this, "Reporte generado exitosamente", "Mensaje del sistema", JOptionPane.INFORMATION_MESSAGE);
    }

    private Date[] obtenerFechasLimite() {
        Calendar cal = Calendar.getInstance();
        Date[] fechas = new Date[2];
        int anio;
        int mes;
        Date fechaInicio = new Date();
        Date fechaFin = new Date();
        if (radPorFecha.isSelected()) {
            fechaInicio = dcFechaInicio.getDate();
            fechaFin = dcFechaFin.getDate();
        } else if (radMes.isSelected()) {
            anio = periodoList.get(cboPeriodo1.getSelectedIndex()).getAnio();
            mes = cboMes.getMonth();
            cal.set(anio, mes, 1);
            fechaInicio = cal.getTime();
            cal.set(Calendar.DAY_OF_MONTH, cal.getActualMaximum(Calendar.DAY_OF_MONTH));
            fechaFin = cal.getTime();
        } else if (radAnio.isSelected()) {
            anio = periodoList.get(cboPeriodo.getSelectedIndex()).getAnio();
            cal.set(anio, 0, 1);
            fechaInicio = cal.getTime();
            cal.set(anio, 11, 31);
            fechaFin = cal.getTime();
        }

        fechas[0] = fechaInicio;
        fechas[1] = fechaFin;

        return fechas;
    }

    private Component nuevoTab(Component reporte) {
        JPanel pnlPrincipal = new JPanel();
        pnlPrincipal.setLayout(new BorderLayout());

        JPanel pnlCerrar = new JPanel();
        pnlCerrar.setLayout(new BoxLayout(pnlCerrar, BoxLayout.LINE_AXIS));

        JButton boton = new JButton();
        boton.setText("Cerrar pestaña");
        boton.setFont(fuente);
        boton.addActionListener((java.awt.event.ActionEvent evt) -> {
            cerrarTabActivo();
        });

        pnlCerrar.add(boton);

        pnlPrincipal.add(pnlCerrar, BorderLayout.NORTH);
        pnlPrincipal.add(reporte, BorderLayout.CENTER);

        return pnlPrincipal;
    }

    private void cerrarTabActivo() {
        int tabIndex = this.pnlTab.getSelectedIndex();
        if (tabIndex > 0) {
            this.pnlTab.remove(tabIndex);
        }

    }
    
    private void ExportarTXT(){
        if (this.tblAsistenciaDetallado.getRowCount() == 0) {
            JOptionPane.showMessageDialog(null, "No hay datos en la tabla para exportar.", "BCO",
                    JOptionPane.INFORMATION_MESSAGE);
            this.btnExportar.grabFocus();
            return;
        }
        JFileChooser chooser = new JFileChooser();

        FileNameExtensionFilter filter = new FileNameExtensionFilter("Archivos de texto", "txt");
        chooser.setFileFilter(filter);
        chooser.setDialogTitle("Guardar archivo");
        chooser.setMultiSelectionEnabled(false);
        chooser.setAcceptAllFileFilterUsed(false);

        if (chooser.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
            List<JTable> tb = new ArrayList<>();
            List<String> nom = new ArrayList<>();
            tb.add(tblAsistenciaDetallado);
            nom.add("Detalle de Asistencia");
            String texto = chooser.getSelectedFile().toString().concat(".txt");
            try {
                Date[] fechasLimite = this.obtenerFechasLimite();
                ExportadorTXT e = new ExportadorTXT(new File(texto), tb, nom, fechasLimite[0], fechasLimite[1], false);
                if (e.exportarTXT()) {
                    JOptionPane.showMessageDialog(null, "Los datos fueron exportados a texto.", "BCO",
                            JOptionPane.INFORMATION_MESSAGE);

                }
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Hubo un error" + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    
    private void ExportarXLS(){
        if (this.tblAsistenciaDetallado.getRowCount() == 0) {
            JOptionPane.showMessageDialog(null, "No hay datos en la tabla para exportar.", "BCO",
                    JOptionPane.INFORMATION_MESSAGE);
            this.btnExportar.grabFocus();
            return;
        }
        JFileChooser chooser = new JFileChooser();

        FileNameExtensionFilter filter = new FileNameExtensionFilter("Archivos de excel", "xls");
        chooser.setFileFilter(filter);
        chooser.setDialogTitle("Guardar archivo");
        chooser.setMultiSelectionEnabled(false);
        chooser.setAcceptAllFileFilterUsed(false);

        if (chooser.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
            List<JTable> tb = new ArrayList<>();
            List<String> nom = new ArrayList<>();
            tb.add(tblAsistenciaDetallado);
            nom.add("Detalle de Asistencia");
            String excel = chooser.getSelectedFile().toString().concat(".xls");
            try {
                Date[] fechasLimite = this.obtenerFechasLimite();
                Exportador e = new Exportador(new File(excel), tb, nom, fechasLimite[0], fechasLimite[1], true);
                if (e.exportar()) {
                    JOptionPane.showMessageDialog(null, "Los datos fueron exportados a excel.", "BCO",
                            JOptionPane.INFORMATION_MESSAGE);

                }
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Hubo un error" + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    private void imprimirResumen() {
        File resumenFile = new File("reportes/reporte_asistencia_resumen.jasper");

        Map<String, Object> parametros = this.obtenerParametros();
        Component report = reporteador.obtenerReporte(interpreteResumen.interpretar(asistenciaList), resumenFile, parametros);
//        pnlTab.removeTabAt(0);
//        pnlTab.add("Resumen " + pnlTab.getTabCount(), report);
        agregarPestaña("Vista previa resumen", report);
        pnlTab.setSelectedIndex(pnlTab.getTabCount() - 1);
    }
}
