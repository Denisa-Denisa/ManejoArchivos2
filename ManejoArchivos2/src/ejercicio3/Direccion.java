package ejercicio3;

public class Direccion {
	private static final String SEPARADOR = "|";
	
	private TipoVia tipoVia;
	private String nombre;
	private int numero;
	private String portal;
	private int piso;
	private String puerta;
	private String codigoPostal;
	private String ciudad;
	private String provincia;
	private String pais;
	
	public Direccion(TipoVia tipoVia, String nombre, int numero, String portal, 
			int piso, String puerta,
			String codigoPostal, String ciudad, String provincia, String pais) {
		super();
		this.tipoVia = tipoVia;
		this.nombre = nombre;
		this.numero = numero;
		this.portal = portal;
		this.piso = piso;
		this.puerta = puerta;
		this.codigoPostal = codigoPostal;
		this.ciudad = ciudad;
		this.provincia = provincia;
		this.pais = pais;
	}

	public static Direccion fromString(String direccion) {
		String[] dir = direccion.split("\\|");
		TipoVia via = TipoVia.valueOf(dir[0]);
		String nombre = dir[1];
		int numero = Integer.parseInt(dir[2]);
		String portal = dir[3];
		int piso = Integer.parseInt(dir[4]);
		String puerta = dir[5]; 
		String codigoPostal = dir[6];
		String ciudad = dir[7];
		String provincia = dir[8];
		String pais = dir[9];
		return new Direccion(via, nombre, numero, portal, piso,
				puerta, codigoPostal, ciudad, provincia, pais);
	}
	public TipoVia getTipoVia() {
		return tipoVia;
	}

	public void setTipoVia(TipoVia tipoVia) {
		this.tipoVia = tipoVia;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getPortal() {
		return portal;
	}

	public void setPortal(String portal) {
		this.portal = portal;
	}

	public int getPiso() {
		return piso;
	}

	public void setPiso(int piso) {
		this.piso = piso;
	}

	public String getPuerta() {
		return puerta;
	}

	public void setPuerta(String puerta) {
		this.puerta = puerta;
	}

	public String getCodigoPostal() {
		return codigoPostal;
	}

	public void setCodigoPostal(String codigoPostal) {
		this.codigoPostal = codigoPostal;
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public String getProvincia() {
		return provincia;
	}

	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}
	
	public String toString() {
		return tipoVia + SEPARADOR + nombre + SEPARADOR + 
			   numero + SEPARADOR + portal  + SEPARADOR + 
			   piso + SEPARADOR + puerta + SEPARADOR + 
			   codigoPostal + SEPARADOR + ciudad + SEPARADOR + 
			   provincia + SEPARADOR + pais;
	}
}
