package es.uned.lsi.eped.EvalJun2020;

public class ListIP<E> extends SequenceDL<E> implements ListIPIF<E> {

    private int pointer;
    private NodeSequence currentNode;

    /* Constructor por defecto: crea una lista vacía */
    public ListIP(){
        super();
        pointer = 1;
        currentNode = this.firstNode;
    }

    /* Constructor por copia: delega en el constructor por copia *
     * de la secuencia                                           */
    public ListIP(ListIP<E> s) {
        super(s);
        pointer = 1;
        currentNode = this.firstNode;
    }

    public int getPointer() {
        return pointer;
    }

    public void moveNext() {
        if(pointer < this.size + 1){
            pointer++;
            if(currentNode.getNext()!=null) currentNode = currentNode.getNext();
        }
        else throw new IndexOutOfBoundsException();
    }

    public void movePrev() {
        if(pointer > 1) {
            pointer--;
            if(pointer!=this.size) currentNode = currentNode.getPrev();
        }
        else throw new IndexOutOfBoundsException();
    }

    public void moveTo(int pos) {
        if(pos > this.size + 1 || pos < 1) throw new IndexOutOfBoundsException();
        else {
            if(pos < pointer){
                if(pointer==this.size+1) pointer--; //valor limite, aqui current es null y no hay prev. ¡No llegar al null!
                for(int i=0; i<(pointer-pos); i++){
                    currentNode = currentNode.getPrev();
                }
            }else if(pos > pointer){
                for(int i=0; i<(pos-pointer); i++){
                    if(currentNode.getNext()!=null) currentNode = currentNode.getNext(); //si se llega a size+1, que es null, no asignar
                }
            }
            pointer = pos;
        }
    }

    public void insert(E elem) {
        NodeSequence newNode = new NodeSequence(elem);
        if(pointer==this.size+1){
            if(this.size>0) {
                currentNode.setNext(newNode);
                newNode.setPrev(currentNode);
                currentNode = newNode;
            }else{
                currentNode = newNode;
                this.firstNode = newNode;
            }
        }else{
            newNode.setNext(currentNode);
            newNode.setPrev(currentNode.getPrev());
            if(currentNode.getPrev()!=null)currentNode.getPrev().setNext(newNode);
            currentNode.setPrev(newNode);
            currentNode = newNode;
            if(pointer==1) this.firstNode = newNode;
        };
        this.size++;
    }

    public void remove() {
        if(pointer < this.size + 1){
            if(this.size > 1){
                if(currentNode.getPrev()!=null) currentNode.getPrev().setNext(currentNode.getNext());
                if(currentNode.getNext()!=null) currentNode.getNext().setPrev(currentNode.getPrev());
                if(pointer==1) {
                    this.firstNode = currentNode.getNext();
                    currentNode = currentNode.getNext();
                } else if(pointer==this.size) {
                    currentNode = currentNode.getPrev();
                } else {
                    currentNode = currentNode.getNext();
                }
            }else{
                this.firstNode = null;
                currentNode = null;
            }
        }else{
            throw new NullPointerException();
        }
        this.size--;
    }

    public E getElem() {
        if(pointer <= this.size ) return currentNode.getValue();
        else throw new NullPointerException();
    }

    public void setElem(E elem) {
        if(pointer < this.size + 1) currentNode.setValue(elem);
        else throw new NullPointerException();
    }
}
