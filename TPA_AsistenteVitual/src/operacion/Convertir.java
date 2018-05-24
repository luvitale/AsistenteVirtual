package operacion;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import clase.Pedido;
import util.Convert;

public class Convertir implements Operacion {
	
	private Operacion siguiente;

	@Override
	public void siguiente(Operacion siguiente) {
		this.siguiente = siguiente;		
	}

	@Override
	public String calcular(Pedido pedido) {
		
		String regex = ".*(?:cuantos|cuantas) (metros cubicos|metro cubico|\\w*) (?:son|hay en) (\\d+) (metros cubicos|metro cubico|\\w*)";
		Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE | Pattern.UNICODE_CASE);
		Matcher matcher = pattern.matcher(pedido.getMensaje());
		
		while(matcher.find()) {
			if(matcher.matches()) {
				Convert c = new Convert(matcher.group(1),matcher.group(3), Double.parseDouble(matcher.group(2)));
				if(c.mismasUnidades()) {
					double valor_2 = c.convertir();
					String unid_1 = c.unidConAcento(matcher.group(3));
					String unid_2 = c.unidConAcento((redondear(valor_2) != 1.0 ? matcher.group(1) : c.unidSingular(matcher.group(1)))); 
					String equiv = (Double.parseDouble(matcher.group(2)) != 1.0 ? " equivalen a " : " equivale a ");
					String val_2 = String.format(formatoRedondeo(valor_2), valor_2).replace(",", ".");
					return pedido.getNameUsuario() + " " + matcher.group(2) + " " + unid_1 + equiv + val_2 + " " + unid_2;
				}
			}
		}
		return siguiente.calcular(pedido);
	}
	
	
	private double redondear(double valor) {
		return ((int)(Math.round(valor) * 100)) / 100.0;
	}
	
	private String formatoRedondeo(double valor) {
		double decimales = valor - (int) valor;
		if(decimales  == 0 || (int) (decimales * 1000) < 9 || (int) (decimales * 1000) > 990)
			return "%.0f";
		return "%.2f";
	}

	
}
