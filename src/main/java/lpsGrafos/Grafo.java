package lpsGrafos;

import java.util.List;

import lpsGrafos.Nodo;

public interface Grafo {
	public void addNodo(String nombre);
	public void addArco(String origen, String destino, int peso) throws Exception;
	public Nodo buscarNodo(String nombre); 
	public boolean existeRuta(String origen, String destino) throws Exception;
	public List<Nodo> buscarRuta(String origen, String destino) throws Exception;
}
