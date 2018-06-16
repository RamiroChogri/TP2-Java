package modos;

public class ModoDefensa extends Modo {

	@Override
	public ModoDefensa colocarEnModoDefensa() {
		return this;
	}
	
	//Agregar algo que impida atacar pero que impida que el jugador pierda vida
	//Esto deberia ser un atributo exclusivo de las cartas Monstruo y actuar solo cuando estan
	//invocadas
	
}
