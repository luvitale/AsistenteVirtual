package operacion;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import clase.Pedido;
import util.Fecha;

public class FechaActual implements Operacion{
	
	private Operacion siguiente;

	@Override
	public void siguiente(Operacion siguiente) {
		this.siguiente = siguiente;		
	}

	@Override
	public String calcular(Pedido pedido) {
		
		Fecha diaActual = new Fecha();
		
		String regex_DiaActual_Hora = ".*(?:que hora es|la hora).*";
		Pattern pattern_DiaActual_Hora = Pattern.compile(regex_DiaActual_Hora, Pattern.CASE_INSENSITIVE | Pattern.UNICODE_CASE);
		Matcher matcher_DiaActual_Hora = pattern_DiaActual_Hora.matcher(pedido.getMensaje());
		while(matcher_DiaActual_Hora.find()) {
			if(matcher_DiaActual_Hora.matches()) {
				return pedido.getNameUsuario() + " son las " + diaActual.hora(diaActual.formato_hora[0]);
			}
		}

		String regex_DiaActual_Fecha = ".*(?:que dia es|la fecha|fecha es hoy).*";
		Pattern pattern_DiaActual_Fecha = Pattern.compile(regex_DiaActual_Fecha , Pattern.CASE_INSENSITIVE | Pattern.UNICODE_CASE);
		Matcher matcher_DiaActual_Fecha = pattern_DiaActual_Fecha.matcher(pedido.getMensaje());
		while(matcher_DiaActual_Fecha.find()) {
			if(matcher_DiaActual_Fecha.matches()) {
				return pedido.getNameUsuario() + " hoy es " + diaActual.fechaToString(diaActual.formato_fecha[0]);
			}
		}

		String regex_DiaActual_DiaSemana = ".*(?:dia de la semana es|dia es de la semana).*";
		Pattern pattern_DiaActual_DiaSemana = Pattern.compile(regex_DiaActual_DiaSemana , Pattern.CASE_INSENSITIVE | Pattern.UNICODE_CASE);
		Matcher matcher_DiaActual_DiaSemana = pattern_DiaActual_DiaSemana.matcher(pedido.getMensaje());
		while(matcher_DiaActual_DiaSemana.find()) {
			if(matcher_DiaActual_DiaSemana.matches()) {
				return pedido.getNameUsuario() + " hoy es " + diaActual.diaSemana();
			}
		}
		
		return siguiente.calcular(pedido);
	}
}
