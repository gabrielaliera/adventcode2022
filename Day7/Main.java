import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;

public class Main{

  static ArrayList<String> data = new ArrayList<>();
  
  public static void readFile(String filenName){
    try{
      File myObj = new File(filenName);
      Scanner scan = new Scanner(myObj);

      while( scan.hasNext()){
        String str = scan.nextLine();
        System.out.println(str);
        data.add(str);
      }

      scan.close();
    } catch( FileNotFoundException e){
      System.out.println("File Error");
    }
  }
  public static void main(String[] args) {        

    readFile("Day7/input.txt");
    System.out.println("Hello world!");
  }
}