package ar.edu.unju.fi.ejercicio5.model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import ar.edu.unju.fi.ejercicio5.interfaces.Pago;

public class PagoEfectivo implements Pago  {
	
	private double montoPagado;
	private LocalDate fechaPago;
	
	public PagoEfectivo() {
		
	}
	
	

	public PagoEfectivo(double montoPagado, LocalDate fechaPago) {
		super();
		this.montoPagado = montoPagado;
		this.fechaPago = fechaPago;
	}



	@Override
	public String toString() {
		return "PagoEfectivo [montoPagado=" + montoPagado + ", fechaPago=" + fechaPago + "]";
	}



	@Override
	public void realizarPago(double monto) {
		this.montoPagado = (monto *0.9);
		
	}

	@Override
	public void imprimirRecibo() {
		
		this.fechaPago = LocalDate.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yy");
		String fechaFormateada = this.fechaPago.format(formatter);
		
		System.out.println("Fecha de pago: "+fechaFormateada);
		System.out.println("Monto pagado: " + montoPagado);

	}



	public double getMontoPagado() {
		return montoPagado;
	}



	public void setMontoPagado(double montoPagado) {
		this.montoPagado = montoPagado;
	}



	public LocalDate getFechaPago() {
		return fechaPago;
	}



	public void setFechaPago(LocalDate fechaPago) {
		this.fechaPago = fechaPago;
	}
	
	

}
