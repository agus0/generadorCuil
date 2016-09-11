package funciones;

import java.awt.Desktop;
import java.net.URI;

public class Funciones {
	
	public static void openURL (String url) {
		if(java.awt.Desktop.isDesktopSupported()){
			 try{
			      Desktop dk = Desktop.getDesktop();
			      dk.browse(new URI(url));
			 }catch(Exception e){
			     System.out.println("Error al abrir URL: "+e.getMessage());
			 }
		} 
	}
	
}
