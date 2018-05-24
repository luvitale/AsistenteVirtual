package util;

import java.util.HashMap;
import java.util.Map;

public class Convert {

	Map<String, Double> uMasa;
	Map<String, Double> uLongitud;
	Map<String, Double> uVolumen;
	Map<String, Double> uTiempo;

	private String unidad1;
	private String unidad2;
	private double valor;

	public Convert(String unidad1, String unidad2, double valor) {
		
		this.unidad1 = unidSingular(unidad1);
		this.unidad2 = unidSingular(unidad2);
		this.valor = valor;
		
		uMasa = new HashMap<String, Double>();
		uMasa.put("kilo", Double.valueOf(1));
		uMasa.put("gramo", Double.valueOf(1000));
		uMasa.put("tonelada", Double.valueOf(0.001));
		uMasa.put("onza", Double.valueOf(35.274));
		uMasa.put("libra", Double.valueOf(2.20462));
		uMasa.put("stone", Double.valueOf(0.157473));
		
		uLongitud = new HashMap<String, Double>();
		uLongitud.put("metro", Double.valueOf(1));
		uLongitud.put("centimetro", Double.valueOf(100));
		uLongitud.put("kilometro", Double.valueOf(0.001));
		uLongitud.put("pulgada",Double.valueOf(39.3701));
		uLongitud.put("yarda",Double.valueOf(1.09361));
		uLongitud.put("milla",Double.valueOf(0.000621371));
		
		uVolumen = new HashMap<String, Double>();
		uVolumen.put("litro", Double.valueOf(1));
		uVolumen.put("mililitro", Double.valueOf(1000));
		uVolumen.put("metro cubico", Double.valueOf(0.001));
		uVolumen.put("galon", Double.valueOf(0.264172));
		uVolumen.put("barril", Double.valueOf(0.0062898105697751));
		uVolumen.put("cuarto", Double.valueOf(1.056688209432594));

		uTiempo = new HashMap<String, Double>();
		uTiempo.put("milisegundo", Double.valueOf(1*7*24*60*60*100));
		uTiempo.put("segundo", Double.valueOf(1*7*24*60*60));
		uTiempo.put("minuto", Double.valueOf(1*7*24*60));
		uTiempo.put("hora", Double.valueOf(1*7*24));
		uTiempo.put("dia", Double.valueOf(1*7));
		uTiempo.put("semana", Double.valueOf(1));
		
	}
	
	public boolean mismasUnidades() {

		for(String unid1 : uMasa.keySet())
			if(unid1.equals(unidad1))
				for(String unid2 : uMasa.keySet())
					if(unid2.equals(unidad2))
						return true;
		
		for(String unid1 : uLongitud.keySet())
			if(unid1.equals(unidad1))
				for(String unid2 : uLongitud.keySet())
					if(unid2.equals(unidad2))
						return true;
		
		for(String unid1 : uVolumen.keySet())
			if(unid1.equals(unidad1))
				for(String unid2 : uVolumen.keySet())
					if(unid2.equals(unidad2))
						return true;
		
		for(String unid1 : uTiempo.keySet())
			if(unid1.equals(unidad1))
				for(String unid2 : uTiempo.keySet())
					if(unid2.equals(unidad2))
						return true;
		
		return false;
	}
		
	public double convertir() {
		
		for(String unid1 : uMasa.keySet())
			if(unid1.equals(unidad1))
				return (uMasa.get(unidad1)/uMasa.get(unidad2)) * valor;
					
		for(String unid1 : uLongitud.keySet())
			if(unid1.equals(unidad1))
				return (uLongitud.get(unidad1)/uLongitud.get(unidad2)) * valor;

		for(String unid1 : uVolumen.keySet())
			if(unid1.equals(unidad1))
				return (uVolumen.get(unidad1)/uVolumen.get(unidad2)) * valor;

		for(String unid1 : uTiempo.keySet())
			if(unid1.equals(unidad1))
				return (uTiempo.get(unidad1)/uTiempo.get(unidad2)) * valor;
		
		return 0;
	}
	

