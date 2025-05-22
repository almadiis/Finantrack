package com.alma.finantrack.models.dto;

import java.io.Serializable;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.alma.finantrack.models.entity.Categoria;
import com.alma.finantrack.models.entity.Presupuesto;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

@Data
public class PresupuestoDTO implements Serializable {
    
	private static final long serialVersionUID = 1L;
	private int id;
    private Double montoMaximo;
    private String periodo;
    private String fechaInicio;
    private String fechaFin;
    @JsonProperty("id_categoria")
    private int categoria;
    @JsonProperty("id_usuario")
    private int id_usuario;
    
    
    public PresupuestoDTO(int i, Double montoMaximo, String periodo, String fechaInicio, String fechaFin, int categoria2, int id_usuario) {	
		this.id = i;
		this.montoMaximo = montoMaximo;
		this.periodo = periodo;
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
		this.categoria = categoria2;
		this.id_usuario = id_usuario;
    }
    
    public PresupuestoDTO() {}
    
    public static PresupuestoDTO fromEntity(Presupuesto presupuesto) {

        return new PresupuestoDTO(
            presupuesto.getId(),
            presupuesto.getMontoMaximo(),
            presupuesto.getPeriodo(),
            presupuesto.getFechaInicio().toString(),
            presupuesto.getFechaFin().toString(),
            presupuesto.getCategoria().getId(),
            presupuesto.getUsuario().getId()
        );
    }


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Double getMontoMaximo() {
		return montoMaximo;
	}

	public void setMontoMaximo(Double montoMaximo) {
		this.montoMaximo = montoMaximo;
	}

	public String getPeriodo() {
		return periodo;
	}

	public void setPeriodo(String periodo) {
		this.periodo = periodo;
	}

	public String getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(String fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public String getFechaFin() {
		return fechaFin;
	}

	public void setFechaFin(String fechaFin) {
		this.fechaFin = fechaFin;
	}
	public int getCategoria() {
		return categoria;
	}
	public void setCategoria(int categoria) {
		this.categoria = categoria;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public int getId_usuario() {
		return id_usuario;
	}

	public void setId_usuario(int id_usuario) {
		this.id_usuario = id_usuario;
	}
}
