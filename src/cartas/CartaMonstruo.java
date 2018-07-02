package cartas;

import estadoCarta.*;
import exceptions.CartaBocaArribaNoSePuedeVoltearException;
import exceptions.MonstruoEnModoDefensaNoPuedeAtacarException;
import exceptions.NoHayEspacioEnElCampoException;
import exceptions.ZonaMonstruoLlenaException;
import invocacionStrategy.*;
import javafx.scene.image.ImageView;
import jugador.Jugador;
import modos.*;
import partida.Partida;
import view.CajaCampo;
import view.CajaConsola;
import view.ContenedorDelDuelo;
import view.handlers.ClickEnCartaEnZonaMonstruoHandler;

import java.util.LinkedList;
import java.util.Scanner;

import campo.*;

public class CartaMonstruo implements Atacable{
	
	private EstadoCarta estado;
	private Modo modo;
	private Puntos puntosDeAtaque;
	private Puntos puntosDeDefensa;
	private int estrellas;
	private String nombre;
	private ReglaDeInvocacionStrategy regla;
	private Scanner teclado;
	private String nombreImagen;
	private boolean atacoEsteTurno;
	private boolean seCambioElEstadoEsteTurno;
	
	public CartaMonstruo() {
		
		//por defecto en el mazo
		this.estado = new EstadoCartaNoJugada(); 
		this.puntosDeAtaque = new Puntos(1000);
		this.puntosDeDefensa = new Puntos(700);
		this.estrellas = 3;
		this.nombre = "MonstruoGenericoACME";
		this.regla = new ReglaDeMonstruoChicoStrategy();
		this.teclado = new Scanner(System.in);
		this.nombreImagen = " ";
		this.atacoEsteTurno = false;
		this.seCambioElEstadoEsteTurno = false;
	}
	
	public CartaMonstruo(Puntos puntosDeAtaqueAColocar, Puntos puntosDeDefensaAColocar, int estrellasAColocar) {
		this.puntosDeAtaque = puntosDeAtaqueAColocar;
		this.puntosDeDefensa = puntosDeDefensaAColocar;
		this.estado = new EstadoCartaNoJugada();
		this.estrellas = estrellasAColocar;
		this.nombre = "MonstruoGenericoACME";
		this.modo = new ModoAtaque();
		this.regla = new ReglaDeMonstruoChicoStrategy();
		this.nombreImagen = " ";
		this.teclado = new Scanner(System.in);
		this.atacoEsteTurno = false;
		this.seCambioElEstadoEsteTurno = false;
	}
	
	///////constructor que recibe la regla para colocarse ////////
	public CartaMonstruo(Puntos puntosDeAtaqueAColocar, Puntos puntosDeDefensaAColocar,
				int estrellasAColocar, ReglaDeInvocacionStrategy reglaDeInvocacion) {
		this.puntosDeAtaque = puntosDeAtaqueAColocar;
		this.puntosDeDefensa = puntosDeDefensaAColocar;
		this.estado = new EstadoCartaNoJugada();
		this.estrellas = estrellasAColocar;
		this.nombre = "MonstruoGenericoACME";
		this.modo = new ModoAtaque();
		this.regla = reglaDeInvocacion;	
		this.nombreImagen = " ";
		this.teclado = new Scanner(System.in);
		this.atacoEsteTurno = false;
		this.seCambioElEstadoEsteTurno = false;
	}
	//Constructor que recibe todo lo anterior + el nombre
	public CartaMonstruo(Puntos puntosDeAtaqueAColocar, Puntos puntosDeDefensaAColocar,
			int estrellasAColocar, ReglaDeInvocacionStrategy reglaDeInvocacion, String nombreAColocar) {
			this.puntosDeAtaque = puntosDeAtaqueAColocar;
			this.puntosDeDefensa = puntosDeDefensaAColocar;
			this.estado = new EstadoCartaNoJugada();
			this.estrellas = estrellasAColocar;
			this.nombre = nombreAColocar;
			this.modo = new ModoAtaque();
			this.regla = reglaDeInvocacion;
			this.nombreImagen = " ";
			this.teclado = new Scanner(System.in);
			this.atacoEsteTurno = false;
			this.seCambioElEstadoEsteTurno = false;
	}

