package es.uned.lsi.eped.EvalJun2020;

import es.uned.lsi.eped.DataStructures.Collection;
import es.uned.lsi.eped.DataStructures.IteratorIF;

public class SequenceDL<E> extends Collection<E> implements SequenceDLIF<E> {
    /* Clase privada que implementa la estructura de nodos de la secuenciaDL */
    protected class NodeSequence {

        private E value;
        private NodeSequence next;
        private NodeSequence prev;

        NodeSequence(){
            this.value = null;
            this.next = null;
            this.prev = null;
        }

        NodeSequence(E e){
            this.value = e;
            this.next = null;
            this.prev = null;
        }

        public E getValue(){
            return this.value;
        }

        public void setValue(E e){
            this.value = e;
        }

        public NodeSequence getNext(){
            return this.next;
        }

        public NodeSequence getPrev(){
            return this.prev;
        }

        public void setNext(NodeSequence n){
            this.next = n;
        }

        public void setPrev(NodeSequence p){
            this.prev = p;
        }

    }

    /* Clase privada que implementa un iterador para la secuencia */
    private class SequenceIterator implements IteratorIF<E> {

        private NodeSequence currentNode;

        SequenceIterator(){
            this.currentNode = firstNode;
        }

        public E getNext() {
            E elem = this.currentNode.getValue();
            this.currentNode = this.currentNode.getNext();
            return elem;
        }

        public boolean hasNext() {
            return this.currentNode != null;
        }

        public void reset() {
            this.currentNode = firstNode;
        }

    }

    protected NodeSequence firstNode;

    /* Devuelve el primer nodo de la secuencia */
    private NodeSequence getFirstNode() {
        return this.firstNode;
    }

    /* Constructor de una secuencia vacía */
    public SequenceDL () {
        super();               /* Creamos una colección */
        this.firstNode = null; /* La secuencia es vacía */
    }

    /* Constructor por copia */
    public SequenceDL (SequenceDL<E> s) {
        this();
        if ( ! s.isEmpty() ) {
            this.size = s.size();
            NodeSequence nodeS = s.getFirstNode();
            NodeSequence pNode = new NodeSequence(nodeS.getValue());
            this.firstNode = pNode;
            while ( nodeS.getNext() != null ) {
                nodeS = nodeS.getNext();
                NodeSequence newNode = new NodeSequence(nodeS.getValue());
                pNode.setNext(newNode);
                newNode.setPrev(pNode);
                pNode = newNode;
            }
        }
    }

    /* Reimplementación/Especialización de algunos métodos de Collection */

    /* Elimina todos los elementos de la secuencia */
    public void clear () {
        super.clear();    /* Vaciamos la colección */
        this.firstNode = null; /* La secuencia es vacía */
    }

    /* Métodos heredados de CollectionIF */

    /* Comprueba si la secuencia contiene el elemento */
    public boolean contains(E e) {
        NodeSequence node = this.firstNode;
        while(node!=null){
            E next = node.getValue();
            if(next.equals(e)){
                return true;
            }
            node = node.getNext();
        }
        return false;
    }

    /* Devuelve un iterador para la secuencia */
    public IteratorIF<E> iterator() {
        return new SequenceIterator();
    }

    /* Devuelve el nodo i-ésimo de la secuencia        *
     * @Pre: 1 <= i <= size()                          */
    protected NodeSequence getNode(int i){
        NodeSequence node = this.firstNode;
        for ( int aux = 1 ; aux < i ; aux++ ) {
            node = node.getNext();
        }
        return node;
    }
}
