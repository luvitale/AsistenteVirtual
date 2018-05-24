package clase;

import java.text.Normalizer;

public class Pedido {
	private String mensaje;
	private String nameUsuario;
	private String nameAsistente;
	
	public Pedido(String mensaje_original, String nameUsuario, String nameAsistente) {
		this.mensaje = normalizado(mensaje_original);
		this.nameUsuario = nameUsuario;
		this.nameAsistente = nameAsistente;
	}
		
	
	
	public String getMensaje() {
		return mensaje;
	}

	public String getNameUsuario() {
		return nameUsuario;
	}

	public String getNameAsistente() {
		return nameAsistente;
	}

	public String normalizado(String texto_original) {	
//		limpiar de tildes
        String texto_normalizado = Normalizer.normalize(texto_original.trim().toLowerCase(), Normalizer.Form.NFD);
//      eliminar char que no son ascii salvo ¿?!¡ñ
        texto_normalizado = texto_normalizado.replaceAll("[^\\p{ASCII}(N\u0303)(n\u0303)(\u00A1)(\u00BF)(\u00B0)(U\u0308)(u\u0308)]", "");
        texto_normalizado = Normalizer.normalize(texto_normalizado, Normalizer.Form.NFC);        
        return texto_normalizado;
	}
	
	public int soloNumero(String texto_original) {
		int numero = 0;
		char[] v_numeros = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
		String str = texto_original;
		for(char c : str.toCharArray ()) {
			for(char num : v_numeros) {
				if(c == num)
					numero = numero * 10 + Integer.parseInt( "" + c);
			}
		} 
        return numero;
	}
	
}
