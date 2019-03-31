package topic10.task13;

import java.io.IOException;
import java.util.ArrayList;

class MainLogic extends Utils {

    private static String pathToOutputFile; //переменная, хранящая путь для файла, в котором лежат ответы
    private ArrayList<Integer> numbersOfValidTriangles = new ArrayList<>();

    MainLogic() throws IOException {
        ArrayList<Triangle> triangles = returnNewTrianglesList(createTrianglesList(readFile()));
        writeInFile(triangles, numbersOfValidTriangles);
    }

    private ArrayList<Triangle> returnNewTrianglesList(ArrayList<Triangle> oldTriangles) {
        ArrayList<Triangle> newTriangles = new ArrayList<>();

        for (Triangle triangle : oldTriangles) {
            if (isItNeedfulTriangle(triangle)) {
                newTriangles.add(triangle);
                numbersOfValidTriangles.add(returnIndex(triangle, oldTriangles));
            }
        }
        return newTriangles;
    }

    private boolean isItNeedfulTriangle(Triangle triangle) {
        int partOfPoint1 = returnPart(triangle.getTopOfTriangle1());
        int partOfPoint2 = returnPart(triangle.getTopOfTriangle2());
        int partOfPoint3 = returnPart(triangle.getTopOfTriangle3());
        return partOfPoint1 == partOfPoint2 & partOfPoint1 == partOfPoint3 & partOfPoint2 == partOfPoint3;
    }

    static String getPathToOutputFile() {
        return pathToOutputFile;
    }

    static void setPathToOutputFile(String pathToOutputFile) {
        MainLogic.pathToOutputFile = pathToOutputFile;
    }
}