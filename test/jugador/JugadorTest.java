package jugador;
import org.junit.Test;

import cartas.*;
import estadoCarta.*;
import factories.*;
import modos.*;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class JugadorTest {

		@Test
		public void testSeCreaJugadorConUnCampoYTieneCincoCartasEnLaMano() {
			Jugador jugador1 = new Jugador();
			
			assertEquals( 5, jugador1.obtenerCantidadDeCartasEnLaMano() );
		}
		
		
		@Test
		public void testJugadorAtacaAlMonstruoDeOtroJugadorYLoDestruye() {
			CartaMonstruoFactory fabrica = new CartaMonstruoFactory();
			Atacable atacante = fabrica.crearBetaElGuerreroMagnetico();
			Atacable atacado = fabrica.crearDragonDeKoumori();
			Jugador jugador1 = new Jugador();
			Jugador jugador2 = new Jugador();
			
			jugador1.enfrentarseA(jugador2);
			jugador2.enfrentarseA(jugador1);
			jugador1.colocar(atacado, new EstadoCartaColocadaBocaArriba(), new ModoAtaque());
			jugador2.colocar(atacante, new EstadoCartaColocadaBocaArriba(), new ModoAtaque());
			
			jugador2.atacar(atacante, atacado);
			
			assertTrue(atacado.estaDestruida());
		}
		
		@Test
		public void testJugadorAtacaAlMonstruoDeOtroJugadorYLeInflingeDanioALosPuntosDeVida() {
			CartaMonstruoFactory fabrica = new CartaMonstruoFactory();
			Atacable atacante = fabrica.crearBetaElGuerreroMagnetico();
			Atacable atacado = fabrica.crearDragonDeKoumori();
			Jugador jugador1 = new Jugador();
			Jugador jugador2 = new Jugador();
			
			jugador1.enfrentarseA(jugador2);
			jugador2.enfrentarseA(jugador1);
			jugador1.colocar(atacado, new EstadoCartaColocadaBocaArriba(), new ModoAtaque());
			jugador2.colocar(atacante, new EstadoCartaColocadaBocaArriba(), new ModoAtaque());
			
			jugador2.atacar(atacante, atacado);
			
			int vidaEsperada = 8000 - 200;
			assertEquals(vidaEsperada, jugador1.obtenerVidaRestante());
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
			CartaMonstruoFactory fabricaMonstruo = new CartaMonstruoFactory();
			CartaMagicaFactory fabricaMagicas = new CartaMagicaFactory();
			
			Atacable monstruo1 = fabricaMonstruo.crearDragonDeBrillo();
			Atacable monstruo2 = fabricaMonstruo.crearDuendeMistico();
			Activable cartaMagica1 = fabricaMagicas.crearAgujeroNegro();
			Activable cartaMagica2 = fabricaMagicas.crearOllaDeLaCodicia();
			
			jugador1.colocar(monstruo1, new EstadoCartaColocadaBocaArriba( ), new ModoAtaque() );
			jugador1.colocar(monstruo2, new EstadoCartaColocadaBocaAbajo(), new ModoDefensa() );
			jugador1.colocar(cartaMagica1, new EstadoCartaColocadaBocaAbajo() );
			jugador1.colocar(cartaMagica2, new EstadoCartaColocadaBocaAbajo() );
			
			assertTrue( jugador1.tieneCartasEnCampo() );
		}
		
		@Test
		public void testObtenerCantidadDeCartasEnCampo() {
			Jugador jugador1 = new Jugador();
			CartaMonstruoFactory fabricaMonstruo = new CartaMonstruoFactory();
			CartaMagicaFactory fabricaMagicas = new CartaMagicaFactory();
			
			Atacable monstruo1 = fabricaMonstruo.crearDragonDeBrillo();
			Atacable monstruo2 = fabricaMonstruo.crearDuendeMistico();
			Activable cartaMagica1 = fabricaMagicas.crearAgujeroNegro();
			Activable cartaMagica2 = fabricaMagicas.crearOllaDeLaCodicia();
			
			jugador1.colocar(monstruo1, new EstadoCartaColocadaBocaArriba( ), new ModoAtaque() );
			jugador1.colocar(monstruo2, new EstadoCartaColocadaBocaAbajo(), new ModoDefensa() );
			jugador1.colocar(cartaMagica1, new EstadoCartaColocadaBocaAbajo() );
			jugador1.colocar(cartaMagica2, new EstadoCartaColocadaBocaAbajo() );
			
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
			assertEquals( vidaEsperada , jugador2.obtenerVidaRestante() );
		}
		
		@Test
		public void testColocarUnacartaCampoDestruyeLaCartaCampoEnemiga() {
			CartaCampoFactory fabrica = new CartaCampoFactory();
			Jugador jugador1 = new Jugador();
			Jugador jugador2 = new Jugador();
			CartaCampo campo1 = fabrica.crearSogen();
			CartaCampo campo2 = fabrica.crearWasteland();
			
			jugador1.enfrentarseA(jugador2);
			jugador2.enfrentarseA(jugador1);
			
			EstadoCarta bocaArriba = new EstadoCartaColocadaBocaArriba();
			jugador1.colocar(campo1, bocaArriba);
			jugador2.colocar(campo2, bocaArriba);
			
			assertEquals(1,jugador1.obtenerCantidadDeCartasEnCementerio());
		}
		
		@Test
		public void testExtraerTodasLasCartasDerrotaAlJugador() {
			Jugador jugador = new Jugador();
			Jugador jugadorEnemigo = new Jugador();
			
			jugador.enfrentarseA(jugadorEnemigo);
			jugadorEnemigo.enfrentarseA(jugador);
			
			for(int i=0; i<36; i++) {
				jugador.tomarCartaDelMazo();
			}
			assertTrue(jugador.estaDerrotado());
		}
		
		@Test
		public void testJugadorConLasCincoPartesDeExodiaEnManoDerrotaAlJugadorEnemigo() {
			Jugador jugador1 = new Jugador();
			Jugador jugador2 = new Jugador();
			
			jugador1.enfrentarseA(jugador2);
			jugador2.enfrentarseA(jugador1);
			
			for(int i=0; i<35; i++) {
				jugador1.tomarCartaDelMazo();
			}
			
			assertTrue(jugador2.estaDerrotado());
		}
		
		@Test
		public void testJugadorConLasCincoPartesDeExodiaEnManoNoDerrotaAlJugadorConExodia() {
			Jugador jugador1 = new Jugador();
			Jugador jugador2 = new Jugador();
			
			jugador1.enfrentarseA(jugador2);
			jugador2.enfrentarseA(jugador1);
			
			for(int i=0; i<35; i++) {
				jugador1.tomarCartaDelMazo();
			}
			
			assertFalse(jugador1.estaDerrotado());
		}
}
