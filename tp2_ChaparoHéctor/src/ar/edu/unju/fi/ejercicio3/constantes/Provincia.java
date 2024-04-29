package ar.edu.unju.fi.ejercicio3.constantes;

public enum Provincia {
	JUJUY(1000000, 5000.0),
    SALTA(1500000, 7500.0),
    TUCUMAN(1200000, 6000.0),
    CATAMARCA(800000, 4000.0),
    LA_RIOJA(700000, 3500.0),
    SANTIAGO_DEL_ESTERO(1800000, 9000.0);
	
	
	private long cantidadPoblacion;
	private double superficie;
	
	private Provincia() {
		
	}
	
	private Provincia(long cantidadPoblacion, double superficie) {
		this.cantidadPoblacion = cantidadPoblacion;
		this.superficie = superficie;
	}
	
	
	
	public double calcularDensidadPoblacional() {
		return this.cantidadPoblacion / this.superficie;
	}


	public long getCantidadPoblacion() {
		return cantidadPoblacion;
	}


	public void setCantidadPoblacion(long cantidadPoblacion) {
		this.cantidadPoblacion = cantidadPoblacion;
	}


	public double getSuperficie() {
		return superficie;
	}


	public void setSuperficie(double superficie) {
		this.superficie = superficie;
	}
	
}