	public String unidSingular(String unidad) {
		
		if(unidad.equals("kilos"))
			return "kilo";
		if(unidad.equals("gramos"))
			return "gramo";
		if(unidad.equals("toneladas"))
			return "tonelada";
		if(unidad.equals("onzas"))
			return "onza";
		if(unidad.equals("libras"))
			return "libra";
		if(unidad.equals("stones"))
			return "stone";
		
		if(unidad.equals("metros"))
			return "metro";
		if(unidad.equals("centimetros"))
			return "centimetro";
		if(unidad.equals("kilometros"))
			return "kilometro";
		if(unidad.equals("pulgadas"))
			return "pulgada";
		if(unidad.equals("yardas"))
			return "yarda";
		if(unidad.equals("millas"))
			return "milla";
		
		if(unidad.equals("litros"))
			return "litro";
		if(unidad.equals("mililitros"))
			return "mililitro";
		if(unidad.equals("metros cubicos"))
			return "metro cubico";
		if(unidad.equals("galones"))
			return "galon";
		if(unidad.equals("barriles"))
			return "barril";
		if(unidad.equals("cuartos"))
			return "cuarto";
		
		if(unidad.equals("milisegundos"))
			return "milisegundo";
		if(unidad.equals("segundos"))
			return "segundo";
		if(unidad.equals("minutos"))
			return "minuto";
		if(unidad.equals("horas"))
			return "hora";
		if(unidad.equals("dias"))
			return "dia";
		if(unidad.equals("semanas"))
			return "semana"
					;
		return unidad;
	}
	
	public String unidPlural(String unidad) {
		
		if(unidad.equals("kilo"))
			return "kilos";
		if(unidad.equals("gramo"))
			return "gramos";
		if(unidad.equals("tonelada"))
			return "toneladas";
		if(unidad.equals("onza"))
			return "onzas";
		if(unidad.equals("libra"))
			return "libras";
		if(unidad.equals("stone"))
			return "stones";
		
		if(unidad.equals("metro"))
			return "metros";
		if(unidad.equals("centimetro"))
			return "centimetros";
		if(unidad.equals("kilometro"))
			return "kilometros";
		if(unidad.equals("pulgada"))
			return "pulgadas";
		if(unidad.equals("yarda"))
			return "yardas";
		if(unidad.equals("milla"))
			return "millas";
		
		if(unidad.equals("litro"))
			return "litros";
		if(unidad.equals("mililitro"))
			return "mililitros";
		if(unidad.equals("metro cubico"))
			return "metros cubicos";
		if(unidad.equals("galon"))
			return "galones";
		if(unidad.equals("barril"))
			return "barriles";
		if(unidad.equals("cuarto"))
			return "cuartos";
		
		if(unidad.equals("milisegundo"))
			return "milisegundos";
		if(unidad.equals("segundo"))
			return "segundos";
		if(unidad.equals("minuto"))
			return "minutos";
		if(unidad.equals("hora"))
			return "horas";
		if(unidad.equals("dia"))
			return "dias";
		if(unidad.equals("semana"))
			return "semanas";
		
		return unidad;
	}
	
	public String unidConAcento(String unidad) {
		if(unidad.equals("dia"))
			return "día";
		if(unidad.equals("dias"))
			return "días";
		if(unidad.equals("centimetro"))
			return "centímetro";
		if(unidad.equals("centimetros"))
			return "centímetros";
		if(unidad.equals("kilometro"))
			return "kilómetro";
		if(unidad.equals("kilometros"))
			return "kilómetros";
		if(unidad.equals("metro cubico"))
			return "metro cúbico";
		if(unidad.equals("metros cubicos"))
			return "metros cúbicos";
		if(unidad.equals("galon"))
			return "galón";
		
		return unidad;
	}
	
}
