package campo;
import carta.*;

import static org.junit.Assert.*;
import org.junit.Test;

public class CampoTest {
	
	//La carta tiene 6 estados: En mazo, en mano, en campo ataque,
	//en campo defensa boca arriba, en campo defensa boca abajo y en cementerio (muerta).
	
	
	@Test
	public void testComienzaLaPartidaCon40CartasEnElMazo() {
		Campo campoTest = new Campo();
		assertEquals(40, campoTest.obtenerCantidadDeCartasEnMazo());
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
		Campo campoTest = new Campo();
		CartaMonstruo cartaTestMonstruo = new CartaMonstruo();
		campoTest.colocarCarta(cartaTestMonstruo);
		assertEquals(1, campoTest.obtenerCantidadDeCartasEnZonaMonstruo());
	}
	
	@Test
	public void testColocarUnaCartaMagicaEnZonaCorrecta() {
		Campo campoTest = new Campo();
		CartaMagica cartaTestMagica = new CartaMagica();
		campoTest.colocarCarta(cartaTestMagica);
		assertEquals(1, campoTest.obtenerCantidadDeCartasEnZonaUtilidad());
	}
	
	@Test
	public void testColocarUnaCartaTrampaEnZonaCorrecta() {
		Campo campoTest = new Campo();
		CartaTrampa cartaTestTrampa = new CartaTrampa();
		campoTest.colocarCarta(cartaTestTrampa);
		assertEquals(1, campoTest.obtenerCantidadDeCartasEnZonaUtilidad());
	}
	
	@Test
	public void testColocarUnaCartaCampoEnZonaCorrecta() {
		Campo campoTest = new Campo();
		CartaCampo cartaTestCampo = new CartaCampo();
		campoTest.colocarCarta(cartaTestCampo);
		assertEquals(1, campoTest.obtenerCantidadDeCartasEnZonaCampo());
	}
	
	@Test
	public void testObtenerVidaRestanteFunciona() {
		Campo campo = new Campo();
		int vidaEsperada = 8000;
		assertEquals( vidaEsperada , campo.obtenerVidaRestante() );
	}
	
	@Test
	public void testColocarUnaCartaMonstruoEnModoAtaqueQuedaColocado() {
		Campo campo = new Campo();
		CartaMonstruo cartaMonstruo = new CartaMonstruo();
		
		campo.colocarMonstruoEnModoAtaque(cartaMonstruo);
		
		assertTrue( cartaMonstruo.estaColocadaEnModoAtaque() );
	}
	
	@Test
	public void testColocarUnaCartaMonstruoBocaArribaEnModoDefensaQuedaColocado() {
		Campo campo = new Campo();
		CartaMonstruo carta = new CartaMonstruo();
		
		campo.colocarMonstruoBocaArribaEnModoDefensa(carta);
		
		assertTrue( carta.estaColocadaBocaArribaEnModoDefensa() );
	}
	
	@Test
	public void testColocarUnaCartaMonstruoBocaAbajoEnModoDefensaQuedaColocado() {
		
		Campo campo = new Campo();
		CartaMonstruo carta = new CartaMonstruo();
		
		campo.colocarMonstruoBocaAbajoEnModoDefensa(carta);
		
		assertTrue( carta.estaColocadaBocaAbajoEnModoDefensa() );
	}
	
	@Test
	public void testColocarUnaCartaMagicaBocaAbajoQuedaColocada() {
		
		Campo campo = new Campo();
		CartaMagica carta = new CartaMagica();
		
		campo.colocarCartaMagicaBocaAbajo(carta);
		
		assertTrue( carta.estaColocadaBocaAbajo() );
	}
	
	@Test
	public void testColocarUnaCartaMagicaBocaArribaQuedaColocada() {
		Campo campo = new Campo();
		CartaMagica carta = new CartaMagica();
		
		campo.colocarCartaMagicaBocaArriba(carta);
		
		assertTrue( carta.estaColocadaBocaArriba());
	}
	
	@Test
	public void testColocarUnaCartaTrampaBocaAbajoQuedaColocada() {
		Campo campo = new Campo();
		CartaTrampa carta = new CartaTrampa();
		
		campo.colocarCartaTrampaBocaAbajo(carta);
		
		assertTrue( carta.estaColocadaBocaAbajo() );
	}
	
	@Test
	public void testColocarUnaCartaTrampaBocaArribaQuedaColocada() {
		Campo campo = new Campo();
		CartaTrampa carta = new CartaTrampa();
		
		campo.colocarCartaTrampaBocaArriba(carta);
		
		assertTrue( carta.estaColocadaBocaArriba() );
	}
	
	@Test
	public void testColocarUnaCartaMagicaYUnaTrampaQudanColocadas() {
		Campo campo = new Campo();
		CartaMagica carta1 = new CartaMagica();
		CartaTrampa carta2 = new CartaTrampa();
		
		campo.colocarCartaMagicaBocaAbajo(carta1);
		campo.colocarCartaTrampaBocaAbajo(carta2);
		int cartasEnCampoEsperadas = 2;
		
		assertEquals(cartasEnCampoEsperadas, campo.obtenerCantidadDeCartasJugadas());
	}
	@Test
	public void testColocarDosCartasMonstruoyQuedanColocadas() {
		Campo campo = new Campo();
		CartaMonstruo carta1 = new CartaMonstruo();
		CartaMonstruo carta2 = new CartaMonstruo();
		
		campo.colocarMonstruoBocaArribaEnModoDefensa(carta1);
		campo.colocarMonstruoBocaAbajoEnModoDefensa(carta2);
		int cartasEnCampoEsperadas = 2;
		
		assertEquals(cartasEnCampoEsperadas, campo.obtenerCantidadDeCartasJugadas());
	}
	
	@Test
	public void testColocarCartaMonstruoCartaMagicaYCartaTrampaQuedanColocadas() {
		Campo campo = new Campo();
		CartaMonstruo carta1 = new CartaMonstruo();
		CartaMagica carta2 = new CartaMagica();
		CartaTrampa carta3 = new CartaTrampa();
		
		campo.colocarMonstruoBocaArribaEnModoDefensa(carta1);
		campo.colocarCartaMagicaBocaAbajo(carta2);
		campo.colocarCartaTrampaBocaAbajo(carta3);
		
		int cartasEnCampoEsperadas = 3;
		
		assertEquals( cartasEnCampoEsperadas, campo.obtenerCantidadDeCartasJugadas() );
	}
}
