package ejercicio1;

import java.io.IOException;
import java.util.Scanner;

public class Ejercicio1 {
	/*
	 * Crea una aplicaci�n para gestionar la lista de la compra. Vamos a pedir por
	 * teclado el nombre del producto y la cantidad. Deber�s preguntar al usuario si
	 * quiere a�adir nuevo producto a la lista. En el caso de que no, se termina el
	 * programa y se deber� guardar la lista en un archivo de texto. Escribir en la
	 * consola la lista de la compra antes de terminar la aplicaci�n.
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ListaCompra compra = new ListaCompra();

		boolean si = false;
		do {
			String producto = InterfazUsuario.getString(sc, "Escribe el nombre del producto: ");
			double cantidad = InterfazUsuario.getDouble(sc, "Escribe la cantidad: ");
			compra.crearProducto(producto, cantidad);
			si = InterfazUsuario.confirmar(sc, "Deseas añadir otro producto");
		} while (si);
		sc.close();
		try {
			PersistenciaListaCompra.guardar(compra);
			InterfazUsuario.escribirListaCompra(compra);
		} catch (IOException e) {
			System.out.println("Hay un problema con el archivo: " + e.getMessage());
		}
		System.out.println("FIN");

	}

}
