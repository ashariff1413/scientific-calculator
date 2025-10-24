# Project Structure

## 📁 Organized Folder Layout

```
Scientific-Calculator/
│
├── 📂 src/                           # SOURCE CODE
│   ├── Calculator.java               # Main GUI application (JFrame)
│   ├── ComplexNumber.java            # Complex number class and operations
│   ├── ComplexParser.java            # Parser for complex expressions
│   ├── ExpressionParser.java        # Parser for real number expressions
│   ├── PolynomialSolver.java        # Polynomial root finding algorithms
│   ├── SystemSolver.java             # Linear system solver (Cramer's rule)
│   ├── EquationSolver.java           # Single equation solver
│   └── CalculusHelper.java           # Calculus operations (derivative, integral, limit)
│
├── 📂 dist/                          # DISTRIBUTION FILES (Ready to share!)
│   ├── ScientificCalculator-1.0.exe  # ⭐ Full installer (190 MB) - MAIN FILE
│   ├── ScientificCalculator.jar      # Cross-platform JAR (10 KB)
│   └── ScientificCalculator/         # Portable version folder
│       ├── ScientificCalculator.exe  # Portable EXE (no install needed)
│       ├── app/                      # Application files
│       └── runtime/                  # Bundled Java runtime
│
├── 📂 docs/                          # DOCUMENTATION
│   ├── README-FOR-USERS.md           # User guide (how to use)
│   ├── DISTRIBUTION-SUMMARY.md       # Distribution options overview
│   ├── SHARE-WITH-FRIENDS.md         # How to share with friends
│   ├── INSTALLER-READY.md            # Installer details and info
│   ├── EXE-READY.md                  # Portable EXE details
│   ├── QUICK-START.md                # Quick start guide
│   ├── DISTRIBUTION-GUIDE.md         # Complete distribution guide
│   ├── build-exe-instructions.md     # How to build EXE
│   └── android-conversion-guide.md   # Convert to Android app
│
├── 📂 scripts/                       # BUILD SCRIPTS
│   ├── build-jar.bat                 # Build JAR file
│   ├── create-installer.bat          # Create full installer (needs WiX)
│   ├── create-distribution.bat       # Create distribution package
│   └── run-calculator.bat            # Run calculator from JAR
│
├── 📂 build-output/                  # COMPILED FILES
│   ├── *.class                       # Compiled Java bytecode
│   └── MANIFEST.MF                   # JAR manifest file
│
├── 📂 build/                         # BUILD DIRECTORY
│   └── (temporary build files)
│
├── 📂 bin/                           # JDK BINARIES
│   ├── javac.exe                     # Java compiler
│   ├── java.exe                      # Java runtime
│   ├── jar.exe                       # JAR packager
│   ├── jpackage.exe                  # Native packager
│   └── (other JDK tools)
│
├── 📂 conf/                          # JDK CONFIGURATION
├── 📂 include/                       # JDK HEADERS
├── 📂 legal/                         # JDK LEGAL FILES
├── 📂 lib/                           # JDK LIBRARIES
│
├── 📄 README.md                      # Main project README
├── 📄 PROJECT-STRUCTURE.md           # This file
├── 📄 NOTICE                         # JDK notice file
└── 📄 release                        # JDK release info
```

---

## 📋 File Descriptions

### Source Code (`src/`)
All Java source files for the calculator application.

**Main Files:**
- `Calculator.java` - GUI, event handling, main application
- `ExpressionParser.java` - Parses and evaluates mathematical expressions
- `ComplexParser.java` - Handles complex number expressions

**Helper Classes:**
- `ComplexNumber.java` - Complex number arithmetic
- `PolynomialSolver.java` - Finds polynomial roots
- `SystemSolver.java` - Solves linear systems
- `EquationSolver.java` - Solves single equations
- `CalculusHelper.java` - Derivative, integral, limit calculations

---

### Distribution (`dist/`)
Ready-to-share files for end users.

**Main Distribution File:**
- `ScientificCalculator-1.0.exe` (190 MB)
  - Full Windows installer
  - No Java required
  - Creates Start Menu + Desktop shortcuts
  - Includes uninstaller
  - **This is what you share with friends!**

**Alternative Distributions:**
- `ScientificCalculator.jar` (10 KB)
  - Cross-platform (Windows, Mac, Linux)
  - Requires Java 8+ installed
  - For developers/technical users

- `ScientificCalculator/` folder
  - Portable version
  - No installation needed
  - Copy folder anywhere and run
  - No Java required (bundled)

---

### Documentation (`docs/`)
All guides and documentation.

**For Users:**
- `README-FOR-USERS.md` - How to install and use
- `QUICK-START.md` - Quick start guide
- `SHARE-WITH-FRIENDS.md` - How to share

**For Distribution:**
- `DISTRIBUTION-SUMMARY.md` - Overview of all options
- `DISTRIBUTION-GUIDE.md` - Complete distribution guide
- `INSTALLER-READY.md` - Installer details
- `EXE-READY.md` - Portable EXE details

**For Developers:**
- `build-exe-instructions.md` - Building executables
- `android-conversion-guide.md` - Convert to Android

---

### Scripts (`scripts/`)
Batch files for building and running.

- `build-jar.bat` - Compiles and creates JAR file
- `create-installer.bat` - Creates full installer (needs WiX)
- `create-distribution.bat` - Creates distribution package
- `run-calculator.bat` - Runs the calculator

---

### Build Output (`build-output/`)
Compiled Java class files and build artifacts.

- `*.class` - Compiled bytecode
- `MANIFEST.MF` - JAR manifest

---

### JDK Folders
Java Development Kit files (for building).

- `bin/` - JDK executables (javac, java, jar, jpackage)
- `conf/` - JDK configuration
- `include/` - C/C++ header files
- `legal/` - Legal notices
- `lib/` - JDK libraries

---

## 🎯 What to Use When

### I want to share with friends:
→ Use `dist/ScientificCalculator-1.0.exe`

### I want to modify the code:
→ Edit files in `src/`

### I want to rebuild:
→ Run `scripts/build-jar.bat`

### I want to read documentation:
→ Check `docs/` folder

### I want to see compiled files:
→ Look in `build-output/`

---

## 🔄 Workflow

### Development:
1. Edit source files in `src/`
2. Run `scripts/build-jar.bat` to compile
3. Test with `scripts/run-calculator.bat`

### Distribution:
1. Build installer with `scripts/create-installer.bat`
2. Find installer in `dist/`
3. Share `dist/ScientificCalculator-1.0.exe`

### Documentation:
1. Read guides in `docs/`
2. Share `docs/README-FOR-USERS.md` with users

---

## 📦 What to Upload to GitHub

**Essential:**
- `src/` - Source code
- `README.md` - Main README
- `PROJECT-STRUCTURE.md` - This file
- `scripts/` - Build scripts

**Optional:**
- `docs/` - Documentation
- `dist/ScientificCalculator.jar` - JAR file (small)

**Don't Upload:**
- `dist/ScientificCalculator-1.0.exe` - Too large (190 MB)
- `dist/ScientificCalculator/` - Too large
- `build-output/` - Compiled files (regenerated)
- `bin/`, `conf/`, `include/`, `legal/`, `lib/` - JDK files

**Instead:**
- Upload installer to GitHub Releases
- Keep source code in repository

---

## ✅ Clean and Organized!

Your project is now properly structured with:
- ✅ Source code in `src/`
- ✅ Distribution files in `dist/`
- ✅ Documentation in `docs/`
- ✅ Build scripts in `scripts/`
- ✅ Compiled files in `build-output/`

Everything is easy to find and maintain!
