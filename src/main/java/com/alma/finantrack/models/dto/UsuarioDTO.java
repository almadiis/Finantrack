package com.alma.finantrack.models.dto;

import com.alma.finantrack.models.entity.Usuario;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioDTO {

    private int id;
    private String nombre;
    private String correo;

    
    public UsuarioDTO(int id2, String nombre2, String correo2) {
    	this.id = id2;
    	this.nombre = nombre2;
    	this.correo = correo2;
	}
    
	public UsuarioDTO() {}

	public static UsuarioDTO fromEntity(Usuario usuario) {
        return new UsuarioDTO(
            usuario.getId(),
            usuario.getNombre(),
            usuario.getCorreo()
        );
    }
}
