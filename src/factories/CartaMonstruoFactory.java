package factories;

import cartas.AtacaComoJinzo7;
import cartas.Atacable;
import cartas.CartaMonstruo;
import cartas.RecibeAtaqueComoInsectoComeHombres;
import cartas.Puntos;
import efectos.Efecto;
import InvocacionStrategy.*;
public class CartaMonstruoFactory {

		public CartaMonstruoFactory() {
			
		}
		
		public Atacable crearDragonDefinitivoDeOjosAzules() {
			
			Puntos puntosDeAtaque = new Puntos(4500);
			Puntos puntosDeDefensa = new Puntos(3800);
			int estrellas = 12;
			ReglaDeInvocacionStrategy regla = new ReglaDragonBlancoDefinitivoStrategy();
			
			Atacable dragonBlancoDefinitivo = new CartaMonstruo(puntosDeAtaque, puntosDeDefensa, estrellas, regla, "Dragon Definitivo De Ojos Azules");
			
			return dragonBlancoDefinitivo;			
		}
		public Atacable crearDragonBlancoDeOjosAzules() {
			
			Puntos puntosDeAtaque = new Puntos(3000);
			Puntos puntosDeDefensa = new Puntos(2500);
			int estrellas = 8;
			ReglaDeInvocacionStrategy regla = new ReglaDeMonstruoGrandeStrategy();
			
			Atacable dragonBlancoDeOjosAzules = new CartaMonstruo(puntosDeAtaque, puntosDeDefensa, estrellas, regla,"Dragon Blanco De Ojos Azules");
			
			return dragonBlancoDeOjosAzules;
		}
		
		public Atacable crearMagoOscuro() {
			Puntos puntosDeAtaque = new Puntos(2500);
			Puntos puntosDeDefensa = new Puntos(2100);
			int estrellas = 7;
			ReglaDeInvocacionStrategy regla = new ReglaDeMonstruoGrandeStrategy();
			
			Atacable magoOscuro = new CartaMonstruo(puntosDeAtaque, puntosDeDefensa, estrellas, regla, "Mago Oscuro");
			
			return magoOscuro;
		}
		
		public Atacable crearZoa() {
			Puntos puntosDeAtaque = new Puntos(2600);
			Puntos puntosDeDefensa = new Puntos(1900);
			int estrellas = 7;
			ReglaDeInvocacionStrategy regla = new ReglaDeMonstruoGrandeStrategy();
			
			Atacable zoa = new CartaMonstruo(puntosDeAtaque, puntosDeDefensa, estrellas, regla, "Zoa");
			
			return zoa;
		}
	
		public Atacable crearCraneoConvocado() {
			Puntos puntosDeAtaque = new Puntos(2500);
			Puntos puntosDeDefensa = new Puntos(1200);
			int estrellas = 5;
			ReglaDeInvocacionStrategy regla = new ReglaDeMonstruoMedianoStrategy();
			
			Atacable craneoConvocado = new CartaMonstruo(puntosDeAtaque, puntosDeDefensa, estrellas, regla,"Craneo Convocado");
			
			return craneoConvocado;	
		}
		

		public Atacable crearEspadachinVengador() {
			Puntos puntosDeAtaque = new Puntos(2000);
			Puntos puntosDeDefensa = new Puntos(1600);
			int estrellas = 6;
			ReglaDeInvocacionStrategy regla = new ReglaDeMonstruoMedianoStrategy();
			
			Atacable espadachinVengador = new CartaMonstruo(puntosDeAtaque, puntosDeDefensa, estrellas, regla, "Espadachin Vengador");
			
			return espadachinVengador;
		}
		
		public Atacable crearBueyDeBatalla() {
			Puntos puntosDeAtaque = new Puntos(1700);
			Puntos puntosDeDefensa = new Puntos(1000);
			int estrellas = 4;
			ReglaDeInvocacionStrategy regla = new ReglaDeMonstruoChicoStrategy();
			
			Atacable bueyDeBatalla = new CartaMonstruo(puntosDeAtaque, puntosDeDefensa, estrellas, regla, "Buey De Batalla");
			
			return bueyDeBatalla;
		}
		
