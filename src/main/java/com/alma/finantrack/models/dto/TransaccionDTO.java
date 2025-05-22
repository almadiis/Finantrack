package com.alma.finantrack.models.dto;

import java.io.Serializable;
import com.alma.finantrack.models.entity.Transaccion;
import lombok.Data;
import com.fasterxml.jackson.annotation.JsonProperty;

@Data
public class TransaccionDTO implements Serializable{

	private static final long serialVersionUID = 1L;
	private int id;
	private Double monto;
    private String fecha;
    private String descripcion;
    private String tipo;
    @JsonProperty("id_categoria")
    private int id_categoria;
    @JsonProperty("id_cuenta")
    private int id_cuenta;
    
    
    public TransaccionDTO(int id, Double monto, String fecha, String descripcion, String tipo, int id_cuenta, int id_categoria) {
		this.id = id;
		this.monto = monto;
		this.fecha = fecha;
		this.descripcion = descripcion;
		this.tipo = tipo;
		this.id_cuenta = id_cuenta;
		this.id_categoria = id_categoria;
	}
    
    public TransaccionDTO() {}
    
    
    // Crear un DTO a partir de una entidad Transacción
    public static TransaccionDTO fromEntity(Transaccion transaccion) {
        TransaccionDTO dto = new TransaccionDTO();
        dto.setId(transaccion.getId());
        dto.setMonto(transaccion.getMonto());
        dto.setFecha(transaccion.getFecha().toString());
        dto.setDescripcion(transaccion.getDescripcion());
        dto.setTipo(transaccion.getTipo());
        dto.setId_cuenta(transaccion.getCuenta().getId());
        dto.setId_categoria(transaccion.getCategoria().getId());
        return dto;
    }


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Double getMonto() {
		return monto;
	}

	public void setMonto(Double monto) {
		this.monto = monto;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
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
    public int getId_categoria() {
    	return id_categoria;
    }
	public void setId_categoria(int id_categoria) {
			this.id_categoria = id_categoria;
	}

	public int getId_cuenta() {
		return id_cuenta;
	}

	public void setId_cuenta(int id_cuenta) {
		this.id_cuenta = id_cuenta;
	}

}
