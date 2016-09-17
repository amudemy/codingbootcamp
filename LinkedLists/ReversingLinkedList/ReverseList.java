import java.lang.*;
import java.util.*;

class Node {
	String value;
	Node next = null;
	Node(String v, Node n){
		value = v;
		next = n;
	}
}

class ReverseLinkedList {
	Node head = null;
	ReverseLinkedList(Node input) {
		head = input;
	}

	void solve() {
		Node prev = null;
		Node curr = head;
		while(curr != null) {
			Node tmp = curr.next;
			curr.next = prev;
			prev = curr;
			curr = tmp;

			if(prev.value == null) {
				head = prev;
			}
		}

		printResult();
	}

	void printResult() {
		Node curr = head;
		while(curr != null) {
			System.out.print(curr.value + " ");
			curr = curr.next;
		}
		System.out.println("");
	}
}

class ReverseList {
	public static void main(String[] args) {
		Node a = new Node("A", null);
		Node b = new Node("B", null);
		Node c = new Node("C", null);
		Node tail = new Node(null, null);
		a.next = b;
		b.next = c;
		c.next = tail;
		ReverseLinkedList rList = new ReverseLinkedList(a);
		rList.solve();
	}
}
