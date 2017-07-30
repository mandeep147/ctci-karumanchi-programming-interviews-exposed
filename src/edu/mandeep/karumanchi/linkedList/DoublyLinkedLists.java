package edu.mandeep.karumanchi.linkedList;

class NodeDLL {
	private NodeDLL next;
	private NodeDLL prev;
	int data;

	public NodeDLL(int data) {
		super();
		this.data = data;
	}

	public NodeDLL(NodeDLL next, NodeDLL prev, int data) {
		super();
		this.next = next;
		this.prev = prev;
		this.data = data;
	}

	public NodeDLL getNext() {
		return next;
	}

	public void setNext(NodeDLL next) {
		this.next = next;
	}

	public NodeDLL getPrev() {
		return prev;
	}

	public void setPrev(NodeDLL prev) {
		this.prev = prev;
	}

	public int getData() {
		return data;
	}

	public void setData(int data) {
		this.data = data;
	}

}

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
