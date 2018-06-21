import static org.junit.Assert.*;
import org.junit.Test;
import campo.*;
import cartas.*;
import efectos.Efecto;
import efectos.EfectoSogen;
import efectos.EfectoWasteland;
import estadoCarta.EstadoCarta;
import estadoCarta.EstadoCartaColocadaBocaAbajo;
import estadoCarta.EstadoCartaColocadaBocaArriba;
import factories.CartaMonstruoFactory;
import jugador.Jugador;
import modos.Modo;
import modos.ModoAtaque;
import modos.ModoDefensa;

public class CartaCampoTest {

	@Test
	public void testColocarWastelandBocaArribaConUnMonstruoEnAmbosCampos() {
		Puntos ataqueMonstruo1 = new Puntos(1500); //1700 con wasteland
		Puntos defensaMonstruo1 = new Puntos(3000);
		Puntos ataqueMonstruo2 = new Puntos(1000);
		Puntos defensaMonstruo2 = new Puntos(1000); //1300 con wasteland
		int estrellasDeUnMonstruo = 3;
		Atacable unMonstruo = new CartaMonstruo(ataqueMonstruo1, defensaMonstruo1, estrellasDeUnMonstruo);
		Atacable otroMonstruo = new CartaMonstruo(ataqueMonstruo2, defensaMonstruo2, estrellasDeUnMonstruo);

		Efecto efectoWasteland = new EfectoWasteland();//wasteland aumenta los ptsatk de tus monstruos en 200
		Activable wasteland = new CartaCampo(efectoWasteland); // tambien los ptsdef de los monstruos enemigos en 300
		
		Jugador jugador1 = new Jugador();
		Jugador jugador2 = new Jugador();
		
		jugador1.enfrentarseA(jugador2);
		jugador2.enfrentarseA(jugador1);
		
		Modo modoAtaque = new ModoAtaque();
		EstadoCarta bocaArriba = new EstadoCartaColocadaBocaArriba();
		
		jugador1.colocar(unMonstruo, bocaArriba, modoAtaque);
		jugador2.colocar(otroMonstruo, bocaArriba, modoAtaque);
		jugador1.colocar(wasteland, bocaArriba);
		
		jugador1.atacar(unMonstruo, otroMonstruo);
		
		int vidaEsperada = 7300;
		assertEquals(vidaEsperada, jugador2.obtenerVidaRestante());
	}
	
	@Test
	public void testColocarSogenBocaArribaConUnMonstruoEnAmbosCampos() {
		Puntos ataqueMonstruo1 = new Puntos(1500);
		Puntos defensaMonstruo1 = new Puntos(1000); //1500 con sogen
		Puntos ataqueMonstruo2 = new Puntos(1000); //1200 con sogen
		Puntos defensaMonstruo2 = new Puntos(1000);
		int estrellasDeUnMonstruo = 3;
		Atacable unMonstruo = new CartaMonstruo(ataqueMonstruo1, defensaMonstruo1, estrellasDeUnMonstruo);
		Atacable otroMonstruo = new CartaMonstruo(ataqueMonstruo2, defensaMonstruo2, estrellasDeUnMonstruo);

		Efecto efectoSogen = new EfectoSogen();//sogen aumenta los ptsdef de tus monstruos en 500
		Activable sogen = new CartaCampo(efectoSogen);  // tambien los ptsatk de los monstruos enemigos en 200
		
		Jugador jugador1 = new Jugador();
		Jugador jugador2 = new Jugador();
		
		jugador1.enfrentarseA(jugador2);
		jugador2.enfrentarseA(jugador1);
		
		Modo modoAtaque = new ModoAtaque();
		EstadoCarta bocaArriba = new EstadoCartaColocadaBocaArriba();
		
		jugador1.colocar(unMonstruo, bocaArriba, modoAtaque);
		jugador2.colocar(otroMonstruo, bocaArriba, modoAtaque);
		jugador1.colocar(sogen, bocaArriba);
		
		jugador1.atacar(unMonstruo, otroMonstruo);
		
		int vidaEsperada = 7700;
		assertEquals(vidaEsperada, jugador2.obtenerVidaRestante());
	}
	
}
