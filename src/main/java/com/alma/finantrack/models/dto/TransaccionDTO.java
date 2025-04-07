package com.alma.finantrack.models.dto;


import lombok.Data;

import java.util.Date;

@Data
public class TransaccionDTO {
    private Long id;
    private Double monto;
    private String tipo;
    private String descripcion;
    private Date fecha;
    private CategoriaDTO categoria;
}

