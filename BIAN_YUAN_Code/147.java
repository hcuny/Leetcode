/**
 * @author tianning.htn
 *
 */
public class Maths {

	public static class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

	public static ListNode insertionSortList(ListNode head) {
		if (head == null) {
			return null;
		}
		/** 排序好后的 链表 */
		ListNode sortedList = new ListNode(0);
		/** 从传入链表里拿出来要插入到新链表的 node */
		ListNode cur = head;
		/** 既然从传入链表里拿出去了node cur，那么cur.next的链表需要有对象来保存 */
		ListNode next = null;
		/**
		 * 排序必然涉及遍历，但是由于单链表，sortedList遍历后是不可逆的，我tm找不到原来的head了呀，所以要一个缓冲对象专门用来从头遍历
		 */
		ListNode pre = sortedList;

		while (cur != null) {
			// backup 后续链表
			next = cur.next;
			// 已排序的部分链表的副本，从最小的开始遍历，得到要插入的位置,先判断null可以避免空指针
			while (pre.next != null && pre.next.val < cur.val) {
				pre = pre.next;
			}
			/**                 cur.next
			 *                   ↓
			 *              _    _   _
			 *         cur |_|→ |_|→|_|→........
			 *   _    _ ↓ _   _   _
			 *  |_|→ |_|→|_|→|_|→|_|→........
			 *        ↑   ↑
			 *       pre pre.next
			 *       
			 *          ↓↓↓     pre.next
			 *              _   ↓_   _   _
			 *         cur |_| →|_|→|_|→|_|→........
			 *   _    _ ↓ _   _   _
			 *  |_|→ |_|→|_|→|_|→|_|→........
			 *        ↑   ↑
			 *       pre pre.next
			 *       
			 *       
			 *          ↓↓↓
			 *              _    _   _   _
			 *         cur |_| →|_|→|_|→|_|→........
			 *   _    _     ↑    ↑
			 *  |_|→ |_|-----    pre.next 
			 *        ↑   
			 *       pre 
			 *       
			 */
			cur.next = pre.next;
			pre.next = cur;
			/**
			 * 插入cur后，pre的位置不是在sortedList的head了，所以需要重新移回到sortedList的head
			 * 重新遍历来查找下一个cur该插入的位置
			 */
			pre = sortedList;
			cur = next;

		}
		return sortedList.next;
	}

	/**
	 * 相比于上一种每次都从最小遍历查找index的方法，这种方法划分了三种情况：head - 从最小遍历（head,tail）查找index - tail
	 * 新插入的val 小于head时，直接插在最前面，更改head指针
	 * 新插入的val 大于tail时，直接插在最后面，更改tail指针
	 * 新插入的val 介于（head,tail)时，退化为上一种方法   从最小遍历（head,tail）区间查找index
	 * 效率肯定比上一种高
	 * 
	 * @return
	 */
	public static ListNode insertionSortList2(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
		/**
		 * 为什么sortedHead、sortedTail指向同一个head的副本?
		 * 我TM置空sortedHead的后续链表，也影响到了sortedTail
		 */
		ListNode sortedHead = head;
		ListNode sortedTail = head;
		head = head.next;
		sortedHead.next = null;

		while (head != null) {
			ListNode temp = head;
			head = head.next;
			temp.next = null;

			// new val is less than the head, just insert in the front
			if (temp.val <= sortedHead.val) {
				temp.next = sortedHead;
				sortedTail = sortedHead.next == null ? sortedHead : sortedTail;
				sortedHead = temp;
			}
			// new val is greater than the tail, just insert at the back
			else if (temp.val >= sortedTail.val) {
				sortedTail.next = temp;
				sortedTail = sortedTail.next;
			}
			// new val is somewhere in the middle, we will have to find its
			// proper
			// location.
			else {
				ListNode current = sortedHead;
				while (current.next != null && current.next.val < temp.val) {
					current = current.next;
				}

				temp.next = current.next;
				current.next = temp;
			}
		}
		return sortedHead;
	}

	public static void main(String[] args) {
		ListNode listNode = new ListNode(1);
		listNode.next = new ListNode(2);
		listNode.next.next = new ListNode(3);
		System.out.println(insertionSortList2(listNode) + "\n");
	}
}
