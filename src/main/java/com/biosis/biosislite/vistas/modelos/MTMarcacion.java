/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.biosis.biosislite.vistas.modelos;

import com.biosis.biosislite.entidades.Marcacion;
import com.biosis.biosislite.entidades.escalafon.Empleado;
import com.personal.utiles.ModeloTabla;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;

/**
 *
 * @author fesquivelc
 */
public class MTMarcacion extends ModeloTabla<Marcacion> {

    private final DateFormat dtFecha;
    private final DateFormat dtHora;
    
    public MTMarcacion(List<Marcacion> datos) {
        super(datos);
        this.nombreColumnas = new String[]{"Nro de documento", "Empleado", "Fecha", "Hora", "Ip de Equipo"};
        dtFecha = new SimpleDateFormat("dd.MM.yyyy");
        dtHora = new SimpleDateFormat("HH:mm:ss");
    }

    public MTMarcacion(List<Marcacion> datos, String[] nombreColumnas) {
        super(datos, nombreColumnas);
        dtFecha = new SimpleDateFormat("dd.MM.yyyy");
        dtHora = new SimpleDateFormat("HH:mm:ss");
    }

    @Override
    public Object getValorEn(int rowIndex, int columnIndex) {
        Marcacion marcacion = this.datos.get(rowIndex);
//        Empleado e = ec.buscarPorId(marcacion.getEmpleado());
        Empleado empleado = marcacion.getEmpleado();
        switch (columnIndex) {
            case 0:
                return empleado.getNroDocumento();
            case 1:
                return String.format("%s %s %s", empleado.getPaterno(),empleado.getMaterno(),empleado.getNombre());
            case 2:
                return dtFecha.format(marcacion.getFechaHora());
            case 3:
                return dtHora.format(marcacion.getFechaHora());
            case 4:
                return marcacion.getEquipo();
            default:
                return null;
        }
    }

}
