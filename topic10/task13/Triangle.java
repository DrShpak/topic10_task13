package topic10.task13;

import java.util.Objects;

public class Triangle {

    private Point topOfTriangle1;
    private Point topOfTriangle2;
    private Point topOfTriangle3;

    Triangle(Point topOfTriangle1, Point topOfTriangle2, Point topOfTriangle3) {
        this.topOfTriangle1 = topOfTriangle1;
        this.topOfTriangle2 = topOfTriangle2;
        this.topOfTriangle3 = topOfTriangle3;
    }

    Point getTopOfTriangle1() {
        return topOfTriangle1;
    }

    Point getTopOfTriangle2() {
        return topOfTriangle2;
    }

    Point getTopOfTriangle3() {
        return topOfTriangle3;
    }

    @Override
    public String toString() {
        return "triangle " + "(" + topOfTriangle1 + ") " + "(" + topOfTriangle2 + ") " + "(" + topOfTriangle3 + ")";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Triangle)) return false;
        Triangle triangle = (Triangle) o;
        return Objects.equals(topOfTriangle1, triangle.topOfTriangle1) &&
                Objects.equals(topOfTriangle2, triangle.topOfTriangle2) &&
                Objects.equals(topOfTriangle3, triangle.topOfTriangle3);
    }
}
