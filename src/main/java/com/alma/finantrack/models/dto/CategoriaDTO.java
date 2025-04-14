package com.alma.finantrack.models.dto;


import java.io.Serializable;
import com.alma.finantrack.models.entity.Categoria;
import lombok.Data;

@Data
public class CategoriaDTO implements Serializable{

	private static final long serialVersionUID = 1L;
	private int id;
    private String nombre;
    private String tipo;
    
    public CategoriaDTO(int id, String nombre, String tipo) {
		this.id = id;
		this.nombre = nombre;
		this.tipo = tipo;
    }
    
    public static CategoriaDTO fromEntity(Categoria categoria) {
        return new CategoriaDTO(
    		categoria.getId(),
    		categoria.getNombre(),
    		categoria.getTipo()
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
}
