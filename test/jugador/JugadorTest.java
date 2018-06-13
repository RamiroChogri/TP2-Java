package jugador;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class JugadorTest {

		@Test
		public void testSeCreaJugadorConUnCampoYNoTieneCartasEnLaMano() {
			Jugador jugador1 = new Jugador();
			
			assertEquals( 0, jugador1.cantidadDeCartasEnLaMano() );
		}
		
}
