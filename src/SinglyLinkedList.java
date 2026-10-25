/**
 * SinglyLinkedList.java
 * Linked List Management System - DSA Mini Project (2nd Year College Level)
 *
 * Implements a complete Singly Linked List with all required operations:
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
 * 12. Display
 * 13. Count Nodes
 * 14. Find Maximum
 * 15. Find Minimum
 * 16. Find Middle Element (Slow/Fast Pointers)
 * 17. Reverse (Iterative 3-Pointer O(1) Space)
 * 18. Sort (Bubble Sort O(n^2))
 * 19. Remove Duplicates
 */

public class SinglyLinkedList {

    /**
     * Node inner class representing each element in the Singly Linked List.
     */
    public static class Node {
        public int data;
        public Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    // Head reference pointing to the first node in the list
    private Node head;

    /**
     * Constructor initializing an empty Singly Linked List.
     */
    public SinglyLinkedList() {
        this.head = null;
    }

    /**
     * Getter for head node (useful for external iteration if needed).
     */
    public Node getHead() {
        return head;
    }

    /**
     * Check if the list is empty.
     * Time Complexity: O(1)
     */
    public boolean isEmpty() {
        return head == null;
    }

    /**
     * 1. Insert at Beginning
     * Adds a new node before the current head.
     * Example: 10 -> 20 -> 30 becomes 5 -> 10 -> 20 -> 30.
     * Time Complexity: O(1)
     */
    public void insertAtBeginning(int data) {
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
        System.out.println("[SUCCESS] Inserted " + data + " at the beginning.");
    }

    /**
     * 2. Insert at End
     * Traverses to the last node and attaches the new node.
     * Time Complexity: O(n) without a tail reference.
     */
    public void insertAtEnd(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            System.out.println("[SUCCESS] Inserted " + data + " as the first node in the list.");
            return;
        }
        Node current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = newNode;
        System.out.println("[SUCCESS] Inserted " + data + " at the end.");
    }

    /**
     * 3. Insert at Position
     * Inserts data at a 1-based position.
     * Handles position 1, middle, last-valid position, and invalid positions.
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

        Node newNode = new Node(data);
        Node current = head;
        // Traverse to node at (position - 1)
        for (int i = 1; i < position - 1; i++) {
            current = current.next;
        }
        newNode.next = current.next;
        current.next = newNode;
        System.out.println("[SUCCESS] Inserted " + data + " at position " + position + ".");
        return true;
    }

    /**
     * 4. Insert After a Node
     * Finds the first matching value and inserts the new node immediately after it.
     * Time Complexity: O(n)
     */
    public boolean insertAfterNode(int targetValue, int data) {
        if (head == null) {
            System.out.println("[ERROR] List is empty. Cannot insert after target.");
            return false;
        }

        Node current = head;
        while (current != null && current.data != targetValue) {
            current = current.next;
        }

        if (current == null) {
            System.out.println("[ERROR] Target value " + targetValue + " not found in the list.");
            return false;
        }

        Node newNode = new Node(data);
        newNode.next = current.next;
        current.next = newNode;
        System.out.println("[SUCCESS] Inserted " + data + " immediately after node with value " + targetValue + ".");
        return true;
    }

    /**
     * 5. Insert Before a Node
     * Finds the first matching value and inserts the new node immediately before it.
     * Time Complexity: O(n)
     */
    public boolean insertBeforeNode(int targetValue, int data) {
        if (head == null) {
            System.out.println("[ERROR] List is empty. Cannot insert before target.");
            return false;
        }

        // If target is head node
        if (head.data == targetValue) {
            insertAtBeginning(data);
            return true;
        }

        Node current = head;
        while (current.next != null && current.next.data != targetValue) {
            current = current.next;
        }

        if (current.next == null) {
            System.out.println("[ERROR] Target value " + targetValue + " not found in the list.");
            return false;
        }

        Node newNode = new Node(data);
        newNode.next = current.next;
        current.next = newNode;
        System.out.println("[SUCCESS] Inserted " + data + " immediately before node with value " + targetValue + ".");
        return true;
    }

