package ejercicio3;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Contacto {
	protected final String SEPARADOR = "|";
	
	private int id;
	private String nombre;
	private String apellido1;
	private String apellido2;
	private LocalDate fechaNacimiento;
	private List<FormaContacto> formas;

	public Contacto(int id, String nombre, String apellido1, String apellido2, LocalDate fechaNacimiento) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.apellido1 = apellido1;
		this.apellido2 = apellido2;
		this.fechaNacimiento = fechaNacimiento;
		formas = new ArrayList<>();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido1() {
		return apellido1;
	}

	public void setApellido1(String apellido1) {
		this.apellido1 = apellido1;
	}

	public String getApellido2() {
		return apellido2;
	}

	public void setApellido2(String apellido2) {
		this.apellido2 = apellido2;
	}

	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(LocalDate fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public static Contacto fromString(String contacto) {
		String[] contact = contacto.split("\\|");
		int id = Integer.parseInt(contact[0]);
		String nombre = contact[1];
		String apellido1 = contact[2];
		String apellido2 = contact[3];
		LocalDate fechaNacimiento = LocalDate.parse(contact[4], DateTimeFormatter.ofPattern("yyyy-MM-dd"));
		return new Contacto(id, nombre, apellido1, apellido2, fechaNacimiento);
	}
	
	public void crearTelefono(String forma) {
		FormaContactoTelefono tel = FormaContactoTelefono.fromString(forma);
		formas.add(tel);
	}
	public void crearTelefono(int id, TipoTelefono tipo, String telefono) {
		if (!existe(id)) {
			FormaContactoTelefono tel = new FormaContactoTelefono(id, tipo, telefono);
			formas.add(tel);
		}
	}

	public void crearEmail(int id, TipoEmail tipo, String email) {
		if (!existe(id)) {
			FormaContactoEmail e = new FormaContactoEmail(id, tipo, email);
			formas.add(e);
		}
	}

	public void crearDireccion(String forma) {
		FormaContactoDireccion dir = FormaContactoDireccion.fromString(forma);
		formas.add(dir);
	}
	public void crearDireccion(int id, TipoDireccion tipo, Direccion direccion) {
		crearDireccion(id, tipo, direccion.getTipoVia(), direccion.getNombre(),
				direccion.getNumero(), direccion.getPortal(),
				direccion.getPiso(), direccion.getPuerta(), direccion.getCodigoPostal(),
				direccion.getCiudad(), direccion.getProvincia(), direccion.getPais());
	}

	public void crearDireccion(int id, TipoDireccion tipo, TipoVia tipoVia, String nombre, 
			int numero, String portal, int piso, String puerta, String codigoPostal, 
			String ciudad, String provincia, String pais) {
		if (!existe(id)) {
			FormaContactoDireccion e = new FormaContactoDireccion(id, tipo, tipoVia, nombre, numero, portal, piso,
					puerta, codigoPostal, ciudad, provincia, pais);
			formas.add(e);
		}
	}

	public void eliminarFormaContacto(int id) {
		FormaContacto forma = buscar(id);
		if (forma != null) {
			formas.remove(forma);
		}
	}
	public void eliminarTelefono(String telefono) {
		FormaContactoTelefono t = buscarTelefono(telefono);
		if (t != null) {
			formas.remove(t);
		}
	}
	public FormaContacto[] getFormasContacto() {
		FormaContacto[] fc = new FormaContacto[formas.size()];
		return formas.toArray(fc);
	}
	private FormaContactoTelefono buscarTelefono(String telefono) {
		for(FormaContacto forma: formas) {
			if (forma instanceof FormaContactoTelefono) {
				FormaContactoTelefono tel = (FormaContactoTelefono) forma;
				if (tel.getTelefono().equals(telefono)) {
					return tel;
				}
			}
		}
		return null;
	}
	
	public FormaContacto getFormaContacto(int id) {
		FormaContacto forma = buscar(id);
		return forma; // .clone();
	}
	
	public void setTelefono(int id, String telefono) {
		FormaContacto forma = buscar(id);
		if (forma instanceof FormaContactoTelefono) {
			((FormaContactoTelefono) forma).setTelefono(telefono);
		}
	}
	public void setEmail(int id, String email) {
		FormaContacto forma = buscar(id);
		if (forma instanceof FormaContactoEmail) {
			((FormaContactoEmail) forma).setEmail(email);
		}
	}
	// TODO resto de campos
	public String getTelefono(int id) {
		FormaContacto forma = buscar(id);
		if (forma instanceof FormaContactoTelefono) {
			return ((FormaContactoTelefono) forma).getTelefono();
		}
		return null;
	}
	private FormaContacto buscar(int id) {
		for (FormaContacto f : formas) {
			if (f.equals(id)) {
				return f;
			}
		}
		return null;
	}

	public boolean existe(int id) {
		return buscar(id) != null;
	}
	
	public boolean equals(int id) {
		return this.id == id;
	}
	public boolean equals(Contacto contacto) {
		return contacto.equals(this.id);
	}
	
	public String toString() {
		return id + SEPARADOR + nombre + SEPARADOR + 
				apellido1 + SEPARADOR + 
				apellido2 + SEPARADOR + fechaNacimiento.toString();
	}
} 
