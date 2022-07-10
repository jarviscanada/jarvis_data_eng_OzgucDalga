package ca.jrvs.practice.codingChallenge;

/**
 * Big(O) is linear (n)
 * ticket url is attached below;
 * https://www.notion.so/jarvisdev/Ozguc-Dalga-Coding-Challenges-4-questions-per-week-aa333f20cd83434995f73bfdfdbfcee4?v=5d88ee1695014d02a0a51b70f48d9e80&p=818fe7baaa08402e9718e51a81dd4395
 */
public class twoSum {
  public int[] twoNumbersSum(int[] numbs, int target) {

    int pointerA = 0;
    int pointerB=numbs.length-1;

    while(pointerA<=pointerB)
    {
      int sum = numbs[pointerA] + numbs[pointerB];

      if(sum > target){
        pointerB -=  1;
      }
      else if (sum<target){
        pointerA +=1;
      }
      else return new int[] {pointerA, pointerB };
    }
    return new int[]{pointerA, pointerB };
  }
}