	public void setNombreDeLaImagen(String nombreDeLaImagen) {
		this.nombreImagen = nombreDeLaImagen;
		this.atacoEsteTurno = false;
	}
	
	public String getNombreDeLaImagen() {
		
		return this.nombreImagen;
	}
	
	public void setNombre(String nombreDeLaCarta) {
		
		this.nombre = nombreDeLaCarta;
	}
	
	public void ponerEn(EstadoCarta estadoRecibido) {
		this.estado = estadoRecibido;
	}
	
	public void cambiarA(Modo modoRecibido) {
		this.modo = modoRecibido;
	}
		
	public void colocarse(Jugador jugador, ZonaMonstruos zonaMonstruos, ZonaMagicasYTrampas zonaMagicasYTrampas, ZonaCampo zonaCampo, Cementerio cementerio, EstadoCarta estadoAColocar) {
		this.estado = estadoAColocar;
		LinkedList<Destruible> monstruosSacrificados = new LinkedList<Destruible>();
		
		monstruosSacrificados = regla.colocarCarta( zonaMonstruos, this);
		
		 cementerio.agregarCartas(monstruosSacrificados);
	}
	
	
	public void atacar(Atacable cartaAtacableEnemiga) {
		if (this.estaEnModoDefensa()) {
			throw new MonstruoEnModoDefensaNoPuedeAtacarException();
		}
		CajaConsola.agregarMensaje(this.obtenerNombre()+" atacó a "+cartaAtacableEnemiga.obtenerNombre());
		cartaAtacableEnemiga.recibirAtaque(this);
	}
	
	public void atacar(Jugador jugador) {
		if (this.estaEnModoDefensa()) {
			throw new MonstruoEnModoDefensaNoPuedeAtacarException();
		}
		
		jugador.recibirAtaque(this);
	}

	public void recibirAtaque(Atacable cartaAtacante) {
	
		if (estaColocadaBocaAbajo()) {
			this.estado = new EstadoCartaColocadaBocaArriba();
		}
		this.modo.recibirAtaque(cartaAtacante, this);
	}
	
	
	public void colocarEnModoAtaque() {
		this.estado = new EstadoCartaColocadaBocaArriba();
		this.modo = this.modo.colocarEnModoAtaque();
	}
	
	public void colocarBocaArribaEnModoDefensa() {
		this.estado = new EstadoCartaColocadaBocaArriba();
		this.modo = this.modo.colocarEnModoDefensa();
	}
	
	public void colocarBocaAbajoEnModoDefensa() {
		this.estado = new EstadoCartaColocadaBocaAbajo();
		this.modo = this.modo.colocarEnModoDefensa();
	}
	
	public boolean estaColocadaBocaAbajo() {
		return this.estado.estaBocaAbajo();
	}
	public boolean estaColocadaBocaArriba() {
		return this.estado.estaBocaArriba();
	}
	
	public boolean estaEnModoAtaque() {
		return this.modo.estaEnModoAtaque();
	}
	
	public boolean estaEnModoDefensa() {
		return this.modo.estaEnModoDefensa();
	}
	
	public boolean estaDestruida() {
		return this.estado.estaDestruida();
	}
	
	public void destruirCarta() {
		this.estado = new EstadoCartaDestruida();
	}
	
	public void destruirCarta(int danioAlJugador) {
		this.estado = new EstadoCartaDestruida(danioAlJugador);
	}
	
	public int obtenerEstrellas() {
		return this.estrellas;
	}
	
	public String obtenerNombre() {
		return this.nombre;
	}

	public int obtenerDanioAlHaberSidoDestruida() {
		return estado.obtenerPuntosDeDanio();
	}

	public Puntos obtenerPuntosAtaque() {
		
		return this.puntosDeAtaque;
	}

	public Puntos obtenerPuntosDefensa() {
	
		return this.puntosDeDefensa;
	}
	
