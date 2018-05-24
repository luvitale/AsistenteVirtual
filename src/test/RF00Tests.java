package test;

import clase.Asistente;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class RF00Tests {

	public final static String USUARIO = "delucas"; 
	
	Asistente jenkins;
	
	@Before
	public void setup() {
		jenkins = new Asistente("jenkins");
	}
	
	@Test
	public void sinsentido() {
		String[] mensajes = {
				"Este mensaje no tiene sentido @jenkins"
		};
		for (String mensaje : mensajes) {
			Assert.assertEquals(
					"Disculpa... no entiendo el pedido, @delucas ¿podrías repetirlo?",
					jenkins.escuchar(mensaje)
			);
		}
	}
	
	@Test
	public void sinDirigidoAsistente() {
		String[] mensajes = {
				"Este mensaje no tiene sentido"
		};
		for (String mensaje : mensajes) {
			Assert.assertEquals(
					"Te estás dirigiendo a mí, @delucas?. Me llamo @jenkins.",
					jenkins.escuchar(mensaje)
			);
		}
	}

}
