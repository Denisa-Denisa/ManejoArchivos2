package ejercicio1;

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
}
