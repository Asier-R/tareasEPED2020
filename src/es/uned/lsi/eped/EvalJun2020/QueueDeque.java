package es.uned.lsi.eped.EvalJun2020;

import es.uned.lsi.eped.DataStructures.IteratorIF;
import es.uned.lsi.eped.DataStructures.QueueIF;

public class QueueDeque<E> implements QueueIF<E> {

    private Deque<E> d;

    public QueueDeque(){
        this.d = new Deque<>();
    }

    public QueueDeque(QueueDeque<E> qd){
        this.d = new Deque<>();
        for(int i=0 ; i<qd.size(); i++){
            d.insertBack(qd.getFirst());
            qd.dequeue();
        }
    }

    public E getFirst() {
        return d.getFront();
    }

    public void enqueue(E elem) {
        d.insertBack(elem);
    }

    public void dequeue() {
        d.removeFront();
    }

    public IteratorIF iterator() {
        return new QueDequeIterator(d);
    }

    public int size() {
        return d.size();
    }

    public boolean isEmpty() {
        return d.isEmpty();
    }

    public boolean contains(E elem) {
        return d.contains(elem);
    }

    public void clear() {
        d.clear();
    }

    private class QueDequeIterator implements IteratorIF<E> {

        private Deque<E> de;
        private Deque<E> deAux;

        QueDequeIterator(Deque<E> deque){
            this.de = new Deque<>(deque);
            this.deAux = new Deque<>();
        }

        public E getNext() {
            deAux.insertBack(de.getFront());
            de.removeFront();
            return deAux.getFront();
        }

        public boolean hasNext() {
            return de.size()>0;
        }

        public void reset() {
            for(int i=0; i<deAux.size(); i++){
                de.insertFront(deAux.getBack());
                deAux.removeBack();
            }
        }

    }
}
