package cartas;

import campo.Campo;
import campo.Cementerio;
import campo.ZonaCampo;
import campo.ZonaMagicasYTrampas;
import campo.ZonaMonstruos;
import efectos.Efecto;
import estadoCarta.EstadoCarta;
import estadoCarta.EstadoCartaNoJugada;
import exceptions.CartaBocaAbajoNoPuedeActivarEfectoException;
import jugador.Jugador;

public class CartaCampo extends CartaMagica {
	
	private String nombre;
	
	public CartaCampo() {
		super();
	}
	
	public CartaCampo(Efecto efectoAColocar) {
		super(efectoAColocar);
	
	}
	
	public void setNombre(String nombreDeLaCarta) {
		this.nombre = nombreDeLaCarta;
	}
	
	public void colocarse(Jugador jugador, ZonaMonstruos zonaMonstruos, ZonaMagicasYTrampas zonaMagicasYTrampas, ZonaCampo zonaCampo, Cementerio cementerio, EstadoCarta estadoAColocar) {
		zonaCampo.enviarCampoAlCementerio(cementerio);
		zonaCampo.destruirCarta();
		jugador.destruirCartaCampoEnemiga();
		this.estado = estadoAColocar;
		zonaCampo.colocarCarta(this);
		
		if (estado.estaBocaArriba()) {
			jugador.aplicarEfectoCarta(this);
		}
	}
	
	public void aplicarEfecto(Campo campo, Campo campoEnemigo) {
		
		if(this.estaColocadaBocaAbajo()) {
			throw new CartaBocaAbajoNoPuedeActivarEfectoException();
		}
		
		this.efecto.aplicarEfecto(campo, campoEnemigo);
		campo.enviarCartasDestruidasAlCementerio();
		campoEnemigo.enviarCartasDestruidasAlCementerio();
	}
}
