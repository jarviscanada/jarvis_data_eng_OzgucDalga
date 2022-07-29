package ca.jrvs.practice.codingChallenge;
/**
 * big(0) O(n) -> Linear
 * ticket url is attacjed :
 * https://www.notion.so/jarvisdev/Ozguc-Dalga-Coding-Challenges-4-questions-per-week-aa333f20cd83434995f73bfdfdbfcee4?p=0f8cc9c80d8f491db1cc0b1fc2c21ccb
 */
 class ListNode {
  int val;
  ListNode next;
  ListNode() {}
  ListNode(int val) {
    this.val = val;
  }
  ListNode(int val, ListNode next) {
    this.val = val;
    this.next = next;
  }
}

public class reversedLinkList {
  public ListNode reverseList(ListNode head){
    ListNode prev = null;
    while(head!= null){
      ListNode next = head.next;
      head.next= prev;
      prev=head;
      head=next;
    }
    return prev;
  }
}
