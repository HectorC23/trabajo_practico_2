package ar.edu.unju.fi.ejercicio2.model;

public class Efemeride {
	
	
	private String codigo;
	private Mes mes;
	private byte dia;
	private String detalle;
	
	public enum Mes{
		ENERO, FEBRERO, MARZO, ABRIL, MAYO, JUNIO, JULIO, AGOSTO, SEPTIEMBRE, OCTUBRE, NOVIEMBRE, DICIEMBRE;
	}
	
	public Efemeride() {
		
	}

	public Efemeride(String codigo, Mes mes, byte dia, String detalle) {
		super();
		this.codigo = codigo;
		this.mes = mes;
		this.dia = dia;
		this.detalle = detalle;
	}

	@Override
	public String toString() {
		return "Efemeride [codigo=" + codigo + ", mes=" + mes + ", dia=" + dia + ", detalle=" + detalle + "]";
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public Mes getMes() {
		return mes;
	}

	public void setMes(Mes mes) {
		this.mes = mes;
	}

	public byte getDia() {
		return dia;
	}

	public void setDia(byte dia) {
		this.dia = dia;
	}

	public String getDetalle() {
		return detalle;
	}

	public void setDetalle(String detalle) {
		this.detalle = detalle;
	}
	
	
	
	
	

}
