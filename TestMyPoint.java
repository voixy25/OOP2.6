// TestMyPoint.java
public class TestMyPoint {
    public static void main(String[] args) {
        MyPoint p1 = new MyPoint();  // Test constructor
        System.out.println(p1.toString());      // Test toString()

        p1.setX(8);   // Test setters
        p1.setY(6);
        System.out.println("x is: " + p1.getX());  // Test getters
        System.out.println("y is: " + p1.getY());

        p1.setXY(3, 0);   // Test setXY()
        System.out.println(p1.getXY()[0]);  // Test getXY()
        System.out.println(p1.getXY()[1]);
        System.out.println(p1);

        MyPoint p2 = new MyPoint(0, 4);  // Test another constructor
        System.out.println(p2);

        // Testing the overloaded methods distance()
        System.out.println(p1.distance(p2));    // distance(MyPoint)
        System.out.println(p2.distance(p1));    // distance(MyPoint)
        System.out.println(p1.distance(5, 6));  // distance(int, int)
        System.out.println(p1.distance());      // distance() to origin

        // Allocating 10 points in an array
        MyPoint[] points = new MyPoint[10];
        for (int i = 0; i < points.length; i++) {
            points[i] = new MyPoint(i + 1, i + 1);
        }

        // Print all the points
        for (MyPoint point : points) {
            System.out.println(point);
        }
    }
}

// MyPoint.java
class MyPoint {
    private int x;
    private int y;

    // No-arg constructor
    public MyPoint() {
        this.x = 0;
        this.y = 0;
    }

    // Constructor with parameters
    public MyPoint(int x, int y) {
        this.x = x;
        this.y = y;
    }

    // Getter and Setter for x
    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    // Getter and Setter for y
    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    // Set both x and y
    public void setXY(int x, int y) {
        this.x = x;
        this.y = y;
    }

    // Get both x and y
    public int[] getXY() {
        return new int[]{x, y};
    }

    // toString
    @Override
    public String toString() {
        return "(" + x + ", " + y + ")";
    }

    // distance to given x, y
    public double distance(int x, int y) {
        int xDiff = this.x - x;
        int yDiff = this.y - y;
        return Math.sqrt(xDiff * xDiff + yDiff * yDiff);
    }

    // distance to another MyPoint
    public double distance(MyPoint another) {
        return distance(another.x, another.y);
    }

    // distance to origin
    public double distance() {
        return distance(0, 0);
    }
}
