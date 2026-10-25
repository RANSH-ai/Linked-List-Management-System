/**
 * DoublyLinkedList.java
 * Linked List Management System - DSA Mini Project (2nd Year College Level)
 *
 * Implements a complete Doubly Linked List with all required operations:
 * 1. Insert at Beginning
 * 2. Insert at End
 * 3. Insert at Position
 * 4. Insert After a Node
 * 5. Insert Before a Node
 * 6. Delete from Beginning
 * 7. Delete from End
 * 8. Delete from Position
 * 9. Delete by Value
 * 10. Search
 * 11. Update
 * 12. Display Forward
 * 13. Display Backward
 * 14. Count Nodes
 * 15. Find Maximum
 * 16. Find Minimum
 * 17. Find Middle Element (Slow/Fast Pointers)
 * 18. Reverse (Pointer swapping of prev and next)
 * 19. Sort (Bubble Sort O(n^2))
 * 20. Remove Duplicates
 */

public class DoublyLinkedList {

    /**
     * DNode inner class representing each element in the Doubly Linked List.
     */
    public static class DNode {
        public int data;
        public DNode prev;
        public DNode next;

        public DNode(int data) {
            this.data = data;
            this.prev = null;
            this.next = null;
        }
    }

    // Head and Tail references
    private DNode head;
    private DNode tail;

    /**
     * Constructor initializing an empty Doubly Linked List.
     */
    public DoublyLinkedList() {
        this.head = null;
        this.tail = null;
    }

    /**
     * Get head reference.
     */
    public DNode getHead() {
        return head;
    }

    /**
     * Get tail reference.
     */
    public DNode getTail() {
        return tail;
    }

    /**
     * Check if list is empty.
     */
    public boolean isEmpty() {
        return head == null;
    }

