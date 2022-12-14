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
  static Queue<Cycle> cycleQueue = new LinkedList<>();
  static ArrayList<Integer> signalStrengths = new ArrayList<>();
  static int X = 0;
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
   
    int count=0;
    //for(String line : data){
    for(int i=0; i<data.size();i++){
      
      String line = data.get(i);
      
      if(line.equals("noop")){
          Cycle cycle = new Cycle(0, i);
          cycle.setName("noop");
          cycleQueue.add(cycle);
          count++;
      }else {
          addScoreToQueue(line,i);
      }

        // if(cycleQueue.peek().getEndCycle() == i){
        //   X += cycleQueue.peek().getScore();
        //   cycleQueue.remove();
        // }
        // if(i ==20  || i==60 || i==100 || i==140 || i==180 || i==220){
        //   signalStrengths.add(X*i);
        // }
    }
    System.out.println("count "+ count);
  }

  public static void startCycleClock(){
    int i = 0;
    System.out.println(cycleQueue.size());
    while(!cycleQueue.isEmpty()){
      
      if(cycleQueue.peek().getEndCycle() == i || cycleQueue.peek().getName().equals("noop")){
          X += cycleQueue.peek().getScore();
    //  System.out.println("removed: "+i+" "+ cycleQueue.peek().getScore()+ " " +cycleQueue.peek().getEndCycle());
          cycleQueue.remove();
      }
      if(i ==20  || i==60 || i==100 || i==140 || i==180 || i==220){
        System.out.println(i +" "+ X);
          signalStrengths.add(X*i);
      }
    
     i++; 
    }
  }

  public static void addScoreToQueue(String line, int i){
    String[] instructions = line.split(" ");
    int score = Integer.valueOf(instructions[1]);
    scores.add(score);

    Cycle cycle = new Cycle(score, i+2);
    cycle.setName("addx");
    cycleQueue.add(cycle);
  }

  public static int sumSignals(){
    int total=0;
    for(int signal : signalStrengths){
      total += signal;
    }
    return total;
  }
  
  public static void main(String[] args) {        

    readFile("Day10/signal.txt");
    cycles();
    startCycleClock();
    System.out.println(sumSignals());
    //3520 too low
    //7920
    //7680
    //16080
    System.out.println(X);
    System.out.println("\nHello world!");
  }
}