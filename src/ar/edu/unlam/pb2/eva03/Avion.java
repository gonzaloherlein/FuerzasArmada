package ar.edu.unlam.pb2.eva03;

public class Avion extends Vehiculo implements Volador {


	private Double altura = 12.00;
	
	public Avion(Integer codigo, String modelo) {
		super(codigo,modelo);

	}

	@Override
	public Double getAltura() {
		
		return this.altura;
	}
	
	

}
