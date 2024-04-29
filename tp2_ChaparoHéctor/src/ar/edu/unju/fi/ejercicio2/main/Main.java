package ar.edu.unju.fi.ejercicio2.main;

import java.time.LocalDate;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

import ar.edu.unju.fi.ejercicio2.constantes.Mes;
import ar.edu.unju.fi.ejercicio2.model.Efemeride;

public class Main {
	
	public static Scanner sc;
	public static ArrayList<Efemeride> arrayEfermeride;

	public static void main(String[] args) {
		precargarArray();
		sc = new Scanner(System.in);
		
		arrayEfermeride.add(new Efemeride("AAA", Mes.values()[0],(byte) 12, "Muy lindo mes"));
		arrayEfermeride.add(new Efemeride("BBB", Mes.values()[2],(byte) 12, "No sé que es una efeméride"));
//		System.out.println(arrayEfermeride);
		
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
						;
						break;
						
				case 3: 
						eliminar();
						break;
				case 4: 
						modificar();
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
		System.out.println("1 – Crear efeméride.");
		System.out.println("2 – Mostrar efemérides.");
		System.out.println("3 – Eliminar efeméride.");
		System.out.println("4 – Modificar efeméride.");
		System.out.println("5 –  Salir.");;	
	}
	
	
	/**
	 * Se inicia el objeto ArrayList para que no esté null.
	 */
	public static void precargarArray() {
		if(arrayEfermeride == null) {
			arrayEfermeride = new ArrayList<>();
		}
		
	}
	
	/**
	 * Se agregan productos al array;
	 */
	public static void crear() {
		
		System.out.println("\n----------------Creando Efeméride: ");
		System.out.println("Ingrese Codigo de la Efeméride: ");
		String codigo = sc.next();
		
		byte mesByte;
		do {
			System.out.println("Ingrese Mes del Año para crear la efeméride(1 a 12): ");
			mesByte = (byte) (sc.nextByte() - 1);
	        try {
	        	Mes.valueOf(Mes.values()[mesByte].name());
	            break;
	        } catch (Exception e) {
	            System.out.println("Error: Debe ingresar un mes válido para la efeméride");
	        }
	    } while (true);
		
		LocalDate auxiliar = LocalDate.now();
		auxiliar = auxiliar.withMonth(mesByte + 1);
		byte dia;
		do {
			System.out.println("Ingrese el día: ");
	        	try {
	        		dia = sc.nextByte() ;
	        		if (dia <= 0 || dia > auxiliar.lengthOfMonth()) {
	                    throw new IllegalArgumentException("El día elejido no es válido.");
	                }
	                break;
	            } catch (Exception e) {
	                System.out.println("Error: Debe ingresar un día valido para este mes.");
	                sc.nextLine();
	            }
	     } while (true);
		sc.nextLine();
		System.out.println("Ingrese el detalle de la efeméride: ");
		String detalle = sc.nextLine();
		
		arrayEfermeride.add(new Efemeride(codigo, Mes.values()[mesByte], dia, detalle));
		System.out.println("---- Efeméride creada!!!! ");
		System.out.println(arrayEfermeride.get(arrayEfermeride.size() -1));
	}
	
	
	
	/**
	 * Metodo Mostrar Objetos del array
	 */
	public static void mostrar() {
		
		System.out.println("--------------- Lista de la Efeméride: ");
		
		arrayEfermeride.forEach((e) -> System.out.println(e.toString()));
		
	}
	
	
	public static void eliminar() {
	
		System.out.println("--------------- Eliminar una Efeméride: ");
		System.out.println("Ingresa el codigo de la Efeméride: ");
		String efemerideBuscada = sc.next();
		
		Iterator<Efemeride> iterator = arrayEfermeride.iterator();
		while(iterator.hasNext()) {
			Efemeride efe = iterator.next();
			if(efe.getCodigo().compareTo(efemerideBuscada)==0){
				iterator.remove();
				System.out.println("Se eliminó con exito la efeméride: " + efemerideBuscada);
				break;
			} else if (arrayEfermeride.get(arrayEfermeride.size()-1) == efe ) {
				System.out.println("\n Efeméride no encontrada \n ");
			}
		}
		
	}

	/**
	 * Se modifican las efemérides del array;
	 */
	public static void modificar() {
		
		System.out.println("\n---------------- Modificando Efeméride: ");
		System.out.println("Ingrese Codigo de la Efeméride: ");
		String codigo = sc.next();
		
		for (Efemeride efe : arrayEfermeride) {
			if(efe.getCodigo().compareTo(codigo)==0){
		
				byte mesByte;
				do {
					System.out.println("Ingrese el nuevo Mes del Año para la efeméride(1 a 12): ");
					mesByte = (byte) (sc.nextByte() - 1);
			        try {
			        	Mes.valueOf(Mes.values()[mesByte].name());
			            break;
			        } catch (Exception e) {
			            System.out.println("Error: Debe ingresar un mes válido para la efeméride");
			        }
			    } while (true);
				
				LocalDate auxiliar = LocalDate.now();
				auxiliar = auxiliar.withMonth(mesByte + 1);
				byte dia;
				do {
					System.out.println("Ingrese el día: ");
			        	try {
			        		dia = sc.nextByte() ;
			        		if (dia <= 0 || dia > auxiliar.lengthOfMonth()) {
			                    throw new IllegalArgumentException("El día elejido no es válido.");
			                }
			                break;
			            } catch (Exception e) {
			                System.out.println("Error: Debe ingresar un día valido para este mes.");
			                sc.nextLine();
			            }
			     } while (true);
				
				sc.nextLine();
				System.out.println("Ingrese el detalle de la efeméride: ");
				String detalle = sc.nextLine();

				efe.setMes(Mes.values()[mesByte]);
				efe.setDia(dia);
				efe.setDetalle(detalle);
				
				System.out.println("---- Efeméride Modificada!!!! ---- ");
				
				System.out.println(efe);
		
			}else if (arrayEfermeride.get(arrayEfermeride.size()-1) == efe ) {
				System.out.println("\n Efemeride no encontrado \n ");
			}
		}
	}

	

}
