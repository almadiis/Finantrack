package com.alma.finantrack.models.dto;

import lombok.Data;

import java.util.List;

@Data
public class UsuarioDTO {
    private Long id;
    private String nombre;
    private String email;
    private List<CuentaDTO> cuentas;
}
