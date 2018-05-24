package operacion;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import clase.Pedido;

public class Agradecer implements Operacion{

	private Operacion siguiente;

	@Override
	public void siguiente(Operacion siguiente) {
		this.siguiente = siguiente;		
	}

	@Override
	public String calcular(Pedido pedido) {
		String regex = ".*(?:gracias).*";
		Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE | Pattern.UNICODE_CASE);
		Matcher matcher = pattern.matcher(pedido.getMensaje());
		while(matcher.find()) {
			if(matcher.matches()) {
				return "No es nada, " + pedido.getNameUsuario();
			}
		}
		return siguiente.calcular(pedido);
	}
}
