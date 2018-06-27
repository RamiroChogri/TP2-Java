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
		
		EspacioCartasCampo campoJ1 = new EspacioCartasCampo();
		EspacioCartasCampo campoJ2 = new EspacioCartasCampo(180);
		
		this.setSpacing(15);
		this.setAlignment(Pos.CENTER);
		VBox.setVgrow(manoJugador2, Priority.ALWAYS);
		VBox.setVgrow(manoJugador1, Priority.ALWAYS);
		VBox.setVgrow(campoJ1, Priority.ALWAYS);
		
		this.getChildren().addAll(manoJugador2,campoJ2,campoJ1,manoJugador1);
		
		this.setStyle("-fx-background-color: BLACK");
		
	}
}
