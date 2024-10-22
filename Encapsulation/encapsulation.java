class Encapsulation {
    public static void main(String[] args) {
        encaps p = new encaps(10, 20);

        System.out.println(p.getPoint());
    }
}

class encaps {
    int x;
    int y;

    encaps(int x, int y) {
        this.y = y;
        this.x = x;
    }

    int getPoint() {
        return this.x;
    }
}