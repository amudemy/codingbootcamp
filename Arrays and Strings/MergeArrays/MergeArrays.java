import java.util.*;
import java.io.*;

public class MergeArrays{
  void merge(int[] arr1, int[] arr2) {
    int p1 = 0;
    int p2 = 0;

    // empty Array
    ArrayList<Integer> result = new ArrayList<Integer>();

    while(p1 < arr1.length && p2 < arr2.length) {
      if(arr1[p1] < arr2[p2]) {
        result.add(arr1[p1]);
        p1++;
      } else if(arr1[p1] >= arr2[p2]){
        result.add(arr2[p2]);
        p2++;
      }
    }

    if(p1 < arr1.length) {
      while(p1 < arr1.length){
        result.add(arr1[p1]);
        p1++;
      }
    }
    if(p2 < arr2.length){
      while(p2 < arr2.length){
        result.add(arr2[p2]);
        p2++;
      }
    }

    printResult(result);
  }

  void printResult(ArrayList<Integer> result){
    for(int i = 0; i < result.size(); i++){
      System.out.print(result.get(i) + " ");
    }
    System.out.println("");
  }

  public static void main(String args[]){
    int[] first = new int[]{1, 3, 3, 4};
    int[] second = new int[]{2, 5, 6};

    MergeArrays obj = new MergeArrays();
    obj.merge(first, second);
  }
}
