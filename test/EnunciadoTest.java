import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

import campo.Campo;
import carta.*;
import efectos.EfectoAgujeroNegro;
import jugador.Jugador;


public class EnunciadoTest {
	
	
	//Colocar una carta de monstruo en posición de ataque.
	@Test
	public void test01ColocarCartaMonstruoEnModoAtaque() {
		Campo campoTest = new Campo();
		CartaMonstruo cartaMonstruo = new CartaMonstruo();
		
		campoTest.colocarMonstruoEnModoAtaque(cartaMonstruo);
		assertEquals(1,campoTest.obtenerCantidadDeCartasEnZonaMonstruo());
		assertTrue( cartaMonstruo.estaColocadaEnModoAtaque() );
	}
	
	@Test
	public void test02ColocarMonstruoBocaAbajoEnModoDefensa() {
		Campo campoTest = new Campo();
		CartaMonstruo cartaMonstruo = new CartaMonstruo();
		
		campoTest.colocarMonstruoBocaAbajoEnModoDefensa(cartaMonstruo);
		
		assertEquals(1,campoTest.obtenerCantidadDeCartasEnZonaMonstruo());
		assertTrue( cartaMonstruo.estaColocadaBocaAbajoEnModoDefensa() );
		
	}
	
	@Test
	public void test03ColocarCartaMagicaEnCampoBocaAbajo() {
		
		CartaMagica cartaMagica = new CartaMagica();
		Campo campo = new Campo();
		cartaMagica.colocarBocaAbajo();
		campo.colocarCartaMagicaBocaAbajo(cartaMagica);
		assertEquals(1, campo.obtenerCantidadDeCartasEnZonaUtilidad() );
		assertTrue(cartaMagica.estaColocadaBocaAbajo());
	}
	
	@Test
	public void test04ColocarCartaTrampaEnCampoBocaAbajo() {
		
		CartaTrampa cartaTrampa = new CartaTrampa();
		Campo campoTest = new Campo();
		campoTest.colocarCartaTrampaBocaAbajo(cartaTrampa);
		
		assertEquals(1, campoTest.obtenerCantidadDeCartasEnZonaUtilidad() );
		assertTrue(cartaTrampa.estaColocadaBocaAbajo());
	}
	
	@Test
	public void test05MandarCartaAlCementerio() {
		
		CartaTrampa cartaTrampa = new CartaTrampa();
		Campo campo = new Campo();

		campo.colocarCarta( cartaTrampa );
		cartaTrampa.destruirCarta();
		campo.enviarCartasDestruidasAlCementerio();
		
		assertEquals( 1, campo.obtenerCantidadDeCartasEnCementerio() );
		
	}
	
	/*Colocar una carta de monstruo en posición de ataque, el oponente coloca otra carta
de monstruo en posición de ataque (con mayor ataque). Atacar al primer monstruo y
verificar que este se destruyó, y sufro daño a los puntos de vida igual a la diferencia
de los puntos de ataque de los monstruos*/

//	@Test
//	public void test06MonstruoAtacaAOtroMonstruoEnModoAtaqueLoDestruyeYRestaVidaAJugador() {
//		CartaMonstruo unaCartaMonstruo = new CartaMonstruo();
//		CartaMonstruo otraCartaMonstruo = new CartaMonstruo();
//		
//		unaCartaMonstruo.colocarEnModoAtaque();
//		otraCartaMonstruo.colocarEnModoAtaque();
//		Jugador j1 = new Jugador();
//		
//		j1.recibirDanio( otraCartaMonstruo.atacar( unaCartaMonstruo ) );
//		
//		int vidaEsperada = 8000;
//		vidaEsperada -= ( otraCartaMonstruo.obtenerPuntosAtaque() - unaCartaMonstruo.obtenerPuntosAtaque() );
//	
//		assertEquals( vidaEsperada, j1.obtenerVidaRestante() );
//		assertTrue( unaCartaMonstruo.estaDestruida() );
//	
//	}
//
//	@Test
//	public void test06MonstruoAtacaAOtroMonstruoEnModoAtaqueLoDestruyeYRestaVidaAJugadorQueA() {
//		CartaMonstruo unaCartaMonstruo = new CartaMonstruo();
//		CartaMonstruo otraCartaMonstruo = new CartaMonstruo();
//		
//		unaCartaMonstruo.colocarEnModoAtaque();
//		otraCartaMonstruo.colocarEnModoAtaque();
//		
//		Jugador j1 = new Jugador();
//		
//		j1.recibirDanio( otraCartaMonstruo.atacar( unaCartaMonstruo ) );
//		
//		int vidaEsperada = 8000;
//		vidaEsperada -= ( otraCartaMonstruo.obtenerPuntosAtaque() - unaCartaMonstruo.obtenerPuntosAtaque() );
//		assertEquals( vidaEsperada, j1.obtenerVidaRestante() );
//		assertTrue( otraCartaMonstruo.estaDestruida() );
//	}

