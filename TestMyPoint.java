// TestMyPoint.java
public class TestMyPoint {
    public static void main(String[] args) {
        // Test konstruktorja
        MyPoint p1 = new MyPoint();
        // Test izpisa
        System.out.println(p1.toString());

        // Test setter metod
        p1.setX(8);
        p1.setY(6);

        // Test getter metod
        System.out.println("x is: " + p1.getX());
        System.out.println("y is: " + p1.getY());

        // Test ostalih setter in getter metod
        p1.setXY(3, 0);   // setter
        System.out.println(p1.getXY()[0]);  // getter
        System.out.println(p1.getXY()[1]);
        System.out.println(p1); // izpis

        // Test drugega konstruktorja
        MyPoint p2 = new MyPoint(0, 4);
        System.out.println(p2); // izpis

        // Test metod distance
        System.out.println(p1.distance(p2));    // distance(MyPoint)     1 -> 2
        System.out.println(p2.distance(p1));    // distance(MyPoint)     2 -> 1
        System.out.println(p1.distance(5, 6));  // distance(int, int)    1 -> tocke
        System.out.println(p1.distance());      // distance()            1 -> izhodisca

        // Kreiranje tabele 10x MyPoint
        MyPoint[] points = new MyPoint[10];
        for (int i = 0; i < points.length; i++) {
            points[i] = new MyPoint(i + 1, i + 1);
        }

        // Izpis vseh tock iz tabele z for each loopom
        for (MyPoint point : points) {
            System.out.println(point);
        }
    }
}

// MyPoint.java
class MyPoint {
    private int x;
    private int y;

    // Konstruktor #1 (brez parametrov)
    public MyPoint() {
        this.x = 0;
        this.y = 0;
    }

    // Konstruktor #2 (s parametri)
    public MyPoint(int x, int y) {
        this.x = x;
        this.y = y;
    }

    // Getterji in setterji
    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setXY(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int[] getXY() {
        return new int[]{x, y};
    }

    // Override metode toString() za izpis
    @Override
    public String toString() {
        return "(" + x + ", " + y + ")";
    }

    // Dolzina od objekta do dolocene tocke
    public double distance(int x, int y) {
        int dx = this.x - x;
        int dy = this.y - y;
        return Math.sqrt(dx * dx + dy * dy);
    }

    // Dolzina od objekta do drugega objekta
    public double distance(MyPoint another) {
        return distance(another.x, another.y); // klic metode distance(int x, int y) znotraj objekta
    }

    // Dolzina od objekta do koordinatnega izhodisca (0, 0)
    public double distance() {
        return distance(0, 0); // klic metode distance(int x, int y) znotraj objekta
    }
}
