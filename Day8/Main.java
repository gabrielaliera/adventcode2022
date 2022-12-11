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
      System.out.println(i);
      for(int j=0;j<grid[0].length;j++){
        System.out.print(grid[i][j]+" ");
      }
    }
  }

  public static void isVisible(){
     // boolean vis =checkVisiblity(0, 0, grid[0][0]);
     // if(vis){
     //     //   count++;
     //      }
    for(int i=0;i<grid.length;i++){
      for(int j=0;j<grid[0].length;j++){
          boolean vis =checkVisiblity(i, j, grid[i][j]);
          if(vis){
            //count++;
          }
      }
    }
    
  }

  public static boolean checkVisiblity(int row, int col, int value){

    if(row < 0 || row>=grid.length || col< 0 || col>=grid[0].length || grid[row][col] < value){
     // count++;
      return true;
    }
    boolean above = checkVisiblity(row-1,col,value); //above
    boolean below = checkVisiblity(row+1,col,value); //below
    boolean left = checkVisiblity(row,col-1,value); //left
    boolean right = checkVisiblity(row,col+1,value); //right

    if(above || below || left || right){
      count++;
    }
    
    //return above || below || left || right;
    return false;
  }

  public static void main(String[] args) {        

    readFile("Day8/grid.txt");
    createMatrix();
    //printMatrix();
    isVisible();
    System.out.println(count);
    
    System.out.println("Hello world!");
  }
}