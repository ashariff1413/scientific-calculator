# Building Native Executable

## Method 1: Using Launch4j (Recommended)
1. Download Launch4j: https://launch4j.sourceforge.net/
2. Install and open Launch4j
3. Configure:
   - Output file: `ScientificCalculator.exe`
   - Jar: `ScientificCalculator.jar`
   - Icon: (optional) create a .ico file
   - JRE min version: 1.8
4. Click "Build wrapper" to create .exe

## Method 2: Using jpackage (Java 14+)
```bash
jpackage --input . --name ScientificCalculator --main-jar ScientificCalculator.jar --main-class Calculator --type exe --icon calculator.ico
```

## Method 3: Using GraalVM Native Image
```bash
native-image -jar ScientificCalculator.jar ScientificCalculator
```
Creates a standalone executable with no Java dependency!

## Distribution
- Share the .exe file
- Users can run without installing Java (if bundled)
- Can create installer with Inno Setup or NSIS
