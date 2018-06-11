package campo;

public class Campo {

	private ZonaMonstruo zonaMonstruo;
	private ZonaUtilidad zonaUtilidad;
	private ZonaCampo zonaCampo;
	private Cementerio cementerio;
	private Mazo mazo;
	
	
	public Campo() {
		//Todas las zonas se inicializan vacias y el mazo se inicializa con 40 cartas
		//ordenadas aleatoriamente
		zonaMonstruo = new ZonaMonstruo();
		zonaUtilidad = new ZonaUtilidad();
		zonaCampo = new ZonaCampo();
		cementerio = new Cementerio();
		mazo = new Mazo();
	}

	//Seguir con la excepcion
	
	public void colocarCarta(CartaMonstruo cartaMonstruoAColocar) {
		try {
			zonaMonstruo.colocar(cartaMonstruoAColocar);
		} catch (ZonaMonstruoLlenaException estaLlena) {
			System.out.println("No se puede invocar el monstruo, el campo esta lleno");
			throw new ZonaMonstruoLlenaException();
		}
		
	}
	
	public void colocarCarta(CartaMagica cartaMagicaAColocar) {
		try {
			zonaUtilidad.colocar(cartaMagicaAColocar);
		} catch (ZonaUtilidadLlenaException estaLlena) {
			System.out.println("No se puede invocar la carta magica, el campo esta lleno");
			throw new ZonaUtilidadLlenaException();
		}
	}
	
	public void colocarCarta(CartaTrampa cartaTrampaAColocar) {
		try {
			zonaUtilidad.colocar(cartaTrampaAColocar);
		} catch (ZonaUtilidadLlenaException estaLlena) {
			System.out.println("No se puede invocar la carta trampa, el campo esta lleno");
			throw new ZonaUtilidadLlenaException();
		}
	}
	
	public void colocarCarta(CartaCampo cartaCampoAColocar) {
		try {
			zonaCampo.colocar(cartaCampoAColocar);
		} catch (ZonaCampoLlenaException estaLlena) {
			System.out.println("No se puede invocar la carta campo, el campo esta lleno");
			throw new ZonaCampoLlenaException();
		}
	}
	
	public int obtenerCantidadDeCartasEnZonaMonstruo() {
		return zonaMonstruo.obtenerCantidadDeCartas();
	}
	
	
	public int obtenerCantidadDeCartasEnZonaUtilidad() {
		return zonaUtilidad.obtenerCantidadDeCartas();
	}
	
	public int obtenerCantidadDeCartasEnZonaCampo() {
		return zonaCampo.obtenerCantidadDeCartas();
	}
	
	public int obtenerCantidadDeCartasEnMazo() {
		return mazo.obtenerCantidaDeCartas();
	}
	
	public int obtenerCantidadDeCartasEnCementerio() {
		return cementerio.obtenerCantidadDeCartas();
	}
	
	
	public boolean tieneCartas() {

		return ((this.obtenerCantidadDeCartasEnZonaMonstruo() + this.obtenerCantidadDeCartasEnZonaUtilidad() + this.obtenerCantidadDeCartasEnZonaCampo()) > 0);

	}
}