    /**
     * 6. Delete from Beginning
     * Removes head node and moves head to head.next.
     * Time Complexity: O(1)
     */
    public Integer deleteFromBeginning() {
        if (head == null) {
            System.out.println("[ERROR] List is empty. Underflow condition!");
            return null;
        }

        int deletedValue = head.data;
        head = head.next;
        System.out.println("[SUCCESS] Deleted " + deletedValue + " from the beginning.");
        return deletedValue;
    }

    /**
     * 7. Delete from End
     * Removes the last node and updates the previous node's next pointer.
     * Time Complexity: O(n)
     */
    public Integer deleteFromEnd() {
        if (head == null) {
            System.out.println("[ERROR] List is empty. Underflow condition!");
            return null;
        }

        // Single node case
        if (head.next == null) {
            int deletedValue = head.data;
            head = null;
            System.out.println("[SUCCESS] Deleted " + deletedValue + " from the end (List is now empty).");
            return deletedValue;
        }

        Node current = head;
        while (current.next.next != null) {
            current = current.next;
        }

        int deletedValue = current.next.data;
        current.next = null;
        System.out.println("[SUCCESS] Deleted " + deletedValue + " from the end.");
        return deletedValue;
    }

    /**
     * 8. Delete from Position
     * Deletes the node at a given 1-based position and preserves links.
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

        Node current = head;
        for (int i = 1; i < position - 1; i++) {
            current = current.next;
        }

        Node nodeToDelete = current.next;
        int deletedValue = nodeToDelete.data;
        current.next = nodeToDelete.next;
        System.out.println("[SUCCESS] Deleted " + deletedValue + " from position " + position + ".");
        return deletedValue;
    }

    /**
     * 9. Delete by Value
     * Deletes the first node containing the target value. Reports when not found.
     * Time Complexity: O(n)
     */
    public boolean deleteByValue(int targetValue) {
        if (head == null) {
            System.out.println("[ERROR] List is empty. Cannot delete value.");
            return false;
        }

        if (head.data == targetValue) {
            deleteFromBeginning();
            return true;
        }

        Node current = head;
        while (current.next != null && current.next.data != targetValue) {
            current = current.next;
        }

        if (current.next == null) {
            System.out.println("[ERROR] Value " + targetValue + " not found in the list.");
            return false;
        }

        int deletedValue = current.next.data;
        current.next = current.next.next;
        System.out.println("[SUCCESS] Deleted node with value " + deletedValue + ".");
        return true;
    }

