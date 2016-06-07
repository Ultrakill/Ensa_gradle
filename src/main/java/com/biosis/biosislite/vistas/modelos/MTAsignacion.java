/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.biosis.biosislite.vistas.modelos;

import com.biosis.biosislite.controladores.EmpleadoControlador;
import com.biosis.biosislite.entidades.AsignacionHorario;
import com.personal.utiles.ModeloTabla;
import com.biosis.biosislite.entidades.escalafon.Empleado;
import java.util.List;

/**
 *
 * @author fesquivelc
 */
public class MTAsignacion extends ModeloTabla<AsignacionHorario>{

    public MTAsignacion(List<AsignacionHorario> datos, String[] nombreColumnas) {
        super(datos, nombreColumnas);
    }

    @Override
    public Object getValorEn(int rowIndex, int columnIndex) {
        AsignacionHorario seleccion = this.datos.get(rowIndex);
        
        switch(columnIndex){
            case 0:
                return seleccion.getHorario().getCodigo();
            case 1:
                return seleccion.getHorario().getNombre();
            case 2:
                if(seleccion.isPorGrupo()){
                    return seleccion.getGrupoHorario().getNombre();                    
                }else{
                    Empleado empleado = seleccion.getEmpleado();
                    if(empleado != null){
                        return empleado.getPaterno() + " " + empleado.getMaterno() + " " + empleado.getNombre();
                    }
                    
                }
            default:
                return null;
        }
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        return String.class;
    }
    
    
    
}
