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
 		
		int vidaEsperada = 7900;
	
		
		//Separar en test unitarios
		
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
		Puntos ataqueMonstruo1 = new Puntos(2000);
		Puntos defensaMonstruo1 = new Puntos(3000);
		Puntos ataqueMonstruo2 = new Puntos(1000);
		Puntos defensaMonstruo2 = new Puntos(2000);
		int estrellas = 3;
		Atacable monstruoConMayorAtaque = new CartaMonstruo(ataqueMonstruo1, defensaMonstruo1, estrellas);
 		Atacable monstruoConMenorAtaque = new CartaMonstruo(ataqueMonstruo2, defensaMonstruo2, estrellas);
		Jugador jugador1 = new Jugador();
		Jugador jugador2 = new Jugador();
		
		jugador1.enfrentarseA(jugador2);
		jugador2.enfrentarseA(jugador1);
		
		Modo modoAtaque = new ModoAtaque();
		EstadoCarta bocaArriba = new EstadoCartaColocadaBocaArriba();
		
		jugador1.colocar(monstruoConMayorAtaque, bocaArriba, modoAtaque);
 		jugador2.colocar(monstruoConMenorAtaque, bocaArriba, modoAtaque);
 		
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
		Puntos ataqueMonstruo1 = new Puntos(2000);
		Puntos defensaMonstruo1 = new Puntos(3000);
		Puntos defensaMonstruo2 = new Puntos(2000);
		int estrellas = 3;
		CartaMonstruo monstruoConMilDeAtaque = new CartaMonstruo(ataqueMonstruo1, defensaMonstruo1, estrellas);
 		CartaMonstruo otroMonstruoConMilDeAtaque = new CartaMonstruo(ataqueMonstruo1, defensaMonstruo2, estrellas);
		Jugador jugador1 = new Jugador();
		Jugador jugador2 = new Jugador();
		
		jugador1.enfrentarseA(jugador2);
		jugador2.enfrentarseA(jugador1);
 		

		Modo modoAtaque = new ModoAtaque();
		EstadoCarta bocaArriba = new EstadoCartaColocadaBocaArriba();
		jugador1.colocar(monstruoConMilDeAtaque, bocaArriba, modoAtaque);
 		jugador2.colocar(otroMonstruoConMilDeAtaque, bocaArriba, modoAtaque);

 		jugador2.atacar( otroMonstruoConMilDeAtaque , monstruoConMilDeAtaque);
 		
		int vidaEsperada = 8000;
		
		assertTrue(monstruoConMilDeAtaque.estaDestruida());
		assertTrue(otroMonstruoConMilDeAtaque.estaDestruida());
		
		assertEquals( vidaEsperada, jugador2.obtenerVidaRestante());
		assertEquals( vidaEsperada, jugador1.obtenerVidaRestante() );
	}
	
	/*Colocar una carta de monstruo en posiciÃ³n de defensa, el oponente coloca otra carta
	de monstruo en posiciÃ³n de ataque (con mayor ataque que la defensa del primer
	monstruo), atacar al primer monstruo y verificar que este se destruyÃ³ y no sufriÃ³
	ningÃºn daÃ±o vital.*/
	@Test
	public void test09MonstruoSeDefiendeDeOtroMonstruoEnModoAtaqueConMayorAtaqueQueSuDefensa() {
		Puntos ataqueMonstruo1 = new Puntos(2000);
		Puntos defensaMonstruo1 = new Puntos(3000);
		Puntos ataqueMonstruo2 = new Puntos(1000);
		Puntos defensaMonstruo2 = new Puntos(1500);
		int estrellas = 3;
		Atacable unMonstuo = new CartaMonstruo(ataqueMonstruo1, defensaMonstruo1, estrellas);
 		Atacable otroMonstruo = new CartaMonstruo(ataqueMonstruo2, defensaMonstruo2, estrellas);
		Jugador jugador1 = new Jugador();
		Jugador jugador2 = new Jugador();
		
		jugador1.enfrentarseA(jugador2);
		jugador2.enfrentarseA(jugador1);
		
		Modo modoAtaque = new ModoAtaque();
		Modo modoDefensa = new ModoDefensa();
		EstadoCarta bocaArriba = new EstadoCartaColocadaBocaArriba();
		jugador1.colocar(unMonstuo, bocaArriba, modoAtaque);
 		jugador2.colocar(otroMonstruo, bocaArriba, modoDefensa);
 		
 		jugador1.atacar(unMonstuo, otroMonstruo);
 		
		int vidaEsperada = 8000;
		
		assertFalse(unMonstuo.estaDestruida());
		assertTrue(otroMonstruo.estaDestruida());
		
		assertEquals(vidaEsperada , jugador2.obtenerVidaRestante());
	}
	
	/*Colocar una carta de monstruo en posiciÃ³n de defensa, el oponente coloca otra carta
	de monstruo en posiciÃ³n de ataque (con menor ataque que la defensa del primer
	monstruo), atacar al primer monstruo y verificar que este no se destruyÃ³ y no sufriÃ³
	ningÃºn daÃ±o vital.*/
	@Test
	public void test10MonstruoSeDefiendeDeOtroMonstruoEnModoAtaqueConMenorAtaqueQueSuDefensa() {
		Puntos ataqueMonstruo1 = new Puntos(2000);
		Puntos defensaMonstruo1 = new Puntos(3000);
		Puntos ataqueMonstruo2 = new Puntos(1000);
		Puntos defensaMonstruo2 = new Puntos(2500);
		int estrellas = 3;
		Atacable unMonstuo = new CartaMonstruo(ataqueMonstruo1, defensaMonstruo1, estrellas);
 		Atacable otroMonstruo = new CartaMonstruo(ataqueMonstruo2, defensaMonstruo2, estrellas);
		Jugador jugador1 = new Jugador();
		Jugador jugador2 = new Jugador();
		
		jugador1.enfrentarseA(jugador2);
		jugador2.enfrentarseA(jugador1);
		
		Modo modoAtaque = new ModoAtaque();
		Modo modoDefensa = new ModoDefensa();
		EstadoCarta bocaArriba = new EstadoCartaColocadaBocaArriba();
		jugador1.colocar(unMonstuo, bocaArriba, modoAtaque);
 		jugador2.colocar(otroMonstruo, bocaArriba, modoDefensa);
 		
 		jugador1.atacar(unMonstuo, otroMonstruo);
 		
		int vidaEsperada = 8000;
		
		assertFalse(unMonstuo.estaDestruida());
		assertFalse(otroMonstruo.estaDestruida());
		
		assertEquals(vidaEsperada , jugador2.obtenerVidaRestante());
	}
	
	/*Colocar monstruos en ambos lados del campo. Colocar â€œAgujero negroâ€� boca arriba
	(es decir, se activa el efecto). Verificar que se destruyeron todos los monstruos de
	ambos lados del campo, y que nadie recibiÃ³ daÃ±o alguno.*/
	@Test
	public void test11MonstruosDelCampoSeDestruyenAlColocarAgujeroNegro() {
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
 		CartaMagica carta = new CartaMagica( agujeroNegroEfecto );
 		
		jugador1.enfrentarseA(jugador2);
		jugador2.enfrentarseA(jugador1);
		
		Modo modoAtaque = new ModoAtaque();
		Modo modoDefensa = new ModoDefensa();
		EstadoCarta bocaArriba = new EstadoCartaColocadaBocaArriba();
		jugador1.colocar(unMonstuo, bocaArriba, modoAtaque);
 		jugador2.colocar(otroMonstruo, bocaArriba, modoDefensa);
 		jugador1.colocarCartaMagicaBocaArriba(carta);
 		
 		assertFalse( jugador1.tieneCartasEnCampo());
 		assertFalse( jugador2.tieneCartasEnCampo());
	}
	
	/*Se coloca un monstruo en el campo, se quiere colocar un monstruo de 5 o 6
	estrellas que requiere sacrificio. se verifica que se convocÃ³ al monstruo y se
	destruyÃ³ el primero.*/
	@Test
	public void test12ColocarMonstruoQueRequiereUnSacrificioDestruyeElMonstruoAnterior() {
		Puntos ataqueMonstruo1 = new Puntos(2000);
		Puntos defensaMonstruo1 = new Puntos(3000);
		Puntos ataqueMonstruo2 = new Puntos(1000);
		Puntos defensaMonstruo2 = new Puntos(2500);
		int estrellasDeUnMonstruo = 3;
		int estrellasDeOtroMonstruo = 6;
		Atacable unMonstruo = new CartaMonstruo(ataqueMonstruo2, defensaMonstruo2, estrellasDeUnMonstruo);
 		Atacable unMonstruode6Estrellas = new CartaMonstruo(ataqueMonstruo1, defensaMonstruo1, estrellasDeOtroMonstruo);
 		
 		Atacable unSacrificio = new CartaMonstruo(ataqueMonstruo1, defensaMonstruo1, estrellasDeUnMonstruo);
		Jugador jugador1 = new Jugador();
		Jugador jugador2 = new Jugador();
		
		jugador1.enfrentarseA(jugador2);
		jugador2.enfrentarseA(jugador1);
		
		Modo modoAtaque = new ModoAtaque();
		EstadoCarta bocaArriba = new EstadoCartaColocadaBocaArriba();
		jugador1.colocar(unSacrificio, bocaArriba, modoAtaque);
		jugador1.colocar(unMonstruode6Estrellas,bocaArriba, modoAtaque);
 		jugador2.colocar(unMonstruo, bocaArriba, modoAtaque);
 		
 		jugador1.atacar(unMonstruode6Estrellas, unMonstruo);
 		
 		int vidaEsperada = 7000;
 		assertEquals(1,jugador1.obtenerCantidadCartasEnCampo());
		assertEquals(vidaEsperada , jugador2.obtenerVidaRestante());

	}
	
	/*Se colocan 2 monstruos en el campo, se quiere colocar un monstruo de 7 o mÃ¡s
	estrellas que requiere 2 sacrificios. 
	se verifica que se convocÃ³ al monstruo y sedestruyeron los demÃ¡s. */
	@Test
	public void test13ColocarMonstruoQueRequiereDosSacrificiosDestruyeLosDosMonstruosAnteriores() {
		Puntos ataqueMonstruo1 = new Puntos(2000);
		Puntos defensaMonstruo1 = new Puntos(3000);
		Puntos ataqueMonstruo2 = new Puntos(1000);
		Puntos defensaMonstruo2 = new Puntos(2500);
		int estrellasDeUnMonstruo = 3;
		int estrellasDeOtroMonstruo = 8;
		Atacable unMonstruo = new CartaMonstruo(ataqueMonstruo2, defensaMonstruo2, estrellasDeUnMonstruo);
 		Atacable unMonstruode6Estrellas = new CartaMonstruo(ataqueMonstruo1, defensaMonstruo1, estrellasDeOtroMonstruo);
 		
 		Atacable unSacrificio = new CartaMonstruo(ataqueMonstruo1, defensaMonstruo1, estrellasDeUnMonstruo);
 		Atacable otroSacrificio = new CartaMonstruo(ataqueMonstruo1, defensaMonstruo1, estrellasDeUnMonstruo);
		Jugador jugador1 = new Jugador();
		Jugador jugador2 = new Jugador();
		
		jugador1.enfrentarseA(jugador2);
		jugador2.enfrentarseA(jugador1);
		
		Modo modoAtaque = new ModoAtaque();
		EstadoCarta bocaArriba = new EstadoCartaColocadaBocaArriba();
		jugador1.colocar(unSacrificio, bocaArriba, modoAtaque);
		jugador1.colocar(otroSacrificio, bocaArriba, modoAtaque);
		jugador1.colocar(unMonstruode6Estrellas,bocaArriba, modoAtaque);
 		jugador2.colocar(unMonstruo, bocaArriba, modoAtaque);
 		
 		jugador1.atacar(unMonstruode6Estrellas, unMonstruo);
 		
 		int vidaEsperada = 7000;
 		assertEquals(1,jugador1.obtenerCantidadCartasEnCampo());
		assertEquals(vidaEsperada , jugador2.obtenerVidaRestante());
	}
	
	@Test
	public void test14ColocarWastelandBocaArribaConUnMonstruoEnAmbosCampos() {
		Puntos ataqueMonstruo1 = new Puntos(1500); //1700 con wasteland
		Puntos defensaMonstruo1 = new Puntos(3000);
		Puntos ataqueMonstruo2 = new Puntos(1000);
		Puntos defensaMonstruo2 = new Puntos(1000); //1300 con wasteland
		int estrellasDeUnMonstruo = 3;
		Atacable unMonstruo = new CartaMonstruo(ataqueMonstruo1, defensaMonstruo1, estrellasDeUnMonstruo);
		Atacable otroMonstruo = new CartaMonstruo(ataqueMonstruo2, defensaMonstruo2, estrellasDeUnMonstruo);

		Efecto efectoWasteland = new EfectoWasteland();//wasteland aumenta los ptsatk de tus monstruos en 200
		CartaCampo wasteland = new CartaCampo(efectoWasteland); // tambien los ptsdef de los monstruos enemigos en 300
		
		Jugador jugador1 = new Jugador();
		Jugador jugador2 = new Jugador();
		
		jugador1.enfrentarseA(jugador2);
		jugador2.enfrentarseA(jugador1);
		
		Modo modoAtaque = new ModoAtaque();
		EstadoCarta bocaArriba = new EstadoCartaColocadaBocaArriba();
		
		jugador1.colocar(unMonstruo, bocaArriba, modoAtaque);
		jugador2.colocar(otroMonstruo, bocaArriba, modoAtaque);
		jugador1.colocarCartaMagicaBocaArriba(wasteland);
		
		jugador1.atacar(unMonstruo, otroMonstruo);
		
		int vidaEsperada = 7300;
		assertEquals(vidaEsperada, jugador2.obtenerVidaRestante());
	}
	
	@Test
	public void test15ColocarSogenBocaArribaConUnMonstruoEnAmbosCampos() {
		Puntos ataqueMonstruo1 = new Puntos(1500);
		Puntos defensaMonstruo1 = new Puntos(1000); //1500 con sogen
		Puntos ataqueMonstruo2 = new Puntos(1000); //1200 con sogen
		Puntos defensaMonstruo2 = new Puntos(1000);
		int estrellasDeUnMonstruo = 3;
		Atacable unMonstruo = new CartaMonstruo(ataqueMonstruo1, defensaMonstruo1, estrellasDeUnMonstruo);
		Atacable otroMonstruo = new CartaMonstruo(ataqueMonstruo2, defensaMonstruo2, estrellasDeUnMonstruo);

		Efecto efectoSogen = new EfectoSogen();//sogen aumenta los ptsdef de tus monstruos en 500
		CartaCampo sogen = new CartaCampo(efectoSogen);  // tambien los ptsatk de los monstruos enemigos en 200
		
		Jugador jugador1 = new Jugador();
		Jugador jugador2 = new Jugador();
		
		jugador1.enfrentarseA(jugador2);
		jugador2.enfrentarseA(jugador1);
		
		Modo modoAtaque = new ModoAtaque();
		EstadoCarta bocaArriba = new EstadoCartaColocadaBocaArriba();
		
		jugador1.colocar(unMonstruo, bocaArriba, modoAtaque);
		jugador2.colocar(otroMonstruo, bocaArriba, modoAtaque);
		jugador1.colocarCartaMagicaBocaArriba(sogen);
		
		jugador1.atacar(unMonstruo, otroMonstruo);
		
		int vidaEsperada = 7700;
		assertEquals(vidaEsperada, jugador2.obtenerVidaRestante());
	}
	
	@Test
	public void test16ActivarPotOfGreedPermiteLevantarDosCartasDelMazo() {

		Efecto efectoPotOfGreed = new EfectoPotOfGreed();//sogen aumenta los ptsdef de tus monstruos en 500
		CartaMagica potOfGreed = new CartaMagica(efectoPotOfGreed);  // tambien los ptsatk de los monstruos enemigos en 200
		
		Jugador jugador1 = new Jugador();
		Jugador jugador2 = new Jugador();
		
		jugador1.enfrentarseA(jugador2);
		jugador2.enfrentarseA(jugador1);
		
		jugador1.colocarCartaMagicaBocaArriba(potOfGreed);
		int cartasEnManoEperadas = 7;
		assertEquals(cartasEnManoEperadas, jugador1.obtenerCantidadDeCartasEnLaMano());
	}
	
//	@Test
//	public void test17ColocarFisuraBocaArribaConUnMonstruoEnAmbosCamposDestruyeAlDeMenorAtaque() {}
	
//	@Test
//	public void test18AtacarConJinzoRestaPuntosDeVidaDirectamenteAlOponente() {}
	
//	@Test
//	public void test19InvocarAlDragonDefinitivoSacrifica3Dragones() {}
	
//	@Test
//	public void test20InsectoBocaAbajoEnModoDefensaDestruyeAlAtacante() {}
	
//	@Test
//	public void test21CilindroDaniaDirectamenteAlOponenteAlSerAtacada() {}
	
	/* Coloco un monstruo en posición de ataque y la carta trampa Reinforcements de mi
	lado del campo, coloco un monstruo en el campo enemigo (con 400 puntos mas de
	ataque que el primero) y atacar al primer monstruo. Verificar que se activa la carta
	trampa, y el monstruo enemigo es destruido y se infligió 100 puntos de daño a la
	vida del otro jugador.*/	
//	@Test
//	public void test22() {}
	
//	@Test
//	public void test23ExtraerTodasLasCartasFinalizaPartida() {}
	
//	@Test
//	public void test24LasCincoPartesDeExodiaEnManoFinalizanPartida() {}
	
}
