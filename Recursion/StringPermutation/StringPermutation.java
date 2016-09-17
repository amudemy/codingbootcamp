import java.util.*;
import java.io.*;

class StringPermutation {
  private int strLen;

  StringPermutation(String s) {
    strLen = s.length();
    solve(s);
  }

  ArrayList<String> solve(String input) {
    ArrayList<String> perms = new ArrayList<String>();

    // base case
    if(input.length() == 0){
      perms.add("");
      return perms;
    }

    char prefix = input.charAt(0);
    String str = input.substring(1);
    ArrayList<String> substrings = solve(str);
    for(String s: substrings){
      for(int i = 0; i <= s.length(); i++) {
        String beginning = s.substring(0, i);
        String middle = Character.toString(prefix);
        String end = s.substring(i);
        perms.add(beginning + middle + end);
      }
    }

    printResult(perms);
    return perms;
  }

  void printResult(ArrayList<String> list) {
    for(String s: list){
      if(s.length() == strLen){
        System.out.println(s);
      }
    }
  }

  public static void main(String [] args) {
    StringPermutation perm = new StringPermutation("abcd");
  }
}
