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


	public UsuarioDTO(int id2, String nombre2, String correo2) {
		this.id = id2;
		this.nombre = nombre2;
		this.correo = correo2;	
	}


	public static UsuarioDTO fromEntity(Usuario usuario) {
        return new UsuarioDTO(
        	usuario.getId(),
			usuario.getNombre(),
			usuario.getCorreo()	
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


}
