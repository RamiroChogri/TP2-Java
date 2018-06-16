package estrategias;

public class EstrategiaBocaAbajo implements Estrategia {
	
	public EstrategiaBocaArriba voltear() {
		return new EstrategiaBocaArriba();
	}

}
