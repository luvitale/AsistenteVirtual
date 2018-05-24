package operacion;

import clase.Pedido;

public class LeyesRobotica implements Operacion{

	private Operacion siguiente;

	@Override
	public void siguiente(Operacion siguiente) {
		this.siguiente = siguiente;		
	}


	@Override
	public String calcular(Pedido pedido) {
		{
		// TODO Auto-generated method stub
		
			
			
			
		//	return resultado;
		}
		return siguiente.calcular(pedido);
	}

}
