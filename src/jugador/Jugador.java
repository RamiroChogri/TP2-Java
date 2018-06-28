package jugador;

import java.util.LinkedList;

import campo.*;
import cartas.*;
import exceptions.*;
import modos.*;
import efectos.Efecto;
import estadoCarta.*;

public class Jugador {

		private Campo campoPropio;
		private Campo campoEnemigo;
		private Mano mano;
		private int vida;
		private boolean tieneAExodiaEnMano;
		private String nombre;

	public Jugador() {
		
		this.mano = new Mano();
		this.campoPropio = new Campo(this);
		this.vida = 8000;
		this.tieneAExodiaEnMano = false;
		
	}
	
	public Jugador(Campo campoDelJugador) {
		this.mano = new Mano();
		this.campoPropio = campoDelJugador;
		this.vida = 8000;
		this.tieneAExodiaEnMano = false;
		
	}
	
	public void enfrentarseA(Jugador jugadorEnemigo) {
		
		jugadorEnemigo.setCampoEnemigo(this.campoPropio);
		for(int i=0;i<5;i++) {
			this.tomarCartaDelMazo();
		}
	
	}
	
	public void atacar(Atacable atacante, Atacable atacado) {
		
		try {
			Activable trampa = campoEnemigo.obtenerCartaTrampa();
			trampa.aplicarEfecto( campoPropio, campoEnemigo, atacante, atacado );
		}catch( NoHayCartasTrampaException e ) { };
		
		atacante.atacar(atacado);
		
		this.campoPropio.enviarCartasDestruidasAlCementerio();

		try {
			this.campoEnemigo.enviarCartasDestruidasAlCementerio();
		} catch (NullPointerException error) {
			throw new FaltaJugadorEnemigoException();
		}
	}
	
	public void atacar(Atacable atacante, Jugador atacado) {

		atacante.atacar(atacado);
		
		this.campoPropio.enviarCartasDestruidasAlCementerio();

		try {
			this.campoEnemigo.enviarCartasDestruidasAlCementerio();
		} catch (NullPointerException error) {
			throw new FaltaJugadorEnemigoException();
		}
	}
	
	public void setCampoEnemigo(Campo campo) {
		try {
			this.campoEnemigo = campo;
		} catch (NullPointerException error) {
			throw new FaltaJugadorEnemigoException();
		}
	}
	
	public int obtenerCantidadDeCartasEnLaMano() {
		
		return mano.obtenerCantidadDeCartas();
	}
	
	public void tomarCartaDelMazo() {
		try {
			try {
				mano.agregarCartaEnMano(campoPropio.levantarCartaDelMazo());
				this.tieneAExodiaEnMano = this.mano.tieneAExodia();
			
				if (tieneAExodiaEnMano) {
					campoEnemigo.obtenerDuenio().derrotarse();
				}
			
			} catch (NoQuedanCartasEnElMazoException error) {
				this.vida = 0;
			}

		} catch (NullPointerException error) {
			throw new FaltaJugadorEnemigoException();
		}
	}

	public boolean tieneVida(int vidaRecibida) {
		
		return (this.vida == vidaRecibida);
	}
	
	public void colocar(Atacable carta, EstadoCarta estado, Modo modo) {
		carta.cambiarA(modo);
		this.campoPropio.colocarCarta(carta, estado);
		this.campoPropio.enviarCartasDestruidasAlCementerio();
		
	}
	
	public void colocar(Colocable carta, EstadoCarta estado) {
		this.campoPropio.colocarCarta(carta, estado);
		
	}
	
	public void aplicarEfectoCarta(Activable carta) {
		carta.aplicarEfecto(this.campoPropio, this.campoEnemigo);
	}
	
	public boolean tieneCartasEnCampo() {
		
		return this.campoPropio.tieneCartas();
	}

	public int obtenerCantidadCartasEnCampo() {
		
		return campoPropio.obtenerCantidadDeCartasEnJuego();
	}
	
	public int obtenerCantidadCartasEnZonaMonstruos() {
		return campoPropio.obtenerCantidadDeCartasEnZonaMonstruos();
	}
	
	public int obtenerCantidadDeCartasEnZonaMagicasYTrampas() {
		return campoPropio.obtenerCantidadDeCartasEnZonaMagicasYTrampas();
	}
	
	public int obtenerCantidadDeCartasEnCementerio() {
		return campoPropio.obtenerCantidadDeCartasEnCementerio();
	}
	
	public void enviarCartasDestruidasAlCementerio() {
		campoPropio.enviarCartasDestruidasAlCementerio();
	}

