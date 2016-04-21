package com.biosis.biosislite.entidades;

import com.biosis.biosislite.entidades.escalafon.Empleado;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Vacacion implements Serializable {

    @Column(unique = false, updatable = true, insertable = true, nullable = true, length = 255, scale = 0, precision = 0)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "fecha_interrupcion", unique = false, updatable = true, insertable = true, nullable = true, length = 255, scale = 0, precision = 0)
    @Temporal(TemporalType.DATE)
    @Basic
    private Date fechaInterrupcion;
    @ManyToOne(targetEntity = Empleado.class)
    @JoinColumn(name = "persona_nro_documento",referencedColumnName = "nro_documento")
    private Empleado empleado;
    @Column(unique = false, updatable = true, insertable = true, nullable = true, length = 255, scale = 0, precision = 0)
    @Basic
    private String documento;
    @Column(name = "hay_interrupcion", unique = false, updatable = true, insertable = true, nullable = false, length = 255, scale = 0, precision = 0)
    @Basic
    private boolean hayInterrupcion;
    @Column(name = "fecha_fin", unique = false, updatable = true, insertable = true, nullable = false, length = 255, scale = 0, precision = 0)
    @Temporal(TemporalType.DATE)
    @Basic
    private Date fechaFin;
    @ManyToOne(optional = false, targetEntity = Periodo.class)
    @JoinColumn(name = "periodo_anio", referencedColumnName = "anio", insertable = true, nullable = false, unique = false, updatable = true)
    private Periodo periodo;
    @Column(name = "fecha_inicio", unique = false, updatable = true, insertable = true, nullable = false, length = 255, scale = 0, precision = 0)
    @Temporal(TemporalType.DATE)
    @Basic
    private Date fechaInicio;

    /*
     PROPIEDADES PARA TRABAJAR CON REPOGRAMACION DE VACACIONES
     */
    @Column(name = "hay_reprogramacion")
    private boolean hayReprogramacion;
    @JoinColumn(name="vacacion_id",referencedColumnName="id",nullable = true)
    @OneToOne(optional = true, targetEntity = Vacacion.class)
    private Vacacion vacacionOrigen;
    @OneToOne(mappedBy = "vacacionOrigen", targetEntity = Vacacion.class, cascade = CascadeType.ALL, orphanRemoval = true)
    private Vacacion vacacionReprogramacion;
    @Column(name = "documento_reprogramacion")
    private String documentoReprogramacion;
    @OneToOne(mappedBy = "vacacion",cascade = CascadeType.ALL,orphanRemoval = true,optional = true)
    private InterrupcionVacacion interrupcionVacacion;

    public InterrupcionVacacion getInterrupcionVacacion() {
        return interrupcionVacacion;
    }

    public void setInterrupcionVacacion(InterrupcionVacacion interrupcionVacacion) {
        this.interrupcionVacacion = interrupcionVacacion;
    }

    public Vacacion getVacacionReprogramacion() {
        return vacacionReprogramacion;
    }

    public void setVacacionReprogramacion(Vacacion vacacionReprogramacion) {
        this.vacacionReprogramacion = vacacionReprogramacion;
    }

    public boolean isHayReprogramacion() {
        return hayReprogramacion;
    }

    public void setHayReprogramacion(boolean hayReprogramacion) {
        this.hayReprogramacion = hayReprogramacion;
    }

    public Vacacion getVacacionOrigen() {
        return vacacionOrigen;
    }

    public void setVacacionOrigen(Vacacion vacacionOrigen) {
        this.vacacionOrigen = vacacionOrigen;
    }

    public String getDocumentoReprogramacion() {
        return documentoReprogramacion;
    }

    public void setDocumentoReprogramacion(String documentoReprogramacion) {
        this.documentoReprogramacion = documentoReprogramacion;
    }
    
    

    public Vacacion() {

    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getFechaInterrupcion() {
        return this.fechaInterrupcion;
    }

    public void setFechaInterrupcion(Date fechaInterrupcion) {
        this.fechaInterrupcion = fechaInterrupcion;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    public String getDocumento() {
        return this.documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public boolean isHayInterrupcion() {
        return this.hayInterrupcion;
    }

    public void setHayInterrupcion(boolean hayInterrupcion) {
        this.hayInterrupcion = hayInterrupcion;
    }

    public Date getFechaFin() {
        return this.fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    public Periodo getPeriodo() {
        return this.periodo;
    }

    public void setPeriodo(Periodo periodo) {
        this.periodo = periodo;
    }

    public Date getFechaInicio() {
        return this.fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }
}
