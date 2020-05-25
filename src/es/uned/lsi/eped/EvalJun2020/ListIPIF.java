package es.uned.lsi.eped.EvalJun2020;

public interface ListIPIF<E> extends SequenceDLIF<E> {
	
	/* Devuelve la posición actual del puntero entre 1 y size()+1 */
	public int getPointer();
	
	/* Mueve el puntero a la siguiente posición de la lista
	 * @Pre: 1 <= getPointer() <= size()
	 * @Post: 1 < getPointer() <= size()+1
	 */
	public void moveNext();
	
	/* Mueve el puntero a la posición anterior de la lista
	 * @Pre: 1 < getPointer() <= size()+1
	 * @Post: 1 <= getPointer() < size()
	 */
	public void movePrev();
	
	/* Mueve el puntero a una posición determinada
	 * @param posición a la que se mueve el puntero
	 * @Pre: 1 <= pos <= size()+1
	 * @Post: getPointer() = pos
	 */
	public void moveTo(int pos);
	
	/* Inserta un elemento en la posición actual del puntero
	 * @param elem Elemento a añadir
	 * @Pre: 1 <= getPointer() <= size()+1
	 * @Post: getElem() = elem
	 */
	public void insert(E elem);
	
	/* Elimina el elemento de la posición actual del puntero
	 * @Pre 1 <= getPointer() <= size()
	 */
	public void remove();
	
	/* Devuelve el valor del elemento en la posición del puntero
	 * @Pre: 1 <= getPointer() <= size()
	 */
	public E getElem();
	
	/* Modifica el valor del elemento que está en la posición actual del puntero
	 * @param elem el valor que debe adoptar el elemento de la posicion del puntero
	 * @Pre: 1 <= getPointer() <= size()
	 * @Post: getElem() = elem
	 */
	public void setElem(E elem);

}

