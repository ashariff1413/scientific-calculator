import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.border.*;

public class Calculator extends JFrame {
    private JTextField display;
    private String currentInput = "";
    private boolean complexMode = false;
    
    public Calculator() {
        setTitle("Scientific Calculator");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout(10, 10));
        getContentPane().setBackground(new Color(30, 30, 30));
        
        createDisplay();
        createButtons();
        
        pack();
        setLocationRelativeTo(null);
        setResizable(false);
    }
    
    private void createDisplay() {
        display = new JTextField();
        display.setEditable(false);
        display.setFont(new Font("Segoe UI", Font.PLAIN, 28));
        display.setHorizontalAlignment(JTextField.RIGHT);
        display.setPreferredSize(new Dimension(500, 80));
        display.setBackground(new Color(45, 45, 45));
        display.setForeground(new Color(255, 255, 255));
        display.setCaretColor(new Color(255, 255, 255));
        display.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(new Color(60, 60, 60), 2),
            BorderFactory.createEmptyBorder(10, 15, 10, 15)
        ));
        
        JPanel displayPanel = new JPanel(new BorderLayout());
        displayPanel.setBackground(new Color(30, 30, 30));
        displayPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 5, 10));
        displayPanel.add(display, BorderLayout.CENTER);
        add(displayPanel, BorderLayout.NORTH);
    }
    
    private void createButtons() {
        JPanel mainPanel = new JPanel(new BorderLayout(8, 8));
        mainPanel.setBackground(new Color(30, 30, 30));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(5, 10, 10, 10));
        
        // Number and basic operation buttons
        JPanel buttonPanel = new JPanel(new GridLayout(6, 4, 8, 8));
        buttonPanel.setBackground(new Color(30, 30, 30));
        String[] buttons = {
            "7", "8", "9", "/",
            "4", "5", "6", "*",
            "1", "2", "3", "-",
            "0", ".", "=", "+",
            "C", "(", ")", "^",
            "DEL", "x", "y", "z"
        };
        
        for (String text : buttons) {
            JButton btn = createStyledButton(text, true);
            btn.addActionListener(e -> handleButton(text));
            buttonPanel.add(btn);
        }
        
        // Create tabbed pane for function categories
        JTabbedPane tabbedPane = new JTabbedPane();
        tabbedPane.setBackground(new Color(30, 30, 30));
        tabbedPane.setForeground(new Color(200, 200, 200));
        tabbedPane.setFont(new Font("Segoe UI", Font.BOLD, 12));
        
        // Trigonometric functions tab
        JPanel trigPanel = createFunctionPanel(new String[] {
            "sin", "cos", "tan",
            "sec", "csc", "cot",
            "asin", "acos", "atan",
            "asec", "acsc", "acot"
        }, 4, 3);
        
        // Exponential/Logarithmic tab
        JPanel expPanel = createFunctionPanel(new String[] {
            "sqrt", "cbrt", "pow",
            "exp", "ln", "log",
            "log2", "abs", "!"
        }, 3, 3);
        
        // Calculus tab
        JPanel calcPanel = createFunctionPanel(new String[] {
            "d/dx", "∫", "lim",
            "Σ", "∏", "∇"
        }, 2, 3);
        
        // Complex & Systems tab
        JPanel complexPanel = createFunctionPanel(new String[] {
            "i", "Re", "Im",
            "Roots", "2x2", "3x3",
            "Solve", "Help", "Clear"
        }, 3, 3);
        
        tabbedPane.addTab("Trig", trigPanel);
        tabbedPane.addTab("Exp", expPanel);
        tabbedPane.addTab("Calc", calcPanel);
        tabbedPane.addTab("Other", complexPanel);
        
        // Style the tabbed pane
        tabbedPane.setUI(new javax.swing.plaf.basic.BasicTabbedPaneUI() {
            @Override
            protected void installDefaults() {
                super.installDefaults();
                highlight = new Color(70, 70, 70);
                lightHighlight = new Color(90, 90, 90);
                shadow = new Color(50, 50, 50);
                darkShadow = new Color(30, 30, 30);
                focus = new Color(0, 120, 215);
            }
        });
        
        mainPanel.add(buttonPanel, BorderLayout.CENTER);
        mainPanel.add(tabbedPane, BorderLayout.EAST);
        
        add(mainPanel, BorderLayout.CENTER);
    }
    
    private JPanel createFunctionPanel(String[] functions, int rows, int cols) {
        JPanel panel = new JPanel(new GridLayout(rows, cols, 8, 8));
        panel.setBackground(new Color(30, 30, 30));
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        
        for (String text : functions) {
            JButton btn = createStyledButton(text, false);
            btn.addActionListener(e -> handleScientific(text));
            panel.add(btn);
        }
        
        return panel;
    }
    
    private JButton createStyledButton(String text, boolean isNumber) {
        JButton btn = new JButton(text);
        btn.setFont(new Font("Segoe UI", Font.BOLD, 16));
        btn.setFocusPainted(false);
        btn.setBorderPainted(false);
        btn.setCursor(new Cursor(Cursor.HAND_CURSOR));
        
        if (text.equals("=")) {
            btn.setBackground(new Color(0, 120, 215));
            btn.setForeground(Color.WHITE);
        } else if (text.equals("C") || text.equals("DEL") || text.equals("Clear")) {
            btn.setBackground(new Color(200, 50, 50));
            btn.setForeground(Color.WHITE);
        } else if (isNumber && (text.matches("\\d") || text.equals("."))) {
            btn.setBackground(new Color(60, 60, 60));
            btn.setForeground(Color.WHITE);
        } else if (isNumber) {
            btn.setBackground(new Color(80, 80, 80));
            btn.setForeground(new Color(255, 165, 0));
        } else {
            btn.setBackground(new Color(70, 70, 70));
            btn.setForeground(new Color(100, 200, 255));
        }
        
        btn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn.setBackground(btn.getBackground().brighter());
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                if (text.equals("=")) {
                    btn.setBackground(new Color(0, 120, 215));
                } else if (text.equals("C") || text.equals("DEL") || text.equals("Clear")) {
                    btn.setBackground(new Color(200, 50, 50));
                } else if (isNumber && (text.matches("\\d") || text.equals("."))) {
                    btn.setBackground(new Color(60, 60, 60));
                } else if (isNumber) {
                    btn.setBackground(new Color(80, 80, 80));
                } else {
                    btn.setBackground(new Color(70, 70, 70));
                }
            }
        });
        
        return btn;
    }
    
    private void handleButton(String text) {
        try {
            switch (text) {
                case "=":
                    calculate();
                    break;
                case "C":
                    currentInput = "";
                    display.setText("");
                    complexMode = false;
                    break;
                case "DEL":
                    if (currentInput.length() > 0) {
                        currentInput = currentInput.substring(0, currentInput.length() - 1);
                        display.setText(currentInput);
                    }
                    break;
                case "x":
                case "y":
                case "z":
                    if (currentInput.length() >= 50) {
                        showError("Overflow: Input exceeds 50 characters");
                        return;
                    }
                    currentInput += text;
                    display.setText(currentInput);
                    break;
                default:
                    if (currentInput.length() >= 50) {
                        showError("Overflow: Input exceeds 50 characters");
                        return;
                    }
                    currentInput += text;
                    display.setText(currentInput);
            }
        } catch (Exception e) {
            showError("Error: " + e.getMessage());
        }
    }
    
    private void handleScientific(String func) {
        try {
            switch (func) {
                case "sin":
                case "cos":
                case "tan":
                case "sec":
                case "csc":
                case "cot":
                case "asin":
                case "acos":
                case "atan":
                case "asec":
                case "acsc":
                case "acot":
                case "sqrt":
                case "cbrt":
                case "ln":
                case "log":
                case "log2":
                case "exp":
                case "abs":
                case "pow":
                    if (currentInput.length() + func.length() + 2 > 50) {
                        showError("Overflow: Input exceeds 50 characters");
                        return;
                    }
                    currentInput += func + "(";
                    display.setText(currentInput);
                    break;
                case "!":
                    if (currentInput.length() + 1 > 50) {
                        showError("Overflow: Input exceeds 50 characters");
                        return;
                    }
                    currentInput += "!";
                    display.setText(currentInput);
                    break;
                case "i":
                    if (currentInput.length() + 1 > 50) {
                        showError("Overflow: Input exceeds 50 characters");
                        return;
                    }
                    currentInput += "i";
                    display.setText(currentInput);
                    complexMode = true;
                    break;
                case "Re":
                    calculateRealPart();
                    break;
                case "Im":
                    calculateImaginaryPart();
                    break;
                case "Roots":
                    findPolynomialRoots();
                    break;
                case "2x2":
                    solve2x2System();
                    break;
                case "3x3":
                    solve3x3System();
                    break;
                case "d/dx":
                    calculateDerivative();
                    break;
                case "∫":
                    calculateIntegral();
                    break;
                case "lim":
                    calculateLimit();
                    break;
                case "Solve":
                    solveEquation();
                    break;
                case "Help":
                    showHelp();
                    break;
                case "Clear":
                    currentInput = "";
                    display.setText("");
                    complexMode = false;
                    break;
            }
        } catch (Exception e) {
            showError("Error: " + e.getMessage());
        }
    }
    
    private void calculate() {
        if (currentInput.isEmpty()) {
            showError("Syntax Error: Empty expression");
            return;
        }
        
        try {
            if (complexMode || currentInput.contains("i")) {
                ComplexNumber result = evaluateComplex(currentInput);
                display.setText(result.toString());
                currentInput = result.toString();
            } else {
                double result = evaluate(currentInput);
                if (Double.isInfinite(result) || Double.isNaN(result)) {
                    showError("Math Error: Invalid result");
                    return;
                }
                display.setText(String.valueOf(result));
                currentInput = String.valueOf(result);
            }
        } catch (Exception e) {
            showError("Syntax Error: " + e.getMessage());
        }
    }
    
    private double evaluate(String expr) throws Exception {
        expr = expr.replaceAll("\\s+", "");
        return new ExpressionParser(expr).parse();
    }
    
    private ComplexNumber evaluateComplex(String expr) throws Exception {
        expr = expr.replaceAll("\\s+", "");
        return new ComplexParser(expr).parse();
    }
    
    private void calculateRealPart() {
        try {
            ComplexNumber c = evaluateComplex(currentInput);
            display.setText("Re = " + c.real);
            currentInput = String.valueOf(c.real);
            complexMode = false;
        } catch (Exception e) {
            showError("Error: " + e.getMessage());
        }
    }
    
    private void calculateImaginaryPart() {
        try {
            ComplexNumber c = evaluateComplex(currentInput);
            display.setText("Im = " + c.imag);
            currentInput = String.valueOf(c.imag);
            complexMode = false;
        } catch (Exception e) {
            showError("Error: " + e.getMessage());
        }
    }
    
    private void findPolynomialRoots() {
        String input = JOptionPane.showInputDialog(this, 
            "Enter polynomial coefficients (highest to lowest degree)\n" +
            "Example: 1,0,-1 for x^2-1\n" +
            "Maximum degree: 5",
            "Polynomial Root Finder",
            JOptionPane.QUESTION_MESSAGE);
        
        if (input == null || input.trim().isEmpty()) return;
        
        try {
            String[] parts = input.split(",");
            if (parts.length > 6) {
                showError("Argument Error: Degree must be less than 6");
                return;
            }
            
            double[] coeffs = new double[parts.length];
            for (int i = 0; i < parts.length; i++) {
                coeffs[i] = Double.parseDouble(parts[i].trim());
            }
            
            ComplexNumber[] roots = PolynomialSolver.findRoots(coeffs);
            StringBuilder result = new StringBuilder("Roots:\n");
            for (int i = 0; i < roots.length; i++) {
                result.append("x").append(i + 1).append(" = ").append(roots[i]).append("\n");
            }
            
            JOptionPane.showMessageDialog(this, result.toString(), 
                "Polynomial Roots", JOptionPane.INFORMATION_MESSAGE);
        } catch (NumberFormatException e) {
            showError("Argument Error: Invalid coefficient format");
        } catch (Exception e) {
            showError("Error: " + e.getMessage());
        }
    }
    
    private void solve2x2System() {
        JPanel panel = new JPanel(new GridLayout(3, 1, 5, 5));
        panel.add(new JLabel("Enter equations in form: ax + by = c"));
        JTextField eq1 = new JTextField("2x + 3y = 8");
        JTextField eq2 = new JTextField("x - y = 1");
        panel.add(eq1);
        panel.add(eq2);
        
        int result = JOptionPane.showConfirmDialog(this, panel, "2x2 System Solver", 
            JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
        
        if (result == JOptionPane.OK_OPTION) {
            try {
                double[] coeffs1 = parseLinearEquation(eq1.getText(), 2);
                double[] coeffs2 = parseLinearEquation(eq2.getText(), 2);
                
                double[][] A = {{coeffs1[0], coeffs1[1]}, {coeffs2[0], coeffs2[1]}};
                double[] b = {coeffs1[2], coeffs2[2]};
                
                double[] solution = SystemSolver.solve2x2(A, b);
                String msg = String.format("Solution:\nx = %.6f\ny = %.6f", solution[0], solution[1]);
                JOptionPane.showMessageDialog(this, msg, "Solution", JOptionPane.INFORMATION_MESSAGE);
            } catch (Exception e) {
                showError("Error: " + e.getMessage());
            }
        }
    }
    
    private void solve3x3System() {
        JPanel panel = new JPanel(new GridLayout(4, 1, 5, 5));
        panel.add(new JLabel("Enter equations in form: ax + by + cz = d"));
        JTextField eq1 = new JTextField("2x + y - z = 8");
        JTextField eq2 = new JTextField("-3x - y + 2z = -11");
        JTextField eq3 = new JTextField("-2x + y + 2z = -3");
        panel.add(eq1);
        panel.add(eq2);
        panel.add(eq3);
        
        int result = JOptionPane.showConfirmDialog(this, panel, "3x3 System Solver", 
            JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
        
        if (result == JOptionPane.OK_OPTION) {
            try {
                double[] coeffs1 = parseLinearEquation(eq1.getText(), 3);
                double[] coeffs2 = parseLinearEquation(eq2.getText(), 3);
                double[] coeffs3 = parseLinearEquation(eq3.getText(), 3);
                
                double[][] A = {
                    {coeffs1[0], coeffs1[1], coeffs1[2]},
                    {coeffs2[0], coeffs2[1], coeffs2[2]},
                    {coeffs3[0], coeffs3[1], coeffs3[2]}
                };
                double[] b = {coeffs1[3], coeffs2[3], coeffs3[3]};
                
                double[] solution = SystemSolver.solve3x3(A, b);
                String msg = String.format("Solution:\nx = %.6f\ny = %.6f\nz = %.6f", 
                    solution[0], solution[1], solution[2]);
                JOptionPane.showMessageDialog(this, msg, "Solution", JOptionPane.INFORMATION_MESSAGE);
            } catch (Exception e) {
                showError("Error: " + e.getMessage());
            }
        }
    }
    
    private double[] parseLinearEquation(String eq, int vars) throws Exception {
        eq = eq.replaceAll("\\s+", "");
        String[] parts = eq.split("=");
        if (parts.length != 2) throw new Exception("Invalid equation format");
        
        double[] coeffs = new double[vars + 1];
        String left = parts[0];
        coeffs[vars] = Double.parseDouble(parts[1]);
        
        // Parse left side for x, y, z coefficients
        String[] varNames = {"x", "y", "z"};
        for (int i = 0; i < vars; i++) {
            coeffs[i] = extractCoefficient(left, varNames[i]);
        }
        
        return coeffs;
    }
    
    private double extractCoefficient(String expr, String var) {
        int idx = expr.indexOf(var);
        if (idx == -1) return 0;
        
        int start = idx - 1;
        while (start >= 0 && (Character.isDigit(expr.charAt(start)) || 
               expr.charAt(start) == '.' || expr.charAt(start) == '-' || 
               expr.charAt(start) == '+')) {
            start--;
        }
        start++;
        
        String coeffStr = expr.substring(start, idx);
        if (coeffStr.isEmpty() || coeffStr.equals("+")) return 1;
        if (coeffStr.equals("-")) return -1;
        return Double.parseDouble(coeffStr);
    }
    
    private void calculateDerivative() {
        String input = JOptionPane.showInputDialog(this, 
            "Enter function to differentiate (use x as variable)\nExample: x^2+3*x+5",
            "Derivative Calculator",
            JOptionPane.QUESTION_MESSAGE);
        
        if (input == null || input.trim().isEmpty()) return;
        
        try {
            String derivative = CalculusHelper.derivative(input);
            JOptionPane.showMessageDialog(this, "d/dx(" + input + ") = " + derivative, 
                "Derivative", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception e) {
            showError("Error: " + e.getMessage());
        }
    }
    
    private void calculateIntegral() {
        JPanel panel = new JPanel(new GridLayout(4, 1, 5, 5));
        panel.add(new JLabel("Enter function to integrate (use x as variable)"));
        JTextField funcField = new JTextField("x^2");
        JTextField lowerField = new JTextField("0");
        JTextField upperField = new JTextField("1");
        panel.add(funcField);
        panel.add(new JLabel("Lower bound:"));
        panel.add(lowerField);
        panel.add(new JLabel("Upper bound:"));
        panel.add(upperField);
        
        int result = JOptionPane.showConfirmDialog(this, panel, "Definite Integral", 
            JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
        
        if (result == JOptionPane.OK_OPTION) {
            try {
                double lower = Double.parseDouble(lowerField.getText());
                double upper = Double.parseDouble(upperField.getText());
                double integral = CalculusHelper.integrate(funcField.getText(), lower, upper);
                String msg = String.format("∫[%.2f to %.2f] %s dx = %.6f", 
                    lower, upper, funcField.getText(), integral);
                JOptionPane.showMessageDialog(this, msg, "Integral", JOptionPane.INFORMATION_MESSAGE);
            } catch (Exception e) {
                showError("Error: " + e.getMessage());
            }
        }
    }
    
    private void calculateLimit() {
        JPanel panel = new JPanel(new GridLayout(3, 1, 5, 5));
        panel.add(new JLabel("Enter function (use x as variable)"));
        JTextField funcField = new JTextField("(x^2-1)/(x-1)");
        JTextField pointField = new JTextField("1");
        panel.add(funcField);
        panel.add(new JLabel("x approaches:"));
        panel.add(pointField);
        
        int result = JOptionPane.showConfirmDialog(this, panel, "Limit Calculator", 
            JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
        
        if (result == JOptionPane.OK_OPTION) {
            try {
                double point = Double.parseDouble(pointField.getText());
                double limit = CalculusHelper.limit(funcField.getText(), point);
                String msg = String.format("lim(x→%.2f) %s = %.6f", 
                    point, funcField.getText(), limit);
                JOptionPane.showMessageDialog(this, msg, "Limit", JOptionPane.INFORMATION_MESSAGE);
            } catch (Exception e) {
                showError("Error: " + e.getMessage());
            }
        }
    }
    
    private void solveEquation() {
        String input = JOptionPane.showInputDialog(this, 
            "Enter equation (e.g., 2x+4y=5)\nFor single equation, will solve for one variable",
            "Equation Solver",
            JOptionPane.QUESTION_MESSAGE);
        
        if (input == null || input.trim().isEmpty()) return;
        
        try {
            if (!input.contains("=")) {
                showError("Error: Equation must contain '='");
                return;
            }
            
            String[] vars = {"x", "y", "z"};
            int varCount = 0;
            String foundVar = "";
            for (String var : vars) {
                if (input.contains(var)) {
                    varCount++;
                    foundVar = var;
                }
            }
            
            if (varCount == 1) {
                double[] coeffs = parseLinearEquation(input, 1);
                double solution = -coeffs[1] / coeffs[0];
                JOptionPane.showMessageDialog(this, foundVar + " = " + solution, 
                    "Solution", JOptionPane.INFORMATION_MESSAGE);
            } else if (varCount == 2) {
                String[] options = {"Solve for x", "Solve for y"};
                int choice = JOptionPane.showOptionDialog(this, 
                    "Solve which variable in terms of what?", "Choose Variable",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE,
                    null, options, options[0]);
                
                if (choice >= 0) {
                    String result = EquationSolver.solveFor(input, choice == 0 ? "x" : "y");
                    JOptionPane.showMessageDialog(this, result, "Solution", 
                        JOptionPane.INFORMATION_MESSAGE);
                }
            } else {
                showError("Error: Use 2x2 or 3x3 buttons for multiple equations");
            }
        } catch (Exception e) {
            showError("Error: " + e.getMessage());
        }
    }
    
    private void showHelp() {
        JPanel helpPanel = new JPanel();
        helpPanel.setLayout(new BoxLayout(helpPanel, BoxLayout.Y_AXIS));
        helpPanel.setBackground(Color.WHITE);
        
        JTextArea helpText = new JTextArea(40, 60);
        helpText.setEditable(false);
        helpText.setFont(new Font("Consolas", Font.PLAIN, 12));
        helpText.setText(
            "╔═══════════════════════════════════════════════════════════════════════╗\n" +
            "║           SCIENTIFIC CALCULATOR - FORMULAS & FUNCTIONS               ║\n" +
            "╚═══════════════════════════════════════════════════════════════════════╝\n\n" +
            
            "┌─ BASIC OPERATIONS ─────────────────────────────────────────────────┐\n" +
            "│  a + b        Addition                                             │\n" +
            "│  a - b        Subtraction                                          │\n" +
            "│  a * b        Multiplication                                       │\n" +
            "│  a / b        Division                                             │\n" +
            "│  a ^ b        Power (a raised to b)                                │\n" +
            "│  (expr)       Parentheses for grouping                             │\n" +
            "└────────────────────────────────────────────────────────────────────┘\n\n" +
            
            "┌─ TRIGONOMETRIC FUNCTIONS (angles in radians) ─────────────────────┐\n" +
            "│  sin(x)       sin(x) = opposite/hypotenuse                         │\n" +
            "│  cos(x)       cos(x) = adjacent/hypotenuse                         │\n" +
            "│  tan(x)       tan(x) = sin(x)/cos(x) = opposite/adjacent           │\n" +
            "│  sec(x)       sec(x) = 1/cos(x)                                    │\n" +
            "│  csc(x)       csc(x) = 1/sin(x)                                    │\n" +
            "│  cot(x)       cot(x) = 1/tan(x) = cos(x)/sin(x)                    │\n" +
            "│                                                                     │\n" +
            "│  asin(x)      arcsin(x), inverse sine, range: [-π/2, π/2]          │\n" +
            "│  acos(x)      arccos(x), inverse cosine, range: [0, π]             │\n" +
            "│  atan(x)      arctan(x), inverse tangent, range: (-π/2, π/2)       │\n" +
            "│  asec(x)      arcsec(x) = acos(1/x)                                │\n" +
            "│  acsc(x)      arccsc(x) = asin(1/x)                                │\n" +
            "│  acot(x)      arccot(x) = atan(1/x)                                │\n" +
            "│                                                                     │\n" +
            "│  Identity: sin²(x) + cos²(x) = 1                                   │\n" +
            "│  Convert: degrees to radians = deg × π/180                         │\n" +
            "└────────────────────────────────────────────────────────────────────┘\n\n" +
            
            "┌─ EXPONENTIAL & LOGARITHMIC ────────────────────────────────────────┐\n" +
            "│  exp(x)       e^x, where e ≈ 2.71828                               │\n" +
            "│  ln(x)        Natural logarithm, ln(e^x) = x                       │\n" +
            "│  log(x)       Base 10 logarithm, log₁₀(x)                          │\n" +
            "│  log2(x)      Base 2 logarithm, log₂(x)                            │\n" +
            "│  sqrt(x)      √x, square root, x^(1/2)                             │\n" +
            "│  cbrt(x)      ∛x, cube root, x^(1/3)                               │\n" +
            "│  pow(x,y)     x^y, x raised to power y                             │\n" +
            "│                                                                     │\n" +
            "│  Properties:                                                        │\n" +
            "│    ln(a×b) = ln(a) + ln(b)                                         │\n" +
            "│    ln(a/b) = ln(a) - ln(b)                                         │\n" +
            "│    ln(a^b) = b×ln(a)                                               │\n" +
            "│    e^(ln(x)) = x                                                   │\n" +
            "└────────────────────────────────────────────────────────────────────┘\n\n" +
            
            "┌─ FACTORIAL & GAMMA FUNCTION ───────────────────────────────────────┐\n" +
            "│  n!           Factorial: n! = n×(n-1)×...×2×1                      │\n" +
            "│               0! = 1, 5! = 120                                     │\n" +
            "│               Uses Gamma function: n! = Γ(n+1)                     │\n" +
            "│               Works for non-integers: 3.5! ≈ 11.63                 │\n" +
            "│                                                                     │\n" +
            "│  Γ(n)         Gamma function (Lanczos approximation)               │\n" +
            "│               Γ(n+1) = n×Γ(n)                                      │\n" +
            "│               Γ(1/2) = √π                                          │\n" +
            "└────────────────────────────────────────────────────────────────────┘\n\n" +
            
            "┌─ CALCULUS OPERATIONS ──────────────────────────────────────────────┐\n" +
            "│  d/dx         Derivative: rate of change                           │\n" +
            "│               d/dx(x^n) = n×x^(n-1)                                │\n" +
            "│               d/dx(sin(x)) = cos(x)                                │\n" +
            "│               d/dx(e^x) = e^x                                      │\n" +
            "│                                                                     │\n" +
            "│  ∫             Definite integral: area under curve                 │\n" +
            "│               Uses Simpson's rule (numerical)                      │\n" +
            "│               ∫[a,b] f(x)dx                                        │\n" +
            "│                                                                     │\n" +
            "│  lim          Limit as x approaches a point                        │\n" +
            "│               lim(x→a) f(x)                                        │\n" +
            "└────────────────────────────────────────────────────────────────────┘\n\n" +
            
            "┌─ COMPLEX NUMBERS ──────────────────────────────────────────────────┐\n" +
            "│  i             Imaginary unit: i² = -1                             │\n" +
            "│  a + bi       Complex number (a=real, b=imaginary)                 │\n" +
            "│  Re(z)        Real part of z                                       │\n" +
            "│  Im(z)        Imaginary part of z                                  │\n" +
            "│  |z|          Magnitude: |a+bi| = √(a²+b²)                         │\n" +
            "│                                                                     │\n" +
            "│  Operations:                                                        │\n" +
            "│    (a+bi) + (c+di) = (a+c) + (b+d)i                                │\n" +
            "│    (a+bi) × (c+di) = (ac-bd) + (ad+bc)i                            │\n" +
            "│  Example: (3+4i) * (2-i) = 10+5i                                   │\n" +
            "└────────────────────────────────────────────────────────────────────┘\n\n" +
            
            "┌─ POLYNOMIAL ROOTS ─────────────────────────────────────────────────┐\n" +
            "│  Roots        Find zeros of polynomial                             │\n" +
            "│               ax^n + bx^(n-1) + ... + c = 0                        │\n" +
            "│                                                                     │\n" +
            "│  Quadratic:   x = (-b ± √(b²-4ac)) / 2a                            │\n" +
            "│  Cubic:       Uses Cardano's formula                               │\n" +
            "│  Higher:      Numerical methods (max degree 5)                     │\n" +
            "│                                                                     │\n" +
            "│  Input: Coefficients from highest to lowest                        │\n" +
            "│  Example: 1,0,-1 solves x²-1=0 → x=±1                              │\n" +
            "└────────────────────────────────────────────────────────────────────┘\n\n" +
            
            "┌─ SYSTEMS OF LINEAR EQUATIONS ──────────────────────────────────────┐\n" +
            "│  2x2 System:  a₁x + b₁y = c₁                                       │\n" +
            "│               a₂x + b₂y = c₂                                       │\n" +
            "│                                                                     │\n" +
            "│  3x3 System:  a₁x + b₁y + c₁z = d₁                                 │\n" +
            "│               a₂x + b₂y + c₂z = d₂                                 │\n" +
            "│               a₃x + b₃y + c₃z = d₃                                 │\n" +
            "│                                                                     │\n" +
            "│  Method: Cramer's Rule using determinants                          │\n" +
            "│  Solution exists if determinant ≠ 0                                │\n" +
            "│                                                                     │\n" +
            "│  Example: 2x + 3y = 8                                              │\n" +
            "│           x - y = 1    →  x=2.2, y=1.2                             │\n" +
            "└────────────────────────────────────────────────────────────────────┘\n\n" +
            
            "┌─ SPECIAL CONSTANTS ────────────────────────────────────────────────┐\n" +
            "│  π (pi)       ≈ 3.14159265359 (use 3.14159 or acos(-1))           │\n" +
            "│  e            ≈ 2.71828182846 (use exp(1))                         │\n" +
            "│  φ (phi)      ≈ 1.61803398875 (golden ratio: (1+√5)/2)            │\n" +
            "└────────────────────────────────────────────────────────────────────┘\n\n" +
            
            "┌─ TIPS & LIMITS ────────────────────────────────────────────────────┐\n" +
            "│  • Max input length: 50 characters                                 │\n" +
            "│  • Use parentheses for clarity: 2*(3+4) not 2*3+4                  │\n" +
            "│  • Variables: x, y, z for algebraic expressions                    │\n" +
            "│  • Angles in radians (multiply degrees by π/180)                   │\n" +
            "│  • Factorial limit: n ≤ 170 (to prevent overflow)                  │\n" +
            "│  • DEL removes last character, C clears all                        │\n" +
            "└────────────────────────────────────────────────────────────────────┘\n"
        );
        
        JScrollPane scrollPane = new JScrollPane(helpText);
        scrollPane.setPreferredSize(new Dimension(750, 600));
        
        JOptionPane.showMessageDialog(this, scrollPane, 
            "Mathematical Formulas & Functions", JOptionPane.PLAIN_MESSAGE);
    }
    
    private void showError(String message) {
        display.setText(message);
        currentInput = "";
    }
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new Calculator().setVisible(true);
        });
    }
}
