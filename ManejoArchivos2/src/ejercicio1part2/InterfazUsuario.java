package ejercicio1part2;

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

	public static int getInt(Scanner sc, String label) {
		System.out.print(label);
		int n = Integer.parseInt(sc.nextLine());
		return n;
	}

	public static boolean confirmar(Scanner sc, String label) {
		System.out.print("�" + label + " (S/N)?");
		String str = sc.nextLine();
		return str.toLowerCase().equals("s");
	}

	public static void escribirListaCompra(ListaCompra compra) {
		System.out.println("LISTA DE LA COMPRA");
		System.out.println("==================");
		for (ElementoListaCompra e : compra.getLista()) {
			System.out.printf("Producto: %-20s Cantidad: %5.2f%n", e.getProducto(), e.getCantidad());
		}
	}

	public static int escribirMenuPrincipal(Scanner sc) {
		System.out.println("1. Añadir producto.");
		System.out.println("2. Eliminar producto.");
		System.out.println("3. Eliminar lista de la compra.");
		System.out.println();
		System.out.println("0. Salir.");
		System.out.println();
		return getInt(sc, "Escribe la opci�n: ");
	}

	public static ElementoListaCompra perdirDatos(Scanner sc) {
		String producto = getString(sc, "Escribe el nombre del producto: ");
		double cantidad = getDouble(sc, "Escribe la cantidad: ");
		return new ElementoListaCompra(producto, cantidad);
	}

	public static void escribirCabecera(String titulo) {
		System.out.println(repeat("*", titulo.length()));
		System.out.println(titulo.toUpperCase());
		System.out.println(repeat("*", titulo.length()));
	}

	public static int escribirEliminarProducto(Scanner sc, ListaCompra compra) {
		ElementoListaCompra[] lista = compra.getLista();
		for (int i = 0; i < lista.length; i++) {
			System.out.printf("%2d - %-25s %5.2f%n", i + 1, lista[i].getProducto(), lista[i].getCantidad());
		}
		System.out.println();
		System.out.println(" 0. Salir.");
		System.out.println();
		int n = getInt(sc, "Elige el producto a eliminar: ");
		return n;
	}

	public static String repeat(String s, int cantidad) {
		String str = "";
		for (int i = 1; i <= cantidad; i++) {
			str += s;
		}
		return str;
	}

}
