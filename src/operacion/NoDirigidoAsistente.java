package operacion;

import clase.Pedido;

public class NoDirigidoAsistente implements Operacion{

	private Operacion siguiente;

	@Override
	public void siguiente(Operacion siguiente) {
		this.siguiente = siguiente;		
	}

	@Override
	public String calcular(Pedido pedido) {
		if(!pedido.getMensaje().contains(pedido.getNameAsistente())) {
			return "Te estás dirigiendo a mí, " + pedido.getNameUsuario() + "?. Me llamo " + pedido.getNameAsistente() + ".";
		}
		else {
			return siguiente.calcular(pedido);
		}
	}

}
