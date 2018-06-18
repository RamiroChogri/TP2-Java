import static org.junit.Assert.*;
import org.junit.Test;
import campo.*;
import cartas.*;
import modos.*;
import estrategias.*;

public class CartaMonstruoTest {
	
//	@Test
//	public void testColocarCartaMonstruoEnModoAtaqueEstaEnModoAtaque() {
//		CartaMonstruo cartaMonstruo = new CartaMonstruo(9000, 5);
//		cartaMonstruo.colocarEnModoAtaque();
//		assertEquals(true, cartaMonstruo.estaColocadaEnModoAtaque());
//	}
//	
//	@Test
//	public void testColocarCartaMonstruoBocaAbajoEnModoDefensaNoEstaEnModoAtaque() {
//		CartaMonstruo cartaMonstruo = new CartaMonstruo(9000, 5);
//		cartaMonstruo.colocarBocaAbajoEnModoDefensa();
//		assertFalse(cartaMonstruo.estaColocadaEnModoAtaque());
//	}
//	
//	@Test
//	public void testMonstruoAtacaAOtroEnModoAtaqueConMenosAtaqueYLoDestruye() {
//		CartaMonstruo cartaMonstruo1 = new CartaMonstruo(1000, 800);
//		CartaMonstruo cartaMonstruo2 = new CartaMonstruo(500, 400);
//		cartaMonstruo1.colocarEnModoAtaque();
//		cartaMonstruo2.colocarEnModoAtaque();
//		cartaMonstruo1.atacar(cartaMonstruo2);
//		
//		assertTrue(cartaMonstruo2.estaDestruida());
//	}
//	
//	@Test
//	public void testMonstruoAtacaAOtroEnModoAtaqueConMenosAtaqueYNoSeDestruyeLaCartaQueAtaca() {
//		CartaMonstruo cartaMonstruo1 = new CartaMonstruo(1000, 800);
//		CartaMonstruo cartaMonstruo2 = new CartaMonstruo(500, 400);
//		cartaMonstruo1.colocarEnModoAtaque();
//		cartaMonstruo2.colocarEnModoAtaque();
//		cartaMonstruo1.atacar(cartaMonstruo2);
//		
//		assertFalse(cartaMonstruo1.estaDestruida());
//	
//	}
//	
//	@Test
//	public void testMonstruoAtacaAOtroMonstruoBocaArribaEnModoDefensaConMenosDefensaYLoDestruye() {
//		CartaMonstruo cartaMonstruo1 = new CartaMonstruo(1000, 800);
//		CartaMonstruo cartaMonstruo2 = new CartaMonstruo(500, 400);
//		cartaMonstruo1.colocarEnModoAtaque();
//		cartaMonstruo2.colocarBocaArribaEnModoDefensa();
//		cartaMonstruo1.atacar(cartaMonstruo2);
//		
//		assertTrue(cartaMonstruo2.estaDestruida());		
//	}
//	
//	@Test
//	public void testMonstruoAtacaAOtroMonstruoBocaArribaEnModoDefensaConMasDefensaYNoLoDestruye() {
//		CartaMonstruo cartaMonstruo1 = new CartaMonstruo(1000, 800);
//		CartaMonstruo cartaMonstruo2 = new CartaMonstruo(500, 1200);
//		cartaMonstruo1.colocarEnModoAtaque();
//		cartaMonstruo2.colocarBocaArribaEnModoDefensa();
//		cartaMonstruo1.atacar(cartaMonstruo2);
//		
//		assertFalse(cartaMonstruo2.estaDestruida());				
//	}
//	
//	@Test
//	public void testMonstruoAtacaAOtroMonstruoBocaArribaEnModoDefensaConMasDefensaYNoSeDestruyeLaQueAtaco() {
//		CartaMonstruo cartaMonstruo1 = new CartaMonstruo(1000, 800);
//		CartaMonstruo cartaMonstruo2 = new CartaMonstruo(500, 1200);
//		cartaMonstruo1.colocarEnModoAtaque();
//		cartaMonstruo2.colocarBocaArribaEnModoDefensa();
//		cartaMonstruo1.atacar(cartaMonstruo2);
//		
//		assertFalse(cartaMonstruo1.estaDestruida());					
//	}
//	
//	
//	@Test
//	public void testMonstruoAtacaAOtroMonstruoBocaAbajoEnModoDefensaConMenosDefensaYLoDestruye() {
//		CartaMonstruo cartaMonstruo1 = new CartaMonstruo(1000, 800);
//		CartaMonstruo cartaMonstruo2 = new CartaMonstruo(500, 400);
//		cartaMonstruo1.colocarEnModoAtaque();
//		cartaMonstruo2.colocarBocaAbajoEnModoDefensa();
//		cartaMonstruo1.atacar(cartaMonstruo2);
//		
//		assertTrue(cartaMonstruo2.estaDestruida());		
//	}
//	
//	@Test
//	public void testMonstruoAtacaAOtroMonstruoBocaAbajoEnModoDefensaConMasDefensaYNoLoDestruye() {
//		CartaMonstruo cartaMonstruo1 = new CartaMonstruo(1000, 800);
//		CartaMonstruo cartaMonstruo2 = new CartaMonstruo(500, 1200);
//		cartaMonstruo1.colocarEnModoAtaque();
//		cartaMonstruo2.colocarBocaAbajoEnModoDefensa();
//		cartaMonstruo1.atacar(cartaMonstruo2);
//		
//		assertFalse(cartaMonstruo2.estaDestruida());				
//	}
//	
//	@Test
//	public void testMonstruoAtacaAOtroMonstruoBocaAbajoEnModoDefensaConMasDefensaYSeDestruyeLaQueAtaco() {
//		CartaMonstruo cartaMonstruo1 = new CartaMonstruo(1000, 800);
//		CartaMonstruo cartaMonstruo2 = new CartaMonstruo(500, 1200);
//		cartaMonstruo1.colocarEnModoAtaque();
//		cartaMonstruo2.colocarBocaAbajoEnModoDefensa();
//		cartaMonstruo1.atacar(cartaMonstruo2);
//		
//		assertFalse(cartaMonstruo1.estaDestruida());					
//	}
//	
//	@Test
//	public void testMonstruoAtacaAOtroMonstruoBocaAbajoEnModoDefensaConMasDefensaYLoDaVuelta() {
//		CartaMonstruo cartaMonstruo1 = new CartaMonstruo(1000, 800);
//		CartaMonstruo cartaMonstruo2 = new CartaMonstruo(500, 1200);
//		cartaMonstruo1.colocarEnModoAtaque();
//		cartaMonstruo2.colocarBocaAbajoEnModoDefensa();
//		cartaMonstruo1.atacar(cartaMonstruo2);
//		
//		assertTrue(cartaMonstruo2.estaColocadaBocaArribaEnModoDefensa());					
//	}
//	
//	@Test
//	public void testMonstruoAtacaAOtroMonstruoEnModoAtaqueConMismoAtaqueYLoDestruye() {
//		CartaMonstruo cartaMonstruo1 = new CartaMonstruo(1000, 800);
//		CartaMonstruo cartaMonstruo2 = new CartaMonstruo(1000, 400);
//		cartaMonstruo1.colocarEnModoAtaque();
//		cartaMonstruo2.colocarEnModoAtaque();
//		cartaMonstruo1.atacar(cartaMonstruo2);
//		
//		assertTrue(cartaMonstruo2.estaDestruida());
//	}
//	
//	@Test
//	public void testMonstruoAtacaAOtroMonstruoEnModoAtaqueConMismoAtaqueYSeDestruye() {
//		CartaMonstruo cartaMonstruo1 = new CartaMonstruo(1000, 800);
//		CartaMonstruo cartaMonstruo2 = new CartaMonstruo(1000, 400);
//		cartaMonstruo1.colocarEnModoAtaque();
//		cartaMonstruo2.colocarEnModoAtaque();
//		cartaMonstruo1.atacar(cartaMonstruo2);
//		
//		assertTrue(cartaMonstruo1.estaDestruida());
//	}
//	
//	@Test
//	public void testMonstruoAtacaAOtroMonstruoEnModoDefensaConMismoAtaqueQueDefensaYNoSeDestruye() {
//		CartaMonstruo cartaMonstruo1 = new CartaMonstruo(2000, 1000);
//		CartaMonstruo cartaMonstruo2 = new CartaMonstruo(0, 2000);
//		cartaMonstruo1.colocarEnModoAtaque();
//		cartaMonstruo2.colocarBocaAbajoEnModoDefensa();
//		cartaMonstruo1.atacar(cartaMonstruo2);
//		
//		assertFalse(cartaMonstruo1.estaDestruida());
//	}
//	@Test
//	public void testMonstruoAtacaAOtroMonstruoEnModoAtaqueLaDestruyeYDejaElDanioCorrespondiente() {
//		CartaMonstruo cartaMonstruo1 = new CartaMonstruo(2000, 1000);
//		CartaMonstruo cartaMonstruo2 = new CartaMonstruo(100, 2000);
//		cartaMonstruo1.colocarEnModoAtaque();
//		cartaMonstruo2.colocarEnModoAtaque();
//		cartaMonstruo1.atacar(cartaMonstruo2);
//		
//		assertEquals(2000 - 100 ,cartaMonstruo2.obtenerDanioAlHaberSidoDestruida());
//	}
//	

