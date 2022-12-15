import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;
import java.util.HashMap;

public class Main{
  static ArrayList<String> data = new ArrayList<>();
  
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
  public static void main(String[] args) {        

    readFile("Day11/input.txt");
    
    System.out.println("\nHello world!");
  }
}