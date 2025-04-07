package com.alma.finantrack.models.dto;

import lombok.Data;

import java.util.Date;

@Data
public class PresupuestoDTO {
    private Long id;
    private Double montoMaximo;
    private String periodo;
    private Date fechaInicio;
    private Date fechaFin;
    private CategoriaDTO categoria;
}
