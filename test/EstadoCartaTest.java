import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class EstadoTest {
	
	//EstadoCartaEnMazo
	
	@Test
	public void testEstadoCartaEnMazoEstaEnMazo() {
		EstadoCarta estado = new EstadoCartaEnMazo();
		assertEquals(true, estado.estaEnMazo());
	}
	
	@Test
	public void testEstadoCartaEnMazoNoEstaEnMano() {
		EstadoCarta estado = new EstadoCartaEnMazo();
		assertEquals(false, estado.estaEnMano());
	}
	
	@Test
	public void testEstadoCartaEnMazoNoEstaEnCementerio( ) {
		EstadoCarta estado = new EstadoCartaEnMazo();
		assertEquals(false, estado.estaEnCementerio());
	}
	
	@Test
	public void testEstadoCartaEnMazoNoEstaEnModoAtaque() {
		EstadoCarta estado = new EstadoCartaEnMazo();
		assertEquals(false, estado.estaEnModoAtaque());
	}
	
	@Test
	public void testEstadoCartaEnMazoNoEstaBocaArribaEnModoDefensa() {
		EstadoCarta estado = new EstadoCartaEnMazo();
		assertEquals(false, estado.estaBocaArribaEnModoDefensa());
	}
	
	@Test
	public void testEstadoCartaEnMazoNoEstaBocaAbajoEnModoDefensa() {
		EstadoCarta estado = new EstadoCartaEnMazo();
		assertEquals(false, estado.estaBocaAbajoEnModoDefensa());
	}
	
	@Test
	public void testEstadoCartaEnMazoNoEstaBocaArriba() {
		EstadoCarta estado = new EstadoCartaEnMazo();
		assertEquals(false, estado.estaBocaArriba());
	}
	
	@Test
	public void testEstadoCartaEnMazoNoEstaBocaAbajo() {
		EstadoCarta estado = new EstadoCartaEnMazo();
		assertEquals(false, estado.estaBocaAbajo());
	}
	
	//Seguir con resto de estados
	
}