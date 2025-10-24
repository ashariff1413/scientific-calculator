public class EquationSolver {
    
    public static String solveFor(String equation, String variable) throws Exception {
        equation = equation.replaceAll("\\s+", "");
        String[] parts = equation.split("=");
        
        if (parts.length != 2) {
            throw new Exception("Invalid equation format");
        }
        
        String left = parts[0];
        String right = parts[1];
        
        // Move everything to left side
        String combined = left + "-(" + right + ")";
        
        // Extract coefficients for linear equation ax + by = c
        double coeffX = extractCoefficient(combined, "x");
        double coeffY = extractCoefficient(combined, "y");
        double constant = extractConstant(combined);
        
        if (variable.equals("x")) {
            if (Math.abs(coeffX) < 1e-10) {
                throw new Exception("Cannot solve for x (coefficient is zero)");
            }
            // x = (-coeffY*y - constant) / coeffX
            double yCoeff = -coeffY / coeffX;
            double constTerm = -constant / coeffX;
            
            if (Math.abs(yCoeff) < 1e-10) {
                return "x = " + String.format("%.6f", constTerm);
            }
            return String.format("x = %.6f*y + %.6f", yCoeff, constTerm);
        } else {
            if (Math.abs(coeffY) < 1e-10) {
                throw new Exception("Cannot solve for y (coefficient is zero)");
            }
            // y = (-coeffX*x - constant) / coeffY
            double xCoeff = -coeffX / coeffY;
            double constTerm = -constant / coeffY;
            
            if (Math.abs(xCoeff) < 1e-10) {
                return "y = " + String.format("%.6f", constTerm);
            }
            return String.format("y = %.6f*x + %.6f", xCoeff, constTerm);
        }
    }
    
    private static double extractCoefficient(String expr, String var) {
        int idx = expr.indexOf(var);
        if (idx == -1) return 0;
        
        int start = idx - 1;
        while (start >= 0 && (Character.isDigit(expr.charAt(start)) || 
               expr.charAt(start) == '.' || expr.charAt(start) == '-' || 
               expr.charAt(start) == '+' || expr.charAt(start) == '*')) {
            start--;
        }
        start++;
        
        String coeffStr = expr.substring(start, idx);
        coeffStr = coeffStr.replace("*", "");
        if (coeffStr.isEmpty() || coeffStr.equals("+")) return 1;
        if (coeffStr.equals("-")) return -1;
        return Double.parseDouble(coeffStr);
    }
    
    private static double extractConstant(String expr) {
        // Remove all variable terms
        String temp = expr.replaceAll("[xyz]", "");
        temp = temp.replaceAll("[\\+\\-]\\*", "");
        
        // Try to evaluate remaining constant expression
        try {
            if (temp.isEmpty()) return 0;
            return new ExpressionParser(temp).parse();
        } catch (Exception e) {
            return 0;
        }
    }
}
