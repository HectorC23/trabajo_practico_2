package ar.edu.unju.fi.ejercicio5.model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import ar.edu.unju.fi.ejercicio5.interfaces.Pago;

public class PagoTarjeta implements Pago {
	
	private String númeroTarjeta;
	private LocalDate fechaPago;
	private double montoPagado;
	
	public PagoTarjeta() {
		
	}

	public PagoTarjeta(String númeroTarjeta, LocalDate fechaPago, double montoPagado) {
		super();
		this.númeroTarjeta = númeroTarjeta;
		this.fechaPago = fechaPago;
		this.montoPagado = montoPagado;
	}

	@Override
	public String toString() {
		return "PagoTarjeta [númeroTarjeta=" + númeroTarjeta + ", fechaPago=" + fechaPago + ", montoPagado="
				+ montoPagado + "]";
	}

	@Override
	public void realizarPago(double monto) {
		this.montoPagado = (monto *1.15);
		
	}

	@Override
	public void imprimirRecibo() {
		this.fechaPago = LocalDate.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yy");
		String fechaFormateada = this.fechaPago.format(formatter);
		
		System.out.println("Número de tarjeta: "+ this.númeroTarjeta);
		System.out.println("Fecha de pago: "+fechaFormateada);
		System.out.println("Monto pagado: " + montoPagado);

	}

	public String getNúmeroTarjeta() {
		return númeroTarjeta;
	}

	public void setNúmeroTarjeta(String númeroTarjeta) {
		this.númeroTarjeta = númeroTarjeta;
	}

	public LocalDate getFechaPago() {
		return fechaPago;
	}

	public void setFechaPago(LocalDate fechaPago) {
		this.fechaPago = fechaPago;
	}

	public double getMontoPagado() {
		return montoPagado;
	}

	public void setMontoPagado(double montoPagado) {
		this.montoPagado = montoPagado;
	}
	
	

}
