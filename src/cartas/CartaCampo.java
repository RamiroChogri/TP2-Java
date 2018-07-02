package cartas;

import campo.Campo;
import campo.Cementerio;
import campo.ZonaCampo;
import campo.ZonaMagicasYTrampas;
import campo.ZonaMonstruos;
import efectos.Efecto;
import estadoCarta.EstadoCarta;
import estadoCarta.EstadoCartaColocadaBocaAbajo;
import estadoCarta.EstadoCartaColocadaBocaArriba;
import estadoCarta.EstadoCartaNoJugada;
import exceptions.CartaBocaAbajoNoPuedeActivarEfectoException;
import javafx.scene.image.ImageView;
import jugador.Jugador;
import partida.Partida;
import view.CajaCampo;
import view.ContenedorDelDuelo;

public class CartaCampo extends CartaMagica {
	
	private String nombre;

	
	public CartaCampo() {
		super();
	}
	
	public CartaCampo(Efecto efectoAColocar) {
		super(efectoAColocar);
	
	}

	///////////
	public void setNombreDeLaImagen(String nombreDeLaImagen) {
		super.setNombreDeLaImagen(nombreDeLaImagen);
	}
	
	public String getNombreDeLaImagen() {
		return super.getNombreDeLaImagen();
	}
	///////////
	
	public void setNombre(String nombreDeLaCarta) {
		this.nombre = nombreDeLaCarta;
	}
	
	public String obtenerNombre() {
		return this.nombre;
	}
	
	public void colocarse(Jugador jugador, ZonaMonstruos zonaMonstruos, ZonaMagicasYTrampas zonaMagicasYTrampas, ZonaCampo zonaCampo, Cementerio cementerio, EstadoCarta estadoAColocar) {
		zonaCampo.destruirCarta();
		zonaCampo.enviarCampoAlCementerio(cementerio);
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
	
	///////////////////////////////
	
	@Override
	public EstadoCarta elegirComoColocar() {
	
		EstadoCarta estadoADevolver = new EstadoCartaColocadaBocaArriba();
		return estadoADevolver;
		
	}
	
	@Override
	public void clickEnZona(Partida partida, Jugador jugadorDuenio, ContenedorDelDuelo cajaDuelo, ImageView imagenCarta) {
		//No hace nada
	}


}
