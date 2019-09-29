package lpsGrafos;

import java.util.ArrayList;
import java.util.List;

import lpsGrafos.Arco;

public class GrafoDirigidoConPeso implements Grafo {

	List<Nodo> nodos = new ArrayList<>();
	List<Arco> arcos = new ArrayList<>();
	EstrategiaBusqueda algo;
	
	//permitir la conexion del algoritmo de busqueda desde el constructor
	public GrafoDirigidoConPeso(EstrategiaBusqueda algo) {
		this.algo = algo;
	}
	
	public GrafoDirigidoConPeso() {
		//por defecto usar el metodo de busqueda dfs
		this.algo = new EstrategiaBusquedaDFS();
	}

	@Override
	public void addNodo(String nombre) {
		// TODO Auto-generated method stub
		Nodo nodo = new Nodo();
		nodo.setNombre(nombre);
		nodos.add(nodo);
	}

	@Override
	public void addArco(String origen, String destino, int peso) throws Exception {
		// TODO Auto-generated method stub
		Nodo nodoOrigen = buscarNodo(origen);
		Nodo nodoDestino = buscarNodo(destino);
		
		// Origen o destino no encontrado
		if (nodoOrigen == null) {
			throw new RuntimeException("Error en la Búsqueda: NodoOrigen no encontrado");
		}
		if (nodoDestino == null) {
			throw new RuntimeException("Error en la Búsqueda: NodoOrigen no encontrado");
		}
		
		addArco(nodoOrigen, nodoDestino, peso);
	}
	
	public void addArco(Nodo nodoOrigen, Nodo nodoDestino, int peso)
	{
		Arco arco = new Arco();
		arco.setOrigen(nodoOrigen);
		arco.setDestino(nodoDestino);
		arco.setPeso(peso);
		arcos.add(arco);
		nodoOrigen.agregarArco(arco);
	}

	@Override
	public Nodo buscarNodo(String nombre) {
		// TODO Auto-generated method stub
		for (Nodo nodo: nodos) {
			if (nodo.getNombre().equals(nombre)) {
				return nodo;
			}
		}
		return null;
	}

	@Override
	public boolean existeRuta(String origen, String destino) throws Exception {
		// TODO Auto-generated method stub
		if (buscarRuta(origen, destino) != null) {
			return true;
		}
		return false;
	}

	@Override
	public List<Nodo> buscarRuta(String origen, String destino) throws Exception {
		// TODO Auto-generated method stub
		Nodo nodoOrigen = buscarNodo(origen);
		Nodo nodoDestino = buscarNodo(destino);
		List<Nodo> nodosRuta = new ArrayList<>();
		
		// Origen o destino no encontrado
		if (nodoOrigen == null) {
			throw new RuntimeException("Error en la Búsqueda: NodoOrigen no encontrado");
		}
		if (nodoDestino == null) {
			throw new RuntimeException("Error en la Búsqueda: NodoOrigen no encontrado");
		}
		
		if (algo.buscarRuta(nodosRuta, nodoOrigen, nodoDestino)) {
			return nodosRuta;
		} else {
			return null;
		}
	}
}
