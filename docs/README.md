# Scientific Calculator

A comprehensive Java-based scientific calculator with advanced mathematical capabilities including complex numbers, polynomial solving, and system of equations.

## How to Run

### Compile
```bash
javac Calculator.java ComplexNumber.java ComplexParser.java ExpressionParser.java PolynomialSolver.java SystemSolver.java
```

### Run
```bash
java Calculator
```

## Features

### Modern Dark Theme UI
- Sleek dark interface with color-coded buttons
- Organized function tabs: Trig, Exp, Calc, Other
- Hover effects and smooth interactions
- Large, easy-to-read display

### Basic Operations
- **Arithmetic**: Addition (+), Subtraction (-), Multiplication (*), Division (/), Power (^)
- **Parentheses**: Support for nested expressions
- **DEL**: Delete last character
- **C**: Clear display
- **Variables**: x, y, z for algebraic expressions

### Trigonometric Functions (Trig Tab)
- **Basic**: sin, cos, tan, sec, csc, cot
- **Inverse**: asin, acos, atan, asec, acsc, acot
- All angles in radians

### Exponential & Logarithmic (Exp Tab)
- **Roots**: sqrt (square root), cbrt (cube root)
- **Exponential**: exp (e^x), pow (power)
- **Logarithms**: ln (natural), log (base 10), log2 (base 2)
- **Other**: abs (absolute value)
- **Factorial**: ! operator with gamma function support (works for non-integers!)

### Calculus Functions (Calc Tab)
- **Derivative**: d/dx - symbolic and numerical differentiation
- **Integration**: ∫ - definite integral using Simpson's rule
- **Limit**: lim - limit evaluation at a point
- **Advanced**: Σ (summation), ∏ (product), ∇ (gradient)

### Complex Numbers
- Use **i** button for imaginary unit
- Example: `3+4i`, `2i`, `5+3i*2-i`
- **Re**: Extract real part of complex number
- **Im**: Extract imaginary part of complex number
- Supports all operations with complex numbers

### Polynomial Root Finder
- Click **Roots** button
- Enter coefficients from highest to lowest degree
- Example: `1,0,-1` for x²-1
- Supports polynomials up to degree 5
- Returns all roots (real and complex)

### System of Equations Solver

#### 2x2 System
- Click **2x2** button
- Enter two equations with x and y variables
- Format: `ax + by = c`
- Example:
  - `2x + 3y = 8`
  - `x - y = 1`
- Solves for x and y values

#### 3x3 System
- Click **3x3** button
- Enter three equations with x, y, and z variables
- Format: `ax + by + cz = d`
- Example:
  - `2x + y - z = 8`
  - `-3x - y + 2z = -11`
  - `-2x + y + 2z = -3`
- Solves for x, y, and z values

### Single Equation Solver
- Enter equation like `2x + 4y = 5`
- If only one equation is entered, calculator will prompt:
  - "Solve which variable in terms of what?"
  - Choose to solve for x in terms of y, or y in terms of x

## Usage Examples

### Basic Calculation
```
Input: 2+3*4
Output: 14
```

### Scientific Function
```
Input: sin(3.14159/2)
Output: 1.0
```

### Complex Number
```
Input: (3+4i)*(2-i)
Output: 10+5i
```

### Polynomial Roots
```
Click Roots → Enter: 1,-5,6
Output: x1 = 3.0, x2 = 2.0
(Roots of x²-5x+6)
```

### System of Equations
```
Click 2x2
Equation 1: 2x + 4y = 5
Equation 2: 5x + 3 = 4y + 9
Output: x = ?, y = ?
```

## Limitations
- Maximum input length: 50 characters
- Polynomial degree: Maximum 5
- System of equations: Maximum 3x3
- Factorial: Maximum n = 170 (to prevent overflow)

## Error Handling
- **Syntax Error**: Invalid expression format
- **Math Error**: Division by zero, invalid operations
- **Overflow**: Input exceeds character limit
- **Argument Error**: Invalid function arguments

## Help
Click the **Help** button in the calculator for quick reference of all available functions and formulas.

## Requirements
- Java Development Kit (JDK) 8 or higher
- Java Swing library (included in standard JDK)

## Project Structure
```
Calculator.java         - Main GUI and calculator logic
ComplexNumber.java      - Complex number operations
ComplexParser.java      - Parser for complex expressions
ExpressionParser.java   - Parser for real number expressions
PolynomialSolver.java   - Polynomial root finding algorithms
SystemSolver.java       - Linear system solver (Cramer's rule)
```

## Future Enhancements
- Derivative calculation
- Limit evaluation
- Integration (definite and indefinite)
- Matrix operations
- Graphing capabilities
