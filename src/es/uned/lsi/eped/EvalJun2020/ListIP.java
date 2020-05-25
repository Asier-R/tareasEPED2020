package es.uned.lsi.eped.EvalJun2020;

public class ListIP<E> extends SequenceDL<E> implements ListIPIF<E> {

    private int pointer;

    /* Constructor por defecto: crea una lista vacía */
    public ListIP(){
        super();
        pointer = 1;
    }

    /* Constructor por copia: delega en el constructor por copia *
     * de la secuencia                                           */
    public ListIP(ListIP<E> s) {
        super(s);
        pointer = 1;
    }

    public int getPointer() {
        return pointer;
    }

    public void moveNext() {
        if(pointer < this.size + 1) pointer++;
        else throw new IndexOutOfBoundsException();
    }

    public void movePrev() {
        if(pointer > 1) pointer--;
        else throw new IndexOutOfBoundsException();
    }

    public void moveTo(int pos) {
        if(pos > this.size + 1 || pos < 1) throw new IndexOutOfBoundsException();
        else pointer = pos;
    }

    public void insert(E elem) {
        NodeSequence newNode = new NodeSequence(elem);

        if(pointer == 1){
            newNode.setNext(this.firstNode);
            this.firstNode.setPrev(newNode);
            this.firstNode = newNode;

        }else{
            NodeSequence prevNode = this.getNode(pointer-1);
            NodeSequence nextNode = prevNode.getNext();
            prevNode.setNext(newNode);
            newNode.setNext(nextNode);
            newNode.setPrev(prevNode);
            nextNode.setPrev(newNode);

        }

        this.size++;
    }

    public void remove() {

        if(pointer < this.size + 1){
            if(pointer == 1){
                this.firstNode = this.firstNode.getNext();
                this.firstNode.setPrev(null);

            }else{
                NodeSequence current = getNode(pointer);
                NodeSequence prevNode = current.getPrev();
                NodeSequence nextNode = current.getNext();
                prevNode.setNext(nextNode);
                nextNode.setPrev(prevNode);
            }

        }else{
            throw new NullPointerException();
        }

        this.size--;
    }

    public E getElem() {
        if(pointer <= this.size ) return getNode(pointer).getValue();
        else throw new NullPointerException();
    }

    public void setElem(E elem) {

        if(pointer < this.size + 1){
            getNode(pointer).setValue(elem);

        }else{
            throw new NullPointerException();
        }

    }
}
