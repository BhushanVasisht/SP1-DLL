/**
 * @author		sxa190016
 * @author 		bsv180000
 * @version		1.0 01/17/2020
 * Doubly linked list: Short project 1
 * Entry class has generic type associated with it, to allow inheritance.
 * The DoublyLinkedList class extends the functionality of SinglyLinkedList class
 * and implements methods hasPrev(), prev(), add(x)
 * and DLLIterator which extends SinglyLinkedList.SLLIterator class.
 */

package bsv180000;

import java.util.ListIterator;
import java.util.Scanner;
import java.util.NoSuchElementException;


/**
 * DoublyLinkedList class extends the functionality of SinglyLinkedList class
 * DLL adds prev pointer to the SLL functions
 * @param <T>
 */
public class DoublyLinkedList<T> extends SinglyLinkedList<T> {

	/**
	 * DLL.Entry class extends SLL.Entry class
	 * @version 1.0 DLL.Entry inherits from SinglyLinkedList.Entry and holds a
	 * single node of the DoublyLinkedList object
	 * @param <E>
	 */
	static class Entry<E> extends SinglyLinkedList.Entry<E> {
		Entry<E> prev; //to facilitate backward movement
		Entry(E x, Entry<E> next, Entry<E> prev) {
			super(x, next);
			this.prev = prev;
		}
	}

	/**
	 * Default public constructor for DLL class
	 */
	public DoublyLinkedList() {
		head = new Entry<>(null,null,null);
		tail = head;
		size = 0;
	}

	/**
	 * Create an iterator to the data structure
	 * @return ListIterator object of type T
	 */
	public ListIterator<T> iterator() {
		//We use ListIterator so as to implement hasPrevious and previous methods
		return new DLLIterator();
	}

	/**
	 * Add method for DLL
	 * @param x, next and prev
	 */
	public void add(T x) {
		Entry<T> ent = new Entry<>(x, null, null);
		ent.prev = (Entry<T>) tail;
		super.add(ent);
	}

	/**
	 * Protected DLLIterator class
	 * extends the functionality of the SLLIterator class
	 */
	protected class DLLIterator extends SLLIterator implements ListIterator<T>  {

		/**
		 * Constructor to the iterator
		 * points the iterator cursor to the head;
		 */
		DLLIterator() {
			cursor = head;
		}


		/**
		 * Method to check if previous element exists
		 * @return true if exists else false
		 */
		public boolean hasPrevious() {
			Entry<T> node = (Entry<T>) cursor;
			return node.prev != null;
		}


		/**
		 * method to get the previous element in the DLL
		 * @return
		 */
		public T previous() {
			Entry<T> node = (Entry<T>) cursor;
			node = node.prev;
			cursor = node;
			return node.element;
		}

		@Override
		public int nextIndex() {
			return 0;
		}

		@Override
		public int previousIndex() {
			return 0;
		}


		/**
		 * Add method to add new entry to the DLL
		 * @param x
		 */
		public void add(T x) {
			Entry<T> newnode=new Entry<>(x,null,null);
			Entry<T> currentnode=(Entry<T>) cursor;
			newnode.next = currentnode.next;
			newnode.prev = currentnode;
			if(currentnode.next!=null) {
				((Entry<T>)currentnode.next).prev = newnode;
			}
			currentnode.next = newnode;
			cursor = newnode;
		}
		//add at the next position method implementation ends

		//remove at the current position method implementation begins
		public void remove(){
			Entry<T> temp = (Entry<T>) cursor;
			temp.prev.next = temp.next;
			((Entry<T>)temp.next).prev = temp.prev;
			temp = temp.prev;
			cursor = temp;
		}

		@Override
		public void set(T t) {

		}

	}

	/**
	 * Main function to test my DLL class
	 * @param args
	 * @throws NoSuchElementException
	 */
	public static void main(String[] args) throws NoSuchElementException {
		int n = 10;
		if(args.length > 0) {
			n = Integer.parseInt(args[0]);
		}
		DoublyLinkedList<Integer> lst=new  DoublyLinkedList<>();
		for(int i = 1; i <= n; i++) {
			lst.add(Integer.valueOf(i));
		}
		lst.printList();
		ListIterator<Integer> it;
		it = lst.iterator();
		Scanner in = new Scanner(System.in);
		System.out.println("Press 1 to go to the next element");
		System.out.println("Press 2 to add an element at the next position");
		System.out.println("Press 3 to go to the previous element");
		System.out.println("Press 4 to remove an element at the position");
		System.out.println("Press any key to stop the traversing");
		whileloop:
		while(it.hasNext()) {
			int entry = in.nextInt();
			switch(entry) {
				case 1: if (it.hasNext()) {
					System.out.println("Next Element is: "+it.next());
					break;
				}
				else {
					break;
				}
				case 2: System.out.println("Enter an element to insert:");
					int x=in.nextInt();
					it.add(x);
					lst.printList();
					break;
				case 3: if(it.hasPrevious()) {
					System.out.println("Previous Element is: "+it.previous());
					break;
				}
				else {
					System.out.println("There is no previous node to the current node");
					break;
				}
				case 4: it.remove();
					lst.printList();
					break;
				default:break whileloop;
			}
		}
		lst.printList();
	}


}
