public class ComplexNumber {
//    private static final int i = -1;
    // a + bi, i^2 = -1
    private final int a, b;

    ComplexNumber() {
        this.a = 0;
        this.b = 0;
    }

    ComplexNumber(int a) {
        this.a = a;
        this.b = 0;
    }

    ComplexNumber(int a, int b) {
        this.a = a;
        this.b = b;
    }

    public int getA() {
        return a;
    }

    public int getB() {
        return b;
    }
}