    /**
     * 10. Search
     * Searches for a value and returns its 1-based position if found, or -1 if not found.
     * Time Complexity: O(n)
     */
    public int search(int targetValue) {
        if (head == null) {
            System.out.println("[INFO] List is empty.");
            return -1;
        }

        Node current = head;
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
     * Finds the first node with oldValue and replaces its data with newValue.
     * Time Complexity: O(n)
     */
    public boolean update(int oldValue, int newValue) {
        if (head == null) {
            System.out.println("[ERROR] List is empty. Cannot update.");
            return false;
        }

        Node current = head;
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
     * 12. Display
     * Traverses from head to NULL and prints the linked list.
     * Format matches specification: 40 -> 10 -> 30 -> 20 -> 50 -> NULL
     * Time Complexity: O(n)
     */
    public void display() {
        if (head == null) {
            System.out.println("[LIST] Empty list (NULL)");
            return;
        }

        StringBuilder sb = new StringBuilder();
        Node current = head;
        while (current != null) {
            sb.append(current.data).append(" -> ");
            current = current.next;
        }
        sb.append("NULL");
        System.out.println("[LIST] " + sb.toString());
    }

    /**
     * 13. Count Nodes
     * Traverses and counts all nodes in the list.
     * Time Complexity: O(n)
     */
    public int countNodes() {
        int count = 0;
        Node current = head;
        while (current != null) {
            count++;
            current = current.next;
        }
        return count;
    }

    /**
     * 14. Find Maximum
     * Traverses and returns the largest value in the list.
     * Time Complexity: O(n)
     */
    public Integer findMaximum() {
        if (head == null) {
            System.out.println("[ERROR] List is empty. No maximum element.");
            return null;
        }

        int max = head.data;
        Node current = head.next;
        while (current != null) {
            if (current.data > max) {
                max = current.data;
            }
            current = current.next;
        }
        System.out.println("[MAXIMUM] Maximum value in list is: " + max);
        return max;
    }

    /**
     * 15. Find Minimum
     * Traverses and returns the smallest value in the list.
     * Time Complexity: O(n)
     */
    public Integer findMinimum() {
        if (head == null) {
            System.out.println("[ERROR] List is empty. No minimum element.");
            return null;
        }

        int min = head.data;
        Node current = head.next;
        while (current != null) {
            if (current.data < min) {
                min = current.data;
            }
            current = current.next;
        }
        System.out.println("[MINIMUM] Minimum value in list is: " + min);
        return min;
    }

    /**
     * 16. Find Middle Element
     * Uses slow/fast pointer (Floyd's Tortoise and Hare algorithm).
     * Even-length rule: Slow pointer lands on the second middle node (standard n/2 + 1).
     * Time Complexity: O(n), Space Complexity: O(1)
     */
    public Integer findMiddleElement() {
        if (head == null) {
            System.out.println("[ERROR] List is empty. No middle element.");
            return null;
        }

        Node slow = head;
        Node fast = head;
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
     * 17. Reverse
     * Reverses next links using previous, current, and next pointers.
     * In-place reversal.
     * Time Complexity: O(n), Space Complexity: O(1)
     */
    public void reverse() {
        if (head == null) {
            System.out.println("[INFO] List is empty. Nothing to reverse.");
            return;
        }
        if (head.next == null) {
            System.out.println("[INFO] List has only one node. Reversal unchanged.");
            return;
        }

        Node prev = null;
        Node current = head;
        Node next = null;

        while (current != null) {
            next = current.next; // Store next node
            current.next = prev; // Reverse current node's pointer
            prev = current;      // Move prev one step forward
            current = next;      // Move current one step forward
        }
        head = prev; // Reset head to new front
        System.out.println("[SUCCESS] Linked list reversed successfully.");
    }

    /**
     * 18. Sort (Ascending)
     * Bubble Sort on linked list by comparing and swapping node values.
     * Handles empty and single-node list edge cases.
     * Time Complexity: O(n^2), Space Complexity: O(1)
     */
    public void sort() {
        if (head == null) {
            System.out.println("[INFO] List is empty. Nothing to sort.");
            return;
        }
        if (head.next == null) {
            System.out.println("[INFO] List has only one node. Already sorted.");
            return;
        }

        boolean swapped;
        do {
            swapped = false;
            Node current = head;
            while (current.next != null) {
                if (current.data > current.next.data) {
                    // Swap values
                    int temp = current.data;
                    current.data = current.next.data;
                    current.next.data = temp;
                    swapped = true;
                }
                current = current.next;
            }
        } while (swapped);

        System.out.println("[SUCCESS] List sorted in ascending order.");
    }

    /**
     * 19. Remove Duplicates
     * Removes repeated values while maintaining valid links in-place without external collections.
     * Works for both sorted and unsorted lists.
     * Time Complexity: O(n^2), Space Complexity: O(1)
     */
    public void removeDuplicates() {
        if (head == null) {
            System.out.println("[INFO] List is empty. No duplicates.");
            return;
        }
        if (head.next == null) {
            System.out.println("[INFO] List has only one node. No duplicates.");
            return;
        }

        int removedCount = 0;
        Node current = head;

        while (current != null) {
            Node runner = current;
            while (runner.next != null) {
                if (runner.next.data == current.data) {
                    // Duplicate found, bypass runner.next
                    runner.next = runner.next.next;
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
