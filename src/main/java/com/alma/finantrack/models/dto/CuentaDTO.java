package com.alma.finantrack.models.dto;

import java.io.Serializable;
import com.alma.finantrack.models.entity.Cuenta;
import lombok.Data;


@Data
public class CuentaDTO implements Serializable{


	private static final long serialVersionUID = 1L;
	private int id;
    private String nombre;
    private Double saldo;
    private String tipo;

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

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Double getSaldo() {
		return saldo;
	}

	public void setSaldo(Double saldo) {
		this.saldo = saldo;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
}