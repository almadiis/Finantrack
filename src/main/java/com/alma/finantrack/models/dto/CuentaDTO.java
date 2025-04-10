package com.alma.finantrack.models.dto;

import com.alma.finantrack.models.entity.Cuenta;

import lombok.Data;

@Data
public class CuentaDTO {

    private int id;
    private String nombre;
    private Double saldo;
    private String tipo;

    public CuentaDTO() {
	}

	public CuentaDTO(int id, String nombre, Double saldo, String tipo) {
		this.id = id;
		this.nombre = nombre;
		this.saldo = saldo;
		this.tipo = tipo;
	}

	public static CuentaDTO fromEntity(Cuenta cuenta) {
        return new CuentaDTO(
            cuenta.getId(),
            cuenta.getNombre(),
            cuenta.getSaldo(),
            cuenta.getTipo()
        );
    }
}