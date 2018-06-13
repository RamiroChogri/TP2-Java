import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

import campo.Campo;
import carta.*;


public class EnunciadoTest {
	
	
	//Colocar una carta de monstruo en posición de ataque.
	@Test
	public void test01ColocarCartaMonstruoEnModoAtaque() {
		
		Carta cartaMonstruo = new CartaMonstruo();
		
		cartaMonstruo.colocarEnModoAtaque();
		
		assertTrue( cartaMonstruo.estaColocadaEnModoAtaque() );
	}
	
	@Test
	public void test02ColocarMonstruoEnModoDefensa() {
		
		Carta cartaMonstruo = new CartaMonstruo();
		
		cartaMonstruo.colocarEnModoDefensaBocaAbajo();
		
		assertTrue( cartaMonstruo.estaColocadaEnModoDefensa() );
		
	}
	
	@Test
	public void test03ColocarCartaMagicaEnCampoBocaAbajo() {
		
		Carta cartaMagica = new CartaMagica();
		Campo campo = new Campo();
		cartaMagica.colocarBocaAbajo();
		campo.colocarCarta( cartaMagica );
		
		assertEquals(1, campo.obtenerCantidadDeCartasEnZonaUtilidad() );
	}
	
	@Test
	public void test04ColocarCartaTrampaEnCampoBocaAbajo() {
		
		Carta cartaTrampa = new CartaTrampa();
		Campo campo = new Campo();
		cartaTrampa.colocarBocaAbajo();
		campo.colocarCarta( cartaTrampa );
		
		assertEquals(1, campo.obtenerCantidadDeCartasEnZonaUtilidad() );
		
	}
	
	@Test
	public void test05MandarCartaAlCementerio() {
		
		Carta cartaTrampa = new CartaTrampa();
		Campo campo = new Campo();
		campo.colocarCarta( cartaTrampa );
		
		cartaTrampa.destruir();
		
		campo.enviarCartasDestruidasAlCementerio();
		
		assertEquals( 1, campo.obtenerCantidadDeCartasEnCementerio() );
		
	}
	

	@Test
	public void test06MonstruoAtacaAOtroMonstruoConMenorAtaque() {

	}

	@Test
	public void test07MonstruoAtacaAOtroMonstruoConMayorAtaque() () {
	
	}

}
