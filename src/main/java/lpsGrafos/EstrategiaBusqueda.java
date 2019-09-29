package lpsGrafos;

import java.util.List;

import lpsGrafos.Nodo;

public interface EstrategiaBusqueda {
	public boolean buscarRuta(List<Nodo> nodosRuta, Nodo nodoOrigen, Nodo nodoDestino);
}
