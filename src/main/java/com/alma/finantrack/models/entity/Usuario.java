package com.alma.finantrack.models.entity;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

// Modelo Usuario
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "usuarios")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @NotNull(message = "El nombre no puede ser nulo")
    private String nombre;

    @Column(name = "correo", unique = true, nullable = false)
    private String correo;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "fecha_registro")
    private LocalDateTime fechaRegistro;

    
    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL)
    private List<Cuenta> cuentas;
}