package ar.edu.unlam.pb2.eva03;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestCases {

	@Test
	public void queSePuedaCrearUnObjetoVolador() {
		Avion avion = new Avion(1, "A-10");

		assertEquals(12.00, avion.getAltura(), 0.01);
	}

	@Test
	public void queSePuedaCrearUnObjetoTerrestre() {
		Tanque tanque = new Tanque(5, "Renault FT");

		assertEquals(100.0, tanque.getVelocidad(), 0.1);
	}

	@Test
	public void queSePuedaCrearUnObjetoAcuatico() {
		Submarino submarino = new Submarino(8, "ARA - San Juan");

		assertEquals(10.0, submarino.getProfundidad(), 0.01);
	}

	@Test
	public void queSePuedaCrearUnObjetoAnfibio() {
		Anfibio var = new Anfibio(12, "LARC-5");

		assertEquals(0.0, var.getVelocidad(), 0.01);
		assertEquals(0.0, var.getProfundidad(), 0.01);
	}

	@Test
	public void queSePuedaCrearUnHidroavion() {
		HidroAvion ag600 = new HidroAvion(12, "AG600");


		assertEquals(0.0, ag600.getAltura(), 0.01);
		assertEquals(0.0, ag600.getProfundidad(), 0.01);
	}

	@Test
	public void queSePuedaArmarElConvoy() {
		FuerzaArmada argentina = new FuerzaArmada();

		argentina.agregarVehiculo(new Avion(1, "A-10"));
		argentina.agregarVehiculo(new Avion(2, "A-10"));
		argentina.agregarVehiculo(new Avion(3, "F-102"));
		argentina.agregarVehiculo(new Avion(4, "F-15"));
		argentina.agregarVehiculo(new Tanque(5, "Renault FT"));
		argentina.agregarVehiculo(new Camion(6, "T-72"));
		argentina.agregarVehiculo(new Camion(7, "T-72"));
		argentina.agregarVehiculo(new Submarino(8, "ARA - San Juan"));
		argentina.agregarVehiculo(new Portaviones(9, "A-10"));
		argentina.agregarVehiculo(new Destructor(10, "A-10"));
		argentina.agregarVehiculo(new Destructor(11, "A-10"));
		argentina.agregarVehiculo(new HidroAvion(12, "Mitsubishi F1M"));
		argentina.agregarVehiculo(new Anfibio(12, "LARC-5"));


		assertEquals((Integer)13, argentina.getCapacidadDeDefensa());
	}

	@Test
	public void queSePuedaCrearUnaBatalla() {
		FuerzaArmada argentina = new FuerzaArmada();

		Batalla sanLorenzo = new Batalla("San Lorenzo", TipoDeBatalla.TERRESTRE, 100.5, 20.3);
		
		argentina.crearBatalla(sanLorenzo);


		assertEquals(100.5, argentina.getBatalla("San Lorenzo").getLatitud(),0.01);
		assertEquals(20.3, argentina.getBatalla("San Lorenzo").getLongitud(),0.01);

	}

		
		

	@Test
	public void queSePuedaPlanearLaBatallaSobreElOceano() {
		
	}
	
	@Test
	public void queSeBusqueUnTanquePorCodigo() {
		FuerzaArmada argentina = new FuerzaArmada();
		Tanque tanque = new Tanque(5, "Renault FT");
		argentina.agregarVehiculo(tanque);
			
		assertEquals(tanque, argentina.devolverVehiculo(5));
	}
	
	
	@Test
	public void queSePuedaPresentarBatallaTerrestre() throws VehiculoIncompatible, VehiculoInexistente{
		
		FuerzaArmada argentina = new FuerzaArmada();
		Batalla sanLorenzo = new Batalla("San Lorenzo", TipoDeBatalla.TERRESTRE, 100.5, 20.3);
		argentina.crearBatalla(sanLorenzo);
		
		Tanque tanque = new Tanque(5, "Renault FT");
		Camion camion = new Camion(6, "T-72");
		Camion camion2 = new Camion(7, "T-73");
		Tanque tanque2 = new Tanque(8, "Quevedo");

		
		argentina.agregarVehiculo(tanque);
		argentina.agregarVehiculo(tanque2);
		argentina.agregarVehiculo(camion);
		argentina.agregarVehiculo(camion2);
	
		
		
		assertTrue(argentina.enviarALaBatalla(sanLorenzo, 5));
		assertTrue(argentina.enviarALaBatalla(sanLorenzo, 6));
		assertTrue(argentina.enviarALaBatalla(sanLorenzo, 7));
		assertTrue(argentina.enviarALaBatalla(sanLorenzo, 8));
	}

	@Test
	public void queSePuedaPresentarBatallaNaval() throws VehiculoInexistente, VehiculoIncompatible {
		FuerzaArmada argentina = new FuerzaArmada();

		Batalla pacifico = new Batalla("Pacifico", TipoDeBatalla.NAVAL, 200.5, 45.8);
		
		argentina.agregarVehiculo(new Submarino(8, "A-10"));
		argentina.agregarVehiculo(new Portaviones(9, "A-10"));
		argentina.agregarVehiculo(new Destructor(10, "A-10"));
		argentina.agregarVehiculo(new Destructor(11, "A-10"));
		argentina.agregarVehiculo(new HidroAvion(12, "A-10"));
		argentina.agregarVehiculo(new Anfibio(13, "A-10"));

		assertEquals(6, argentina.getCapacidadDeDefensa());
		argentina.crearBatalla(pacifico);

		assertTrue(argentina.enviarALaBatalla(pacifico, 8));
		assertTrue(argentina.enviarALaBatalla(pacifico, 9));
		assertTrue(argentina.enviarALaBatalla(pacifico, 10));		
		assertTrue(argentina.enviarALaBatalla(pacifico, 11));		
		assertTrue(argentina.enviarALaBatalla(pacifico, 12));		
		assertTrue(argentina.enviarALaBatalla(pacifico, 13));		
	}

	@Test (expected = VehiculoIncompatible.class)
	public void queSeNoSePuedaEnviarAUnaBatallaEnTierraUnBarco() throws VehiculoInexistente, VehiculoIncompatible {
		FuerzaArmada argentina = new FuerzaArmada();
		Batalla sanLorenzo = new Batalla("San Lorenzo", TipoDeBatalla.TERRESTRE, 100.5, 20.3);

		argentina.agregarVehiculo(new Tanque(5, "Renault FT"));
		argentina.agregarVehiculo(new Camion(6, "T-72"));
		argentina.agregarVehiculo(new Camion(7, "T-72"));
		argentina.agregarVehiculo(new Destructor(11, "A-10"));

		argentina.crearBatalla(sanLorenzo);

		assertFalse(argentina.enviarALaBatalla(sanLorenzo, 11));

	}

	@Test (expected = VehiculoInexistente.class)
	public void queSeNoSePuedaEnviarAUnaBatallaUnVehiculoQueNoExista() throws VehiculoInexistente, VehiculoIncompatible {
		FuerzaArmada argentina = new FuerzaArmada();
		Batalla sanLorenzo = new Batalla("San Lorenzo", TipoDeBatalla.TERRESTRE, 100.5, 20.3);
		
		
		argentina.agregarVehiculo(new Tanque(5, "Renault FT"));
		argentina.agregarVehiculo(new Camion(6, "T-72"));
		argentina.agregarVehiculo(new Camion(7, "T-72"));
		argentina.agregarVehiculo(new Destructor(11, "A-10"));

		argentina.crearBatalla(sanLorenzo);

		assertFalse(argentina.enviarALaBatalla(sanLorenzo, 4));
	}
}
