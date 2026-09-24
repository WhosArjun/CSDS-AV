public class RecursionWorksheet {

    public static void main(String[] args) {

        RecursionWorksheet rw = new RecursionWorksheet();

        int v[] = {1, 2, 3, 4, 5};

        rw.printRecur(v);

        System.out.println(rw.sumRecur(v));

        rw.printReverse(v);

        System.out.println(rw.found(v, 3));

        rw.pattern(5);

        rw.pattern1(1);
    }

    public void printRecur(int v[]) {
        printRecur(v, 0);
    }

    private void printRecur(int v[], int index) {
        if (index < v.length) {
            System.out.println(v[index]);
            printRecur(v, index + 1);
        }
    }

    public int sumRecur(int v[]) {
        return sumRecur(v, 0);
    }

    private int sumRecur(int v[], int index) {
        if (index == v.length) {
            return 0;
        }
        else {
            return v[index] + sumRecur(v, index + 1);
        }
    }

    public void printReverse(int v[]) {
        printReverse(v, 0);
    }

    private void printReverse(int v[], int index) {
        if (index < v.length) {
            printReverse(v, index + 1);
            System.out.println(v[index]);
        }
    }

    public boolean found(int v[], int target) {
        return found(v, target, 0);
    }

    private boolean found(int v[], int target, int index) {
        if (index == v.length) {
            return false;
        }
        else if (v[index] == target) {
            return true;
        }
        else {
            return found(v, target, index + 1);
        }
    }

    public void pattern(int n) {
        if (n > 0) {
            for (int i = 0; i < n; i++) {
                System.out.print("#");
            }

            System.out.println();

            pattern(n - 1);
        }
    }

    public void pattern1(int n) {
        if (n <= 5) {
            for (int i = 0; i < n; i++) {
                System.out.print("#");
            }

            System.out.println();

            pattern1(n + 1);
        }
    }
}