package invocacionStrategy;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import cartas.Atacable;
import factories.CartaMonstruoFactory;
import jugador.Jugador;
import modos.*;
import estadoCarta.*;

public class ReglaMonstruoStrategyTest {
	
	@Test
	public void testColocar1MonstruoDe4EstrellasQuedaColocado() {
		CartaMonstruoFactory fabrica = new CartaMonstruoFactory();
		
		Atacable jineteVorse = fabrica.crearJineteVorse();
		Atacable duendeMistico = fabrica.crearDuendeMistico();
		
		Jugador jugador1 = new Jugador();
		jugador1.colocar( jineteVorse, new EstadoCartaColocadaBocaArriba(), new ModoAtaque() );
		jugador1.colocar(duendeMistico, new EstadoCartaColocadaBocaArriba(), new ModoDefensa());
		
		
		assertEquals(2, jugador1.obtenerCantidadCartasEnCampo());
	}
	
	@Test
	public void testColocarUnMonstruoDe5EstrellasYElOtroSeSacrifica() {
		CartaMonstruoFactory fabrica = new CartaMonstruoFactory();
		
		Atacable jineteVorse = fabrica.crearJineteVorse();
		Atacable craneoConvocado = fabrica.crearCraneoConvocado();
		
		Jugador jugador1 = new Jugador();
		jugador1.colocar( jineteVorse, new EstadoCartaColocadaBocaArriba(), new ModoAtaque() );
		jugador1.colocar(craneoConvocado, new EstadoCartaColocadaBocaArriba(), new ModoDefensa());
		
		assertEquals(1, jugador1.obtenerCantidadCartasEnCampo());		
	}

	@Test
	public void testColocarDosMonstruosYDespuesUnoDe6EstrellasYQuedanDosMonstruosEnCampo() {
		CartaMonstruoFactory fabrica = new CartaMonstruoFactory();
		
		Atacable duendeMistico = fabrica.crearDuendeMistico();
		Atacable espadachinVengador = fabrica.crearEspadachinVengador();
		Atacable beta = fabrica.crearBetaElGuerreroMagnetico();
		
		Jugador jugador1 = new Jugador();
		jugador1.colocar( duendeMistico, new EstadoCartaColocadaBocaArriba(), new ModoAtaque() );
		jugador1.colocar(beta, new EstadoCartaColocadaBocaAbajo(), new ModoDefensa());
		jugador1.colocar( espadachinVengador, new EstadoCartaColocadaBocaArriba(), new ModoAtaque() );
		
		assertEquals(2, jugador1.obtenerCantidadCartasEnCampo());		
	}
	
	@Test
	public void testColocarDosMonstruosYOtroQueRequiereDosSacrificiosSeSacrificanLosDos() {
		CartaMonstruoFactory fabrica = new CartaMonstruoFactory();
		
		Atacable beta = fabrica.crearBetaElGuerreroMagnetico();
		Atacable conejo = fabrica.crearConejoOscuro();
		Atacable zoa = fabrica.crearZoa();
		
		Jugador jugador1 = new Jugador();
		jugador1.colocar( beta, new EstadoCartaColocadaBocaArriba(), new ModoAtaque() );
		jugador1.colocar( conejo, new EstadoCartaColocadaBocaArriba(), new ModoAtaque() );
		jugador1.colocar( zoa, new EstadoCartaColocadaBocaAbajo(), new ModoDefensa() );

		assertEquals (2, jugador1.obtenerCantidadDeCartasEnCementerio() );
	}
	
	@Test
	public void testColocarTresMonstruosYOtroQueRequiereDosSacrificiosYQuedanDosColocados() {
		CartaMonstruoFactory fabrica = new CartaMonstruoFactory();
		
		Atacable buey = fabrica.crearBueyDeBatalla();
		Atacable jineteVorse = fabrica.crearJineteVorse();
		Atacable damaArpia = fabrica.crearDamaArpia();
		Atacable magoOscuro = fabrica.crearZoa();
		
		Jugador jugador1 = new Jugador();
		jugador1.colocar( buey, new EstadoCartaColocadaBocaArriba(), new ModoAtaque() );
		jugador1.colocar( jineteVorse, new EstadoCartaColocadaBocaArriba(), new ModoAtaque() );
		jugador1.colocar( damaArpia, new EstadoCartaColocadaBocaAbajo(), new ModoDefensa() );
		
		jugador1.colocar(magoOscuro, new EstadoCartaColocadaBocaAbajo(), new ModoAtaque());

		assertEquals( 2, jugador1.obtenerCantidadCartasEnCampo() );
	}
	
}
