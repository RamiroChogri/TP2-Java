package cartas;

import estadoCarta.EstadoCarta;
import estadoCarta.EstadoCartaColocadaBocaAbajo;
import estadoCarta.EstadoCartaColocadaBocaArriba;
import estadoCarta.EstadoCartaDestruida;
import estadoCarta.EstadoCartaNoJugada;

import java.util.Scanner;

import campo.Campo;
import campo.Cementerio;
import campo.ZonaCampo;
import campo.ZonaMagicasYTrampas;
import campo.ZonaMonstruos;
import efectos.*;
import exceptions.*;
import jugador.Jugador;
import modos.Modo;
import modos.ModoDefensa;

public class CartaMagica implements Activable{
	
	protected EstadoCarta estado;
	protected Efecto efecto;
	private String nombre;
	private Scanner teclado;
	private String nombreImagen;
	
	public CartaMagica() {
		
		this.estado = new EstadoCartaNoJugada();
		Efecto efectoNulo = new EfectoNulo();
		this.efecto = efectoNulo;
		this.nombre = " ";
		this.teclado = new Scanner(System.in);
		this.nombreImagen = " ";
	}
	
	public CartaMagica(Efecto efectoAColocar) {
		
		this.estado = new EstadoCartaNoJugada();
		this.efecto = efectoAColocar;
		this.nombre = " ";
		this.nombreImagen = " ";
		this.teclado = new Scanner(System.in);
		
	}
	
	public void setNombreDeLaImagen(String nombreDeLaImagen) {
		this.nombreImagen = nombreDeLaImagen;
	}
	
	public String getNombreDeLaImagen() {
		return this.nombreImagen;
	}
	
	public void setNombre(String nombreDeLaCarta) {
		this.nombre = nombreDeLaCarta;
	}
	
	public void destruirCarta() {
	
		this.estado = new EstadoCartaDestruida();

	}

	public void colocarBocaAbajo() {
	
		this.estado = new EstadoCartaColocadaBocaAbajo();
		
	}

	public void colocarBocaArriba() {
		
		this.estado = new EstadoCartaColocadaBocaArriba();
		
	}

	public boolean estaColocadaBocaAbajo() {
		return ( this.estado.estaBocaAbajo() );
	}

	public boolean estaColocadaBocaArriba() {
		return ( this.estado.estaBocaArriba() );
	}
	
	public boolean estaDestruida() {
		return this.estado.estaDestruida();
	}
	
	public Efecto obtenerEfecto() {
		return this.efecto;
	}


	public void aplicarEfecto(Campo campo, Campo campoEnemigo) {
	
		if(this.estaColocadaBocaAbajo()) {
			throw new CartaBocaAbajoNoPuedeActivarEfectoException();
		}
		
		this.efecto.aplicarEfecto(campo, campoEnemigo);
		this.destruirCarta();
		campo.enviarCartasDestruidasAlCementerio();
		campoEnemigo.enviarCartasDestruidasAlCementerio();
	}

	public void colocarse(Jugador jugador, ZonaMonstruos zonaMonstruos, ZonaMagicasYTrampas zonaMagicasYTrampas, ZonaCampo zonaCampo, Cementerio cementerio, EstadoCarta estadoAColocar) {
		this.estado = estadoAColocar;
		zonaMagicasYTrampas.colocarCarta(this);
		
		if (estado.estaBocaArriba()) {
			jugador.aplicarEfectoCarta(this);
		}
	}

	public void cambiarA(Modo modoACambiar) {
		//metodo forzado
	}
	
	public boolean esDeTrampa() {
		
		return false;
	}

	@Override
	public String obtenerNombre() {
		
		return nombre;
	}

	@Override
	public void aplicarEfecto(Campo campoPropio, Campo campoEnemigo, Atacable atacante, Atacable atacado) {
		
	}

	@Override
	public void voltear(Campo campoPropio, Campo campoEnemigo) {
		if(this.estaColocadaBocaArriba()) {
			throw new CartaBocaArribaNoSePuedeVoltearException();
		}
		
		this.colocarBocaArriba();
		this.aplicarEfecto(campoPropio, campoEnemigo);
	}
	
	//////////////////////////////////////
	
	@Override
	public EstadoCarta elegirComoColocar() {
	
		String estado = this.pedirEstadoCarta();
		EstadoCarta estadoADevolver = null;
		
		if (estado == "arriba") {
			estadoADevolver = new EstadoCartaColocadaBocaArriba();
		
		} else {
			estadoADevolver = new EstadoCartaColocadaBocaAbajo();
		}
		
		return estadoADevolver;
		
	}
	
	public String pedirEstadoCarta() {
		
		System.out.println("Ingrese 'arriba' o ' abajo' para indicar como quiere colocar la carta");
		String nombreEstado = teclado.nextLine();
		while ((!nombreEstado.equals("arriba")) && (!nombreEstado.equals("abajo"))) {
			System.out.println("Ingrese un estado valido");
			nombreEstado = this.teclado.nextLine();
		}
		
		return nombreEstado;
	}
	
	public boolean esActivable() {
		return true;
	}
	
	public boolean esAtacable() {
		return false;
	}
	
	
}