package ca.jrvs.practice.codingChallenge;


/**
 *
 * Big(O)  --> Constant 0(1)
 * the link of ticket --> https://www.notion.so/jarvisdev/Ozguc-Dalga-Coding-Challenges-4-questions-per-week-aa333f20cd83434995f73bfdfdbfcee4?v=5d88ee1695014d02a0a51b70f48d9e80&p=6aee79ff381e4a79a2fdd2a0f9443917
 */
public class implementStackUsingQueue {
  int array [];
  int size;
  int rear;
  int front;

  public void  QueueCluster(int size){
    this.size= size;
    array = new int [size];
    front=0;
    rear=-1;
  }

  void enQueue(int data){

    if(isFull()){
      System.out.println("The Queue is full , You can not add anything");
    }else {
      rear++;
      array[rear] = data;
      System.out.println("It's added to the queue");
    }
  }

  void deQueue() {
    if(isEmpty()){
      System.out.println("There is noe any element for deleting at the end of the Queue");

    }else{
      int number = array[front];
      for(int i=0; i<= rear; i++){
        array[i-1]= array[i];
      }
      rear--;
      System.out.println("\n " + number + "It is removed from List");
    }
  }

  private boolean isEmpty(){
    return rear == -1;
  }
  private boolean isFull() {
      return rear== size-1;
  }

  void  ElementNumbers(){
    System.out.println(" the number of element is  " + (rear +1 ));
  }

  void print(){
  int i= rear;
  System.out.println("The last element    ->");
  while(i>=0){
    System.out.println(array[i] + " -> ");
    i--;
  }

  System.out.println("Primary element");
    }


}

















