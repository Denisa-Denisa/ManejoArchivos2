package ejercicio1part2;

import java.util.ArrayList;
import java.util.List;

public class ListaCompra {
	private List<ElementoListaCompra> lista = new ArrayList<>();

	public ListaCompra() {
		super();
	}
	
	public ElementoListaCompra[] getLista() {
		ElementoListaCompra[] compra = new ElementoListaCompra[lista.size()];
		return lista.toArray(compra);
	}
	
	public void crearProducto(String nombreProducto, double cantidad) {
		ElementoListaCompra e = new ElementoListaCompra(nombreProducto, cantidad);
		lista.add(e);
	}
	
	public void eliminarProducto(int indice) {
		int index = indice -1;
		if (index>=0 && index < lista.size()) {
			lista.remove(index);
		}
	}
	
	public void vaciar() {
		lista.clear();
	}
}
