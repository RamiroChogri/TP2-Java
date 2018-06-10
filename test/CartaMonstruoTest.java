import static org.junit.Assert.assertEquals;
import org.junit.Test;

public CampoTest {
	
	//La carta tiene 6 estados: En mazo, en mano, en campo ataque,
	//en campo defensa boca arriba, en campo defensa boca abajo y en cementerio (muerta).
	
	@Test
	public void testColocarMonstruoEnCampoEnAtaque() {
		
		//Por defecto el estado inicial es "En mazo"
		Carta carta = new CartaMonstruo();
		carta.colocarEnPosicionAtaque();
		
		assertEquals(true, carta.estaColocadaEnModoAtaque());
	}
	
	@Test
	public void testColocarMonstruoEnCampoEnDefensaNoEstaEnAtaque() {
		
		Carta carta = new CartaMonstruo();
		carta.colocarEnPosicionDefensaBocaArriba();
		assertEquals(false, carta.estaColocadaEnModoAtaque());
	}
	
}