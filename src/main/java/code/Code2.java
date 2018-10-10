package code;

/**
 * @author 邵益炯
 * @date 2018/10/10
 */
@SuppressWarnings("all")
public class Code2 {

  /**
   * 给定两个非空链表来表示两个非负整数。位数按照逆序方式存储，它们的每个节点只存储单个数字。将两数相加返回一个新的链表。
   *
   * 你可以假设除了数字 0 之外，这两个数字都不会以零开头。
   *
   * 示例：
   *
   * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4) 输出：7 -> 0 -> 8 原因：342 + 465 = 807
   */
  static class ListNode {

    int val;
    ListNode next;

    ListNode(int x) {
      val = x;
    }
  }

  public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    ListNode a = new ListNode(0);
    ListNode b = a;
    int mark = 0;
    int num1 = 0;
    int num2 = 0;
    while (l1 != null || l2 != null) {
      num1 = 0;
      num2 = 0;
      if (l1 != null) {
        num1 = l1.val;
        l1 = l1.next;
      }
      if (l2 != null) {
        num2 = l2.val;
        l2 = l2.next;
      }
      int sum = num1 + num2 + mark;
      mark = sum / 10;
      if (mark == 1) {
        sum -= 10;
      }

      b.next = new ListNode(sum);
      b = b.next;
    }
    if (mark == 1) {
      b.next = new ListNode(1);
    }
    return a.next;
  }

  public static void main(String[] args) {
    ListNode l1 = new ListNode(5);
    l1.next = new ListNode(9);
    l1.next.next = new ListNode(9);
    l1.next.next.next = new ListNode(9);
    l1.next.next.next.next = new ListNode(3);

    ListNode l2 = new ListNode(5);
    l2.next = new ListNode(6);
    l2.next.next = new ListNode(4);

    ListNode a = addTwoNumbers(l1, l2);
    while (a != null) {
      System.out.print(a.val);
      a = a.next;
    }
  }
}
