package ar.edu.unju.fi.ejercicio5.main;

import java.util.ArrayList;
import java.util.Scanner;

import ar.edu.unju.fi.ejercicio5.model.PagoEfectivo;
import ar.edu.unju.fi.ejercicio5.model.PagoTarjeta;
import ar.edu.unju.fi.ejercicio5.model.Producto;

public class Main {
	
	public static ArrayList<Producto> arrayProductos = new ArrayList<>();
	public static ArrayList<Producto> carrito = new ArrayList<>();
	public static Scanner sc;
	
	public static void main(String[] args) {
		
		precargar();
		sc = new Scanner(System.in);
		int op;
		
		do {
			do {
				try {
	            	menu();
	                op = sc.nextInt();
	                if (op < 1 || op > 3) {
	                    throw new IllegalArgumentException("Elija una opcion entre 1 y 3: ");
	                }
	                break;
				} catch (Exception e) {
	                System.out.println("Error: dato invalido: " + e.getMessage());
	                sc.nextLine();
		        }
			} while (true);
				
				switch (op) {
				case 1: 
						mostrar();
						break;
						
				case 2: 
						realizarCompra();
						;
						break;
						
				case 3: 
						sc.close();
						break;
						
				default:
					break;
				}
				
		} while (op != 3);

	}
	
	
	/**
	 * se hace la precarga de los 15 productos del arrayProductos
	 */
	public static void precargar() {	
		arrayProductos.add(new Producto("AAA", "Cafetera", 100, Producto.Origen.ARGENTINA, Producto.Categoria.ELECTROHOGAR, true));
		arrayProductos.add(new Producto("BBB", "Martillo", 200, Producto.Origen.BRASIL, Producto.Categoria.HERRAMIENTAS, false));
		arrayProductos.add(new Producto("CCC", "Moto G5", 300, Producto.Origen.CHINA, Producto.Categoria.TELEFONIA, true));
		arrayProductos.add(new Producto("DDD", "Impresora", 400, Producto.Origen.URUGUAY, Producto.Categoria.INFORMATICA, true));
		arrayProductos.add(new Producto("EEE", "Heladera", 500, Producto.Origen.ARGENTINA, Producto.Categoria.ELECTROHOGAR, false));
		arrayProductos.add(new Producto("FFF", "Destornillador", 600, Producto.Origen.BRASIL, Producto.Categoria.HERRAMIENTAS, true));
		arrayProductos.add(new Producto("GGG", "Samsung A20", 20, Producto.Origen.CHINA, Producto.Categoria.TELEFONIA, true));
		arrayProductos.add(new Producto("HHH", "Mouse", 700, Producto.Origen.URUGUAY, Producto.Categoria.INFORMATICA, false));
		arrayProductos.add(new Producto("III", "Teclado Mecanico", 800, Producto.Origen.ARGENTINA, Producto.Categoria.INFORMATICA, true));
		arrayProductos.add(new Producto("JJJ", "Cargador Turbo", 900, Producto.Origen.BRASIL, Producto.Categoria.TELEFONIA, false));
		arrayProductos.add(new Producto("KKK", "Batidora", 1000, Producto.Origen.CHINA, Producto.Categoria.ELECTROHOGAR, true));
		arrayProductos.add(new Producto("LLL", "Microondas", 1100, Producto.Origen.URUGUAY, Producto.Categoria.ELECTROHOGAR, true));
		arrayProductos.add(new Producto("MMM", "Llave Inglesa", 1200, Producto.Origen.ARGENTINA, Producto.Categoria.HERRAMIENTAS, false));
		arrayProductos.add(new Producto("NNN", "Sierra", 1300, Producto.Origen.CHINA, Producto.Categoria.HERRAMIENTAS, false));
		arrayProductos.add(new Producto("OOO", "Funda de Celular", 1400, Producto.Origen.BRASIL, Producto.Categoria.TELEFONIA, true));
	}
	
