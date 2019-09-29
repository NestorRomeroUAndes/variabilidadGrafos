package lpsGrafos;

import java.io.FileReader;
import java.util.Properties;


public class Fabrica {
	
	public static String getOpcionGrafo() {
        // define un valor por defecto
        String opcionConfigurada = "normal";  
        
        try {
                // lee el archivo de configuración
                Properties opciones = new Properties();
                opciones.load(new FileReader("config.properties"));
                
                // revisa las opciones configuradas
                if (opciones.getProperty("normal", "false").equals("true")) {
                    opcionConfigurada = "normal";                                
                }

                if (opciones.getProperty("dirigido", "false").equals("true")) {
                    opcionConfigurada = "dirigido";                                
                }   
                if (opciones.getProperty("dirigidoConPeso", "false").equals("true")) {
                    opcionConfigurada = "DirigidoConPeso";                                
                }
        
        } catch (Exception e) {
                // ignora cualquier error leyendo el archivo
        } 
        
        return opcionConfigurada;
	}
	
	public static String getOpcionAlgo() {
        // define un valor por defecto
        String opcionConfigurada = "DFS";  
        
        try {
                // lee el archivo de configuración
                Properties opciones = new Properties();
                opciones.load(new FileReader("config.properties"));
                
                // revisa las opciones configuradas
                if (opciones.getProperty("DFS", "false").equals("true")) {
                    opcionConfigurada = "DFS";                                
                }

                if (opciones.getProperty("BFS", "false").equals("true")) {
                    opcionConfigurada = "BFS";                                
                }   
        
        } catch (Exception e) {
                // ignora cualquier error leyendo el archivo
        } 
        
        return opcionConfigurada;
	}
	
	public static Grafo  obtenerNuevoGrafo() {
		
		// obtiene la opción configurada
		String opcionGrafo = Fabrica.getOpcionGrafo();
		String opcionAlgo = Fabrica.getOpcionAlgo();
		
		//selecciona el algoritmo de busqueda segun la configuracion
		EstrategiaBusqueda algoritmo = null;
		switch(opcionAlgo) {
		
		case "DFS":
			algoritmo = new EstrategiaBusquedaDFS();
			break;
		
		case "BFS":
			algoritmo = new EstrategiaBusquedaBFS();
			break;
		}
		
		// crea el Grafo de acuerdo a la opción configurada
		Grafo grafo = null;
		switch(opcionGrafo) {
		
		case "normal":
			grafo = new GrafoNormal(algoritmo);
			break;
		
		case "dirigido":
			grafo = new GrafoDirigido(algoritmo);
			break;
			
		case "dirigidoConPeso":
			grafo = new GrafoDirigidoConPeso(algoritmo);
			break;
		}
		
		return grafo;
	}
}
