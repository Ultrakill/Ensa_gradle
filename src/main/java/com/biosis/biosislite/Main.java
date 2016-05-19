/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.biosis.biosislite;

import com.biosis.biosislite.vistas.dialogos.DlgLogin;
import com.personal.utiles.PropertiesUtil;
import java.io.File;
import java.util.Properties;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author fesquivelc
 */
public class Main {

    public static String APLICACION_TITULO = "";
    public static String APLICACION_FONDO = "";
    public static String LOGIN_TITULO = "";
    public static String LOGIN_SUBTITULO = "";
    public static String LOGIN_IMAGEN = "";
    public static String REPORTE_INSTITUCION = "";
    public static String REPORTE_RUC = "";
    public static String REPORTE_LOGO = "";
    
    public static File FICHERO_REPORTE_PAPELETA_SALIDA;
    public static File FICHERO_REPORTE_PAPELETA_VACACION;
    public static File FICHERO_REPORTE_ASISTENCIA_DETALLADO;
    public static File FICHERO_REPORTE_ASISTENCIA_RESUMEN;
    public static File FICHERO_REPORTE_PERMISOS;
    public static File FICHERO_REPORTE_EMPLEADOS_NO_MARCAN;
    public static File FICHERO_REPORTE_TARDANZAS_MES;
    public static File FICHERO_REPORTE_VACACIONES_SALDO;
    public static File FICHERO_REPORTE_VACACIONES_DETALLE;
    public static File FICHERO_REPORTE_ASISTENCIA_DETALLADO_ALUMNO;

    public static void main(String[] args) {
        // TODO code application logic here
        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equalsIgnoreCase(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e) {

        }

//        System.setProperty(
//                "Quaqua.tabLayoutPolicy", "wrap"
//        );
//        try {
//            UIManager.setLookAndFeel(ch.randelshofer.quaqua.QuaquaManager.getLookAndFeel());
//        } catch (Exception e) {
//
//        }
        Properties props = PropertiesUtil.cargarProperties("config/interfaz.properties");
        Properties recursos = PropertiesUtil.cargarProperties("config/recursos.properties");
        APLICACION_TITULO = props.getProperty("aplicacion_titulo");
        LOGIN_TITULO = props.getProperty("login_titulo");
        LOGIN_SUBTITULO = props.getProperty("login_subtitulo");
        LOGIN_IMAGEN = props.getProperty("login_imagen");
        APLICACION_FONDO = props.getProperty("aplicacion_fondo");
        REPORTE_INSTITUCION = props.getProperty("reporte_institucion");
        REPORTE_LOGO = props.getProperty("reporte_logo");
        REPORTE_RUC = props.getProperty("reporte_ruc");
        
        FICHERO_REPORTE_PAPELETA_SALIDA = new File(recursos.getProperty("reporte_papeleta_salida"));
        FICHERO_REPORTE_PAPELETA_VACACION = new File(recursos.getProperty("reporte_papeleta_vacacion"));
        FICHERO_REPORTE_ASISTENCIA_DETALLADO = new File(recursos.getProperty("reporte_asistencia_detallado"));
        FICHERO_REPORTE_ASISTENCIA_DETALLADO_ALUMNO = new File(recursos.getProperty("reporte_asistencia_detallado_alumno"));
        FICHERO_REPORTE_ASISTENCIA_RESUMEN = new File(recursos.getProperty("reporte_asistencia_resumen"));
        FICHERO_REPORTE_PERMISOS = new File(recursos.getProperty("reporte_permisos"));
        FICHERO_REPORTE_TARDANZAS_MES = new File(recursos.getProperty("reporte_tardanzas_mes"));
        FICHERO_REPORTE_EMPLEADOS_NO_MARCAN = new File(recursos.getProperty("reporte_empleados_no_marcan"));
        FICHERO_REPORTE_VACACIONES_SALDO = new File(recursos.getProperty("reporte_vacaciones_saldo"));
        FICHERO_REPORTE_VACACIONES_DETALLE = new File(recursos.getProperty("reporte_vacaciones_detalle"));
        
        DlgLogin principal = new DlgLogin(null, true);
        principal.setVisible(true);

    }

}
