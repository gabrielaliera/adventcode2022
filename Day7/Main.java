import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.LinkedList;

public class Main{

  static ArrayList<String> data = new ArrayList<>();
  static Node<String> root = new Node<>("/");
  static Node<String> cd = root;
  static int sum=0;
  
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
    //  System.out.println(str);
      
      if(isCommand(str)){
       // System.out.println("isCommand-true");
        processCommand(str);
      } else {
        Node<String> child = makeChild(str);
        child.setParent(cd);
        cd.setChild(child);
      }
    }
  }
  public static Node<String> makeChild(String s){
    String [] blocks = s.split(" ");
    Node<String> child;
    
    if(blocks[0].equals("dir")){
     child = new Node<>(blocks[1],cd);
     child.setIsDirectory(true);
    } else {
      int size = Integer.valueOf(blocks[0]);
      child = new Node<>(blocks[1],cd);
      child.setSize(size);
    }
    return child;
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
    } else if( !dir.equals("/")){
     // System.out.println("CD before: "+cd.getName());
     // System.out.println("looking for:"+dir);
      cd = cd.getChild(dir);
        //instead of findind child I find child
    }
  }

  public static int makefileSize(Node<String> parent){
    LinkedList<Node<String>> children = parent.getChildren();
    int total = 0;
    for(Node<String> child: children){
      if(child.getSize()!= 0){
         int size = child.getSize();
         total += size;
      } else{
         total += makefileSize(child);
        //recursive find sizze//make change recurives to return filesize
      }
    }
    parent.setSize(total);
    return total;
  }

  public static void findSum( Node<String> root){
    for(Node<String> child: root.getChildren()){
     if(child.isDirectroy()){
       System.out.println(child.getName()+"true");
       if(child.getSize()<=100000){
         sum+=child.getSize();
       }
       findSum(child);
     }
       //System.out.println(child.getName()+" "+child.getSize());
    }
  }
  

  
  public static void main(String[] args) {        

    readFile("Day7/input.txt");
    createDir();
    makefileSize(root);
  //     System.out.println(root.getSize());
  // for(Node<String> child: root.getChildren()){
  //   System.out.println(child.getName()+" "+child.getSize());
  // }
    findSum(root);
    System.out.println(sum);
    System.out.println("Hello world!");
  }
}