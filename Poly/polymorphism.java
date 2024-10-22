class Main {
    public static void main(String[] args) {
        poly p = new poly2();

        p.test(1);
        p.test(2, 3);
        p.getX();
        System.out.println(p);
    }
}

class poly {

    int x;

    void setX(int x) {
        this.x = x;
    }

    void getX() {
        System.out.println("x = " + this.x);
    }

    // Overload
    void test(int x, int y) {
        System.out.println("" + x + ' ' + y);
    }

    // Overload
    void test(int x) {
        System.out.println(x);
    }
}

class poly2 extends poly {

    int z;

    @Override
    public void test(int x, int y) {
        super.setX(z);

        this.z = y;
        System.out.println("warning x now = 0, and then z now = y");
    }
}