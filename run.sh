#!/usr/bin/env bash
# ================================================================
# Linked List Management System - Runner Script (Linux/macOS/Git Bash)
# ================================================================

echo "[INFO] Compiling Java source files..."
mkdir -p bin
javac -d bin src/SinglyLinkedList.java src/DoublyLinkedList.java src/Main.java

if [ $? -ne 0 ]; then
    echo "[ERROR] Compilation failed!"
    exit 1
fi

echo "[SUCCESS] Compilation successful!"
echo "[INFO] Launching Linked List Management System..."
echo "================================================================"
java -cp bin Main
