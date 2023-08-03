package ejercicio3;

import java.io.*;

public class AgendaArchivo {
	private static final String NOMBRE_ARCHIVO = "agenda.dat";
	
	public Agenda cargar() throws IOException {
		Agenda agenda = new Agenda();
		FileReader fr = null;
		BufferedReader br = null;
		try {
			fr = new FileReader(NOMBRE_ARCHIVO);
			br = new BufferedReader(fr);
			String fila= "";

			int id=0; // id del ultimo contacto cargado.
			do {
				fila = br.readLine();
				if (fila != null) {
					if (fila.startsWith("Contacto")) {
						String contacto = fila.substring(10);
						id = agenda.crearContacto(contacto);
					} else if (fila.startsWith("FormaContactoDireccion")) {
						String formaDireccion = fila.substring(24);
						agenda.crearDireccion(id, formaDireccion);
						
					} else if (fila.startsWith("FormaContactoTelefono")) {
						String formaTelefono = fila.substring(23);
						agenda.crearTelefono(id, formaTelefono);
						
					} else if (fila.startsWith("FormaContactoEmail")) {
						String formaEmail = fila.substring(20);
						String[] fe = formaEmail.split("\\|");
						int idF = Integer.parseInt(fe[0]);
						TipoEmail tipo = TipoEmail.valueOf(fe[1]);
						String email = fe[2];
						agenda.crearEmail(id, idF, tipo, email);
						
					}
					
				}

			} while (fila != null);

		} catch(FileNotFoundException e) {
			System.out.println("No se han encontrado tareas.");
		} catch(IOException e) {
			System.out.println(e);

		} finally {
			if (br!=null) {
				br.close();
			}
			if (fr!=null) {
				fr.close();
			}
		}
		return agenda;
	}
	
	
	public void guardar(Agenda agenda) throws IOException {
		FileWriter fw = null;
		BufferedWriter bw = null;
		try {
			fw = new FileWriter(NOMBRE_ARCHIVO);
			bw = new BufferedWriter(fw);
			
			for(Contacto contacto : agenda.getContactos()) {
				bw.write(contacto.getClass().getSimpleName() + ": " + contacto.toString());
				bw.newLine();
				for(FormaContacto fc : contacto.getFormasContacto()) {
					bw.write(fc.getClass().getSimpleName() + ": " + fc.toString());
					bw.newLine();
				}
				
			}
			bw.flush();
		} catch(IOException e) {
			System.out.println(e);
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
