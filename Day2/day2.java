import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.Scanner; // Import the Scanner class to read text files
import java.util.ArrayList;
import java.util.HashMap;


class day2 {
  static ArrayList<String> data= new ArrayList<>();  //Hold string from text file
  static ArrayList<Integer>wins = new ArrayList<>();
  static ArrayList<Integer>wins2 = new ArrayList<>();
 
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

  public static void print(){
    for(int i=0; i<20;i++){
      System.out.println(data.get(i));
    }
  }

  public static void calculateWins(){
    int selScore;
    int winScore;
    int sel2;
    int win2;

    for(String s: data){
      String elf= s.substring(0,1);
      String gaby = s.substring(2);

      selScore = selectionScore(gaby);
      //System.out.println("gaby:"+gaby+" score:"+selScore);
        
      if(gaby.equals("X")){
        winScore = roundX(elf);

        sel2 = lose(elf);
        win2 = 0;
      } else if(gaby.equals("Y")){
        winScore = roundY(elf);

        sel2 = draw(elf);
        win2 =3;
      } else {
        winScore = roundZ(elf);

        sel2 = win(elf);
        win2=6;
      }
     // System.out.println("s1-" +elf +"-s2: -"+gaby + " selScore: "+ selScore + " win: "+ winScore);

      wins.add(selScore+ winScore);
      wins2.add(win2 + sel2);
    }

    
  }

  public static int draw(String elf){
    if (elf.equals("A")){
           return 1;  
    } else if (elf.equals("B")){
           return 2;
    } else {
      return 3;
    }
  }

   public static int win(String elf){
    if (elf.equals("A")){
           return 2;  
    } else if (elf.equals("B")){
           return 3;
    } else {
      return 1;
    }
  }

   public static int lose(String elf){
    if (elf.equals("A")){
           return 3;  
    } else if (elf.equals("B")){
           return 1;
    } else {
      return 2;
    }
  }
  
  public static int roundX(String elf){
    if (elf.equals("A")){
           return 3;  
    } else if (elf.equals("B")){
           return 0;
    } else {
      return 6;
    }
    
    
  }
  
  public static int roundY(String elf){
    if (elf.equals("A")){
           return 6;  
    } else if (elf.equals("B")){
           return 3;
    } else {
      return 0;
    } 
    
    
  }
  
  public static int roundZ(String elf){
    if (elf.equals("A")){
           return 0;  
    } else if (elf.equals("B")){
           return 6;
    } else {
      return 3;
    } 
  } 
    

  public static int selectionScore(String s){
    
    if (s.equals("X")){
           return 1;  
    } else if (s.equals("Y")){
           return 2;
    } else {
      return 3;
    }
    
  }
  
  public static void main(String[] args) {


    readFile("rps.txt");
    //print();
    calculateWins();

    int total = 0;
    for(int score: wins){
      total = total + score;
    }
    System.out.println("Total: "+total);


    total = 0;
    
    for(int score: wins2){
      total = total + score;
    }
    System.out.println("Totalv2: "+ total);
    System.out.println("Hello world!");
  }
}