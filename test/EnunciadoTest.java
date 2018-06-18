import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

import estrategias.*;
import modos.*;
import campo.Campo;
import cartas.*;
import efectos.*;
import estadoCarta.*;
import jugador.Jugador;
import exceptions.*;


public class EnunciadoTest {
	
	
	//Colocar una carta de monstruo en posiciÃ³n de ataque.
	@Test
	public void test01ColocarCartaMonstruoEnModoAtaque() {
//		Campo campoTest = new Campo();
//		CartaMonstruo cartaMonstruo = new CartaMonstruo(); //Pogramar vs interfaces !!!!
//		cartaMonstruo.colocarEnModoAtaque();
//		
//		campoTest.colocarCarta(cartaMonstruo);
//		assertEquals(1,campoTest.obtenerCantidadDeCartasEnZonaMonstruo());
//		assertTrue( cartaMonstruo.estaColocadaEnModoAtaque() );
//		
		
		
		//Agregada nueva clase "puntos" en carta para el manejo de puntos de ataque y defensa
		//en cartas monstruo
		//Agregado nuevo EstadoCartaInvocada (No tiene nada implementado)
		//Agregadas clases Estrategias y Modos (no implementados, deben relacionarse con el
		//campo todavia)	
		//Falta cambiar todo lo que diga "Utilizable" por "Activable"
		
		Campo campoPropio = new Campo();
		Campo campoEnemigo = new Campo();
		Puntos ataqueMonstruo1 = new Puntos(1000);
		Puntos defensaMonstruo1 = new Puntos(500);
		Puntos ataqueMonstruo2 = new Puntos(900);
		Puntos defensaMonstruo2 = new Puntos(300);
		int estrellasMonstruo = 3;
		Atacable monstruoPropio = new CartaMonstruo(ataqueMonstruo1, defensaMonstruo1, estrellasMonstruo);
		Atacable monstruoEnemigo = new CartaMonstruo(ataqueMonstruo2, defensaMonstruo2, estrellasMonstruo);
		Modo modoAtaque = new ModoAtaque();
		EstadoCarta bocaArriba = new EstadoCartaColocadaBocaArriba();
		//campo recibe estrategia y modo
		
		monstruoPropio.cambiarA(modoAtaque);
		monstruoEnemigo.cambiarA(modoAtaque);
		
		
		campoPropio.colocarCarta(monstruoPropio, bocaArriba);
		campoEnemigo.colocarCarta(monstruoEnemigo, bocaArriba);
		
		monstruoPropio.atacar(monstruoEnemigo);
		campoEnemigo.enviarCartasDestruidasAlCementerio();
		
		//Como esta en modo ataque y tiene mas puntos de ataque que la carta enemiga la mata
		//y la envia al cementerio <--- Esta bien que tenga que aclarar que es lo que esta
		//pasando? El codigo deberia ser mas claro o el comentario sobra?
		
		assertEquals( 1, campoEnemigo.obtenerCantidadDeCartasEnCementerio() );
		
		
		
		//REPENSAR ESTE TESTS ( Y LOS PARECIDOS ) SE DEBE TESTEAR COMPORTAMIENTO
		
		//-Hay que rehacer "EstadoCarta", separar en "POSICION-BOCAARRIBA/ABAJO-ATAQUE/DEFENSA"
		//-Colocar en modo ataque implica que puede atacar
		//-Puntos de ataque/defensa que no sean integers el comportamiento que podrÃ­an tener
		// para que no sean solo clases contenedoras es el de aumentar/decrementar su valor 
		// hasta que "pase el turno" (es decir, se puede hacer que cuando se construya tenga
		// un valor original y posea un metodo que sea "aumentarEn(puntosExtra)" y otro que
		// sea "eliminarAumento" o algo del estilo)
		//-Les convence una clase que sea "ModoDeCartaMonstruo"? O es muy especifica?
		//
	}
	
