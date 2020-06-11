package com.fengkun.studey.leetcode;

/**
 * @author : fengkun
 * @date : 20-6-11
 * 内容 ： 给定一个非负整数 c ，你要判断是否存在两个整数 a 和 b，使得 a2 + b2 = c
 * Input: 5
 * Output: True
 * Explanation: 1 * 1 + 2 * 2 = 5
 */
public class SquareSum {

  public static void main(String[] args) {

    System.out.println(judgeSquareSum(3));
  }

  public static boolean judgeSquareSum(int target) {
    if (target < 0) {
      return false;
    }
    int i = 0;
    int j = (int) Math.sqrt(target);
    while (i <= j) {
      int squareSum = i * i + j * j;
      if (squareSum == target) {
        return true;
      } else if (squareSum < target) {
        i++;
      } else {
        j--;
      }
    }
    return false;
  }
}
