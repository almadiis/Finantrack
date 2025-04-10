package com.alma.finantrack.models.dto;

import java.util.Date;

import com.alma.finantrack.models.entity.Categoria;
import com.alma.finantrack.models.entity.Presupuesto;

import lombok.Data;

@Data

public class PresupuestoDTO {
    private int id;
    private Double montoMaximo;
    private String periodo;
    private Date fechaInicio;
    private Date fechaFin;
    private Categoria categoria;
    
    
    public PresupuestoDTO(int i, Double montoMaximo, String periodo, Date fechaInicio, Date fechaFin, Categoria categoria2) {	
		this.id = i;
		this.montoMaximo = montoMaximo;
		this.periodo = periodo;
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
		this.categoria = categoria2;
    }
    
    public PresupuestoDTO() {}
    
    public static PresupuestoDTO fromEntity(Presupuesto presupuesto) {
		return new PresupuestoDTO(
			presupuesto.getId(),
			presupuesto.getMontoMaximo(),
			presupuesto.getPeriodo(),
			presupuesto.getFechaInicio(),
			presupuesto.getFechaFin(),
			presupuesto.getCategoria()
		);
	}
}
