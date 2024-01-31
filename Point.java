
import java.util.Objects;

public class Point {
    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public Vector calcVectorTo(Point p) {
        double dx = p.x - this.x;
        double dy = p.y - this.y;

        return new Vector(dx, dy);
    }

    public Point move(Vector v) {
        return new Point(this.x + v.getX(), this.y + v.getY());
    }

    @Override
    public String toString() {
        return String.format("(%.2f, %.2f)", this.x, this.y);
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || !(o instanceof Point)) {
            return false;
        }

        Point that = (Point) o;

        return this.x == that.x && this.y == that.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.x, this.y);
    }

    private double x;
    private double y;
}
