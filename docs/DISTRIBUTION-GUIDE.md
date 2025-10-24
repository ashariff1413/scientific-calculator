# Scientific Calculator - Distribution Guide

## ✅ Your App is Ready!

### Files Created:
- **ScientificCalculator.jar** - The executable application
- **run-calculator.bat** - Windows launcher (double-click to run)

---

## 📦 Distribution Options

### Option 1: Share JAR File (Simplest)
**What to share:**
- `ScientificCalculator.jar`
- `run-calculator.bat` (optional, for easier launching)
- `README.md` (instructions)

**Requirements:**
- Users need Java 8+ installed
- Works on Windows, Mac, Linux

**How users run it:**
- **Windows**: Double-click `run-calculator.bat` OR `ScientificCalculator.jar`
- **Mac/Linux**: `java -jar ScientificCalculator.jar`

---

### Option 2: Create Windows Installer (.exe)

#### Using Launch4j (Recommended):
1. Download: https://launch4j.sourceforge.net/
2. Configure:
   ```
   Output file: ScientificCalculator.exe
   Jar: ScientificCalculator.jar
   Min JRE version: 1.8.0
   ```
3. Build wrapper
4. Share the .exe file

#### Using jpackage (Java 14+):
```bash
jpackage --input . \
  --name "Scientific Calculator" \
  --main-jar ScientificCalculator.jar \
  --main-class Calculator \
  --type exe \
  --win-shortcut \
  --win-menu
```

Creates a full installer with:
- Desktop shortcut
- Start menu entry
- Bundled Java runtime (no Java install needed!)

---

### Option 3: Publish on GitHub

1. Create GitHub repository
2. Upload files:
   - All `.java` source files
   - `ScientificCalculator.jar`
   - `README.md`
   - `build-jar.bat`
3. Create a Release:
   - Go to "Releases" → "Create new release"
   - Upload `ScientificCalculator.jar`
   - Add release notes
4. Users can download from Releases page

**Example README for GitHub:**
```markdown
# Scientific Calculator

Download the latest version: [ScientificCalculator.jar](releases/latest)

## How to Run
1. Make sure Java 8+ is installed
2. Double-click `ScientificCalculator.jar`
3. Or run: `java -jar ScientificCalculator.jar`

## Features
- Modern dark theme UI
- Trigonometric functions (sin, cos, tan, sec, csc, cot)
- Complex numbers support
- Calculus operations (derivative, integral, limit)
- System of equations solver (2x2, 3x3)
- Polynomial root finder
- And much more!
```

---

### Option 4: Microsoft Store (Advanced)

1. Convert to MSIX package using Desktop Bridge
2. Submit to Microsoft Store
3. Users can install from Store

**Tools:**
- MSIX Packaging Tool
- Visual Studio

---

### Option 5: Web Version (For Netlify/GitHub Pages)

To host on Netlify, you'd need to convert to HTML/CSS/JavaScript.

**I can help you create a web version with:**
- Same features
- Same modern UI
- Runs in browser
- No installation needed

Would you like me to create the web version?

---

## 🎯 Recommended Approach

**For quick sharing:**
→ Share `ScientificCalculator.jar` + `README.md`

**For professional distribution:**
→ Use jpackage to create installer with bundled Java

**For web hosting:**
→ Convert to HTML/CSS/JavaScript (I can help!)

---

## 📱 Mobile App Options

### Android:
- Use Android Studio to convert Swing UI to Android layouts
- Or use Flutter/React Native with Java backend

### iOS:
- Rewrite in Swift/SwiftUI
- Or use Flutter/React Native

---

## Current Status: ✅ Desktop App Ready!

Your calculator is fully functional as a desktop application.
Users can run it on any computer with Java installed.

**Next steps:**
1. Test the JAR file on different computers
2. Choose distribution method
3. Create installer (optional)
4. Publish on GitHub (optional)
