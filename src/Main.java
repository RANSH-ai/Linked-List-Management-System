/**
 * Main.java
 * Linked List Management System - DSA Mini Project (2nd Year College Level)
 *
 * Menu-driven console application managing Singly and Doubly Linked Lists
 * with full operation support, edge case handling, and comparison module.
 */

import java.util.Scanner;
import java.util.InputMismatchException;

public class Main {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        SinglyLinkedList sll = new SinglyLinkedList();
        DoublyLinkedList dll = new DoublyLinkedList();

        boolean running = true;
        while (running) {
            printMainMenu();
            int choice = readInt("Enter your choice: ");

            switch (choice) {
                case 1:
                    handleSinglyLinkedListMenu(sll);
                    break;
                case 2:
                    handleDoublyLinkedListMenu(dll);
                    break;
                case 3:
                    displayComparison();
                    break;
                case 4:
                    System.out.println("\nExiting Linked List Management System. Thank you!");
                    running = false;
                    break;
                default:
                    System.out.println("[ERROR] Invalid choice! Please select between 1 and 4.\n");
            }
        }
        scanner.close();
    }

    /**
     * Display Main Menu matching project specification.
     */
    private static void printMainMenu() {
        System.out.println("\n==================================================");
        System.out.println("          LINKED LIST MANAGEMENT SYSTEM           ");
        System.out.println("==================================================");
        System.out.println("1. Singly Linked List");
        System.out.println("2. Doubly Linked List");
        System.out.println("3. Compare Singly vs Doubly Linked List");
        System.out.println("4. Exit");
    }

    /**
     * Handle Singly Linked List sub-menu operations.
     */
    private static void handleSinglyLinkedListMenu(SinglyLinkedList sll) {
        boolean back = false;
        while (!back) {
            System.out.println("\n********** Operation on Singly Linked List **********");
            System.out.println("1. Insert at Beginning");
            System.out.println("2. Insert at End");
            System.out.println("3. Insert at Position");
            System.out.println("4. Insert After a Node");
            System.out.println("5. Insert Before a Node");
            System.out.println("6. Delete from Beginning");
            System.out.println("7. Delete from End");
            System.out.println("8. Delete from Position");
            System.out.println("9. Delete by Value");
            System.out.println("10. Search");
            System.out.println("11. Update");
            System.out.println("12. Display");
            System.out.println("13. Count Nodes");
            System.out.println("14. Find Maximum");
            System.out.println("15. Find Minimum");
            System.out.println("16. Find Middle Element");
            System.out.println("17. Reverse");
            System.out.println("18. Sort");
            System.out.println("19. Remove Duplicates");
            System.out.println("20. Exit");

            int choice = readInt("Enter the choice:- ");

            switch (choice) {
                case 1: {
                    int val = readInt("Enter value to insert at beginning: ");
                    sll.insertAtBeginning(val);
                    sll.display();
                    break;
                }
                case 2: {
                    int val = readInt("Enter value to insert at end: ");
                    sll.insertAtEnd(val);
                    sll.display();
                    break;
                }
                case 3: {
                    int val = readInt("Enter value to insert: ");
                    int pos = readInt("Enter 1-based position: ");
                    sll.insertAtPosition(val, pos);
                    sll.display();
                    break;
                }
                case 4: {
                    int target = readInt("Enter target node value: ");
                    int val = readInt("Enter new value to insert after target: ");
                    sll.insertAfterNode(target, val);
                    sll.display();
                    break;
                }
                case 5: {
                    int target = readInt("Enter target node value: ");
                    int val = readInt("Enter new value to insert before target: ");
                    sll.insertBeforeNode(target, val);
                    sll.display();
                    break;
                }
                case 6: {
                    sll.deleteFromBeginning();
                    sll.display();
                    break;
                }
                case 7: {
                    sll.deleteFromEnd();
                    sll.display();
                    break;
                }
                case 8: {
                    int pos = readInt("Enter 1-based position to delete: ");
                    sll.deleteFromPosition(pos);
                    sll.display();
                    break;
                }
                case 9: {
                    int val = readInt("Enter value to delete: ");
                    sll.deleteByValue(val);
                    sll.display();
                    break;
                }
                case 10: {
                    int val = readInt("Enter value to search: ");
                    sll.search(val);
                    break;
                }
                case 11: {
                    int oldVal = readInt("Enter existing value to update: ");
                    int newVal = readInt("Enter new value: ");
                    sll.update(oldVal, newVal);
                    sll.display();
                    break;
                }
                case 12: {
                    sll.display();
                    break;
                }
                case 13: {
                    int count = sll.countNodes();
                    System.out.println("[COUNT] Total nodes in Singly Linked List: " + count);
                    break;
                }
                case 14: {
                    sll.findMaximum();
                    break;
                }
                case 15: {
                    sll.findMinimum();
                    break;
                }
                case 16: {
                    sll.findMiddleElement();
                    break;
                }
                case 17: {
                    sll.reverse();
                    sll.display();
                    break;
                }
                case 18: {
                    sll.sort();
                    sll.display();
                    break;
                }
                case 19: {
                    sll.removeDuplicates();
                    sll.display();
                    break;
                }
                case 20: {
                    System.out.println("Returning to Main Menu...");
                    back = true;
                    break;
                }
                default:
                    System.out.println("[ERROR] Invalid option! Please enter a choice between 1 and 20.");
            }
        }
    }

    /**
     * Handle Doubly Linked List sub-menu operations.
     */
    private static void handleDoublyLinkedListMenu(DoublyLinkedList dll) {
        boolean back = false;
        while (!back) {
            System.out.println("\n********** Operation on Doubly Linked List **********");
            System.out.println("1. Insert at Beginning");
            System.out.println("2. Insert at End");
            System.out.println("3. Insert at Position");
            System.out.println("4. Insert After a Node");
            System.out.println("5. Insert Before a Node");
            System.out.println("6. Delete from Beginning");
            System.out.println("7. Delete from End");
            System.out.println("8. Delete from Position");
            System.out.println("9. Delete by Value");
            System.out.println("10. Search");
            System.out.println("11. Update");
            System.out.println("12. Display Forward");
            System.out.println("13. Display Backward");
            System.out.println("14. Count Nodes");
            System.out.println("15. Find Maximum");
            System.out.println("16. Find Minimum");
            System.out.println("17. Find Middle Element");
            System.out.println("18. Reverse");
            System.out.println("19. Sort");
            System.out.println("20. Remove Duplicates");
            System.out.println("21. Exit");

            int choice = readInt("Enter the choice:- ");

            switch (choice) {
                case 1: {
                    int val = readInt("Enter value to insert at beginning: ");
                    dll.insertAtBeginning(val);
                    dll.displayForward();
                    break;
                }
                case 2: {
                    int val = readInt("Enter value to insert at end: ");
                    dll.insertAtEnd(val);
                    dll.displayForward();
                    break;
                }
                case 3: {
                    int val = readInt("Enter value to insert: ");
                    int pos = readInt("Enter 1-based position: ");
                    dll.insertAtPosition(val, pos);
                    dll.displayForward();
                    break;
                }
                case 4: {
                    int target = readInt("Enter target node value: ");
                    int val = readInt("Enter new value to insert after target: ");
                    dll.insertAfterNode(target, val);
                    dll.displayForward();
                    break;
                }
                case 5: {
                    int target = readInt("Enter target node value: ");
                    int val = readInt("Enter new value to insert before target: ");
                    dll.insertBeforeNode(target, val);
                    dll.displayForward();
                    break;
                }
                case 6: {
                    dll.deleteFromBeginning();
                    dll.displayForward();
                    break;
                }
                case 7: {
                    dll.deleteFromEnd();
                    dll.displayForward();
                    break;
                }
                case 8: {
                    int pos = readInt("Enter 1-based position to delete: ");
                    dll.deleteFromPosition(pos);
                    dll.displayForward();
                    break;
                }
                case 9: {
                    int val = readInt("Enter value to delete: ");
                    dll.deleteByValue(val);
                    dll.displayForward();
                    break;
                }
                case 10: {
                    int val = readInt("Enter value to search: ");
                    dll.search(val);
                    break;
                }
                case 11: {
                    int oldVal = readInt("Enter existing value to update: ");
                    int newVal = readInt("Enter new value: ");
                    dll.update(oldVal, newVal);
                    dll.displayForward();
                    break;
                }
                case 12: {
                    dll.displayForward();
                    break;
                }
                case 13: {
                    dll.displayBackward();
                    break;
                }
                case 14: {
                    int count = dll.countNodes();
                    System.out.println("[COUNT] Total nodes in Doubly Linked List: " + count);
                    break;
                }
                case 15: {
                    dll.findMaximum();
                    break;
                }
                case 16: {
                    dll.findMinimum();
                    break;
                }
                case 17: {
                    dll.findMiddleElement();
                    break;
                }
                case 18: {
                    dll.reverse();
                    dll.displayForward();
                    break;
                }
                case 19: {
                    dll.sort();
                    dll.displayForward();
                    break;
                }
                case 20: {
                    dll.removeDuplicates();
                    dll.displayForward();
                    break;
                }
                case 21: {
                    System.out.println("Returning to Main Menu...");
                    back = true;
                    break;
                }
                default:
                    System.out.println("[ERROR] Invalid option! Please enter a choice between 1 and 21.");
            }
        }
    }

    /**
     * Display a comprehensive comparison table between Singly and Doubly Linked Lists.
     */
    private static void displayComparison() {
        System.out.println("\n" + "=".repeat(75));
        System.out.println("           COMPREHENSIVE COMPARISON: SINGLY VS DOUBLY LINKED LIST");
        System.out.println("=".repeat(75));

        System.out.printf("%-24s | %-23s | %-23s%n", "CRITERIA / PROPERTY", "SINGLY LINKED LIST (SLL)", "DOUBLY LINKED LIST (DLL)");
        System.out.println("-".repeat(75));

        System.out.printf("%-24s | %-23s | %-23s%n", "Node Structure", "Data + Next reference", "Data + Prev + Next references");
        System.out.printf("%-24s | %-23s | %-23s%n", "References per Node", "1 pointer (next)", "2 pointers (prev, next)");
        System.out.printf("%-24s | %-23s | %-23s%n", "Memory Overhead", "Lesser (saves pointer space)", "Higher (~33%-50% more memory)");
        System.out.printf("%-24s | %-23s | %-23s%n", "Traversal Direction", "Forward only (unidirectional)", "Bidirectional (forward & back)");
        System.out.printf("%-24s | %-23s | %-23s%n", "Insert at Head", "O(1)", "O(1)");
        System.out.printf("%-24s | %-23s | %-23s%n", "Insert at Tail", "O(n) [O(1) with tail ref]", "O(1) with tail reference");
        System.out.printf("%-24s | %-23s | %-23s%n", "Delete Head", "O(1)", "O(1)");
        System.out.printf("%-24s | %-23s | %-23s%n", "Delete Tail", "O(n) (needs predecessor)", "O(1) with tail reference");
        System.out.printf("%-24s | %-23s | %-23s%n", "Delete Given Node Ref", "O(n) without prev node", "O(1) directly via prev/next");
        System.out.printf("%-24s | %-23s | %-23s%n", "Insert Before Given Node", "O(n) without prev pointer", "O(1) using prev link");
        System.out.printf("%-24s | %-23s | %-23s%n", "Reverse List", "O(n) time, O(1) space", "O(n) time, swap prev/next");
        System.out.printf("%-24s | %-23s | %-23s%n", "Implementation Effort", "Simpler, fewer pointer bugs", "More complex, double links");
        System.out.printf("%-24s | %-23s | %-23s%n", "Real-World Use Cases", "Hash table chaining, Queues", "Browser history, LRU Cache");

        System.out.println("=".repeat(75));
        System.out.println("Key Takeaway:");
        System.out.println("• Use Singly Linked List when memory conservation is prioritized and backward");
        System.out.println("  traversal is never required.");
        System.out.println("• Use Doubly Linked List when frequent deletions of known nodes or two-way");
        System.out.println("  traversal (e.g. undo/redo, browser navigation) are needed.");
        System.out.println("=".repeat(75));

        System.out.print("\nPress Enter to return to Main Menu...");
        scanner.nextLine();
    }

    /**
     * Helper to read integer inputs safely without throwing unhandled exceptions.
     */
    private static int readInt(String prompt) {
        while (true) {
            System.out.print(prompt);
            try {
                String line = scanner.nextLine().trim();
                return Integer.parseInt(line);
            } catch (NumberFormatException e) {
                System.out.println("[ERROR] Invalid number format! Please enter a valid integer.");
            }
        }
    }
}
