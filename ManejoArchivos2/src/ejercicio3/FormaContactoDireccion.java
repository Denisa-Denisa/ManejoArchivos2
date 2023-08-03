package ejercicio3;

public class FormaContactoDireccion extends FormaContacto {
	private TipoDireccion tipo;
	private Direccion direccion;
	
	public FormaContactoDireccion(int id, TipoDireccion tipo, Direccion direccion) {
		super(id);
		this.tipo = tipo;
		this.direccion = direccion;
	}
	public FormaContactoDireccion(int id, TipoDireccion tipo, 
			TipoVia tipoVia, String nombre, int numero, String portal, 
			int piso, String puerta,
			String codigoPostal, String ciudad, String provincia, String pais) {
		super(id);
		this.tipo = tipo;
		this.direccion = new Direccion(tipoVia, nombre, numero, portal, piso, puerta,
				codigoPostal, ciudad, provincia, pais);
	}
	
	public static FormaContactoDireccion fromString(String forma) {
		String[] dir = forma.split("\\|");
		int idF = Integer.parseInt(dir[0]);
		TipoDireccion tipo = TipoDireccion.valueOf(dir[1]);
		TipoVia via = TipoVia.valueOf(dir[2]);
		String nombre = dir[3];
		int numero = Integer.parseInt(dir[4]);
		String portal = dir[5];
		int piso = Integer.parseInt(dir[6]);
		String puerta = dir[7]; 
		String codigoPostal = dir[8];
		String ciudad = dir[9];
		String provincia = dir[10];
		String pais = dir[11];
		return new FormaContactoDireccion(idF, tipo, via, nombre, 
				numero, portal, piso,
				puerta, codigoPostal, ciudad, provincia, pais);
	}
	
	public TipoDireccion getTipo() {
		return tipo;
	}
	public void setTipo(TipoDireccion tipo) {
		this.tipo = tipo;
	}
	public Direccion getDireccion() {
		return direccion;
	}
	public void setDireccion(Direccion direccion) {
		this.direccion = direccion;
	}
	
	public TipoVia getTipoVia() {
		return direccion.getTipoVia();
	}

	public void setTipoVia(TipoVia tipoVia) {
		direccion.setTipoVia(tipoVia);
	}

	public String getNombre() {
		return direccion.getNombre();
	}

	public void setNombre(String nombre) {
		direccion.setNombre(nombre);
	}

	public int getNumero() {
		return direccion.getNumero();
	}

	public void setNumero(int numero) {
		direccion.setNumero(numero);
	}

	public String getPortal() {
		return direccion.getPortal();
	}

	public void setPortal(String portal) {
		direccion.setPortal(portal);
	}

	public int getPiso() {
		return direccion.getPiso();
	}

	public void setPiso(int piso) {
		direccion.setPiso(piso);
	}

	public String getPuerta() {
		return direccion.getPuerta();
	}

	public void setPuerta(String puerta) {
		direccion.setPuerta(puerta);
	}

	public String getCodigoPostal() {
		return direccion.getCodigoPostal();
	}

	public void setCodigoPostal(String codigoPostal) {
		direccion.setCodigoPostal(codigoPostal);
	}

	public String getCiudad() {
		return direccion.getCiudad();
	}

	public void setCiudad(String ciudad) {
		direccion.setCiudad(ciudad);
	}

	public String getProvincia() {
		return direccion.getProvincia();
	}

	public void setProvincia(String provincia) {
		direccion.setProvincia(provincia);
	}

	public String getPais() {
		return direccion.getPais();
	}

	public void setPais(String pais) {
		direccion.setPais(pais);
	}
	
	public String toString() {
		return super.toString() + SEPARADOR +
				tipo + SEPARADOR +
				direccion;
	}
}
