import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;
public class Main{

  static ArrayList<String> data = new ArrayList<>();
  static int[][] grid;
  
  public static void readFile(String fileName){
    try{
      File myObj = new File(fileName);
      Scanner scan = new Scanner(myObj);

      while (scan.hasNext()){
        String line = scan.nextLine();
        data.add(line);
      }
      scan.close();
    } catch(FileNotFoundException e){
      System.out.println("File Reading Error");
    }
  }

  public static void createMatrix(){
    int len = data.size();
    char[] numberRow = data.get(0).toCharArray();
    int width = numberRow.length;

    grid = new int[len][width];
    int row= 0;
    for(String line: data){
      numberRow = line.toCharArray();
      for(int i=0;i<numberRow.length;i++){
         int num = Integer.valueOf(numberRow[i]);
         grid[row][i] = num;
      }
      row++;
    } 
    
    System.out.println("L: "+ len+" W: "+ width);
  }

   public static void main(String[] args) {        

    readFile("Day8/grid.txt");
    createMatrix();
    
    System.out.println("Hello world!");
  }
}