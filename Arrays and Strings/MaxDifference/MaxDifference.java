import java.util.*;
import java.lang.*;

class MaxDifference {
	private int[] arr;
	private int maxDiff, maxPos;
	private int minValue, minPos;
	private Stack<Integer> buySell;

	MaxDifference(int[] input) {
		buySell = new Stack<Integer>();
		arr = new int[input.length];
		for(int i = 0; i < input.length; i++){
			arr[i] = input[i];
		}
	}

	public void solve() {
		maxDiff = 0;
		maxPos = 0;
		minValue = arr[0];
		minPos = 0;
		int diff, newMax, newMin;
		for(int i = 0; i < arr.length; i++){
			newMin = min(minValue, arr[i]);
			if(newMin < minValue) {
				minValue = newMin;
				minPos = i;
			}
			diff = arr[i] - minValue;
			newMax = max(diff, maxDiff);
			if(newMax > maxDiff){
				maxPos = i;
				maxDiff = newMax;
				// store buy/sell price
				buySell.push(maxPos);
				buySell.push(minPos);
			}
		}

		printResult();
	}

	public int min(int a, int b) {
		if(a < b) {
			return a;
		}
		else if (a >= b) {
			return b;
		}
		return -1;
	}

	public int max(int a, int b) {
		if(a > b) {
			return a;
		}
		else if(a <= b){
			return b;
		}
		return -1;
	}

	public void printResult() {
		System.out.println("Max Difference: " + maxDiff);
		System.out.println("Min Position: " + buySell.pop());
		System.out.println("Max Position: " + buySell.pop());
	}

	public static void main(String [] args) {
		MaxDifference maxDiff = new MaxDifference(new int[]{-1, 5, 0, 7, 2, -3});
		maxDiff.solve();
	}
}