	public void recibirAtaque(Atacable cartaAtacante) {
		
		if (campoPropio.obtenerCantidadDeCartasEnZonaMonstruos() > 0) {
			throw new NoSePuedeAtacarAlJugadorDirectamenteException();
		}
		
		Puntos puntosDeDanioRecibidos = cartaAtacante.obtenerPuntosAtaque();
		this.recibirAtaque( puntosDeDanioRecibidos.obtenerPuntosActuales() );
	}
	
	public void recibirAtaque(int danioRecibido) {
		this.vida -= danioRecibido;
	}
	
	public Jugador obtenerJugadorEnemigo() {
		try {
			return this.campoEnemigo.obtenerDuenio();
		} catch (NullPointerException error) {
			throw new FaltaJugadorEnemigoException();
		}
	}
	
	public int obtenerCartasMazo() {
		return this.campoPropio.obtenerCantidadDeCartasEnMazo();
	}
	
	public boolean estaDerrotado() {
		return (this.vida <= 0);
	}
	
	public boolean tieneAExodiaEnMano() {
		
		return this.tieneAExodiaEnMano;
	}
	
	public void derrotarse() {
		
		this.recibirAtaque(this.vida);
	
	}

	public void destruirCartaCampoEnemiga() {
		try {
			this.campoEnemigo.vaciarZonaCampo();
		} catch (NullPointerException error) {
			throw new FaltaJugadorEnemigoException();
		}
	}
	
	public void setName(String nombreAColocar) {
		this.nombre = nombreAColocar;
	}
	
	public String obtenerNombre() {
		return this.nombre;
	}
	
	public void voltearCarta(Atacable cartaAVoltear) {
		cartaAVoltear.voltear();
	}
	
	public void voltearCarta(Activable cartaAVoltear) {
		
		cartaAVoltear.voltear(this.campoPropio, this.campoEnemigo);
	}
	
	public Atacable obtenerCartaDeZonaMonstruo( String nombreCartaMonstruoAtacante ) {
		
		return campoPropio.obtenerCartaDeZonaMonstruo( nombreCartaMonstruoAtacante );
	}
	

	public Activable obtenerCartaDeZonaMagicasYTrampas( String nombreCartaActivable ) {
		
		return campoPropio.obtenerCartaDeZonaMagicasYTrampas( nombreCartaActivable );
	}
	
	///////////////////////////////////////
	
	public LinkedList<String> obtenerNombresDeCartasAtacablesEnMano() {
		return this.mano.obtenerNombresDeCartasAtacables();
	}
	
	public LinkedList<String> obtenerNombresDeCartasActivablesEnMano() {
		return this.mano.obtenerNombresDeCartasActivables();
	}
	
	public Colocable obtenerCartaDeMano(String nombreCarta) {
		return this.mano.obtenerCarta(nombreCarta);
	}

	public LinkedList<String> obtenerNombresDeCartasMagicasEnCampoPropio() {
		
		LinkedList<String> cartasMagicasActivables = this.campoPropio.obtenerNombresDeCartasMagicas();
		
		return cartasMagicasActivables;
	}
	
	public int obtenerVida() {
		return this.vida;
	}

	public LinkedList<String> obtenerNombresDeCartasAtacablesEnZonaMonstruos() {
		
		LinkedList<String> nombresDeAtacables = this.campoPropio.obtenerNombresDeCartasAtacables();
		
		return nombresDeAtacables;
	}
	
	public LinkedList<String> obtenerNombresDeCartasAtacablesEnModoAtaqueEnZonaMonstruos() {
		
		LinkedList<String> nombresDeAtacables = this.campoPropio.obtenerNombresDeCartasAtacablesEnModoAtaque();
		
		return nombresDeAtacables;
	}
	
	
	public void eliminarCartaDeLaMano(String nombreCartaElegida) {
		
		this.mano.eliminarCarta(nombreCartaElegida);
		
	}
	
	public LinkedList<Colocable> obtenerCartasEnMano() {
		return this.mano.obtenerCartas();
	}
	
	public LinkedList<Atacable> obtenerMonstruosColocados(){
		LinkedList<Atacable> monstruosColocados = new LinkedList<Atacable>();
		
		monstruosColocados = this.campoPropio.obtenerCartasEnZonaMonstruo();
		
		return monstruosColocados;
	}
	
	public LinkedList<Activable> obtenerMagicasYTrampasColocadas(){
		LinkedList<Activable> cartasColocadas = this.campoPropio.obtenerMagicasYTrampasColocadas();
		
		return cartasColocadas;
	}
	
	public LinkedList<Activable> obtenerCartaCampoColocada(){
		
		return this.campoPropio.obtenerCartaCampoColocada();
	}

	public String obtenerNombreDeLaImagenDeLaUltimaCartaDelCementerio() {
		return this.campoPropio.obtenerNombreDeLaImagenDeLaUltimaCartaDelCementerio();
	}
	
}