import java.util.*;
import java.lang.*;

class ReverseSentence {
	String input;
	ReverseSentence(String i) {
		input = i;
	}

	public void reverse() {
		ArrayList<Character> tmp = new ArrayList<Character>();
		for(int i = input.length() - 1; i >=0; i--) {
			tmp.add(input.charAt(i));
		}

		printResult(tmp);
	}

	public void printResult(ArrayList<Character> list) {
		for(int i = 0; i < list.size(); i++) {
			System.out.print(list.get(i));
		}
		System.out.println("");
	}

	public static void main(String [] args) {
		ReverseSentence sentence = new ReverseSentence("The fox jumps over the fence");
		sentence.reverse();
	}
}
