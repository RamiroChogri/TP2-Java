import static org.junit.Assert.*;
import org.junit.Test;
import campo.*;
import carta.*;

public class CartaMonstruoTest {
	
	@Test
	public void colocarCartaMonstruoEnModoAtaqueEstaEnModoAtaque() {
		CartaMonstruo cartaMonstruo = new CartaMonstruo();
		ZonaMonstruo zona = new ZonaMonstruo();
		zona.colocarCarta(cartaMonstruo);
		
		cartaMonstruo.colocarEnModoAtaque();
		assertEquals(true, cartaMonstruo.estaColocadaEnModoAtaque());
	}
	
	@Test
	public void colocarCartaMonstruoBocaAbajoEnModoDefensaNoEstaEnModoAtaque() {
		CartaMonstruo cartaMonstruo = new CartaMonstruo();
		cartaMonstruo.colocarBocaAbajoEnModoDefensa();
		assertFalse(cartaMonstruo.estaColocadaEnModoAtaque());
	}
	

	
	
}