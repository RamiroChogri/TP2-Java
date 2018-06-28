package view.handlers;

import cartas.Activable;
import cartas.CartaMagica;
import cartas.CartaTrampa;
import cartas.Colocable;
import estadoCarta.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.MenuItem;
import javafx.scene.input.MouseEvent;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import jugador.Jugador;
import modos.*;
import partida.Partida;
import view.CajaCampo;
import view.CajaInformacion;
import view.ManoJugador;

public class ClickEnCartaEnManoHandler implements EventHandler<MouseEvent> {
	
	private Partida duelo;
	private Colocable carta;
	private Jugador jugador;
	private CajaCampo cajaCampo;
	private CajaInformacion cajaInf;
	
	public ClickEnCartaEnManoHandler(CajaInformacion cajaInfRecibida, Partida partidaAColocar, Colocable cartaAColocar, Jugador jugadorEnTurno, CajaCampo cajaCampoRecibida) {
		this.duelo = partidaAColocar;
		this.carta = cartaAColocar;
		this.jugador = jugadorEnTurno;
		this.cajaCampo = cajaCampoRecibida;
		this.cajaInf = cajaInfRecibida;
	}
	
	public void handle(MouseEvent t) {
        if (duelo.estaEnFaseDePreparacion()){
        	if (this.carta.esAtacable() && !this.duelo.seJugoUnaCartaMonstruoEsteTurno()) {
        		this.menuCartaAtacable();
        	} else if (this.carta.getClass() == CartaMagica.class) {
        		this.menuCartaMagica();
        	} else if (this.carta.getClass() == CartaTrampa.class) {
        		EstadoCarta estadoCarta = new EstadoCartaColocadaBocaAbajo();
        		this.jugador.colocar(carta, estadoCarta);
        		this.jugador.eliminarCartaDeLaMano(carta.obtenerNombre());
        		if (duelo.estaYugiEnTurno()) {
        			cajaCampo.actualizarVistaYugiEnTurno(jugador, jugador.obtenerJugadorEnemigo());
        		} else {
        			cajaCampo.actualizarVistaKaibaEnTurno(jugador, jugador.obtenerJugadorEnemigo());
        		}
        	} else {
        		EstadoCarta estadoCarta = new EstadoCartaColocadaBocaArriba();
        		this.jugador.colocar(carta, estadoCarta);
        		this.jugador.eliminarCartaDeLaMano(carta.obtenerNombre());
        		if (duelo.estaYugiEnTurno()) {
        			cajaCampo.actualizarVistaYugiEnTurno(jugador, jugador.obtenerJugadorEnemigo());
        		} else {
        			cajaCampo.actualizarVistaKaibaEnTurno(jugador, jugador.obtenerJugadorEnemigo());
        		}
        	}
        	
        }
    }
	
