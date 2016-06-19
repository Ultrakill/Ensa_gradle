/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.biosis.biosislite.controladores;

import com.biosis.biosislite.entidades.AsignacionPermiso;
import com.biosis.biosislite.entidades.TipoPermiso;
import com.biosis.biosislite.entidades.escalafon.Empleado;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author fesquivelc
 */
public class AsignacionPermisoControlador extends Controlador<AsignacionPermiso> {

    public AsignacionPermisoControlador() {
        super(AsignacionPermiso.class);
    }

    public List<AsignacionPermiso> buscarXEmpleadoXFecha(Empleado dni, Date fechaInicio, Date fechaFin, int desde, int tamanio) {
        String jpql = "SELECT a FROM AsignacionPermiso a WHERE a.empleado = :dni AND a.permiso.fechaInicio BETWEEN :fechaInicio AND :fechaFin ORDER BY a.permiso.fechaInicio";
        Map<String, Object> mapa = new HashMap<>();
        mapa.put("dni", dni);
        mapa.put("fechaInicio", fechaInicio);
        mapa.put("fechaFin", fechaFin);
        return this.getDao().buscar(jpql, mapa, desde, tamanio);
    }

    public List<AsignacionPermiso> buscarXFecha(Date fechaInicio, Date fechaFin, int desde, int tamanio) {
        String jpql = "SELECT a FROM AsignacionPermiso a WHERE a.permiso.fechaInicio BETWEEN :fechaInicio AND :fechaFin ORDER BY a.permiso.fechaInicio";
        Map<String, Object> mapa = new HashMap<>();
        mapa.put("fechaInicio", fechaInicio);
        mapa.put("fechaFin", fechaFin);
        return this.getDao().buscar(jpql, mapa, desde, tamanio);
    }

    //Query para comprobacion de permisos en rango de fecha
    public List<AsignacionPermiso> buscarXFechaDni(Empleado empleado,Date fechaInicio){
        String jpl = "SELECT a FROM AsignacionPermiso a WHERE a.empleado = :dni AND :fechaInicio BETWEEN a.permiso.fechaInicio and a.permiso.fechaFin ";
        Map<String, Object> mapa = new HashMap<>();
        mapa.put("dni", empleado);
        mapa.put("fechaInicio", fechaInicio);
        return this.getDao().buscar(jpl, mapa);
    }
    
    public int contarXEmpleadoEntreFechaPorFecha(Empleado empleado,Date fechaInicio, Date fechaFin){
        String jpl = "SELECT COUNT(a) FROM AsignacionPermiso a WHERE "
                + "a.empleado = :dni AND "
                + "a.permiso.opcion = 'F' AND "
                + "("
                + "(a.permiso.fechaInicio >= :fechaInicio AND a.permiso.fechaInicio <= :fechaFin) OR "
                + "(a.permiso.fechaInicio <= :fechaInicio AND a.permiso.fechaFin >= :fechaInicio)"
                + ")";
        Map<String, Object> mapa = new HashMap<>();
        mapa.put("dni", empleado);
        mapa.put("fechaInicio", fechaInicio);
        mapa.put("fechaFin", fechaFin);
        int conteo = this.getDao().contar(jpl, mapa);
        return conteo;
    }
    
    //Query para comprobacion de permisos en rango de hora
    public List<AsignacionPermiso> buscarXHora(Empleado empleado, Date fecha){
        String jpl = "SELECT a FROM AsignacionPermiso a WHERE a.empleado = :dni AND a.permiso.opcion = 'H' AND a.permiso.fechaInicio = :fecha";
        Map<String, Object> mapa = new HashMap<>();
        mapa.put("dni", empleado);
        mapa.put("fecha", fecha);
        return this.getDao().buscar(jpl, mapa);
    }
    
     public List<AsignacionPermiso> buscarXHoraxFecha(Empleado empleado, Date horaInicio, Date fecha){
        String jpl = "SELECT a FROM AsignacionPermiso a WHERE a.empleado = :dni AND a.permiso.fechaInicio = :fecha AND :horaInicio BETWEEN a.permiso.horaInicio and a.permiso.horaFin ";
        Map<String, Object> mapa = new HashMap<>();
        mapa.put("dni", empleado);
        mapa.put("fecha", fecha);
        mapa.put("horaInicio", horaInicio);
        return this.getDao().buscar(jpl, mapa);
    }
    public int contarXEmpleadoXFecha(Empleado dni, Date fechaInicio, Date fechaFin) {
        String jpql = "SELECT COUNT(a.id) FROM AsignacionPermiso a WHERE a.empleado = :dni AND a.permiso.fechaInicio BETWEEN :fechaInicio AND :fechaFin";
        Long cont = (Long) this.getDao().getEntityManager().createQuery(jpql)
                .setParameter("dni", dni)
                .setParameter("fechaInicio", fechaInicio)
                .setParameter("fechaFin", fechaFin).getSingleResult();
        int conteo = cont.intValue();
        return conteo;
    }

