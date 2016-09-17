import java.io.*;
import java.lang.*;

class Node {
	String value;
	Node next = null;
	Node(String v, Node n){
		value = v;
		next = n;
	}
}

class LinkedList {
	Node head;
	Node tail;
	LinkedList(Node start) {
		head = start;
		tail = start;
	}

	void insert(Node e){
		tail.next = e;
		tail = e;
	}
}

class Cycles {
	private LinkedList list = new LinkedList(null);
	Cycles(LinkedList input) {
		list = input;
	}
	void solve() {
		Node result = null;
		Node fast, slow;
		Node prev = null;
		slow = list.head;
		fast = list.head;
		boolean loop = true;

		while(loop) {
			// advance the pointers
			slow = slow.next;
			if(fast.next != null) {
				prev = fast.next;
				fast = fast.next.next;
			} else { // no cycle
				loop = false;
				result = null;
			}
			if(slow == fast && loop) {
				result = prev;
				loop = false;
			} else if(slow == null || fast == null) { // no cycle
				result = null;
				loop = false;
			}
		}

		printResult(result);
	}

	void printResult(Node result) {
		if(result != null) {
			System.out.println("Cycle detected at: " + result.value);
		} else {
			System.out.println("No cycle detected. ");
		}
	}
}

class DetectingCycles {
	public static void main(String[] args) {
		Node c = new Node("C", null);
		Node b = new Node("B", null);
		Node a = new Node("A", null);
		a.next = b;
		b.next = c;
		c.next = null;
		LinkedList list = new LinkedList(a);
		list.insert(b);
		list.insert(c);
		Cycles cycle = new Cycles(list);
		cycle.solve();
	}
}
