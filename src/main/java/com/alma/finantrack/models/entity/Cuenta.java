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

//Modelo Cuenta
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "cuentas")
public class Cuenta {
 @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
 private Long id;
 private String nombre;
 private Double saldo;
 private String tipo; // banco, efectivo, tarjeta

 
 @ManyToOne
 @JoinColumn(name = "usuario_id")
 private Usuario usuario;
 
 @OneToMany(mappedBy = "cuenta", cascade = CascadeType.ALL)
 private List<Transaccion> transacciones;
}
