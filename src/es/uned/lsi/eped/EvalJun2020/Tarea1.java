package es.uned.lsi.eped.EvalJun2020;

import es.uned.lsi.eped.DataStructures.IteratorIF;

public class Tarea1 {

	public static void printStatus(ListIPIF<Integer> param) {
		System.out.print("Tamaño: ");
		System.out.println(param.size());
		System.out.print("Posición: ");
		System.out.println(param.getPointer());
		System.out.print("Iterador: ");
		IteratorIF<Integer> it = param.iterator();
		while (it.hasNext()) {
			System.out.print(it.getNext());
			if (it.hasNext()) { System.out.print(","); }
		}
		System.out.println();
		System.out.println("--------------------------");
	}
	
	public static void main(String [] args) {
		ListIPIF<Integer> lista = new ListIP<Integer>();
		
		printStatus(lista);
		
		lista.insert(10);
		lista.moveNext();
		lista.insert(5);
		lista.insert(40);
		lista.movePrev();
		lista.insert(65);
		printStatus(lista);
		
		lista.moveTo(3);
		lista.remove();
		printStatus(lista);
		
		lista.insert(3);
		lista.insert(13);
		lista.moveTo(lista.size()+1);
		lista.insert(231);
		lista.moveNext();
		lista.insert(1341);
		lista.moveTo(2);
		lista.remove();
		printStatus(lista);
		
		lista.moveTo(1);
		lista.setElem(823);
		while ( ! lista.isEmpty() ) {
			System.out.print("Eliminando ");
			System.out.println(lista.getElem());
			lista.remove();
		}
		printStatus(lista);

	}
	
}
