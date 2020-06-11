package com.fengkun.studey.leetcode;

/**
 * @author : fengkun
 * @date : 20-6-11
 * 内容 ： 在有序数组中找出两个数，使它们的和为 target。
 * Input: numbers={2, 7, 11, 15}, target=9
 * Output: index1=1, index2=2
 */
public class SumEqualTarget {

  public static void main(String[] args) {
    int[] numbers = {2, 7, 11, 15};
    int[] output = twoSum(numbers, 9);
    if (output.length > 0) {
      for (int i = 0; i < output.length; i++) {
        System.out.println(output[i]);
      }
    }
  }

  public static int[] twoSum(int[] numbers, int target) {
    if (numbers == null)
      return null;
    int i = 0;
    int j = numbers.length - 1;
    while (i < j) {
      int sum = numbers[i] + numbers[j];
      if (sum == target) {
        return new int[]{i + 1, j + 1};
      } else if (sum < target) {
        i++;
      } else {
        j--;
      }
    }
    return null;
  }
}
