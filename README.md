# Linked List Management System

![Java](https://img.shields.io/badge/Language-Java-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)
![DSA](https://img.shields.io/badge/Subject-Data%20Structures%20%26%20Algorithms-blue?style=for-the-badge)
![Academic Level](https://img.shields.io/badge/Level-2nd%20Year%20College%20Mini%20Project-green?style=for-the-badge)
![License](https://img.shields.io/badge/License-MIT-purple?style=for-the-badge)

A modular, menu-driven console application engineered for practicing and mastering fundamental dynamic data structures—specifically **Singly Linked Lists (SLL)** and **Doubly Linked Lists (DLL)**. Developed as a 2nd Year College DSA Mini Project.

---

## Table of Contents
1. [Objective](#objective)
2. [Language Used](#language-used)
3. [Repository Structure](#repository-structure)
4. [Features](#features)
   - [Singly Linked List](#singly-linked-list)
   - [Doubly Linked List](#doubly-linked-list)
   - [Comparison Module](#comparison-module)
5. [Operations Supported](#operations)
6. [How to Run](#how-to-run)
7. [Sample Output](#sample-output)
8. [Time & Space Complexity](#time-complexity)
9. [Edge Cases Handled](#edge-cases-handled)
10. [Viva / Evaluation Questions](#viva--evaluation-questions)
11. [Author](#author)

---

## Objective

The objective of this project is to implement pure, pointer/reference-based Linked List data structures from the ground up in **Java** without utilizing standard library collections (such as `java.util.LinkedList`). The project emphasizes:
- Dynamic memory management on the heap using object references.
- Complete CRUD operations (Insertion, Deletion, Search, Update, Traversal).
- Two-pointer algorithms (Floyd's Tortoise and Hare for finding the middle element).
- In-place reversal with $O(1)$ auxiliary space.
- Sorting (Bubble Sort) and duplicate removal.
- Robust exception handling and edge-case validation.

---

## Language Used

- **Language:** Java (JDK 8 or higher)
- **Paradigm:** Object-Oriented Programming (OOP)
- **Memory Handling:** Object references with JVM Automatic Garbage Collection
- **Input / Output:** `java.util.Scanner` with input sanitization and `System.out`

---

## Repository Structure

```
Linked-List-Management-System/
│
├── README.md                     # Comprehensive project documentation
├── .gitignore                    # Git ignore file for compiled bytecode and IDE configs
├── run.bat                       # One-click Windows runner script
├── run.sh                        # Linux / macOS / Git Bash runner script
│
├── src/                          # Source code directory
│   ├── SinglyLinkedList.java     # Complete Singly Linked List class
│   ├── DoublyLinkedList.java     # Complete Doubly Linked List class
│   └── Main.java                 # Interactive menu-driven console interface
│
├── sample-output/                # Test execution output logs
│   └── output.txt                # Full text log of all operations & edge case tests
│
└── docs/                         # Detailed academic documentation
    └── project-report.md         # Comprehensive project report & 15 Viva answers
```

---

## Features

### Singly Linked List
- Unidirectional node architecture (`data` and `next` reference).
- All standard and boundary insertions/deletions.
- Fast/Slow pointer middle finding algorithm.
- Iterative 3-pointer in-place reversal ($O(n)$ time, $O(1)$ auxiliary space).
- In-place ascending Bubble Sort and duplicate elimination.

### Doubly Linked List
- Bidirectional node architecture (`prev`, `data`, and `next` references).
- Dual `head` and `tail` pointers for $O(1)$ operations at both ends.
- Forward traversal (`head` $\to$ `tail`) and Backward traversal (`tail` $\to$ `head`).
- In-place reversal via pairwise pointer swapping.
- Ascending sort and duplicate elimination maintaining bidirectional pointer integrity.

### Comparison Module
An interactive analytical tool accessible from the main menu comparing Singly and Doubly Linked Lists side-by-side across:
- Memory overhead per node
- Traversal capabilities
- Time complexities for key operations
- Real-world software engineering applications

---

## Operations

| # | Singly Linked List Operations | Doubly Linked List Operations |
|---|-------------------------------|-------------------------------|
| 1 | Insert at Beginning           | Insert at Beginning           |
| 2 | Insert at End                 | Insert at End                 |
| 3 | Insert at Position (1-based)  | Insert at Position (1-based)  |
| 4 | Insert After a Node           | Insert After a Node           |
| 5 | Insert Before a Node          | Insert Before a Node          |
| 6 | Delete from Beginning         | Delete from Beginning         |
| 7 | Delete from End               | Delete from End               |
| 8 | Delete from Position          | Delete from Position          |
| 9 | Delete by Value               | Delete by Value               |
| 10| Search Value (1-based index)  | Search Value (1-based index)  |
| 11| Update Node Value             | Update Node Value             |
| 12| Display List                  | Display Forward               |
| 13| Count Nodes                   | Display Backward              |
| 14| Find Maximum Value            | Count Nodes                   |
| 15| Find Minimum Value            | Find Maximum Value            |
| 16| Find Middle Element           | Find Minimum Value            |
| 17| Reverse List                  | Find Middle Element           |
| 18| Sort Ascending                | Reverse List                  |
| 19| Remove Duplicates             | Sort Ascending                |
| 20| Exit to Main Menu             | Remove Duplicates             |
| 21| -                             | Exit to Main Menu             |

---

## How to Run

### Prerequisites
- Java Development Kit (JDK 8 or later) installed.
- Verify installation by running:
  ```bash
  javac -version
  java -version
  ```

### Quick Run (Windows)
Double-click `run.bat` or execute in Command Prompt:
```cmd
.\run.bat
```

### Quick Run (Linux / macOS / Git Bash)
```bash
chmod +x run.sh
./run.sh
```

### Manual Compilation and Execution
From the project root directory:

1. **Compile all Java source files:**
   ```bash
   javac -d bin src/*.java
   ```

2. **Run the application:**
   ```bash
   java -cp bin Main
   ```

---

## Sample Output

### 1. Singly Linked List Demonstration
```text
********** Operation on Singly Linked List **********
Before:
[LIST] 40 -> 10 -> 30 -> 20 -> 50 -> NULL

After Sort:
[SUCCESS] List sorted in ascending order.
[LIST] 10 -> 20 -> 30 -> 40 -> 50 -> NULL

After Reverse:
[SUCCESS] Linked list reversed successfully.
[LIST] 50 -> 40 -> 30 -> 20 -> 10 -> NULL

Find Middle:
[MIDDLE] Middle Element is 30 at position 3.
```

### 2. Doubly Linked List Demonstration
```text
********** Operation on Doubly Linked List **********
[FORWARD]  NULL <- 10 <-> 20 <-> 30 <-> 40 -> NULL
[BACKWARD] NULL <- 40 <-> 30 <-> 20 <-> 10 -> NULL
```

### 3. Comparison Table (Main Menu Option 3)
```text
===========================================================================
           COMPREHENSIVE COMPARISON: SINGLY VS DOUBLY LINKED LIST
===========================================================================
CRITERIA / PROPERTY      | SINGLY LINKED LIST (SLL) | DOUBLY LINKED LIST (DLL)
---------------------------------------------------------------------------
Node Structure           | Data + Next reference   | Data + Prev + Next refs 
References per Node      | 1 pointer (next)        | 2 pointers (prev, next) 
Memory Overhead          | Lesser (saves pointer)  | Higher (~33%-50% more)  
Traversal Direction      | Forward only            | Bidirectional           
Insert at Head           | O(1)                    | O(1)                    
Insert at Tail           | O(n)                    | O(1) with tail ref      
Delete Head              | O(1)                    | O(1)                    
Delete Tail              | O(n)                    | O(1) with tail ref      
Delete Given Node Ref    | O(n)                    | O(1)                    
Insert Before Given Node | O(n)                    | O(1)                    
Reverse List             | O(n) time, O(1) space   | O(n) time, swap pointers
Real-World Use Cases     | Hash chaining, Queues   | Browser history, Cache  
===========================================================================
```

*See [sample-output/output.txt](sample-output/output.txt) for the full interactive session log.*

---

## Time Complexity

| Operation | Singly Linked List (SLL) | Doubly Linked List (DLL) | Space Complexity |
| :--- | :--- | :--- | :--- |
| **Insert at Beginning** | $O(1)$ | $O(1)$ | $O(1)$ |
| **Insert at End** | $O(n)$ | $O(1)$ (with tail pointer) | $O(1)$ |
| **Insert at Position** | $O(n)$ | $O(n)$ | $O(1)$ |
| **Insert After Node** | $O(n)$ | $O(n)$ | $O(1)$ |
| **Insert Before Node** | $O(n)$ | $O(n)$ | $O(1)$ |
| **Delete from Beginning** | $O(1)$ | $O(1)$ | $O(1)$ |
| **Delete from End** | $O(n)$ | $O(1)$ (with tail pointer) | $O(1)$ |
| **Delete from Position** | $O(n)$ | $O(n)$ | $O(1)$ |
| **Delete by Value** | $O(n)$ | $O(n)$ | $O(1)$ |
| **Search** | $O(n)$ | $O(n)$ | $O(1)$ |
| **Update** | $O(n)$ | $O(n)$ | $O(1)$ |
| **Display (Forward/Backward)**| $O(n)$ | $O(n)$ | $O(1)$ |
| **Count Nodes** | $O(n)$ | $O(n)$ | $O(1)$ |
| **Find Min / Max** | $O(n)$ | $O(n)$ | $O(1)$ |
| **Find Middle Element** | $O(n)$ | $O(n)$ | $O(1)$ |
| **Reverse** | $O(n)$ | $O(n)$ | $O(1)$ |
| **Bubble Sort** | $O(n^2)$ | $O(n^2)$ | $O(1)$ |
| **Remove Duplicates** | $O(n^2)$ | $O(n^2)$ | $O(1)$ |

---

## Edge Cases Handled

- **Empty Linked List:** Gracefully handles all operations without `NullPointerException`.
- **Single-Node List:** Correctly manages boundary updates where `head == tail`.
- **Head & Tail Boundary Operations:** Accurately re-links head, tail, and adjacent nodes.
- **Out-of-Range Positions:** Bounds-checked with clear descriptive error messages.
- **Non-Existent Target Values:** Reports clean failure when search, update, or deletion targets are missing.
- **Duplicate Elements:** In-place deduplication without extra memory overhead.
- **Negative & Zero Values:** Handled seamlessly across comparisons and sorting.
- **Input Sanitization:** Resilient against non-integer inputs without terminating the application.

---

## Viva / Evaluation Questions

Comprehensive, detailed answers to all 15 viva questions from the evaluation rubric are provided in [docs/project-report.md](docs/project-report.md#6-comprehensive-viva--evaluation-qa-guide):
1. What is a linked list?
2. What is the difference between an array and a linked list?
3. What is the purpose of head?
4. What is the purpose of next?
5. Why does a doubly linked list need prev and next?
6. Why is insertion at the beginning O(1)?
7. Why is searching O(n)?
8. How do you reverse a singly linked list?
9. How do slow and fast pointers find the middle?
10. How do you safely delete a node?
11. What changes when implementing the project in Java instead of C++?
12. Why does Java not require explicit delete?
13. Why is Bubble Sort O(n^2)?
14. How can Merge Sort be used for linked lists?
15. What edge cases must be handled?

---

## Author

- **Student:** 2nd Year Computer Science & Engineering
- **Course:** Data Structures & Algorithms (DSA) Mini Project
- **Project Title:** Linked List Management System
