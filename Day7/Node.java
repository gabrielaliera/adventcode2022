import java.util.LinkedList;

public class Node <E> {

  String name;
  int size;
  Node<E> parent;
  LinkedList<Node<E>> children;
  boolean isDir= false;

  Node<E> child1;
  Node<E> child2;
  Node<E> child3;
  Node<E> child4;
  Node<E> child5;
  Node<E> child6;
  Node<E> child7;
  Node<E> child8;
  Node<E> child9;
  Node<E> child10;
  int count = 0;

  Node(String n){
    this.name=n;
    this.children = new LinkedList<>();
  }
  
  Node(String n, Node<E> p){
    this.name=n;
    this.parent =p;
    this.children = new LinkedList<>();
  }

  public void addChild(String s ){
    Node<E> curr = new Node<>(s);
    children.add(curr) ;
    // switch(count){
    //   case 0:
    //     child1 = curr;
    //     count++;
    //     break;
    //   case 1:
    //     child2 = curr;
    //     count++;
    //     break;
    //   case 2:
    //     child3 = curr;
    //     count++;
    //     break;
    //   case 3:
    //     child4 = curr;
    //     count++;
    //     break;
    //   case 4:
    //     child5 = curr;
    //     count++;
    //     break;
    //   case 5:
    //     child6 = curr;
    //     count++;
    //     break;
    //   case 6:
    //     child7 = curr;
    //     count++;
    //     break;
    //   case 7:
    //     child8 = curr;
    //     count++;
    //     break;
    //   case 8:
    //     child9 = curr;
    //     count++;
    //     break;
    //   case 9:
    //     child10 = curr;
    //     count++;
    //     break;
    // }
  }

  public void setSize(int num){size = num;}
  public int getSize(){return size;}
  public String getName(){return name;}
  
   public Node<E> getChild(String name){
    Node<E> child=null;
    
     for(int i=0; i< children.size();i++){
      Node<E> curr = children.get(i);

     // System.out.print(curr.getName()+" ");
      if(curr.getName().equals(name)){
        child= curr;
      }
    }
   return child;
  }

  public void setChild(Node<E> curr){
    children.addLast(curr) ;
  }
  

  public Node<E> getParent(){
    return parent;
  }
  public void setParent(Node<E>p){parent=p;}

  public LinkedList<Node<E>> getChildren(){return children;}

  public boolean isDirectroy(){return isDir;}
  public void setIsDirectory(boolean x){isDir=x;}
  
}