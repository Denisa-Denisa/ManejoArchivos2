package ejercicio3;

public abstract class FormaContacto {
	protected final String SEPARADOR = "|";
	
	int id;

	public FormaContacto(int id) {
		super();
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public boolean equals(int id) {
		return this.id == id;
	}
	public boolean equals(FormaContacto forma) {
		return this.id == forma.getId();
	}
	
	public String toString() {
		return String.valueOf(id);
	}
}
