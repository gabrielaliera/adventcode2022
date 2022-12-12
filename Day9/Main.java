import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.HashMap;

public class Main{

  static ArrayList<String> data = new ArrayList<>();
  static String[][] grid = new String[50][50];
  static int[] headPosition = {0,0};
  static int[] tailPosition ={0,0};
  static HashMap<String,String> tailVisits = new HashMap<>();
  

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
     // System.out.println(direction+" "+ moves);
      moveHead(direction, moves);
    }
  }
  public static void moveHead(String dir, int moves){
    int row = headPosition[0];
    int col = headPosition[1];
    int[] previousHead = {row,col};

    while(moves> 0){
      if(dir.equals("L")){
       // grid[row][col+moves] = "H";
        headPosition[1] = col+1;
        
      } else if(dir.equals("R")){
        //grid[row][col-moves] = "H";
        headPosition[1] = col-1;
        
      } else if(dir.equals("U")){
        //grid[row+moves][col] ="H";
        headPosition[0] = row+1;
      } else {
        //grid[row-moves][col] = "H";
        headPosition[0] = row+1;
      }
      moves--;
      moveTail(previousHead);
      
    }
    
  }

  public static void moveTail(int[] previousHead){
    int tailRow =  tailPosition[0];
    int tailCol = tailPosition[1];
    int headRow = headPosition[0];
    int headCol = headPosition[1];

    //if tail is not next too head
    if(!isAdjacent(tailRow,tailCol)){
      System.out.println("not adj");
      //move tail to right
      if(headRow == tailRow && headCol == tailCol + 2){ // 0T 1 2H 
        tailPosition[1] = tailCol +1;
        System.out.println("moveR");
      } else if(headRow == tailRow && headCol == tailCol - 2){ //move tail to left 
        tailPosition[1] = tailCol -1;  //0H 1-2T
        System.out.println("moveL");
        
      } else if(headCol == tailCol && headRow == tailRow - 2){//move tail to up
        tailPosition[1] = tailCol -1; // 0H 1 2T 
        System.out.println("moveU");
      } else if (headCol == tailCol && headRow == tailRow + 2){ //move tail to down
        tailPosition[1] = tailCol +1;// 0T 1 2H 
        System.out.println("moveD");
      } else {//Move diagonally
        tailPosition[0] = previousHead[0];
        tailPosition[1] = previousHead[1];
        System.out.println("moveDiag");
      }
    }
    //Add tail postion to map
    addVisitedTail();
  }

  public static void addVisitedTail(){
    String tail = String.valueOf(tailPosition[0]) + String.valueOf(tailPosition[1]);
    if (tailVisits.get(tail)== null){
      tailVisits.put(tail,tail);
    }
  }
  public static boolean isAdjacent(int tailRow, int tailCol){
    int headRow = headPosition[0];
    int headCol = headPosition[1];
    
    //check if tail left of head
    if(headCol == tailCol+1){
      return true;
    }
    //check if tail right of head
    if(headCol == tailCol-1){
      return true;
    }
    //check if tail is above head 0T 1H 2
    if(headRow == tailRow +1){
      return true;
    }
    //check if tail is below head   0H 1T 2
    if(headRow ==  tailRow-1){
      return true;
    }

    return false;
  }

  public static void main(String[] args) {        

    readFile("Day9/step.txt");
   // tailVisits.put("00","00");
    readSteps();
    System.out.println(tailVisits.size());
    //728 too low
   // System.out.println(tailVisits.entrySet());
    
    System.out.println("\nHello world!");
  }
}