package edu.mandeep.karumanchi.linkedList;

public class SinglyLinkedList{
	public static void main(String args[]){
		LinkedList l = new LinkedList();

		l.insertAtEnd(10);
		l.insertAtBegin(5);
		l.insertAtEnd(7);
		l.insertAtBegin(3);
		l.insertAtEnd(15);
		l.insertAtPosition(6, 2);
		l.insertAtPosition(2, -1);
		l.insertAtPosition(9, 7);

	}
}
