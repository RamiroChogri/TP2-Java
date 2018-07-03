package view;


import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import partida.Partida;
import view.handlers.EscOnKeyPressedHandler;

public class Vista extends Application{

	
	public static void main(String[] args) {
		 launch(args);
		 }
	
	 public void start(Stage stage) throws Exception {
		 stage.setTitle("Al-go-oh! Prototype");
		 
		 Partida duelo = new Partida();
		 
		 ContenedorDelDuelo contenedorDelDuelo = new ContenedorDelDuelo(stage,duelo);
		 Scene escenaDelDuelo = new Scene(contenedorDelDuelo,1190,670);
		 ContenedorDeBienvenida contenedorBienvenida = new ContenedorDeBienvenida(stage,escenaDelDuelo);
		 
		 EscOnKeyPressedHandler salirPantallaCompleta = new EscOnKeyPressedHandler(stage,contenedorDelDuelo.getBarraDeMenu());
		 escenaDelDuelo.setOnKeyPressed(salirPantallaCompleta);
		
		 Scene escenaDeBienvenida = new Scene(contenedorBienvenida,1190,670);
		 stage.setScene(escenaDeBienvenida);
	     stage.setFullScreenExitHint("Presione la tecla ESC para salir del modo pantalla completa");
	     stage.setFullScreen(true);
	     escenaDeBienvenida.getStylesheets().add("viewSupportFiles/Style.css");
		 stage.show();
	 }
}
