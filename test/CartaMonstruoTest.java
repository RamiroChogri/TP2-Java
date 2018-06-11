import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class CartaMonstruoTest {
	
	@Test
	public void colocarCartaMonstruoEnModoAtaqueEstaEnModoAtaque() {
		Carta cartaMonstruo = new CartaMonstruo();
		cartaMonstruo.colocarEnModoAtaque();
		assertEquals(true, cartaMonstruo.estaEnModoAtaque());
	}
	
	public void colocarCartaMonstruoBocaAbajoEnModoDefensaNoEstaEnModoAtaque() {
		Carta cartaMonstruo = new CartaMonstruo();
		cartaMonstruo.colocarBocaAbajoEnModoDefensa();
		assertEquals(false, cartaMonstruo.estaEnModoAtaque());
	}

	
	
}