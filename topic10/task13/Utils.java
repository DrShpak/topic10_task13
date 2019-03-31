package topic10.task13;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

class Utils {

    List<String> readFile() throws IOException {
        return Files.readAllLines(Paths.get("/Users/test/Documents/Java programmes/Михаил Тихомиров/topic10_task13/src/topic10/task13/input.txt"));
    }

    ArrayList<Triangle> createTrianglesList(List<String> list) {
        ArrayList<Triangle> triangles = new ArrayList<>();
        for (String string : list) {
            Triangle triangle = createTriangle(createStringArray(croppingRow(string)));
            if (triangle != null) {
                triangles.add(triangle);
            }
        }
        return triangles;
    }

    private Triangle createTriangle(String[] stringArray) {
        Point[] points = new Point[3];
        for (int i = 0; i < stringArray.length; i++) {
            points[i] = createNewPoint(createStringPoint(stringArray[i]));
        }

        if (!isItTriangle(points)) {
            return new Triangle(points[0], points[1], points[2]);
        } else {
            return null;
        }
    }

    private boolean isItTriangle(Point[] points) {
        return (points[0].getX() == points[1].getX() & points[1].getX() == points[2].getX() & points[0].getX() == points[2].getX())
                | (points[0].getY() == points[1].getY() & points[1].getY() == points[2].getY() & points[0].getY() == points[2].getY());

    }

    private String croppingRow(String string) {
        return string.substring(string.indexOf("{") + 1, string.indexOf("}"));
    }

    private String[] createStringArray(String string) {
        return string.split(" ");
    }

    private Point createNewPoint(String[] stringPointArray) {
        double x = Double.parseDouble(stringPointArray[0]);
        double y = Double.parseDouble(stringPointArray[1]);
        return new Point(x, y);
    }

    private String[] createStringPoint(String stringPoint) {
        return stringPoint.split(";");
    }

    int returnPart(Point point) {
        if (point.getX() > 0 & point.getY() > 0) {
            return 1;
        } else if (point.getX() < 0 & point.getY() > 0) {
            return 2;
        } else if (point.getX() < 0 & point.getY() < 0) {
            return 3;
        } else if (point.getX() > 0 & point.getY() < 0) {
            return 4;
        } else {
            return 0;
        }
    }

    int returnIndex(Triangle triangle, ArrayList<Triangle> triangles) {
        int index = 0;
        for (int i = 0; i < triangles.size(); i++) {
            if (triangle.equals(triangles.get(i))) {
                index = i;
                break;
            }
        }
        return index + 1;
    }

    //запись в файл
    void writeInFile(ArrayList<Triangle> answers, ArrayList<Integer> numbersOfValidTriangles) {
        File file = new File("output.txt");
        MainLogic.setPathToOutputFile(file.getAbsolutePath());  // присваеваем путь к файлу в котором хранятся ответы
        int i = 0;
        try {
            PrintWriter printWriter = new PrintWriter(file);
            for (Triangle triangle : answers) {
                printWriter.println("Triangle" + numbersOfValidTriangles.get(i) + " -> " + triangle);
                i++;
            }
            printWriter.close();
        } catch (FileNotFoundException e) {
            System.out.println("Writing in file has been failed!");
        }
    }
}