import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

import modos.*;
import campo.Campo;
import cartas.*;
import efectos.*;
import estadoCarta.*;
import jugador.Jugador;
import exceptions.*;
import factories.CartaMonstruoFactory;
import factories.CartaTrampaFactory;
import invocacionStrategy.ReglaDeMonstruoGrandeStrategy;


public class EnunciadoTest {
	
	
	//Colocar una carta de monstruo en posiciÃ³n de ataque.
	@Test
	public void test01ColocarCartaMonstruoEnModoAtaque() {			
		//Agregada nueva clase "puntos" en carta para el manejo de puntos de ataque y defensa
		//en cartas monstruo
		//Agregado nuevo EstadoCartaInvocada (No tiene nada implementado)
		//Agregadas clases Estrategias y Modos (no implementados, deben relacionarse con el
		//campo todavia)	
		//Falta cambiar todo lo que diga "Utilizable" por "Activable"
		
		Jugador jugador1 = new Jugador();
		Jugador jugador2 = new Jugador();
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
		
		jugador1.enfrentarseA(jugador2);
		jugador2.enfrentarseA(jugador1);
		
		jugador1.colocar(monstruoPropio, bocaArriba, modoAtaque);
		jugador2.colocar(monstruoEnemigo, bocaArriba, modoAtaque);
		
		monstruoPropio.atacar(monstruoEnemigo);
		jugador2.enviarCartasDestruidasAlCementerio();
		
		//Como esta en modo ataque y tiene mas puntos de ataque que la carta enemiga la mata
		//y la envia al cementerio <--- Esta bien que tenga que aclarar que es lo que esta
		//pasando? El codigo deberia ser mas claro o el comentario sobra?
		
		assertEquals( 1, jugador2.obtenerCantidadDeCartasEnCementerio() );
		
		
		
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

		//CartaEnModoDefensaNoPuedeAtacar
		//cambia algo el que este boca abajo? Que comportamiento le agrega?
		
		Jugador jugador1 = new Jugador();
		Jugador jugador2 = new Jugador();
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
		
		jugador1.enfrentarseA(jugador2);
		jugador2.enfrentarseA(jugador1);
		
		jugador1.colocar(monstruoPropio, bocaAbajo, modoDefensa);
		jugador2.colocar(monstruoEnemigo, bocaArriba, modoAtaque);
		
		
		try {
			monstruoPropio.atacar(monstruoEnemigo);
		} catch (MonstruoEnModoDefensaNoPuedeAtacarException error) {
			huboExcepcion = true;
		}
		
		assertTrue(huboExcepcion);
		
	}
	
	@Test
	public void test03ColocarCartaMagicaEnCampoBocaAbajo() {
		
		Jugador jugador = new Jugador();
		Efecto efectoNulo = new EfectoNulo();
		Activable cartaMagica = new CartaMagica(efectoNulo);
		EstadoCarta bocaAbajo = new EstadoCartaColocadaBocaAbajo();
		boolean huboExcepcion = false;
		
		jugador.colocar(cartaMagica, bocaAbajo);
		
		try {
			jugador.aplicarEfectoCarta(cartaMagica);
		} catch (CartaBocaAbajoNoPuedeActivarEfectoException error) {
			huboExcepcion = true;
		}
		
		assertTrue(huboExcepcion);
	}
	
	@Test
	public void test04ColocarCartaTrampaEnCampoBocaAbajo() {

		Jugador jugador = new Jugador();
		Efecto efectoNulo = new EfectoNulo();
		Activable cartaTrampa = new CartaTrampa(efectoNulo);
		EstadoCarta bocaAbajo = new EstadoCartaColocadaBocaAbajo();
		jugador.colocar(cartaTrampa, bocaAbajo);
		
		assertEquals(1, jugador.obtenerCantidadDeCartasEnZonaMagicasYTrampas() );
	}
	
