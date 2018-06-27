package view.handlers;

import javafx.event.EventHandler;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import view.MenuDelDuelo;

public class EscOnKeyPressedHandler implements EventHandler<KeyEvent>{

	private Stage stage;
	private MenuDelDuelo menu;

	public EscOnKeyPressedHandler(Stage stage, MenuDelDuelo menu) {
		this.stage = stage;
		this.menu = menu;
	}

	public void handle(KeyEvent event) {

		if (event.getCode() == KeyCode.ESCAPE) {
			stage.setMaximized(true);
			menu.aplicacionMaximizada();
		}
	}
}
