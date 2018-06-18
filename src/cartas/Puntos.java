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
	
	public int obtenerDiferenciaCon(Puntos otrosPuntos) {
		int diferencia = -1 * otrosPuntos.obtenerDiferenciaConCantidad(this.puntos);
		
		return diferencia;
	}
	
	public int obtenerDiferenciaConCantidad(int cantidadDePuntos) {
		int diferencia = this.puntos - cantidadDePuntos;
		
		return diferencia;
		
	}
	
	//Ver si se quiere agregar un metodo para decrementar o si usar este con parametros negativos
	
	public void aumentar(int puntosExtra) {
		this.puntos += puntosExtra;
	}
	
	public void eliminarModificadores() {
		this.puntos = this.puntosOriginales;
	}

	public boolean sonMayoresA(Puntos otrosPuntos) {
		
		return otrosPuntos.sonMenoresA(this.puntos);
	}

	private boolean sonMenoresA(int cantidadDePuntos) {
		
		return (this.puntos < cantidadDePuntos);
	}
	
}