		public Atacable crearConejoOscuro() {
			Puntos puntosDeAtaque = new Puntos(1100);
			Puntos puntosDeDefensa = new Puntos(1500);
			int estrellas = 4;
			ReglaDeInvocacionStrategy regla = new ReglaDeMonstruoChicoStrategy();
			
			Atacable conejoOscuro = new CartaMonstruo(puntosDeAtaque, puntosDeDefensa, estrellas, regla,"Conejo Oscuro");
			
			return conejoOscuro;
		}
		
		public Atacable crearDragonDeBrillo() {
			Puntos puntosDeAtaque = new Puntos(1900);
			Puntos puntosDeDefensa = new Puntos(1500);
			int estrellas = 4;
			ReglaDeInvocacionStrategy regla = new ReglaDeMonstruoChicoStrategy();
			
			Atacable dragonDeBrillo = new CartaMonstruo(puntosDeAtaque, puntosDeDefensa, estrellas, regla, "Dragon De Brillo");
			
			return dragonDeBrillo;
		}
		
		public Atacable crearDuendeMistico() {
			Puntos puntosDeAtaque = new Puntos(800);
			Puntos puntosDeDefensa = new Puntos(2000);
			int estrellas = 4;
			ReglaDeInvocacionStrategy regla = new ReglaDeMonstruoChicoStrategy();
			
			Atacable duendeMistico = new CartaMonstruo(puntosDeAtaque, puntosDeDefensa, estrellas, regla,"Duende Mistico");
			
			return duendeMistico;
		}
		
		public Atacable crearBetaElGuerreroMagnetico() {
			Puntos puntosDeAtaque = new Puntos(1700);
			Puntos puntosDeDefensa = new Puntos(1500);
			int estrellas = 4;
			ReglaDeInvocacionStrategy regla = new ReglaDeMonstruoChicoStrategy();
			
			Atacable betaElGuerreroMagnetico = new CartaMonstruo(puntosDeAtaque, puntosDeDefensa, estrellas, regla,"Beta El Guerrero Magnetico");
			
			return betaElGuerreroMagnetico;
		}
		
		public Atacable crearJineteVorse() {
			Puntos puntosDeAtaque = new Puntos(1900);
			Puntos puntosDeDefensa = new Puntos(1200);
			int estrellas = 4;
			ReglaDeInvocacionStrategy regla = new ReglaDeMonstruoChicoStrategy();
			
			Atacable jineteVorse = new CartaMonstruo(puntosDeAtaque, puntosDeDefensa, estrellas, regla, "Jinete Vorse");
			
			return jineteVorse;
		}
		
		public Atacable crearHeroeElementalAvian() {
			Puntos puntosDeAtaque = new Puntos(1000);
			Puntos puntosDeDefensa = new Puntos(1000);
			int estrellas = 3;
			ReglaDeInvocacionStrategy regla = new ReglaDeMonstruoChicoStrategy();
			
			Atacable avian = new CartaMonstruo(puntosDeAtaque, puntosDeDefensa, estrellas, regla,"Heroe Elemental Avian");
			
			return avian;
		}
		
		public Atacable crearDamaArpia() {
			Puntos puntosDeAtaque = new Puntos(1300);
			Puntos puntosDeDefensa = new Puntos(1400);
			int estrellas = 4;
			ReglaDeInvocacionStrategy regla = new ReglaDeMonstruoChicoStrategy();
			
			Atacable damaArpia = new CartaMonstruo(puntosDeAtaque, puntosDeDefensa, estrellas, regla,"Dama Arpia");
			
			return damaArpia;
		}
		
		public Atacable crearDragonDeKoumori() {
			Puntos puntosDeAtaque = new Puntos(1500);
			Puntos puntosDeDefensa = new Puntos(1200);
			int estrellas = 4;
			ReglaDeInvocacionStrategy regla = new ReglaDeMonstruoChicoStrategy();
			
			Atacable dragonDeKoumori = new CartaMonstruo(puntosDeAtaque, puntosDeDefensa, estrellas, regla, "Dragon De Koumori");
			
			return dragonDeKoumori;
		}
		
