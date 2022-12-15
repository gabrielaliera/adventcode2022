import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;
import java.util.HashMap;

/*
addx V takes two cycles to complete. After two cycles, the X register is increased by the value V. (V can be negative.)
noop takes one cycle to complete. It has no other effect.
*/ 

public class Main{
  
  static ArrayList<String> data = new ArrayList<>();
  static Queue<Integer>  scores = new LinkedList<>();
  static Queue<Cycle> cycleQueue = new LinkedList<>();
  static ArrayList<Integer> signalStrengths = new ArrayList<>();
  static HashMap<Integer,Integer> map = new HashMap<>();
  static int X = 1;
  
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
   
    //for(String line : data){
    for(int i=0; i<data.size();i++){
      String line = data.get(i);
      addCycleToQueue(line);
    }
  }
  
  public static void addCycleToQueue(String line){
      if(line.equals("noop")){
          Cycle cycle = new Cycle(0, 1);
          cycle.setName("noop");
          cycleQueue.add(cycle);
      }else {
        String[] instructions = line.split(" ");
        int score = Integer.valueOf(instructions[1]);
        Cycle cycle = new Cycle(score, 2);
        cycle.setName("addx");
        cycleQueue.add(cycle); 
      }
  }
  
  public static void startCycleClock(){
    int currentCycle = 1;
    
    while(!cycleQueue.isEmpty()){
      Cycle cycleObj = cycleQueue.peek();
      int untilAdd = cycleObj.getEndCycle();
      //System.out.println("current: "+currentCycle);
      
      checkCurrentCycleForSum(currentCycle);
      
      if(untilAdd == 1){
          X += cycleObj.getScore();
          //System.out.println(cycleObj.getName()+ " " +cycleObj.getScore());
          cycleQueue.remove();
      } else{
        cycleObj.setEndCycle(cycleObj.getEndCycle()-1);
      }
      //checkCurrentCycleForSum(currentCycle);
    
      currentCycle++; 
    }
  }

 

  public static void checkCurrentCycleForSum(int currentCycle){
    if(currentCycle ==20  || currentCycle ==60 || currentCycle ==100 || currentCycle ==140 || currentCycle ==180 || currentCycle ==220){
       // System.out.println("Cycle: "+currentCycle  +":"+ X);
        signalStrengths.add(X*currentCycle);
        map.put(currentCycle,currentCycle*X);
      }
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
    System.out.println("Sum: "+sumSignals());
    System.out.println(map.entrySet());
    System.out.println(X);
    System.out.println("\nHello world!");
  }
}