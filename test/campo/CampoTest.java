package campo;
import static org.junit.Assert.assertEquals;
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
		assertEquals(false, campoTest.tieneCartas());
	}
	
	@Test
	public void testColocarUnMonstruoBocaArribaEnZonaCorrecta() {
		Campo campoTest = new Campo();
		Carta cartaTestMonstruo = new CartaMonstruo();
		campoTest.colocarCarta(cartaTestMonstruo);
		assertEquals(1, campoTest.obtenerCantidadDeCartasEnZonaMonstruo());
	}
	
	@Test
	public void testColocarUnaCartaMagicaEnZonaCorrecta() {
		Campo campoTest = new Campo();
		Carta cartaTestMagica = new CartaMagica();
		campoTest.colocarCarta(cartaTestMagica);
		assertEquals(1, campoTest.obtenerCantidadDeCartasEnZonaUtilidad());
	}
	
	@Test
	public void testColocarUnaCartaTrampaEnZonaCorrecta() {
		Campo campoTest = new Campo();
		Carta cartaTestTrampa = new CartaTrampa();
		campoTest.colocarCarta(cartaTestTrampa);
		assertEquals(1, campoTest.obtenerCantidadDeCartasEnZonaUtilidad());
	}
	
	@Test
	public void testColocarUnaCartaCampoEnZonaCorrecta() {
		Campo campoTest = new Campo();
		Carta cartaTestCampo = new CartaCampo();
		campoTest.colocarCarta(cartaTestCampo);
		assertEquals(true, campoTest.obtenerCantidadDeCartasEnZonaCampo());
	}
	
}
