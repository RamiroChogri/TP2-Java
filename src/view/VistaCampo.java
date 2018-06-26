package view;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class VistaCampo extends VBox {

	public VistaCampo() {
		super();
		this.setAlignment(Pos.BOTTOM_CENTER);
		
//		VistaZonaMonstruo zonaMonstruo = new VistaZonaMonstruo();
		
		HBox zonaMonstruosTest = new HBox();
		zonaMonstruosTest.setSpacing(10);
		zonaMonstruosTest.setAlignment(Pos.BOTTOM_CENTER);
		HBox zonaMagicaTest = new HBox();
		zonaMagicaTest.setSpacing(10);
		zonaMagicaTest.setAlignment(Pos.BOTTOM_CENTER);
		
//		EspacioCarta espacioCartaMonstruo1 = new EspacioCarta();
		
		Button btest = new Button("Test");
		Button btest2 = new Button("Test");
		
		zonaMonstruosTest.getChildren().addAll(btest);
		zonaMagicaTest.getChildren().addAll(btest2);
		
		this.getChildren().addAll(zonaMonstruosTest,zonaMagicaTest);
		
//		EspacioCarta espacioDeCarta = new EspacioCarta();
//		EspacioMazo espacioMazo = new EspacioMazo();
//		EspacioCementerio espacioCementerio = new EspacioCementerio();
		
		
	}
}
