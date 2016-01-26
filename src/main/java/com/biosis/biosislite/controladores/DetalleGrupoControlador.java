/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.biosis.biosislite.controladores;

import com.biosis.biosislite.entidades.DetalleGrupoHorario;
import com.biosis.biosislite.entidades.GrupoHorario;
import com.biosis.biosislite.entidades.escalafon.Empleado;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author fesquivelc
 */
public class DetalleGrupoControlador extends Controlador<DetalleGrupoHorario>{

    public DetalleGrupoControlador() {
        super(DetalleGrupoHorario.class);
    }
    
    public List<DetalleGrupoHorario> buscarXEmpleado(Empleado empleado){
        String jpql = "SELECT a FROM DetalleGrupoHorario a WHERE "
                + "a.empleado = :empleado";
        Map<String, Object> mapa = new HashMap<>();
        mapa.put("empleado", empleado);
        return this.getDao().buscar(jpql, mapa);
    }
    
    public List<DetalleGrupoHorario> buscarXGrupo(GrupoHorario grupo){
        String jpql = "SELECT a FROM DetalleGrupoHorario a WHERE "
                + "a.grupoHorario = :grupo";
        Map<String, Object> mapa = new HashMap<>();
        mapa.put("grupo", grupo);
        return this.getDao().buscar(jpql, mapa);
    }

    public List<DetalleGrupoHorario> buscarXEmpleado(Empleado empleado, Date fechaInicio, Date fechaFin) {
        String jpql = "SELECT a FROM DetalleGrupoHorario a WHERE "
                + "a.empleado = :empleado AND a.horario.fechaInicio ";
        Map<String, Object> mapa = new HashMap<>();
        mapa.put("empleado", empleado);
        mapa.put("fechaInicio", fechaInicio);
        mapa.put("fechaFin", fechaFin);
        
        return this.getDao().buscar(jpql, mapa);
    }

    List<DetalleGrupoHorario> buscarXEmpleados(List<Empleado> empleados) {
        String jpql = "SELECT dgh FROM DetalleGrupoHorario dgh WHERE "
                + "dgh.empleado IN :empleados ";
        Map<String, Object> mapa = new HashMap<>();
        mapa.put("empleados", empleados);
        
        return this.getDao().buscar(jpql, mapa);
    }
}
