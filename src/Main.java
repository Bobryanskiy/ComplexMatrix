import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        ComplexMatrix f = new ComplexMatrix(2, 3);
        f.init();
        f.transpose();
        ComplexMatrix d = f.copy();
        f.transpose();
        f.printMatrix();
        d.printMatrix();


        ComplexMatrix test = new ComplexMatrix(4, 4);
        test.setMatrix(0, 0, new ComplexNumber(-2));
        test.setMatrix(0, 1, new ComplexNumber(1));
        test.setMatrix(0, 2, new ComplexNumber(3));
        test.setMatrix(0, 3, new ComplexNumber(2));
        test.setMatrix(1, 0, new ComplexNumber(3));
        test.setMatrix(1, 1, new ComplexNumber(0));
        test.setMatrix(1, 2, new ComplexNumber(-1));
        test.setMatrix(1, 3, new ComplexNumber(2));
        test.setMatrix(2, 0, new ComplexNumber(-5));
        test.setMatrix(2, 1, new ComplexNumber(2));
        test.setMatrix(2, 2, new ComplexNumber(3));
        test.setMatrix(2, 3, new ComplexNumber(0));
        test.setMatrix(3, 0, new ComplexNumber(4));
        test.setMatrix(3, 1, new ComplexNumber(-1));
        test.setMatrix(3, 2, new ComplexNumber(2));
        test.setMatrix(3, 3, new ComplexNumber(-3));
        System.out.println();
        test.printMatrix();
        System.out.println();
        ComplexMatrixMath.determinant(test, 0, new Stack<>()).printNumber();
        System.out.println();
        System.out.println();

        ComplexMatrix aa = new ComplexMatrix(2, 2);
        aa.setMatrix(0, 0, new ComplexNumber(-2));
        aa.setMatrix(0, 1, new ComplexNumber(1));
        aa.setMatrix(1, 0, new ComplexNumber(5));
        aa.setMatrix(1, 1, new ComplexNumber(4));
        ComplexMatrix bb = new ComplexMatrix(2, 1);
        bb.setMatrix(0, 0, new ComplexNumber(3));
        bb.setMatrix(1, 0, new ComplexNumber(-1));
        aa.printMatrix();
        bb.printMatrix();
        ComplexMatrix kr = ComplexMatrixMath.multiply(aa, bb);
        kr.printMatrix();

        ComplexMatrix a = new ComplexMatrix(3, 3);
        a.setMatrix(0, 0, new ComplexNumber(5));
        a.setMatrix(0, 1, new ComplexNumber(8));
        a.setMatrix(0, 2, new ComplexNumber(-4));
        a.setMatrix(1, 0, new ComplexNumber(6));
        a.setMatrix(1, 1, new ComplexNumber(9));
        a.setMatrix(1, 2, new ComplexNumber(-5));
        a.setMatrix(2, 0, new ComplexNumber(4));
        a.setMatrix(2, 1, new ComplexNumber(7));
        a.setMatrix(2, 2, new ComplexNumber(-3));
        a.printMatrix();
        ComplexMatrix b = new ComplexMatrix(1, 3);
        b.setMatrix(0, 0, new ComplexNumber(2));
        b.setMatrix(0, 1, new ComplexNumber(-3));
        b.setMatrix(0, 2, new ComplexNumber(1));
        b.printMatrix();
        b.transpose();
        System.out.println();
        ComplexMatrixMath.multiply(a, b).printMatrix();

        System.out.println();
        System.out.println();
        ComplexMatrix t = new ComplexMatrix(3, 3);
        t.setMatrix(0, 0, new ComplexNumber(5));
        t.setMatrix(0, 1, new ComplexNumber(8));
        t.setMatrix(0, 2, new ComplexNumber(-4));
        t.setMatrix(1, 0, new ComplexNumber(6));
        t.setMatrix(1, 1, new ComplexNumber(9));
        t.setMatrix(1, 2, new ComplexNumber(-5));
        t.setMatrix(2, 0, new ComplexNumber(4));
        t.setMatrix(2, 1, new ComplexNumber(7));
        t.setMatrix(2, 2, new ComplexNumber(-3));
        t.printMatrix();
        System.out.println();
        ComplexMatrix t2 = new ComplexMatrix(3, 3);
        t2.setMatrix(0, 0, new ComplexNumber(3));
        t2.setMatrix(0, 1, new ComplexNumber(2));
        t2.setMatrix(0, 2, new ComplexNumber(5));
        t2.setMatrix(1, 0, new ComplexNumber(4));
        t2.setMatrix(1, 1, new ComplexNumber(-1));
        t2.setMatrix(1, 2, new ComplexNumber(3));
        t2.setMatrix(2, 0, new ComplexNumber(9));
        t2.setMatrix(2, 1, new ComplexNumber(6));
        t2.setMatrix(2, 2, new ComplexNumber(5));
        t2.printMatrix();
        System.out.println();
        ComplexMatrixMath.multiply(t, t2).printMatrix();

        f.init();
        f.printMatrix();
        f.transpose();
        f.printMatrix();
        ComplexNumbersMath.sum(1, new ComplexNumber());
        System.out.println();
        System.out.println();
        ComplexMatrix k = new ComplexMatrix(2, 2);
        ComplexMatrix l = new ComplexMatrix(2, 2);
//        k.init();
//        l.init();
        k.setMatrix(0, 0, new ComplexNumber(12));
        k.setMatrix(0, 1, new ComplexNumber(-1));
        k.setMatrix(1, 0, new ComplexNumber(-5));
        k.setMatrix(1, 1, new ComplexNumber(0));

        l.setMatrix(0, 0, new ComplexNumber(-4));
        l.setMatrix(0, 1, new ComplexNumber(-3));
        l.setMatrix(1, 0, new ComplexNumber(15));
        l.setMatrix(1, 1, new ComplexNumber(7));
        ComplexMatrix kl = ComplexMatrixMath.sum(k, l);
        k.printMatrix();
        l.printMatrix();
        if (kl != null) {
            kl.printMatrix();
        }
        l.transpose();
        l.printMatrix();
        kl = ComplexMatrixMath.sum(k, l);
        kl.printMatrix();
    }
}
