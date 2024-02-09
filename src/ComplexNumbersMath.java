public interface ComplexNumbersMath {
    static ComplexNumber sum(ComplexNumber first, ComplexNumber second) {
        return new ComplexNumber(first.getA() + second.getA(), first.getB() + second.getB());
    }

    static ComplexNumber multiply(ComplexNumber first, ComplexNumber second) {
        return new ComplexNumber(first.getA() * second.getA() - first.getB() * second.getB(), first.getB() * second.getA() + first.getA() * second.getB());
    }

    static ComplexNumber sum(ComplexNumber first, int second) {
        return new ComplexNumber(first.getA() + second, first.getB());
    }

    static ComplexNumber multiply(ComplexNumber first, int second) {
        return new ComplexNumber(first.getA() * second, first.getB() * second);
    }

    static ComplexNumber sum(int first, ComplexNumber second) {
        return new ComplexNumber(first + second.getA(), second.getB());
    }

    static ComplexNumber multiply(int first, ComplexNumber second) {
        return new ComplexNumber(first * second.getA(), first * second.getB());
    }
}
