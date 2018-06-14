package jugador;
import org.junit.Test;

import carta.CartaMonstruo;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class JugadorTest {

		@Test
		public void testSeCreaJugadorConUnCampoYNoTieneCartasEnLaMano() {
			Jugador jugador1 = new Jugador();
			
			assertEquals( 0, jugador1.cantidadDeCartasEnLaMano() );
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
			jugador1.colocarCartaEnCampo(atacante);
			jugador2.colocarCartaEnCampo(atacado);
			
			jugador1.atacar(atacante, atacado);
			
			assertTrue(atacado.estaDestruida());
			assertEquals( 8000, jugador1.obtenerVidaRestante() );
			assertEquals( 7900, jugador2.obtenerVidaRestante() );
		}
}
