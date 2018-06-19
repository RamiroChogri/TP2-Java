package cartas;

import campo.Campo;
import campo.ZonaCampo;
import campo.ZonaMagicasYTrampas;
import campo.ZonaMonstruos;
import efectos.Efecto;
import estadoCarta.EstadoCarta;
import estadoCarta.EstadoCartaNoJugada;
import exceptions.CartaBocaAbajoNoPuedeActivarEfectoException;

public class CartaCampo extends CartaMagica {
	
	public CartaCampo() {
		super();
	}
	
	public CartaCampo(Efecto efectoAColocar) {
		super(efectoAColocar);
	
	}
	
	public void colocarse(ZonaMonstruos zonaMonstruos, ZonaMagicasYTrampas zonaMagicasYTrampas, ZonaCampo zonaCampo, EstadoCarta estadoAColocar) {
		this.estado = estadoAColocar;
		zonaCampo.colocarCarta(this);
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
