# Scientific Calculator

A modern, feature-rich scientific calculator for Windows with advanced mathematical capabilities including trigonometric functions, complex numbers, calculus operations, and system of equations solving.

![Version](https://img.shields.io/badge/version-1.1-blue)
![Platform](https://img.shields.io/badge/platform-Windows-lightgrey)
![Java](https://img.shields.io/badge/java-8%2B-orange)
![License](https://img.shields.io/badge/license-MIT-green)

## 📥 Download

### 🪟 Windows (No Java Required)
**[Download ScientificCalculator-1.1-Windows.zip](https://github.com/ashariff1413/scientific-calculator/releases/download/v1.1/ScientificCalculator-1.1-Windows.zip)** (223 MB)
- Extract the ZIP file
- Run `ScientificCalculator.exe`
- Works on Windows 10/11

### ☕ Cross-Platform (Requires Java 8+)
**[Download ScientificCalculator.jar](https://github.com/ashariff1413/scientific-calculator/releases/download/v1.1/ScientificCalculator.jar)** (35 KB)
- Run with: `java -jar ScientificCalculator.jar`
- Works on Windows, Mac, Linux

---

## 🎉 What's New in v1.1

### ✨ Enhanced Display Formatting
- **Clean Number Display**: Results now show without unnecessary trailing zeros
  - `3` instead of `3.0`
  - `120` instead of `120.000000`
- Applied to all operations: summation (Σ), product (∏), gradient (∇), integrals, limits

### 🚀 Improved Derivative Calculator
- **Symbolic Differentiation** now handles polynomial expressions
  - `x^2+3*x+5` → `2*x+3`
  - `2*x^3+x^2` → `6*x^2+2*x`
- **Numerical Fallback** for trigonometric and logarithmic functions

[View Full Changelog](CHANGELOG.md)

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

## 🎯 Usage Examples

### Basic Calculation
```
Input: 2+3*4
Output: 14
```

### Derivatives (NEW in v1.1!)
```
Click d/dx → Enter: x^2+3*x+5
Output: 2*x+3
```

### Summation
```
Click Σ
Function: x^2
Variable: x
Range: 1 to 5
Output: 55
```

### Gradient
```
Click ∇
Function: x^2 + y^2
Variables: x,y
Point: 1,2
Output: [2, 4]
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
├── ScientificCalculator/         # Distribution package
│   ├── app/                      # Application files
│   │   └── ScientificCalculator.jar
│   ├── runtime/                  # Bundled Java runtime
│   └── ScientificCalculator.exe  # Launcher
│
├── ScientificCalculator-1.1-Windows.zip  # Release package
├── ScientificCalculator.jar      # Standalone JAR (35 KB)
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



## 📤 Distribution Options

### 🪟 Windows Package (223 MB)
- **File:** `ScientificCalculator-1.1-Windows.zip`
- No Java required (bundled runtime)
- Extract and run `ScientificCalculator.exe`
- Professional package with all dependencies

### ☕ Cross-Platform JAR (35 KB)
- **File:** `ScientificCalculator.jar`
- Requires Java 8+ installed
- Works on Windows, Mac, Linux
- Lightweight and portable

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
**Version 1.1** - October 2025

## 🙏 Acknowledgments

- Java Swing for GUI framework
- Lanczos approximation for Gamma function
- Simpson's rule for numerical integration
- Cramer's rule for system solving
- Central difference method for numerical derivatives

## 📊 Version History

- **v1.1** (2025-10-24) - Enhanced display formatting, improved derivatives
- **v1.0** (2025-10-23) - Initial release

[View Full Changelog](CHANGELOG.md)

---

**Made with ❤️ and ☕**
