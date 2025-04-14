package com.alma.finantrack.models.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//Modelo Cuenta
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "cuentas")
public class Cuenta {
	
	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 private int id;
	 private String nombre;
	 private Double saldo;
	 private String tipo; // banco, efectivo, tarjeta
	
	 Cuenta(String nombre, Double saldo, String tipo) {
		 this.nombre = nombre;
		 this.saldo = saldo;
		 this.tipo = tipo;
	 }
	 Cuenta(){}
	 
	 
	 @ManyToOne
	 @JoinColumn(name = "usuario_id")
	 private Usuario usuario;
	 
	 @OneToMany(mappedBy = "cuenta", cascade = CascadeType.ALL)
	 private List<Transaccion> transacciones;
	 
	 
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
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	public List<Transaccion> getTransacciones() {
		return transacciones;
	}
	public void setTransacciones(List<Transaccion> transacciones) {
		this.transacciones = transacciones;
	}

}
