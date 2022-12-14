public class Cycle{

  int score;
  int endCycle;
  String name;

  Cycle(int s,int ec){
    this.score= s;
    this.endCycle=ec;
  }
  
  public void setScore(int n){score=n;}
  public int getScore(){return score;}
  public void setEndCycle(int n){endCycle =n;}
  public int getEndCycle(){return endCycle;}

  public void setName(String s){name=s;}
  public String getName(){return name;}
}