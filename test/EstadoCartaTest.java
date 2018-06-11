import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class EstadoCartaTest {
	
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
	
	//EstadoCartaEnMano
	
	@Test
	public void testEstadoCartaEnManoNoEstaEnMazo() {
		EstadoCarta estado = new EstadoCartaEnMano();
		assertEquals(false, estado.estaEnMazo());
	}
	
	@Test
	public void testEstadoCartaEnManoEstaEnMano() {
		EstadoCarta estado = new EstadoCartaEnMano();
		assertEquals(true, estado.estaEnMano());
	}
	
	@Test
	public void testEstadoCartaEnManoNoEstaEnCementerio() {
		EstadoCarta estado = new EstadoCartaEnMano();
		assertEquals(false, estado.estaEnCementerio());
	}
	
	@Test
	public void testEstadoCartaEnManoNoEstaEnModoAtaque() {
		EstadoCarta estado = new EstadoCartaEnMano();
		assertEquals(false, estado.estaEnModoAtaque());
	}
	
	@Test
	public void testEstadoCartaEnManoNoEstaBocaArribaEnModoDefensa() {
		EstadoCarta estado = new EstadoCartaEnMano();
		assertEquals(false, estado.estaBocaArribaEnModoDefensa());
	}
	
	@Test
	public void testEstadoCartaEnManoNoEstaBocaAbajoEnModoDefensa() {
		EstadoCarta estado = new EstadoCartaEnMano();
		assertEquals(false, estado.estaBocaAbajoEnModoDefensa());
	}
	
	@Test
	public void testEstadoCartaEnManoNoEstaBocaArriba() {
		EstadoCarta estado = new EstadoCartaEnMano();
		assertEquals(false, estado.estaBocaArriba());
	}
	
	@Test
	public void testEstadoCartaEnManoNoEstaBocaAbajo() {
		EstadoCarta estado = new EstadoCartaEnMano();
		assertEquals(false, estado.estaBocaAbajo());
	}
	
	//EstadoCartaEnCementerio
	
	@Test
	public void testEstadoCartaEnCementerioNoEstaEnMazo() {
		EstadoCarta estado = new EstadoCartaEnCementerio();
		assertEquals(false, estado.estaEnMazo());
	}
	
	@Test
	public void testEstadoCartaEnCementerioNoEstaEnMano() {
		EstadoCarta estado = new EstadoCartaEnCementerio();
		assertEquals(false, estado.estaEnMano());
	}
	
	@Test
	public void testEstadoCartaEnCementerioEstaEnCementerio() {
		EstadoCarta estado = new EstadoCartaEnCementerio();
		assertEquals(true, estado.estaEnCementerio());
	}
	
	@Test
	public void testEstadoCartaEnCementerioNoEstaEnModoAtaque() {
		EstadoCarta estado = new EstadoCartaEnCementerio();
		assertEquals(false, estado.estaEnModoDefensa());
	}
	
	@Test
	public void testEstadoCartaEnCementerioNoEstaBocaArribaEnModoDefensa() {
		EstadoCarta estado = new EstadoCartaEnCementerio();
		assertEquals(false, estado.estaBocaArribaEnModoDefensa());
	}
	
	@Test
	public void testEstadoCartaEnCementerioNoEstaBocaAbajoEnModoDefensa() {
		EstadoCarta estado = new EstadoCartaEnCementerio();
		assertEquals(false, estado.estaBocaAbajoEnModoDefensa());
	}
	
	@Test
	public void testEstadoCartaEnCementerioNoEstaBajoArriba() {
		EstadoCarta estado = new EstadoCartaEnCementerio();
		assertEquals(false, estado.estaBocaArriba());
	}
	
	@Test
	public void testEstadoCartaEnCementerioNoEstaBocaAbajo() {
		EstadoCarta estado = new EstadoCartaEnCementerio();
		assertEquals(false, estado.estaBocaAbajo());
	}
	
	//EstadoCartaEnModoAtaque
	
	@Test
	public void testEstadoCartaEnModoAtaqueNoEstaEnMazo() {
		EstadoCarta estado = new EstadoCartaEnModoAtaque();
		assertEquals(false, estado.estaEnMazo());
	}
	
	@Test
	public void testEstadoCartaEnModoAtaqueNoEstaEnMano() {
		EstadoCarta estado = new EstadoCartaEnModoAtaque();
		assertEquals(false, estado.estaEnMano());
	}
	
	@Test
	public void testEstadoCartaEnModoAtaqueNoEstaEnCementerio() {
		EstadoCarta estado = new EstadoCartaEnModoAtaque();
		assertEquals(false, estado.estaEnCementerio());
	}
	
	@Test
	public void testEstadoCartaEnModoAtaqueEstaEnModoAtaque() {
		EstadoCarta estado = new EstadoCartaEnModoAtaque();
		assertEquals(true, estado.estaEnModoAtaque());
	}
	
	@Test
	public void testEstadoCartaEnModoAtaqueNoEstaBocaArribaEnModoDefensa() {
		EstadoCarta estado = new EstadoCartaEnModoAtaque();
		assertEquals(false, estado.estaBocaArribaEnModoDefensa());
	}
	
	@Test
	public void testEstadoCartaEnModoAtaqueNoEstaBocaAbajoEnModoDefensa() {
		EstadoCarta estado = new EstadoCartaEnModoAtaque();
		assertEquals(false, estado.estaBocaAbajoEnModoDefensa());
	}
	
	@Test
	public void testEstadoCartaEnModoAtaqueNoEstaBocaArriba() {
		EstadoCarta estado = new EstadoCartaEnModoAtaque();
		assertEquals(false, estado.estaBocaArriba());
	}
	
	@Test
	public void testEstadoCartaEnModoAtaqueNoEstaBocaAbajo() {
		EstadoCarta estado = new EstadoCartaEnModoAtaque();
		assertEquals(false, estado.estaBocaAbajo());
	}
	
	//EstadoCartaBocaArribaEnModoDefensa
	
	@Test
	public void testEstadoCartaBocaArribaEnModoDefensaNoEstaEnMazo() {
		EstadoCarta estado = new EstadoCartaBocaArribaEnModoDefensa();
		assertEquals(false, estado.estaEnMazo());
	}
	
	@Test
	public void testEstadoCartaBocaArribaEnModoDefensaNoEstaEnMano() {
		EstadoCarta estado = new EstadoCartaBocaArribaEnModoDefensa();
		assertEquals(false, estado.estaEnMano());
	}
	
	@Test
	public void testEstadoCartaBocaArribaEnModoDefensaNoEstaEnCementerio() {
		EstadoCarta estado = new EstadoCartaBocaArribaEnModoDefensa();
		assertEquals(false, estado.estaEnCementerio());
	}
	
	@Test
	public void testEstadoCartaBocaArribaEnModoDefensaNoEstaEnModoAtaque() {
		EstadoCarta estado = new EstadoCartaBocaArribaEnModoDefensa();
		assertEquals(false, estado.estaEnModoAtaque());
	}
	
	@Test
	public void testEstadoCartaBocaArribaEnModoDefensaEstaBocaArribaEnModoDefensa() {
		EstadoCarta estado = new EstadoCartaBocaArribaEnModoDefensa();
		assertEquals(true, estado.estaBocaArribaEnModoDefensa());
	}
	
	@Test
	public void testEstadoCartaBocaArribaEnModoDefensaNoEstaBocaAbajoEnModoDefensa() {
		EstadoCarta estado = new EstadoCartaBocaArribaEnModoDefensa();
		assertEquals(false, estado.estaBocaAbajoEnModoDefensa());
	}
	
	//ASDASDASDASDASDASDASDASDASDAS
	//ASDASDASDASDASDASDASDASDASDASD
	//ASDASDASDASDASDASDASDASDASDASDAD
	//ASDASDASDASDASDASDASDASDASDASDASD
	
	@Test
	public void testEstadoCartaBocaArribaEnModoDefensaNoEstaBocaArriba() {
		EstadoCarta estado = new EstadoCartaBocaArribaEnModoDefensa();
		assertEquals(false, estado.estaBocaArriba());
	}
	
	//ASDASDASDASDASDASDASDASDASDASDASD
	//ASDASDASDASDASDASDASDASDASDASDAS
	//ASDASDASDASDASDASDASDASDASDASDA
	//ASDASDASDASDASDASDASDASDASDASD
	
	@Test
	public void testEstadoCartaBocaArribaEnModoDefensaNoEstaBocaAbajo() {
		EstadoCarta estado = new EstadoCartaBocaArribaEnModoDefensa();
		assertEquals(false, estado.estaBocaAbajo());
	}
	
	//EstadoCartaBocaAbajoEnModoDefensa
	
	@Test
	public void testEstadoCartaBocaAbajoEnModoDefensaNoEstaEnMazo() {
		EstadoCarta estado = new EstadoCartaBocaAbajoEnModoDefensa();
		assertEquals(false, estado.estaEnMazo());
	}
	
	@Test
	public void testEstadoCartaBocaAbajoEnModoDefensaNoEstaEnMano() {
		EstadoCarta estado = new EstadoCartaBocaAbajoEnModoDefensa();
		assertEquals(false, estado.estaEnMano());
	}
	
	@Test
	public void testEstadoCartaBocaAbajoEnModoDefensaNoEstaEnCementerio() {
		EstadoCarta estado = new EstadoCartaBocaAbajoEnModoDefensa();
		assertEquals(false, estado.estaEnCementerio());
	}
	
	@Test
	public void testEstadoCartaBocaAbajoEnModoDefensaNoEstaEnModoAtaque() {
		EstadoCarta estado = new EstadoCartaBocaAbajoEnModoDefensa();
		assertEquals(false, estado.estaEnModoAtaque());
	}
	
	@Test
	public void testEstadoCartaBocaAbajoEnModoDefensaNoEstaBocaArribaEnModoDefensa() {
		EstadoCarta estado = new EstadoCartaBocaAbajoEnModoDefensa();
		assertEquals(false, estado.estaBocaArribaEnModoDefensa());
	}
	
	@Test
	public void testEstadoCartaBocaAbajoEnModoDefensaEstaBocaAbajoEnModoDefensa() {
		EstadoCarta estado = new EstadoCartaBocaAbajoEnModoDefensa();
		assertEquals(true, estado.estaBocaAbajoEnModoDefensa());
	}
	
	@Test
	public void testEstadoCartaBocaAbajoEnModoDefensaNoEstaBocaArriba() {
		EstadoCarta estado = new EstadoCartaBocaAbajoEnModoDefensa();
		assertEquals(false, estado.estaBocaArriba());
	}
	
	@Test
	public void testEstadoCartaBocaAbajoEnModoDefensaNoEstaBocaAbajo() {
		EstadoCarta estado = new EstadoCartaBocaAbajoEnModoDefensa();
		assertEquals(false, estado.estaBocaAbajo());
	}
	
	//EstadoCartaBocaArriba
	
	@Test
	public void testEstadoCartaBocaArribaNoEstaEnMazo() {
		EstadoCarta estado = new EstadoCartaBocaArriba();
		assertEquals(false, estado.estaEnMazo());
	}
	
	@Test
	public void testEstadoCartaBocaArribaNoEstaEnMano() {
		EstadoCarta estado = new EstadoCartaBocaArriba();
		assertEquals(false, estado.estaEnMano());
	}
	
	@Test
	public void testEstadoCartaBocaArribaNoEstaEnCementerio() {
		EstadoCarta estado = new EstadoCartaBocaArriba();
		assertEquals(false, estado.estaEnCementerio());
	}
	
	@Test
	public void testEstadoCartaBocaArribaNoEstaEnModoAtaque() {
		EstadoCarta estado = new EstadoCartaBocaArriba();
		assertEquals(false, estado.estaEnModoAtaque());
	}
	
	@Test
	public void testEstadoCartaBocaArribaNoEstaBocaArribaEnModoDefensa() {
		EstadoCarta estado = new EstadoCartaBocaArriba();
		assertEquals(false, estado.estaBocaArribaEnModoDefesa());
	}
	
	@Test
	public void testEstadoCartaBocaArribaNoEstaBocaAbajoEnModoDefensa() {
		EstadoCarta estado = new EstadoCartaBocaArriba();
		assertEquals(false, estado.estaBocaAbajoEnModoDefensa());
	}
	
	@Test
	public void testEstadoCartaBocaArribaEstaBocaArriba() {
		EstadoCarta estado = new EstadoCartaBocaArriba();
		assertEquals(true, estado.estaBocaArriba());
	}
	
	@Test
	public void testEstadoCartaBocaArribaNoEstaBocaAbajo() {
		EstadoCarta estado = new EstadoCartaBocaArriba();
		assertEquals(false, estado.estaBocaAbajo();
	}
	
	//EstadoCartaBocaAbajo
	
	@Test
	public void testEstadoCartaBocaAbajoNoEstaEnMazo() {
		EstadoCarta estado = new EstadoCartaBocaAbajo();
		assertEquals(false, estado.estaEnMazo());
	}
	
	@Test
	public void testEstadoCartaBocaAbajoNoEstaEnMano() {
		EstadoCarta estado = new EstadoCartaBocaAbajo();
		assertEquals(false, estado.estaEnMano());
	}
	
	@Test
	public void testEstadoCartaBocaAbajoNoEstaEnCementerio() {
		EstadoCarta estado = new EstadoCartaBocaAbajo();
		assertEquals(false, estado.estaEnCementerio());
	}
	
	@Test
	public void testEstadoCartaBocaAbajoNoEstaEnModoAtaque() {
		EstadoCarta estado = new EstadoCartaBocaAbajo();
		assertEquals(false, estado.estaEnModoAtaque());
	}
	
	@Test
	public void testEstadoCartaBocaAbajoNoEstaBocaArribaEnModoDefensa() {
		EstadoCarta estado = new EstadoCartaBocaAbajo();
		assertEquals(false, estado.estaBocaArribaEnModoDefensa());
	}
	
	@Test
	public void testEstadoCartaBocaAbajoNoEstaBocaAbajoEnModoDefensa() {
		EstadoCarta estado = new EstadoCartaBocaAbajo();
		assertEquals(false, estado.estaBocaAbajoEnModoDefensa());
	}
	
	@Test
	public void testEstadoCartaBocaAbajoNoEstaBocaArriba() {
		EstadoCarta estado = new EstadoCartaBocaAbajo();
		assertEquals(false, estado.estaBocaArriba());
	}
	
	@Test
	public void testEstadoCartaBocaAbajoEstaBocaAbajo() {
		EstadoCarta estado = new EstadoCartaBocaAbajo();
		assertEquals(true, estado.estaBocaAbajo());
	}
	
}