	@Test
	public void test02ColocarMonstruoBocaAbajoEnModoDefensa() {
//		
//		Campo campoTest = new Campo();
//		CartaMonstruo cartaMonstruo = new CartaMonstruo();
//		cartaMonstruo.colocarBocaAbajoEnModoDefensa();
//		
//		campoTest.colocarCarta(cartaMonstruo);
//		
//		assertEquals(1,campoTest.obtenerCantidadDeCartasEnZonaMonstruo());
//		assertTrue( cartaMonstruo.estaColocadaBocaAbajoEnModoDefensa() );
//		

		//CartaEnModoDefensaNoPuedeAtacar
		//cambia algo el que este boca abajo? Que comportamiento le agrega?
		
		Campo campoPropio = new Campo();
		Campo campoEnemigo = new Campo();
		Puntos ataqueMonstruo1 = new Puntos(1000);
		Puntos defensaMonstruo1 = new Puntos(500);
		Puntos ataqueMonstruo2 = new Puntos(900);
		Puntos defensaMonstruo2 = new Puntos(300);
		int estrellasMonstruo = 3;
		Atacable monstruoPropio = new CartaMonstruo(ataqueMonstruo1, defensaMonstruo1, estrellasMonstruo);
		Atacable monstruoEnemigo = new CartaMonstruo(ataqueMonstruo2, defensaMonstruo2, estrellasMonstruo);
		Modo modoAtaque = new ModoAtaque();
		Modo modoDefensa = new ModoDefensa();
		EstadoCarta bocaAbajo = new EstadoCartaColocadaBocaAbajo();
		EstadoCarta bocaArriba = new EstadoCartaColocadaBocaArriba();
		boolean huboExcepcion = false;
		
		monstruoPropio.cambiarA(modoDefensa);
		monstruoEnemigo.cambiarA(modoAtaque);
		
		campoPropio.colocarCarta(monstruoPropio, bocaAbajo);
		campoEnemigo.colocarCarta(monstruoEnemigo, bocaArriba);
		
		
		try {
			monstruoPropio.atacar(monstruoEnemigo);
		} catch (MonstruoEnModoDefensaNoPuedeAtacarException error) {
			huboExcepcion = true;
		}
		
		assertTrue(huboExcepcion);
		
	}
	
	@Test
	public void test03ColocarCartaMagicaEnCampoBocaAbajo() {
		
		Efecto efectoNulo = new EfectoNulo();
		CartaMagica cartaMagica = new CartaMagica(efectoNulo);
		Campo campoPropio = new Campo();
		Campo campoEnemigo = new Campo();
		EstadoCarta bocaAbajo = new EstadoCartaColocadaBocaAbajo();
		boolean huboExcepcion = false;
		
		campoPropio.colocarCarta(cartaMagica, bocaAbajo);
		
		
		try {
			cartaMagica.aplicarEfecto(campoPropio, campoEnemigo);
		} catch (CartaBocaAbajoNoPuedeActivarEfectoException error) {
			huboExcepcion = true;
		}
		
		assertTrue(huboExcepcion);
	}
	
	@Test
	public void test04ColocarCartaTrampaEnCampoBocaAbajo() {

		Efecto efectoNulo = new EfectoNulo();
		CartaTrampa cartaTrampa = new CartaTrampa(efectoNulo);
		Campo campoTest = new Campo();
		EstadoCarta bocaAbajo = new EstadoCartaColocadaBocaAbajo();
		campoTest.colocarCarta(cartaTrampa, bocaAbajo);
		
		assertEquals(1, campoTest.obtenerCantidadDeCartasEnZonaUtilidad() );
	}
	
	@Test
	public void test05MandarCartaAlCementerio() {

		Efecto efectoNulo = new EfectoNulo();
		CartaMagica cartaMagica = new CartaMagica(efectoNulo);
		Campo campo = new Campo();
		EstadoCarta bocaAbajo = new EstadoCartaColocadaBocaAbajo();
				
		campo.colocarCarta(cartaMagica, bocaAbajo);
		cartaMagica.destruirCarta();
		campo.enviarCartasDestruidasAlCementerio();
		
		assertEquals( 1, campo.obtenerCantidadDeCartasEnCementerio() );
		
	}
	
