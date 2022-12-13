import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;

/*
addx V takes two cycles to complete. After two cycles, the X register is increased by the value V. (V can be negative.)
noop takes one cycle to complete. It has no other effect.
*/

public class Main{
  
  static ArrayList<String> data = new ArrayList<>();
  static Queue<Integer>  scores = new LinkedList<>();
  static Queue<Integer> cycels = new LinkedList<>();

  public static void readFile(String fileName){
    try{
      File myObj = new File(fileName);
      Scanner scan = new Scanner(myObj);

      while (scan.hasNext()){
        String line = scan.nextLine();
        data.add(line);
      }
      scan.close();
    }catch (FileNotFoundException e){
      System.out.println("Error");
    }
  }

  public static void cycles(){
    int X = 0;
    //for(String line : data){
      for(int i=0; i<5;i++){
        String line = data.get(i);
        if(line.equals("noop")){
          
        }else {
          addScoreToQueue(line);
        }
    }
  }

  public static void addScoreToQueue(String line){
    String[] instructions = line.split(" ");
    int score = Integer.valueOf(instructions[1]);
    scores.add(score);
  }
   public static void main(String[] args) {        

    readFile("Day10/signal.txt");
    
    System.out.println("\nHello world!");
  }
}