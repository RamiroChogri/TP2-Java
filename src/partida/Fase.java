package partida;

public class Fase {

	private Fase faseSiguiente;
	
	public Fase() {
		this.faseSiguiente = this;
	}
	
	public void setFaseSiguiente(Fase faseSiguienteAColocar) {
		this.faseSiguiente = faseSiguienteAColocar;
	}
	
	public Fase obtenerSiguiente() {
		return this.faseSiguiente;
	}
}
