package es.uned.lsi.eped.EvalJun2020;

import es.uned.lsi.eped.DataStructures.IteratorIF;
import es.uned.lsi.eped.DataStructures.StackIF;

public class StackDeque<E> implements StackIF<E> {

    private Deque<E> d;

    public StackDeque(){
        this.d = new Deque<>();
    }

    public StackDeque(StackDeque<E> sd){
        this.d = new Deque<>();
        for(int i=0 ; i<sd.size(); i++){
            d.insertBack(sd.getTop());
            sd.pop();
        }
    }

    public E getTop() {
        return d.getFront();
    }

    public void push(E elem) {
        d.insertFront(elem);
    }

    public void pop() {
        d.removeFront();
    }

    public IteratorIF iterator() {
        return new StackDequeIterator(this.d);
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

    private class StackDequeIterator implements IteratorIF<E> {

        private Deque<E> de;
        private Deque<E> deAux;

        StackDequeIterator(Deque<E> deque){
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
