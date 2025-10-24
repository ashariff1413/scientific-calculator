public class CalculusHelper {
    
    public static String derivative(String expr) throws Exception {
        expr = expr.replaceAll("\\s+", "");
        
        // Simple symbolic differentiation
        if (!expr.contains("x")) return "0";
        if (expr.equals("x")) return "1";
        
        // Power rule: x^n -> n*x^(n-1)
        if (expr.matches("x\\^\\d+")) {
            int power = Integer.parseInt(expr.substring(2));
            if (power == 1) return "1";
            if (power == 2) return "2*x";
            return power + "*x^" + (power - 1);
        }
        
        // Constant multiple: c*x^n
        if (expr.matches("\\d+\\*x(\\^\\d+)?")) {
            String[] parts = expr.split("\\*");
            int coeff = Integer.parseInt(parts[0]);
            if (parts[1].equals("x")) return String.valueOf(coeff);
            if (parts[1].contains("^")) {
                int power = Integer.parseInt(parts[1].substring(3));
                return (coeff * power) + "*x^" + (power - 1);
            }
        }
        
        return "Derivative calculation for complex expressions not yet implemented";
    }
    
    public static double integrate(String expr, double lower, double upper) throws Exception {
        int steps = 10000;
        double h = (upper - lower) / steps;
        double sum = 0;
        
        // Simpson's rule for numerical integration
        for (int i = 0; i <= steps; i++) {
            double x = lower + i * h;
            double fx = evaluateAt(expr, x);
            
            if (i == 0 || i == steps) {
                sum += fx;
            } else if (i % 2 == 0) {
                sum += 2 * fx;
            } else {
                sum += 4 * fx;
            }
        }
        
        return sum * h / 3;
    }
    
    public static double limit(String expr, double point) throws Exception {
        double epsilon = 0.0001;
        double left = evaluateAt(expr, point - epsilon);
        double right = evaluateAt(expr, point + epsilon);
        
        if (Math.abs(left - right) < 0.01) {
            return (left + right) / 2;
        }
        
        throw new Exception("Limit does not exist or is discontinuous");
    }
    
    private static double evaluateAt(String expr, double xValue) throws Exception {
        expr = expr.replaceAll("x", "(" + xValue + ")");
        return new ExpressionParser(expr).parse();
    }
}
