package cartas;

public abstract class CartaMonstruoDecorator implements Atacable {

	private Atacable atacable;

	public CartaMonstruoDecorator(Atacable atacableAColocar) {
		this.setAtacable(atacableAColocar);
	}
	
	public void setAtacable(Atacable atacableAColocar) {
		this.atacable = atacableAColocar;
	}
	
	public Atacable getAtacable() {
		return this.atacable;
	}
	
	
}
