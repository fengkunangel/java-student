package com.fengkun.studey.leetcode;

import java.util.Arrays;
import java.util.HashSet;

/**
 * @author : fengkun
 * @date : 20-6-11
 * 内容 ： 编写一个函数，以字符串作为输入，反转该字符串中的元音字母。
 * 输入: "leetcode"
 * 输出: "leotcede"
 */
public class ReverseVowels {

  private final static HashSet<Character> vowels = new HashSet<>(Arrays.asList(
      'a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'
  ));

  public static void main(String[] args) {
    System.out.println(reverseVowels("leetcode"));
  }

  public static String reverseVowels(String s) {
    if (s == null) {
      return null;
    }
    int i = 0;
    int j = s.length() - 1;
    char[] result = new char[s.length()];
    while (i <= j) {
      char ci = s.charAt(i);
      char cj = s.charAt(j);
      if (!vowels.contains(ci)) {
        result[i++] = ci;
      } else if (!vowels.contains(cj)) {
        result[j--] = cj;
      } else {
        result[i++] = cj;
        result[j--] = ci;
      }
    }
    return new String(result);
  }
}