    /**
     * 1. Insert at Beginning
     * Insert before head and update both prev and next links.
     * Time Complexity: O(1)
     */
    public void insertAtBeginning(int data) {
        DNode newNode = new DNode(data);
        if (head == null) {
            head = tail = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
        System.out.println("[SUCCESS] Inserted " + data + " at the beginning.");
    }

    /**
     * 2. Insert at End
     * Attach after the tail and update the new node's prev link.
     * Time Complexity: O(1) with tail reference (or O(n) traversal).
     */
    public void insertAtEnd(int data) {
        DNode newNode = new DNode(data);
        if (head == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        System.out.println("[SUCCESS] Inserted " + data + " at the end.");
    }

    /**
     * 3. Insert at Position
     * Insert at a 1-based position and maintain both directions.
     * Time Complexity: O(n)
     */
    public boolean insertAtPosition(int data, int position) {
        int totalNodes = countNodes();

        if (position < 1 || position > totalNodes + 1) {
            System.out.println("[ERROR] Invalid position " + position + ". Valid range is 1 to " + (totalNodes + 1) + ".");
            return false;
        }

        if (position == 1) {
            insertAtBeginning(data);
            return true;
        }

        if (position == totalNodes + 1) {
            insertAtEnd(data);
            return true;
        }

        DNode newNode = new DNode(data);
        DNode current = head;
        for (int i = 1; i < position; i++) {
            current = current.next;
        }

        // Insert before 'current'
        newNode.prev = current.prev;
        newNode.next = current;
        current.prev.next = newNode;
        current.prev = newNode;

        System.out.println("[SUCCESS] Inserted " + data + " at position " + position + ".");
        return true;
    }

    /**
     * 4. Insert After a Node
     * Insert after the first matching node and reconnect neighboring links.
     * Time Complexity: O(n)
     */
    public boolean insertAfterNode(int targetValue, int data) {
        if (head == null) {
            System.out.println("[ERROR] List is empty. Cannot insert after target.");
            return false;
        }

        DNode current = head;
        while (current != null && current.data != targetValue) {
            current = current.next;
        }

        if (current == null) {
            System.out.println("[ERROR] Target value " + targetValue + " not found in the list.");
            return false;
        }

        if (current == tail) {
            insertAtEnd(data);
            return true;
        }

        DNode newNode = new DNode(data);
        newNode.next = current.next;
        newNode.prev = current;
        current.next.prev = newNode;
        current.next = newNode;

        System.out.println("[SUCCESS] Inserted " + data + " immediately after node with value " + targetValue + ".");
        return true;
    }

    /**
     * 5. Insert Before a Node
     * Insert before the first matching node and reconnect neighboring links.
     * Time Complexity: O(n)
     */
    public boolean insertBeforeNode(int targetValue, int data) {
        if (head == null) {
            System.out.println("[ERROR] List is empty. Cannot insert before target.");
            return false;
        }

        DNode current = head;
        while (current != null && current.data != targetValue) {
            current = current.next;
        }

        if (current == null) {
            System.out.println("[ERROR] Target value " + targetValue + " not found in the list.");
            return false;
        }

        if (current == head) {
            insertAtBeginning(data);
            return true;
        }

        DNode newNode = new DNode(data);
        newNode.prev = current.prev;
        newNode.next = current;
        current.prev.next = newNode;
        current.prev = newNode;

        System.out.println("[SUCCESS] Inserted " + data + " immediately before node with value " + targetValue + ".");
        return true;
    }

    /**
     * 6. Delete from Beginning
     * Remove head and update the new head's prev link.
     * Time Complexity: O(1)
     */
    public Integer deleteFromBeginning() {
        if (head == null) {
            System.out.println("[ERROR] List is empty. Underflow condition!");
            return null;
        }

        int deletedValue = head.data;

        if (head == tail) {
            head = tail = null;
        } else {
            head = head.next;
            head.prev = null;
        }

        System.out.println("[SUCCESS] Deleted " + deletedValue + " from the beginning.");
        return deletedValue;
    }

    /**
     * 7. Delete from End
     * Remove tail and update the previous node's next link.
     * Time Complexity: O(1)
     */
    public Integer deleteFromEnd() {
        if (tail == null) {
            System.out.println("[ERROR] List is empty. Underflow condition!");
            return null;
        }

        int deletedValue = tail.data;

        if (head == tail) {
            head = tail = null;
        } else {
            tail = tail.prev;
            tail.next = null;
        }

        System.out.println("[SUCCESS] Deleted " + deletedValue + " from the end.");
        return deletedValue;
    }

    /**
     * 8. Delete from Position
     * Delete a node at a specified position while preserving both links.
     * Time Complexity: O(n)
     */
    public Integer deleteFromPosition(int position) {
        if (head == null) {
            System.out.println("[ERROR] List is empty. Cannot delete from position.");
            return null;
        }

        int totalNodes = countNodes();
        if (position < 1 || position > totalNodes) {
            System.out.println("[ERROR] Invalid position " + position + ". Valid range is 1 to " + totalNodes + ".");
            return null;
        }

        if (position == 1) {
            return deleteFromBeginning();
        }

        if (position == totalNodes) {
            return deleteFromEnd();
        }

        DNode current = head;
        for (int i = 1; i < position; i++) {
            current = current.next;
        }

        int deletedValue = current.data;
        current.prev.next = current.next;
        current.next.prev = current.prev;

        System.out.println("[SUCCESS] Deleted " + deletedValue + " from position " + position + ".");
        return deletedValue;
    }

    /**
     * 9. Delete by Value
     * Delete the first matching node.
     * Time Complexity: O(n)
     */
    public boolean deleteByValue(int targetValue) {
        if (head == null) {
            System.out.println("[ERROR] List is empty. Cannot delete value.");
            return false;
        }

        DNode current = head;
        while (current != null && current.data != targetValue) {
            current = current.next;
        }

        if (current == null) {
            System.out.println("[ERROR] Value " + targetValue + " not found in the list.");
            return false;
        }

        if (current == head) {
            deleteFromBeginning();
            return true;
        }

        if (current == tail) {
            deleteFromEnd();
            return true;
        }

        current.prev.next = current.next;
        current.next.prev = current.prev;
        System.out.println("[SUCCESS] Deleted node with value " + targetValue + ".");
        return true;
    }

    /**
     * 10. Search
     * Find a value and report its 1-based position.
     * Time Complexity: O(n)
     */
    public int search(int targetValue) {
        if (head == null) {
            System.out.println("[INFO] List is empty.");
            return -1;
        }

        DNode current = head;
        int position = 1;
        while (current != null) {
            if (current.data == targetValue) {
                System.out.println("[FOUND] Value " + targetValue + " found at position " + position + ".");
                return position;
            }
            current = current.next;
            position++;
        }

        System.out.println("[NOT FOUND] Value " + targetValue + " does not exist in the list.");
        return -1;
    }

    /**
     * 11. Update
     * Replace the data of the first matching node.
     * Time Complexity: O(n)
     */
    public boolean update(int oldValue, int newValue) {
        if (head == null) {
            System.out.println("[ERROR] List is empty. Cannot update.");
            return false;
        }

        DNode current = head;
        int position = 1;
        while (current != null) {
            if (current.data == oldValue) {
                current.data = newValue;
                System.out.println("[SUCCESS] Updated value " + oldValue + " to " + newValue + " at position " + position + ".");
                return true;
            }
            current = current.next;
            position++;
        }

        System.out.println("[ERROR] Value " + oldValue + " not found in the list.");
        return false;
    }

    /**
     * 12. Display Forward
     * Traverse using next links.
     * Format matches specification: NULL <- 10 <-> 20 <-> 30 <-> 40 -> NULL
     * Time Complexity: O(n)
     */
    public void displayForward() {
        if (head == null) {
            System.out.println("[FORWARD] List is empty (NULL)");
            return;
        }

        StringBuilder sb = new StringBuilder();
        sb.append("NULL <- ");
        DNode current = head;
        while (current != null) {
            sb.append(current.data);
            if (current.next != null) {
                sb.append(" <-> ");
            }
            current = current.next;
        }
        sb.append(" -> NULL");
        System.out.println("[FORWARD] " + sb.toString());
    }

    /**
     * 13. Display Backward
     * Start at the tail and traverse using prev links.
     * Format matches specification: NULL <- 40 <-> 30 <-> 20 <-> 10 -> NULL
     * Time Complexity: O(n)
     */
    public void displayBackward() {
        if (tail == null) {
            System.out.println("[BACKWARD] List is empty (NULL)");
            return;
        }

        StringBuilder sb = new StringBuilder();
        sb.append("NULL <- ");
        DNode current = tail;
        while (current != null) {
            sb.append(current.data);
            if (current.prev != null) {
                sb.append(" <-> ");
            }
            current = current.prev;
        }
        sb.append(" -> NULL");
        System.out.println("[BACKWARD] " + sb.toString());
    }

    /**
     * 14. Count Nodes
     * Count all nodes in the list.
     * Time Complexity: O(n)
     */
    public int countNodes() {
        int count = 0;
        DNode current = head;
        while (current != null) {
            count++;
            current = current.next;
        }
        return count;
    }

    /**
     * 15. Find Maximum
     * Find the largest value.
     * Time Complexity: O(n)
     */
    public Integer findMaximum() {
        if (head == null) {
            System.out.println("[ERROR] List is empty. No maximum element.");
            return null;
        }

        int max = head.data;
        DNode current = head.next;
        while (current != null) {
            if (current.data > max) {
                max = current.data;
            }
            current = current.next;
        }
        System.out.println("[MAXIMUM] Maximum value in doubly linked list is: " + max);
        return max;
    }

    /**
     * 16. Find Minimum
     * Find the smallest value.
     * Time Complexity: O(n)
     */
    public Integer findMinimum() {
        if (head == null) {
            System.out.println("[ERROR] List is empty. No minimum element.");
            return null;
        }

        int min = head.data;
        DNode current = head.next;
        while (current != null) {
            if (current.data < min) {
                min = current.data;
            }
            current = current.next;
        }
        System.out.println("[MINIMUM] Minimum value in doubly linked list is: " + min);
        return min;
    }

    /**
     * 17. Find Middle Element
     * Find the middle using slow/fast references.
     * Rule for even length: second middle node (n/2 + 1).
     * Time Complexity: O(n), Space Complexity: O(1)
     */
    public Integer findMiddleElement() {
        if (head == null) {
            System.out.println("[ERROR] List is empty. No middle element.");
            return null;
        }

        DNode slow = head;
        DNode fast = head;
        int position = 1;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            position++;
        }

        int total = countNodes();
        if (total % 2 == 0) {
            System.out.println("[MIDDLE] Middle Element is " + slow.data + " at position " + position +
                    " (Even-length list: second middle node selected per standard convention).");
        } else {
            System.out.println("[MIDDLE] Middle Element is " + slow.data + " at position " + position + ".");
        }
        return slow.data;
    }

    /**
     * 18. Reverse
     * Reverse both prev and next links and update head/tail correctly.
     * Time Complexity: O(n), Space Complexity: O(1)
     */
    public void reverse() {
        if (head == null) {
            System.out.println("[INFO] List is empty. Nothing to reverse.");
            return;
        }
        if (head == tail) {
            System.out.println("[INFO] List has only one node. Reversal unchanged.");
            return;
        }

        DNode current = head;
        DNode temp = null;

        // Swap next and prev for all nodes
        while (current != null) {
            temp = current.prev;
            current.prev = current.next;
            current.next = temp;
            current = current.prev; // Move to next node in original order (which is now in current.prev)
        }

        // Before swap, head was head, tail was tail.
        // Update tail to old head, and head to temp.prev (new front)
        tail = head;
        if (temp != null) {
            head = temp.prev;
        }

        System.out.println("[SUCCESS] Doubly linked list reversed successfully.");
    }

    /**
     * 19. Sort (Ascending)
     * Bubble Sort on doubly linked list by comparing and swapping values.
     * Time Complexity: O(n^2), Space Complexity: O(1)
     */
    public void sort() {
        if (head == null) {
            System.out.println("[INFO] List is empty. Nothing to sort.");
            return;
        }
        if (head == tail) {
            System.out.println("[INFO] List has only one node. Already sorted.");
            return;
        }

        boolean swapped;
        do {
            swapped = false;
            DNode current = head;
            while (current.next != null) {
                if (current.data > current.next.data) {
                    int temp = current.data;
                    current.data = current.next.data;
                    current.next.data = temp;
                    swapped = true;
                }
                current = current.next;
            }
        } while (swapped);

        System.out.println("[SUCCESS] Doubly linked list sorted in ascending order.");
    }

    /**
     * 20. Remove Duplicates
     * Remove repeated values while maintaining correct prev/next links.
     * In-place without external collections.
     * Time Complexity: O(n^2), Space Complexity: O(1)
     */
    public void removeDuplicates() {
        if (head == null) {
            System.out.println("[INFO] List is empty. No duplicates.");
            return;
        }
        if (head == tail) {
            System.out.println("[INFO] List has only one node. No duplicates.");
            return;
        }

        int removedCount = 0;
        DNode current = head;

        while (current != null) {
            DNode runner = current.next;
            while (runner != null) {
                if (runner.data == current.data) {
                    DNode duplicate = runner;
                    runner = runner.next; // Advance before deleting duplicate

                    if (duplicate == tail) {
                        tail = duplicate.prev;
                        tail.next = null;
                    } else {
                        duplicate.prev.next = duplicate.next;
                        duplicate.next.prev = duplicate.prev;
                    }
                    removedCount++;
                } else {
                    runner = runner.next;
                }
            }
            current = current.next;
        }

        if (removedCount > 0) {
            System.out.println("[SUCCESS] Removed " + removedCount + " duplicate node(s).");
        } else {
            System.out.println("[INFO] No duplicate values found in the list.");
        }
    }
}
