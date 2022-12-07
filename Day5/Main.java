import java.util.Stack;
import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.Scanner; // Import the Scanner class to read text files


class Main {
  
  static Stack<Character> stack1 = new Stack<>();
  static Stack<Character> stack2 = new Stack<>();
  static Stack<Character> stack3 = new Stack<>();
  static Stack<Character> stack4 = new Stack<>();
  static Stack<Character> stack5 = new Stack<>();
  static Stack<Character> stack6 = new Stack<>();
  static Stack<Character> stack7 = new Stack<>();
  static Stack<Character> stack8 = new Stack<>();
  static Stack<Character> stack9 = new Stack<>();
  static char C  = 'C'; static char S = 'S'; static char G = 'G';  static char B = 'B';
  static char V  = 'V'; static char N = 'N'; static char J = 'J';  static char H = 'H';
  static char W  = 'W'; static char M = 'M'; static char T = 'T';  static char Q = 'Q';
  static char L  = 'L'; static char P = 'P'; static char F = 'F';  static char Z = 'Z';
  static char D  = 'D';
  
  public static void printStack(Stack<Character> s){
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
    printStack(stack1);

    stack2.push(T);
    stack2.push(M);
    stack2.push(W);
    stack2.push(H);
    stack2.push(J);
    stack2.push(N);
    stack2.push(V);
    stack2.push(G);
    printStack(stack2);
    
    stack3.push(M);
    stack3.push(Q);
    stack3.push(S);
    printStack(stack3);

    stack4.push(B);
    stack4.push(S);
    stack4.push(L);
    stack4.push(T);
    stack4.push(W);
    stack4.push(N);
    stack4.push(M);
    printStack(stack4);
    
    stack5.push(J);
    stack5.push(Z);
    stack5.push(F);
    stack5.push(T);
    stack5.push(V);
    stack5.push(G);
    stack5.push(W);
    stack5.push(P);
    printStack(stack5);
    
    stack6.push(C);
    stack6.push(T);
    stack6.push(B);
    stack6.push(G);
    stack6.push(Q);
    stack6.push(H);
    stack6.push(S);
    printStack(stack6);

    
    stack7.push(T);
    stack7.push(J);
    stack7.push(P);
    stack7.push(B);
    stack7.push(W);
    printStack(stack7);
    
    stack8.push(G);
    stack8.push(D);
    stack8.push(C);
    stack8.push(Z);
    stack8.push(F);
    stack8.push(T);
    stack8.push(Q);
    stack8.push(M);
    printStack(stack8);
    
    stack9.push(N);
    stack9.push(S);
    stack9.push(H);
    stack9.push(B);
    stack9.push(P);
    stack9.push(F);
    printStack(stack9);
  }

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
  
  public static void main(String[] args) {
    
  createStacks();
  
    
    System.out.println("Hello world!");
  }
}