package ar.edu.unlam.pb2.eva03;

import java.util.HashSet;
import java.util.Set;

public class Batalla {
	private String nombre;
	private TipoDeBatalla tipo;
	private Double latitud;
	private Double longitud;

	
	public Batalla(String nombre, ar.edu.unlam.pb2.eva03.TipoDeBatalla tipo, Double latitud, Double longitud) {

		this.nombre = nombre;
		this.tipo = tipo;
		this.latitud = latitud;
		this.longitud = longitud;

	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public TipoDeBatalla getTipo() {
		return tipo;
	}

	public void setTipo(TipoDeBatalla tipo) {
		this.tipo = tipo;
	}

	public Double getLatitud() {
		return latitud;
	}

	public void setLatitud(Double latitud) {
		this.latitud = latitud;
	}

	public Double getLongitud() {
		return longitud;
	}

	public void setLongitud(Double longitud) {
		this.longitud = longitud;
	}


	
}
