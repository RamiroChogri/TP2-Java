import static org.junit.Assert.assertEquals;
import org.junit.Test;

public CampoTest {
	
	//La carta tiene 5 estados: En mazo, en mano, en campo ataque,
	//en campo defensa y cementerio (muerta).
	
	@Test
	public void testColocarMonstruoEnCampoEnAtaque() {
		
		//Por defecto el estado inicial es "En mazo"
		Carta carta = new CartaMonstruo();
		carta.colocarEnPosicionAtaque();
		
		assertEquals(true, carta.estaColocadaEnModoAtaque());
	}
	
}