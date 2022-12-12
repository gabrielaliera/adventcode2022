import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;
public class Main{

  static ArrayList<String> data = new ArrayList<>();
  static int[][] grid;
  static int count=0;
  
  public static void readFile(String fileName){
    try{
      File myObj = new File(fileName);
      Scanner scan = new Scanner(myObj);

      while (scan.hasNext()){
        String line = scan.nextLine();
      //  System.out.println(line);
        data.add(line);
      }
      scan.close();
    } catch(FileNotFoundException e){
      System.out.println("File Reading Error");
    }
  }

  public static void createMatrix(){
    int len = data.size();
    char[] numberRow = data.get(0).toCharArray();
    int width = numberRow.length;

    grid = new int[len][width];
    int row= 0;
    for(String line: data){
      numberRow = line.toCharArray();
      for(int i=0;i<numberRow.length;i++){
        //  System.out.println(numberRow[i]);
         int num = Character.getNumericValue(numberRow[i]);
       // System.out.println(num);
         grid[row][i] = num;
      }
      row++;
    } 
     
    
    System.out.println("L: "+ len+" W: "+ width);
  }

  public static void printMatrix(){
    for(int i=0;i< grid.length;i++){
      System.out.println();
      for(int j=0;j<grid[0].length;j++){
        System.out.print(grid[i][j]);
      }
    }
  }

  public static void isVisible(){
   
    for(int i=0;i<grid.length;i++){
      for(int j=0;j<grid[0].length;j++){
          boolean vis =checkVisiblity(i, j, grid[i][j]);
          if(vis){count++;}
      }
    }
    
  }

  public static boolean checkAbove(int row,int col, int height){
    row--; //check row above
    while(row>= 0){
      if(grid[row][col]>=height){
        return false;
      }
      row--;
    }
    return true;
  }
  public static boolean checkBelow(int row,int col, int height){
    row++; //check row above
    while(row < grid.length){
      if(grid[row][col]>=height){
        return false;
      }
      row++;
    }
    return true;
  }

  public static boolean checkLeft(int row,int col, int height){
    col--; //check col left
    while(col >= 0){
      if(grid[row][col]>=height){
        return false;
      }
      col--;
    }
    return true;
  }

  public static boolean checkRight(int row,int col, int height){
    col++; //check col left
    while(col < grid[0].length){
      if(grid[row][col]>=height){
        return false;
      }
      col++;
    }
    return true;
  }
  public static boolean checkVisiblity(int row, int col, int value){

    boolean above = checkAbove(row,col,grid[row][col]);
    boolean below = checkBelow(row,col,grid[row][col]);
    boolean left = checkLeft(row,col,grid[row][col]);
    boolean right = checkRight(row,col,grid[row][col]);
   
    return above || below || left || right;
  }

  //PART 2
  public static int part2(){
    int max = Integer.MIN_VALUE;
    for(int i=0;i<grid.length;i++){
      for(int j=0;j<grid[0].length;j++){
          
          int score =findScenicScore(i, j, grid[i][j]);
          max = Math.max(max,score);
      }
    }
    return max;
  }
  public static int findScenicScore(int row, int col,int height){
    
    int above = scoreAbove(row, col, height);
    int below = scoreBelow(row, col, height);
    int left = scoreLeft(row, col, height);
    int right = scoreRight(row, col, height);
    
    return above*below*left*right;
  }
  public static int scoreAbove(int row,int col, int height){
    int score=0;
    row--; //check row above
    while(row>= 0){
      if(grid[row][col]<=height){
        score++;
        if(grid[row][col] == height){break;}
      }
      row--;
    }
    return score;
  }
  public static int scoreBelow(int row,int col, int height){
    int score=0;
    row++; //check row above
    while(row < grid.length){
      if(grid[row][col]<=height){
        score++;
        if(grid[row][col] == height){break;}
      }
      row++;
    }
    return score;
  }
  public static int scoreLeft(int row,int col, int height){
    int score=0;
    col--; //check row above
    while(col>= 0){
      if(grid[row][col]<=height){
        score++;
        if(grid[row][col] == height){break;}
      }
      col--;
    }
    return score;
  }
  public static int scoreRight(int row,int col, int height){
    int score=0;
    col++; //check row above
    while(col < grid[0].length){
      if(grid[row][col]<=height){
        score++;
        if(grid[row][col] == height){break;}
      }
      col++;
    }
    return score;
  }

  public static void main(String[] args) {        

    readFile("Day8/grid.txt");
    createMatrix();
   // printMatrix();
    isVisible();
    System.out.println(count);
    System.out.println(part2());
    
    System.out.println("\nHello world!");
  }
}