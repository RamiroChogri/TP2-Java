package factories;

import cartas.CartaMonstruo;
import cartas.Puntos;
import InvocacionStrategy.*;
public class CartaMonstruoFactory {

		public CartaMonstruoFactory() {
			
		}
		
		public CartaMonstruo crearDragonDefinitivoDeOjosAzules() {
			
			Puntos puntosDeAtaque = new Puntos(4500);
			Puntos puntosDeDefensa = new Puntos(3800);
			int estrellas = 12;
			ReglaDeInvocacionStrategy regla = new ReglaDragonBlancoDefinitivoStrategy();
			
			CartaMonstruo dragonBlancoDefinitivo = new CartaMonstruo(puntosDeAtaque, puntosDeDefensa, estrellas, regla);
			dragonBlancoDefinitivo.setNombre("Dragon Definitivo De Ojos Azules");
			
			return dragonBlancoDefinitivo;			
		}
		public CartaMonstruo crearDragonBlancoDeOjosAzules() {
			
			Puntos puntosDeAtaque = new Puntos(3000);
			Puntos puntosDeDefensa = new Puntos(2500);
			int estrellas = 8;
			ReglaDeInvocacionStrategy regla = new ReglaDeMonstruoGrandeStrategy();
			
			CartaMonstruo dragonBlancoDeOjosAzules = new CartaMonstruo(puntosDeAtaque, puntosDeDefensa, estrellas, regla);
			dragonBlancoDeOjosAzules.setNombre("Dragon Blanco De Ojos Azules");
			
			return dragonBlancoDeOjosAzules;
		}
		
		public CartaMonstruo crearMagoOscuro() {
			Puntos puntosDeAtaque = new Puntos(2500);
			Puntos puntosDeDefensa = new Puntos(2100);
			int estrellas = 7;
			ReglaDeInvocacionStrategy regla = new ReglaDeMonstruoGrandeStrategy();
			
			CartaMonstruo magoOscuro = new CartaMonstruo(puntosDeAtaque, puntosDeDefensa, estrellas, regla);
			magoOscuro.setNombre("Mago Oscuro");
			
			return magoOscuro;
		}
		
		public CartaMonstruo crearZoa() {
			Puntos puntosDeAtaque = new Puntos(2600);
			Puntos puntosDeDefensa = new Puntos(1900);
			int estrellas = 7;
			ReglaDeInvocacionStrategy regla = new ReglaDeMonstruoGrandeStrategy();
			
			CartaMonstruo zoa = new CartaMonstruo(puntosDeAtaque, puntosDeDefensa, estrellas, regla);
			zoa.setNombre("Zoa");
			
			return zoa;
		}
	
		public CartaMonstruo crearCraneoConvocado() {
			Puntos puntosDeAtaque = new Puntos(2500);
			Puntos puntosDeDefensa = new Puntos(1200);
			int estrellas = 5;
			ReglaDeInvocacionStrategy regla = new ReglaDeMonstruoMedianoStrategy();
			
			CartaMonstruo craneoConvocado = new CartaMonstruo(puntosDeAtaque, puntosDeDefensa, estrellas, regla);
			craneoConvocado.setNombre("Craneo Convocado");
			
			return craneoConvocado;	
		}
		

		public CartaMonstruo crearEspadachinVengador() {
			Puntos puntosDeAtaque = new Puntos(2000);
			Puntos puntosDeDefensa = new Puntos(1600);
			int estrellas = 6;
			ReglaDeInvocacionStrategy regla = new ReglaDeMonstruoMedianoStrategy();
			
			CartaMonstruo espadachinVengador = new CartaMonstruo(puntosDeAtaque, puntosDeDefensa, estrellas, regla);
			espadachinVengador.setNombre("Espadachin Vengador");
			
			return espadachinVengador;
		}
		
