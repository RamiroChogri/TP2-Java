package cartas;

import estadoCarta.EstadoCarta;
import estadoCarta.EstadoCartaColocadaBocaAbajo;
import estadoCarta.EstadoCartaColocadaBocaArriba;
import estadoCarta.EstadoCartaDestruida;
import estadoCarta.EstadoCartaNoJugada;

import campo.Campo;
import campo.Cementerio;
import campo.ZonaCampo;
import campo.ZonaMagicasYTrampas;
import campo.ZonaMonstruos;
import efectos.*;
import exceptions.*;
import javafx.scene.image.ImageView;
import jugador.Jugador;
import modos.Modo;
import partida.Partida;
import view.ContenedorDelDuelo;
import view.handlers.ClickEnCartaMagicaInvocadaHandler;

public class CartaMagica implements Activable{
	
	protected EstadoCarta estado;
	protected Efecto efecto;
	private String nombre;

	private String nombreImagen;
	
	public CartaMagica() {
		
		this.estado = new EstadoCartaNoJugada();
		Efecto efectoNulo = new EfectoNulo();
		this.efecto = efectoNulo;
		this.nombre = " ";
		this.nombreImagen = " ";
	}
	
	public CartaMagica(Efecto efectoAColocar) {
		
		this.estado = new EstadoCartaNoJugada();
		this.efecto = efectoAColocar;
		this.nombre = " ";
		this.nombreImagen = " ";
		
	}
	
	public void setNombreDeLaImagen(String nombreDeLaImagen) {
		this.nombreImagen = nombreDeLaImagen;
	}
	
	public String getNombreDeLaImagen() {
		return this.nombreImagen;
	}
	
	public void setNombre(String nombreDeLaCarta) {
		this.nombre = nombreDeLaCarta;
	}
	
	public void destruirCarta() {
	
		this.estado = new EstadoCartaDestruida();

	}

	public void colocarBocaAbajo() {
	
		this.estado = new EstadoCartaColocadaBocaAbajo();
		
	}

	public void colocarBocaArriba() {
		
		this.estado = new EstadoCartaColocadaBocaArriba();
		
	}

	public boolean estaColocadaBocaAbajo() {
		return ( this.estado.estaBocaAbajo() );
	}

	public boolean estaColocadaBocaArriba() {
		return ( this.estado.estaBocaArriba() );
	}
	
	public boolean estaDestruida() {
		return this.estado.estaDestruida();
	}
	
	public Efecto obtenerEfecto() {
		return this.efecto;
	}


	public void aplicarEfecto(Campo campo, Campo campoEnemigo) {
	
		if(this.estaColocadaBocaAbajo()) {
			throw new CartaBocaAbajoNoPuedeActivarEfectoException();
		}
		
		this.efecto.aplicarEfecto(campo, campoEnemigo);
		this.destruirCarta();
		campo.enviarCartasDestruidasAlCementerio();
		campoEnemigo.enviarCartasDestruidasAlCementerio();
	}

	public void colocarse(Jugador jugador, ZonaMonstruos zonaMonstruos, ZonaMagicasYTrampas zonaMagicasYTrampas, ZonaCampo zonaCampo, Cementerio cementerio, EstadoCarta estadoAColocar) {
		this.estado = estadoAColocar;
		zonaMagicasYTrampas.colocarCarta(this);
		
		if (estado.estaBocaArriba()) {
			jugador.aplicarEfectoCarta(this);
		}
	}

	public void cambiarA(Modo modoACambiar) {
		//metodo forzado
	}
	
	public boolean esDeTrampa() {
		
		return false;
	}

	@Override
	public String obtenerNombre() {
		
		return nombre;
	}

	@Override
	public void aplicarEfecto(Campo campoPropio, Campo campoEnemigo, Atacable atacante, Atacable atacado) {
		
	}

	@Override
	public void voltear(Campo campoPropio, Campo campoEnemigo) {
		if(this.estaColocadaBocaArriba()) {
			throw new CartaBocaArribaNoSePuedeVoltearException();
		}
		
		this.colocarBocaArriba();
		this.aplicarEfecto(campoPropio, campoEnemigo);
	}
	
	//////////////////////////////////////
	
	public boolean esActivable() {
		return true;
	}
	
	public boolean esAtacable() {
		return false;
	}
	
	@Override
	public void clickEnZona(Partida partida, Jugador jugadorDuenio, ContenedorDelDuelo cajaDuelo, ImageView imagenCarta) {
		ClickEnCartaMagicaInvocadaHandler verMenu = new ClickEnCartaMagicaInvocadaHandler(partida, this, jugadorDuenio, cajaDuelo);
		imagenCarta.setOnContextMenuRequested(verMenu);
	}
	
	
}