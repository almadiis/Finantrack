package com.alma.finantrack.models.dto;

import java.io.Serializable;
import com.alma.finantrack.models.entity.Transaccion;
import lombok.Data;

@Data
public class TransaccionDTO implements Serializable{

	private static final long serialVersionUID = 1L;
	private int id;
	private Double monto;
    private String fecha;
    private String descripcion;
    private String tipo;
    private String cuentaNombre;
    private String categoriaNombre;
    
    
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
        TransaccionDTO dto = new TransaccionDTO();
        dto.setId(transaccion.getId());
        dto.setMonto(transaccion.getMonto());
        dto.setFecha(transaccion.getFecha().toString());
        dto.setDescripcion(transaccion.getDescripcion());
        dto.setTipo(transaccion.getTipo());
        dto.setCuentaNombre(transaccion.getCuenta().getNombre());
        dto.setCategoriaNombre(transaccion.getCategoria().getNombre());
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

	public String getCategoriaNombre() {
		return categoriaNombre;
	}

	public void setCategoriaNombre(String categoriaNombre) {
		this.categoriaNombre = categoriaNombre;
	}

	public String getCuentaNombre() {
		return cuentaNombre;
	}

	public void setCuentaNombre(String cuentaNombre) {
		this.cuentaNombre = cuentaNombre;
	}

}
