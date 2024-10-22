class Abstract {
    public static void main(String[] args) {
        poly1 p = new poly3();
        int x = 1;
        p.test(x);
        p.test(2, 3);

    }
}

// abstraction class
abstract class poly1 {

    // protected must have an inhertance
    protected int x;
    protected int y;

    // abstraction method
    abstract public int numberOfPloyPoints();

    void setX(int x) {
        this.x = x;
    }

    void setY(int y) {
        this.y = y;
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

class poly3 extends poly1 {

    int z;

    @Override
    public int numberOfPloyPoints() {
        return 3;
    }

    @Override
    public void test(int x, int y) {
        super.setX(z);

        this.z = y;
        System.out.println("warning x now = 0, and then z now = y");

        System.out.println(super.x);

    }

    @Override
    public String toString() {
        return String.valueOf(super.x);
    }
}