package campo;
import carta.*;
import efectos.*;
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
		
		cartaMonstruo.colocarEnModoAtaque();
		
		campo.colocarCarta(cartaMonstruo);
		
		assertTrue( cartaMonstruo.estaColocadaEnModoAtaque() );
		assertEquals( 1, campo.obtenerCantidadDeCartasEnZonaMonstruo() );
	}
	
	@Test
	public void testColocarUnaCartaMonstruoBocaArribaEnModoDefensaQuedaColocado() {
		Campo campo = new Campo();
		CartaMonstruo carta = new CartaMonstruo();
		
		carta.colocarBocaArribaEnModoDefensa();
		
		campo.colocarCarta(carta);
		
		assertTrue( carta.estaColocadaBocaArribaEnModoDefensa() );
		assertEquals( 1, campo.obtenerCantidadDeCartasEnZonaMonstruo() );
	}
	
	@Test
	public void testColocarUnaCartaMonstruoBocaAbajoEnModoDefensaQuedaColocado() {
		
		Campo campo = new Campo();
		CartaMonstruo carta = new CartaMonstruo();
		
		carta.colocarBocaAbajoEnModoDefensa();
		
		campo.colocarCarta(carta);
		
		assertTrue( carta.estaColocadaBocaAbajoEnModoDefensa() );
		assertEquals( 1, campo.obtenerCantidadDeCartasEnZonaMonstruo() );
	
	}
	
	@Test
	public void testColocarUnaCartaMagicaBocaAbajoQuedaColocada() {
		
		Campo campo = new Campo();
		CartaMagica carta = new CartaMagica();
		
		carta.colocarBocaAbajo();
		
		campo.colocarCarta(carta);
		
		assertTrue( carta.estaColocadaBocaAbajo() );
		assertEquals( 1, campo.obtenerCantidadDeCartasEnZonaUtilidad() );
	
	}
	
	@Test
	public void testColocarUnaCartaMagicaBocaArribaQuedaColocada() {
		Campo campo = new Campo();
		CartaMagica carta = new CartaMagica();
		//No se guarda el efecto de la carta magica al colocarla boca arriba
		carta.colocarBocaArriba();
		
		campo.colocarCarta(carta);
		
		assertTrue( carta.estaColocadaBocaArriba());
		assertEquals( 1, campo.obtenerCantidadDeCartasEnZonaUtilidad() );
	
	}
	
	@Test
	public void testColocarUnaCartaTrampaBocaAbajoQuedaColocada() {
		Campo campo = new Campo();
		CartaTrampa carta = new CartaTrampa();
		
		carta.colocarBocaAbajo();
		
		campo.colocarCarta(carta);
		
		assertTrue( carta.estaColocadaBocaAbajo() );
		assertEquals( 1, campo.obtenerCantidadDeCartasEnZonaUtilidad() );
	}
	
	@Test
	public void testColocarUnaCartaTrampaBocaArribaQuedaColocada() {
		Campo campo = new Campo();
		CartaTrampa carta = new CartaTrampa();
		//No se guarda el efecto de la carta trampa al colocarla boca arriba
		carta.colocarBocaArriba();
		
		campo.colocarCarta(carta);
		
		assertTrue( carta.estaColocadaBocaArriba() );
		assertEquals( 1, campo.obtenerCantidadDeCartasEnZonaUtilidad() );
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
		assertTrue ( campo.obtenerCantidadDeCartasEnZonaMonstruo() == 0 );
	}
}
