package ar.edu.unlam.pb2.eva03;

public class Submarino extends Vehiculo implements Acuatico{

	private Double profundidad = 10.0;
	
	public Submarino(Integer codigo, String modelo) {
		super(codigo,modelo);

	}


	@Override
	public Double getProfundidad() {
		return this.profundidad;
	}
	
}
