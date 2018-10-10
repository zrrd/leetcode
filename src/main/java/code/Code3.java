package code;

import java.util.HashSet;
import java.util.Set;

/**
 * @author 邵益炯
 * @date 2018/10/10
 */
@SuppressWarnings("all")
public class Code3 {

  /**
   * 给定一个字符串，找出不含有重复字符的最长子串的长度。
   *
   * 示例 1:
   *
   * 输入: "abcabcbb" 输出: 3 解释: 无重复字符的最长子串是 "abc"，其长度为 3。 示例 2:
   *
   * 输入: "bbbbb" 输出: 1 解释: 无重复字符的最长子串是 "b"，其长度为 1。 示例 3:
   *
   * 输入: "pwwkew" 输出: 3 解释: 无重复字符的最长子串是 "wke"，其长度为 3。 请注意，答案必须是一个子串，"pwke" 是一个子序列 而不是子串。
   */
  public  static int lengthOfLongestSubstring(String s) {
    if (s.isEmpty()) {
      return 0;
    }
    int max = 1;
    Set<Character> set = new HashSet<>();
    for (int i = 0; i < s.length(); i++) {
      set.add(s.charAt(i));
      for (int j = i + 1; j < s.length(); j++) {
        if (!set.add(s.charAt(j))) {
          break;
        }
      }
      if (set.size() > max) {
        max = set.size();
      }
      set.clear();
    }
    return max;
  }

  /**
   * 滑动窗口
   */
  public int lengthOfLongestSubstring2(String s) {
    int n = s.length();
    Set<Character> set = new HashSet<>();
    int ans = 0, i = 0, j = 0;
    while (i < n && j < n) {
      // try to extend the range [i, j]
      if (!set.contains(s.charAt(j))){
        set.add(s.charAt(j++));
        ans = Math.max(ans, j - i);
      }
      else {
        set.remove(s.charAt(i++));
      }
    }
    return ans;
  }
  /**
   * 最优解
   * 当我们知道该字符集比较小的时侯，我们可以用一个整数数组作为直接访问表来替换 Map。
   *
   * 常用的表如下所示：
   *
   * int [26] 用于字母 ‘a’ - ‘z’或 ‘A’ - ‘Z’
   * int [128] 用于ASCII码
   * int [256] 用于扩展ASCII码
   */
  public int lengthOfLongestSubstring3(String s) {
    int n = s.length(), ans = 0;
    int[] index = new int[128]; // current index of character
    // try to extend the range [i, j]
    for (int j = 0, i = 0; j < n; j++) {
      i = Math.max(index[s.charAt(j)], i);
      ans = Math.max(ans, j - i + 1);
      index[s.charAt(j)] = j + 1;
    }
    return ans;
  }

  public static void main(String[] args) {
    int size = lengthOfLongestSubstring("au");
    System.out.println(size);
  }
}
