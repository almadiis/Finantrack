package com.alma.finantrack.models.dto;

import com.alma.finantrack.models.entity.Transaccion;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TransaccionDTO {

    private int id;
    private Double monto;
    private String fecha;
    private String descripcion;
    private String tipo;
    
    
    public TransaccionDTO(int id, Double monto, String fecha, String descripcion, String tipo) {
		this.id = id;
		this.monto = monto;
		this.fecha = fecha;
		this.descripcion = descripcion;
		this.tipo = tipo;
	}
    
    public TransaccionDTO() {}
    // Crear un DTO a partir de una entidad Transacción
    public static TransaccionDTO fromEntity(Transaccion transaccion) {
        return new TransaccionDTO(
            transaccion.getId(),
            transaccion.getMonto(),
            transaccion.getFecha().toString(),
            transaccion.getDescripcion(),
            transaccion.getTipo()
        );
    }
}
