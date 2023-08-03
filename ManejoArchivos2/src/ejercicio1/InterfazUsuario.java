package ejercicio1;

import java.util.Scanner;

public class InterfazUsuario {

	
	public static String getString(Scanner sc, String label) {
		System.out.print(label);
		String str = sc.nextLine();
		return str;
	}
	
	public static double getDouble(Scanner sc, String label) {
		System.out.print(label);
		double d = Double.parseDouble(sc.nextLine());
		return d;
	}
	
	public static boolean confirmar(Scanner sc, String label) {
		System.out.print("¿" + label + " (S/N)?");
		String str = sc.nextLine();
		return str.toLowerCase().equals("s");
	}
	
	public static void escribirListaCompra(ListaCompra compra) {
		System.out.println("LISTA DE LA COMPRA");
		System.out.println("==================");
		for(ElementoListaCompra e: compra.getLista()) {
			System.out.printf("Producto: %s\t Cantidad: %f%n", e.getProducto(), e.getCantidad());
		}
	}
}
