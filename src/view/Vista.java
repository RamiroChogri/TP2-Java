package view;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Vista extends Application{

	
	public static void main(String[] args) {
		 launch(args);
		 }
	
	 public void start(Stage stage) throws Exception {
		 stage.setTitle("Al-go-oh! Prototype");
		 
		 VBox verticalBox = new VBox();
		 Scene escenaDelDuelo = new Scene(verticalBox,640,480);
		 ContenedorDeBienvenida contenedorBienvenida = new ContenedorDeBienvenida(stage,escenaDelDuelo);
		
		 
		 Scene escenaDeBienvenida = new Scene(contenedorBienvenida,640,480);
		 stage.setScene(escenaDeBienvenida);
	     stage.setFullScreenExitHint("Presione la tecla ESC para salir del modo pantalla completa");
	     stage.setFullScreen(true);
	     escenaDeBienvenida.getStylesheets().add("view/ButtonStyle.css");
		 stage.show();
	 }
}
