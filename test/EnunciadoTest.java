import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

import estrategias.*;
import modos.*;
import campo.Campo;
import cartas.*;
import efectos.EfectoAgujeroNegro;
import jugador.Jugador;


public class EnunciadoTest {
	
	
	//Colocar una carta de monstruo en posición de ataque.
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
		int puntosDeAtaqueCartaMonstruo = 1000;
		int puntosDeDefensaCartaMonstruo = 500;
		Atacable cartaMonstruoPropia = new CartaMonstruo(puntosDeAtaqueCartaMonstruo, puntosDeDefensaCartaMonstruo);
		Atacable cartaMonstruoEnemiga = new CartaMonstruo(puntosDeAtaqueCartaMonstruo - 100, puntosDeDefensaCartaMonstruo - 100);
		Modo modoAtaque = new ModoAtaque();
		Estrategia bocaArriba = new EstrategiaBocaArriba();
		//campo recibe estrategia y modo
		campoPropio.colocarCarta(cartaMonstruoPropia, bocaArriba, modoAtaque);
		campoEnemigo.colocarCarta(cartaMonstruoEnemiga, bocaArriba, modoAtaque);
		
		cartaMonstruoPropia.atacar(cartaMonstruoEnemiga);
		campoEnemigo.enviarCartasDestruidasAlCementerio();
		
		//Como esta en modo ataque y tiene mas puntos de ataque que la carta enemiga la mata
		//y la envia al cementerio <--- Esta bien que tenga que aclarar que es lo que esta
		//pasando? El codigo deberia ser mas claro o el comentario sobra?
		
		assertEquals( 1, campoEnemigo.obtenerCantidadDeCartasEnCementerio() );
		
		
		
		//REPENSAR ESTE TESTS ( Y LOS PARECIDOS ) SE DEBE TESTEAR COMPORTAMIENTO
		
		//-Hay que rehacer "EstadoCarta", separar en "POSICION-BOCAARRIBA/ABAJO-ATAQUE/DEFENSA"
		//-Colocar en modo ataque implica que puede atacar
		//-Puntos de ataque/defensa que no sean integers el comportamiento que podrían tener
		// para que no sean solo clases contenedoras es el de aumentar/decrementar su valor 
		// hasta que "pase el turno" (es decir, se puede hacer que cuando se construya tenga
		// un valor original y posea un metodo que sea "aumentarEn(puntosExtra)" y otro que
		// sea "eliminarAumento" o algo del estilo)
		//-Les convence una clase que sea "ModoDeCartaMonstruo"? O es muy especifica?
		//
	}
	
	@Test
	public void test02ColocarMonstruoBocaAbajoEnModoDefensa() {
		Campo campoTest = new Campo();
		CartaMonstruo cartaMonstruo = new CartaMonstruo();
		cartaMonstruo.colocarBocaAbajoEnModoDefensa();
		
		campoTest.colocarCarta(cartaMonstruo);
		
		assertEquals(1,campoTest.obtenerCantidadDeCartasEnZonaMonstruo());
		assertTrue( cartaMonstruo.estaColocadaBocaAbajoEnModoDefensa() );
		
	}
	
	@Test
	public void test03ColocarCartaMagicaEnCampoBocaAbajo() {
		
		CartaMagica cartaMagica = new CartaMagica();
		Campo campo = new Campo();
		cartaMagica.colocarBocaAbajo();
		campo.colocarCarta(cartaMagica);
		assertEquals(1, campo.obtenerCantidadDeCartasEnZonaUtilidad() );
		assertTrue(cartaMagica.estaColocadaBocaAbajo());
	}
	
	@Test
	public void test04ColocarCartaTrampaEnCampoBocaAbajo() {
		
		CartaTrampa cartaTrampa = new CartaTrampa();
		Campo campoTest = new Campo();
		cartaTrampa.colocarBocaAbajo();
		campoTest.colocarCarta(cartaTrampa);
		
		assertEquals(1, campoTest.obtenerCantidadDeCartasEnZonaUtilidad() );
		assertTrue(cartaTrampa.estaColocadaBocaAbajo());
	}
	
	@Test
	public void test05MandarCartaAlCementerio() {
		
		CartaTrampa cartaTrampa = new CartaTrampa();
		Campo campo = new Campo();

		campo.colocarCarta( cartaTrampa );
		cartaTrampa.destruirCarta();
		campo.enviarCartasDestruidasAlCementerio();
		
		assertEquals( 1, campo.obtenerCantidadDeCartasEnCementerio() );
		
	}
	
	/*Colocar una carta de monstruo en posicion de ataque, el oponente coloca otra carta
de monstruo en posicion de ataque (con mayor ataque). Atacar al primer monstruo y
verificar que este se destruyo, y sufro danio a los puntos de vida igual a la diferencia
de los puntos de ataque de los monstruos*/

	@Test
	public void test06MonstruoAtacaAOtroMonstruoEnModoAtaqueConMenorAtaque() {
		CartaMonstruo monstruoConMayorAtaque = new CartaMonstruo(2000, 3000);
		CartaMonstruo monstruoConMenorAtaque = new CartaMonstruo(1000, 2000);
		Jugador jugador1 = new Jugador();
		Jugador jugador2 = new Jugador();
		
		jugador1.enfrentarseA(jugador2);
		jugador2.enfrentarseA(jugador1);
 		
 		jugador1.colocarMonstruoEnModoAtaque(monstruoConMayorAtaque);
 		jugador2.colocarMonstruoEnModoAtaque(monstruoConMenorAtaque);
 		
 		jugador1.atacar(monstruoConMayorAtaque, monstruoConMenorAtaque);
 		
		int vidaEsperada = 7000;
		
		assertFalse(monstruoConMayorAtaque.estaDestruida());
		assertTrue(monstruoConMenorAtaque.estaDestruida());
		
		assertEquals(vidaEsperada , jugador2.obtenerVidaRestante());
	
	}
 /*	Colocar una carta de monstruo en posici�n de ataque, el oponente coloca otra carta
	de monstruo en posici�n de ataque (con menor ataque), atacar al primer monstruo,
	el monstruo atacante es destruido y el atacante recibe da�o a los
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
	Colocar una carta de monstruo en posici�n de ataque, el oponente coloca otra carta
	de monstruo en posici�n de ataque (con igual ataque), atacar al primer monstruo,
	ambos monstruos son destruidos y nadie recibe da�o a los puntos de
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
	
	/*Colocar una carta de monstruo en posición de defensa, el oponente coloca otra carta
	de monstruo en posición de ataque (con mayor ataque que la defensa del primer
	monstruo), atacar al primer monstruo y verificar que este se destruyó y no sufrió
	ningún daño vital.*/
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
	
	/*Colocar una carta de monstruo en posición de defensa, el oponente coloca otra carta
	de monstruo en posición de ataque (con menor ataque que la defensa del primer
	monstruo), atacar al primer monstruo y verificar que este no se destruyó y no sufrió
	ningún daño vital.*/
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
	
	/*Colocar monstruos en ambos lados del campo. Colocar “Agujero negro” boca arriba
	(es decir, se activa el efecto). Verificar que se destruyeron todos los monstruos de
	ambos lados del campo, y que nadie recibió daño alguno.*/
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
	estrellas que requiere sacrificio. se verifica que se convocó al monstruo y se
	destruyó el primero.*/
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
	
	/*Se colocan 2 monstruos en el campo, se quiere colocar un monstruo de 7 o más
	estrellas que requiere 2 sacrificios. 
	se verifica que se convocó al monstruo y sedestruyeron los demás. */
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
