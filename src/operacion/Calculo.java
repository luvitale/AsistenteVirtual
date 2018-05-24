package operacion;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import clase.Pedido;
import util.MyCalculo;

public class Calculo implements Operacion{

	private Operacion siguiente;

	@Override
	public void siguiente(Operacion siguiente) {
		this.siguiente = siguiente;		
	}


	@Override
	public String calcular(Pedido pedido) {
		String regex = ".*(?:cuanto es|cuanto da).*";
		Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE | Pattern.UNICODE_CASE);
		Matcher matcher = pattern.matcher(pedido.getMensaje());
		while(matcher.find()) {
			if(matcher.matches()) {
				String respuesta = null;
				try {
					MyCalculo calc = new MyCalculo();
					double resultado = calc.calcular(pedido.getMensaje());
					if(resultado % 1 == 0) // Si es entero devolver sin decimales
						respuesta =  pedido.getNameUsuario() + " " + Math.round(resultado);
					else // Sino devolver con decimales
						respuesta =  pedido.getNameUsuario() + " " + resultado;		
				} catch (Exception e) {
					return siguiente.calcular(pedido);
				}
				return respuesta;
			}
		}
		return siguiente.calcular(pedido);
	}

}
