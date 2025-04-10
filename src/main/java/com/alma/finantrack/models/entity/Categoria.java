package com.alma.finantrack.models.entity;

import java.util.List;

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

//Modelo Categoria
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "categorias")
public class Categoria {
	
	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 private int id;
	 private String nombre;
	 
	 @ManyToOne
	 @JoinColumn(name = "usuario_id")
	 private Usuario usuario;
	
	 private String tipo; // ingreso o gasto
	
	 @OneToMany(mappedBy = "categoria", cascade = CascadeType.ALL)
	 private List<Transaccion> transacciones;
	 
	 
	 public Categoria(String nombre, String tipo, Usuario usuario) {
		 this.nombre = nombre;
		 this.tipo = tipo;
		 this.usuario = usuario;
	}	
	Categoria(){}
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
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public List<Transaccion> getTransacciones() {
		return transacciones;
	}
	public void setTransacciones(List<Transaccion> transacciones) {
		this.transacciones = transacciones;
	}
} 