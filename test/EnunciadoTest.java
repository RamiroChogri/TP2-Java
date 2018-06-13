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
	
	/*Colocar una carta de monstruo en posición de ataque, el oponente coloca otra carta
de monstruo en posición de ataque (con mayor ataque). Atacar al primer monstruo y
verificar que este se destruyó, y sufro daño a los puntos de vida igual a la diferencia
de los puntos de ataque de los monstruos*/
	@Test
	public void test06MonstruoAtacaAOtroMonstruoEnModoAtaqueLoDestruyeYRestaVidaAJugador() {
		Carta cartaMonstruo1 = new CartaMonstruo();
		Carta cartaMonstruo2 = new CartaMonstruo();
		
		cartaMonstruo1.colocarEnModoAtaque();
		cartaMonstruo2.colocarEnModoAtaque();
		Jugador j1 = new Jugador();
		
		j1.recibirDanio( cartaMonstruo2.atacar( cartaMonstruo1 ) );
		
		int vidaEsperada = 8000;
		vidaEsperada -= ( cartaMonstruo2.obtenerPuntosAtaque() - cartaMonstruo1.obtenerPuntosAtaque() );
	
		assertEquals( vidaEsperada, j1.obtenerVidaRestante() );
		assertTrue( cartaMonstruo1.estaDestruida() );
	
	}

	@Test
	public void test06MonstruoAtacaAOtroMonstruoEnModoAtaqueLoDestruyeYRestaVidaAJugadorQueA() {
		Carta cartaMonstruo1 = new CartaMonstruo();
		Carta cartaMonstruo2 = new CartaMonstruo();
		
		cartaMonstruo1.colocarEnModoAtaque();
		cartaMonstruo2.colocarEnModoAtaque();
		
		Jugador j1 = new Jugador();
		
		j1.recibirDanio( cartaMonstruo2.atacar( cartaMonstruo1 ) );
		
		int vidaEsperada = 8000;
		vidaEsperada -= ( cartaMonstruo2.obtenerPuntosAtaque() - cartaMonstruo1.obtenerPuntosAtaque() );
		assertEquals( vidaEsperada, j1.obtenerVidaRestante() );
		assertTrue( cartaMonstruo2.estaDestruida() );
	}

}