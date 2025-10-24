public class ComplexParser {
    private String expr;
    private int pos = -1;
    private int ch;
    
    public ComplexParser(String expr) {
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
    
    public ComplexNumber parse() throws Exception {
        nextChar();
        ComplexNumber x = parseExpression();
        if (pos < expr.length()) throw new Exception("Unexpected: " + (char)ch);
        return x;
    }
    
    private ComplexNumber parseExpression() throws Exception {
        ComplexNumber x = parseTerm();
        while (true) {
            if (eat('+')) x = x.add(parseTerm());
            else if (eat('-')) x = x.subtract(parseTerm());
            else return x;
        }
    }
    
    private ComplexNumber parseTerm() throws Exception {
        ComplexNumber x = parseFactor();
        while (true) {
            if (eat('*')) x = x.multiply(parseFactor());
            else if (eat('/')) x = x.divide(parseFactor());
            else return x;
        }
    }
    
    private ComplexNumber parseFactor() throws Exception {
        if (eat('+')) return parseFactor();
        if (eat('-')) {
            ComplexNumber c = parseFactor();
            return new ComplexNumber(-c.real, -c.imag);
        }
        
        ComplexNumber x;
        int startPos = pos;
        
        if (eat('(')) {
            x = parseExpression();
            if (!eat(')')) throw new Exception("Missing ')'");
        } else if (eat('i')) {
            x = new ComplexNumber(0, 1);
        } else if ((ch >= '0' && ch <= '9') || ch == '.') {
            while ((ch >= '0' && ch <= '9') || ch == '.') nextChar();
            double val = Double.parseDouble(expr.substring(startPos, pos));
            if (eat('i')) {
                x = new ComplexNumber(0, val);
            } else {
                x = new ComplexNumber(val, 0);
            }
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
        
        if (eat('^')) {
            ComplexNumber exp = parseFactor();
            if (Math.abs(exp.imag) < 1e-10) {
                x = x.power(exp.real);
            } else {
                throw new Exception("Complex exponents not supported");
            }
        }
        
        return x;
    }
    
    private ComplexNumber applyFunction(String func, ComplexNumber arg) throws Exception {
        if (Math.abs(arg.imag) < 1e-10) {
            double result;
            switch (func) {
                case "sin": result = Math.sin(arg.real); break;
                case "cos": result = Math.cos(arg.real); break;
                case "tan": result = Math.tan(arg.real); break;
                case "sec": result = 1.0 / Math.cos(arg.real); break;
                case "csc": result = 1.0 / Math.sin(arg.real); break;
                case "cot": result = 1.0 / Math.tan(arg.real); break;
                case "asin": result = Math.asin(arg.real); break;
                case "acos": result = Math.acos(arg.real); break;
                case "atan": result = Math.atan(arg.real); break;
                case "asec": result = Math.acos(1.0 / arg.real); break;
                case "acsc": result = Math.asin(1.0 / arg.real); break;
                case "acot": result = Math.atan(1.0 / arg.real); break;
                case "sqrt": 
                    if (arg.real >= 0) result = Math.sqrt(arg.real);
                    else return new ComplexNumber(0, Math.sqrt(-arg.real));
                    break;
                case "cbrt": result = Math.cbrt(arg.real); break;
                case "ln": result = Math.log(arg.real); break;
                case "log": result = Math.log10(arg.real); break;
                case "log2": result = Math.log(arg.real) / Math.log(2); break;
                case "exp": result = Math.exp(arg.real); break;
                case "abs": result = Math.abs(arg.real); break;
                default: throw new Exception("Unknown function: " + func);
            }
            return new ComplexNumber(result, 0);
        } else {
            switch (func) {
                case "abs": return new ComplexNumber(arg.magnitude(), 0);
                default: throw new Exception("Function " + func + " not supported for complex numbers");
            }
        }
    }
}
