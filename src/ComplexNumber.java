public class ComplexNumber {
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

    public void printNumber() {
        if (a == 0) {
            if (b != 1 && b != -1) System.out.print(b);
            if (b != 0) System.out.print("i");
            System.out.print(" ");
        } else {
            System.out.print(a + " ");
            if (b > 0) {
                System.out.print("+ ");
                if (b != 1) System.out.print(b);
            } else if (b < 0) {
                System.out.print("- ");
                if (b != -1) System.out.print(-b);
            }
            if (b != 0)
                System.out.print("i ");
        }
    }

    public ComplexNumber sum(ComplexNumber num) {
        return new ComplexNumber(this.a + num.a, this.b + num.b);
    }

    public ComplexNumber sub(ComplexNumber num) {
        return new ComplexNumber(this.a - num.a, this.b - num.b);
    }

    public ComplexNumber multiply(ComplexNumber num) {
        return new ComplexNumber(this.a * num.a - this.b * num.b, this.b * num.a + this.a * num.b);
    }

    public ComplexNumber divide(ComplexNumber num) {
        int i = num.a * num.a + num.b * num.b;
        return new ComplexNumber((this.a * num.a + this.b * num.b) / i, (this.b * num.a - this.a * num.b) / i);
    }

    public int getA() {
        return a;
    }

    public int getB() {
        return b;
    }
}