	/**
	 * Menú principal
	 */
	public static void menu() {
		System.out.println("\n----------------Menú Principal: ");
		System.out.println("Ingrese una opcion: ");
		System.out.println("1 – Mostrar productos.");
		System.out.println("2 – Realizar compra.");
		System.out.println("3 –  Salir.");;	
	}
	
	
	/**
	 * Muestra el array de productos
	 */
	public static void mostrar() {
		
		System.out.println("--------------- Lista de Productos: ");
		
		arrayProductos.forEach((e) -> System.out.println(e.toString()));
		
	}
	
	
	/**
	 * Interfaz con menus para agregar los productos al carrito 
	 * y realizar el pago con tarjeta o efectivo
	 */
	public static void realizarCompra() {
		
		System.out.println("--------------- Realizar Compra: ");
//		mostrar();
		
		int op;
		
		do {
			do {
				try {
					System.out.println("Ingrese una opcion: ");
					System.out.println("1 – Añadir Producto al carrito");
					System.out.println("2 – Pagar carrito.");
					System.out.println("3 – Cancelar.");
	                op = sc.nextInt();
	                if (op < 1 || op > 3) {
	                    throw new IllegalArgumentException("Elija una opcion entre 1 y 3: ");
	                }
	                break;
				} catch (Exception e) {
	                System.out.println("Error: dato invalido: " + e.getMessage());
	                sc.nextLine();
		        }
			} while (true);
				
				switch (op) {
				case 1: 

						System.out.println("Ingrese Codigo del Producto: ");
						String codigo = sc.next();
						sc.nextLine();
						
						for (Producto producto : arrayProductos) {
							if(producto.getCodigo().compareTo(codigo)==0){
								
								if (producto.getEstado()) {
									carrito.add(producto);
									System.out.println("\n Producto agregado al carrito \n ");
								} else {
									System.out.println("\n NO hay STOCK del producto \n ");
								}

								break;
							}else if (arrayProductos.get(arrayProductos.size()-1) == producto ) {
								System.out.println("\n Producto no encontrado \n ");
							}
						}
						break;
						
				case 2: 
						if(!carrito.isEmpty()) {
							int op2;
							do {
								try {System.out.println("\n----------------: ");
									System.out.println("Ingrese una opcion: ");
									System.out.println("1 – Pago efectivo");
									System.out.println("2 – Pago con tarjeta.");
					                op2 = sc.nextInt();
					                if (op2 < 1 || op2 > 3) {
					                    throw new IllegalArgumentException("Elija una opcion entre 1 y 3: ");
					                }
					                break;
								} catch (Exception e) {
					                System.out.println("Error: dato invalido: " + e.getMessage());
					                sc.nextLine();
						        }
							} while (true);
							
							double montoPagar = 0;
							for (Producto producto : carrito) {
								montoPagar = montoPagar + producto.getPrecioUnidad();
							}
							
							switch (op2) {
								case 1: 
										PagoEfectivo pagarEfectivo = new PagoEfectivo();
										pagarEfectivo.realizarPago(montoPagar);
										pagarEfectivo.imprimirRecibo();
										sc.nextLine();
										op = 3;
										carrito.clear();
										break;
										
								case 2:
										System.out.println("Ingrese número de Tarjeta: ");
										String numTarjeta = sc.next();
										
										PagoTarjeta pagarTarjeta = new PagoTarjeta();
										pagarTarjeta.setNúmeroTarjeta(numTarjeta);
										pagarTarjeta.realizarPago(montoPagar);
										pagarTarjeta.imprimirRecibo();
										sc.nextLine();
										op = 3;
										carrito.clear();
										break;
										
								default:
									break;
								}
						} else {
							System.out.println("El carrito está vacio");
						}
//						sc.close();
						break;
				case 3:
						sc.nextLine();
						break;
				default:
					break;
				}
				
		} while (op != 3);

	}

}
