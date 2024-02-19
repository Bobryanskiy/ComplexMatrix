import java.util.Random;
import java.util.Stack;

public class ComplexMatrix {
    private boolean isTransparent;
    private final int rows, columns;
    private final ComplexNumber[][] matrix;

    public ComplexMatrix() {
        this.isTransparent = false;
        this.rows = 0;
        this.columns = 0;
        this.matrix = new ComplexNumber[0][0];
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
                this.matrix[i][j] = new ComplexNumber(random.nextInt(-10, 11), random.nextInt(-10, 11));
            }
        }
    }

    public void transpose() {
        this.isTransparent = !this.isTransparent;
    }

    public void printMatrix() {
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
                    newM.matrix[j][i] = new ComplexNumber(this.matrix[j][i].getA(), this.matrix[j][i].getB());
                }
            }
        } else {
            for (int i = 0; i < rows; ++i) {
                for (int j = 0; j < columns; ++j) {
                    newM.matrix[i][j] = new ComplexNumber(this.matrix[i][j].getA(), this.matrix[i][j].getB());
                }
            }
        }
        return newM;
    }

    public ComplexMatrix sum(ComplexMatrix matrix) {
        int r1, r2, c1, c2;
        if (this.isTransparent) {
            r1 = this.columns;
            c1 = this.rows;
        } else {
            r1 = this.rows;
            c1 = this.columns;
        }
        if (matrix.isTransparent) {
            r2 = matrix.columns;
            c2 = matrix.rows;
        } else {
            r2 = matrix.rows;
            c2 = matrix.columns;
        }

        if (r1 != r2 || c1 != c2) {
            System.out.println("Sizes are not equal");
            return null;
        }
        ComplexMatrix newM = new ComplexMatrix(r1, c1);
        for (int i = 0; i < r1; ++i) {
            for (int j = 0; j < c1; ++j) {
                newM.matrix[i][j] = (this.isTransparent ? this.matrix[j][i] : this.matrix[i][j]).sum(matrix.isTransparent ? matrix.matrix[j][i] : matrix.matrix[i][j]);
            }
        }
        return newM;
    }

    public ComplexMatrix multiply(ComplexMatrix matrix) {
        int r2, c1, c2;
        if (this.isTransparent) {
            c1 = this.rows;
        } else {
            c1 = this.columns;
        }
        if (matrix.isTransparent) {
            r2 = matrix.columns;
            c2 = matrix.rows;
        } else {
            r2 = matrix.rows;
            c2 = matrix.columns;
        }
        if (c1 != r2) {
            System.out.println("Sizes are not equal");
            return null;
        }
        ComplexMatrix newM = new ComplexMatrix(r2, c2);
        ComplexNumber num;
        for (int i = 0; i < r2; ++i) {
            for (int j = 0; j < c2; ++j) {
                num = new ComplexNumber();
                for (int k = 0; k < r2; ++k) {
                    num = num.sum((this.isTransparent ? this.matrix[k][i] : this.matrix[i][k]).multiply(matrix.isTransparent ? matrix.matrix[j][k] : matrix.matrix[k][j]));
                }
                newM.matrix[i][j] = num;
            }
        }
        return newM;
    }

    public ComplexNumber determinant() {
        if (this.columns != this.rows) {
            System.out.println("rows != columns");
            return null;
        }
        return determinantStep(0, new Stack<>());
    }

    private ComplexNumber determinantStep(int i, Stack<Integer> stack) {
        if (this.rows - 1 == i) {
            for (int j = 0; j < this.columns; ++j) {
                if (!stack.contains(j)) {
                    return this.matrix[i][j];
                }
            }
        }
        ComplexNumber answer = new ComplexNumber();
        int count = 0;
        for (int k = 0; k < this.columns; ++k) {
            if (stack.contains(k)) continue;
            stack.push(k);
            answer = answer.sum(determinantStep(i + 1, stack).multiply(this.matrix[i][k]).multiply(count % 2 == 0 ? new ComplexNumber(1) : new ComplexNumber(-1)));
            stack.pop();
            count++;
        }
        return answer;
    }

    public int getRows() {
        return rows;
    }

    public int getColumns() {
        return columns;
    }

    public ComplexNumber getMatrix(int i, int j) {
        return matrix[i][j];
    }

    public void setMatrix(int i, int j, ComplexNumber num) {
        matrix[i][j] = num;
    }

    public boolean isTransparent() {
        return isTransparent;
    }
}
