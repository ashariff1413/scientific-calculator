public class SystemSolver {
    
    public static double[] solve2x2(double[][] A, double[] b) throws Exception {
        double det = A[0][0] * A[1][1] - A[0][1] * A[1][0];
        
        if (Math.abs(det) < 1e-10) {
            throw new Exception("System has no unique solution (determinant = 0)");
        }
        
        double[] solution = new double[2];
        solution[0] = (b[0] * A[1][1] - b[1] * A[0][1]) / det;
        solution[1] = (A[0][0] * b[1] - A[1][0] * b[0]) / det;
        
        return solution;
    }
    
    public static double[] solve3x3(double[][] A, double[] b) throws Exception {
        double det = determinant3x3(A);
        
        if (Math.abs(det) < 1e-10) {
            throw new Exception("System has no unique solution (determinant = 0)");
        }
        
        double[] solution = new double[3];
        
        // Cramer's rule
        for (int i = 0; i < 3; i++) {
            double[][] temp = new double[3][3];
            for (int j = 0; j < 3; j++) {
                for (int k = 0; k < 3; k++) {
                    temp[j][k] = (k == i) ? b[j] : A[j][k];
                }
            }
            solution[i] = determinant3x3(temp) / det;
        }
        
        return solution;
    }
    
    private static double determinant3x3(double[][] A) {
        return A[0][0] * (A[1][1] * A[2][2] - A[1][2] * A[2][1]) -
               A[0][1] * (A[1][0] * A[2][2] - A[1][2] * A[2][0]) +
               A[0][2] * (A[1][0] * A[2][1] - A[1][1] * A[2][0]);
    }
}
