import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.HashMap;

public class Main{

  static ArrayList<String> data = new ArrayList<>();
  static String[][] grid = new String[50][50];
  static int[] headPosition = {0,0};
  

  public static void readFile(String fileName){
    
    try{
      File myObj = new File(fileName);
      Scanner scan = new Scanner(myObj);
      while(scan.hasNext()){
       String line = scan.nextLine();
        data.add(line);
      }
      scan.close();
    } catch (FileNotFoundException e){
      System.out.println("Error");
    }
    
    
  }

  public static void readSteps(){
    
    for(String line: data){
      String[] instruction = line.split(" ");
      String direction = instruction[0];
      int moves = Integer.valueOf(instruction[1]);
      System.out.println(direction+" "+ moves);
      moveHead(direction, moves);
    }
  }
  public static void moveHead(String dir, int moves){
    int row = headPosition[0];
    int col = headPosition[1];
    
    if(dir.equals("L")){
      grid[row][col+moves] = "H";
      headPosition[1] = col+moves;
      
    } else if(dir.equals("R")){
      grid[row][col-moves] = "H";
      headPosition[1] = col-moves;
      
    } else if(dir.equals("U")){
      grid[row+moves][col] ="H";
      headPosition[0] = row+moves;
    } else {
      grid[row-moves][col] = "H";
      headPosition[0] = row+moves;
    }
  }

  public static void main(String[] args) {        

    readFile("Day9/step.txt");
    readSteps();
    
    System.out.println("\nHello world!");
  }
}