	@Test
	public void test06MonstruoAtacaAOtroMonstruoEnModoAtaqueConMenorAtaque() {
		CartaMonstruo monstruoConMayorAtaque = new CartaMonstruo(2000, 3000);
		CartaMonstruo monstruoConMenorAtaque = new CartaMonstruo(1000, 2000);
		Jugador jugador1 = new Jugador();
		Jugador jugador2 = new Jugador();
		
		jugador1.enfrentarseA(jugador2);
		jugador2.enfrentarseA(jugador1);
 		
 		jugador1.colocarMonstruoEnModoAtaque(monstruoConMayorAtaque);
 		jugador2.colocarMonstruoEnModoAtaque(monstruoConMenorAtaque);
 		
 		jugador1.atacar(monstruoConMayorAtaque, monstruoConMenorAtaque);
		
		assertFalse(monstruoConMayorAtaque.estaDestruida());
		assertTrue(monstruoConMenorAtaque.estaDestruida());
		
		int vidaEsperada = 7000;
		
		assertEquals(vidaEsperada , jugador2.obtenerVidaRestante());
	}
 
	@Test
	public void test07MonstruoAtacaAOtroMonstruoEnModoAtaqueConMayorAtaque() {
		CartaMonstruo monstruoConMayorAtaque = new CartaMonstruo(2000, 3000);
 		CartaMonstruo monstruoConMenorAtaque = new CartaMonstruo(1000, 2000);
 		Campo campoTest = new Campo();
 		Campo campoTestEnemigo = new Campo(); 
 		
 		campoTest.colocarMonstruoEnModoAtaque(monstruoConMayorAtaque);
 		campoTestEnemigo.colocarMonstruoEnModoAtaque(monstruoConMenorAtaque);
 		
 		monstruoConMayorAtaque.atacar(monstruoConMenorAtaque);
 		
 		assertFalse(monstruoConMayorAtaque.estaDestruida());
 		assertTrue(monstruoConMenorAtaque.estaDestruida());
	}
	
	
	
	@Test
	public void test08MonstruoAtacaAOtroMonstruoEnModoAtaqueConIgualAtaque() {
		CartaMonstruo unMonstruoConMilAtaque = new CartaMonstruo(1000, 3000);
 		CartaMonstruo otroMonstruoConMilAtaque = new CartaMonstruo(1000, 2000);
 		Campo campoTest = new Campo();
 		Campo campoTestEnemigo = new Campo(); 
 		
 		campoTest.colocarMonstruoEnModoAtaque(unMonstruoConMilAtaque);
 		campoTestEnemigo.colocarMonstruoEnModoAtaque(otroMonstruoConMilAtaque);
 		unMonstruoConMilAtaque.atacar(otroMonstruoConMilAtaque);
 		
 		assertTrue(unMonstruoConMilAtaque.estaDestruida());
 		assertTrue(otroMonstruoConMilAtaque.estaDestruida());
	}
	
	@Test
	public void test09MonstruoSeDefiendeDeOtroMonstruoEnModoAtaqueConMayorAtaqueQueSuDefensa() {
		CartaMonstruo monstruoAtacante = new CartaMonstruo(3000, 3000);
 		CartaMonstruo monstruoDefensor = new CartaMonstruo(1000, 2000);
 		Campo campoTest = new Campo();
 		Campo campoTestEnemigo = new Campo(); 
 		
 		campoTest.colocarMonstruoEnModoAtaque(monstruoAtacante);
 		campoTestEnemigo.colocarMonstruoBocaArribaEnModoDefensa(monstruoDefensor);
 		monstruoAtacante.atacar(monstruoDefensor);
 		
 		assertFalse(monstruoAtacante.estaDestruida());
 		assertTrue(monstruoDefensor.estaDestruida());
	}

	@Test
	public void test10MonstruoSeDefiendeDeOtroMonstruoEnModoAtaqueConMenorAtaqueQueSuDefensa() {
		CartaMonstruo monstruoAtacante = new CartaMonstruo(1000, 3000);
		CartaMonstruo monstruoDefensor = new CartaMonstruo(1000, 2000);
 		Campo campoTest = new Campo();
 		Campo campoTestEnemigo = new Campo(); 
 		
 		campoTest.colocarMonstruoEnModoAtaque(monstruoAtacante);
 		campoTestEnemigo.colocarMonstruoBocaArribaEnModoDefensa(monstruoDefensor);
 		monstruoAtacante.atacar(monstruoDefensor);
 		
 		assertFalse(monstruoAtacante.estaDestruida());
 		assertFalse(monstruoDefensor.estaDestruida());
	}
	
	@Test
	public void test11MonstruosDelCampoSeDestruyenAlColocarAgujeroNegro() {
		CartaMonstruo monstruoAtacante = new CartaMonstruo(1000, 3000);
		CartaMonstruo monstruoDefensor = new CartaMonstruo(1000, 2000);
 		Campo campoTest = new Campo();
 		Campo campoTestEnemigo = new Campo(); 
 		EfectoAgujeroNegro agujeroNegroEfecto = new EfectoAgujeroNegro();
 		
 		campoTest.colocarMonstruoEnModoAtaque(monstruoAtacante);
 		campoTestEnemigo.colocarMonstruoBocaArribaEnModoDefensa(monstruoDefensor);
 		
 		agujeroNegroEfecto.aplicarEfecto(campoTest, campoTestEnemigo);
 		
 		assertFalse(campoTest.tieneCartas());
 		assertFalse(campoTestEnemigo.tieneCartas());
	}
//	
//	@Test
//	public void test12ColocarMonstruoQueRequiereUnSacrificioDestruyeElMonstruoAnterior() {
//	
//	}
//
//	@Test
//	public void test13ColocarMonstruoQueRequiereDosSacrificiosDestruyeLosDosMonstruosAnteriores() {
//	
//	}
}
