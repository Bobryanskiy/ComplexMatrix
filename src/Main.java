public class Main {
    public static void main(String[] args) {
        ComplexMatrix test = new ComplexMatrix(4, 4);
        test.setMatrix(0, 0, new ComplexNumber(-2,1 ));
        test.setMatrix(0, 1, new ComplexNumber(1, 3));
        test.setMatrix(0, 2, new ComplexNumber(3, -4));
        test.setMatrix(0, 3, new ComplexNumber(2, 5));
        test.setMatrix(1, 0, new ComplexNumber(3, 6));
        test.setMatrix(1, 1, new ComplexNumber(0, 8));
        test.setMatrix(1, 2, new ComplexNumber(-1, -2));
        test.setMatrix(1, 3, new ComplexNumber(2, 0));
        test.setMatrix(2, 0, new ComplexNumber(-5, 1));
        test.setMatrix(2, 1, new ComplexNumber(2, -1));
        test.setMatrix(2, 2, new ComplexNumber(3, 9));
        test.setMatrix(2, 3, new ComplexNumber(0, -7));
        test.setMatrix(3, 0, new ComplexNumber(4, 5));
        test.setMatrix(3, 1, new ComplexNumber(-1, -4));
        test.setMatrix(3, 2, new ComplexNumber(2, 2));
        test.setMatrix(3, 3, new ComplexNumber(-3, 3));

        test.printMatrix();

        System.out.println();

        test.determinant().printNumber();

        System.out.println();

        ComplexMatrix a = new ComplexMatrix(2, 2);
        ComplexMatrix b = new ComplexMatrix(2, 2);
        a.init();
        b.init();
        System.out.println("a:");
        a.printMatrix();
        System.out.println("b:");
        b.printMatrix();
        System.out.println("a + b:");
        a.sum(b).printMatrix();
        System.out.println("a * b:");
        a.multiply(b).printMatrix();
        System.out.println("transpose a:");
        a.transpose();
        a.printMatrix();
        ComplexMatrix aa = a.copy();
        a.transpose();
        System.out.println("a + transpose a");
        aa.sum(a).printMatrix();
    }
}
