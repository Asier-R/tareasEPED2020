package es.uned.lsi.eped.EvalJun2020;

import java.util.Random;

import es.uned.lsi.eped.DataStructures.IteratorIF;
;

public class Tarea2 {

	public static <E extends Comparable<E>> DequeIF<E> H(DequeIF<E> d){
		int s = d.size();
		if(s<=1){
			return d;
		}
		int m = s/2;
		IteratorIF<E> it = d.iterator();
		int cont = 1;
		Deque<E> daux1 = new Deque<E>();
		Deque<E> daux2 = new Deque<E>();
		while(cont<=m){
			daux1.insertBack(it.getNext());
			cont++;
		}
		while(cont<=s){
			daux2.insertBack(it.getNext());
			cont++;
		}
		daux1 = (Deque<E>) H(daux1);
		daux2 = (Deque<E>) H(daux2);
		if(daux1.getBack().compareTo(daux2.getFront())<=0){
			IteratorIF<E> itAux = daux2.iterator();
			while(itAux.hasNext()){
				daux1.insertBack(itAux.getNext());
			}
			return daux1;
		}
		DequeIF<E> R = Haux(daux1,daux2);
		return R;
	}

	public static <E extends Comparable<E>> DequeIF<E> Haux(DequeIF<E> d1,
															DequeIF<E> d2){
		DequeIF<E> R = new Deque<E> ();
		while(d1.size()>0 && d2.size()>0){
			if(d1.getFront().compareTo(d2.getFront())<=0){
				R.insertBack(d1.getFront());
				d1.removeFront();
			}
			else{
				R.insertBack(d2.getFront());
				d2.removeFront();
			}
		}
		if(d1.size()>0){
			IteratorIF<E> itAux = d1.iterator();
			while(itAux.hasNext()){
				R.insertBack(itAux.getNext());
			}
		}
		if(d2.size()>0){
			IteratorIF<E> itAux = d2.iterator();
			while(itAux.hasNext()){
				R.insertBack(itAux.getNext());
			}
		}
		return R;
	}

	public static <E> void G(DequeIF<E> d){
		Gaux(d,d.size());
	}
	public static <E> void Gaux (DequeIF<E> d,int s){
		if(s>1){
			E e = d.getFront();
			d.removeFront();
			Gaux(d,s-1);
			d.insertBack(e);
		}
	}

	public static <E extends Comparable<E>> boolean F(DequeIF<E> d){
		if(d.size()>1){
			if(d.getFront().compareTo(d.getBack())!=0){
				return false;
			} d.removeFront();
			d.removeBack();
			return F(d);
		}
		return true;
	}

	public static void printStatus(DequeIF<Integer> param) {
		System.out.print("Tamaño: ");
		System.out.println(param.size());
		if(!param.isEmpty()){
			System.out.print("Primer elemento: ");
			System.out.println(param.getFront());
			System.out.print("Último elemento: ");
			System.out.println(param.getBack());
		}
		System.out.print("Iterador: ");
		IteratorIF<Integer> it = param.iterator();
		while (it.hasNext()) {
			System.out.print(it.getNext());
			if (it.hasNext()) { System.out.print(","); }
		}
		System.out.println();
		System.out.println("--------------------------");
	}
	
	
	public static void printStatus(StackDeque<Integer> param) {
		System.out.print("Tamaño: ");
		System.out.println(param.size());
		if(!param.isEmpty()){
			System.out.print("Cima: ");
			System.out.println(param.getTop());
		}
		System.out.print("Iterador: ");
		IteratorIF<Integer> it = param.iterator();
		while (it.hasNext()) {
			System.out.print(it.getNext());
			if (it.hasNext()) { System.out.print(","); }
		}
		System.out.println();
		System.out.println("--------------------------");
	}
	
	public static void printStatus(QueueDeque<Integer> param) {
		System.out.print("Tamaño: ");
		System.out.println(param.size());
		if(!param.isEmpty()){
			System.out.print("Primer elemento: ");
			System.out.println(param.getFirst());
		}
		System.out.print("Iterador: ");
		IteratorIF<Integer> it = param.iterator();
		while (it.hasNext()) {
			System.out.print(it.getNext());
			if (it.hasNext()) { System.out.print(","); }
		}
		System.out.println();
		System.out.println("--------------------------");
	}
	
	
	//genera pseudoaleatoriamente una bicola de longitud máxima num
	//co valores enteros positivos entre 0 y maxValue
	public static DequeIF<Integer> generateDeque(int num, int maxValue) {
		DequeIF<Integer> deque = new Deque<Integer>();
		Random r = new Random();
		//tamaño de la bicola entre 0 y num
		int n = r.nextInt(num+1);
		//asignar elementos
		for(int i = 1; i<=n;i++){
			//asignación pseudoaleatoria del valor del elemento
			int value = r.nextInt(maxValue+1);
			//decidir pseudoaleatoreamente por donde insertar el elemento
			int dir = r.nextInt(2); //dir es 0 o 1
			//si dir es 0 insertar por el inicio
			if(dir==0){
				deque.insertFront(value);
			}
			//si dir es 1 insertar por el final
			else{
				deque.insertBack(value);
			}
		}
		//devolver la bicola generada pseudoaleatoriamente
		return deque;
	}

	public static void main(String [] args) {
		//pruebas bicola
		
		DequeIF<Integer> deque = new Deque<Integer>();
		deque.insertBack(4);
		deque.insertFront(5);
		deque.insertBack(3);
		deque.insertFront(6);
		printStatus(deque);
		System.out.println("¿está 5?: "+deque.contains(5));
		System.out.println("¿está 9?: "+deque.contains(9));
		System.out.println("--------------------------");
		deque.removeFront();
		printStatus(deque);
		deque.removeBack();
		printStatus(deque);
		deque.clear();
		printStatus(deque);
		
		
		//pruebas pila con bicola
		
		StackDeque<Integer> stack = new StackDeque<Integer>();
		stack.push(6);
		stack.push(4);
		stack.push(5);
		stack.push(8);
		printStatus(stack);
		System.out.println("¿está 5?: "+stack.contains(5));
		System.out.println("¿está 9?: "+stack.contains(9));
		System.out.println("--------------------------");
		stack.pop();
		stack.pop();
		printStatus(stack);
		stack.clear();
		printStatus(stack);

	
		
		//pruebas cola con bicola

		QueueDeque<Integer> queue = new QueueDeque<Integer>();
		queue.enqueue(6);
		queue.enqueue(4);
		queue.enqueue(5);
		queue.enqueue(8);
		printStatus(queue);
		System.out.println("¿está 5?: "+queue.contains(5));
		System.out.println("¿está 9?: "+queue.contains(9));
		System.out.println("--------------------------");
		queue.dequeue();
		queue.dequeue();
		printStatus(queue);
		queue.clear();
		printStatus(queue);	
		
		//prueba deque generado pseudoaleatoriamente

		int n = 20;
		int maxValue = 100;
		DequeIF<Integer> deque2 = generateDeque(n,maxValue);
		printStatus(deque2);

		System.out.println("-------------------------------------------------------");
		System.out.println("-------------------------------------------------------");
		deque.insertFront(3);
		deque.insertFront(2);
		deque.insertFront(1);
		deque.insertFront(9);
		deque.insertFront(5);
		printStatus(deque);
		System.out.println(F(deque));
		System.out.println("-----DAR LA VUELTA----");
		G(deque);
		printStatus(deque);
		System.out.println("------FUCNION H-------");
		deque2 = H(deque);
		printStatus(deque2);
	}
	

}
