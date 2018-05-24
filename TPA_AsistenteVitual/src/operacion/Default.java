package operacion;

import clase.Pedido;

public class Default implements Operacion{

	@Override
	public void siguiente(Operacion siguiente) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String calcular(Pedido pedido) {
		return "Disculpa... no entiendo el pedido, " + pedido.getNameUsuario()+ " ¿podrías repetirlo?";
	}
	

}
