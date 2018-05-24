package test;

import clase.Asistente;


import java.util.Date;
import java.util.GregorianCalendar;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class RF03Tests {

	public final static String USUARIO = "delucas";
	public final static Date FECHA_HORA = new GregorianCalendar(2018, 3, 1, 15, 15, 0).getTime();
	
	Asistente jenkins;
	
	@Before
	public void setup() {
		jenkins = new Asistente("jenkins");
	}
	
	@Test
	public void hora() {
		String[] mensajes = {
				"¿qué hora es, @jenkins?",
				"@jenkins, la hora por favor",
				"me decís la hora @jenkins?"
		};
		for (String mensaje : mensajes) {
			Assert.assertEquals(
					"@delucas son las 3:15 PM",
					jenkins.escuchar(mensaje)
			);
		}
	}
	
	@Test
	public void fecha() {
		String[] mensajes = {
				"¿qué día es, @jenkins?",
				"@jenkins, la fecha por favor",
				"me decís la fecha @jenkins?"
		};
		for (String mensaje : mensajes) {
			Assert.assertEquals(
					"@delucas hoy es 1 de abril de 2018",
					jenkins.escuchar(mensaje)
			);
		}
	}
	
	@Test
	public void diaDeLaSemana() {
		String[] mensajes = {
				"¿qué día de la semana es hoy, @jenkins?"
		};
		for (String mensaje : mensajes) {
			Assert.assertEquals(
					"@delucas hoy es domingo",
					jenkins.escuchar(mensaje)
			);
		}
	}
	
}
