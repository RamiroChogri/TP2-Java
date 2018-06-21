package campo;
import efectos.*;
import estadoCarta.EstadoCarta;
import estadoCarta.EstadoCartaColocadaBocaAbajo;
import estadoCarta.EstadoCartaColocadaBocaArriba;
import factories.CartaMonstruoFactory;
import jugador.Jugador;
import modos.Modo;
import modos.ModoAtaque;
import modos.ModoDefensa;

import static org.junit.Assert.*;
import org.junit.Test;

import cartas.*;

public class CampoTest {
	
	//La carta tiene 6 estados: En mazo, en mano, en campo ataque,
	//en campo defensa boca arriba, en campo defensa boca abajo y en cementerio (muerta).
	
	
	@Test
	public void testComienzaLaPartidaCon35CartasEnElMazo() {
		Campo campoTest = new Campo();
		assertEquals(35, campoTest.obtenerCantidadDeCartasEnMazo());
	}
	
	@Test
	public void testComienzaLaPartidaCon0CartasEnElCementerio() {
		Campo campoTest = new Campo();
		assertEquals(0, campoTest.obtenerCantidadDeCartasEnCementerio());
	}
	
	@Test
	public void testCampoComienzaVacio() {
		Campo campoTest = new Campo();
		assertFalse(campoTest.tieneCartas());
	}
	
	@Test
	public void testColocarUnMonstruoBocaArribaEnZonaCorrecta() {
		Campo campoPropio = new Campo();
		Puntos ataqueMonstruo1 = new Puntos(1000);
		Puntos defensaMonstruo1 = new Puntos(500);
		int estrellasMonstruo = 3;
		Atacable monstruoPropio = new CartaMonstruo(ataqueMonstruo1, defensaMonstruo1, estrellasMonstruo);
		Modo modoAtaque = new ModoAtaque();
		EstadoCarta bocaArriba = new EstadoCartaColocadaBocaArriba();
		
		monstruoPropio.cambiarA(modoAtaque);
		campoPropio.colocarCarta(monstruoPropio, bocaArriba);
		
		assertEquals(1, campoPropio.obtenerCantidadDeCartasEnZonaMonstruos());
	}
	
	@Test
	public void testColocarUnaCartaMagicaEnZonaCorrecta() {
		Campo campoTest = new Campo();
		
		EfectoAgujeroNegro agujeroNegroEfecto = new EfectoAgujeroNegro();
 		Colocable carta = new CartaMagica( agujeroNegroEfecto );
		
		EstadoCarta bocaAbajo = new EstadoCartaColocadaBocaAbajo();
		campoTest.colocarCarta(carta, bocaAbajo);
		assertEquals(1, campoTest.obtenerCantidadDeCartasEnZonaMagicasYTrampas());
	}
	
	@Test
	public void testColocarUnaCartaTrampaEnZonaCorrecta() {
		Campo campoTest = new Campo();
		
		Efecto efectoTest = new EfectoNulo();
 		Colocable carta = new CartaTrampa(efectoTest);
 		
		EstadoCarta bocaAbajo = new EstadoCartaColocadaBocaAbajo();
		campoTest.colocarCarta(carta, bocaAbajo);
		assertEquals(1, campoTest.obtenerCantidadDeCartasEnZonaMagicasYTrampas());
	}
	
	@Test
	public void testColocarUnaCartaCampoEnZonaCorrecta() {
		Campo campoTest = new Campo();
		
		Efecto efectoNulo = new EfectoNulo();
 		Colocable cartaCampo = new CartaCampo(efectoNulo);
 		
		EstadoCarta bocaArriba = new EstadoCartaColocadaBocaArriba();
		campoTest.colocarCarta(cartaCampo, bocaArriba);
		assertEquals(1, campoTest.obtenerCantidadDeCartasEnZonaCampo());
	}
	
	
	@Test
	public void testColocarUnaCartaMonstruoEnModoAtaqueQuedaColocado() {
		CartaMonstruoFactory fabrica = new CartaMonstruoFactory();
		
		Atacable cartaMonstruo = fabrica.crearHeroeElementalAvian();
		Campo campo = new Campo();

		EstadoCarta bocaArriba = new EstadoCartaColocadaBocaArriba();
		campo.colocarCarta(cartaMonstruo, bocaArriba);
		
		assertEquals(1, campo.obtenerCantidadDeCartasEnZonaMonstruos());
	}
	
	
	@Test
	public void testColocarUnaCartaMonstruoBocaArribaEnModoDefensaQuedaColocado() {
		CartaMonstruoFactory fabrica = new CartaMonstruoFactory();
		
		Atacable cartaMonstruo = fabrica.crearHeroeElementalAvian();
		Campo campo = new Campo();

		EstadoCarta bocaArriba = new EstadoCartaColocadaBocaArriba();
		campo.colocarCarta(cartaMonstruo, bocaArriba);
		assertEquals( 1, campo.obtenerCantidadDeCartasEnZonaMonstruos() );
	}
	
	@Test
	public void testColocarUnaCartaMonstruoBocaAbajoEnModoDefensaQuedaColocado() {
		
		CartaMonstruoFactory fabrica = new CartaMonstruoFactory();
		
		Atacable cartaMonstruo = fabrica.crearHeroeElementalAvian();
		Campo campo = new Campo();

		EstadoCarta bocaAbajo = new EstadoCartaColocadaBocaAbajo();
		campo.colocarCarta(cartaMonstruo, bocaAbajo);
		assertEquals( 1, campo.obtenerCantidadDeCartasEnZonaMonstruos() );
	
	}
	
