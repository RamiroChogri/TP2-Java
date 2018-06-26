package view.handlers;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.MenuItem;
import javafx.stage.Stage;

public class BotonPantallaCompletaHandler implements EventHandler<ActionEvent> {

	Stage stage;
    MenuItem botonPantallaCompleta;

    public BotonPantallaCompletaHandler(Stage stage, MenuItem botonPantallaCompleta) {
        this.stage = stage;
        this.botonPantallaCompleta = botonPantallaCompleta;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        if (!stage.isFullScreen()) {
            stage.setFullScreen(true);
            stage.show();
        }
    }
}
