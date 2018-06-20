package jugador;
import org.junit.Test;

import cartas.Atacable;
import cartas.CartaMagica;
import cartas.CartaMonstruo;
import cartas.CartaTrampa;
import estadoCarta.EstadoCarta;
import estadoCarta.EstadoCartaColocadaBocaArriba;
import factories.CartaMonstruoFactory;
import modos.Modo;
import modos.ModoAtaque;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class JugadorTest {

		@Test
		public void testSeCreaJugadorConUnCampoYTieneCincoCartasEnLaMano() {
			Jugador jugador1 = new Jugador();
			
			assertEquals( 5, jugador1.obtenerCantidadDeCartasEnLaMano() );
		}
		
		
		@Test
		public void testJugadorAtacaAlMonstruoDeOtroJugador() {
			
			CartaMonstruo atacante = new CartaMonstruo(200,100);
			CartaMonstruo atacado = new CartaMonstruo(100,100);
			Jugador jugador1 = new Jugador();
			Jugador jugador2 = new Jugador();
			
			atacante.colocarEnModoAtaque();
			atacado.colocarEnModoAtaque();
			jugador1.enfrentarseA(jugador2);
			jugador2.enfrentarseA(jugador1);
			jugador1.colocarMonstruoEnModoAtaque(atacante);
			jugador2.colocarMonstruoEnModoAtaque(atacado);
			
			jugador1.atacar(atacante, atacado);
			
			assertTrue(atacado.estaDestruida());
			assertEquals( 8000, jugador1.obtenerVidaRestante() );
			assertEquals( 7900, jugador2.obtenerVidaRestante() );
		}
		
		@Test
		public void testJugadorTomaDosCartasDelMazoYTieneSieteCartasEnLaMano() {
			Jugador jugador1 = new Jugador();
			jugador1.tomarCartaDelMazo();
			jugador1.tomarCartaDelMazo();
			
			assertEquals(7, jugador1.obtenerCantidadDeCartasEnLaMano());
		}
		
		@Test
		public void testElJugadorTieneCartasEnElCampo() {
			Jugador jugador1 = new Jugador();
			CartaMonstruo cartaMonstruo1 = new CartaMonstruo(1000, 3000, 3);
			CartaMonstruo cartaMonstruo2 = new CartaMonstruo(1000, 3000, 3);
			CartaMagica cartaMagica = new CartaMagica();
			CartaTrampa cartaTrampa = new CartaTrampa();

			jugador1.colocarMonstruoEnModoAtaque(cartaMonstruo1);
			jugador1.colocarMonstruoBocaAbajoEnModoDefensa(cartaMonstruo2);
			jugador1.colocarCartaMagicaBocaAbajo(cartaMagica);
			jugador1.colocarCartaTrampaBocaAbajo(cartaTrampa);
			
			assertTrue(jugador1.tieneCartasEnCampo());
		}
		
		@Test
		public void testObtenerCantidadDeCartasEnCampo() {
			Jugador jugador1 = new Jugador();
			CartaMonstruo cartaMonstruo1 = new CartaMonstruo(1000, 3000, 3);
			CartaMonstruo cartaMonstruo2 = new CartaMonstruo(1000, 3000, 3);
			CartaMagica cartaMagica = new CartaMagica();
			CartaTrampa cartaTrampa = new CartaTrampa();

			jugador1.colocarMonstruoEnModoAtaque(cartaMonstruo1);
			jugador1.colocarMonstruoBocaAbajoEnModoDefensa(cartaMonstruo2);
			jugador1.colocarCartaMagicaBocaAbajo(cartaMagica);
			jugador1.colocarCartaTrampaBocaAbajo(cartaTrampa);
			
			assertEquals(4, jugador1.obtenerCantidadCartasEnCampo());
		}
		
		@Test
		public void testAtacarAunJugadorSinMonstruosEnCampo() {
			CartaMonstruoFactory fabrica = new CartaMonstruoFactory();
			
			Atacable unMonstruo = fabrica.crearHeroeElementalAvian();
	 		
			Jugador jugador1 = new Jugador();
			Jugador jugador2 = new Jugador();
			
			jugador1.enfrentarseA(jugador2);
			jugador2.enfrentarseA(jugador1);
			
			Modo modoAtaque = new ModoAtaque();
			EstadoCarta bocaArriba = new EstadoCartaColocadaBocaArriba();
			jugador1.colocar(unMonstruo, bocaArriba, modoAtaque);
	 		
	 		jugador1.atacar(unMonstruo, jugador2);
	 		
	 		int vidaEsperada = 7000;
			assertEquals(vidaEsperada , jugador2.obtenerVidaRestante());
		}
		
}
