package ar.edu.unlam.pb2.eva03;

public class Tanque extends Vehiculo implements Terrestre {
	

	private Double velocidad = 100.0;

	public Tanque(Integer codigo,String modelo) {
		super(codigo,modelo);

	}
	

	@Override
	public Double getVelocidad() {
		return this.velocidad;
	}


}
