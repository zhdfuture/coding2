public class ListNode {
     int value;
      ListNode next;
      ListNode(int x) { value = x; }
  class Solution {
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            int jinwei = 0;  //进位
            int x = 0, y = 0;
            ListNode tempHead = new ListNode(0);  //哑元结点
            ListNode p1 = l1;
            ListNode p2 = l2;
            ListNode currency = tempHead;
            while (p1 != null || p2 != null) {
                if (p1 != null) {
                    x = p1.value;
                } else {
                    x = 0;
                }
                if (p2 != null) {
                    y = p2.value;
                } else {
                    y = 0;
                }
                int result = jinwei + x + y;
                jinwei = result / 10;   //更新进位的值
                currency.next = new ListNode(result % 10);    //新节点（当前的下一个）
                currency=currency.next;
                if (p1 != null) {           //同时往后走
                    p1 = p1.next;
                }
                if (p2 != null) {
                    p2 = p2.next;
                }
            }

            if(jinwei>0){
                currency.next=new ListNode(jinwei);
            }
            return tempHead.next;
        }
    }

    public static void main(String[] args) {

    }
}
