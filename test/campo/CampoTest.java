package campo;
import efectos.*;
import estadoCarta.EstadoCarta;
import estadoCarta.EstadoCartaColocadaBocaAbajo;
import estadoCarta.EstadoCartaColocadaBocaArriba;
import factories.CartaMonstruoFactory;
import jugador.Jugador;
import modos.Modo;
import modos.ModoAtaque;
import modos.ModoDefensa;

import static org.junit.Assert.*;
import org.junit.Test;

import cartas.*;

public class CampoTest {
	
	//La carta tiene 6 estados: En mazo, en mano, en campo ataque,
	//en campo defensa boca arriba, en campo defensa boca abajo y en cementerio (muerta).
	
	
	@Test
	public void testComienzaLaPartidaCon35CartasEnElMazo() {
		Campo campoTest = new Campo();
		assertEquals(35, campoTest.obtenerCantidadDeCartasEnMazo());
	}
	
	@Test
	public void testComienzaLaPartidaCon0CartasEnElCementerio() {
		Campo campoTest = new Campo();
		assertEquals(0, campoTest.obtenerCantidadDeCartasEnCementerio());
	}
	
	@Test
	public void testCampoComienzaVacio() {
		Campo campoTest = new Campo();
		assertFalse(campoTest.tieneCartas());
	}
	
	@Test
	public void testColocarUnMonstruoBocaArribaEnZonaCorrecta() {
		Campo campoPropio = new Campo();
		Puntos ataqueMonstruo1 = new Puntos(1000);
		Puntos defensaMonstruo1 = new Puntos(500);
		int estrellasMonstruo = 3;
		Atacable monstruoPropio = new CartaMonstruo(ataqueMonstruo1, defensaMonstruo1, estrellasMonstruo);
		Modo modoAtaque = new ModoAtaque();
		EstadoCarta bocaArriba = new EstadoCartaColocadaBocaArriba();
		
		monstruoPropio.cambiarA(modoAtaque);
		campoPropio.colocarCarta(monstruoPropio, bocaArriba);
		
		assertEquals(1, campoPropio.obtenerCantidadDeCartasEnZonaMonstruos());
	}
	
	@Test
	public void testColocarUnaCartaMagicaEnZonaCorrecta() {
		Campo campoTest = new Campo();
		
		EfectoAgujeroNegro agujeroNegroEfecto = new EfectoAgujeroNegro();
 		Colocable carta = new CartaMagica( agujeroNegroEfecto );
		
		EstadoCarta bocaAbajo = new EstadoCartaColocadaBocaAbajo();
		campoTest.colocarCarta(carta, bocaAbajo);
		assertEquals(1, campoTest.obtenerCantidadDeCartasEnZonaMagicasYTrampas());
	}
	
	@Test
	public void testColocarUnaCartaTrampaEnZonaCorrecta() {
		Campo campoTest = new Campo();
		
		Efecto efectoTest = new EfectoNulo();
 		Colocable carta = new CartaTrampa(efectoTest);
 		
		EstadoCarta bocaAbajo = new EstadoCartaColocadaBocaAbajo();
		campoTest.colocarCarta(carta, bocaAbajo);
		assertEquals(1, campoTest.obtenerCantidadDeCartasEnZonaMagicasYTrampas());
	}
	
	@Test
	public void testColocarUnaCartaCampoEnZonaCorrecta() {
		Campo campoTest = new Campo();
		
		Efecto efectoNulo = new EfectoNulo();
 		Colocable cartaCampo = new CartaCampo(efectoNulo);
 		
		EstadoCarta bocaArriba = new EstadoCartaColocadaBocaArriba();
		campoTest.colocarCarta(cartaCampo, bocaArriba);
		assertEquals(1, campoTest.obtenerCantidadDeCartasEnZonaCampo());
	}
	
	
	@Test
	public void testColocarUnaCartaMonstruoEnModoAtaqueQuedaColocado() {
		CartaMonstruoFactory fabrica = new CartaMonstruoFactory();
		
		CartaMonstruo cartaMonstruo = fabrica.crearHeroeElementalAvian();
		Campo campo = new Campo();

		EstadoCarta bocaArriba = new EstadoCartaColocadaBocaArriba();
		campo.colocarCarta(cartaMonstruo, bocaArriba);
		
		assertTrue(cartaMonstruo.estaEnModoAtaque());
		assertTrue(cartaMonstruo.estaColocadaBocaArriba());
		assertEquals(1, campo.obtenerCantidadDeCartasEnZonaMonstruos());
	}
	
	
	@Test
	public void testColocarUnaCartaMonstruoBocaArribaEnModoDefensaQuedaColocado() {
		CartaMonstruoFactory fabrica = new CartaMonstruoFactory();
		
		CartaMonstruo cartaMonstruo = fabrica.crearHeroeElementalAvian();
		Campo campo = new Campo();

		cartaMonstruo.colocarBocaArribaEnModoDefensa();
		EstadoCarta bocaArriba = new EstadoCartaColocadaBocaArriba();
		campo.colocarCarta(cartaMonstruo, bocaArriba);
		assertTrue( cartaMonstruo.estaColocadaBocaArriba());
		assertTrue( cartaMonstruo.estaEnModoDefensa());
		assertEquals( 1, campo.obtenerCantidadDeCartasEnZonaMonstruos() );
	}
	
