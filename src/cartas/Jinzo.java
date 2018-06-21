package cartas;

import InvocacionStrategy.ReglaDeInvocacionStrategy;
import InvocacionStrategy.ReglaDeMonstruoChicoStrategy;
import estadoCarta.EstadoCarta;
import estadoCarta.EstadoCartaNoJugada;
import modos.Modo;

public class Jinzo extends CartaMonstruo {

	private EstadoCarta estado;
	private Modo modo;
	private Puntos puntosDeAtaque;
	private Puntos puntosDeDefensa;
	private int estrellas;
	private String nombre;
	private ReglaDeInvocacionStrategy regla;
	
	public Jinzo() {
		
		this.estado = new EstadoCartaNoJugada(); 
		this.puntosDeAtaque = new Puntos(500);
		this.puntosDeDefensa = new Puntos(400);
		this.estrellas = 2;
		this.nombre = "Jinzo";
		this.regla = new ReglaDeMonstruoChicoStrategy();
		
	}
	
	public void atacar() {
		
	}
	
}