	/*Colocar una carta de monstruo en posicion de ataque, el oponente coloca otra carta
de monstruo en posicion de ataque (con mayor ataque). Atacar al primer monstruo y
verificar que este se destruyo, y sufro danio a los puntos de vida igual a la diferencia
de los puntos de ataque de los monstruos*/

	@Test
	public void test06MonstruoAtacaAOtroMonstruoEnModoAtaqueConMenorAtaque() {
		Puntos ataqueMonstruo1 = new Puntos(1000);
		Puntos defensaMonstruo1 = new Puntos(500);
		Puntos ataqueMonstruo2 = new Puntos(900);
		Puntos defensaMonstruo2 = new Puntos(300);
		int estrellas = 3;
		Atacable monstruoConMayorAtaque = new CartaMonstruo(ataqueMonstruo1, defensaMonstruo1, estrellas);
		Atacable monstruoConMenorAtaque = new CartaMonstruo(ataqueMonstruo2, defensaMonstruo2, estrellas);
		Jugador jugador1 = new Jugador();
		Jugador jugador2 = new Jugador();
		
		jugador1.enfrentarseA(jugador2);
		jugador2.enfrentarseA(jugador1);
 		
		Modo modoAtaque = new ModoAtaque();
		EstadoCarta bocaArriba = new EstadoCartaColocadaBocaArriba();
		
		//Desde jugador al colocar pueden lanzarse dos tipos de excepciones
		//NoHayEspacioEnCampo y NoHayMonstruoParaSacrificar cuando se quiere colocar un monstruo
		//de muchas estrellas
		
 		jugador1.colocar(monstruoConMayorAtaque, bocaArriba, modoAtaque);
 		jugador2.colocar(monstruoConMenorAtaque, bocaArriba, modoAtaque);
 		
 		jugador1.atacar(monstruoConMayorAtaque, monstruoConMenorAtaque);
 		
		int vidaEsperada = 7000;
		
		assertFalse(monstruoConMayorAtaque.estaDestruida());
		assertTrue(monstruoConMenorAtaque.estaDestruida());
		
		assertEquals(vidaEsperada , jugador2.obtenerVidaRestante());
	
	}
 /*	Colocar una carta de monstruo en posiciï¿½n de ataque, el oponente coloca otra carta
	de monstruo en posiciï¿½n de ataque (con menor ataque), atacar al primer monstruo,
	el monstruo atacante es destruido y el atacante recibe daï¿½o a los
	puntos de vida igual a la diferencia de ataques.
  * 
  */
	@Test
	public void test07MonstruoAtacaAOtroMonstruoEnModoAtaqueConMayorAtaque() {
		CartaMonstruo monstruoConMayorAtaque = new CartaMonstruo(2000, 3000);
 		CartaMonstruo monstruoConMenorAtaque = new CartaMonstruo(1000, 2000);
		Jugador jugador1 = new Jugador();
		Jugador jugador2 = new Jugador();
		
		jugador1.enfrentarseA(jugador2);
		jugador2.enfrentarseA(jugador1);
 		
 		jugador1.colocarMonstruoEnModoAtaque(monstruoConMayorAtaque);
 		jugador2.colocarMonstruoEnModoAtaque(monstruoConMenorAtaque);
 		
 		jugador2.atacar(monstruoConMenorAtaque, monstruoConMayorAtaque);
 		
		int vidaEsperada = 7000;
		
		assertFalse(monstruoConMayorAtaque.estaDestruida());
		assertTrue(monstruoConMenorAtaque.estaDestruida());
		
		assertEquals(vidaEsperada , jugador2.obtenerVidaRestante());
	}
	
	/*
	Colocar una carta de monstruo en posiciï¿½n de ataque, el oponente coloca otra carta
	de monstruo en posiciï¿½n de ataque (con igual ataque), atacar al primer monstruo,
	ambos monstruos son destruidos y nadie recibe daï¿½o a los puntos de
	vida.
	*/
	
