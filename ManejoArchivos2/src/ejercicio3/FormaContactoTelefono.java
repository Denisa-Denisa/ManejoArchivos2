package ejercicio3;

public class FormaContactoTelefono extends FormaContacto {
	
	private TipoTelefono tipo;
	private String telefono;
	
	public FormaContactoTelefono(int id, TipoTelefono tipo, String telefono) {
		super(id);
		this.tipo = tipo;
		this.telefono = telefono;
	}

	public static FormaContactoTelefono fromString(String forma) {
		String[] ft = forma.split("\\|");
		int idF = Integer.parseInt(ft[0]);
		TipoTelefono tipo = TipoTelefono.valueOf(ft[1]);
		String telefono = ft[2];
		return new FormaContactoTelefono(idF, tipo, telefono);
	}
	public TipoTelefono getTipo() {
		return tipo;
	}

	public void setTipo(TipoTelefono tipo) {
		this.tipo = tipo;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	
	public String toString() {
		return super.toString() + SEPARADOR +
				tipo + SEPARADOR +
				telefono;
	}
	
}
