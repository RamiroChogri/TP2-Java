package InvocacionStrategy;

import campo.ZonaMonstruos;
import cartas.CartaMonstruo;

public abstract class ReglaDeInvocacionStrategy {

	public abstract void colocarCarta(ZonaMonstruos zonaMonstruos, CartaMonstruo cartaAColocar);

}
