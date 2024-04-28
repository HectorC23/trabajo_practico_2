package ar.edu.unju.fi.ejercicio1.model;

public class Producto {
	
	private String codigo;
	private String Descripcion;
	private double precioUnidad;
	private Origen origenFabricacion;
	private Categoria categoria;
	
	public enum Origen{
		ARGENTINA, CHINA, BRASIL, URUGUAY;
	}
	public enum Categoria{
		TELEFONIA, INFORMATICA, ELECTROHOGAR, HERRAMIENTAS;
	}
	
	
	public Producto() {
		
	}
	
	public Producto(String codigo, String descripcion, double precioUnidad, Origen origenFabricacion,
			Categoria catego) {
		super();
		this.codigo = codigo;
		Descripcion = descripcion;
		this.precioUnidad = precioUnidad;
		this.origenFabricacion = origenFabricacion;
		this.categoria = catego;
	}
	
	
	
	
	@Override
	public String toString() {
		return "Producto [codigo=" + codigo + ", Descripcion=" + Descripcion + ", precioUnidad=" + precioUnidad
				+ ", origenFabricacion=" + origenFabricacion + ", catego=" + categoria + "]";
	}

	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public String getDescripcion() {
		return Descripcion;
	}
	public void setDescripcion(String descripcion) {
		Descripcion = descripcion;
	}
	public double getPrecioUnidad() {
		return precioUnidad;
	}
	public void setPrecioUnidad(double precioUnidad) {
		this.precioUnidad = precioUnidad;
	}
	public Origen getOrigenFabricacion() {
		return origenFabricacion;
	}
	public void setOrigenFabricacion(Origen origenFabricacion) {
		this.origenFabricacion = origenFabricacion;
	}
	public Categoria getCatego() {
		return categoria;
	}
	public void setCatego(Categoria catego) {
		this.categoria = catego;
	}

}
