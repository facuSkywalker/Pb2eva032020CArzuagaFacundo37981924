package ar.edu.unlam.pb220202c.eva03;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;



public class TestAutoPista {
	
	@Test
	public void queSePuedaRegistrarTelepase () {
		Autopista delSol = new Autopista();
		Automovil ford = new Automovil("ats234", 100, 130);
		Boolean seRegistro = delSol.registrarTelepase(1, ford);
		assertTrue("no se agrego", seRegistro);
		
	}
	@Test
	public void queAlSalirDelAutopistaNoestaEncirculacionLanceUnaExcepcion() throws VehiculoNotFounException  {
		Autopista delSol = new Autopista();
		Automovil ford = new Automovil("ats234", 110, 130);
		
		try {
			delSol.salirAutpista(ford);
		}catch(VehiculoNotFounException e) {
			System.out.println(e.getMessage());
		}
		
	
		
	}
	@Test
	public void queVerifiqueQueSeObtengaUnaListaDeAutosInsfractoresOrdenadaPorPatente()throws VehiculoNotFounException{
		Autopista delSol = new Autopista();
		Automovil ford = new Automovil("atj234", 120, 130);
		Automovil chevrolet = new Automovil("gts534", 100, 130);
		Automovil suruba = new Automovil("rts274", 90, 130);
		ford.setVelocidadActual(250);
		chevrolet.setVelocidadActual(220);
		suruba.setVelocidadActual(235);
		delSol.registrarTelepase(1, ford);
		delSol.registrarTelepase(2, chevrolet);
		delSol.registrarTelepase(3, suruba);
		delSol.ingresarAutopista(1);
		delSol.ingresarAutopista(2);
		delSol.ingresarAutopista(3);
		delSol.obtenerVehiculosConExcesosDeVelocidadOrdenadosPorPatente();
		String a = ford.getPatente();
		String z = suruba.getPatente();
		assertEquals(a, delSol.obtenerVehiculosConExcesosDeVelocidadOrdenadosPorPatente().first().getPatente());
		assertEquals(z, delSol.obtenerVehiculosConExcesosDeVelocidadOrdenadosPorPatente().last().getPatente());
	}
	@Test
	public void queNoHaya2autosIguales() {
		Autopista delSol = new Autopista();
		Automovil ford = new Automovil("atj234", 100, 130);
		Automovil ford1 = new Automovil("atj234", 90, 130);
		delSol.registrarTelepase(1, ford);
		delSol.registrarTelepase(2, ford1);
		Boolean a =delSol.registrarTelepase(2, ford1);
		assertFalse(a);
	}
	@Test
	public void queDeCorrectamenteLaCantidadDeVehiculosEnCirculacion() throws VehiculoNotFounException{
		Autopista delSol = new Autopista();
		Automovil ford = new Automovil("atj234", 100, 130);
		Automovil chevrolet = new Automovil("gts534", 110, 130);
		Automovil suruba = new Automovil("rts274", 90, 130);
		ford.setVelocidadActual(250);
		chevrolet.setVelocidadActual(220);
		suruba.setVelocidadActual(235);
		delSol.registrarTelepase(1, ford);
		delSol.registrarTelepase(2, chevrolet);
		delSol.registrarTelepase(3, suruba);
		delSol.ingresarAutopista(1);
		delSol.ingresarAutopista(2);
		delSol.ingresarAutopista(3);
		Integer a = delSol.cantidadDeVehiculosENCirculacion();
		Integer hay = 3;
		assertEquals(a, hay);
		
	}
	}
	

