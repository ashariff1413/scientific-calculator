public class PolynomialSolver {
    
    public static ComplexNumber[] findRoots(double[] coeffs) throws Exception {
        int degree = coeffs.length - 1;
        
        if (degree > 5) {
            throw new Exception("Degree must be 5 or less");
        }
        
        if (degree == 1) {
            return solveLinear(coeffs);
        } else if (degree == 2) {
            return solveQuadratic(coeffs);
        } else if (degree == 3) {
            return solveCubic(coeffs);
        } else {
            return solveNumerical(coeffs);
        }
    }
    
    private static ComplexNumber[] solveLinear(double[] c) {
        return new ComplexNumber[] { new ComplexNumber(-c[1] / c[0], 0) };
    }
    
    private static ComplexNumber[] solveQuadratic(double[] c) {
        double a = c[0], b = c[1], d = c[2];
        double disc = b * b - 4 * a * d;
        
        if (disc >= 0) {
            double sqrtDisc = Math.sqrt(disc);
            return new ComplexNumber[] {
                new ComplexNumber((-b + sqrtDisc) / (2 * a), 0),
                new ComplexNumber((-b - sqrtDisc) / (2 * a), 0)
            };
        } else {
            double real = -b / (2 * a);
            double imag = Math.sqrt(-disc) / (2 * a);
            return new ComplexNumber[] {
                new ComplexNumber(real, imag),
                new ComplexNumber(real, -imag)
            };
        }
    }
    
    private static ComplexNumber[] solveCubic(double[] c) {
        double a = c[1] / c[0];
        double b = c[2] / c[0];
        double d = c[3] / c[0];
        
        double p = (3 * b - a * a) / 3;
        double q = (2 * a * a * a - 9 * a * b + 27 * d) / 27;
        
        double disc = q * q / 4 + p * p * p / 27;
        
        ComplexNumber[] roots = new ComplexNumber[3];
        
        if (disc > 0) {
            double u = Math.cbrt(-q / 2 + Math.sqrt(disc));
            double v = Math.cbrt(-q / 2 - Math.sqrt(disc));
            roots[0] = new ComplexNumber(u + v - a / 3, 0);
            
            double real = -(u + v) / 2 - a / 3;
            double imag = (u - v) * Math.sqrt(3) / 2;
            roots[1] = new ComplexNumber(real, imag);
            roots[2] = new ComplexNumber(real, -imag);
        } else {
            double r = Math.sqrt(-p * p * p / 27);
            double phi = Math.acos(-q / (2 * r));
            double t = 2 * Math.cbrt(r);
            
            for (int k = 0; k < 3; k++) {
                roots[k] = new ComplexNumber(t * Math.cos((phi + 2 * Math.PI * k) / 3) - a / 3, 0);
            }
        }
        
        return roots;
    }
    
    private static ComplexNumber[] solveNumerical(double[] coeffs) throws Exception {
        int degree = coeffs.length - 1;
        ComplexNumber[] roots = new ComplexNumber[degree];
        
        for (int i = 0; i < degree; i++) {
            double angle = 2 * Math.PI * i / degree;
            roots[i] = new ComplexNumber(Math.cos(angle), Math.sin(angle));
        }
        
        for (int iter = 0; iter < 50; iter++) {
            for (int i = 0; i < degree; i++) {
                ComplexNumber num = evaluate(coeffs, roots[i]);
                ComplexNumber denom = evaluateDerivative(coeffs, roots[i]);
                
                for (int j = 0; j < degree; j++) {
                    if (i != j) {
                        denom = denom.multiply(roots[i].subtract(roots[j]));
                    }
                }
                
                if (denom.magnitude() > 1e-10) {
                    roots[i] = roots[i].subtract(num.divide(denom));
                }
            }
        }
        
        return roots;
    }
    
    private static ComplexNumber evaluate(double[] coeffs, ComplexNumber x) {
        ComplexNumber result = new ComplexNumber(coeffs[0], 0);
        for (int i = 1; i < coeffs.length; i++) {
            result = result.multiply(x).add(new ComplexNumber(coeffs[i], 0));
        }
        return result;
    }
    
    private static ComplexNumber evaluateDerivative(double[] coeffs, ComplexNumber x) {
        ComplexNumber result = new ComplexNumber(coeffs[0] * (coeffs.length - 1), 0);
        for (int i = 1; i < coeffs.length - 1; i++) {
            result = result.multiply(x).add(new ComplexNumber(coeffs[i] * (coeffs.length - 1 - i), 0));
        }
        return result;
    }
}
