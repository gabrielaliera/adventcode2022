import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;

public class Main{

  static ArrayList<String> data = new ArrayList<>();
  static Node<String> root = new Node<>("/");
  static Node<String> cd = root;
  
  public static void readFile(String filenName){
    try{
      File myObj = new File(filenName);
      Scanner scan = new Scanner(myObj);

      while( scan.hasNext()){
        String str = scan.nextLine();
      //  System.out.println(str);
        data.add(str);
      }

      scan.close();
    } catch( FileNotFoundException e){
      System.out.println("File Error");
    }
  }

  public static void createDir(){

    for(String str : data){
      //if(str.substring(0,1).equasl("$"))
      
      if(isCommand(str)){
        //process command
      } else {
        //Need to input parent node
        makeChild(str);
      }
    }
  }
  public static void makeChild(String s){
    String [] blocks = s.split(" ");
    if(blocks[0].equals("dir")){
      Node<String> child = new Node<>(blocks[1]);
    } else {
      int size = Integer.valueOf(blocks[0]);
      Node<String> child = new Node<>(blocks[1]);
      child.setSize(size);
    }
  }


  public static boolean isCommand(String s){
    if(s.substring(0,1).equals("$")){
      return true;
    }
    return false;
  }

  public static void processCommand(String s){
        String[] command = s.split(" ");
    if(command[1].equals("cd")){
      changeDir(command[2]);
    } else {
      //command is list
    }
  }

  public static void changeDir(String dir){
    if(dir.equals("..")){
      //move up
      cd = cd.getParent();
    } else {
      cd = cd.getChild(dir);
        //instead of findind child I find child
    }
  }
  public static void main(String[] args) {        

    readFile("Day7/input.txt");
    createDir();
    makeChild("dir dsa");
    makeChild("12324 sdf");
    System.out.println("Hello world!");
  }
}