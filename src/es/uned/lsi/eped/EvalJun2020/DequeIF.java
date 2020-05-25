package es.uned.lsi.eped.EvalJun2020;

/* Representa una bicola o cola doble (deque en inglés):		*
 * estructura de datos lineal que permite operar por ambos 		*
 * extremos (inicio y fin).						*/
public interface DequeIF<E> extends SequenceDLIF<E> {

	/*Devuelve el primer elemento de la bicola			*
	 *@Pre: !isEmpty().						*/	
	public E getFront();
	/*Devuelve el último elemento de la bicola			*
	 *@Pre: !isEmpty().						*/	
	public E getBack();
	/*Inserta un elemento por el inicio de la bicola 		*
	 *@param e: elemento a insertar por el inicio			*/	
	public void insertFront(E e);
	/*Inserta un elemento por el final de la bicola 		*
	 *@param e: elemento a insertar por el final			*/	
	public void insertBack(E e);
	/*Elimina el primer elemento de la bicola			*
	 * @Pre: !isEmpty().						*/	
	public void removeFront();
	/*Elimina el último elemento de la bicola			*
	 * @Pre: !isEmpty().						*/	
	public void removeBack();
	
}
