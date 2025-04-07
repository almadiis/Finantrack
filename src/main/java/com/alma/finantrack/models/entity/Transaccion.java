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
 private Long id;
 private Double monto;
 private Date fecha;
 private String descripcion;
 private String tipo; // ingreso o gasto

 
 @ManyToOne
 @JoinColumn(name = "cuenta_id")
 private Cuenta cuenta;
 
 @ManyToOne
 @JoinColumn(name = "categoria_id")
 private Categoria categoria;
}