	@Test
	public void test05MandarCartaAlCementerio() {
		
		Jugador jugador = new Jugador();
		Efecto efectoNulo = new EfectoNulo();
		Activable cartaMagica = new CartaMagica(efectoNulo);
		EstadoCarta bocaAbajo = new EstadoCartaColocadaBocaAbajo();
				
		jugador.colocar(cartaMagica, bocaAbajo);
		cartaMagica.destruirCarta();
		jugador.enviarCartasDestruidasAlCementerio();
		
		assertEquals( 1, jugador.obtenerCantidadDeCartasEnCementerio() );
		
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
		Puntos ataqueMonstruo1 = new Puntos(1000);
		Puntos defensaMonstruo1 = new Puntos(3000);
		
		Puntos ataqueMonstruo2 = new Puntos(1000);
		Puntos defensaMonstruo2 = new Puntos(2000);
		
		int estrellas = 3;
		CartaMonstruo monstruoConMilDeAtaque = new CartaMonstruo(ataqueMonstruo1, defensaMonstruo1, estrellas);
 		CartaMonstruo otroMonstruoConMilDeAtaque = new CartaMonstruo(ataqueMonstruo2, defensaMonstruo2, estrellas);
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
 		Activable agujeroNegro = new CartaMagica( agujeroNegroEfecto );
 		
		jugador1.enfrentarseA(jugador2);
		jugador2.enfrentarseA(jugador1);
		
		Modo modoAtaque = new ModoAtaque();
		Modo modoDefensa = new ModoDefensa();
		EstadoCarta bocaArriba = new EstadoCartaColocadaBocaArriba();
		jugador1.colocar(unMonstuo, bocaArriba, modoAtaque);
 		jugador2.colocar(otroMonstruo, bocaArriba, modoDefensa);
 		jugador1.colocar(agujeroNegro, bocaArriba);
 		
 		assertFalse( jugador1.tieneCartasEnCampo());
 		assertFalse( jugador2.tieneCartasEnCampo());
	}
	
