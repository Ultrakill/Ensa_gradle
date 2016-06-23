/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.biosis.biosislite.controladores;

import com.biosis.biosislite.entidades.escalafon.Departamento;
import com.biosis.biosislite.entidades.escalafon.Empleado;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author fesquivelc
 */
public class DepartamentoControlador extends Controlador<Departamento>{
    
    private DepartamentoControlador() {
        super(Departamento.class);
    }
    public List<Departamento> buscarXNombre(String patron){
        String jpql = "SELECT d FROM Departamento d WHERE UPPER(d.nombre) LIKE CONCAT('%',UPPER(:patron),'%')";
        Map<String,Object> param = new HashMap<>();
        param.put("patron", patron);
        
        return this.getDao().buscar(jpql, param);
    }
    
    public List<Departamento> buscarXJerarquia(){
        String jpql = "SELECT d FROM Departamento d WHERE d.departamento IS NULL";                
        return this.getDao().buscar(jpql);
    }
    
    public static DepartamentoControlador getInstance() {
        return DepartamentoControladorHolder.INSTANCE;
    }
    
    private static class DepartamentoControladorHolder {

        private static final DepartamentoControlador INSTANCE = new DepartamentoControlador();
    }
    
    public Departamento buscarXJefe(Empleado empleado){
        String jpql = "SELECT d FROM Departamento d WHERE d.empleado = :empleado";                
        Map<String,Object> param = new HashMap<>();
        param.put("empleado", empleado);
        
        return this.getDao().buscar(jpql, param).get(0);
    }
}
