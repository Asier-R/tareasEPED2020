package es.uned.lsi.eped.EvalJun2020;

public class Deque<E> extends SequenceDL<E> implements DequeIF<E>{

    private NodeSequence lastNode;

    public Deque(){
        super();
        this.lastNode = null;
        this.firstNode = null;
    }

    public Deque(Deque<E> s){
        super(s);
        if ( this.isEmpty() ) {
            this.lastNode = null;
            this.firstNode = null;
        } else {
            this.lastNode = s.lastNode;
            this.firstNode = s.firstNode;
        }
    }

    public E getFront() {
        return this.firstNode.getValue();
    }

    public E getBack() {
        return this.lastNode.getValue();
    }

    public void insertFront(E e) {
        NodeSequence nd = new NodeSequence(e);
        if (this.size > 0) {
            nd.setNext(this.firstNode);
            this.firstNode.setPrev(nd);
            this.firstNode = nd;
        }else{
            this.firstNode = nd;
            this.lastNode = nd;
        }
        this.size++;
    }

    public void insertBack(E e) {
        NodeSequence nd = new NodeSequence(e);
        if (this.size > 0) {
            nd.setPrev(this.lastNode);
            this.lastNode.setNext(nd);
            this.lastNode = nd;
        }else{
            this.firstNode = nd;
            this.lastNode = nd;
        }
        this.size++;
    }

    public void removeFront() {
        if(this.size > 0) {
            this.firstNode = this.firstNode.getNext();
            if(this.firstNode!=null) this.firstNode.setPrev(null);
        }
        this.size--;
    }

    public void removeBack() {
        if(this.size > 0) {
            this.lastNode = this.lastNode.getPrev();
            if(this.lastNode!=null) this.lastNode.setNext(null);
        }
        this.size--;
    }

    public void clear() {
        super.clear();
        this.lastNode = null;
        this.firstNode = null;
    }
}
