package principal;

public class Matrix {
    private double[][] data;

    public Matrix(double[][] data) {
        if (data.length != 3 || data[0].length != 3) {
            throw new IllegalArgumentException("La matriz debe ser de dimensiones 3x3");
        }
        this.data = data;
    }

    public double calculateDeterminant() {
        return calculateDeterminant(data);
    }

    private double calculateDeterminant(double[][] matrix) {
        if (matrix.length == 2) {
            return matrix[0][0] * matrix[1][1] - matrix[0][1] * matrix[1][0];
        }

        double determinant = 0;
        for (int i = 0; i < matrix.length; i++) {
            determinant += Math.pow(-1, i) * matrix[0][i] * calculateDeterminant(createSubMatrix(matrix, 0, i));
        }
        return determinant;
    }

    private double[][] createSubMatrix(double[][] matrix, int excludingRow, int excludingColumn) {
        double[][] subMatrix = new double[matrix.length - 1][matrix.length - 1];
        int r = 0, c = 0;
        for (int i = 0; i < matrix.length; i++) {
            if (i != excludingRow) {
                for (int j = 0; j < matrix.length; j++) {
                    if (j != excludingColumn) {
                        subMatrix[r][c++] = matrix[i][j];
                    }
                }
                r++;
                c = 0;
            }
        }
        return subMatrix;
    }
}
