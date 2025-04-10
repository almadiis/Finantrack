package com.alma.finantrack.models.dto;


import com.alma.finantrack.models.entity.Cuenta;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CategoriaDTO {
    private int id;
    private String nombre;
    private String tipo;
    
    public CategoriaDTO(int id, String nombre, String tipo) {
		this.id = id;
		this.nombre = nombre;
		this.tipo = tipo;
    }
    public CategoriaDTO() {}
    
    public static CategoriaDTO fromEntity(Cuenta cuenta) {
        return new CategoriaDTO(
            cuenta.getId(),
            cuenta.getNombre(),
            cuenta.getTipo()
        );
    }
}
