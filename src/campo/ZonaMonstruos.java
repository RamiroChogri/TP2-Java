package campo;
import java.util.*;

import cartas.*;
import exceptions.NoHayLugarVacioException;
import exceptions.NoHayMonstruoParaSacrificarException;
import exceptions.NoHayCartasException;
import exceptions.ZonaMonstruoLlenaException;
import view.CajaConsola;

public class ZonaMonstruos extends Zona {
	
	private LinkedList<Atacable> posiciones;
	private boolean hayEspacio;
	private Puntos puntosDeAtaqueExtra;
	private Puntos puntosDeDefensaExtra;
	
	public ZonaMonstruos() {
		this.posiciones = new LinkedList<Atacable>();
		this.hayEspacio = true;
		this.puntosDeAtaqueExtra = new Puntos(0);
		this.puntosDeDefensaExtra = new Puntos(0);
	}
	
	public void colocarCarta(Colocable cartaMonstruoAColocar) {
		//MetodoForzadoPorZona
	}
	
	public void colocarCarta(Atacable cartaMonstruoAColocar) {
		this.hayEspacio = this.hayEspacioDisponible();
			if ( !this.hayEspacio ) {
				throw new NoHayLugarVacioException();
			}
			cartaMonstruoAColocar.aumentarAtaqueEn(this.puntosDeAtaqueExtra);
			cartaMonstruoAColocar.aumentarDefensaEn(this.puntosDeDefensaExtra);
			this.posiciones.add(cartaMonstruoAColocar);
		
	}
	
	public boolean hayEspacioDisponible() {	
		return (this.posiciones.size() < 5);
	}

	public int obtenerCantidadDeCartas() {
		return (this.posiciones.size());
	}
	
	public LinkedList<Destruible> recolectarCartasDestruidas() {
		LinkedList<Destruible>cartasDestruidas = new LinkedList<Destruible>();
		Iterator<Atacable> posicionesIterador = this.posiciones.iterator();		
	    Atacable cartaMonstruoActual;
	    while (posicionesIterador.hasNext()) {
	    	cartaMonstruoActual = posicionesIterador.next();
	    	if(cartaMonstruoActual.estaDestruida()) {
	    	
	    		Destruible cartaActual = cartaMonstruoActual;
	    		cartasDestruidas.add(cartaActual);
	    		posicionesIterador.remove();
	    	
	    	}
	    }
	    return cartasDestruidas;
	}

	public void vaciar() {
		Iterator<Atacable> posicionesIterador = this.posiciones.iterator();		
		Atacable cartaMonstruoActual;
	    while (posicionesIterador.hasNext()) {
	    	cartaMonstruoActual = posicionesIterador.next();
	    	cartaMonstruoActual.destruirCarta();
	    }
	}

	public int obtenerDanioRecibido() {
		int danio = 0;
		Iterator<Atacable> posicionesIterador = this.posiciones.iterator();		
		Atacable cartaMonstruoActual;
	    
	    while (posicionesIterador.hasNext()) {
	    	cartaMonstruoActual = posicionesIterador.next();
	    	danio += cartaMonstruoActual.obtenerDanioAlHaberSidoDestruida(); 
	    	
	    }
	    
		return danio;
	}
	
	public void eliminarUltimaCartaMonstruoColocada() {
		try {
			posiciones.getLast().destruirCarta();
		} catch (NoSuchElementException noHayMonstruoParaBorrar) {
			//No se elimina nada
		}
	}

	public boolean tieneMonstruosColocados(int cantidadDeMonstruosBuscados) {
		
		return ( posiciones.size() >= cantidadDeMonstruosBuscados );
	}
	
	public void aumentarAtaqueMonstruoPorEfectoCampo(Puntos puntosAtaqueAColocar) {
		this.puntosDeAtaqueExtra = puntosAtaqueAColocar;
		this.puntosDeDefensaExtra = new Puntos(0);
		Iterator<Atacable> posicionesIterador = this.posiciones.iterator();		
		Atacable cartaMonstruoActual;
	    while (posicionesIterador.hasNext()) {
	    	cartaMonstruoActual = posicionesIterador.next();
	    	cartaMonstruoActual.eliminarModificadorDeAtaque();
	    	cartaMonstruoActual.eliminarModificadorDeDefensa();
	    	cartaMonstruoActual.aumentarAtaqueEn(this.puntosDeAtaqueExtra);
	    }
	}
	
	public void aumentarDefensaMonstruoPorEfectoCampo(Puntos puntosDefensaAColocar) {
		this.puntosDeAtaqueExtra = new Puntos(0);
		this.puntosDeDefensaExtra = puntosDefensaAColocar;
		Iterator<Atacable> posicionesIterador = this.posiciones.iterator();		
		Atacable cartaMonstruoActual;
	    while (posicionesIterador.hasNext()) {
	    	cartaMonstruoActual = posicionesIterador.next();
	    	cartaMonstruoActual.eliminarModificadorDeAtaque();
	    	cartaMonstruoActual.eliminarModificadorDeDefensa();
	    	cartaMonstruoActual.aumentarDefensaEn(this.puntosDeDefensaExtra);
	    }
	}

