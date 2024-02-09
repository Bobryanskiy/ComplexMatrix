import java.util.Random;

public class ComplexMatrix {
    private boolean isTransparent;
    private final int rows, columns;
    private final ComplexNumber[][] matrix;

    public ComplexMatrix() {
        this.isTransparent = false;
        this.rows = 0;
        this.columns = 0;
        this.matrix = null;
    }

    public ComplexMatrix(int rows, int columns) {
        this.isTransparent = false;
        this.rows = rows;
        this.columns = columns;
        this.matrix = new ComplexNumber[rows][columns];
    }

    public void init() {
        Random random = new Random();
        for (int i = 0; i < rows; ++i) {
            for (int j = 0; j < columns; ++j) {
                assert this.matrix != null;
                this.matrix[i][j] = new ComplexNumber(random.nextInt(-10, 11), random.nextInt(-10, 11));
            }
        }
    }

    public void transpose() {
        this.isTransparent = !this.isTransparent;
    }

    public void printMatrix() {
        if (this.matrix == null || this.matrix[0][0] == null) {
            System.out.println("Initialize matrix");
            return;
        }
        if (this.isTransparent) {
            for (int i = 0; i < columns; ++i) {
                for (int j = 0; j < rows; ++j) {
                    this.matrix[j][i].printNumber();
                }
                System.out.println();
            }
        } else {
            for (int i = 0; i < rows; ++i) {
                for (int j = 0; j < columns; ++j) {
                    this.matrix[i][j].printNumber();
                }
                System.out.println();
            }
        }
    }

    public ComplexMatrix copy() {
        ComplexMatrix newM = new ComplexMatrix(this.rows, this.columns);
        if (this.isTransparent) {
            newM.transpose();
            for (int i = 0; i < columns; ++i) {
                for (int j = 0; j < rows; ++j) {
                    assert newM.matrix != null;
                    assert this.matrix != null;
                    newM.matrix[j][i] = new ComplexNumber(this.matrix[j][i].getA(), this.matrix[j][i].getB());
                }
            }
        } else {
            for (int i = 0; i < rows; ++i) {
                for (int j = 0; j < columns; ++j) {
                    assert newM.matrix != null;
                    assert this.matrix != null;
                    newM.matrix[i][j] = new ComplexNumber(this.matrix[i][j].getA(), this.matrix[i][j].getB());
                }
            }
        }
        return newM;
    }

    public int getRows() {
        return rows;
    }

    public int getColumns() {
        return columns;
    }

    public ComplexNumber getMatrix(int i, int j) {
        if (matrix != null)
            return matrix[i][j];
        return null;
    }

    public void setMatrix(int i, int j, ComplexNumber num) {
        if (matrix != null)
            matrix[i][j] = num;
    }

    public boolean isTransparent() {
        return isTransparent;
    }
}
