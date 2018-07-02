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
		public void testSeCreaJugadorConUnCampoYNoTieneCartasEnLaMano() {
			Jugador jugador1 = new Jugador();
			
			assertEquals( 0, jugador1.obtenerCantidadDeCartasEnLaMano() );
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
			assertTrue(jugador1.tieneVida(vidaEsperada));
		}
		
		@Test
		public void testJugadorTomaDosCartasDelMazoYTieneDosCartasEnLaMano() {
			Jugador jugador1 = new Jugador();
			jugador1.tomarCartaDelMazo();
			jugador1.tomarCartaDelMazo();
			
			assertEquals(2, jugador1.obtenerCantidadDeCartasEnLaMano());
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
			assertTrue( jugador2.tieneVida(vidaEsperada) );
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
		
		@Test
		public void testJugadorColocaAgujeroNegroBocaAbajoYLuegoLaVolteaYDestruyeSuMonstruo() {
			CartaMonstruoFactory fabrica = new CartaMonstruoFactory();
			CartaMagicaFactory magicas = new CartaMagicaFactory();
			Atacable beta = fabrica.crearBetaElGuerreroMagnetico();
			Atacable dragonKoumori = fabrica.crearDragonDeKoumori();
			Activable agujeroNegro = magicas.crearAgujeroNegro();
			
			Jugador jugador1 = new Jugador();
			Jugador jugador2 = new Jugador();
			
			jugador1.enfrentarseA(jugador2);
			jugador2.enfrentarseA(jugador1);
			jugador2.colocar(dragonKoumori, new EstadoCartaColocadaBocaArriba(), new ModoAtaque());
			jugador2.colocar(beta, new EstadoCartaColocadaBocaArriba(), new ModoAtaque());
			
			jugador2.colocar(agujeroNegro, new EstadoCartaColocadaBocaAbajo() );
			
			jugador2.voltearCarta(agujeroNegro);
			
			assertEquals(3, jugador2.obtenerCantidadDeCartasEnCementerio());

		}
		
		@Test
		public void testJugadorColocaFisuraBocaAbajoYLuegoLaVolteaYDestruyeMonstruoMasDebil() {
			CartaMonstruoFactory fabrica = new CartaMonstruoFactory();
			CartaMagicaFactory magicas = new CartaMagicaFactory();
			Atacable monstruoCon1900Atk = fabrica.crearDragonDeBrillo();
			Atacable monstruoCon1100Atk = fabrica.crearConejoOscuro();
			Activable fisura = magicas.crearFisura();
			
			Jugador jugador1 = new Jugador();
			Jugador jugador2 = new Jugador();
			
			jugador1.enfrentarseA(jugador2);
			jugador2.enfrentarseA(jugador1);
			jugador1.colocar(monstruoCon1900Atk, new EstadoCartaColocadaBocaArriba(), new ModoAtaque());
			jugador1.colocar(monstruoCon1100Atk, new EstadoCartaColocadaBocaArriba(), new ModoAtaque());
			
			jugador2.colocar(fisura, new EstadoCartaColocadaBocaAbajo() );
			
			jugador2.voltearCarta(fisura);
			
			assertTrue( monstruoCon1100Atk.estaDestruida() );
		}
		
		@Test
		public void testJugadorColocaOllaDeLaCodiciaBocaAbajoLuegoLaVolteaYtomaDosCartas() {
			CartaMagicaFactory magicas = new CartaMagicaFactory();
			Activable potOfGreed = magicas.crearOllaDeLaCodicia();
			
			Jugador jugador1 = new Jugador();
			Jugador jugador2 = new Jugador();
			
			jugador1.enfrentarseA(jugador2);
			jugador2.enfrentarseA(jugador1);
			
			jugador1.colocar(potOfGreed, new EstadoCartaColocadaBocaAbajo() );
			
			jugador1.voltearCarta(potOfGreed);
			
			assertEquals(7, jugador1.obtenerCantidadDeCartasEnLaMano());
		}
		
		@Test
		public void testJugadorColocaUnMonstruoBocaAbajoLuegoLoVolteaYQuedaBocaArribaEnModoAtaque() {
			CartaMonstruoFactory fabrica = new CartaMonstruoFactory();
			Atacable atacante = fabrica.crearBetaElGuerreroMagnetico();
			Atacable atacado = fabrica.crearDragonDeKoumori();
			Jugador jugador1 = new Jugador();
			Jugador jugador2 = new Jugador();
			
			jugador1.enfrentarseA(jugador2);
			jugador2.enfrentarseA(jugador1);
			
			jugador1.colocar(atacado, new EstadoCartaColocadaBocaArriba(), new ModoAtaque());
			jugador2.colocar(atacante, new EstadoCartaColocadaBocaAbajo(), new ModoDefensa());
			
			ModoAtaque modoataque = new ModoAtaque();
			
			jugador2.voltearCarta(atacante);
			atacante.cambiarA(modoataque);
			jugador2.atacar(atacante, atacado);
			
			int vidaEsperada = 8000 - 200;
			assertTrue(jugador1.tieneVida(vidaEsperada));
		}
}
