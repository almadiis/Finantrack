package com.alma.finantrack.models.dto;

import java.io.Serializable;

import com.alma.finantrack.models.entity.Usuario;

import lombok.Data;

@Data
public class UsuarioDTO implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private int id;
    private String nombre;
    private String correo;
    private String password;


	public UsuarioDTO(int id2, String nombre2, String correo2, String password2) {
		this.id = id2;
		this.nombre = nombre2;
		this.correo = correo2;	
		this.password = password2;
	}


	public static UsuarioDTO fromEntity(Usuario usuario) {
        return new UsuarioDTO(
        	usuario.getId(),
			usuario.getNombre(),
			usuario.getCorreo(),
			usuario.getPassword()
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


	public String getCorreo() {
		return correo;
	}


	public void setCorreo(String correo) {
		this.correo = correo;
	}
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

}
