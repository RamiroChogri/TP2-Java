package campo;

import java.util.Collections;
import java.util.EmptyStackException;
import java.util.LinkedList;
import java.util.Stack;

import cartas.Colocable;
import exceptions.NoQuedanCartasEnElMazoException;
import factories.*;
import cartas.CartaMonstruo;

public class Mazo {

	private Stack<Colocable> mazo;
	
	public Mazo() {
		CartaMonstruoFactory fabricaMonstruos = new CartaMonstruoFactory();
		CartaMagicaFactory fabricaMagicas = new CartaMagicaFactory();
		CartaTrampaFactory fabricaTrampas = new CartaTrampaFactory();
		CartaCampoFactory fabricaCampo = new CartaCampoFactory();
		
		this.mazo = new Stack<Colocable>();
		
		this.mazo.add(fabricaMagicas.crearAgujeroNegro());
		this.mazo.add(fabricaMagicas.crearFisura());
		this.mazo.add(fabricaMagicas.crearOllaDeLaCodicia());
		
		this.mazo.add(fabricaTrampas.crearCilindroMagico());
		this.mazo.add(fabricaTrampas.crearRefuerzos());
		
		this.mazo.add(fabricaCampo.crearSogen());
		this.mazo.add(fabricaCampo.crearWasteland());
		
		this.mazo.add(fabricaMonstruos.crearCabezaDeExodia());
		this.mazo.add(fabricaMonstruos.crearBrazoIzquierdoExodia());
		this.mazo.add(fabricaMonstruos.crearBrazoDerechoExodia());
		this.mazo.add(fabricaMonstruos.crearPiernaIzquierdaExodia());
		this.mazo.add(fabricaMonstruos.crearPiernaDerechaExodia());
		
		this.mazo.add(fabricaMonstruos.crearDragonDefinitivoDeOjosAzules());
		
		for (int i=0; i<3; i++) {
			this.mazo.add(fabricaMonstruos.crearDragonBlancoDeOjosAzules());
			
			this.mazo.add(fabricaMonstruos.crearBetaElGuerreroMagnetico());
			this.mazo.add(fabricaMonstruos.crearBueyDeBatalla());
			this.mazo.add(fabricaMonstruos.crearConejoOscuro());
			this.mazo.add(fabricaMonstruos.crearCraneoConvocado());
			
		}
		
		this.mazo.add(fabricaMonstruos.crearDamaArpia());
		this.mazo.add(fabricaMonstruos.crearDragonDeBrillo());
		this.mazo.add(fabricaMonstruos.crearDragonDeKoumori());
		this.mazo.add(fabricaMonstruos.crearDuendeMistico());
		
		this.mazo.add(fabricaMonstruos.crearEspadachinVengador());
		this.mazo.add(fabricaMonstruos.crearHeroeElementalAvian());
		this.mazo.add(fabricaMonstruos.crearInsectoComeHombres());
		this.mazo.add(fabricaMonstruos.crearJineteVorse());
		
		this.mazo.add(fabricaMonstruos.crearJinzo7());
		this.mazo.add(fabricaMonstruos.crearMagoOscuro());
		this.mazo.add(fabricaMonstruos.crearZoa());
		this.mazo.add(fabricaMonstruos.crearJineteVorse());
		
		Collections.shuffle(mazo);
		this.mazo.add(fabricaMonstruos.crearJinzo7());
		
	}
	
	public int obtenerCantidaDeCartas() {
		return this.mazo.size();
	}
	
	public Colocable levantarCarta() {
		Colocable cartaADevolver;
		try {
			cartaADevolver =  this.mazo.pop();
		} catch (EmptyStackException error) {
			throw new NoQuedanCartasEnElMazoException();
		}

		return cartaADevolver;
	}
}