	@Test
	public void test08MonstruoAtacaAOtroMonstruoEnModoAtaqueConIgualAtaque() {
		CartaMonstruo monstruoConMilDeAtaque = new CartaMonstruo(1000, 3000);
 		CartaMonstruo otroMonstruoConMilDeAtaque = new CartaMonstruo(1000, 2000);
		Jugador jugador1 = new Jugador();
		Jugador jugador2 = new Jugador();
		
		jugador1.enfrentarseA(jugador2);
		jugador2.enfrentarseA(jugador1);
 		
 		jugador1.colocarMonstruoEnModoAtaque(monstruoConMilDeAtaque);
 		jugador2.colocarMonstruoEnModoAtaque(otroMonstruoConMilDeAtaque);
 		
 		jugador2.atacar( monstruoConMilDeAtaque , otroMonstruoConMilDeAtaque);
 		
		int vidaEsperada = 8000;
		
		assertTrue(monstruoConMilDeAtaque.estaDestruida());
		assertTrue(otroMonstruoConMilDeAtaque.estaDestruida());
		
		assertEquals( vidaEsperada , jugador2.obtenerVidaRestante());
		assertEquals( vidaEsperada, jugador1.obtenerVidaRestante() );
	}
	
	/*Colocar una carta de monstruo en posiciÃ³n de defensa, el oponente coloca otra carta
	de monstruo en posiciÃ³n de ataque (con mayor ataque que la defensa del primer
	monstruo), atacar al primer monstruo y verificar que este se destruyÃ³ y no sufriÃ³
	ningÃºn daÃ±o vital.*/
	@Test
	public void test09MonstruoSeDefiendeDeOtroMonstruoEnModoAtaqueConMayorAtaqueQueSuDefensa() {
		CartaMonstruo monstruoAtacante = new CartaMonstruo(3000, 3000);
 		CartaMonstruo monstruoDefensor = new CartaMonstruo(1000, 2000);
 
 		Jugador jugador1 = new Jugador();
		Jugador jugador2 = new Jugador();
		
		jugador1.enfrentarseA(jugador2);
		jugador2.enfrentarseA(jugador1);
 		
 		jugador1.colocarMonstruoEnModoAtaque(monstruoAtacante);
 		jugador2.colocarMonstruoBocaArribaEnModoDefensa(monstruoDefensor);
 		
 		jugador2.atacar( monstruoAtacante , monstruoDefensor );
 		
		int vidaEsperada = 8000;
		
		assertFalse(monstruoAtacante.estaDestruida());
		assertTrue(monstruoDefensor.estaDestruida());
		
		assertEquals( vidaEsperada , jugador2.obtenerVidaRestante());
		assertEquals( vidaEsperada, jugador1.obtenerVidaRestante() );
	}
	
	/*Colocar una carta de monstruo en posiciÃ³n de defensa, el oponente coloca otra carta
	de monstruo en posiciÃ³n de ataque (con menor ataque que la defensa del primer
	monstruo), atacar al primer monstruo y verificar que este no se destruyÃ³ y no sufriÃ³
	ningÃºn daÃ±o vital.*/
	@Test
	public void test10MonstruoSeDefiendeDeOtroMonstruoEnModoAtaqueConMenorAtaqueQueSuDefensa() {
		CartaMonstruo monstruoAtacante = new CartaMonstruo(1000, 3000);
 		CartaMonstruo monstruoDefensor = new CartaMonstruo(1000, 2000);
 
 		Jugador jugador1 = new Jugador();
		Jugador jugador2 = new Jugador();
		
		jugador1.enfrentarseA(jugador2);
		jugador2.enfrentarseA(jugador1);
 		
 		jugador1.colocarMonstruoEnModoAtaque(monstruoAtacante);
 		jugador2.colocarMonstruoBocaArribaEnModoDefensa(monstruoDefensor);
 		
 		jugador2.atacar( monstruoAtacante , monstruoDefensor );
 		
		int vidaEsperada = 8000;
		
		assertFalse(monstruoAtacante.estaDestruida());
		assertFalse(monstruoDefensor.estaDestruida());
		
		assertEquals( vidaEsperada , jugador2.obtenerVidaRestante());
		assertEquals( vidaEsperada, jugador1.obtenerVidaRestante() );
	}
	