		public Atacable crearJinzo7() {
			Puntos puntosDeAtaque = new Puntos(500);
			Puntos puntosDeDefensa = new Puntos(400);
			int estrellas = 2;
			ReglaDeInvocacionStrategy regla = new ReglaDeMonstruoChicoStrategy();
			
			Atacable jinzo7 = new CartaMonstruo(puntosDeAtaque, puntosDeDefensa, estrellas, regla, "Jinzo 7");
			
			jinzo7 = new AtacaComoJinzo7(jinzo7);
			
			return jinzo7;
			
		}
		
		public Atacable crearInsectoComeHombres() {
			Puntos puntosDeAtaque = new Puntos(450);
			Puntos puntosDeDefensa = new Puntos(600);
			int estrellas = 2;
			ReglaDeInvocacionStrategy regla = new ReglaDeMonstruoChicoStrategy();
			
			Atacable insectoComeHombres = new CartaMonstruo(puntosDeAtaque, puntosDeDefensa, estrellas, regla, "Insecto Come Hombres");
			
			insectoComeHombres = new RecibeAtaqueComoInsectoComeHombres(insectoComeHombres);
			
			return insectoComeHombres;
		}
		
		public Atacable crearCabezaDeExodia() {
			Puntos puntosDeAtaque = new Puntos(1000);
			Puntos puntosDeDefensa = new Puntos(1000);
			int estrellas = 3;
			ReglaDeInvocacionStrategy regla = new ReglaDeMonstruoChicoStrategy();
			
			Atacable cabezaDeExodia = new CartaMonstruo(puntosDeAtaque, puntosDeDefensa, estrellas, regla, "Exodia , El Prohibido");
			
			return cabezaDeExodia;	
		}
		
		public Atacable crearBrazoIzquierdoExodia() {
			Puntos puntosDeAtaque = new Puntos(200);
			Puntos puntosDeDefensa = new Puntos(300);
			int estrellas = 1;
			ReglaDeInvocacionStrategy regla = new ReglaDeMonstruoChicoStrategy();
			
			Atacable brazoIzquierdoExodia = new CartaMonstruo(puntosDeAtaque, puntosDeDefensa, estrellas, regla, "Brazo Izquierdo De Exodia");
			
			return brazoIzquierdoExodia;
		}
		
		public Atacable crearBrazoDerechoExodia() {
			Puntos puntosDeAtaque = new Puntos(200);
			Puntos puntosDeDefensa = new Puntos(300);
			int estrellas = 1;
			ReglaDeInvocacionStrategy regla = new ReglaDeMonstruoChicoStrategy();
			
			Atacable brazoDerechoExodia = new CartaMonstruo(puntosDeAtaque, puntosDeDefensa, estrellas, regla, "Brazo Derecho De Exodia");
			
			return brazoDerechoExodia;
		}
		
		public Atacable crearPiernaIzquierdaExodia() {
			Puntos puntosDeAtaque = new Puntos(200);
			Puntos puntosDeDefensa = new Puntos(300);
			int estrellas = 1;
			ReglaDeInvocacionStrategy regla = new ReglaDeMonstruoChicoStrategy();
			
			Atacable piernaIzquierdaExodia = new CartaMonstruo(puntosDeAtaque, puntosDeDefensa, estrellas, regla, "Pierna Izquierda De Exodia");
			
			return piernaIzquierdaExodia;
		}
		
		public Atacable crearPiernaDerechaExodia() {
			Puntos puntosDeAtaque = new Puntos(200);
			Puntos puntosDeDefensa = new Puntos(300);
			int estrellas = 1;
			ReglaDeInvocacionStrategy regla = new ReglaDeMonstruoChicoStrategy();
			
			Atacable piernaDerechaExodia = new CartaMonstruo(puntosDeAtaque, puntosDeDefensa, estrellas, regla, "Pierna Derecha De Exodia");
			
			return piernaDerechaExodia;
		}
		
}