	@Test
	public void testColocarUnaCartaMagicaBocaAbajoQuedaColocada() {
		
		Campo campo = new Campo();
		CartaMagica carta = new CartaMagica();
		
		carta.colocarBocaAbajo();
		
		EstadoCarta bocaAbajo = new EstadoCartaColocadaBocaAbajo();

		campo.colocarCarta(carta,bocaAbajo);
		
		assertEquals( 1, campo.obtenerCantidadDeCartasEnZonaMagicasYTrampas() );
	
	}
	
	@Test
	public void testColocarUnaCartaMagicaBocaArribaSeActivaYSeVaAlCementerio() {
		Campo campo = new Campo();
		
		Activable carta = new CartaMagica();
		//No se guarda el efecto de la carta magica al colocarla boca arriba
		
		EstadoCarta bocaArriba = new EstadoCartaColocadaBocaArriba();

		campo.colocarCarta(carta, bocaArriba);
		
		assertEquals( 1, campo.obtenerCantidadDeCartasEnCementerio() );
	
	}
	
	@Test
	public void testColocarUnaCartaTrampaBocaAbajoQuedaColocada() {
		Campo campo = new Campo();
		CartaTrampa carta = new CartaTrampa();
		
		carta.colocarBocaAbajo();
		EstadoCarta bocaAbajo = new EstadoCartaColocadaBocaAbajo();

		campo.colocarCarta(carta,bocaAbajo);
		
		assertEquals( 1, campo.obtenerCantidadDeCartasEnZonaMagicasYTrampas() );
	}
	
	@Test

	public void testColocarUnaCartaMagicaYUnaTrampaQudanColocadas() {
		Campo campo = new Campo();
		CartaMagica cartaMagica = new CartaMagica();
		CartaTrampa cartaTrampa = new CartaTrampa();
		
		cartaMagica.colocarBocaAbajo();
		cartaTrampa.colocarBocaAbajo();
		
		EstadoCarta bocaAbajo = new EstadoCartaColocadaBocaAbajo();

		campo.colocarCarta(cartaMagica,bocaAbajo);
		campo.colocarCarta(cartaTrampa,bocaAbajo);
		int cartasEnCampoEsperadas = 2;
		
		assertEquals(cartasEnCampoEsperadas, campo.obtenerCantidadDeCartasEnJuego());
	}
	

	@Test
	public void testColocarDosCartasMonstruoyQuedanColocadas() {
		Campo campo = new Campo();
		
		CartaMonstruoFactory fabrica = new CartaMonstruoFactory();
		
		Atacable cartaMonstruo1 = fabrica.crearHeroeElementalAvian();
		Atacable cartaMonstruo2 = fabrica.crearHeroeElementalAvian();
		
		
		EstadoCarta bocaArriba = new EstadoCartaColocadaBocaArriba();
		
		campo.colocarCarta(cartaMonstruo1,bocaArriba);
		campo.colocarCarta(cartaMonstruo2,bocaArriba);
		int cartasEnCampoEsperadas = 2;
		
		assertEquals(cartasEnCampoEsperadas, campo.obtenerCantidadDeCartasEnZonaMonstruos());
	}
	
	@Test
	public void testColocarCartaMonstruoCartaMagicaYCartaTrampaQuedanColocadas() {
		Campo campo = new Campo();
		
		CartaMonstruoFactory fabrica = new CartaMonstruoFactory();
		
		Atacable cartaMonstruo =	fabrica.crearHeroeElementalAvian();
		CartaMagica cartaMagica = new CartaMagica();
		CartaTrampa cartaTrampa = new CartaTrampa();
		
		EstadoCarta bocaArriba = new EstadoCartaColocadaBocaArriba();
		EstadoCarta bocaAbajo = new EstadoCartaColocadaBocaAbajo();
		
		campo.colocarCarta(cartaMonstruo,bocaArriba);
		campo.colocarCarta(cartaMagica,bocaAbajo);
		campo.colocarCarta(cartaTrampa,bocaAbajo);
		
		int cartasEnCampoEsperadas = 3;
		
		assertEquals( cartasEnCampoEsperadas, campo.obtenerCantidadDeCartasEnJuego() );
	}

	@Test
	public void testVaciarZonaMonstruosDelCampo() {
		Campo campo = new Campo();
		CartaMonstruoFactory fabrica = new CartaMonstruoFactory();
		
		Atacable cartaMonstruo1 =  fabrica.crearHeroeElementalAvian();
		Atacable cartaMonstruo2 =  fabrica.crearHeroeElementalAvian();
		Atacable cartaMonstruo3 =  fabrica.crearHeroeElementalAvian();
		
		EstadoCarta bocaArriba = new EstadoCartaColocadaBocaArriba();
		
		campo.colocarCarta(cartaMonstruo1,bocaArriba);
		campo.colocarCarta(cartaMonstruo2,bocaArriba);
		campo.colocarCarta(cartaMonstruo3,bocaArriba);
	
		campo.vaciarZonaMonstruos();
		assertTrue ( campo.obtenerCantidadDeCartasEnZonaMonstruos() == 0 );
	}
}