	/*Colocar monstruos en ambos lados del campo. Colocar â€œAgujero negroâ€� boca arriba
	(es decir, se activa el efecto). Verificar que se destruyeron todos los monstruos de
	ambos lados del campo, y que nadie recibiÃ³ daÃ±o alguno.*/
	@Test
	public void test11MonstruosDelCampoSeDestruyenAlColocarAgujeroNegro() {
		CartaMonstruo monstruoAtacante = new CartaMonstruo(1000, 3000);
		CartaMonstruo monstruoDefensor = new CartaMonstruo(1000, 2000);
 		EfectoAgujeroNegro agujeroNegroEfecto = new EfectoAgujeroNegro();
 		CartaMagica carta = new CartaMagica( agujeroNegroEfecto );
 		Jugador jugador1 = new Jugador();
 		Jugador jugador2 = new Jugador();
 		
 		jugador1.enfrentarseA(jugador2);
 		jugador2.enfrentarseA(jugador1);
 		
 		jugador1.colocarMonstruoEnModoAtaque(monstruoAtacante);
 		jugador2.colocarMonstruoBocaAbajoEnModoDefensa(monstruoDefensor);
 		
 		jugador1.colocarCartaMagicaBocaArriba( carta );
 		
 		assertFalse( jugador1.tieneCartasEnCampo());
 		assertFalse( jugador2.tieneCartasEnCampo());
 		int vidaEsperada = 8000;
		assertEquals( vidaEsperada , jugador2.obtenerVidaRestante());
		assertEquals( vidaEsperada, jugador1.obtenerVidaRestante() );
	}
	
	/*Se coloca un monstruo en el campo, se quiere colocar un monstruo de 5 o 6
	estrellas que requiere sacrificio. se verifica que se convocÃ³ al monstruo y se
	destruyÃ³ el primero.*/
	@Test
	public void test12ColocarMonstruoQueRequiereUnSacrificioDestruyeElMonstruoAnterior() {
		CartaMonstruo monstruo = new CartaMonstruo(1000, 3000, 3);
		CartaMonstruo monstruoSeisEstrellas = new CartaMonstruo(1000, 2000, 6);

 		Jugador jugador1 = new Jugador();
 		
 		jugador1.colocarMonstruoEnModoAtaque(monstruo);
 		
 		jugador1.colocarMonstruoEnModoAtaque( monstruoSeisEstrellas );
 		
 		assertTrue( monstruo.estaDestruida() );
 		assertEquals( 1 ,jugador1.obtenerCantidadCartasEnCampo());
 		

	}
	
	/*Se colocan 2 monstruos en el campo, se quiere colocar un monstruo de 7 o mÃ¡s
	estrellas que requiere 2 sacrificios. 
	se verifica que se convocÃ³ al monstruo y sedestruyeron los demÃ¡s. */
	@Test
	public void test13ColocarMonstruoQueRequiereDosSacrificiosDestruyeLosDosMonstruosAnteriores() {
		CartaMonstruo monstruo1 = new CartaMonstruo(1000, 3000, 3);
		CartaMonstruo monstruo2 = new CartaMonstruo(1000, 3000, 3);
		CartaMonstruo monstruoOchoEstrellas = new CartaMonstruo(1000, 2000, 8);

 		Jugador jugador1 = new Jugador();
 		
 		jugador1.colocarMonstruoEnModoAtaque(monstruo1);
 		jugador1.colocarMonstruoEnModoAtaque(monstruo2);
 		
 		jugador1.colocarMonstruoEnModoAtaque( monstruoOchoEstrellas );
 		
 		assertTrue( monstruo1.estaDestruida() );
 		assertTrue( monstruo2.estaDestruida() );
 		
 		assertEquals( 1 ,jugador1.obtenerCantidadCartasEnCampo());
	}
}
