package util;

public class Nodo { 
	private Object elemento;      // Valor almacenado en el nodo 
	private Nodo sig;            // Referencia al siguiente elemento 

	// Elemento igual a valor apuntando a null
	Nodo(Object valor) { 
		this (valor, null);
	}

	// Elemento igual a valor apuntando a Nodo n
	Nodo(Object valor, Nodo n) {
		elemento = valor;
		sig = n;
	}

	// Obtener el valor del nodo
	public Object obtenerElemento () {
		return elemento;
	}

	// Referencia al siguiente nodo
	public Nodo obtenerSig() {
		return sig;
	}
}