	public Atacable obtenerMonstruoConMenorAtaque() {
		
		if( posiciones.isEmpty() ) { throw new NoHayMonstruoParaSacrificarException(); };
		
		Iterator<Atacable> posicionesIterador = this.posiciones.iterator();		
		Atacable cartaMonstruoMenorPuntaje = posicionesIterador.next();
	        
	    while ( posicionesIterador.hasNext() ) {
	    	
	    	Atacable cartaActual = posicionesIterador.next();
	    	if(cartaMonstruoMenorPuntaje.tieneMasPuntosDeAtaqueQue(cartaActual)) {
	    		
	    		cartaMonstruoMenorPuntaje = cartaActual;
	    		
	    	}
	    	
	    }
		return cartaMonstruoMenorPuntaje;
	}
	
	public boolean tieneElMonstruoTantasVeces(String nombreDelMonstruo, int cantidadDeVeces) {
		int vecesEncontrada = 0;
		Iterator<Atacable> posicionesIterator = this.posiciones.iterator();
		Atacable monstruoActual;
		while(posicionesIterator.hasNext()) {
			monstruoActual = posicionesIterator.next();
			if( nombreDelMonstruo == monstruoActual.obtenerNombre() ) {
				vecesEncontrada++;
			}
		}
		
		return ( vecesEncontrada >= cantidadDeVeces );
	}
	
	public void sacrificarA(String nombreDelMonstruo) {
		boolean destruido = false;
		Iterator<Atacable> posicionesIterator = this.posiciones.iterator();
		Atacable monstruoActual;
		while(posicionesIterator.hasNext() && !destruido) {
			monstruoActual = posicionesIterator.next();
			if( nombreDelMonstruo == monstruoActual.obtenerNombre() ) {
				monstruoActual.destruirCarta();
				destruido = true;
			}
		}
	}
	
	public Atacable obtenerCarta(String nombre) {
		Atacable carta = null;
		boolean encontrado = false;
		Iterator<Atacable> posicionesIterator = this.posiciones.iterator();
		Atacable monstruoActual;
	
		while( posicionesIterator.hasNext() && !encontrado ) {
	
			monstruoActual = posicionesIterator.next();
	
			if( nombre.equals(monstruoActual.obtenerNombre()) ) {
				carta = monstruoActual;
				encontrado = true;
			}
		}
		if( !encontrado ) { throw new NoHayCartasException(); };
			return carta;
	}

	public LinkedList<String> obtenerNombresDeCartasAtacables() {
		
		LinkedList<String> cartasAtacables = new LinkedList<String>();
		Atacable cartaActual;
		
		Iterator<Atacable> posicionesIterator = this.posiciones.iterator();
		while ( posicionesIterator.hasNext() ) {
			
			cartaActual = posicionesIterator.next();
			cartasAtacables.add(cartaActual.obtenerNombre());
	
		}
		
		return cartasAtacables;
	}
	
	public LinkedList<String> obtenerNombresDeCartasAtacablesEnModoAtaque() {
		
		LinkedList<String> cartasAtacables = new LinkedList<String>();
		Atacable cartaActual;
		
		Iterator<Atacable> posicionesIterator = this.posiciones.iterator();
		while ( posicionesIterator.hasNext() ) {
			
			cartaActual = posicionesIterator.next();
			if (cartaActual.estaEnModoAtaque()) {
				cartasAtacables.add(cartaActual.obtenerNombre());
			}
	
		}
		
		return cartasAtacables;
	}

	public LinkedList<Atacable> obtenerMonstruosColocados() {
		LinkedList<Atacable> cartasColocadas = new LinkedList<Atacable>();
		Atacable cartaActual;
		
		Iterator<Atacable> posicionesIterator = this.posiciones.iterator();
		while(posicionesIterator.hasNext()) {
			
			cartaActual = posicionesIterator.next();
			cartasColocadas.add(cartaActual);
		}
		
		
		return cartasColocadas;
	}
	
	public void reiniciarAtaquesMonstruos() {
		
		Atacable cartaActual;
		
		Iterator<Atacable> posicionesIterator = this.posiciones.iterator();
		while(posicionesIterator.hasNext()) {
			
			cartaActual = posicionesIterator.next();
			cartaActual.setAtacoEsteTurno(false);
		
		}
		
	}
	
	public void reiniciarSeCambioElEstadoEsteTurno() {
		
		Atacable cartaActual;
		
		Iterator<Atacable> posicionesIterator = this.posiciones.iterator();
		while(posicionesIterator.hasNext()) {
			
			cartaActual = posicionesIterator.next();
			cartaActual.setSeCambioElEstadoEsteTurno(false);
		
		}
		
	}
	

}
