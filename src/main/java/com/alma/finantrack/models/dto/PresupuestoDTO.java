package com.alma.finantrack.models.dto;

import java.io.Serializable;
import java.util.Date;

import com.alma.finantrack.models.entity.Categoria;
import com.alma.finantrack.models.entity.Presupuesto;

import lombok.Data;

@Data
public class PresupuestoDTO implements Serializable {
    
	private static final long serialVersionUID = 1L;
	private int id;
    private Double montoMaximo;
    private String periodo;
    private Date fechaInicio;
    private Date fechaFin;
    private CategoriaDTO categoria;
    
    
    public PresupuestoDTO(int i, Double montoMaximo, String periodo, Date fechaInicio, Date fechaFin, CategoriaDTO categoria2) {	
		this.id = i;
		this.montoMaximo = montoMaximo;
		this.periodo = periodo;
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
		this.categoria = categoria2;
    }
    
    public PresupuestoDTO() {}
    
    public static PresupuestoDTO fromEntity(Presupuesto presupuesto) {
        Categoria categoria = presupuesto.getCategoria();
        CategoriaDTO categoriaDTO = new CategoriaDTO(
            categoria.getId(),
            categoria.getNombre(),
            categoria.getTipo()
        );

        return new PresupuestoDTO(
            presupuesto.getId(),
            presupuesto.getMontoMaximo(),
            presupuesto.getPeriodo(),
            presupuesto.getFechaInicio(),
            presupuesto.getFechaFin(),
            categoriaDTO
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

	public Date getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public Date getFechaFin() {
		return fechaFin;
	}

	public void setFechaFin(Date fechaFin) {
		this.fechaFin = fechaFin;
	}

	public CategoriaDTO getCategoria() {
		return categoria;
	}

	public void setCategoria(CategoriaDTO categoria) {
		this.categoria = categoria;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
