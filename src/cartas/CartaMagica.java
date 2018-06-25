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
import jugador.Jugador;
import modos.Modo;

public class CartaMagica implements Activable{
	
	protected EstadoCarta estado;
	protected Efecto efecto;
	private String nombre;
	
	
	public CartaMagica() {
		
		this.estado = new EstadoCartaNoJugada();
		Efecto efectoNulo = new EfectoNulo();
		this.efecto = efectoNulo;
		this.nombre = " ";
	}
	
	public CartaMagica(Efecto efectoAColocar) {
		
		this.estado = new EstadoCartaNoJugada();
		this.efecto = efectoAColocar;
		this.nombre = " ";
	
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


}