	@Test
	public void testColocarUnaCartaMonstruoBocaAbajoEnModoDefensaQuedaColocado() {
		
		CartaMonstruoFactory fabrica = new CartaMonstruoFactory();
		
		CartaMonstruo cartaMonstruo = fabrica.crearHeroeElementalAvian();
		Campo campo = new Campo();

		cartaMonstruo.colocarBocaAbajoEnModoDefensa();
		EstadoCarta bocaAbajo = new EstadoCartaColocadaBocaAbajo();
		campo.colocarCarta(cartaMonstruo, bocaAbajo);
		assertTrue( cartaMonstruo.estaColocadaBocaAbajo());
		assertTrue( cartaMonstruo.estaEnModoDefensa());
		assertEquals( 1, campo.obtenerCantidadDeCartasEnZonaMonstruos() );
	
	}
	
	@Test
	public void testColocarUnaCartaMagicaBocaAbajoQuedaColocada() {
		
		Campo campo = new Campo();
		CartaMagica carta = new CartaMagica();
		
		carta.colocarBocaAbajo();
		
		campo.colocarCarta(carta);
		
		assertTrue( carta.estaColocadaBocaAbajo() );
		assertEquals( 1, campo.obtenerCantidadDeCartasEnZonaMagicasYTrampas() );
	
	}
	
	@Test
	public void testColocarUnaCartaMagicaBocaArribaQuedaColocada() {
		Campo campo = new Campo();
		CartaMagica carta = new CartaMagica();
		//No se guarda el efecto de la carta magica al colocarla boca arriba
		carta.colocarBocaArriba();
		
		campo.colocarCarta(carta);
		
		assertTrue( carta.estaColocadaBocaArriba());
		assertEquals( 1, campo.obtenerCantidadDeCartasEnZonaMagicasYTrampas() );
	
	}
	
	@Test
	public void testColocarUnaCartaTrampaBocaAbajoQuedaColocada() {
		Campo campo = new Campo();
		CartaTrampa carta = new CartaTrampa();
		
		carta.colocarBocaAbajo();
		
		campo.colocarCarta(carta);
		
		assertTrue( carta.estaColocadaBocaAbajo() );
		assertEquals( 1, campo.obtenerCantidadDeCartasEnZonaMagicasYTrampas() );
	}
	
	@Test
	public void testColocarUnaCartaTrampaBocaArribaQuedaColocada() {
		Campo campo = new Campo();
		CartaTrampa carta = new CartaTrampa();
		//No se guarda el efecto de la carta trampa al colocarla boca arriba
		carta.colocarBocaArriba();
		
		campo.colocarCarta(carta);
		
		assertTrue( carta.estaColocadaBocaArriba() );
		assertEquals( 1, campo.obtenerCantidadDeCartasEnZonaMagicasYTrampas() );
	}
	
	@Test

	public void testColocarUnaCartaMagicaYUnaTrampaQudanColocadas() {
		Campo campo = new Campo();
		CartaMagica cartaMagica = new CartaMagica();
		CartaTrampa cartaTrampa = new CartaTrampa();
		
		cartaMagica.colocarBocaAbajo();
		cartaTrampa.colocarBocaAbajo();
		
		campo.colocarCarta(cartaMagica);
		campo.colocarCarta(cartaTrampa);
		int cartasEnCampoEsperadas = 2;
		
		assertEquals(cartasEnCampoEsperadas, campo.obtenerCantidadDeCartasEnJuego());
	}
	
	@Test
	public void testColocarDosCartasMonstruoyQuedanColocadas() {
		Campo campo = new Campo();
		CartaMonstruo cartaMonstruo1 = new CartaMonstruo();
		CartaMonstruo cartaMonstruo2 = new CartaMonstruo();
		
		cartaMonstruo1.colocarBocaArribaEnModoDefensa();
		cartaMonstruo2.colocarBocaAbajoEnModoDefensa();
		
		campo.colocarCarta(cartaMonstruo1);
		campo.colocarCarta(cartaMonstruo2);
		int cartasEnCampoEsperadas = 2;
		
		assertEquals(cartasEnCampoEsperadas, campo.obtenerCantidadDeCartasEnJuego());
	}
	
	@Test
	public void testColocarCartaMonstruoCartaMagicaYCartaTrampaQuedanColocadas() {
		Campo campo = new Campo();
		CartaMonstruo cartaMonstruo = new CartaMonstruo();
		CartaMagica cartaMagica = new CartaMagica();
		CartaTrampa cartaTrampa = new CartaTrampa();
		
		cartaMonstruo.colocarBocaArribaEnModoDefensa();
		cartaMagica.colocarBocaAbajo();
		cartaTrampa.colocarBocaAbajo();
		
		campo.colocarCarta(cartaMonstruo);
		campo.colocarCarta(cartaMagica);
		campo.colocarCarta(cartaTrampa);
		
		int cartasEnCampoEsperadas = 3;
		
		assertEquals( cartasEnCampoEsperadas, campo.obtenerCantidadDeCartasEnJuego() );
	}

	@Test
	public void testVaciarZonaMonstruosDelCampo() {
		Campo campo = new Campo();
		CartaMonstruo cartaMonstruo1 = new CartaMonstruo();
		CartaMonstruo cartaMonstruo2 = new CartaMonstruo();
		CartaMonstruo cartaMonstruo3 = new CartaMonstruo();
		
		cartaMonstruo1.colocarBocaArribaEnModoDefensa();
		cartaMonstruo2.colocarEnModoAtaque();
		cartaMonstruo3.colocarBocaAbajoEnModoDefensa();
		
		campo.colocarCarta(cartaMonstruo1);
		campo.colocarCarta(cartaMonstruo2);
		campo.colocarCarta(cartaMonstruo3);
	
		campo.vaciarZonaMonstruos();
		assertTrue ( campo.obtenerCantidadDeCartasEnZonaMonstruos() == 0 );
	}
}
