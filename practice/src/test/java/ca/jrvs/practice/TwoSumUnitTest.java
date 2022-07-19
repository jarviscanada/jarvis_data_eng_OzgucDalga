package ca.jrvs.practice;

import org.junit.Test;

public class TwoSumUnitTest {

  public int[] TesttwoNumbersSum(int[] numbs, int target) {

    int pointerA = 0;
    int pointerB = numbs.length - 1;

    while (pointerA <= pointerB) {
      int sum = numbs[pointerA] + numbs[pointerB];

      if (sum > target) {
        pointerB -= 1;
      } else if (sum < target) {
        pointerA += 1;
      } else
        return new int[]{pointerA, pointerB};

    }
    return new int[]{pointerA, pointerB};

  }
}