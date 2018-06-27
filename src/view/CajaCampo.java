package view;

import javafx.geometry.Pos;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;

public class CajaCampo extends VBox{

	public CajaCampo() {
		ManoJugador manoJugador1 = new ManoJugador();
		manoJugador1.setAlignment(Pos.BOTTOM_CENTER);
		
		ManoJugador manoJugador2 = new ManoJugador();
		manoJugador2.setAlignment(Pos.TOP_CENTER);
		
		EspacioCarta espacioTest = new EspacioCarta();
		
		this.setSpacing(15);
		this.setAlignment(Pos.CENTER);
		VBox.setVgrow(manoJugador2, Priority.ALWAYS);
		VBox.setVgrow(manoJugador1, Priority.ALWAYS);
		this.getChildren().addAll(manoJugador2,espacioTest,manoJugador1);
		
	}
}
