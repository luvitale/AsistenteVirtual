package test;

import clase.Asistente;

//import java.text.ParseException;
//import java.text.SimpleDateFormat;
//import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class RF04Tests {

	public final static String USUARIO = "delucas";
	public final static Date FECHA_HORA = new GregorianCalendar(2018, 3, 1, 15, 15, 0).getTime();
	
	Asistente jenkins;
	
	@Before
	public void setup() {
		jenkins = new Asistente("jenkins");
	}
	
	@Test
	public void diaDentroDe() {
		
		Assert.assertEquals(
				"@delucas será el lunes 2 de abril de 2018",
				jenkins.escuchar("@jenkins qué día será mañana?")
			);
		
		Assert.assertEquals(
				"@delucas será el martes 3 de abril de 2018",
				jenkins.escuchar("@jenkins qué día será dentro de 2 días?")
			);

		Assert.assertEquals(
				"@delucas será el lunes 23 de abril de 2018",
				jenkins.escuchar("@jenkins qué día será dentro de 22 días?")
			);
		
		Assert.assertEquals(
				"@delucas será el viernes 1 de junio de 2018",
				jenkins.escuchar("@jenkins qué día será dentro de 2 meses?")
			);
		
		Assert.assertEquals(
				"@delucas será el miércoles 1 de abril de 2020",
				jenkins.escuchar("@jenkins qué día será dentro de 2 años?")
			);
	}
	
	@Test
	public void diaHace() {
		Assert.assertEquals(
				"@delucas fue el sábado 31 de marzo de 2018",
				jenkins.escuchar("@jenkins qué día fue ayer?")
			);
		
		Assert.assertEquals(
				"@delucas fue el jueves 29 de marzo de 2018",
				jenkins.escuchar("@jenkins qué día fue hace 3 días?")
			);
		
		Assert.assertEquals(
				"@delucas fue el jueves 1 de febrero de 2018",
				jenkins.escuchar("@jenkins qué día fue hace 2 meses?")
			);
		
		Assert.assertEquals(
				"@delucas fue el viernes 1 de abril de 2016",
				jenkins.escuchar("@jenkins qué día fue hace 2 años?")
			);
	}
	
	@Test
	public void tiempoDesde() {
		
		Assert.assertEquals(
				"@delucas entre el 1 de abril de 2017 y el 1 de abril de 2018 pasaron 365 días",
				jenkins.escuchar("@jenkins cuántos días pasaron desde el 1 de abril de 2017?")
			);
		
		Assert.assertEquals(
				"@delucas entre el 2 de abril de 2017 y el 1 de abril de 2018 pasaron 364 días",
				jenkins.escuchar("@jenkins cuántos días pasaron desde el 2 de abril de 2017?")
			);
		
		Assert.assertEquals(
				"@delucas entre el 1 de abril de 2017 y el 1 de abril de 2018 pasaron 52 semanas",
				jenkins.escuchar("@jenkins cuántas semanas pasaron desde el 1 de abril de 2017?")
			);
		

		Assert.assertEquals(
				"@delucas entre el 1 de abril de 2017 y el 1 de abril de 2018 pasaron 12 meses",
				jenkins.escuchar("@jenkins cuántos meses pasaron desde el 1 de abril de 2017?")
			);

		Assert.assertEquals(
				"@delucas entre el 1 de abril de 2017 y el 1 de abril de 2018 paso 1 año",
				jenkins.escuchar("@jenkins cuántos años pasaron desde el 1 de abril de 2017?")
			);

		Assert.assertEquals(
				"@delucas entre el 2 de abril de 2017 y el 1 de abril de 2018 pasaron 0 años",
				jenkins.escuchar("@jenkins cuántos años pasaron desde el 2 de abril de 2017?")
			);
		
		Assert.assertEquals(
				"@delucas pasaron 31 días",
				jenkins.escuchar("@jenkins cuántos días pasaron desde el 1 de marzo?")
			);
		
		Assert.assertEquals(
				"@delucas pasaron 4 semanas",
				jenkins.escuchar("@jenkins cuántas semanas pasaron desde el 1 de marzo?")
			);
		
		Assert.assertEquals(
				"@delucas paso 1 mes",
				jenkins.escuchar("@jenkins cuántos meses pasaron desde el 1 de marzo?")
			);
		
		Assert.assertEquals(
				"@delucas pasaron 3 meses",
				jenkins.escuchar("@jenkins cuántos meses pasaron desde el 1 de enero?")
			);
		
		Assert.assertEquals(
				"@delucas pasaron 0 años",
				jenkins.escuchar("@jenkins cuántos años pasaron desde el 1 de marzo?")
			);
		
		// agregar casos de prueba
	}
	
	@Test
	public void tiempoHasta() {
		Assert.assertEquals(
				"@delucas faltan 9 días",
				jenkins.escuchar("@jenkins cuántos días faltan para el 10 de abril?")
			);
		
		
		Assert.assertEquals(
				"@delucas entre el 1 de abril de 2018 y el 1 de abril de 2019 faltan 365 días",
				jenkins.escuchar("@jenkins cuántos días faltan para el 1 de abril de 2019?")
			);
		
		Assert.assertEquals(
				"@delucas entre el 1 de abril de 2018 y el 2 de abril de 2019 faltan 366 días",
				jenkins.escuchar("@jenkins cuántos días faltan para el 2 de abril de 2019?")
			);

		Assert.assertEquals(
				"@delucas entre el 1 de abril de 2018 y el 1 de abril de 2019 faltan 52 semanas",
				jenkins.escuchar("@jenkins cuántas semanas faltan para el 1 de abril de 2019?")
			);
		

		Assert.assertEquals(
				"@delucas entre el 1 de abril de 2018 y el 1 de abril de 2019 faltan 12 meses",
				jenkins.escuchar("@jenkins cuántos meses faltan para el 1 de abril de 2019?")
			);

		Assert.assertEquals(
				"@delucas entre el 1 de abril de 2018 y el 1 de abril de 2019 falta 1 año",
				jenkins.escuchar("@jenkins cuántos años faltan para el 1 de abril de 2019?")
			);

		Assert.assertEquals(
				"@delucas entre el 1 de abril de 2018 y el 31 de marzo de 2019 faltan 0 años",
				jenkins.escuchar("@jenkins cuántos años faltan para el 31 de marzo de 2019?")
			);
		
		Assert.assertEquals(
				"@delucas faltan 61 días",
				jenkins.escuchar("@jenkins cuántos días faltan para el 1 de junio?")
			);
		
		Assert.assertEquals(
				"@delucas faltan 8 semanas",
				jenkins.escuchar("@jenkins cuántas semanas faltan para el 1 de junio?")
			);
		
		Assert.assertEquals(
				"@delucas faltan 2 meses",
				jenkins.escuchar("@jenkins cuántos meses faltan para el 1 de junio?")
			);
		
		Assert.assertEquals(
				"@delucas faltan 0 años",
				jenkins.escuchar("@jenkins cuántos años faltan para el 1 de junio?")
			);
		
		// agregar casos de prueba
	}
	
}
