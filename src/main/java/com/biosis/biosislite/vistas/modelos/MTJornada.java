/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.biosis.biosislite.vistas.modelos;

import com.biosis.biosislite.entidades.Jornada;
import com.personal.utiles.ModeloTabla;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;
import org.apache.log4j.Logger;

/**
 *
 * @author fesquivelc
 */
public class MTJornada extends ModeloTabla<Jornada>{

    private final DateFormat dtHora;
    public MTJornada(List<Jornada> datos, String[] nombreColumnas) {
        super(datos, nombreColumnas);
        dtHora = new SimpleDateFormat("HH:mm");
    }
    private static final Logger LOG = Logger.getLogger(MTJornada.class.getName());

    
    
    @Override
    public Object getValorEn(int rowIndex, int columnIndex) {
        Jornada jornada = this.datos.get(rowIndex);
        
        switch(columnIndex){
            case 0:
                return jornada.getCodigo();
            case 1:
                return jornada.getNombre();
            case 2:
                return jornada.getDescripcion();
            default:
                return null;
        }
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        return String.class; //To change body of generated methods, choose Tools | Templates.
    }
}
