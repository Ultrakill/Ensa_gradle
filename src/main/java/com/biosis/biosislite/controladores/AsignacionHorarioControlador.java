/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.biosis.biosislite.controladores;

import com.biosis.biosislite.entidades.AsignacionHorario;
import com.biosis.biosislite.entidades.DetalleGrupoHorario;
import com.biosis.biosislite.entidades.GrupoHorario;
import com.biosis.biosislite.entidades.Horario;
import com.biosis.biosislite.entidades.escalafon.Empleado;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author fesquivelc
 */
public class AsignacionHorarioControlador extends Controlador<AsignacionHorario> {

    private final DetalleGrupoControlador dgc;
    public AsignacionHorarioControlador() {
        super(AsignacionHorario.class);
        dgc = new DetalleGrupoControlador();
    }
    
    public List<AsignacionHorario> buscarXGrupos(List<GrupoHorario> grupos){
        String jpql = "SELECT a FROM AsignacionHorario a WHERE "
                + "a.grupoHorario in :grupos";
        Map<String, Object> mapa = new HashMap<>();
        mapa.put("grupos", grupos);
        return this.getDao().buscar(jpql, mapa);
    }
    
    public List<AsignacionHorario> buscarXGrupo(GrupoHorario grupo){
        String jpql = "SELECT a FROM AsignacionHorario a WHERE "
                + "a.grupoHorario = :grupo";
        Map<String, Object> mapa = new HashMap<>();
        mapa.put("grupo", grupo);
        return this.getDao().buscar(jpql, mapa);
    }
    
    public List<AsignacionHorario> buscarXEmpleado(Empleado empleado){
        String jpql = "SELECT a FROM AsignacionHorario a WHERE "                
                + "a.empleado = :empleado OR "                
                + "EXISTS(SELECT d FROM DetalleGrupoHorario d WHERE d.empleado = :empleado AND d.grupoHorario = a.grupoHorario)";
        Map<String, Object> mapa = new HashMap<>();
        mapa.put("empleado", empleado);
        return this.getDao().buscar(jpql, mapa);
    }
    
    public List<AsignacionHorario> buscarXEmpleado(Empleado empleado, Date fechaInicio, Date fechaFin){
        String jpql = "SELECT a FROM AsignacionHorario a WHERE "                
                + "(a.fechaInicio BETWEEN :fechaInicio AND :fechaFin OR :fechaInicio BETWEEN a.fechaInicio AND a.fechaFin) AND "
                + "(a.empleado = :empleado OR "
                + "EXISTS(SELECT d FROM DetalleGrupoHorario d WHERE d.empleado = :empleado AND d.grupoHorario = a.grupoHorario))";
        Map<String, Object> mapa = new HashMap<>();
        mapa.put("empleado", empleado);
        mapa.put("fechaInicio", fechaInicio);
        mapa.put("fechaFin", fechaFin);
        return this.getDao().buscar(jpql, mapa);
    }
    
    public List<AsignacionHorario> buscarXEmpleado(List<Empleado> empleados ,Horario horario){
        List<DetalleGrupoHorario> detalleGrupo = dgc.buscarXEmpleados(empleados);
        List<GrupoHorario> grupos = new ArrayList<>();
        
        for(DetalleGrupoHorario detalle : detalleGrupo){
            grupos.add(detalle.getGrupoHorario());
        }
        
        String jpql = "SELECT a FROM AsignacionHorario a WHERE "
                + "(a.empleado IN :empleados OR a.grupo IN :grupos) AND a.horario = :horario";
        Map<String, Object> mapa = new HashMap<>();
        mapa.put("empleados", empleados);
        mapa.put("horario", horario);
        mapa.put("grupos", grupos);
        return this.getDao().buscar(jpql, mapa);
    }

}
