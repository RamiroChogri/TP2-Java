import static org.junit.Assert.*;
import org.junit.Test;
import campo.*;
import cartas.*;
import estadoCarta.EstadoCarta;
import estadoCarta.EstadoCartaColocadaBocaAbajo;
import estadoCarta.EstadoCartaColocadaBocaArriba;
import factories.CartaMonstruoFactory;
import factories.CartaTrampaFactory;
import jugador.Jugador;
import modos.Modo;
import modos.ModoAtaque;
import modos.ModoDefensa;

public class CartaTrampaTest {

	@Test
	public void testCilindroDaniaDirectamenteAlOponenteAlSerAtacada() {
		
		CartaMonstruoFactory fabrica = new CartaMonstruoFactory();
		CartaTrampaFactory fabricaTrampas = new CartaTrampaFactory();
		
		Activable cilindroMagico = fabricaTrampas.crearCilindroMagico();
		
		Atacable monstruo1 = fabrica.crearBueyDeBatalla();
 		Atacable monstruo2 = fabrica.crearConejoOscuro();
 		
 		Jugador jugador1 = new Jugador();
		Jugador jugador2 = new Jugador();
		
		jugador1.enfrentarseA(jugador2);
		jugador2.enfrentarseA(jugador1);
		
		Modo modoAtaque = new ModoAtaque();
		EstadoCarta bocaArriba = new EstadoCartaColocadaBocaArriba();
		EstadoCarta bocaAbajo = new EstadoCartaColocadaBocaAbajo();
		
		jugador1.colocar(monstruo1, bocaArriba, modoAtaque);
		jugador2.colocar(monstruo2, bocaArriba, modoAtaque);
		jugador2.colocar(cilindroMagico, bocaAbajo);
		
		jugador1.atacar(monstruo1, monstruo2);
		
							/*8000 - 1700 = 6300*/
		int vidaEsperada = 8000 - monstruo1.obtenerPuntosAtaque().obtenerPuntosActuales();
		
		assertEquals(vidaEsperada, jugador1.obtenerVidaRestante());
	}
	
	@Test
	public void testCilindroNoSeDestruyeAlUsarse() {
		
		CartaMonstruoFactory fabrica = new CartaMonstruoFactory();
		CartaTrampaFactory fabricaTrampas = new CartaTrampaFactory();
		
		Activable cilindroMagico = fabricaTrampas.crearCilindroMagico();
		
		Atacable monstruo1 = fabrica.crearBueyDeBatalla();
 		Atacable monstruo2 = fabrica.crearConejoOscuro();
 		
 		Jugador jugador1 = new Jugador();
		Jugador jugador2 = new Jugador();
		
		jugador1.enfrentarseA(jugador2);
		jugador2.enfrentarseA(jugador1);
		
		Modo modoAtaque = new ModoAtaque();
		EstadoCarta bocaArriba = new EstadoCartaColocadaBocaArriba();
		EstadoCarta bocaAbajo = new EstadoCartaColocadaBocaAbajo();
		
		jugador1.colocar(monstruo1, bocaArriba, modoAtaque);
		jugador2.colocar(monstruo2, bocaArriba, modoAtaque);
		jugador2.colocar(cilindroMagico, bocaAbajo);
		
		jugador1.atacar(monstruo1, monstruo2);
		
							/*8000 - 1700 = 6300*/
		int vidaEsperada = 8000 - monstruo1.obtenerPuntosAtaque().obtenerPuntosActuales();
		
		assertTrue(cilindroMagico.estaDestruida());
		
	}
	
		
	@Test
	public void testUnMonstruoEsAtacadoYSeActivaReinforcementsElAtacanteEsDestruido() {
		
		
		CartaMonstruoFactory fabrica = new CartaMonstruoFactory();
		CartaTrampaFactory fabricaTrampas = new CartaTrampaFactory();
		
		Activable refuerzos = fabricaTrampas.crearRefuerzos();
		
		Atacable monstruo1 = fabrica.crearDragonDeKoumori();
 		Atacable monstruo2 = fabrica.crearJineteVorse();
 		
 		Jugador jugador1 = new Jugador();
		Jugador jugador2 = new Jugador();
		
		jugador1.enfrentarseA(jugador2);
		jugador2.enfrentarseA(jugador1);
		
		Modo modoAtaque = new ModoAtaque();
		EstadoCarta bocaArriba = new EstadoCartaColocadaBocaArriba();
		EstadoCarta bocaAbajo = new EstadoCartaColocadaBocaAbajo();
		
		jugador1.colocar(monstruo1, bocaArriba, modoAtaque);
		jugador1.colocar(refuerzos, bocaAbajo);
		
		jugador2.colocar(monstruo2, bocaArriba, modoAtaque);
		jugador2.atacar(monstruo2, monstruo1);
		
		assertTrue(monstruo2.estaDestruida());
		
	}
	
	@Test
	public void testUnMonstruoEsAtacadoYSeActivaReinforcementsElJugadorEsDaniado() {
		
		
		CartaMonstruoFactory fabrica = new CartaMonstruoFactory();
		CartaTrampaFactory fabricaTrampas = new CartaTrampaFactory();
		
		Activable refuerzos = fabricaTrampas.crearRefuerzos();
		
		Atacable monstruo1 = fabrica.crearDragonDeKoumori();
 		Atacable monstruo2 = fabrica.crearJineteVorse();
 		
 		Jugador jugador1 = new Jugador();
		Jugador jugador2 = new Jugador();
		
		jugador1.enfrentarseA(jugador2);
		jugador2.enfrentarseA(jugador1);
		
		Modo modoAtaque = new ModoAtaque();
		EstadoCarta bocaArriba = new EstadoCartaColocadaBocaArriba();
		EstadoCarta bocaAbajo = new EstadoCartaColocadaBocaAbajo();
		
		jugador1.colocar(monstruo1, bocaArriba, modoAtaque);
		jugador1.colocar(refuerzos, bocaAbajo);
		
		jugador2.colocar(monstruo2, bocaArriba, modoAtaque);
		jugador2.atacar(monstruo2, monstruo1);
		
							/*8000 - 100 = 7900*/
		int vidaEsperada = 7900;
		
		assertEquals(vidaEsperada, jugador2.obtenerVidaRestante());
	}
	
}