	public void eliminarModificadorDeAtaque() {
		this.puntosDeAtaque.eliminarModificadores();
	}
	
	public void eliminarModificadorDeDefensa() {
		this.puntosDeDefensa.eliminarModificadores();
	}
	
	public void aumentarAtaqueEn(Puntos puntosDeAtaqueExtra) {
		this.puntosDeAtaque.aumentar(puntosDeAtaqueExtra);
	}
	
	public void aumentarDefensaEn(Puntos puntosDeDefensaExtra) {
		this.puntosDeDefensa.aumentar(puntosDeDefensaExtra);
	}

	public boolean tieneMasPuntosDeAtaqueQue(Atacable carta) {
		
		return puntosDeAtaque.sonMayoresA(carta.obtenerPuntosAtaque());
	}

	public int diferenciaDeAtaqueCon(Atacable carta) {
		
		return puntosDeAtaque.obtenerDiferenciaCon(carta.obtenerPuntosAtaque());
	}

	public Modo obtenerModo() {

		return this.modo;
	}

	@Override
	public void voltear() {
		
		this.colocarBocaArriba();
	}

	@Override
	public void colocarBocaArriba() {
		if(this.estaColocadaBocaArriba() ) {
			throw new CartaBocaArribaNoSePuedeVoltearException();
		}
		
		this.estado = new EstadoCartaColocadaBocaArriba();	
		
	}

	//////////////////////////////////////////
	
	@Override
	public EstadoCarta elegirComoColocar() {
	
		String estado = this.pedirEstadoCarta();
		EstadoCarta estadoADevolver = null;
		if (estado.equals("arriba")) {
			estadoADevolver = new EstadoCartaColocadaBocaArriba();
			this.pedirModo();
		
		} else {
			estadoADevolver = new EstadoCartaColocadaBocaAbajo();
			this.modo = new ModoDefensa();
		}
		
		return estadoADevolver;

	}
	
	public String pedirEstadoCarta() {
		
		System.out.println("Ingrese 'arriba' o ' abajo' para indicar como quiere colocar la carta");
		String nombreEstado = teclado.nextLine();
		while ((!nombreEstado.equals("arriba")) && (!nombreEstado.equals("abajo"))) {
			System.out.println("Ingrese un estado valido");
			nombreEstado = this.teclado.nextLine();
		}
		
		return nombreEstado;
	}
	
	public void pedirModo() {
		
		System.out.println("Ingrese 'ataque' o 'defensa' para indicar el modo de la carta");
		String nombreModo = this.teclado.nextLine();
		while ((!nombreModo.equals("ataque")) && (!nombreModo.equals("defensa"))) {
			System.out.println("Ingrese un modo valido");
			nombreModo = this.teclado.nextLine();
		}
		
		if (nombreModo.equals("ataque")) {
			this.modo = new ModoAtaque();
		} else {
			this.modo = new ModoDefensa();
		}
		
	}
	
	public boolean esAtacable() {
		return true;
	}
	
	public boolean esActivable() {
		return false;
	}
	
	public void clickEnZona(Partida partida, Jugador jugadorDuenio, ContenedorDelDuelo cajaDuelo, ImageView imagenCarta) {
		ClickEnCartaEnZonaMonstruoHandler verMenu = new ClickEnCartaEnZonaMonstruoHandler(partida, this, jugadorDuenio, cajaDuelo);
		imagenCarta.setOnContextMenuRequested(verMenu);
		
	}
 	
	public boolean atacoEsteTurno() {
		return this.atacoEsteTurno;
	}
	
	public void setAtacoEsteTurno(boolean ataco) {
		this.atacoEsteTurno = ataco;
	}

	@Override
	public boolean seCambioElEstadoEsteTurno() {
		return this.seCambioElEstadoEsteTurno;
	}

	@Override
	public void setSeCambioElEstadoEsteTurno(boolean seCambioElEstado) {
		
		this.seCambioElEstadoEsteTurno = seCambioElEstado;
		
	}
	
	
}