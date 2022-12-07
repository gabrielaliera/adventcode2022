

import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.Scanner; // Import the Scanner class to read text files
import java.util.ArrayList;
import java.util.HashMap;

class day4 {
  static ArrayList<Integer> data= new ArrayList<>();  //Hold string from text file
  static int count=0;
  static int overlap=0;
  
  //Read file to ArrayList<String> data
  public static void readFile(String fileName) {
    try{
      File myObj = new File(fileName);
      Scanner scan = new Scanner(myObj);

      scan.useDelimiter("[-,\\n]");
      while (scan.hasNextLine()) {   //Read file
        int num1= Integer.valueOf(scan.next());
        int num2= Integer.valueOf(scan.next());
        int num3= Integer.valueOf(scan.next());
        int num4 = Integer.valueOf(scan.next().trim());
   

        //System.out.println(num1+ " "+num2);
     //  System.out.println("num1:"+num1+" "+num2+" "+num3+ " "+ num4);
        data.add(num1);       //Add str to data array
        data.add(num2); 
        data.add(num3); 
        data.add(num4);
        count++;
      }
    scan.close();
    } catch (FileNotFoundException e) {
      System.out.println("An error occurred.");
      e.printStackTrace();
    }
  }

  public static int getScore(){
    int total=0;
    for(int i= 0; i< data.size(); i += 4){
      int A = data.get(i);
      int B = data.get(i+1);
      int C = data.get(i+2);
      int D = data.get(i+3);

      if( (A<= C && C<=D && D<=B) || (C<=A && A<=B && B<=D)){
       total++;
      }
    
     int maxAC = Math.max(A,C);
     int maxBD = Math.max(B,D); 
      if(maxAC<maxBD){
      //  overlap++;
      }
      if(A<=C || B>=D){
       // overlap++;
      }
      if( A==D || B==C|| A<=C || B>=D){
     //  overlap++;
      }

      if(((D-A)*(B-C) >= 0)){
        overlap++;
      }
      
    }
    return total;
  }

  
  public static void main(String[] args) {

    readFile("pairs.txt");
    System.out.println("Total: "+ getScore());
    System.out.println("Lines Read Count: "+ count);
    System.out.println("Data size: "+ data.size());
    System.out.println("Overlap: "+ overlap);
    System.out.println("Hello world!");
  }
}