	private void menuCartaAtacable() {
		TextField textField = new TextField("Elija como colocar carta Atacable");
    	final ContextMenu contextMenu = new ContextMenu();
    	MenuItem bocaArribaModoAtaque = new MenuItem("Colocar boca arriba en Modo Ataque");
    	MenuItem bocaArribaModoDefensa = new MenuItem("Colocar boca arriba en Modo Defensa");
    	MenuItem bocaAbajoModoDefensa = new MenuItem("Colocar boca abajo en Modo Defensa");
    	contextMenu.getItems().addAll(bocaArribaModoAtaque, bocaAbajoModoDefensa, bocaAbajoModoDefensa);
    	bocaArribaModoAtaque.setOnAction(new EventHandler<ActionEvent>() {
    	    @Override
    	    public void handle(ActionEvent event) {
    	        Modo modoACambiar = new ModoAtaque();
    	        EstadoCarta estadoACambiar = new EstadoCartaColocadaBocaArriba();
    	    	carta.cambiarA(modoACambiar);
    	    	jugador.colocar(carta, estadoACambiar);
    	    	jugador.eliminarCartaDeLaMano(carta.obtenerNombre());
    	    	duelo.setSeJugoCartaMonstruo(); //Se reinicia cada fase
        		if (duelo.estaYugiEnTurno()) {
        			cajaCampo.actualizarVistaYugiEnTurno(jugador, jugador.obtenerJugadorEnemigo());
        		} else {
        			cajaCampo.actualizarVistaKaibaEnTurno(jugador, jugador.obtenerJugadorEnemigo());
        		}
        	}
    	});
    	bocaArribaModoDefensa.setOnAction(new EventHandler<ActionEvent>() {
    	    @Override
    	    public void handle(ActionEvent event) {
    	        Modo modoACambiar = new ModoDefensa();
    	        EstadoCarta estadoACambiar = new EstadoCartaColocadaBocaArriba();
    	    	carta.cambiarA(modoACambiar);
    	    	jugador.colocar(carta, estadoACambiar);
    	    	jugador.eliminarCartaDeLaMano(carta.obtenerNombre());
    	    	duelo.setSeJugoCartaMonstruo();
    	    	if (duelo.estaYugiEnTurno()) {
        			cajaCampo.actualizarVistaYugiEnTurno(jugador, jugador.obtenerJugadorEnemigo());
        		} else {
        			cajaCampo.actualizarVistaKaibaEnTurno(jugador, jugador.obtenerJugadorEnemigo());
        		}
    	    }
    	});
    	bocaAbajoModoDefensa.setOnAction(new EventHandler<ActionEvent>() {
    	    @Override
    	    public void handle(ActionEvent event) {
    	        Modo modoACambiar = new ModoDefensa();
    	        EstadoCarta estadoACambiar = new EstadoCartaColocadaBocaAbajo();
    	    	carta.cambiarA(modoACambiar);
    	    	jugador.colocar(carta, estadoACambiar);
    	    	jugador.eliminarCartaDeLaMano(carta.obtenerNombre());
    	    	duelo.setSeJugoCartaMonstruo();
    	    	if (duelo.estaYugiEnTurno()) {
        			cajaCampo.actualizarVistaYugiEnTurno(jugador, jugador.obtenerJugadorEnemigo());
        		} else {
        			cajaCampo.actualizarVistaKaibaEnTurno(jugador, jugador.obtenerJugadorEnemigo());
        		}
    	    }
    	});
    	textField.setContextMenu(contextMenu);
	}
	
	private void menuCartaMagica() {
		TextField textField = new TextField("Elija como colocar la carta magica");
    	final ContextMenu contextMenu = new ContextMenu();
    	MenuItem bocaArriba = new MenuItem("Boca Arriba");
    	MenuItem bocaAbajo = new MenuItem("Boca Abajo");
    	contextMenu.getItems().addAll(bocaArriba, bocaAbajo);
    	bocaArriba.setOnAction(new EventHandler<ActionEvent>() {
    	    @Override
    	    public void handle(ActionEvent event) {
    	    	EstadoCarta estadoCarta = new EstadoCartaColocadaBocaArriba();
        		jugador.colocar(carta, estadoCarta);
        		jugador.eliminarCartaDeLaMano(carta.obtenerNombre());
        		if (duelo.estaYugiEnTurno()) {
        			cajaCampo.actualizarVistaYugiEnTurno(jugador, jugador.obtenerJugadorEnemigo());
        		} else {
        			cajaCampo.actualizarVistaKaibaEnTurno(jugador, jugador.obtenerJugadorEnemigo());
        		}
    	    }
    	});
    	bocaAbajo.setOnAction(new EventHandler<ActionEvent>() {
    	    @Override
    	    public void handle(ActionEvent event) {
    	    	EstadoCarta estadoCarta = new EstadoCartaColocadaBocaAbajo();
        		jugador.colocar(carta, estadoCarta);
        		jugador.eliminarCartaDeLaMano(carta.obtenerNombre());
        		if (duelo.estaYugiEnTurno()) {
        			cajaCampo.actualizarVistaYugiEnTurno(jugador, jugador.obtenerJugadorEnemigo());
        		} else {
        			cajaCampo.actualizarVistaKaibaEnTurno(jugador, jugador.obtenerJugadorEnemigo());
        		}
    	    }
    	});
    	textField.setContextMenu(contextMenu);
	}
}