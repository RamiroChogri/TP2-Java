package partida;

import jugador.Jugador;

public class Partida {

	
	private Fase faseActual;
	private boolean seJugoCartaMonstruo;
	private Jugador jugadorEnTurno;
	private Jugador jugadorYugi;
	private Jugador jugadorKaiba;
	private int contadorDeTurnos;
	private boolean esPrimerTurno;
	
	public Partida() {
		
		this.jugadorYugi = new Jugador();
		this.jugadorKaiba = new Jugador();
		
		this.jugadorYugi.setName("Yugi");
		this.jugadorKaiba.setName("Kaiba");
		this.jugadorEnTurno = this.elegirQuienComienza(jugadorYugi, jugadorKaiba);
		
		this.jugadorYugi.enfrentarseA(jugadorKaiba);
		this.jugadorKaiba.enfrentarseA(jugadorYugi);
		
		this.seJugoCartaMonstruo = false;
		
		FaseAtaqueYTrampas.esPrimerTurno = true;
		
		this.faseActual = new FasePreparacion(this.jugadorEnTurno);
		
		this.contadorDeTurnos = 0;
		
		this.esPrimerTurno = true;
		
	}
	
	public boolean estaEnFaseDePreparacion() {
		return this.faseActual.esFasePreparacion();
	}
	
	public boolean estaEnFaseDeAtaqueYTrampas() {
		return this.faseActual.esFaseAtaqueYTrampas();
	}
	
	public boolean estaEnFaseFinal() {
		return this.faseActual.esFaseFinal();
	}
	
	public Jugador elegirQuienComienza(Jugador unJugador, Jugador otroJugador) {
		
		Jugador jugadorQueComienza = unJugador ;
		
		if(Math.random() < 0.5) {
			jugadorQueComienza = otroJugador;
		}
		
		return jugadorQueComienza;
	}
	
	public Jugador getJugadorYugi() {
		return this.jugadorYugi;
	}
	
	public Jugador getJugadorKaiba() {
		return this.jugadorKaiba;
	}
	
	public boolean estaYugiEnTurno() {
		return (this.jugadorEnTurno == this.jugadorYugi);
	}
	
	public void setSeJugoCartaMonstruo() {
		this.seJugoCartaMonstruo = true;
	}
	
	public void setNoSeJugoUnaCartaMonstruo() {
		this.seJugoCartaMonstruo = false;
	}
	
	public boolean seJugoUnaCartaMonstruoEsteTurno() {
		return this.seJugoCartaMonstruo;
	}
	
	public void avanzarFase() {
		this.faseActual = faseActual.obtenerFaseSiguiente();
		if (faseActual.getNombreFase().equals("Fase Preparacion")) {
			this.jugadorEnTurno = this.faseActual.obtenerJugadorEnTurno();
			this.seJugoCartaMonstruo = false;
			this.jugadorEnTurno.reiniciarAtaquesMonstruosColocados();
			this.jugadorEnTurno.reiniciarSeCambioElEstadoEsteTurnoMonstruosColocados();
			if (!esPrimerTurno) {
				contadorDeTurnos++;
			}
			
			if (esPrimerTurno) {
				esPrimerTurno = false;
			}
		}
	}
	
	public void finalizarTurno() {
		this.jugadorEnTurno = this.jugadorEnTurno.obtenerJugadorEnemigo();
		this.faseActual = new FasePreparacion(this.jugadorEnTurno);
		this.seJugoCartaMonstruo = false;
		this.jugadorEnTurno.reiniciarAtaquesMonstruosColocados();
		this.jugadorEnTurno.reiniciarSeCambioElEstadoEsteTurnoMonstruosColocados();
		this.contadorDeTurnos++;
		this.esPrimerTurno = false;
	}
	
	public String getNombreFase() {
		return this.faseActual.getNombreFase();
	}
	
	public boolean jugadorEstaEnTurno(Jugador jugadorRecibido) {
		return (jugadorRecibido == this.jugadorEnTurno);
	}
	
	public boolean esPrimerTurno() {
		return this.contadorDeTurnos == 0;
	}
}
