import java.util.*;
import java.lang.*;

class TowersOfHanoi {
	private Stack<Integer> disks;

	TowersOfHanoi(int n) {
		disks = new Stack<Integer>();
	}

	public void add(int value) {
		if(disks.isEmpty()){
			disks.push(value);
		} else if(disks.peek() >= value){
			disks.push(value);
		}
	}

	public void transferDisk(TowersOfHanoi tower) {
		int top = disks.pop();
		tower.add(top);
	}

	public void solve(int n, TowersOfHanoi dest, TowersOfHanoi spare) {
		if(n > 0) {
			solve(n - 1, spare, dest);
			transferDisk(dest);
			spare.solve(n - 1, dest, this);
		}
	}

	public void printDisks(String towerName) {
		Integer curr = null;
		System.out.print(towerName + " ");
		if(disks.isEmpty()){
			System.out.print("Empty");
		} else {
			while(!disks.isEmpty()){
				curr = disks.pop();
				System.out.print(curr + " ");
			}
		}
		System.out.println("");
	}

	public static void main(String [] args) {
		int numDisks = 5;
		TowersOfHanoi[] towers = new TowersOfHanoi[numDisks];
		for(int i = 0; i < 3; i++) {
			towers[i] = new TowersOfHanoi(i); // create the 3 towers
		}
		for(int i = numDisks - 1; i >= 0; i--) {
			towers[0].add(i); // place all the disks in the first location
		}

		towers[0].solve(numDisks, towers[2], towers[1]);

		// After moving
		System.out.println("After moving:");
		towers[0].printDisks("Tower 1");
		towers[1].printDisks("Tower 2");
		towers[2].printDisks("Tower 3");
	}
}
