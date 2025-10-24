public class ComplexNumber {
    public double real;
    public double imag;
    
    public ComplexNumber(double real, double imag) {
        this.real = real;
        this.imag = imag;
    }
    
    public ComplexNumber add(ComplexNumber other) {
        return new ComplexNumber(this.real + other.real, this.imag + other.imag);
    }
    
    public ComplexNumber subtract(ComplexNumber other) {
        return new ComplexNumber(this.real - other.real, this.imag - other.imag);
    }
    
    public ComplexNumber multiply(ComplexNumber other) {
        double r = this.real * other.real - this.imag * other.imag;
        double i = this.real * other.imag + this.imag * other.real;
        return new ComplexNumber(r, i);
    }
    
    public ComplexNumber divide(ComplexNumber other) {
        double denom = other.real * other.real + other.imag * other.imag;
        if (denom == 0) throw new ArithmeticException("Division by zero");
        double r = (this.real * other.real + this.imag * other.imag) / denom;
        double i = (this.imag * other.real - this.real * other.imag) / denom;
        return new ComplexNumber(r, i);
    }
    
    public ComplexNumber power(double exp) {
        double r = Math.sqrt(real * real + imag * imag);
        double theta = Math.atan2(imag, real);
        double newR = Math.pow(r, exp);
        double newTheta = theta * exp;
        return new ComplexNumber(newR * Math.cos(newTheta), newR * Math.sin(newTheta));
    }
    
    public double magnitude() {
        return Math.sqrt(real * real + imag * imag);
    }
    
    @Override
    public String toString() {
        if (Math.abs(imag) < 1e-10) return String.format("%.6f", real);
        if (Math.abs(real) < 1e-10) return String.format("%.6fi", imag);
        if (imag > 0) return String.format("%.6f+%.6fi", real, imag);
        return String.format("%.6f%.6fi", real, imag);
    }
}
