@echo off
REM ================================================================
REM Linked List Management System - Runner Script (Windows)
REM ================================================================

echo [INFO] Compiling Java source files...
if not exist "bin" mkdir bin
javac -d bin src\SinglyLinkedList.java src\DoublyLinkedList.java src\Main.java

if %ERRORLEVEL% NEQ 0 (
    echo [ERROR] Compilation failed!
    pause
    exit /b %ERRORLEVEL%
)

echo [SUCCESS] Compilation successful!
echo [INFO] Launching Linked List Management System...
echo ================================================================
java -cp bin Main
pause