    public int contarXFecha(Date fechaInicio, Date fechaFin) {
        String jpql = "SELECT COUNT(a.id) FROM AsignacionPermiso a WHERE a.permiso.fechaInicio BETWEEN :fechaInicio AND :fechaFin";
        Long cont = (Long) this.getDao().getEntityManager().createQuery(jpql)
                .setParameter("fechaInicio", fechaInicio)
                .setParameter("fechaFin", fechaFin).getSingleResult();
        int conteo = cont.intValue();
        System.out.println("CONTEO"+conteo);
        return conteo;
    }
    
    public AsignacionPermiso buscarXDia(Empleado empleado, Date dia){
        String jpql = "SELECT a FROM AsignacionPermiso a WHERE a.empleado = :dni AND a.permiso.porFecha = TRUE AND :dia BETWEEN a.permiso.fechaInicio AND a.permiso.fechaFin";
        Map<String, Object> mapa = new HashMap<>();
        mapa.put("dia", dia);
        mapa.put("dni", empleado);
        List<AsignacionPermiso> asignacion = this.getDao().buscar(jpql, mapa, -1, 1);
        if(asignacion.isEmpty()){
            return null;
        }else{
            return asignacion.get(0);
        }        
    }

    public List<AsignacionPermiso> obtenerPermisosXHora(Empleado empleado, Date fecha, Date horaI, Date horaF) {
        String jpql = "SELECT a FROM AsignacionPermiso a WHERE "
                + "a.empleado = :dni AND "
                + "a.permiso.fechaInicio = :fecha AND "
                + "a.permiso.horaInicio BETWEEN :horaI AND :horaF";
        Map<String, Object> mapa = new HashMap<>();
        mapa.put("dni", empleado);
        mapa.put("fecha", fecha);
        mapa.put("horaI", horaI);
        mapa.put("horaF", horaF);
        return this.getDao().buscar(jpql, mapa);
    }
    
    public List<AsignacionPermiso> buscarXEmpleadoXFechaxTipo(Empleado dni, Date fechaInicio, Date fechaFin, TipoPermiso tipo) {
        String jpql = "SELECT a FROM AsignacionPermiso a WHERE a.empleado = :dni AND a.permiso.fechaInicio BETWEEN :fechaInicio AND :fechaFin "
                + " AND a.permiso.tipoPermiso = :tipo  ORDER BY a.permiso.fechaInicio";
        Map<String, Object> mapa = new HashMap<>();
        mapa.put("dni", dni);
        mapa.put("fechaInicio", fechaInicio);
        mapa.put("fechaFin", fechaFin);
        mapa.put("tipo", tipo);
        return this.getDao().buscar(jpql, mapa);
    }
    
    public List<AsignacionPermiso> buscarXEmpleadoXFechaxDescuento(Empleado dni, Date fechaInicio, Date fechaFin, char tipo) {
        String jpql = "SELECT a FROM AsignacionPermiso a WHERE a.empleado = :dni AND a.permiso.fechaInicio BETWEEN :fechaInicio AND :fechaFin  "
                + " AND a.permiso.tipoPermiso.tipoDescuento = :tipo ORDER BY a.permiso.fechaInicio";
        Map<String, Object> mapa = new HashMap<>();
        mapa.put("dni", dni);
        mapa.put("fechaInicio", fechaInicio);
        mapa.put("fechaFin", fechaFin);
        mapa.put("tipo", tipo);
        return this.getDao().buscar(jpql, mapa);
    }
    
    public List<AsignacionPermiso> buscarXEmpleadoXFecha(Empleado dni, Date fechaInicio, Date fechaFin) {
        String jpql = "SELECT a FROM AsignacionPermiso a WHERE a.empleado = :dni AND a.permiso.fechaInicio BETWEEN :fechaInicio AND :fechaFin ORDER BY a.permiso.fechaInicio";
        Map<String, Object> mapa = new HashMap<>();
        mapa.put("dni", dni);
        mapa.put("fechaInicio", fechaInicio);
        mapa.put("fechaFin", fechaFin);
        return this.getDao().buscar(jpql, mapa);
    }
}