		public CartaMonstruo crearBueyDeBatalla() {
			Puntos puntosDeAtaque = new Puntos(1700);
			Puntos puntosDeDefensa = new Puntos(1000);
			int estrellas = 4;
			ReglaDeInvocacionStrategy regla = new ReglaDeMonstruoChicoStrategy();
			
			CartaMonstruo bueyDeBatalla = new CartaMonstruo(puntosDeAtaque, puntosDeDefensa, estrellas, regla);
			bueyDeBatalla.setNombre("Buey De Batalla");
			
			return bueyDeBatalla;
		}
		
		public CartaMonstruo crearConejoOscuro() {
			Puntos puntosDeAtaque = new Puntos(1100);
			Puntos puntosDeDefensa = new Puntos(1500);
			int estrellas = 4;
			ReglaDeInvocacionStrategy regla = new ReglaDeMonstruoChicoStrategy();
			
			CartaMonstruo conejoOscuro = new CartaMonstruo(puntosDeAtaque, puntosDeDefensa, estrellas, regla);
			conejoOscuro.setNombre("Conejo Oscuro");
			
			return conejoOscuro;
		}
		
		public CartaMonstruo crearDragonDeBrillo() {
			Puntos puntosDeAtaque = new Puntos(1900);
			Puntos puntosDeDefensa = new Puntos(1500);
			int estrellas = 4;
			ReglaDeInvocacionStrategy regla = new ReglaDeMonstruoChicoStrategy();
			
			CartaMonstruo dragonDeBrillo = new CartaMonstruo(puntosDeAtaque, puntosDeDefensa, estrellas, regla);
			dragonDeBrillo.setNombre("Dragon De Brillo");
			
			return dragonDeBrillo;
		}
		
		public CartaMonstruo crearDuendeMistico() {
			Puntos puntosDeAtaque = new Puntos(800);
			Puntos puntosDeDefensa = new Puntos(2000);
			int estrellas = 4;
			ReglaDeInvocacionStrategy regla = new ReglaDeMonstruoChicoStrategy();
			
			CartaMonstruo duendeMistico = new CartaMonstruo(puntosDeAtaque, puntosDeDefensa, estrellas, regla);
			duendeMistico.setNombre("Duende Mistico");
			
			return duendeMistico;
		}
		
		public CartaMonstruo crearBetaElGuerreroMagnetico() {
			Puntos puntosDeAtaque = new Puntos(1700);
			Puntos puntosDeDefensa = new Puntos(1500);
			int estrellas = 4;
			ReglaDeInvocacionStrategy regla = new ReglaDeMonstruoChicoStrategy();
			
			CartaMonstruo betaElGuerreroMagnetico = new CartaMonstruo(puntosDeAtaque, puntosDeDefensa, estrellas, regla);
			betaElGuerreroMagnetico.setNombre("Beta El Guerrero Magnetico");
			
			return betaElGuerreroMagnetico;
		}
		
		public CartaMonstruo crearJineteVorse() {
			Puntos puntosDeAtaque = new Puntos(1900);
			Puntos puntosDeDefensa = new Puntos(1200);
			int estrellas = 4;
			ReglaDeInvocacionStrategy regla = new ReglaDeMonstruoChicoStrategy();
			
			CartaMonstruo jineteVorse = new CartaMonstruo(puntosDeAtaque, puntosDeDefensa, estrellas, regla);
			jineteVorse.setNombre("Jinete Vorse");
			
			return jineteVorse;
		}
		
		public CartaMonstruo crearHeroeElementalAvian() {
			Puntos puntosDeAtaque = new Puntos(1000);
			Puntos puntosDeDefensa = new Puntos(1000);
			int estrellas = 3;
			ReglaDeInvocacionStrategy regla = new ReglaDeMonstruoChicoStrategy();
			
			CartaMonstruo avian = new CartaMonstruo(puntosDeAtaque, puntosDeDefensa, estrellas, regla);
			avian.setNombre("Heroe Elemental Avian");
			
			return avian;
		}
}
