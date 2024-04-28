package ar.edu.unju.fi.ejercicio1.main;

import java.util.ArrayList;
import java.util.Scanner;

import ar.edu.unju.fi.ejercicio1.model.Producto;
public class Main {
	
	public static Scanner sc;
	public static ArrayList<Producto> arrayProductos;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		sc = new Scanner(System.in);
		
		precargarArray();
		arrayProductos.add(new Producto("AAA", "Muy lindo producto", 20, Producto.Origen.ARGENTINA, Producto.Categoria.ELECTROHOGAR));
		arrayProductos.add(new Producto("BBB", "Muy feo producto", 10, Producto.Origen.CHINA, Producto.Categoria.HERRAMIENTAS));
		int op;
		
		do {
			do {
				try {
	            	menu();
	                op = sc.nextInt();
	                if (op < 1 || op > 4) {
	                    throw new IllegalArgumentException("Elija una opcion entre 1 y 4: ");
	                }
	                break;
				} catch (Exception e) {
	                System.out.println("Error: dato invalido: " + e.getMessage());
	                sc.nextLine();
		        }
			} while (true);
				
				switch (op) {
				case 1: 
						crearProducto();
						break;
						
				case 2: 
						mostrar();
						;
						break;
						
				case 3: 
						modificar();
						;
						break;
						
				case 4: 
						sc.close();
						break;
						
				default:
					break;
				}
				
		} while (op != 4);

	}
	
	/**
	 * Menú principal
	 */
	public static void menu() {
		System.out.println("\n----------------Menú Principal: ");
		System.out.println("Ingrese una opcion: ");
		System.out.println("1 – Crear Producto.");
		System.out.println("2 – Mostrar productos.");
		System.out.println("3 – Modificar producto.");
//		(sólo puede modificar: descripción, precio unitario, origen fabricacióno categoría).
		System.out.println("4 –  Salir.");;	
	}
	
	/**
	 * Se inicia el objeto ArrayList para que no esté null.
	 */
	public static void precargarArray() {
		if(arrayProductos == null) {
			arrayProductos = new ArrayList<>();
		}
		
	}
	
	/**
	 * Se agregan productos al array;
	 */
	public static void crearProducto() {
		System.out.println("Ingrese Codigo del Producto: ");
		String codigo = sc.next();
		sc.nextLine();
		System.out.println("Ingrese descripcion del Producto: ");
		String descripcion = sc.nextLine();
		
		
		double precio;
		do {
			System.out.println("Ingrese Precio del producto: ");
	        	try {
	            	precio = sc.nextDouble() ;
	                break; // Salir del bucle si se ingresa un número double válido
	            } catch (Exception e) {
	                System.out.println("Error: Debe ingresar un precio válido (00,00).");
	                sc.nextLine();
	            }
	     } while (true);
		
		String origenString;
		do {
			mostrarOrigen();
	        System.out.println("Elija una opción: ");
	        origenString = sc.next().toUpperCase();
	        try {
	        	Producto.Origen.valueOf(origenString);
	            break;
	        } catch (Exception e) {
	            System.out.println("Error: Debe ingresar el nombre del origen que sea válido.");
	        }
	    } while (true);
		
		
		String categoriaString;
		do {
			mostrarCategoria();
	        System.out.println("Elija una opción: ");
	        categoriaString = sc.next().toUpperCase();
	        try {
	        	Producto.Categoria.valueOf(categoriaString);
	            break;
	        } catch (Exception e) {
	            System.out.println("Error: Debe ingresar el nombre de la categoria que sea válido.");
	        }
	    } while (true);
		
		arrayProductos.add(new Producto(codigo, descripcion, precio, Producto.Origen.valueOf(origenString), Producto.Categoria.valueOf(categoriaString)));
//		System.out.println(arrayProductos);
		System.out.println("\n Producto Creado Con Exito!!!\n");
	}

	/**
	 * Metodo Mostrar Objetos del array
	 */
	public static void mostrar() {
		
		System.out.println("--------------- Lista de Productos: ");
		
		arrayProductos.forEach((e) -> System.out.println(e.toString()));
		
	}
	
	/**
	 * Modificar algun elemento del array pasando su codigo de producto
	 * directamente decidí modificar el producto en su totalidad y no
	 * preguntarle si quiere modificar algo en particular.
	 */
	public static void modificar() {
		System.out.println("--------------- Editar Producto: ");
		System.out.println("Ingrese Codigo del Producto a editar: ");
		String codigo = sc.next();
		sc.nextLine();
		
		for (Producto producto : arrayProductos) {
			if(producto.getCodigo().compareTo(codigo)==0){
				
				System.out.println("Ingrese la nueva descripcion del Producto: ");
				String descripcion = sc.nextLine();
				
				double precio;
				do {
					System.out.println("Ingrese el nuevo Precio del producto: ");
			        	try {
			            	precio = sc.nextDouble() ;
			                break;
			            } catch (Exception e) {
			                System.out.println("Error: Debe ingresar un precio válido (00,00).");
			                sc.nextLine();
			            }
			     } while (true);
				
				String origenString;
				do {
					mostrarOrigen();
			        System.out.println("Elija una opción: ");
					origenString = sc.next().toUpperCase();
			        try {
			        	Producto.Origen.valueOf(origenString);
			            break;
			        } catch (Exception e) {
			            System.out.println("Error: Debe ingresar el nombre del origen.");
			        }
			    } while (true);
				
				String categoriaString;
				do {
					mostrarCategoria();
			        System.out.println("Elija una opción: ");
					categoriaString = sc.next().toUpperCase();
			        try {
			        	Producto.Categoria.valueOf(categoriaString);
			            break;
			        } catch (Exception e) {
			            System.out.println("Error: Debe ingresar el nombre de la categoria.");
			        }
			    } while (true);
				
				producto.setDescripcion(descripcion);
				producto.setPrecioUnidad(precio);
				producto.setCatego(Producto.Categoria.valueOf(categoriaString));
				producto.setOrigenFabricacion(Producto.Origen.valueOf(origenString));
				System.out.println("\n Producto Modificado Con Exito!!!\n");
				break;
			} else if (arrayProductos.get(arrayProductos.size()-1) == producto ) {
				System.out.println("\n Producto no encontrado \n ");
			}
		}
		
	}
	
	
	/**
	 * Muestra de forma ordenada la lista de Origenes disponibles
	 */
	public static void mostrarOrigen() {
		
		System.out.println("---- Origen de fabricación ---- ");
		
		for (int i = 0; i < Producto.Origen.values().length; i++) {
			
			System.out.println("	"+(i+1)+" - "+ Producto.Origen.values()[i]);
			
		}
		
	}
	
	/**
	 * Muestra de forma ordenada la lista de Categorias disponibles
	 */
	public static void mostrarCategoria() {
		
		System.out.println("---- Categoría ---- ");
		
		for (int i = 0; i < Producto.Categoria.values().length; i++) {
			
			System.out.println("	"+(i+1)+" - "+ Producto.Categoria.values()[i]);
			
		}
		
		
	}
	
	
	

}
