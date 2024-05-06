package ar.edu.unju.fi.ejercicio7.main;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import ar.edu.unju.fi.ejercicio5.model.Producto;
import ar.edu.unju.fi.ejercicio5.model.Producto.Categoria;

public class Main {
	
	public static Scanner sc;
//	public static 
	public static ArrayList<Producto> arrayProductos = new ArrayList<>();
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		sc = new Scanner(System.in);
		precargar();
		
		Consumer<Producto> printProductos = c -> System.out.println(c.toString());
		
		ArrayList<Producto> productosIncrementados = new ArrayList<>();
		ArrayList<Producto> productosMayusculas = new ArrayList<>();

		int op;
		
		do {
			do {
				try {
	            	menu();
	                op = sc.nextInt();
	                if (op < 1 || op > 7) {
	                    throw new IllegalArgumentException("Elija una opcion entre 1 y 7: ");
	                }
	                break;
				} catch (Exception e) {
	                System.out.println("Error: dato invalido: " + e.getMessage());
	                sc.nextLine();
		        }
			} while (true);
				
				switch (op) {
				case 1: 
						System.out.println("----------------------Productos en Stock--------------------------");
						mostrarTrue();
						break;
						
				case 2: 
						System.out.println("----------------------Productos sin Stock--------------------------");
						mostrarFalse();
						break;
						
				case 3: 
						System.out.println("----------------------Productos con Incremento--------------------------");
						incrementar();
						break;
						
				case 4:
						System.out.println("----------------------Productos de la categoria Electrohogar--------------------------");
						filtro();
						break;
				
				case 5:
						System.out.println("----------------------Productos Ordenados--------------------------");
						arrayProductos.sort(Comparator.comparing(Producto::getPrecioUnidad));
						arrayProductos.forEach(System.out::println);
						break;
						
				case 6: 
						System.out.println("----------------------Productos con Nombre en Mayuscula--------------------------");
						mayuscula();
						break;
						
				case 7:
						sc.close();
						break;
						
				default:
					break;
				}
				
		} while (op != 7);
		
		
	}
	
	
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
		System.out.println("1 – Mostrar productos.");//(solo se muestran los productos con estado true).
		System.out.println("2 – Mostrar los productos faltantes.");//(muestra productos con estado false)
		System.out.println("3 – Incrementar los precios de los productos en un 20%.");
		System.out.println("4 – Mostrar los productos que corresponden a la categoría Electrohogar y estén disponibles para la venta.");
		System.out.println("5 – Ordenar los productos por precio de forma descendente.");
		System.out.println("6 – Mostrar los productos con los nombres en mayúsculas.");
		System.out.println("7 – Salir.");
		
	}
	
	/**
	 * Para la opción 1 utilizar la interfaz funcional Consumer.
	 */
	public static void mostrarTrue() {
		Consumer<Producto> printDisponibles = c -> {
			if(c.getEstado()) {
				System.out.println(c.toString());;
			}
		};
		arrayProductos.forEach(printDisponibles);
	}
	
	
	/**
	 * Para la opción 2 utilizar Predicate y filter().
	 */
	public static void mostrarFalse() {
		Predicate<Producto> filtroFaltantes = c -> !c.getEstado(); 
		arrayProductos.stream().filter(filtroFaltantes).forEach(System.out::println);
	}
	
	/**
	 * Para la opción 3 utilizar Function, map(), el resultado debe almacenarse en un nuevo ArrayList
	 * productosIncrementados.
	 */
	public static void incrementar() {
		ArrayList<Producto> productosIncrementados = new ArrayList<>();
		
		
		// ESTO ES PARA GUARDAR LOS VALORES ORIGINALES,
		// YA QUE ME ALTERAN LOS VALORES DEL ARRAY ORIGINAL Y SE ME OCURRIÓ ESTA FORMA PARA SOLUCIONARLO
		ArrayList<Double> originales = new ArrayList<>();
		Function<Producto,Double> copiar = (p) -> {
			double precio = p.getPrecioUnidad();
			return precio;
		};
		originales = (ArrayList<Double>) arrayProductos.stream().map(copiar).collect(Collectors.toList());
		//----------------------------------------------------------------
		
		// CONSIGNA
		Function<Producto,Producto> incremento = (p) -> {
			double resultado = p.getPrecioUnidad()*1.20;
			p.setPrecioUnidad(resultado);
			return p;
		};
		productosIncrementados = (ArrayList<Producto>) arrayProductos.stream().map(incremento).collect(Collectors.toList());
		productosIncrementados.forEach(System.out::println);
		//--------------------------------------------------------
		
		//volver normal - IGNORAR
		int i = 0;
		for (Double double1 : originales) {
			arrayProductos.get(i).setPrecioUnidad(double1.doubleValue());
			i++;
		}
		i=0;
		//-------------------------------------------
	}
	
	
	/**
	 * Para la opción 4 utilizar Predicate y filter().
	 */
	public static void filtro() {

		
		Predicate<Producto> filtroElectrohogar = c -> c.getCatego()== Categoria.ELECTROHOGAR && c.getEstado();
		ArrayList<Producto> productosFiltrados = (ArrayList<Producto>) arrayProductos.stream().filter(filtroElectrohogar).collect(Collectors.toList());
		productosFiltrados.forEach(System.out::println);
		
	}
	
	/**
	 * Para la opción 6 utilizar Function y map().
	 */
	public static void mayuscula() {
		
		ArrayList<Producto> productosMayusculas = new ArrayList<>();
		Function<Producto,Producto> mayuscula = (p) -> {
			p.setDescripcion(p.getDescripcion().toUpperCase());
			return p;
		};
		productosMayusculas = (ArrayList<Producto>) arrayProductos.stream().map(mayuscula).collect(Collectors.toList());
		productosMayusculas.forEach(System.out::println);
		
		
		
		//volver normal - IGNORAR
		Function<Producto,Producto> minuscula = (p) -> {
			p.setDescripcion(p.getDescripcion().toLowerCase());
			return p;
		};
		productosMayusculas = (ArrayList<Producto>) arrayProductos.stream().map(minuscula).collect(Collectors.toList());
	}
	
}
