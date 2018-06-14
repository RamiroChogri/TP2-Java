import static org.junit.Assert.*;
import org.junit.Test;
import campo.*;
import carta.*;
import efectos.*;

public class CartaMagicaTest {
	
	@Test
	public void testColocarCartaMagicaBocaAbajoEstaBocaAbajo() {
		CartaMagica cartaMagica = new CartaMagica();
		cartaMagica.colocarBocaAbajo();
		
		assertTrue(cartaMagica.estaColocadaBocaAbajo());
	}
	
	@Test
	public void testColocarCartaMagicaBocaArribaNoEstaBocaAbajo() {
		CartaMagica cartaMagica = new CartaMagica();
		Efecto efectoRecibidoAlDarVueltaLaCarta;
		efectoRecibidoAlDarVueltaLaCarta = cartaMagica.colocarBocaArriba();
		
		assertFalse(cartaMagica.estaColocadaBocaAbajo());
		
	}
	
	@Test
	public void testColocarCartaMagicaBocaArribaEstaBocaArriba() {
		CartaMagica cartaMagica = new CartaMagica();
		Efecto efectoRecibidoAlDarVueltaLaCarta;
		efectoRecibidoAlDarVueltaLaCarta = cartaMagica.colocarBocaArriba();
		
		assertTrue(cartaMagica.estaColocadaBocaArriba());
	}	
	
	@Test
	public void testColocarCartaMagicaBocaAbajoNoEstaBocaArriba() {
		CartaMagica cartaMagica = new CartaMagica();
		cartaMagica.colocarBocaAbajo();
		
		assertFalse(cartaMagica.estaColocadaBocaArriba());	
	}
	
	@Test
	public void testDestruirCartaMagicaLaDestruye() {
		CartaMagica cartaMagica = new CartaMagica();
		cartaMagica.destruirCarta();
		
		assertTrue(cartaMagica.estaDestruida());	
	}
	
	@Test
	public void testDestruirCartaMagicaNoEstaBocaArriba() {
		CartaMagica cartaMagica = new CartaMagica();
		cartaMagica.destruirCarta();
		
		assertFalse(cartaMagica.estaColocadaBocaArriba());			
	}
	
	@Test
	public void testDestruirCartaMagicaNoEstaBocaAbajo() {
		CartaMagica cartaMagica = new CartaMagica();
		cartaMagica.destruirCarta();
		
		assertFalse(cartaMagica.estaColocadaBocaAbajo());				
	}
	
}	
