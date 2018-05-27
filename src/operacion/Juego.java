package operacion;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import clase.Pedido;

public class Juego implements Operacion {
	
	private int contador;
	private int numeroPensado;
	private int min;
	private int max;
	private int numeroCalculado;
	private boolean estoyPensando;
	private boolean estoyAdivinando;
	
	public Juego() {
		min = 1;
		max = 100;
		contador = 0;
		estoyPensando = false; // Se inicializa siempre en false
		estoyAdivinando = false; // Se inicializa siempre en false
	}
	

	private Operacion siguiente;

	@Override
	public void siguiente(Operacion siguiente) {
		this.siguiente = siguiente;		
	}


	@Override
	public String calcular(Pedido pedido) {
		String regex;
		
		//System.out.println(estoyPensando); entra en false siempre
		
		if(estoyPensando) {
			regex = ".*es el (.+).+.*";
			Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE | Pattern.UNICODE_CASE);
			Matcher matcher = pattern.matcher(pedido.getMensaje());
			while(matcher.find()) {
				if(matcher.matches()) {
					contador++;
					int numeroRecibido = Integer.parseInt(matcher.group(1));
					if(numeroPensado < numeroRecibido) {
						return pedido.getNameUsuario() + " más chico";
					}
					else if(numeroPensado > numeroRecibido) {
						return pedido.getNameUsuario() + " más grande";
					}
					else {
						estoyPensando = false;
						return pedido.getNameUsuario() + " ¡si! Adivinaste en " + contador + " pasos...";
					}
				}
			}
			return siguiente.calcular(pedido); // Si está pensando y no se manda algo relacionado al juego continúa la cadena pero puede seguir jugando
		}
		
		if(estoyAdivinando) {
			regex = ".*listo.*";
			Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE | Pattern.UNICODE_CASE);
			Matcher matcher = pattern.matcher(pedido.getMensaje());
			while(matcher.find()) {
				if(matcher.matches()) {
					numeroCalculado = (int) Math.floor((min + max)/2);
					return pedido.getNameUsuario() + " ¿es el " + numeroCalculado + "?";
				}
			}
			
			regex = ".*mas (.+).*";
			pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE | Pattern.UNICODE_CASE);
			matcher = pattern.matcher(pedido.getMensaje());
			while(matcher.find()) {
				if(matcher.matches()) {
					if(matcher.group(1).equals("chico")) {
						max = numeroCalculado;
					}
					else if(matcher.group(1).equals("grande")) {
						min = numeroCalculado;
					}
					
					numeroCalculado = (int) Math.floor((min + max) / 2);
					return pedido.getNameUsuario() + " ¿es el " + numeroCalculado + "?";
				}
			}
			
			regex = ".*si.*";
			pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE | Pattern.UNICODE_CASE);
			matcher = pattern.matcher(pedido.getMensaje());
			while(matcher.find()) {
				if(matcher.matches()) {
					min = 1;
					max = 100;
					estoyAdivinando = false;
					return pedido.getNameUsuario() + " fue divertido :)";
				}
			}
		}
		
		regex = ".*jugamos.+pensa.*";
		Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE | Pattern.UNICODE_CASE);
		Matcher matcher = pattern.matcher(pedido.getMensaje());
		while(matcher.find()) {
			if(matcher.matches()) {
				this.contador = 0;
				this.estoyPensando = true;
				// System.out.println(estoyPensando); Se pone en true
				this.numeroPensado = (int) (Math.random() * 100) + 1; // Pensar número aleatorio entre 1 y 100
				return pedido.getNameUsuario() + " ¡listo!";
			}
		}
		
		regex = ".*jugamos.+.*";
		pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE | Pattern.UNICODE_CASE);
		matcher = pattern.matcher(pedido.getMensaje());
		while(matcher.find()) {
			if(matcher.matches()) {
				this.estoyAdivinando = true;
				return pedido.getNameUsuario() + " ¡sale y vale! Pensá un número del 1 al 100";
			}
		}
		
		return siguiente.calcular(pedido);
	}

}
