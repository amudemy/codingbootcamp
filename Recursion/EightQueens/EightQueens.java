import java.util.*;
import java.io.*;

public class EightQueens {
  private static int board[][];
  private int numQueens;

  public EightQueens() {
    numQueens = 0;
    board = new int[8][8];
    for(int i = 0; i < 8; i++) {
      for(int j = 0; j < 8; j++) {
        board[i][j] = 0;
      }
    }
  }

  public boolean solve(int numQueens) {
    if(numQueens == 8) {
      printBoard();
      return true;
    }
    else {
      for(int i = 0; i < 8; i++) {
        for(int j = 0; j < 8; j++) {
          if(validMove(i, j)){
            placeQueen(i, j, true);
            numQueens++;
            if(solve(numQueens)){
              return true;
            } else {
              placeQueen(i, j, false);
              numQueens--;
            }
          }
        }
      }
    }
    return false;
  }

  public boolean validMove(int x, int y) {
    for(int k = 0; k < 8; k++) {
      if(get(x, k)) {
        return false;
      }
      if(get(k, y)) {
        return false;
      }
      if(get(x-k, y-k)) {
        return false;
      }
      if(get(x-k, y+k)) {
        return false;
      }
      if(get(x+k, y-k)) {
        return false;
      }
      if(get(x+k, y+k)){
        return false;
      }
    }

    return true;
  }

  public int placeQueen(int x, int y, boolean validMove) {
    if(validMove) {
      board[x][y] = 1;
      numQueens++;
      return 0;
    } else if(!validMove) {
      board[x][y] = 0;
      return 0;
    }
    return -1;
  }

  public boolean get(int x, int y) {
    if(x < 0 || x > 7 || y < 0 || y > 7){
      return false;
    }
    if(board[x][y] == 1) {
      return true;
    }
    return false;
  }

  public void printBoard() {
    for(int i = 0; i < 8; i++) {
      for(int j = 0; j < 8; j++) {
        System.out.print(board[i][j] + " ");
      }
      System.out.println("");
    }
    System.out.println("");
  }

  public static void main(String [] args) {
    EightQueens board = new EightQueens();
    board.solve(0);
  }
}
