package com.alma.finantrack.models.entity;

import java.sql.Date;
import jakarta.persistence.Column;
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

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "presupuestos")
public class Presupuesto {
  
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "categoria_id")
    private Categoria categoria;

    @Column(name = "monto_maximo")
    private Double montoMaximo;

    private String periodo; // mensual, semanal, diario

    @Column(name = "fecha_inicio")
    private Date fechaInicio;

    @Column(name = "fecha_fin")
    private Date fechaFin;
    
    Presupuesto(String periodo, Double montoMaximo, Date fechaInicio, Date fechaFin) {
		this.periodo = periodo;
		this.montoMaximo = montoMaximo;
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
    }
    Presupuesto() {}
    
    public int getId() {
  		return id;
  	}
  	public void setId(int id) {
  		this.id = id;
  	}
  	public Usuario getUsuario() {
  		return usuario;
  	}
  	public void setUsuario(Usuario usuario) {
  		this.usuario = usuario;
  	}
  	public Categoria getCategoria() {
  		return categoria;
  	}
  	public void setCategoria(Categoria categoria) {
  		this.categoria = categoria;
  	}
  	public Double getMontoMaximo() {
  		return montoMaximo;
  	}
  	public void setMontoMaximo(Double montoMaximo) {
  		this.montoMaximo = montoMaximo;
  	}
  	public String getPeriodo() {
  		return periodo;
  	}
  	public void setPeriodo(String periodo) {
  		this.periodo = periodo;
  	}
  	public Date getFechaInicio() {
  		return fechaInicio;
  	}
  	public void setFechaInicio(Date fechaInicio) {
  		this.fechaInicio = fechaInicio;
  	}
  	public Date getFechaFin() {
  		return fechaFin;
  	}
  	public void setFechaFin(Date fechaFin) {
  		this.fechaFin = fechaFin;
  	}
    	
}
