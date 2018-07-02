package cartas;

import campo.*;
import estadoCarta.EstadoCarta;
import javafx.scene.image.ImageView;
import jugador.Jugador;
import modos.Modo;
import partida.Partida;
import view.CajaCampo;
import view.ContenedorDelDuelo;

public interface Colocable {
	
	public void colocarse(Jugador jugador, ZonaMonstruos monstruos ,ZonaMagicasYTrampas magicasYTrampas, ZonaCampo campo, Cementerio cementerio, EstadoCarta estadoAColocar);

	public void destruirCarta();

	public boolean estaDestruida();
	
	public String obtenerNombre();
	
	////////////////////////////////
	
	public EstadoCarta elegirComoColocar();
	
	public boolean esActivable();
	
	public boolean esAtacable();
	
	public boolean estaColocadaBocaArriba();
	
	public boolean estaColocadaBocaAbajo();
	
	
	//los metodos para poner los nombres de las imagenes para que la interfaz
	//la busque cuando se saca la carta del mazo
	//y no tenemos 80 imagenes cargadas todo el tiempo
	public void setNombreDeLaImagen(String nombreDeLaImagen);
	
	public String getNombreDeLaImagen();

	public void cambiarA(Modo modoACambiar);
	
	public void clickEnZona(Partida partida, Jugador jugadorDuenio, ContenedorDelDuelo cajaDuelo, ImageView imagenCarta);
}
