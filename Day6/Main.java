import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;
import java.lang.StringBuilder;
public class Main{

  static ArrayList<String> data = new ArrayList<>();

  public static void readFile(String fileName){
    try{
      File myObj = new File(fileName);
      Scanner scan = new Scanner(myObj);

      while(scan.hasNext()){
        String s = scan.next();
      
        data.add(s);
      }
      scan.close();
    } catch(FileNotFoundException e){
      System.out.println("Error: Can't find file");
    }
  }

  public static int findStart(char[] letters){

    StringBuilder str = new StringBuilder();
    char[] packet = new char[4];
    int index = 0;
    
    for(int i=0;i<letters.length;i++){
      if(index < 4){
        packet[index]= letters[i];
        index++;
        if(index == 4){
          //System.out.println("hel");
          if(!containsRepeat(packet)){
            return i+1;
          } 
        }
      } else{
        index =0;
      }
      
    }
    return -1;
  }

  public static boolean containsRepeat(char[] packet){
    for(int i=0;i<packet.length;i++){
      for(int j=i+1;j<packet.length;j++){
        if (packet[i]== packet[j]){
          return true;
        }
      }
    }
    return false;
  }
  
  public static void main(String[] args) {        

    readFile("Day6/data.txt");
    
    char[] letters = data.get(0).toCharArray();
    System.out.println("Size: "+letters.length);
    System.out.println(findStart(letters));
    System.out.println("Hello world!");
  }
}