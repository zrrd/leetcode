package code;

/**
 * 两个排序数组的中位数.
 *
 * @author 邵益炯
 * @date 2018/11/6
 */
@SuppressWarnings("all")
public class Code4 {

  /**
   * 给定两个大小为 m 和 n 的有序数组 nums1 和 nums2 。
   *
   * 请找出这两个有序数组的中位数。要求算法的时间复杂度为 O(log (m+n)) 。
   *
   * 你可以假设 nums1 和 nums2 不同时为空。
   *
   * 示例 1:
   *
   * nums1 = [1, 3] nums2 = [2]
   *
   * 中位数是 2.0 示例 2:
   *
   * nums1 = [1, 2] nums2 = [3, 4]
   *
   * 中位数是 (2 + 3)/2 = 2.5
   */
  public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
    int l1 = nums1.length;
    int l2 = nums2.length;
    int[] num3 = new int[l1 + l2];
    int i = 0;
    int j = 0;
    while (i < l1 && j < l2) {
      if (nums1[i] < nums2[j]) {
        num3[i + j] = nums1[i];
        i++;
      } else {
        num3[i + j] = nums2[j];
        j++;
      }
    }
    if (i == l1) {
      for (; j < l2; j++) {
        num3[i + j] = nums2[j];
      }
    } else if (j == l2) {
      for (; i < l1; i++) {
        num3[i + j] = nums1[i];
      }
    }
    if (num3.length % 2 == 0) {
      return (num3[num3.length / 2 -1] + num3[num3.length / 2]) * 1.0 / 2;
    } else {
      return num3[num3.length / 2] * 1.0;
    }
  }

  public static void main(String[] args) {
    int[] nums1 = new int[]{1,1, 2,5,6};
    int[] nums2 = new int[]{3, 4,7,10,11};
    double a = findMedianSortedArrays(nums1, nums2);
    System.out.println(a);
  }
}
