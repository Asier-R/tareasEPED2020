package es.uned.lsi.eped.EvalJun2020;

import es.uned.lsi.eped.DataStructures.CollectionIF;
import es.uned.lsi.eped.DataStructures.IteratorIF;

/* Representa una secuencia doblemente enlazada, que es una     *
 * colección de elementos que se organizan linealmente. Y en la *
 * que cada elemento sabe cuál es su sucesor y su antecesor.    */
public interface SequenceDLIF<E> extends CollectionIF<E> {

	/* Devuelve el iterador sobre la secuencia. No necesita     *
	 * parámetros puesto que el recorrido es lineal y único.    */
	public IteratorIF<E> iterator (); 
}
