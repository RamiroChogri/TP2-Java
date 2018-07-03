package viewSupportFiles;

public interface PathArchivos {
	//Ambos tienen que tener el "file:///" antes, el de musica tiene que ser con // entre directorios,
	//el de imagenes con / esta bien, no puede haber espacios, en donde iria un espacio se pone un %20.
	//CAMBIAR EL PATH EN ARCHIVO .CSS SECCION ROOT 
	String pathDeImagenes = "file:src/viewSupportFiles/";
	String pathDeMusica = "file:///C://Users//marcelo//Documents//Desktop//Algo%203//TP2-Java//src//viewSupportFiles/";
	String pathDePackCartas ="file:src/viewSupportFiles/imagenesCartas/";
}
