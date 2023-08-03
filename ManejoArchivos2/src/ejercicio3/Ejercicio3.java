package ejercicio3;

import java.io.IOException;
import java.time.LocalDate;

public class Ejercicio3 {
/*
 * Realiza una agenda de contactos.
 * De cada contacto debemos saber:
 * - id
 * - nombre
 * - apellido1
 * - apellido2
 * - fecha nacimiento
 * - lista de telefono, email, direccion (formas de contacto)
 * Del contacto por telefono debemos saber:
 * - id
 * - tipo (personal, trabajo, casa, m�vil)
 * - n�mero de tel�fono
 * Del contacto por email debemos saber:
 * - id
 * - tipo (personal o trabajo)
 * - direcci�n de correo electr�nico
 * Del contacto por direccion debemos saber:
 * - id
 * - tipo (Primera vivienda, Segunda vivienda)
 * - direccion 
 * De la direcci�n:
 * - tipoVia (Calle, Avenida, Plaza), 
 * - nombre, 
 * - n�mero, 
 * - portal, 
 * - piso, 
 * - puerta, 
 * - codigo postal, 
 * - ciudad, 
 * - provincia, 
 * - pais)
 * El id de las formas de contacto debe ser distinto para todos.
 * El programa debe poder realizar las siguientes acciones:
 * - Crear, eliminar o consultar un contacto
 * - Escribir los datos de un contacto incluido las formas de contacto.
 * - A�adir telefono, email, direcci�n a un contacto.
 * - Eliminar una forma de contacto por su id.
 * - Cambiar cualquier campo de las formas de contacto.
 * - Cargar/Guardar la agenda desde/a un archivo de texto.
 * 
 */
	public static void main(String[] args) {
		Agenda agenda = new Agenda();
		
		Direccion direccion = new Direccion(TipoVia.AVENIDA, "dfd", 1,"1",2, "B", 
					"23233", "Talavera", "Toledo", "Espa�a");
		
		agenda.crearContacto(1, "pepe", "pepe", "pepe", LocalDate.of(2000, 3, 3));
		agenda.crearDireccion(1, 1, TipoDireccion.PRIMERA_VIVIENDA, direccion);
		agenda.crearTelefono(1, 2, TipoTelefono.MOVIL, "666666666");
		agenda.crearEmail(1, 3, TipoEmail.PERSONAL, "pepe@pepe.com");
		agenda.crearContacto(2, "pepa", "pepa", "pepa", LocalDate.of(2001, 3, 3));
		agenda.crearDireccion(2, 4, TipoDireccion.PRIMERA_VIVIENDA, direccion);
		agenda.crearTelefono(2, 5, TipoTelefono.PERSONAL, "555555555");
		agenda.crearEmail(2, 6, TipoEmail.PERSONAL, "pepa@pepa.com");

		AgendaArchivo aa = new AgendaArchivo();
		try {
			aa.guardar(agenda);
			agenda = aa.cargar();
			System.out.println();
			agenda.escribir();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	


}
