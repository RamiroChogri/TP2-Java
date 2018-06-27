package view.handlers;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import view.CajaInformacion;

public class MouseSalirArribaDeImagenHandler implements EventHandler<MouseEvent>{
	
	private CajaInformacion cajaInformacion;
	
	public MouseSalirArribaDeImagenHandler( CajaInformacion cajaInformacion) {
		this.cajaInformacion = cajaInformacion;
	}
	
        public void handle(MouseEvent t) {
        	cajaInformacion.quitarImagen();
        }
}
