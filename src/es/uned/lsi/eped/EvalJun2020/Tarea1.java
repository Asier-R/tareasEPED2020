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
		printStatus(lista);
		lista.insert(13);
		printStatus(lista);
		lista.moveTo(lista.size()+1);
		lista.insert(231);
		printStatus(lista);
		lista.moveNext();
		lista.insert(1341);
		printStatus(lista);
		lista.moveTo(2);
		lista.remove();
		printStatus(lista);
		
		lista.moveTo(1);
		lista.setElem(823);
		while ( ! lista.isEmpty() ) {
			System.out.println("Size: "+lista.size());
			System.out.print("Eliminando ");
			System.out.println(lista.getElem());
			lista.remove();
		}
		printStatus(lista);




		lista = new ListIP<Integer>();


		System.out.println("------------------------------------------");

		lista.insert(1);
		lista.moveNext();
		lista.insert(2);
		lista.moveNext();
		lista.insert(3);
		lista.moveNext();
		lista.insert(4);
		lista.moveNext();
		lista.insert(5);
		printStatus(lista);

		System.out.println();
		lista.moveTo(lista.size());
		for(int i=1; i<=lista.size(); i++){
			System.out.print(lista.getElem()+",");
			if(i<lista.size())lista.movePrev();
		}
		System.out.println();
		System.out.println();

		lista.moveTo(1);
		lista.remove();
		lista.remove();
		printStatus(lista);
		lista.remove();
		printStatus(lista);
		System.out.println("Elemento "+lista.getPointer()+": "+lista.getElem());
		lista.moveNext();
		System.out.println("Elemento "+lista.getPointer()+": "+lista.getElem());
		lista.moveNext();
		System.out.println("Pointer: "+lista.getPointer()+"  size: "+lista.size());
		lista.movePrev();
		System.out.println("Pointer: "+lista.getPointer()+"  size: "+lista.size());
		lista.setElem(9999);
		lista.insert(7777);
		System.out.println(".....");
		printStatus(lista);
		//sSystem.out.println("Elemento "+lista.getPointer()+": "+lista.getElem());

		System.out.println("------------------------------------------");
		System.out.println(".......Lista 2.......");
		ListIPIF<Integer> lista2 = new ListIP<Integer>((ListIP<Integer>) lista);
		printStatus(lista2);

	}
	
}
