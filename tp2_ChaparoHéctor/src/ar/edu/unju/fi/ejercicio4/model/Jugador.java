package ar.edu.unju.fi.ejercicio4.model;

import java.time.LocalDate;

import ar.edu.unju.fi.ejercicio4.constantes.Posicion;

public class Jugador {
	
	private String nombre;
	private String apellido;
	private LocalDate fechaDeNacimiento;
	private String nacionalidad;
	private float estatura;
	private float peso;
	private Posicion posición ;//(DELANTERO, MEDIO, DEFENSA, ARQUERO)

	public Jugador(String nombre, String apellido, LocalDate fechaDeNacimiento, String nacionalidad, float estatura,
			float peso, Posicion posición) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.fechaDeNacimiento = fechaDeNacimiento;
		this.nacionalidad = nacionalidad;
		this.estatura = estatura;
		this.peso = peso;
		this.posición = posición;
	}

	@Override
	public String toString() {
		return "Jugador [nombre=" + nombre + ", apellido=" + apellido + ", fechaDeNacimiento=" + fechaDeNacimiento
				+ ", nacionalidad=" + nacionalidad + ", estatura=" + estatura + ", peso=" + peso + ", posición="
				+ posición + "]";
	}

	
	public int calcularEdad() {
		LocalDate fechaActual = LocalDate.now();
		if ((fechaActual.getYear() > fechaDeNacimiento.getYear())) {
			if(fechaActual.getMonthValue() >= fechaDeNacimiento.getMonthValue()) {
				if (fechaActual.getMonthValue() == fechaDeNacimiento.getMonthValue()) {
					if((fechaActual.getDayOfMonth() < fechaDeNacimiento.getDayOfMonth())){
						return ((fechaActual.getYear()- fechaDeNacimiento.getYear())-1); //
					} else {
						return (fechaActual.getYear()- fechaDeNacimiento.getYear());
					}
				} else {
					return (fechaActual.getYear()- fechaDeNacimiento.getYear()); //
				}
			} else {
				return (fechaActual.getYear()-fechaDeNacimiento.getYear());
			}	
		}
		else {
			return (fechaActual.getYear()-fechaDeNacimiento.getYear());
		}
	}




	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public LocalDate getFechaDeNacimiento() {
		return fechaDeNacimiento;
	}
	public void setFechaDeNacimiento(LocalDate fechaDeNacimiento) {
		this.fechaDeNacimiento = fechaDeNacimiento;
	}
	public String getNacionalidad() {
		return nacionalidad;
	}
	public void setNacionalidad(String nacionalidad) {
		this.nacionalidad = nacionalidad;
	}
	public float getEstatura() {
		return estatura;
	}
	public void setEstatura(float estatura) {
		this.estatura = estatura;
	}
	public float getPeso() {
		return peso;
	}
	public void setPeso(float peso) {
		this.peso = peso;
	}
	public Posicion getPosición() {
		return posición;
	}
	public void setPosición(Posicion posición) {
		this.posición = posición;
	}

}
