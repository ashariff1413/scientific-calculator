@echo off
title Scientific Calculator
echo Starting Scientific Calculator...
java -jar ScientificCalculator.jar
if errorlevel 1 (
    echo.
    echo ERROR: Java is not installed or not in PATH
    echo Please install Java from: https://www.java.com/download/
    pause
)
