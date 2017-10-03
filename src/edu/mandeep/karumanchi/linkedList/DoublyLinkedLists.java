package edu.mandeep.karumanchi.linkedList;

class DoublyLinkedlist  {

	private NodeDLL head;
	
	public DoublyLinkedlist(NodeDLL head) {
		super();
		this.head = head;
	}

	public DoublyLinkedlist() {
		super();
	}


	public void insertAtBegin(int data){

	}


	//Prints list data
	public void printList() {
		NodeDLL currentNode = head;
		System.out.print("List: ");

		System.out.print(head.getData()+ " -> ");
		while(currentNode.getNext() != null) {
			currentNode = currentNode.getNext();
			System.out.print(currentNode.getData()+" -> ");

		}
		System.out.println("");
	}

}
public class DoublyLinkedLists {

	public static void main(String[] args){
		DoublyLinkedlist l = new DoublyLinkedlist();

		//l.insertAtEnd(10);
		l.insertAtBegin(5);
		/*l.insertAtEnd(7);
		l.insertAtBegin(3);
		l.insertAtEnd(15);
		l.insertAtPosition(6, 2);
		l.insertAtPosition(2, -1);
		l.insertAtPosition(9, 7);
		l.deleteAtStart();
	///	l.deleteAtStart();
		l.deleteAtEnd();
//		l.deleteAtEnd();
		l.printList();
		l.deleteAtPosition(3);*/
		l.printList();	
	}
}
