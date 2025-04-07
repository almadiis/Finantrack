package com.alma.finantrack.models.dto;

import lombok.Data;

import java.util.List;

@Data
public class CuentaDTO {
    private Long id;
    private String nombre;
    private String tipo;
    private Double saldo;
    private List<TransaccionDTO> transacciones;
}
