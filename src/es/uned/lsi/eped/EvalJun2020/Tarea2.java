package es.uned.lsi.eped.EvalJun2020;

import java.util.Random;

import es.uned.lsi.eped.DataStructures.IteratorIF;
;

public class Tarea2 {

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
	}
	
	
}
