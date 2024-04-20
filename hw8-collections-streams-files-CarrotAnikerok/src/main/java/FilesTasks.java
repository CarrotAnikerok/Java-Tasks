import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Scanner;

public class FilesTasks {

    public static int readInt(String message) {
        System.out.println(message);
        Scanner scan = new Scanner(System.in);
        int numb = 0;

        try {
            numb = may(scan);
            return numb;
        } catch (IOException e) {
            System.out.println("it is not a number, try again");
            numb = readInt(message);
        }
        return numb;
    }

    private static int may(Scanner scan) throws IOException {
        if (!scan.hasNextInt()) {
            throw new IOException();
        }
        return scan.nextInt();
    }

    public static void renameFiles(List<String> filePaths) {
        int i = 1;
        try {
            for (String path : filePaths) {
                Path myFile = Path.of(path);
                Path name = myFile.getFileName();
                Files.move(myFile, myFile.resolveSibling(i + "_" + name));
                i += 1;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
