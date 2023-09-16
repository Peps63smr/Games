import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        StringBuilder log = new StringBuilder();

        String mainPath = "F://Games";

        String[] dirs = {
                mainPath,
                mainPath + "/src",
                mainPath + "/res",
                mainPath + "/savegames",
                mainPath + "/temp",
                mainPath + "/src/main",
                mainPath + "/src/test",
                mainPath + "/res/drawables",
                mainPath + "/res/vectors",
                mainPath + "/res/icons",
        };

        for (String dir : dirs) {
            File file = new File(dir);
            if (file.mkdir()) {
                log.append("Директория создана: ").append(dir).append("\n");
            } else {
                log.append("Директория не создана: ").append(dir).append("\n");
            }
        }


        String[] files = {
                mainPath + "/src/main/Main.java",
                mainPath + "/src/main/Utils.java",
                mainPath + "/temp/temp.txt",
        };

        for (String fileStr : files) {
            File file = new File(fileStr);
            try {
                if (file.createNewFile()) {
                    log.append("Файл создан: ").append(fileStr).append("\n");
                } else {
                    log.append("Файл не создан: ").append(fileStr).append("\n");
                }
            } catch (IOException e) {
                log.append(e.getMessage()).append(fileStr).append("\n").append(e.getMessage()).append("\n");
            }
        }

        try (FileWriter writer = new FileWriter(mainPath + "/temp/temp.txt")) {
            writer.write(log.toString());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}