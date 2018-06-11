import static org.junit.Assert.*;
import org.junit.Test;

import carta.*;

public class CartaMonstruoTest {
	
	@Test
	public void colocarCartaMonstruoEnModoAtaqueEstaEnModoAtaque() {
		Carta cartaMonstruo = new CartaMonstruo();
		ZonaMonstruo zona = new ZonaMonstruo();
		zona.colocar(cartaMonstruo);
		
		cartaMonstruo.colocarEnModoAtaque();
		assertEquals(true, cartaMonstruo.estaEnModoAtaque());
	}
	
	@Test
	public void colocarCartaMonstruoBocaAbajoEnModoDefensaNoEstaEnModoAtaque() {
		Carta cartaMonstruo = new CartaMonstruo();
		cartaMonstruo.colocarBocaAbajoEnModoDefensa();
		assertFalse(cartaMonstruo.estaEnModoAtaque());
	}
	

	
	
}