	@Test
	public void testMonstruoAtacaAOtroMonstruoEnModoAtaqueYLoDestruye() {
		Puntos puntosDeAtaqueCarta1 = new Puntos(2000);
		Puntos puntosDeDefensaCarta1 = new Puntos(1000);
		Puntos puntosDeAtaqueCarta2 = new Puntos (1000);
		Puntos puntosDeDefensaCarta2 = new Puntos (500);
		Atacable monstruo1 = new CartaMonstruo(puntosDeAtaqueCarta1, puntosDeDefensaCarta1);
		Atacable monstruo2 = new CartaMonstruo(puntosDeAtaqueCarta2, puntosDeDefensaCarta2);
		
		Modo modoAtaque = new ModoAtaque();
		Estrategia bocaArriba = new EstrategiaBocaArriba();
		
		monstruo1.colocar(bocaArriba, modoAtaque);
		monstruo2.colocar(bocaArriba, modoAtaque);
		
		monstruo1.atacar(monstruo2);
		
		assertTrue(monstruo2.estaDestruida());	
	}
	
	
	@Test
	public void testMonstruoEnModoDefensaNoPuedeAtacar() {
		Puntos puntosDeAtaqueCarta1 = new Puntos(2000);
		Puntos puntosDeDefensaCarta1 = new Puntos(1000);
		Puntos puntosDeAtaqueCarta2 = new Puntos (1000);
		Puntos puntosDeDefensaCarta2 = new Puntos (500);
		boolean huboExcepcion = false;
		Atacable monstruo1 = new CartaMonstruo(puntosDeAtaqueCarta1, puntosDeDefensaCarta1);
		Atacable monstruo2 = new CartaMonstruo(puntosDeAtaqueCarta2, puntosDeDefensaCarta2);
		
		Modo modoAtaque = new ModoAtaque();
		Modo modoDefensa = new ModoDefensa();
		Estrategia bocaArriba = new EstrategiaBocaArriba();
		
		monstruo1.colocar(bocaArriba, modoDefensa);
		monstruo2.colocar(bocaArriba, modoAtaque);
		try {
			monstruo1.atacar(monstruo2);
		} catch (AtacableEnModoDefensaNoPuedeAtacarException error) {
			huboExcepcion = true;
		}
		
		assertTrue(huboExcepcion);
	}
	
}