package ejercicio1part2;

import java.io.IOException;
import java.util.Scanner;

public class Ejercicio1Part2 {
	/*
	 * Crea una aplicaci�n para gestionar la lista de la compra. Vamos a pedir por
	 * teclado el nombre del producto y la cantidad. Deber�s preguntar al usuario si
	 * quiere a�adir nuevo producto a la lista. En el caso de que no, se termina el
	 * programa y se deber� guardar la lista en un archivo de texto. Escribir en la
	 * consola la lista de la compra antes de terminar la aplicaci�n.
	 * 
	 * 2� PARTE Al iniciar la aplicaci�n cargar la lista de la compra desde el
	 * archivo si hay. Mostrar un menu con las siguientes opciones: 1. A�adir
	 * producto 2. Eliminar producto 3. Eliminar la lista 0. Salir
	 */
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);

		try {
			int op;
			ListaCompra compra = PersistenciaListaCompra.cargar();
			InterfazUsuario.escribirListaCompra(compra);
			System.out.println();
			do {
				InterfazUsuario.escribirCabecera("menu principal");
				System.out.println();
				op = InterfazUsuario.escribirMenuPrincipal(sc);
				System.out.println();
				switch (op) {
				case 1:
					boolean si = false;
					do {
						ElementoListaCompra e = InterfazUsuario.perdirDatos(sc);
						compra.crearProducto(e.getProducto(), e.getCantidad());
						si = InterfazUsuario.confirmar(sc, "Deseas añadir otro producto");
					} while (si);
					break;
				case 2:
					int index;
					do {
						InterfazUsuario.escribirCabecera("Eliminar producto");
						System.out.println();
						index = InterfazUsuario.escribirEliminarProducto(sc, compra);
						if (index > 0) {
							compra.eliminarProducto(index);
						}
					} while (index != 0);
					break;
				case 3:
					InterfazUsuario.escribirCabecera("eliminar la lista de la compra");
					System.out.println();
					InterfazUsuario.escribirListaCompra(compra);
					System.out.println();
					boolean borrar = InterfazUsuario.confirmar(sc, "Estas seguro");
					if (borrar) {
						compra.vaciar();
					}
					break;
				case 0:
					try {
						PersistenciaListaCompra.guardar(compra);
					} catch (IOException e) {
						System.out.println("Hay un problema con el archivo: " + e.getMessage());
					}
					break;
				default:
					System.out.println("Opci�n no valida.");
				}
			} while (op != 0);
		} catch (IOException e) {
			System.out.println("Hay un problema con el archivo: " + e.getMessage());
		}
		sc.close();
		System.out.println("FIN");

	}

}
