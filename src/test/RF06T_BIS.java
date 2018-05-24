package test;

import static org.junit.Assert.*;

import org.junit.Test;

import util.MyCalculo;

public class RF06T_BIS {

	MyCalculo calc = new MyCalculo();

	@Test
	public void sumaDeNumerosDeUnaCifra() {
		assertTrue(calc.calcular("4+5") == 4.0 + 5.0);
	}

	@Test
	public void restaDeNumerosDeUnaCifra() {
		assertTrue(calc.calcular("5-9") == 5.0 - 9.0);
	}

	@Test
	public void multiplicacionDeNumerosDeUnaCifra() {
		assertTrue(calc.calcular("8*9") == 8.0 * 9.0);
	}

	@Test
	public void divisionDeNumerosDeUnaCifra() {
		assertTrue(calc.calcular("8/5") == 8.0 / 5.0);
	}

	@Test
	public void potenciacionDeNumerosDeUnaCifra() {
		assertTrue(calc.calcular("4^6") == Math.pow(4.0, 6.0));
	}

	@Test
	public void porcentaje() {
		assertTrue(calc.calcular("13%") == 13.0 / 100.0);
	}

	@Test
	public void porcentajeConMultiplicacion() {
		assertTrue(calc.calcular("21%*3000") == (21.00 / 100.00) * 3000);
	}

	@Test
	public void conNumerosDeVariasCifras() {
		assertTrue(calc.calcular("485+321") == 485.0 + 321.0);
	}

	@Test
	public void conNumerosDecimales() {
		assertTrue(calc.calcular("32.45*123.21") == 32.45 * 123.21);
	}

	@Test
	public void sumaDeVariosNumeros() {
		assertTrue(calc.calcular("25.05+32.2+8+3") == 25.05 + 32.2 + 8.0 + 3.0);
	}

	@Test
	public void multiplesOperaciones() {
		assertTrue(calc.calcular("23.3+4*23+5.9-2^3+5/25+30*15%-8") == 23.3 + 4.0 * 23.0 + 5.9 - Math.pow(2.0, 3.0) + 5.0 / 25.0 + 30.0 * 15.0 / 100.0 - 8.0);
	}

	@Test
	public void conParentesis() {
		assertTrue(calc.calcular("25+8+(3*2-1)-5*(3+2/5)") == 25.0 + 8.0 + (3.0 * 2.0 - 1.0) - 5.0 * (3.0 + 2.0 / 5.0));
	}

	@Test
	public void conNumerosNegativos() {
		assertTrue(calc.calcular("-23+5*-2+5-3/(-2*3)-5") == -23.0 + 5.0 * - 2.0 + 5.0 - 3.0 / (-2.0 * 3.0) - 5.0);
	}
	
	@Test
	public void raizCuadrada() {
		assertTrue(calc.calcular("√25") == Math.sqrt(25.0));
	}
	
	@Test
	public void raizCubica() {
		assertTrue(calc.calcular("2 + 5 * 3√81 + 3") == 2.0 + 5.0 * Math.pow(81.0, 1.0 / 3.0) + 3.0);
	}
	
}
