package factories;

import cartas.CartaMagica;
import efectos.*;

public class CartaMagicaFactory {

	public CartaMagicaFactory() {
		
	}
	
	public CartaMagica crearAgujeroNegro() {
		
		EfectoAgujeroNegro efecto = new EfectoAgujeroNegro();
		
		CartaMagica agujeroNegro = new CartaMagica(efecto);
		
		agujeroNegro.setNombre("Agujero Negro");
		
		return agujeroNegro;
	}
	
	public CartaMagica crearOllaDeLaCodicia() {
		EfectoPotOfGreed efecto = new EfectoPotOfGreed();
		
		CartaMagica ollaDeLaCodicia = new CartaMagica(efecto);
		
		ollaDeLaCodicia.setNombre("Olla De La Codicia");
		
		return ollaDeLaCodicia;
	}
	
	public CartaMagica crearFisura() {
		EfectoFisura efecto = new EfectoFisura();
		
		CartaMagica fisura = new CartaMagica(efecto);
		
		fisura.setNombre("Fisura");
		
		return fisura;
	}
}
