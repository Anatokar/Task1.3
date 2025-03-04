import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        //Task1
        //1
        File games = new File("Games");
        StringBuilder states = new StringBuilder();

        File src = new File(games, "scr");
        File res = new File(games, "res");
        File saveGames = new File(games, "saveGames");
        File temp = new File(games, "temp");

        List<File> gamesFiles = List.of(new File[]{src, res, saveGames, temp});
        for (File file : gamesFiles) {
            if (file.mkdir()) {
                states.append("Каталог ").append(file.getName()).append(" успешно создан.\n");
            }
        }
        //2
        File main = new File(src, "main");
        File test = new File(src, "test");

        List<File> srcFiles = List.of(new File[]{main, test});
        for (File file : srcFiles) {
            if (file.mkdir()) {
                states.append("Каталог ").append(file.getName()).append(" успешно создан.\n");
            }
        }
        //3
        File mainFile1 = new File(main, "Main.java");
        File mainFile2 = new File(main, "Utils.java");

        List<File> mainFiles = List.of(new File[]{mainFile1, mainFile2});
        for (File file : mainFiles) {
            try {
                if (file.createNewFile()) {
                    states.append("Файл ").append(file.getName()).append(" успешно создан.\n");
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        //4
        File drawables = new File(res, "drawables");
        File vectors = new File(res, "vectors");
        File icons = new File(res, "icons");

        List<File> resFiles = List.of(new File[]{drawables, vectors, icons});
        for (File file : resFiles) {
            if (file.mkdir()) {
                states.append("Каталог ").append(file.getName()).append(" успешно создан.\n");
            }
        }
        //5
        File tempFile1 = new File(temp, "temp.txt");
        try {
            if (tempFile1.createNewFile()) {
                states.append("Файл ").append(tempFile1.getName()).append(" успешно создан.\n");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        try (FileWriter writer = new FileWriter(tempFile1)) {
            writer.write(states.toString());
            writer.flush();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        //Task2
        GameProgress game1 = new GameProgress(60, 1, 3, 32.1);
        GameProgress game2 = new GameProgress(100, 2, 5, 12.0);
        GameProgress game3 = new GameProgress(40, 1, 1, 13.1);

        GameProgress.saveGame("C:\\Users\\Анатолий\\IdeaProjects\\TheBestJavaDeveloper\\Games\\saveGames\\save1.dat", game1);
        GameProgress.saveGame("C:\\Users\\Анатолий\\IdeaProjects\\TheBestJavaDeveloper\\Games\\saveGames\\save2.dat", game2);
        GameProgress.saveGame("C:\\Users\\Анатолий\\IdeaProjects\\TheBestJavaDeveloper\\Games\\saveGames\\save3.dat", game3);

        List<String> files = List.of(new String[]{
                "C:\\Users\\Анатолий\\IdeaProjects\\TheBestJavaDeveloper\\Games\\saveGames\\save1.dat",
                "C:\\Users\\Анатолий\\IdeaProjects\\TheBestJavaDeveloper\\Games\\saveGames\\save2.dat",
                "C:\\Users\\Анатолий\\IdeaProjects\\TheBestJavaDeveloper\\Games\\saveGames\\save3.dat"
        });
        GameProgress.zipFiles("C:\\Users\\Анатолий\\IdeaProjects\\TheBestJavaDeveloper\\Games\\saveGames\\zip.zip", files);

        //Task3
        GameProgress.openZip("C:\\Users\\Анатолий\\IdeaProjects\\TheBestJavaDeveloper\\Games\\saveGames\\zip.zip",
                "C:\\Users\\Анатолий\\IdeaProjects\\TheBestJavaDeveloper\\Games\\saveGames");
        for (String file: files) {
            System.out.println(GameProgress.openProgress(file));
        }
    }
}
