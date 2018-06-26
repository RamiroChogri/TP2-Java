package view;


import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Vista extends Application{

	
	public static void main(String[] args) {
		 launch(args);
		 }
	
	 public void start(Stage stage) throws Exception {
		 stage.setTitle("Al-go-oh! Prototype");
		 
		 ContenedorDelDuelo contenedorDelDuelo = new ContenedorDelDuelo(stage);
		 Scene escenaDelDuelo = new Scene(contenedorDelDuelo,1190,670);
		 ContenedorDeBienvenida contenedorBienvenida = new ContenedorDeBienvenida(stage,escenaDelDuelo);
		
		 Scene escenaDeBienvenida = new Scene(contenedorBienvenida,1190,670);
		 stage.setScene(escenaDeBienvenida);
	     stage.setFullScreenExitHint("Presione la tecla ESC para salir del modo pantalla completa");
	     stage.setFullScreen(true);
	     escenaDeBienvenida.getStylesheets().add("view/Style.css");
//	     escenaDelDuelo.getStylesheets().add("view/Style.css"); hace nuevo css
		 stage.show();
	 }
}
