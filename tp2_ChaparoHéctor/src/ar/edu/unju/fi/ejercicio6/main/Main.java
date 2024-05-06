package ar.edu.unju.fi.ejercicio6.main;

import ar.edu.unju.fi.ejercicio6.interfaces.funcionales.Converter;
import ar.edu.unju.fi.ejercicio6.model.FelinoDomestico;
import ar.edu.unju.fi.ejercicio6.model.FelinoSalvaje;

public class Main {
	
//	public static Converter converter;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		
		FelinoDomestico gato = new FelinoDomestico("Gardfiel", (byte) 45, 12f);
		
		Converter<FelinoDomestico, FelinoSalvaje> converter = x -> new FelinoSalvaje(x.getNombre(),
				x.getEdad(), x.getPeso());
		
		FelinoSalvaje felino1 = converter.convert(gato);

		converter.mostrarObjeto(felino1);

//-----------------------------------------------------------------------
	
//		  Realice la conversión de un objeto felino salvaje a felino doméstico.
//		  Nombre = Tanner
//		  Edad = 20
//		  Peso = 186
		 
		FelinoSalvaje tannerSalvaje = new FelinoSalvaje("Tanner", (byte)20, 186f);
		
		
//		 utilice el método estático de la interfaz isNotNull() para verificar que
//		 el objeto a convertir no es nulo.
		 

		if (Converter.isNotNull(tannerSalvaje)) {
			Converter<FelinoSalvaje, FelinoDomestico> converter1 = x -> new FelinoDomestico(x.getNombre(),
					x.getEdad(), x.getPeso());
//			 Utilice el método mostrarObjeto() para mostrar los datos del objeto
			FelinoDomestico tannerDomestico = converter1.convert(tannerSalvaje);
			converter1.mostrarObjeto(tannerDomestico);
		} else {
			System.out.println("el felino no fue inicializado");
		}
		

	}

}
