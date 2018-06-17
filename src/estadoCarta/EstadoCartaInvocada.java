package estadoCarta;

import estrategias.*;
import modos.*;
import cartas.*;

public class EstadoCartaInvocada extends EstadoCarta {

	private Modo modo;
	private Estrategia boca;
	private Puntos puntosDeAtaque;
	private Puntos puntosDeDefensa;
	
	public EstadoCartaInvocada(Estrategia bocaRecibida, Modo modoRecibido, Puntos puntosATKRecibidos, Puntos puntosDEFRecibidos) {
		this.modo = modoRecibido;
		this.boca = bocaRecibida;
		this.puntosDeAtaque = puntosATKRecibidos;
		this.puntosDeDefensa = puntosDEFRecibidos;
	}
	
	public int recibirAtaque(Puntos puntosAtaqueEnemigo) {
	
		int diferenciaDanio = puntosAtaqueEnemigo.obtenerDiferenciaCon(this.puntosDeAtaque);
		return diferenciaDanio;
	
	}


	
	
	
}
