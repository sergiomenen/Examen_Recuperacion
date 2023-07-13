package principal;

public class MatrixTest {

    public void runTests() {
        testDeterminantCalculation();
        testInvalidMatrixDimensions();
        testInvalidMatrixFormat();
    }

    private void testDeterminantCalculation() {
        // Caso de prueba 1: Determinante igual a 0
        double[][] matrixData1 = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        Matrix matrix1 = new Matrix(matrixData1);
        double determinant1 = matrix1.calculateDeterminant();
        assertEqual(determinant1, 0);

        // Caso de prueba 2: Determinante igual a -48
        double[][] matrixData2 = {
                {-2, 3, 5},
                {1, -4, 2},
                {3, -1, 6}
        };
        Matrix matrix2 = new Matrix(matrixData2);
        double determinant2 = matrix2.calculateDeterminant();
        assertEqual(determinant2, -48);

        // Caso de prueba 3: Determinante igual a 1
        double[][] matrixData3 = {
                {1, 0, 0},
                {0, 1, 0},
                {0, 0, 1}
        };
        Matrix matrix3 = new Matrix(matrixData3);
        double determinant3 = matrix3.calculateDeterminant();
        assertEqual(determinant3, 1);
    }

    private void testInvalidMatrixDimensions() {
        // Caso de prueba 4: Matriz con dimensiones incorrectas
        double[][] matrixData4 = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12}
        };
        try {
            Matrix matrix4 = new Matrix(matrixData4);
            double determinant4 = matrix4.calculateDeterminant();
            System.out.println("Prueba fallida. No se lanzó la excepción esperada.");
        } catch (IllegalArgumentException e) {
            System.out.println("Prueba exitosa. Se lanzó la excepción esperada: " + e.getMessage());
        }
    }

    private void testInvalidMatrixFormat() {
        // Caso de prueba 5: Matriz con formato incorrecto (texto en lugar de números)
        String[][] matrixData5 = {
                {"1", "2", "3"},
                {"4", "texto", "6"},
                {"7", "8", "9"}
        };
        try {
            double[][] matrix5 = convertToDoubleMatrix(matrixData5);
            Matrix matrix = new Matrix(matrix5);
            double determinant5 = matrix.calculateDeterminant();
            System.out.println("Prueba fallida. No se lanzó la excepción esperada.");
        } catch (NumberFormatException e) {
            System.out.println("Prueba exitosa. Se lanzó la excepción esperada: " + e.getMessage());
        }
    }

    private double[][] convertToDoubleMatrix(String[][] matrixData) {
        int rows = matrixData.length;
        int cols = matrixData[0].length;
        double[][] result = new double[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                try {
                    result[i][j] = Double.parseDouble(matrixData[i][j]);
                } catch (NumberFormatException e) {
                    throw new NumberFormatException("Formato de matriz incorrecto en la posición [" + i + "][" + j + "]");
                }
            }
        }
        return result;
    }

    private void assertEqual(double actual, double expected) {
        if (Math.abs(actual - expected) < 0.0001) {
            System.out.println("Prueba exitosa");
        } else {
            System.out.println("Prueba fallida. Valor actual: " + actual + ", Valor esperado: " + expected);
        }
    }

    public static void main(String[] args) {
        MatrixTest testRunner = new MatrixTest();
        testRunner.runTests();
    }
}
