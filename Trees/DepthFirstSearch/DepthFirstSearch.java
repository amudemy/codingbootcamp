import java.util.*;
import java.io.*;

class Node {
	int value;
	Node left;
	Node right;
	boolean visited = false;

	Node(int v, Node l, Node r) {
		value = v;
		left = l;
		right = r;
		System.out.println("Created new node: " + value + " " + left + " " + right);
	}

	public Node[] children() {
		Node[] children = new Node[2];
		children[0] = left;
		children[1] = right;
		return children;
	}
}

class DepthFirstSearch {
  private Node root;

  DepthFirstSearch(Node first) {
	root = first;
	System.out.println("Iterative");
	traverseIterative();
	System.out.println("\nRecursive");
	traverseRecursive(root);
  }

  void traverseIterative() {
		if(root == null) {
			return;
		}

		Stack<Node> s = new Stack<Node>();
		root.visited = true;
		System.out.print(root.value + " ");
		s.push(root);
		Node curr = root;

		while(!s.isEmpty()){
			for(Node n: curr.children()){
				if(n != null && !n.visited){
					n.visited = true;
					System.out.print(n.value + " ");
					s.push(n);
				}
			}
			curr = s.pop();
		}
  }

  void traverseRecursive(Node curr) {
		if(curr == null) {
			return;
		}

		curr.visited = true;
		System.out.print(curr.value + " ");
		traverseRecursive(curr.left);
		traverseRecursive(curr.right);
  }

  public static void main(String [] args) {
		/*
		Tree:
					3
				2   4
				   3 6
		Pre-order traversal result (root, left, right):
		   3 2 4 3 6
		*/

  	Node three_first = new Node(3, null, null);
  	Node two = new Node(2, null, null);
  	Node three = new Node(3, null, null);
  	Node four = new Node(4, null, null);
  	Node six = new Node(6, null, null);

  	three_first.left = two;
  	three_first.right = four;
  	four.left = three;
  	four.right = six;

    DepthFirstSearch perm = new DepthFirstSearch(three_first);

  }
}
