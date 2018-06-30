package cartas;

import campo.Campo;
import efectos.Efecto;
import estadoCarta.EstadoCarta;
import estadoCarta.EstadoCartaColocadaBocaAbajo;
import estadoCarta.EstadoCartaColocadaBocaArriba;
import exceptions.CartaTrampaNoPuedeVoltearseException;
import javafx.scene.image.ImageView;
import jugador.Jugador;
import partida.Partida;
import view.CajaCampo;

public class CartaTrampa extends CartaMagica{
	
	public CartaTrampa() {
		super();
	}
	
	
	public CartaTrampa(Efecto efectoAColocar) {
		super(efectoAColocar);
	}
	
	public void setNombreDeLaImagen(String nombreDeLaImagen) {
		super.setNombreDeLaImagen(nombreDeLaImagen);
	}
	
	public String getNombreDeLaImagen() {
		return super.getNombreDeLaImagen();
	}
	
	
	public void aplicarEfecto(Campo campoPropio, Campo campoEnemigo, Atacable atacante, Atacable atacado) {
		
		efecto.aplicarEfecto(campoPropio, campoEnemigo, atacante, atacado);
		this.destruirCarta();
	}
	
	@Override
	public boolean esDeTrampa() {
		
		return true;
	}

	@Override
	public void voltear(Campo campoPropio, Campo campoEnemigo) {
		
		throw new CartaTrampaNoPuedeVoltearseException();
	}

	@Override
	public EstadoCarta elegirComoColocar() {
	
		EstadoCarta estadoADevolver = new EstadoCartaColocadaBocaAbajo();
		return estadoADevolver;
		
	}
	
	@Override
	public void clickEnZona(Partida partida, Jugador jugadorDuenio, CajaCampo cajaCampo, ImageView imagenCarta) {
		//No hace nada
	}
	
}
