public interface ComplexMatrixMath {
    static ComplexMatrix sum(ComplexMatrix first, ComplexMatrix second) {
        if (first.getMatrix(0, 0) == null || second.getMatrix(0, 0) == null) {
            System.out.println("Initialize matrix");
            return null;
        }
        int r1, r2, c1, c2;
        if (first.isTransparent()) {
            r1 = first.getColumns();
            c1 = first.getRows();
        } else {
            r1 = first.getRows();
            c1 = first.getColumns();
        }
        if (second.isTransparent()) {
            r2 = second.getColumns();
            c2 = second.getRows();
        } else {
            r2 = second.getRows();
            c2 = second.getColumns();
        }

        if (r1 != r2 || c1 != c2) {
            System.out.println("Sizes are not equal");
            return null;
        }
        ComplexMatrix newM = new ComplexMatrix(r1, c1);
        for (int i = 0; i < r1; ++i) {
            for (int j = 0; j < c1; ++j) {
                newM.setMatrix(i, j, ComplexNumbersMath.sum(first.isTransparent() ? first.getMatrix(j, i) : first.getMatrix(i, j), second.isTransparent() ? second.getMatrix(j, i) : second.getMatrix(i, j)));
            }
        }
        return newM;
    }
    static ComplexMatrix multiply(ComplexMatrix first, ComplexMatrix second) {
        if (first.getMatrix(0, 0) == null || second.getMatrix(0, 0) == null) {
            System.out.println("Initialize matrix");
            return null;
        }
        int r2, c1, c2;
        if (first.isTransparent()) {
            c1 = first.getRows();
        } else {
            c1 = first.getColumns();
        }
        if (second.isTransparent()) {
            r2 = second.getColumns();
            c2 = second.getRows();
        } else {
            r2 = second.getRows();
            c2 = second.getColumns();
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
                    num = ComplexNumbersMath.sum(num, ComplexNumbersMath.multiply(first.isTransparent() ? first.getMatrix(k, i) : first.getMatrix(i, k), second.isTransparent() ? second.getMatrix(j, k) : second.getMatrix(k, j)));
                }
                newM.setMatrix(i, j, num);
            }
        }
        return newM;
    }
}
