package ar.edu.unlam.pb2.eva03;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class FuerzaArmada {

	private Set<Vehiculo> convoy = new HashSet<>();
	private Map<String, Batalla> batallas = new HashMap<String, Batalla>();
	private Set<Vehiculo> vehiculosEnLaBatalla = new HashSet<>();

	public FuerzaArmada() {
	
	}

	public Set<Vehiculo> getConvoy() {
		return convoy;
	}

	public void setConvoy(Set<Vehiculo> convoy) {
		this.convoy = convoy;
	}

	public Map<String, Batalla> getBatallas() {
		return batallas;
	}

	public void setBatallas(Map<String, Batalla> batallas) {
		this.batallas = batallas;
	}

	public void agregarVehiculo(Vehiculo vehiculo) {
		this.convoy.add(vehiculo);

	}

	public Object getCapacidadDeDefensa() {
		return this.convoy.size();
	}
	
	public Set<Vehiculo> getVehiculosEnLaBatalla() {
		return vehiculosEnLaBatalla;
	}

	public void setVehiculosEnLaBatalla(Set<Vehiculo> vehiculosEnLaBatalla) {
		this.vehiculosEnLaBatalla = vehiculosEnLaBatalla;
	}
	
	
	public Integer cantidadDeVehiculosEnBatalla() {
		return vehiculosEnLaBatalla.size();
	}

	public void crearBatalla(Batalla batalla) {
		this.batallas.put(batalla.getNombre(), batalla);

	}

	public Batalla getBatalla(String nombreDeBatalla) {
		for (Batalla batalla : batallas.values()) {
			if (batalla.getNombre().equals(nombreDeBatalla)) {
				return batalla;
			}
		}
		return null;
	}

	public Vehiculo devolverVehiculo(Integer codigoVehiculo) {
		for (Vehiculo vehiculo : convoy) {
			if(vehiculo.getCodigo() == codigoVehiculo) {
				return vehiculo;
			}
		}
		return null;
	}
	
	
	public Boolean enviarALaBatalla(Batalla batalla, Integer codigoVehiculo) throws VehiculoIncompatible, VehiculoInexistente {
		TipoDeBatalla tipoDeBatalla = batalla.getTipo();

		
		for (Vehiculo vehiculo : convoy) {
			if (vehiculo.getCodigo() == codigoVehiculo) {
				switch (tipoDeBatalla) {
				case TERRESTRE:
					if (vehiculo instanceof Terrestre) {
						vehiculosEnLaBatalla.add(vehiculo);
						return true;
					} else {
						throw new VehiculoIncompatible("Vehiculo Incompatible");
					}
				case NAVAL:
					if (vehiculo instanceof Acuatico) {
						vehiculosEnLaBatalla.add(vehiculo);
						return true;
					} else {
						throw new VehiculoIncompatible("Vehiculo Incompatible");
					}
				case AEREO:
					if (vehiculo instanceof Volador) {
						vehiculosEnLaBatalla.add(vehiculo);
						return true;
					} else {
						throw new VehiculoIncompatible("Vehiculo Incompatible");
					}
				}
			}
		}
		throw new VehiculoInexistente("El vehiculo no existe");
		
	}

}
