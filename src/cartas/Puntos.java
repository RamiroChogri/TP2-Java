package cartas;

public class Puntos {

	int puntosOriginales;
	int puntos;
	
	public Puntos(int puntosDeCartaAtacable) {
		this.puntosOriginales = puntosDeCartaAtacable;
		this.puntos = this.puntosOriginales;
	}
	
	public int obtener() {
		return this.puntos;
	}
	
	//Ver si se quiere agregar un metodo para decrementar o si usar este con parametros negativos
	
	public void aumentar(int puntosExtra) {
		this.puntos += puntosExtra;
	}
	
	public void eliminarModificadores() {
		this.puntos = this.puntosOriginales;
	}
	
}
