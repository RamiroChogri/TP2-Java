package efectos;

import campo.Campo;
import cartas.Atacable;
import exceptions.NoHayMonstruoParaSacrificarException;
import view.CajaConsola;

public class EfectoFisura extends Efecto {

	@Override
	public void aplicarEfecto(Campo campoPropio, Campo campoEnemigo) {
		try {
			Atacable cartaConMenorAtaque = campoEnemigo.obtenerCartaMonstruoConMenorAtaque();
			cartaConMenorAtaque.destruirCarta();
			campoEnemigo.enviarCartasDestruidasAlCementerio();
		} catch (NoHayMonstruoParaSacrificarException noHayCartasEnLaZonaMonstruoEnemiga) {
			//No se destruye nada
		}
	}

	@Override
	public void aplicarEfecto(Campo campoPropio, Campo campoEnemigo, Atacable atacante, Atacable atacado) {
		// TODO Auto-generated method stub
		
	}
	
}
