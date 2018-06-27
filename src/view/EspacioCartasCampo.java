package view;

import javafx.geometry.Pos;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class EspacioCartasCampo extends GridPane{
	
	public EspacioCartasCampo() {
		EspacioCarta espacioMosntruo1 = new EspacioCarta();
		EspacioCarta espacioMosntruo2 = new EspacioCarta();
		EspacioCarta espacioMosntruo3 = new EspacioCarta();
		EspacioCarta espacioMosntruo4 = new EspacioCarta();
		EspacioCarta espacioMosntruo5 = new EspacioCarta();
		
		EspacioCartaMagica espacioMagico1 = new EspacioCartaMagica();
		EspacioCartaMagica espacioMagico2 = new EspacioCartaMagica();
		EspacioCartaMagica espacioMagico3 = new EspacioCartaMagica();
		EspacioCartaMagica espacioMagico4 = new EspacioCartaMagica();
		EspacioCartaMagica espacioMagico5 = new EspacioCartaMagica();
		
		Rectangle espacioCementerio = new Rectangle(60,100,Color.GREY);
		Rectangle espacioMazo = new Rectangle(60,100,Color.BROWN);
		Rectangle espacioCampo = new Rectangle(60,100,Color.GREEN);
		Rectangle espacioRelleno = new Rectangle(60,100,Color.BLACK);
		
		this.setHgap(10);
		this.setVgap(10);
		this.addRow(0, espacioCampo,espacioMosntruo1,espacioMosntruo2,espacioMosntruo3,espacioMosntruo4,espacioMosntruo5,espacioCementerio);
		this.addRow(1,espacioRelleno, espacioMagico1,espacioMagico2,espacioMagico3,espacioMagico4,espacioMagico5,espacioMazo);
		
		this.setAlignment(Pos.CENTER);
	}
	
	public EspacioCartasCampo(int gradosDeRotacion) {
		EspacioCarta espacioMosntruo1 = new EspacioCarta();
		EspacioCarta espacioMosntruo2 = new EspacioCarta();
		EspacioCarta espacioMosntruo3 = new EspacioCarta();
		EspacioCarta espacioMosntruo4 = new EspacioCarta();
		EspacioCarta espacioMosntruo5 = new EspacioCarta();
		
		EspacioCartaMagica espacioMagico1 = new EspacioCartaMagica();
		EspacioCartaMagica espacioMagico2 = new EspacioCartaMagica();
		EspacioCartaMagica espacioMagico3 = new EspacioCartaMagica();
		EspacioCartaMagica espacioMagico4 = new EspacioCartaMagica();
		EspacioCartaMagica espacioMagico5 = new EspacioCartaMagica();
		
		Rectangle espacioCementerio = new Rectangle(60,100,Color.GREY);
		Rectangle espacioMazo = new Rectangle(60,100,Color.BROWN);
		Rectangle espacioCampo = new Rectangle(60,100,Color.GREEN);
		Rectangle espacioRelleno = new Rectangle(60,100,Color.BLACK);
		
		this.setHgap(10);
		this.setVgap(10);
		this.addRow(1,espacioCementerio,espacioMosntruo5,espacioMosntruo4,espacioMosntruo3,espacioMosntruo2,espacioMosntruo1,espacioCampo);
		this.addRow(0,espacioMazo,espacioMagico5,espacioMagico4,espacioMagico3,espacioMagico2,espacioMagico1,espacioRelleno);
		
		this.setAlignment(Pos.CENTER);
	}
}
