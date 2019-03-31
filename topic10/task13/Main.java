package topic10.task13;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {

        MainLogic logic = new MainLogic();

        outAnswers(readFile());
    }

    private static List<String> readFile() throws IOException {
        return Files.readAllLines(Paths.get(MainLogic.getPathToOutputFile()));
    }

    private static void outAnswers(List<String> answers) {
        for (String answer : answers) {
            System.out.println(answer);
        }
    }
}
