# Scientific Calculator

A modern, feature-rich scientific calculator for Windows with advanced mathematical capabilities including trigonometric functions, complex numbers, calculus operations, and system of equations solving.

![Version](https://img.shields.io/badge/version-1.0-blue)
![Platform](https://img.shields.io/badge/platform-Windows-lightgrey)
![Java](https://img.shields.io/badge/java-8%2B-orange)

## 📥 Download

**[⬇️ Download ScientificCalculator-1.0.exe (190 MB)](https://github.com/ashariff1413/scientific-calculator/releases/latest/download/ScientificCalculator-1.0.exe)**

No Java installation required! Works on Windows 10/11.

> **Alternative:** [View all releases](https://github.com/ashariff1413/scientific-calculator/releases)

## ✨ Features

- **Modern Dark Theme UI** - Sleek, professional interface
- **Trigonometric Functions** - sin, cos, tan, sec, csc, cot + inverses
- **Exponential & Logarithmic** - exp, ln, log, log2, sqrt, cbrt
- **Complex Numbers** - Full support for imaginary numbers
- **Calculus Operations** - Derivatives, integrals, limits
- **System of Equations** - Solve 2x2 and 3x3 systems
- **Polynomial Root Finder** - Up to degree 5
- **Gamma Function** - Factorial works for non-integers!

## 🚀 Quick Start

### For Users:
1. Download `dist/ScientificCalculator-1.0.exe`
2. Run the installer
3. Launch from Start Menu or Desktop
4. No Java installation required!

### For Developers:
```bash
# Compile
cd src
..\bin\javac *.java

# Run
..\bin\java Calculator
```

## 📁 Project Structure

```
Scientific-Calculator/
├── src/                          # Source code
│   ├── Calculator.java           # Main GUI application
│   ├── ComplexNumber.java        # Complex number operations
│   ├── ComplexParser.java        # Complex expression parser
│   ├── ExpressionParser.java    # Real number expression parser
│   ├── PolynomialSolver.java    # Polynomial root finder
│   ├── SystemSolver.java         # Linear system solver
│   ├── EquationSolver.java       # Single equation solver
│   └── CalculusHelper.java       # Calculus operations
│
├── dist/                         # Distribution files
│   ├── ScientificCalculator-1.0.exe    # Full installer (MAIN)
│   ├── ScientificCalculator.jar        # Cross-platform JAR
│   └── ScientificCalculator/           # Portable version
│       └── ScientificCalculator.exe    # Portable EXE
│
├── docs/                         # Documentation
│   ├── README-FOR-USERS.md       # User guide
│   ├── DISTRIBUTION-SUMMARY.md   # Distribution guide
│   ├── SHARE-WITH-FRIENDS.md     # Sharing instructions
│   ├── INSTALLER-READY.md        # Installer details
│   ├── EXE-READY.md              # EXE details
│   ├── QUICK-START.md            # Quick start guide
│   ├── DISTRIBUTION-GUIDE.md     # Full distribution guide
│   ├── build-exe-instructions.md # Building EXE guide
│   └── android-conversion-guide.md # Android conversion
│
├── scripts/                      # Build scripts
│   ├── build-jar.bat             # Build JAR file
│   ├── create-installer.bat      # Create installer
│   ├── create-distribution.bat   # Create distribution package
│   └── run-calculator.bat        # Run calculator
│
├── build-output/                 # Compiled files
│   ├── *.class                   # Compiled Java classes
│   └── MANIFEST.MF               # JAR manifest
│
├── build/                        # Build directory
├── bin/                          # JDK binaries
├── conf/                         # JDK configuration
├── include/                      # JDK headers
├── legal/                        # JDK legal files
└── lib/                          # JDK libraries
```

## 🛠️ Building from Source

### Prerequisites:
- JDK 8 or higher (included in `bin/` folder)

### Build JAR:
```bash
scripts\build-jar.bat
```

### Build Installer:
```bash
scripts\create-installer.bat
```
*Requires WiX Toolset for full installer*

### Build Portable EXE:
```bash
.\bin\jpackage.exe --input . --name "ScientificCalculator" --main-jar ScientificCalculator.jar --main-class Calculator --type app-image
```

## 📖 Documentation

- **[User Guide](docs/README-FOR-USERS.md)** - How to use the calculator
- **[Distribution Guide](docs/DISTRIBUTION-SUMMARY.md)** - How to distribute
- **[Sharing Guide](docs/SHARE-WITH-FRIENDS.md)** - Share with friends
- **[Build Instructions](docs/build-exe-instructions.md)** - Build from source

## 🎯 Usage Examples

### Basic Calculation
```
Input: 2+3*4
Output: 14
```

### Trigonometric
```
Input: sin(3.14159/2)
Output: 1.0
```

### Complex Numbers
```
Input: (3+4i)*(2-i)
Output: 10+5i
```

### Calculus
```
Click d/dx → Enter: x^2+3*x+5
Output: 2*x+3
```

### System of Equations
```
Click 2x2
Equation 1: 2x + 3y = 8
Equation 2: x - y = 1
Output: x = 2.2, y = 1.2
```

## 📤 Distribution

### For End Users:
- **Installer:** `dist/ScientificCalculator-1.0.exe` (190 MB)
  - No Java required (bundled)
  - Professional installation
  - Start Menu + Desktop shortcuts

### For Developers:
- **JAR File:** `dist/ScientificCalculator.jar` (10 KB)
  - Requires Java 8+
  - Cross-platform (Windows, Mac, Linux)

### For Portable Use:
- **Portable Folder:** `dist/ScientificCalculator/`
  - No installation needed
  - Copy folder anywhere
  - No Java required (bundled)

## 🌐 Sharing Options

1. **Google Drive** - Upload and share link
2. **GitHub Releases** - Professional distribution
3. **WeTransfer** - Quick sharing (7-day expiry)
4. **USB Drive** - Direct file transfer

See [SHARE-WITH-FRIENDS.md](docs/SHARE-WITH-FRIENDS.md) for detailed instructions.

## 🔧 Requirements

### For Users:
- Windows 10 or Windows 11
- 200 MB disk space
- No Java installation required

### For Developers:
- JDK 8 or higher
- Windows (for building EXE)
- WiX Toolset (optional, for installer)

## 📝 License

MIT License - Free to use, modify, and distribute

## 🤝 Contributing

Contributions welcome! Feel free to:
- Report bugs
- Suggest features
- Submit pull requests

## 👨‍💻 Author

Created with Java and Swing
Version 1.0 - October 2025

## 🙏 Acknowledgments

- Java Swing for GUI framework
- Lanczos approximation for Gamma function
- Simpson's rule for numerical integration
- Cramer's rule for system solving

---

**Made with ❤️ and ☕**
