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
import javafx.scene.control.TextField;
import jugador.Jugador;
import modos.*;
import partida.Partida;

public class ClickEnCartaEnManoHandler implements EventHandler<ActionEvent> {
	
	private Partida duelo;
	private Colocable carta;
	private Jugador jugador;
	
	public ClickEnCartaEnManoHandler(Partida partidaAColocar, Colocable cartaAColocar, Jugador jugadorEnTurno) {
		this.duelo = partidaAColocar;
		this.carta = cartaAColocar;
		this.jugador = jugadorEnTurno;
	}
	
	public void handle(ActionEvent actionEvent) {
        if (duelo.estaEnFaseDePreparacion()){
        	if (this.carta.esAtacable()) {
        		TextField textField = new TextField("Elegir como colocar carta Atacable");
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
            	    	duelo.seJugoCartaMonstruo();
                		duelo.actualizarVista();
            	    }
            	});
            	bocaArribaModoDefensa.setOnAction(new EventHandler<ActionEvent>() {
            	    @Override
            	    public void handle(ActionEvent event) {
            	        Modo modoACambiar = new ModoDefensa();
            	        EstadoCarta estadoACambiar = new EstadoCartaColocadaBocaArriba();
            	    	carta.cambiarA(modoACambiar);
            	    	jugador.colocar(carta, estadoACambiar);
            	    	duelo.seJugoCartaMonstruo();
                		duelo.actualizarVista();
            	    }
            	});
            	bocaAbajoModoDefensa.setOnAction(new EventHandler<ActionEvent>() {
            	    @Override
            	    public void handle(ActionEvent event) {
            	        Modo modoACambiar = new ModoDefensa();
            	        EstadoCarta estadoACambiar = new EstadoCartaColocadaBocaAbajo();
            	    	carta.cambiarA(modoACambiar);
            	    	jugador.colocar(carta, estadoACambiar);
            	    	duelo.seJugoCartaMonstruo();
                		duelo.actualizarVista();
            	    }
            	});
            	textField.setContextMenu(contextMenu);
        	} else if (this.carta.getClass() == CartaMagica.class) {
        		TextField textField = new TextField("Type Something");
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
                		duelo.actualizarVista();
            	    }
            	});
            	bocaAbajo.setOnAction(new EventHandler<ActionEvent>() {
            	    @Override
            	    public void handle(ActionEvent event) {
            	    	EstadoCarta estadoCarta = new EstadoCartaColocadaBocaAbajo();
                		jugador.colocar(carta, estadoCarta);
                		jugador.eliminarCartaDeLaMano(carta.obtenerNombre());
                		duelo.actualizarVista();
            	    }
            	});
            	textField.setContextMenu(contextMenu);
        	} else if (this.carta.getClass() == CartaTrampa.class) {
        		EstadoCarta estadoCarta = new EstadoCartaColocadaBocaAbajo();
        		this.jugador.colocar(carta, estadoCarta);
        		this.jugador.eliminarCartaDeLaMano(carta.obtenerNombre());
        		duelo.actualizarVista();
        	} else {
        		EstadoCarta estadoCarta = new EstadoCartaColocadaBocaArriba();
        		this.jugador.colocar(carta, estadoCarta);
        		this.jugador.eliminarCartaDeLaMano(carta.obtenerNombre());
        		duelo.actualizarVista();
        	}
        	
        	

        }
    }
}