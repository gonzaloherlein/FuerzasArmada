package ar.edu.unlam.pb2.eva03;

public class HidroAvion extends Vehiculo implements Acuatico, Volador {
	

	private Double altura = 0.0;
	private Double profundidad = 0.0;
	
	public HidroAvion(Integer codigo, String modelo) {
		super(codigo,modelo);
	}

	@Override
	public Double getAltura() {
		
		return this.altura;
	}

	@Override
	public Double getProfundidad() {
	
		return this.profundidad;
	}

}
