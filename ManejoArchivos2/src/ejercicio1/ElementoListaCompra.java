package ejercicio1;

public class ElementoListaCompra {
	private String producto;
	private double cantidad;
	
	public ElementoListaCompra(String producto, double cantidad) {
		super();
		this.producto = producto;
		this.cantidad = cantidad;
	}

	public String getProducto() {
		return producto;
	}

	public void setProducto(String producto) {
		this.producto = producto;
	}

	public double getCantidad() {
		return cantidad;
	}

	public void setCantidad(double cantidad) {
		this.cantidad = cantidad;
	}
	
	
}
