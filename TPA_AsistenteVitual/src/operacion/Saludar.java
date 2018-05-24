package operacion;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import clase.Pedido;

public class Saludar implements Operacion{

	private Operacion siguiente;

	@Override
	public void siguiente(Operacion siguiente) {
		this.siguiente = siguiente;		
	}

	@Override
	public String calcular(Pedido pedido) {
		String regex = ".*(?:hola|buen dia|buenos dias|buenas|que tal|tardes|noches|hey).*";
		Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE | Pattern.UNICODE_CASE);
		Matcher matcher = pattern.matcher(pedido.getMensaje());
		while(matcher.find()) {
			if(matcher.matches()) {
				return "¡Hola, " + pedido.getNameUsuario() + "!";
			}
		}
		return siguiente.calcular(pedido);
	}

}
