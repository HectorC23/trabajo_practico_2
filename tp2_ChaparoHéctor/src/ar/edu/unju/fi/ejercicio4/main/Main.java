package ar.edu.unju.fi.ejercicio4.main;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

import ar.edu.unju.fi.ejercicio4.constantes.Posicion;
import ar.edu.unju.fi.ejercicio4.model.Jugador;


public class Main {
	
	public static Scanner sc;
	public static ArrayList<Jugador> arrayJugadores = new ArrayList<>();
	
	public static void main(String[] args) {
		
		sc = new Scanner(System.in);
		arrayJugadores.add(new Jugador("hector", "Chaparro", LocalDate.parse("2000-11-30"), "Argentina", 1.64f, 60f, Posicion.MEDIO));
		arrayJugadores.add(new Jugador("lucas", "mamani", LocalDate.parse("2000-11-30"), "Argentina", 1.64f, 60f, Posicion.DELANTERO));
		arrayJugadores.add(new Jugador("Ezequiel", "Marino", LocalDate.parse("2000-11-30"), "Argentina", 1.64f, 60f, Posicion.DELANTERO));
		
		int op;
		
		do {
			do {
				try {
	            	menu();
	                op = sc.nextInt();
	                if (op < 1 || op > 5) {
	                    throw new IllegalArgumentException("Elija una opcion entre 1 y 5: ");
	                }
	                break;
				} catch (Exception e) {
	                System.out.println("Error: dato invalido: " + e.getMessage());
	                sc.nextLine();
		        }
			} while (true);
				
				switch (op) {
				case 1: 
						crear();
						break;
						
				case 2: 
						mostrar();
						break;
						
				case 3: 
						modificar();
						break;
				case 4: 
						eliminar();
						;
						break;
						
				case 5: 
						sc.close();
						break;
						
				default:
					break;
				}
				
		} while (op != 5);
		
	}
	
	/**
	 * Menú principal
	 */
	public static void menu() {
		System.out.println("\n----------------Menú Principal: ");
		System.out.println("Ingrese una opcion: ");
		System.out.println("1 – Alta de jugador.");
		System.out.println("2 – Mostrar todos los jugadores.");
		System.out.println("3 – Modificar la posición de un jugador.");//el usuario debe ingresar el nombre y el apellido deljugador
		System.out.println("4 – Eliminar un jugador.");// el usuario debe ingresar el nombre y apellido. Utilice Iterator
		System.out.println("5 –  Salir.");;	
	}
	
	public static void crear() {
		System.out.println("\n---------------- Alta de Jugador: ");
		System.out.println("Ingrese su Nombre: ");
		String nombre = sc.next();
		System.out.println("Ingrese su Apellido: ");
		String apellido = sc.next();
		
		String fechaNacimientoString;
		LocalDate fecha;
		do {
			System.out.println("Ingrese su fecha de nacimiento: (YYYY-MM-DD): ");
            try {
            	fechaNacimientoString = sc.next();
            	fecha = LocalDate.parse(fechaNacimientoString);
                break;
            } catch (Exception e) {
                System.out.println("Error: Debe ingresar una fecha en el formato especificado.");
            }
        } while (true);
		
		System.out.println("Ingrese su Nacionalidad: ");
		String nacionalidad = sc.next();
		
		float estatura;
		 do {
			 System.out.println("Ingrese estatura del jugador (m): ");
	            try {
	            	estatura = sc.nextFloat() ;
	                break;
	            } catch (Exception e) {
	                System.out.println("Error: Debe ingresar una estatura válida.");
	                sc.nextLine();
	            }
	      } while (true);
		
		 float peso;
		 do {
			 System.out.println("Ingrese peso del jugador (kg): ");
	            try {
	            	peso = sc.nextFloat();
	                break;
	            } catch (Exception e) {
	                System.out.println("Error: Debe ingresar un peso válido.");
	                sc.nextLine();
	            }
	      } while (true);
		
		
		String position;
		do {
			System.out.println("Ingrese la Posicion (DELANTERO, MEDIO, DEFENSA, ARQUERO): ");
			position = sc.next().toUpperCase();
	        try {
	        	Posicion.valueOf(position);
	            break;
	        } catch (Exception e) {
	            System.out.println("Error: Debe ingresar una Posicion válida.");
	        }
	    } while (true);
		
		
		arrayJugadores.add(new Jugador(nombre, apellido, fecha, nacionalidad, estatura, peso, Posicion.valueOf(position)));
		System.out.println("---- Jugador creado!!!! ");
		System.out.println(arrayJugadores.get(arrayJugadores.size() -1));
	}
	
	
	public static void mostrar() {
		
		if(arrayJugadores.size() <= 0) {
			System.out.println("--------------- No hay jugadores cargados ");
		} else {
		
		System.out.println("--------------- Lista de la Efeméride: ");
		
		arrayJugadores.forEach((e) -> System.out.println(e.toString()));
		}
	}
	
	
	
	public static void modificar() {
		if(arrayJugadores.size() <= 0) {
			System.out.println("--------------- No hay jugadores cargados ");
		} else {
		
		System.out.println("--------------- Modificar Posición ");
		System.out.println("Ingresa el nombre del jugador: ");
		String nombre = sc.next();
		System.out.println("Ingresa el apellido del jugador: ");
		String apellido = sc.next();
		
		Iterator<Jugador> iterator = arrayJugadores.iterator();
		while(iterator.hasNext()) {
			Jugador player = iterator.next();
			if(player.getNombre().compareTo(nombre)==0 && player.getApellido().compareTo(apellido)==0){
				String position;
				do {
					System.out.println("Ingrese la NUEVA Posicion (DELANTERO, MEDIO, DEFENSA, ARQUERO): ");
					position = sc.next().toUpperCase();
			        try {
			        	Posicion.valueOf(position);
			            break;
			        } catch (Exception e) {
			            System.out.println("Error: Debe ingresar una Posicion válida.");
			        }
			    } while (true);
				player.setPosición(Posicion.valueOf(position));
				System.out.println("Jugador modificado!!!!! ");
				System.out.println(player);

				break;
			} else if (arrayJugadores.get(arrayJugadores.size()-1) == player ) {
				System.out.println("\n Jugador no encontrado \n ");
			}
		}
		}
		
	}
	
	public static void eliminar() {
		
		if(arrayJugadores.size() <= 0) {
			System.out.println("--------------- No hay jugadores cargados ");
		} else {		
			System.out.println("--------------- Eliminar Jugador ");
			System.out.println("Ingresa el nombre del jugador: ");
			String nombre = sc.next();
			System.out.println("Ingresa el apellido del jugador: ");
			String apellido = sc.next();
			
			Iterator<Jugador> iterator = arrayJugadores.iterator();
			while(iterator.hasNext()) {
				Jugador player = iterator.next();
				if(player.getNombre().compareTo(nombre)==0 && player.getApellido().compareTo(apellido)==0){
					iterator.remove();
					System.out.println("Jugador Eliminado: " + nombre + " " + apellido);
					break;
				} else if (arrayJugadores.get(arrayJugadores.size()-1) == player ) {
					System.out.println("\n Jugador no encontrado \n ");
				}
			}
		}
		
		
		
	}
	
	
	
	
	
}	
