import static org.junit.Assert.*;
import org.junit.Test;
import campo.*;
import carta.*;

public class CartaMonstruoTest {
	
	@Test
	public void colocarCartaMonstruoEnModoAtaqueEstaEnModoAtaque() {
		CartaMonstruo cartaMonstruo = new CartaMonstruo(9000, 5);
		cartaMonstruo.colocarEnModoAtaque();
		assertEquals(true, cartaMonstruo.estaColocadaEnModoAtaque());
	}
	
	@Test
	public void colocarCartaMonstruoBocaAbajoEnModoDefensaNoEstaEnModoAtaque() {
		CartaMonstruo cartaMonstruo = new CartaMonstruo(9000, 5);
		cartaMonstruo.colocarBocaAbajoEnModoDefensa();
		assertFalse(cartaMonstruo.estaColocadaEnModoAtaque());
	}
	
	@Test
	public void monstruoAtacaAOtroEnModoAtaqueConMenosAtaqueYLoDestruye() {
		CartaMonstruo cartaMonstruo1 = new CartaMonstruo(1000, 800);
		CartaMonstruo cartaMonstruo2 = new CartaMonstruo(500, 400);
		cartaMonstruo1.colocarEnModoAtaque();
		cartaMonstruo2.colocarEnModoAtaque();
		cartaMonstruo1.atacar(cartaMonstruo2);
		
		assertTrue(cartaMonstruo2.estaDestruida());
	}
	
	@Test
	public void monstruoAtacaAOtroEnModoAtaqueConMenosAtaqueYNoSeDestruyeLaCartaQueAtaca() {
		CartaMonstruo cartaMonstruo1 = new CartaMonstruo(1000, 800);
		CartaMonstruo cartaMonstruo2 = new CartaMonstruo(500, 400);
		cartaMonstruo1.colocarEnModoAtaque();
		cartaMonstruo2.colocarEnModoAtaque();
		cartaMonstruo1.atacar(cartaMonstruo2);
		
		assertFalse(cartaMonstruo1.estaDestruida());
	
	}
	
	@Test
	public void monstruoAtacaAOtroMonstruoBocaArribaEnModoDefensaConMenosDefensaYLoDestruye() {
		CartaMonstruo cartaMonstruo1 = new CartaMonstruo(1000, 800);
		CartaMonstruo cartaMonstruo2 = new CartaMonstruo(500, 400);
		cartaMonstruo1.colocarEnModoAtaque();
		cartaMonstruo2.colocarBocaArribaEnModoDefensa();
		cartaMonstruo1.atacar(cartaMonstruo2);
		
		assertTrue(cartaMonstruo2.estaDestruida());		
	}
	
	@Test
	public void monstruoAtacaAOtroMonstruoBocaArribaEnModoDefensaConMasDefensaYNoLoDestruye() {
		CartaMonstruo cartaMonstruo1 = new CartaMonstruo(1000, 800);
		CartaMonstruo cartaMonstruo2 = new CartaMonstruo(500, 1200);
		cartaMonstruo1.colocarEnModoAtaque();
		cartaMonstruo2.colocarBocaArribaEnModoDefensa();
		cartaMonstruo1.atacar(cartaMonstruo2);
		
		assertFalse(cartaMonstruo2.estaDestruida());				
	}
	
	@Test
	public void monstruoAtacaAOtroMonstruoBocaArribaEnModoDefensaConMasDefensaYNoSeDestruyeLaQueAtaco() {
		CartaMonstruo cartaMonstruo1 = new CartaMonstruo(1000, 800);
		CartaMonstruo cartaMonstruo2 = new CartaMonstruo(500, 1200);
		cartaMonstruo1.colocarEnModoAtaque();
		cartaMonstruo2.colocarBocaArribaEnModoDefensa();
		cartaMonstruo1.atacar(cartaMonstruo2);
		
		assertFalse(cartaMonstruo1.estaDestruida());					
	}
	
	
	@Test
	public void monstruoAtacaAOtroMonstruoBocaAbajoEnModoDefensaConMenosDefensaYLoDestruye() {
		CartaMonstruo cartaMonstruo1 = new CartaMonstruo(1000, 800);
		CartaMonstruo cartaMonstruo2 = new CartaMonstruo(500, 400);
		cartaMonstruo1.colocarEnModoAtaque();
		cartaMonstruo2.colocarBocaAbajoEnModoDefensa();
		cartaMonstruo1.atacar(cartaMonstruo2);
		
		assertTrue(cartaMonstruo2.estaDestruida());		
	}
	
	@Test
	public void monstruoAtacaAOtroMonstruoBocaAbajoEnModoDefensaConMasDefensaYNoLoDestruye() {
		CartaMonstruo cartaMonstruo1 = new CartaMonstruo(1000, 800);
		CartaMonstruo cartaMonstruo2 = new CartaMonstruo(500, 1200);
		cartaMonstruo1.colocarEnModoAtaque();
		cartaMonstruo2.colocarBocaAbajoEnModoDefensa();
		cartaMonstruo1.atacar(cartaMonstruo2);
		
		assertFalse(cartaMonstruo2.estaDestruida());				
	}
	
	@Test
	public void monstruoAtacaAOtroMonstruoBocaAbajoEnModoDefensaConMasDefensaYSeDestruyeLaQueAtaco() {
		CartaMonstruo cartaMonstruo1 = new CartaMonstruo(1000, 800);
		CartaMonstruo cartaMonstruo2 = new CartaMonstruo(500, 1200);
		cartaMonstruo1.colocarEnModoAtaque();
		cartaMonstruo2.colocarBocaAbajoEnModoDefensa();
		cartaMonstruo1.atacar(cartaMonstruo2);
		
		assertFalse(cartaMonstruo1.estaDestruida());					
	}
	
	@Test
	public void monstruoAtacaAOtroMonstruoBocaAbajoEnModoDefensaConMasDefensaYLoDaVuelta() {
		CartaMonstruo cartaMonstruo1 = new CartaMonstruo(1000, 800);
		CartaMonstruo cartaMonstruo2 = new CartaMonstruo(500, 1200);
		cartaMonstruo1.colocarEnModoAtaque();
		cartaMonstruo2.colocarBocaAbajoEnModoDefensa();
		cartaMonstruo1.atacar(cartaMonstruo2);
		
		assertTrue(cartaMonstruo2.estaColocadaBocaArribaEnModoDefensa());					
	}
	
}