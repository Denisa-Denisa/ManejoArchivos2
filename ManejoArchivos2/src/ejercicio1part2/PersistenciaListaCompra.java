package ejercicio1part2;

import java.io.*;

public class PersistenciaListaCompra {
	private final static String NOMBRE_ARCHIVO = "lista_compra.dat";
	private final static String SEPARADOR = "|";
	
	public static void guardar(ListaCompra compra) throws IOException {
		FileWriter fw = null;
		BufferedWriter bw = null;
		try {
			fw = new FileWriter(NOMBRE_ARCHIVO);
			bw = new BufferedWriter(fw);
			
			for(ElementoListaCompra e : compra.getLista()) {
				bw.write(e.getProducto() + SEPARADOR + e.getCantidad());
				bw.newLine();
			}
			bw.flush();
		} catch(IOException e) {
			System.out.println(e);
			throw e;
		} finally {
			if (bw!=null) {
				bw.close();
			}
			if (fw!=null) {
				fw.close();
			}
		}
	}
	public static ListaCompra cargar() throws IOException {
		FileReader fr = null;
		BufferedReader br = null;
		ListaCompra compra = new ListaCompra();
		try {
			fr = new FileReader(NOMBRE_ARCHIVO);
			br = new BufferedReader(fr);
			String fila= "";
			
			do {
				fila = br.readLine();
				if (fila != null && fila.contains(SEPARADOR)) {
					String[] data = fila.split("\\" + SEPARADOR);
					try {
						compra.crearProducto(data[0], Double.parseDouble(data[1]));
					} catch (NumberFormatException e) {
						System.out.printf("La fila: %s no se ha podido leer.%n", fila);
					}
				}
			} while (fila != null);

		} catch(FileNotFoundException e) {
			System.out.println("No se ha encontrado una lista.");
		} catch(IOException e) {
			System.out.println(e);
			throw e;
		} finally {
			if (br!=null) {
				br.close();
			}
			if (fr!=null) {
				fr.close();
			}
		}
		
		return compra;
		
	}
}
