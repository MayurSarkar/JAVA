package LinkedList;

/**
 * Definition for singly-linked list.
 * A ListNode class is used to represent a node in the linked list.
 * Each node contains an integer value and a reference to the next node.
 */
class ListNode {
    int val; // Stores the value of the node.
    ListNode next; // Points to the next node in the list.

    // Default constructor
    ListNode() {}

    // Constructor that initializes the node with a value.
    ListNode(int val) {
        this.val = val;
    }

    // Constructor that initializes the node with a value and the next node.
    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // Create a dummy node to act as the starting point of the result list.
        ListNode dummy = new ListNode();

        // Temp node to traverse and build the result linked list.
        ListNode temp = dummy;

        // Variable to keep track of any carry from addition.
        int carry = 0;

        // Loop through both lists as long as there are nodes in l1 or l2 or a carry value exists.
        while (l1 != null || l2 != null || carry == 1) {
            int sum = 0; // To store the sum of corresponding nodes plus the carry.

            // If l1 is not null, add its value to sum and move to the next node.
            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }

            // If l2 is not null, add its value to sum and move to the next node.
            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }

            // Add the carry (from the previous iteration) to the sum.
            sum += carry;

            // Update the carry: if sum is 10 or more, carry will be 1, otherwise 0.
            carry = sum / 10;

            // Create a new node with the digit value (remainder when sum is divided by 10).
            ListNode node = new ListNode(sum % 10);

            // Attach this new node to the next of temp (building the result list).
            temp.next = node;

            // Move temp to the next node to continue building the result list.
            temp = temp.next;
        }

        // Return the result list, skipping the dummy node at the start.
        return dummy.next;
    }

    // Helper method to print a linked list.
    public void printList(ListNode node) {
        while (node != null) {
            System.out.print(node.val);
            if (node.next != null) {
                System.out.print(" -> ");
            }
            node = node.next;
        }
        System.out.println();
    }


}



public class ADD_TWO_NUMBERS {
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Create first linked list: 2 -> 4 -> 3 (represents 342)
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);

        // Create second linked list: 5 -> 6 -> 4 (represents 465)
        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);

        // Add the two numbers and get the result as a linked list
        ListNode result = solution.addTwoNumbers(l1, l2);

        // Print the result linked list: should be 7 -> 0 -> 8 (represents 807)
        System.out.print("Result: ");
        solution.printList(result);
    }
}
