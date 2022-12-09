public class Node <E> {

  String name;
  int size;
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
  }

  public void addChild(String s ){
    Node<E> curr = new Node<>(s);
    
    switch(count){
      case 0:
        child1 = curr;
        count++;
        break;
      case 1:
        child2 = curr;
        count++;
        break;
      case 2:
        child3 = curr;
        count++;
        break;
      case 3:
        child4 = curr;
        count++;
        break;
      case 4:
        child5 = curr;
        count++;
        break;
      case 5:
        child6 = curr;
        count++;
        break;
      case 6:
        child7 = curr;
        count++;
        break;
      case 7:
        child8 = curr;
        count++;
        break;
      case 8:
        child9 = curr;
        count++;
        break;
      case 9:
        child10 = curr;
        count++;
        break;
    }
  }

  public void setSize(int num){size = num;}
  public int getSize(){return size;}
  
  public Node<E> getChild(int num){
    switch(num){
      default :
        return child1;
      case 1:
        return child1;
      case 2:
        return child2;
      case 3:
       return child3;
      case 4:
       return child4;
      case 5:
        return child5;
      case 6:
        return child6;
      case 7:
         return child7;
      case 8:
        return child8;
      case 9:
         return child9;
      case 10:
         return child10;
    }
  }

  public void setChild(Node<E> curr){
    switch(count){
      case 0:
        child1 = curr;
        count++;
        break;
      case 1:
        child2 = curr;
        count++;
        break;
      case 2:
        child3 = curr;
        count++;
        break;
      case 3:
        child4 = curr;
        count++;
        break;
      case 4:
        child5 = curr;
        count++;
        break;
      case 5:
        child6 = curr;
        count++;
        break;
      case 6:
        child7 = curr;
        count++;
        break;
      case 7:
        child8 = curr;
        count++;
        break;
      case 8:
        child9 = curr;
        count++;
        break;
      case 9:
        child10 = curr;
        count++;
        break;
    }
  }
}