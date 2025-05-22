package com.alma.finantrack.models.dto;
import lombok.Data;

@Data
public class LoginDTO{
 private String nombre;
 private String password;

 // Getters y setters
 public String getNombre() { return nombre; }
 public void setNombre(String nombre) { this.nombre = nombre; }

 public String getPassword() { return password; }
 public void setPassword(String password) { this.password = password; }
}
