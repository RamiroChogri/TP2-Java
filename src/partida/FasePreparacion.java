package partida;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;

import cartas.Atacable;
import cartas.Colocable;
import estadoCarta.EstadoCarta;
import estadoCarta.EstadoCartaColocadaBocaArriba;
import exceptions.NoHayMonstruoParaSacrificarException;
import exceptions.NoHaySuficientesMonstruosParaSacrificarException;
import jugador.*;
import modos.Modo;
import modos.ModoAtaque;
import modos.ModoDefensa;
import view.CajaConsola;

public class FasePreparacion extends Fase {

	private Scanner teclado;
	private String nombreFase;
	private Jugador jugadorEnTurno;
	
	public FasePreparacion(Jugador jugadorRecibido) {
		this.teclado = new Scanner(System.in);
		this.nombreFase = "Fase Preparacion";
		this.jugadorEnTurno = jugadorRecibido;
		this.jugadorEnTurno.tomarCartaDelMazo();
		

		
	}
	
	public String getNombreFase() {
		return this.nombreFase;
	}
	
	@Override
	public Fase obtenerFaseSiguiente() {
		Fase faseADevolver = new FaseAtaqueYTrampas(this.jugadorEnTurno);
		return faseADevolver;
	}
	
	@Override
	public boolean esFasePreparacion() {
		return true;
	}
	
	@Override
	public Jugador obtenerJugadorEnTurno() {
		return this.jugadorEnTurno;
	}
}
