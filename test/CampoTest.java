import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class CampoTest {
	
	//La carta tiene 6 estados: En mazo, en mano, en campo ataque,
	//en campo defensa boca arriba, en campo defensa boca abajo y en cementerio (muerta).
	
	@Test
	public void testColocarMonstruoEnCampoEnAtaque() {
		
		//Por defecto el estado inicial es "En mazo"
		Carta carta = new CartaMonstruo();
		carta.colocarEnModoAtaque();
		
		assertEquals(true, carta.estaColocadaEnModoAtaque());
	}
	
	@Test
	public void testColocarMonstruoEnCampoEnDefensaNoEstaEnAtaque() {
		
		Carta carta = new CartaMonstruo();
		carta.colocarEnModoDefensaBocaArriba();
		assertEquals(false, carta.estaColocadaEnModoAtaque());
	}
	
	@Test
	public void testColocarMonstruoEnCampoEnAtaqueNoEstaEnDefensa() {
		Carta carta = new CartaMonstruo();
		carta.colocarEnModoAtaque();
		assertEquals(false, carta.estaColocadaEnModoDefensa());
	}
}
