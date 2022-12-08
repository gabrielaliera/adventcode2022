import java.util.Stack;
import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.Scanner; // Import the Scanner class to read text files
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Queue;
import java.util.LinkedList;
import java.lang.StringBuilder;

class Main {

  static ArrayList<Integer> data= new ArrayList<>();  //Hold string from text file
  static Stack<Character> stack1 = new Stack<>();
  static Stack<Character> stack2 = new Stack<>();
  static Stack<Character> stack3 = new Stack<>();
  static Stack<Character> stack4 = new Stack<>();
  static Stack<Character> stack5 = new Stack<>();
  static Stack<Character> stack6 = new Stack<>();
  static Stack<Character> stack7 = new Stack<>();
  static Stack<Character> stack8 = new Stack<>();
  static Stack<Character> stack9 = new Stack<>();

  static Stack<Character> stackTo;
  static Stack<Character> stackFrom;
  static char C  = 'C'; static char S = 'S'; static char G = 'G';  static char B = 'B';
  static char V  = 'V'; static char N = 'N'; static char J = 'J';  static char H = 'H';
  static char W  = 'W'; static char M = 'M'; static char T = 'T';  static char Q = 'Q';
  static char L  = 'L'; static char P = 'P'; static char F = 'F';  static char Z = 'Z';
  static char D  = 'D';

  static HashMap<Integer, Stack<Character>> map = new HashMap<>();
  
  public static void printStack(Stack<Character> s){
   //System.out.print(s.getClass());
    while(!s.isEmpty()){
      System.out.print(s.pop()+" ");
    }
    System.out.println();
  }

  public static void createStacks(){
    stack1.push(B);
    stack1.push(G);
    stack1.push(S);
    stack1.push(C);
   // printStack(stack1);

    stack2.push(T);
    stack2.push(M);
    stack2.push(W);
    stack2.push(H);
    stack2.push(J);
    stack2.push(N);
    stack2.push(V);
    stack2.push(G);
   // printStack(stack2);
    
    stack3.push(M);
    stack3.push(Q);
    stack3.push(S);
  //  printStack(stack3);

    stack4.push(B);
    stack4.push(S);
    stack4.push(L);
    stack4.push(T);
    stack4.push(W);
    stack4.push(N);
    stack4.push(M);
  //  printStack(stack4);
    
    stack5.push(J);
    stack5.push(Z);
    stack5.push(F);
    stack5.push(T);
    stack5.push(V);
    stack5.push(G);
    stack5.push(W);
    stack5.push(P);
   // printStack(stack5);
    
    stack6.push(C);
    stack6.push(T);
    stack6.push(B);
    stack6.push(G);
    stack6.push(Q);
    stack6.push(H);
    stack6.push(S);
   // printStack(stack6);

    
    stack7.push(T);
    stack7.push(J);
    stack7.push(P);
    stack7.push(B);
    stack7.push(W);
   // printStack(stack7);
  
    stack8.push(G);
    stack8.push(D);
    stack8.push(C);
    stack8.push(Z);
    stack8.push(F);
    stack8.push(T);
    stack8.push(Q);
    stack8.push(M);
   // printStack(stack8);
    
    stack9.push(N);
    stack9.push(S);
    stack9.push(H);
    stack9.push(B);
    stack9.push(P);
    stack9.push(F);
    //printStack(stack9);
  }

 public static void readFile(String fileName) {
    try{
      File myObj = new File(fileName);
      Scanner scan = new Scanner(myObj);

     // scan.useDelimiter("[-,\\n]");
      while (scan.hasNextLine()) {   //Read file
        String[] strLine = scan.nextLine().split(" ");
        
        if(strLine[0].equals("move")){
          data.add(Integer.parseInt(strLine[1]));
        }
         if(strLine[2].equals("from")){
          data.add(Integer.parseInt(strLine[3]));
        }

        if(strLine[4].equals("to")){
          data.add(Integer.parseInt(strLine[5]));
        }
      
      
      }
    scan.close();
    } catch (FileNotFoundException e) {
      System.out.println("An error occurred.");
      e.printStackTrace();
    }
  }

  public static void moveStacks(){

    for(int i=0;i< data.size();i+=3){ // Read each instruction
      int move = data.get(i);
      int fromStack = data.get(i+1);
      int toStack = data.get(i+2);
      
     // System.out.println(move+" "+fromStack+" "+toStack);

     // System.out.println(map.get(toStack).getClass());
      for(int j=0; j<move;j++){
        map.get(toStack).push(map.get(fromStack).pop());
      }  
    }
  }

   public static void moveStacks2(){

    for(int i=0;i< data.size();i+=3){ // Read each instruction
      int move = data.get(i);
      int fromStack = data.get(i+1);
      int toStack = data.get(i+2);
      
     // System.out.println(move+" "+fromStack+" "+toStack);

      Stack<Character> stack = new Stack<>();
      for(int j=0; j<move;j++){
        stack.push(map.get(fromStack).pop());
      }

      for(int j=0; j<move;j++){
        map.get(toStack).push(stack.pop());
      }
      
    }
  }
 
  public static void createMap(){
    map.put(1,stack1);
    map.put(2,stack2);
    map.put(3,stack3);
    map.put(4,stack4);
    map.put(5,stack5);
    map.put(6,stack6);
    map.put(7,stack7);
    map.put(8,stack8);
    map.put(9,stack9);
  }

  public static String viewTops(){
    StringBuilder str = new StringBuilder();

    for(int i=1;i<10;i++){
      str.append(map.get(i).peek());
    }
    return str.toString();
  }
  
  
  public static void main(String[] args) {        
    createStacks();
    // printStack(stack1);
    // printStack(stack2);
    // printStack(stack3);
    // printStack(stack4);
    // printStack(stack5);
    // printStack(stack6);
    // printStack(stack7);
    // printStack(stack8);
    // printStack(stack9);
    readFile("Day5/crates.txt");
    System.out.println("GEYT");
    createMap();
  // moveStacks();
    moveStacks2();
    System.out.println(viewTops());
    System.out.println("Hello world!");
  }
}