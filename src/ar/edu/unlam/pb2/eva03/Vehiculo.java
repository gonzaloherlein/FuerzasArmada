package ar.edu.unlam.pb2.eva03;

import java.util.Objects;

public class Vehiculo {
	private Integer codigo;
	private String modelo;
	
	public Vehiculo(Integer codigo,String modelo) {
		this.codigo = codigo;
		this.modelo = modelo;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

//	@Override
//	public int hashCode() {
//		return Objects.hash(codigo);
//	}
//
//	@Override
//	public boolean equals(Object obj) {
//		if (this == obj)
//			return true;
//		if (obj == null)
//			return false;
//		if (getClass() != obj.getClass())
//			return false;
//		Vehiculo other = (Vehiculo) obj;
//		return Objects.equals(codigo, other.codigo);
//	}


	
	
}
