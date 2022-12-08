import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;
import java.lang.StringBuilder;
public class Main{

  static ArrayList<String> data = new ArrayList<>();
  static int repeatIndex=0;

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

  public static int findStart14(char[] letters){

    
    char[] packet = new char[14];
    int index = 0;
    
    for(int i=0;i<100;i++){
      if(index < 14){
        packet[index]= letters[i];
        index++;

        if(index == 14){
        
          if(containsRepeat(packet)){
             i = i- repeatIndex;
             index = 0;
          } else{
            return i;
          }
        }
        
      } else{
        index =0;
      }
      
    }
    return -1;
  }

  public static boolean containsRepeat(char[] packet){
    char[] block = new char[14];
    for(char c : packet){
      System.out.print(c +" ");
    }
    System.out.println();

    for(int i =0;i<packet.length;i++){
      block[i] = packet[i];
      for(int j=0;j<i;j++){
        for(int k=j+1;k<i;k++){
          if (packet[j]==block[k]){
            repeatIndex = 14-k;  
            return true;
          }
        }
        
      }
    }
    return false;
  }

  
  
  public static void main(String[] args) {        

    readFile("Day6/data.txt");
    
    char[] letters = data.get(0).toCharArray();
    System.out.println("Size: "+letters.length);
    //System.out.println("Packet4 start: "+findStart(letters));
    System.out.println("Packet14 start: "+findStart14(letters));
    System.out.println("Hello world!");
  }
}