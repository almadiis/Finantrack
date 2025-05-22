package com.alma.finantrack.models.dto;


import java.io.Serializable;
import com.alma.finantrack.models.entity.Categoria;
import lombok.Data;

@Data
public class CategoriaDTO implements Serializable{

	public String getIcono() {
		return icono;
	}

	public void setIcono(String icono) {
		this.icono = icono;
	}

	public String getColorHex() {
		return colorHex;
	}

	public void setColorHex(String colorHex) {
		this.colorHex = colorHex;
	}
	private static final long serialVersionUID = 1L;
	private int id;
    private String nombre;
    private String tipo;
    private String icono;
    private String colorHex;
    private Integer usuarioId;

    public CategoriaDTO(int id, String nombre, String tipo, String icono, String colorHex, Integer usuarioId) {
    	this.id = id;
    	this.nombre = nombre;
    	this.tipo = tipo;
    	this.icono = icono;
    	this.colorHex = colorHex;
    	this.usuarioId = usuarioId;
    }

    public static CategoriaDTO fromEntity(Categoria categoria) {
    	return new CategoriaDTO(
    		categoria.getId(),
    		categoria.getNombre(),
    		categoria.getTipo(),
    		categoria.getIcono(),
    		categoria.getColorHex(),
    		categoria.getUsuario() != null ? categoria.getUsuario().getId() : null
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
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Integer getUsuarioId() {
		return usuarioId;
	}

	public void setUsuarioId(Integer usuarioId) {
		this.usuarioId = usuarioId;
	}
}
