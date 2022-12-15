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

public class Day10{
  
  static ArrayList<String> data = new ArrayList<>();
  static Queue<Cycle> cycleQueue = new LinkedList<>();
  static ArrayList<Integer> signalStrengths = new ArrayList<>();
  static HashMap<Integer,Integer> map = new HashMap<>();
  static int[] sprite = {1,2,3};
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
      
      part2(currentCycle);
      checkCurrentCycleForSum(currentCycle);
      
      if(untilAdd == 1){
        X += cycleObj.getScore();
        sprite[0] = X;
        sprite[1] = X+1;
        sprite[2] = X+2; 
     
        cycleQueue.remove();
      } else{
        cycleObj.setEndCycle(cycleObj.getEndCycle()-1);
      }
      currentCycle++; 
      
    }
  }

 public static void part2(int currentCycle){
   int pixal = currentCycle % 40;
   if(currentCycle % 40 == 1){
     System.out.println();
   }
    if(pixal == sprite[0]|| pixal == sprite[1] || pixal ==sprite[2]){
     System.out.print("#");
   } else {
     System.out.print(".");
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

  public static void printPixals(){
    for(int i=1;i<241;i++){
      if(i%40 == 0 + 1){
        System.out.println();
      }
      System.out.print("#");
    }
  }
  
  public static void main(String[] args) {        

    readFile("Day10/signal.txt");
    cycles();
    startCycleClock();
    System.out.println("\nSum: "+sumSignals());
    System.out.println(map.entrySet());
    System.out.println(X);
    //printPixals();
    System.out.println("\nHello world!");
  }
}