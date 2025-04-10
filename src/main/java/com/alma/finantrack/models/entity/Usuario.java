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
    private int id;
    
    private String nombre;

    @Column(name = "correo", unique = true, nullable = false)
    private String correo;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "fecha_registro")
    private LocalDateTime fechaRegistro;

    
    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL)
    private List<Cuenta> cuentas;
    
    // Constructor sin parámetros
    public Usuario() {}
    
    public Usuario(String nombre, String correo, String password) {
		this.nombre = nombre;
		this.correo = correo;
		this.password = password;
		this.fechaRegistro = LocalDateTime.now(); // Asignar fecha de registro al crear el usuario
	}
    
 // Getter para id
    public int getId() {
        return id;
    }

    // Setter para id
    public void setId(int id) {
        this.id = id;
    }

    // Getter para nombre
    public String getNombre() {
        return nombre;
    }

    // Setter para nombre
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    // Getter para correo
    public String getCorreo() {
        return correo;
    }

    // Setter para correo
    public void setCorreo(String correo) {
        this.correo = correo;
    }

    // Getter para password
    public String getPassword() {
        return password;
    }

    // Setter para password
    public void setPassword(String password) {
        this.password = password;
    }

    // Getter para fechaRegistro
    public LocalDateTime getFechaRegistro() {
        return fechaRegistro;
    }

    // Setter para fechaRegistro
    public void setFechaRegistro(LocalDateTime fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }
}