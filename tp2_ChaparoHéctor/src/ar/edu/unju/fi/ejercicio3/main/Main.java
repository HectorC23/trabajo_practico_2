package ar.edu.unju.fi.ejercicio3.main;

import java.util.ArrayList;
import java.util.Scanner;

import ar.edu.unju.fi.ejercicio3.constantes.Provincia;

public class Main {
	
	
	public static ArrayList<Provincia> arrayProvincias = new ArrayList<>();
	public static Scanner sc;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		for (Provincia provincia : Provincia.values()) {		
			arrayProvincias.add(provincia);
		}
		
		System.out.println("--------- PROVINCIAS CON TODOS SUS DATOS ---------\n");
		for (Provincia provincia : arrayProvincias) {		
			System.out.println("Provincia: " + provincia.name()
					+ " - Cantidad Poblacional: " +provincia.getCantidadPoblacion() 
					+ " - Superficie: " + provincia.getSuperficie()
					+ " - Densidad Poblacional: " + provincia.calcularDensidadPoblacional() + "\n"
					);
				
		}
	}

}
