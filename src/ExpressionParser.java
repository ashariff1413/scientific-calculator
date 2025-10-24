public class ExpressionParser {
    private String expr;
    private int pos = -1;
    private int ch;
    
    public ExpressionParser(String expr) {
        this.expr = expr;
    }
    
    private void nextChar() {
        ch = (++pos < expr.length()) ? expr.charAt(pos) : -1;
    }
    
    private boolean eat(int charToEat) {
        while (ch == ' ') nextChar();
        if (ch == charToEat) {
            nextChar();
            return true;
        }
        return false;
    }
    
    public double parse() throws Exception {
        nextChar();
        double x = parseExpression();
        if (pos < expr.length()) throw new Exception("Unexpected: " + (char)ch);
        return x;
    }
    
    private double parseExpression() throws Exception {
        double x = parseTerm();
        while (true) {
            if (eat('+')) x += parseTerm();
            else if (eat('-')) x -= parseTerm();
            else return x;
        }
    }
    
    private double parseTerm() throws Exception {
        double x = parseFactor();
        while (true) {
            if (eat('*')) x *= parseFactor();
            else if (eat('/')) {
                double divisor = parseFactor();
                if (divisor == 0) throw new Exception("Division by zero");
                x /= divisor;
            }
            else return x;
        }
    }
    
    private double parseFactor() throws Exception {
        if (eat('+')) return parseFactor();
        if (eat('-')) return -parseFactor();
        
        double x;
        int startPos = pos;
        
        if (eat('(')) {
            x = parseExpression();
            if (!eat(')')) throw new Exception("Missing ')'");
        } else if ((ch >= '0' && ch <= '9') || ch == '.') {
            while ((ch >= '0' && ch <= '9') || ch == '.') nextChar();
            x = Double.parseDouble(expr.substring(startPos, pos));
        } else if (ch >= 'a' && ch <= 'z') {
            while (ch >= 'a' && ch <= 'z') nextChar();
            String func = expr.substring(startPos, pos);
            if (!eat('(')) throw new Exception("Missing '(' after function");
            x = parseExpression();
            if (!eat(')')) throw new Exception("Missing ')' after function");
            x = applyFunction(func, x);
        } else {
            throw new Exception("Unexpected: " + (char)ch);
        }
        
        if (eat('^')) x = Math.pow(x, parseFactor());
        if (eat('!')) x = factorial(x);
        
        return x;
    }
    
    private double applyFunction(String func, double arg) throws Exception {
        switch (func) {
            case "sin": return Math.sin(arg);
            case "cos": return Math.cos(arg);
            case "tan": return Math.tan(arg);
            case "sec": return 1.0 / Math.cos(arg);
            case "csc": return 1.0 / Math.sin(arg);
            case "cot": return 1.0 / Math.tan(arg);
            case "asin": return Math.asin(arg);
            case "acos": return Math.acos(arg);
            case "atan": return Math.atan(arg);
            case "asec": return Math.acos(1.0 / arg);
            case "acsc": return Math.asin(1.0 / arg);
            case "acot": return Math.atan(1.0 / arg);
            case "sqrt": return Math.sqrt(arg);
            case "cbrt": return Math.cbrt(arg);
            case "ln": return Math.log(arg);
            case "log": return Math.log10(arg);
            case "log2": return Math.log(arg) / Math.log(2);
            case "exp": return Math.exp(arg);
            case "abs": return Math.abs(arg);
            case "pow": return arg; // pow needs two arguments, handled separately
            default: throw new Exception("Unknown function: " + func);
        }
    }
    
    private double factorial(double n) throws Exception {
        if (n < 0) {
            throw new Exception("Factorial requires non-negative number");
        }
        
        // Use gamma function for non-integers: n! = Gamma(n+1)
        if (n != (int)n) {
            return gamma(n + 1);
        }
        
        if (n > 170) throw new Exception("Factorial overflow");
        double result = 1;
        for (int i = 2; i <= n; i++) result *= i;
        return result;
    }
    
    private double gamma(double z) {
        // Lanczos approximation for gamma function
        if (z < 0.5) {
            return Math.PI / (Math.sin(Math.PI * z) * gamma(1 - z));
        }
        
        z -= 1;
        double[] p = {
            0.99999999999980993, 676.5203681218851, -1259.1392167224028,
            771.32342877765313, -176.61502916214059, 12.507343278686905,
            -0.13857109526572012, 9.9843695780195716e-6, 1.5056327351493116e-7
        };
        
        double x = p[0];
        for (int i = 1; i < 9; i++) {
            x += p[i] / (z + i);
        }
        
        double t = z + 7.5;
        return Math.sqrt(2 * Math.PI) * Math.pow(t, z + 0.5) * Math.exp(-t) * x;
    }
}
