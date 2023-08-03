package ejercicio3;

public class FormaContactoEmail extends FormaContacto {

	private TipoEmail tipo;
	private String email;
	
	public FormaContactoEmail(int id, TipoEmail tipo, String email) {
		super(id);
		this.tipo = tipo;
		this.email = email;
	}

	public TipoEmail getTipo() {
		return tipo;
	}

	public void setTipo(TipoEmail tipo) {
		this.tipo = tipo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public String toString() {
		return super.toString() + SEPARADOR +
				tipo + SEPARADOR +
				email;
	}
}
