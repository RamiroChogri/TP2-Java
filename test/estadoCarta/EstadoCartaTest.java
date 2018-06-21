package estadoCarta;

import static org.junit.Assert.assertTrue;

import org.junit.Test;


public class EstadoCartaTest {
	
	
	@Test
	public void testEstadoCartaDestruidaEstaEnCementerio() {
		EstadoCarta estado = new EstadoCartaDestruida();
		assertTrue( estado.estaDestruida());
	}

	@Test
	public void testEstadoCartaBocaArribaEstaBocaArriba() {
		EstadoCarta estado = new EstadoCartaColocadaBocaArriba();
		assertTrue (estado.estaBocaArriba());
	}
	
	@Test
	public void testEstadoCartaBocaAbajoEstaBocaAbajo() {
		EstadoCarta estado = new EstadoCartaColocadaBocaAbajo();
		assertTrue (estado.estaBocaAbajo());
	}
	
	@Test
	public void testCartaNoJugadaEstaSinJugar() {
		EstadoCarta estado = new EstadoCartaNoJugada();
		assertTrue(estado.estaNoJugada());
	}

}
