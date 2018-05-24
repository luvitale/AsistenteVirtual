package clase;

import operacion.Interpretacion;

//public class Asistente extends Interpretar{
public class Asistente{
	
	private static final String USUARIO = "delucas";
	private String nameAsistente;
	private String nameUsuario = "@"+USUARIO;
	
	public Asistente(String nameAsistente) {
		this.nameAsistente = "@"+nameAsistente;
	}
	
	public String escuchar(String mensaje) {
		Interpretacion interpretacion = new Interpretacion();
		Pedido pedido = new Pedido(mensaje, nameUsuario, nameAsistente);
		return interpretacion.calcular(pedido);
	}

}
