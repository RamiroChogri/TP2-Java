package partida;


import jugador.*;


public class FasePreparacion extends Fase {

	private String nombreFase;
	private Jugador jugadorEnTurno;
	
	public FasePreparacion(Jugador jugadorRecibido) {
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
