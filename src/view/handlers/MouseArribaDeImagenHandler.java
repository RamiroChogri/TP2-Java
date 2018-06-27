package view.handlers;

import javafx.event.EventHandler;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import view.CajaInformacion;

public class MouseArribaDeImagenHandler implements EventHandler<MouseEvent>{
	
	private CajaInformacion cajaInformacion;
	private ImageView imagen;
	
	public MouseArribaDeImagenHandler(ImageView imagen , CajaInformacion cajaInformacion) {
		this.cajaInformacion = cajaInformacion;
		this.imagen = imagen;
	}
	
        public void handle(MouseEvent t) {
        	cajaInformacion.zoomAImagen(imagen.getImage());
        }
}
