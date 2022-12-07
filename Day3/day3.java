

import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.Scanner; // Import the Scanner class to read text files
import java.util.ArrayList;
import java.util.HashMap;

class day3 {
  static ArrayList<String> data= new ArrayList<>();  //Hold string from text file
  static ArrayList<Character> letters= new ArrayList<>();  //Hold string from text file
  static ArrayList<Character> letters3= new ArrayList<>();  //Hold string from text file
  static HashMap<Character,Integer> priority = new HashMap<>();
  
  //Read file to ArrayList<String> data
  public static void readFile(String fileName) {
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

  public static void createPriority(){
    int score =1;
    Character[] lowercase = {'a','b','c','d','e','f','g','h','i','j','k','l',
                             'm','n','o','p','q','r','s','t','u','v','w','x','y','z'};
    Character[] uppercase = new Character[26];
    
    for(int i =0;i< lowercase.length;i++){
      priority.put(lowercase[i],score);
      
      uppercase[i] = Character.toUpperCase(lowercase[i]);
      priority.put(uppercase[i], score+26);
      //System.out.print(priority.get(lowercase[i]));
      score++;
    }
  }

  public static void findPriority(){

    for(String str: data){
      int size = str.length();
      String r1 = str.substring(0,size/2);
      String r2 = str.substring(size/2);
     // System.out.println("r1:-"+r1+"size: "+r1.length()+"-r2-"+r2+"-size: "+ r2.length() );
      
      HashMap<Character,Character> map = new HashMap<>();
      for(int i=0; i< r1.length(); i++){
        char c = r1.charAt(i);
        map.put(c,c);
      }

      for(int j=0; j<r2.length();j++){
        char c =r2.charAt(j);
        if(map.containsKey(c)){
         // System.out.println("contains: "+ c);
          letters.add(c);
          break;
        }
      }
      
    }
    
  }

  public static void findPriority3(){

    for(int i =0; i< data.size(); i+=3){
           
  
      String r1 = data.get(i);
      String r2 = data.get(i+1);
      String r3 = data.get(i+2);
    
    //  System.out.println("r1:-"+r1+"-r2-"+r2+"-r3-"+ r3);
      
      HashMap<Character,Character> map = new HashMap<>();
      HashMap<Character,Character> map2 = new HashMap<>();
      
      //Add all char from group 1 to hashmap
      for(int k=0; k< r1.length(); k++){
        char c = r1.charAt(k);
        map.put(c,c);
      }

      //Add all char to grop2
      for(int j=0; j< r2.length(); j++){
        char c = r2.charAt(j);
        map2.put(c,c);
      }

      for(int p=0; p<r3.length();p++){
        char c =r3.charAt(p);
        if(map.containsKey(c) && map2.containsKey(c)){
          System.out.println("contains: "+ c);
          letters3.add(c);
          break;
        }
      }
      
    }
    
  }

  public static int getScore(){
    int total=0;
    for(Character c: letters){
      
      int score = priority.get(c);
      //System.out.println("c: "+c+ " score: "+ score);
      total = total + score;
    }
    return total;
  }

  
  public static int getScore3(){
    int total=0;
    for(Character c: letters3){
      
      int score = priority.get(c);
      //System.out.println("c: "+c+ " score: "+ score);
      total = total + score;
    }
    return total;
  }
  public static void main(String[] args) {

    readFile("rucksack3.txt");
    findPriority();
    createPriority();
    int total = getScore();
    System.out.println("Total: "+ total);
    
    findPriority3();
    System.out.println("Total3: "+ getScore3());
    
    System.out.println("Hello world!");
  }
}