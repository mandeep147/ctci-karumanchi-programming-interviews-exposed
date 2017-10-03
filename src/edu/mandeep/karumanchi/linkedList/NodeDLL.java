/**
 * 
 */
package edu.mandeep.karumanchi.linkedList;

/**
 * @author mandeep
 *
 */
public class NodeDLL {
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