	/*Se coloca un monstruo en el campo, se quiere colocar un monstruo de 5 o 6
	estrellas que requiere sacrificio. se verifica que se convocÃ³ al monstruo y se
	destruyÃ³ el primero.*/
	@Test
	public void test12ColocarMonstruoQueRequiereUnSacrificioDestruyeElMonstruoAnterior() {
		CartaMonstruoFactory fabrica = new CartaMonstruoFactory();
		
		Atacable unMonstruo = fabrica.crearHeroeElementalAvian();
 		Atacable unMonstruode6Estrellas = fabrica.crearEspadachinVengador();
 		
 		Atacable unSacrificio = fabrica.crearConejoOscuro();
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
		CartaMonstruoFactory fabrica = new CartaMonstruoFactory();
		Atacable unMonstruo = fabrica.crearDragonDeBrillo();
 		Atacable unMonstruoDe7Estrellas = fabrica.crearMagoOscuro();
 		
 		Atacable unSacrificio = fabrica.crearBetaElGuerreroMagnetico();
 		Atacable otroSacrificio = fabrica.crearDuendeMistico();
		Jugador jugador1 = new Jugador();
		Jugador jugador2 = new Jugador();
		
		jugador1.enfrentarseA(jugador2);
		jugador2.enfrentarseA(jugador1);
		
		Modo modoAtaque = new ModoAtaque();
		EstadoCarta bocaArriba = new EstadoCartaColocadaBocaArriba();
		jugador1.colocar(unSacrificio, bocaArriba, modoAtaque);
		jugador1.colocar(otroSacrificio, bocaArriba, modoAtaque);
		jugador1.colocar(unMonstruoDe7Estrellas,bocaArriba, modoAtaque);
 		jugador2.colocar(unMonstruo, bocaArriba, modoAtaque);
 		
 		jugador1.atacar(unMonstruoDe7Estrellas, unMonstruo);
 		
 		int vidaEsperada = 7400;
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
	public void test15ColocarSogenBocaArribaConUnMonstruoEnAmbosCampos() {
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
	
	@Test
	public void test16ActivarPotOfGreedPermiteLevantarDosCartasDelMazo() {

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
	public void test17ColocarFisuraBocaArribaConUnMonstruoEnAmbosCamposDestruyeAlDeMenorAtaque() {
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
		assertFalse(monstruoCon1100DeAtaque.estaDestruida());
		assertFalse(monstruoCon1700DeAtaque.estaDestruida());
		
	}
	
	@Test
	public void test18AtacarConJinzoRestaPuntosDeVidaDirectamenteAlOponente() {
		CartaMonstruoFactory fabrica = new CartaMonstruoFactory();
		
		Atacable jinzo7 = fabrica.crearJinzo7();
		Atacable monstruoCon1700DeAtaque = fabrica.crearBueyDeBatalla();
 		Atacable monstruoCon1100DeAtaque = fabrica.crearConejoOscuro();
 		
 		Jugador jugador1 = new Jugador();
		Jugador jugador2 = new Jugador();
		
		jugador1.enfrentarseA(jugador2);
		jugador2.enfrentarseA(jugador1);
		
		Modo modoAtaque = new ModoAtaque();
		EstadoCarta bocaArriba = new EstadoCartaColocadaBocaArriba();
		jugador1.colocar(jinzo7, bocaArriba, modoAtaque);
		jugador2.colocar(monstruoCon1700DeAtaque, bocaArriba, modoAtaque);
		jugador2.colocar(monstruoCon1100DeAtaque, bocaArriba, modoAtaque);
		
		//Si no es jinzo7 debe tirar excepcion de que hay cartas monstruo vivas en el
		//tablero enemigo que deben destruirse antes de poder atacar directamente al 
		//jugador enemigo
		jugador1.atacar(jinzo7, jugador2);
		
		int vidaEsperada = 7500;
		assertEquals(vidaEsperada, jugador2.obtenerVidaRestante());
	}
	
	@Test
	public void test19InvocarAlDragonDefinitivoSacrificando3DragonesBlancos() {
		CartaMonstruoFactory fabrica = new CartaMonstruoFactory();
		
		Atacable primerDragonBlancoDeOjosAzules = fabrica.crearDragonBlancoDeOjosAzules();
		Atacable segundoDragonBlancoDeOjosAzules = fabrica.crearDragonBlancoDeOjosAzules();
		Atacable tercerDragonBlancoDeOjosAzules = fabrica.crearDragonBlancoDeOjosAzules();
		Atacable dragonDefinitivo = fabrica.crearDragonDefinitivoDeOjosAzules();
		
		Jugador jugador1 = new Jugador();
		Jugador jugador2 = new Jugador();
		
		jugador1.enfrentarseA(jugador2);
		jugador2.enfrentarseA(jugador1);
		
		EstadoCarta bocaArriba = new EstadoCartaColocadaBocaArriba();
		Modo modoDeAtaque = new ModoAtaque();
		
		jugador1.colocar(fabrica.crearConejoOscuro(), bocaArriba, modoDeAtaque);
		jugador1.colocar(fabrica.crearJineteVorse(), bocaArriba, modoDeAtaque);
		jugador1.colocar(primerDragonBlancoDeOjosAzules, bocaArriba, modoDeAtaque);
		
		jugador1.colocar(fabrica.crearConejoOscuro(), bocaArriba, modoDeAtaque);
		jugador1.colocar(fabrica.crearDuendeMistico(), bocaArriba, modoDeAtaque);
		jugador1.colocar(segundoDragonBlancoDeOjosAzules, bocaArriba, modoDeAtaque);
		
		jugador1.colocar(fabrica.crearBueyDeBatalla(), bocaArriba, modoDeAtaque);
		jugador1.colocar(fabrica.crearDragonDeBrillo(), bocaArriba, modoDeAtaque);
		jugador1.colocar(tercerDragonBlancoDeOjosAzules, bocaArriba, modoDeAtaque);
		
		jugador1.colocar(dragonDefinitivo, bocaArriba, modoDeAtaque);
		
		jugador1.atacar(dragonDefinitivo, jugador2);
		
		int vidaEsperada =3500;
		
		assertEquals(vidaEsperada, jugador2.obtenerVidaRestante());
	}
	
	@Test
	public void test20InsectoBocaAbajoEnModoDefensaDestruyeAlAtacante() {
		CartaMonstruoFactory fabrica = new CartaMonstruoFactory();
		Jugador jugador1 = new Jugador();
		Jugador jugador2 = new Jugador();
		
		jugador1.enfrentarseA(jugador2);
		jugador2.enfrentarseA(jugador1);
		
		Atacable insectoComeHombres = fabrica.crearInsectoComeHombres();
		Atacable damaArpia = fabrica.crearDamaArpia();
		
		EstadoCarta bocaAbajo = new EstadoCartaColocadaBocaAbajo();
		EstadoCarta bocaArriba = new EstadoCartaColocadaBocaArriba();
		
		jugador1.colocar(insectoComeHombres, bocaAbajo, new ModoDefensa() );
		jugador2.colocar(damaArpia, bocaArriba, new ModoAtaque() );
		
		jugador2.atacar(damaArpia ,insectoComeHombres);
		
		int vidaEsperada = 8000;
		
		assertEquals(1 , jugador1.obtenerCantidadCartasEnZonaMonstruos());
		assertEquals (0, jugador2.obtenerCantidadCartasEnZonaMonstruos());
		assertEquals(vidaEsperada, jugador1.obtenerVidaRestante() );
		assertEquals(vidaEsperada, jugador2.obtenerVidaRestante() );
}
	
	@Test
	public void test21CilindroDaniaDirectamenteAlOponenteAlSerAtacada() {
		
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
		assertEquals(8000, jugador2.obtenerVidaRestante());
		assertFalse(monstruo1.estaDestruida());
		assertFalse(monstruo2.estaDestruida());
		assertTrue(cilindroMagico.estaDestruida());
		
	}
	
	/* Coloco un monstruo en posición de ataque y la carta trampa Reinforcements de mi
	lado del campo, coloco un monstruo en el campo enemigo (con 400 puntos mas de
	ataque que el primero) y atacar al primer monstruo. Verificar que se activa la carta
	trampa, y el monstruo enemigo es destruido y se infligió 100 puntos de daño a la
	vida del otro jugador.*/	
	@Test
	public void test22UnMonstruoEsAtacadoYSeActivaReinforcementsElAtacanteEsDestruido() {
		
		
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
		assertFalse(monstruo1.estaDestruida());
		assertTrue(monstruo2.estaDestruida());
		assertTrue(refuerzos.estaDestruida());
		
	}
	
	@Test
	public void test23ExtraerTodasLasCartasFinalizaPartida() {
		Jugador jugador = new Jugador();
		Jugador jugadorEnemigo = new Jugador();
		
		jugador.enfrentarseA(jugadorEnemigo);
		jugadorEnemigo.enfrentarseA(jugador);
		
		for(int i=0; i<36; i++) {
			jugador.tomarCartaDelMazo();
		}
		
		int cartasManoEsperadas = 40;
		assertEquals(cartasManoEsperadas, jugador.obtenerCantidadDeCartasEnLaMano());
		assertTrue(jugador.estaDerrotado());
	}
	
	@Test
	public void test24LasCincoPartesDeExodiaEnManoFinalizanPartida() {
		Jugador jugador1 = new Jugador();
		Jugador jugador2 = new Jugador();
		
		jugador1.enfrentarseA(jugador2);
		jugador2.enfrentarseA(jugador1);
		
		for(int i=0; i<35; i++) {
			jugador1.tomarCartaDelMazo();
		}
		
		int cartasManoEsperadas = 40;
		assertEquals(cartasManoEsperadas, jugador1.obtenerCantidadDeCartasEnLaMano());
		assertTrue(jugador1.tieneAExodiaEnMano());
		assertFalse(jugador1.estaDerrotado());
		assertTrue(jugador2.estaDerrotado());
		
	}
	
}
