package com.alma.finantrack.models.entity;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//Modelo Transaccion
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "transacciones")
public class Transaccion {
	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 private int id;
	 private Double monto;
	 private Date fecha;
	 private String descripcion;
	 private String tipo; // ingreso o gasto
	
	 Transaccion() {
	 }
	 
	 public Transaccion(int id, Double monto, Date fecha, String descripcion, String tipo) {
		 this.id = id;
		 this.monto = monto;
		 this.fecha = fecha;
		 this.descripcion = descripcion;
		 this.tipo = tipo;
	 }
	 @ManyToOne
	 @JoinColumn(name = "cuenta_id")
	 private Cuenta cuenta;
	 
	 @ManyToOne
	 @JoinColumn(name = "categoria_id")
	 private Categoria categoria;
	 

	 public int getId() {
		 return id;
	 }
	 public void setId(int id) {
		 this.id = id;
	 }
	 
	 public Double getMonto() {
		 return monto;
	 }
	 public void setMonto(Double monto) {
		 this.monto = monto;
	 }
	 
	 public Date getFecha() {
		 return fecha;
	 }
	 public void setFecha(Date fecha) {
		 this.fecha = fecha;
	 }
	 public String getDescripcion() {
		 return descripcion;
	 }
	 public void setDescripcion(String descripcion) {
		 this.descripcion = descripcion;
	 }
	 public String getTipo() {
		 return tipo;
	 }
	 public void setTipo(String tipo) {
		 this.tipo = tipo;
	 }
	 public Cuenta getCuenta() {
		 return cuenta;
	 }
	 public void setCuenta(Cuenta cuenta) {
		 this.cuenta = cuenta;
	 }
	 public Categoria getCategoria() {
		 return categoria;
	 }
	 public void setCategoria(Categoria categoria) {
		 this.categoria = categoria;
	 }
	 
}

