import static org.junit.Assert.*;
import org.junit.Test;
import cartas.*;
import efectos.*;
import estadoCarta.EstadoCarta;
import estadoCarta.EstadoCartaColocadaBocaArriba;
import factories.CartaMonstruoFactory;
import jugador.Jugador;
import modos.Modo;
import modos.ModoAtaque;
import modos.ModoDefensa;

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
		cartaMagica.colocarBocaArriba();
		assertFalse(cartaMagica.estaColocadaBocaAbajo());
		
	}
	
	@Test
	public void testColocarCartaMagicaBocaArribaEstaBocaArriba() {
		CartaMagica cartaMagica = new CartaMagica();
		cartaMagica.colocarBocaArriba();
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
		cartaMagica.colocarBocaArriba();
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
	
	@Test
	public void testMonstruosDelCampoSeDestruyenAlColocarAgujeroNegro() {
		Puntos ataqueMonstruo1 = new Puntos(2000);
		Puntos defensaMonstruo1 = new Puntos(3000);
		Puntos ataqueMonstruo2 = new Puntos(1000);
		Puntos defensaMonstruo2 = new Puntos(2500);
		int estrellas = 3;
		Atacable unMonstuo = new CartaMonstruo(ataqueMonstruo1, defensaMonstruo1, estrellas);
 		Atacable otroMonstruo = new CartaMonstruo(ataqueMonstruo2, defensaMonstruo2, estrellas);
		Jugador jugador1 = new Jugador();
		Jugador jugador2 = new Jugador();
		
		Efecto agujeroNegroEfecto = new EfectoAgujeroNegro();
 		Activable agujeroNegro = new CartaMagica( agujeroNegroEfecto );
 		
		jugador1.enfrentarseA(jugador2);
		jugador2.enfrentarseA(jugador1);
		
		Modo modoAtaque = new ModoAtaque();
		Modo modoDefensa = new ModoDefensa();
		EstadoCarta bocaArriba = new EstadoCartaColocadaBocaArriba();
		jugador1.colocar(unMonstuo, bocaArriba, modoAtaque);
 		jugador2.colocar(otroMonstruo, bocaArriba, modoDefensa);
 		jugador1.colocar(agujeroNegro, bocaArriba);
 		
 		assertFalse( jugador1.tieneCartasEnCampo() || jugador2.tieneCartasEnCampo() );
	}
	
	@Test
	public void testActivarPotOfGreedPermiteLevantarDosCartasDelMazo() {

		Efecto efectoPotOfGreed = new EfectoPotOfGreed();//sogen aumenta los ptsdef de tus monstruos en 500
		Activable potOfGreed = new CartaMagica(efectoPotOfGreed);  // tambien los ptsatk de los monstruos enemigos en 200
		EstadoCarta bocaArriba = new EstadoCartaColocadaBocaArriba();
		
		Jugador jugador1 = new Jugador();
		Jugador jugador2 = new Jugador();
		
		jugador1.enfrentarseA(jugador2);
		jugador2.enfrentarseA(jugador1);
		
		jugador1.colocar(potOfGreed, bocaArriba);
		int cartasEnManoEperadas = 7;
		assertEquals(cartasEnManoEperadas, jugador1.obtenerCantidadDeCartasEnLaMano());
	}
	
	@Test
	public void testColocarFisuraBocaArribaConUnMonstruoEnAmbosCamposDestruyeAlDeMenorAtaque() {
		CartaMonstruoFactory fabrica = new CartaMonstruoFactory();
		
		Atacable monstruoCon1000DeAtaque = fabrica.crearHeroeElementalAvian();
		Atacable monstruoCon1700DeAtaque = fabrica.crearBueyDeBatalla();
 		Atacable monstruoCon1100DeAtaque = fabrica.crearConejoOscuro();
 		Efecto efectoFisura = new EfectoFisura();
 		Activable fisura = new CartaMagica(efectoFisura);
 				
		Jugador jugador1 = new Jugador();
		Jugador jugador2 = new Jugador();
		
		jugador1.enfrentarseA(jugador2);
		jugador2.enfrentarseA(jugador1);
		
		Modo modoAtaque = new ModoAtaque();
		EstadoCarta bocaArriba = new EstadoCartaColocadaBocaArriba();
		jugador2.colocar(monstruoCon1700DeAtaque, bocaArriba, modoAtaque);
		jugador2.colocar(monstruoCon1000DeAtaque, bocaArriba, modoAtaque);
		jugador2.colocar(monstruoCon1100DeAtaque, bocaArriba, modoAtaque);
		
		jugador1.colocar(fisura, bocaArriba);
		
		//Hay que hacer otro caso como para verificar que efecto de fisura no es destruir
		//la segunda carta colocada (que no esta hardcodeado)
		
		assertTrue(monstruoCon1000DeAtaque.estaDestruida());
	}
	
	@Test
	public void testColocarFisuraBocaArribaConUnMonstruoEnAmbosCamposNoDestruyeAMonstruosDeMasAtaque() {
		CartaMonstruoFactory fabrica = new CartaMonstruoFactory();
		
		Atacable monstruoCon1000DeAtaque = fabrica.crearHeroeElementalAvian();
		Atacable monstruoCon1700DeAtaque = fabrica.crearBueyDeBatalla();
 		Atacable monstruoCon1100DeAtaque = fabrica.crearConejoOscuro();
 		Efecto efectoFisura = new EfectoFisura();
 		Activable fisura = new CartaMagica(efectoFisura);
 				
		Jugador jugador1 = new Jugador();
		Jugador jugador2 = new Jugador();
		
		jugador1.enfrentarseA(jugador2);
		jugador2.enfrentarseA(jugador1);
		
		Modo modoAtaque = new ModoAtaque();
		EstadoCarta bocaArriba = new EstadoCartaColocadaBocaArriba();
		jugador2.colocar(monstruoCon1700DeAtaque, bocaArriba, modoAtaque);
		jugador2.colocar(monstruoCon1000DeAtaque, bocaArriba, modoAtaque);
		jugador2.colocar(monstruoCon1100DeAtaque, bocaArriba, modoAtaque);
		
		jugador1.colocar(fisura, bocaArriba);
		
		//Hay que hacer otro caso como para verificar que efecto de fisura no es destruir
		//la segunda carta colocada (que no esta hardcodeado)
		
		assertFalse(monstruoCon1700DeAtaque.estaDestruida() || monstruoCon1100DeAtaque.estaDestruida());
		
	}
	
}	
