import java.util.*;
import java.io.*;

class SyntaxBuilder {
  private int total;

  SyntaxBuilder(int n) {
    total = n * 2;
    solve(total);
  }

  Set<String> solve(int n) {
    Set<String> combos = new HashSet<String>();

    if(n == 0) {
      return null;
    }

    if(n == 1){
      combos.add("()");
      return combos;
    }
    String parens = "()";
    Set<String> results = solve(n-1);
    for(String s: results){
      ArrayList<Integer> inters = new ArrayList<Integer>(s);

    }
  }

  ArrayList<Integer> findIntersections(String s) {
    ArrayList<Integer> inter = new ArrayList<Integer>();
    for(int i = 0; i < s.length(); i++){
      if(i == 0){
        inter.add(i);
      } else if(i == s.length() - 1){
        inter.add(i);
      } else {
        inter.add(i);
      }
    }
    return inter;
  }

  void printResults(Set<String> list) {
  }

  public static void main(String [] args) {
    SyntaxBuilder perm = new SyntaxBuilder(3);
  }
}
