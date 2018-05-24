package util;

public class Pila {
	private Nodo tope;                // Tope de la pila

	// Constructor de pila vacía
	public Pila() {
		tope = null;
	}

	// Verificar si la pila está vacía
	public boolean estaVacia (){ 
		return tope == null; 
	}

	// Vaciar pila
	public void vaciar() { 
		tope = null;
	}

	// Devolver el tope de la pila
	public Object verTope() { 
		return (estaVacia()) ? null : tope.obtenerElemento(); 
	}

	// Extraer el elemento del tope
	public Object sacar() {
		if (estaVacia())
			return null;

		Object dato = tope.obtenerElemento();
		tope = tope.obtenerSig();
		return dato;
	}

	// Insertar un nodo
	public void poner(Object x) {
		tope = new Nodo(x, tope);
	}

}
