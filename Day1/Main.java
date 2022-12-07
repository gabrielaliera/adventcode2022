import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.Scanner; // Import the Scanner class to read text files
import java.util.ArrayList;
import java.util.HashMap;
 
public class Main {
  
  static ArrayList<String> data= new ArrayList<>();  //Hold string from text file
 
  //Read file to ArrayList<String> data
  public static void readFile(String fileName){
    try{
      File myObj = new File(fileName);
      Scanner scan = new Scanner(myObj);
    
      while (scan.hasNextLine()) {   //Read file
        String str = scan.nextLine();  //Scan file
        data.add(str);       //Add str to data array
      }
    scan.close();
    } catch (FileNotFoundException e) {
      System.out.println("An error occurred.");
      e.printStackTrace();
    }
  }
  
  public static int findMax(ArrayList<Integer> elf){
    int max= Integer.MIN_VALUE;
    int max2 = Integer.MIN_VALUE;
    int max3 = Integer.MIN_VALUE;
    int index = 0;
    for(int i=0 ; i< elf.size(); i++){
      int total = elf.get(i);
      if (max < total){
        max3 = max2;
        max2 = max;
        max = total;
        index = i;
       // System.out.println(index);
      } else if ( max > total && max2 < total){
        max3 = max2;
        max2 = total;
      }else if (max > total && max2 > total && max3< total){
        max3 = total;
      }
    }
    System.out.println(index);
    System.out.println("max1: "+ max);
    System.out.println("max2: "+ max2);
    System.out.println("max3: "+ max3);
    System.out.println(max+max2+max3);
    return max;
  }
  
  
  public static void main(String[] args) {
      readFile("calories.txt");
      int total = 0;  
      ArrayList<Integer> elf = new ArrayList<>();
      int num = 0;
      
    
      for(int i=0; i< data.size(); i++){
          //System.out.println(s);
          String s = data.get(i);
         // System.out.println("s: "+ s);
          if (s.equals("")){
            elf.add(total);
           //System.out.println("total: "+total);
            total = 0;
          } else {
            num = Integer.valueOf(s);
            //System.out.println("num: "+ num+ " pretotal: "+ total);
            total = total + num;
           // System.out.println( "add total: "+ total);
          }
        
      }
      System.out.println("Max calories: "+ findMax(elf));

  }
 
}
