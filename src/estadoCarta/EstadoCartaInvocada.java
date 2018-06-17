package estadoCarta;

import estrategias.*;
import modos.*;

public class EstadoCartaInvocada extends EstadoCarta {

	private Modo modo;
	private Estrategia boca;
	
	public EstadoCartaInvocada(Estrategia bocaRecibida, Modo modoRecibido) {
		this.modo = modoRecibido;
		this.boca = bocaRecibida;
	}
	
	
	
}
