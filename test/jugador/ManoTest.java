package jugador;


import static org.junit.Assert.assertEquals;

import java.util.LinkedList;

import org.junit.Test;
import carta.*;

public class ManoTest {

	@Test
	public void test01LaManoSeInicializaSinCartas () {
		
		Mano mano = new Mano();
		
		assertEquals( 0, mano.obtenerCantidadDeCartas() );
	}
	
	@Test
	public void test02CantidadDeCartasEnManoEsUnoAlAgregarCarta() {
		Mano mano = new Mano();
		Carta carta = new CartaMonstruo();
		
		mano.agregarCartaEnMano( carta );
	
		assertEquals( 1, mano.obtenerCantidadDeCartas() );
	}
	
	@Test
	public void test03CantidadDeCartasEnManoEsCorrectaAlAgregarVariasCartas() {
		Mano mano = new Mano();
		Carta carta1 = new CartaMonstruo();
		Carta carta2 = new CartaMonstruo();
		Carta carta3 = new CartaMonstruo();
		LinkedList<Carta> variasCartas = new LinkedList<Carta>();
		
		variasCartas.add( carta1 );
		variasCartas.add( carta2 );
		variasCartas.add( carta3 );
		
		mano.agregarCartasEnMano( variasCartas );
	
		assertEquals( variasCartas.size(), mano.obtenerCantidadDeCartas() );
	}
}
