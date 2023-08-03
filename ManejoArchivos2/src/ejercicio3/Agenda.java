package ejercicio3;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Agenda {
	private List<Contacto> contactos;

	public Agenda() {
		super();
		contactos = new ArrayList<>();
	}
	
	public int crearContacto(String contacto) {
		Contacto c = Contacto.fromString(contacto);
		contactos.add(c);
		return c.getId();
	}
	public void crearContacto(int id, String nombre, 
			String apellido1, String apellido2, LocalDate fechaNacimiento) {
		
		if (!existe(id)) {
			Contacto c = new Contacto(id, nombre, apellido1, apellido2, fechaNacimiento);
			contactos.add(c);
		}
	}
	
	public void eliminarContacto(int id) {
		Contacto c = buscar(id);
		if (c != null) {
			contactos.remove(c);
		}
	}
	
	public Contacto getContacto(int id) {
		Contacto c = buscar(id);
		return c; // .clone();
	}
	
	public Contacto[] getContactos() {
		Contacto[] array = new Contacto[contactos.size()];
		return contactos.toArray(array); //
	}
	
	public void crearTelefono(int idContacto, String forma) {
		Contacto contacto = buscar(idContacto);
		contacto.crearTelefono(forma);
	}
	public void crearTelefono(int idContacto, 
			                  int idForma, TipoTelefono tipo, String telefono) {
		Contacto contacto = buscar(idContacto);
		if (contacto != null) {
			if (!contacto.existe(idForma)) {
				contacto.crearTelefono(idForma, tipo, telefono);
			}
		}
	}

	public void crearEmail(int idContacto, 
						   int idForma, TipoEmail tipo, String email) {
		Contacto contacto = buscar(idContacto);
		if (contacto != null) {
			if (!contacto.existe(idForma)) {
				contacto.crearEmail(idForma, tipo, email);
			}
		}
	}

	public void crearDireccion(int idContacto, String forma) {
		Contacto contacto = buscar(idContacto);
		if (contacto!=null) {
			contacto.crearDireccion(forma);
		}
	}
	public void crearDireccion(int idContacto, int idForma, TipoDireccion tipo, Direccion direccion) {
		crearDireccion(idContacto, idForma, tipo, direccion.getTipoVia(), 
				direccion.getNombre(), direccion.getNumero(), direccion.getPortal(),
				direccion.getPiso(), direccion.getPuerta(), direccion.getCodigoPostal(),
				direccion.getCiudad(), direccion.getProvincia(), direccion.getPais());
	}
	public void crearDireccion(int idContacto, int idForma, TipoDireccion tipo, 
			TipoVia tipoVia, String nombre, int numero, String portal, int piso, 
			String puerta, String codigoPostal, String ciudad, String provincia, 
				String pais) {
		Contacto contacto = buscar(idContacto);
		if (contacto != null) {
			if (!contacto.existe(idForma)) {
				contacto.crearDireccion(idForma, tipo, tipoVia, nombre, 
						numero, portal, piso,
						puerta, codigoPostal, ciudad, provincia, pais);
			}
		}
	}
	
	public FormaContacto getFormaContacto(int idContacto, int idFormaContacto) {
		Contacto contacto = buscar(idContacto);
		if (contacto == null) return null;
		
		FormaContacto fc = contacto.getFormaContacto(idFormaContacto);
		return fc;
	}
	public void setNombreContacto(int id, String nuevoNombre) {
		Contacto c = buscar(id);
		c.setNombre(nuevoNombre);
	}
	public String getNombreContacto(int id) {
		Contacto c = buscar(id);
		return c.getNombre();
	}
	

	
	private Contacto buscar(int id) {
		for(Contacto c: contactos) {
			if (c.equals(id)) {
				return c;
			}
		}
		return null;
	}
	public boolean existe(int id) {
		return buscar(id) != null;
	}
	
	public void escribir() {
		for(Contacto contacto:contactos) {
			System.out.println(contacto);
			for(FormaContacto forma: contacto.getFormasContacto()) {
				System.out.println(forma);
			}
			System.out.println("-------------------------");
		}
	}
	
}
