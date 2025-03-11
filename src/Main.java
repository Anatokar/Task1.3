import java.io.*;
import java.util.List;

public class Main {
    private static final StringBuilder log = new StringBuilder();

    public static void main(String[] args) {
        String basePath = "C:\\Users\\Анатолий\\IdeaProjects\\TheBestJavaDeveloper\\Games";

        List<String> directories = List.of(
                basePath + "\\src", basePath + "\\res", basePath + "\\saveGames", basePath + "\\temp",
                basePath + "\\src\\main", basePath + "\\src\\test",
                basePath + "\\res\\drawables", basePath + "\\res\\vectors", basePath + "\\res\\icons"
        );

        List<String> files = List.of(
                basePath + "\\src\\main\\Main.java", basePath + "\\src\\main\\Utils.java",
                basePath + "\\temp\\temp.txt"
        );

        createDirectories(directories);
        createFiles(files);
        writeLogToFile(basePath + "\\temp\\temp.txt");

        // Task 2
        GameProgress game1 = new GameProgress(60, 1, 3, 32.1);
        GameProgress game2 = new GameProgress(100, 2, 5, 12.0);
        GameProgress game3 = new GameProgress(40, 1, 1, 13.1);

        List<String> saveFiles = List.of(
                basePath + "\\saveGames\\save1.dat",
                basePath + "\\saveGames\\save2.dat",
                basePath + "\\saveGames\\save3.dat"
        );

        GameProgress.saveGame(saveFiles.get(0), game1);
        GameProgress.saveGame(saveFiles.get(1), game2);
        GameProgress.saveGame(saveFiles.get(2), game3);

        GameProgress.zipFiles(basePath + "\\saveGames\\zip.zip", saveFiles);

        // Task 3
        GameProgress.openZip(basePath + "\\saveGames\\zip.zip", basePath + "\\saveGames");
        for (String file : saveFiles) {
            System.out.println(GameProgress.openProgress(file));
        }
    }

    private static void createDirectories(List<String> directories) {
        for (String path : directories) {
            File dir = new File(path);
            if (dir.mkdir()) {
                log.append("Каталог ").append(dir.getName()).append(" успешно создан.\n");
            }
        }
    }

    private static void createFiles(List<String> files) {
        for (String path : files) {
            File file = new File(path);
            try {
                if (file.createNewFile()) {
                    log.append("Файл ").append(file.getName()).append(" успешно создан.\n");
                }
            } catch (IOException e) {
                log.append("Ошибка при создании файла ").append(file.getName()).append(": ").append(e.getMessage()).append("\n");
            }
        }
    }

    private static void writeLogToFile(String logFilePath) {
        try (FileWriter writer = new FileWriter(logFilePath)) {
            writer.write(log.toString());
            writer.flush();
        } catch (IOException e) {
            System.out.println("Ошибка при записи лога: " + e.getMessage());
        }
    }
}
