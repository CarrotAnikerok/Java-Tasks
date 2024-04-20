import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class main {
    public static void main(String[] args) throws IOException {
        List<String> list = new ArrayList<>();
        list.add("resources/test_input_1.txt");
        list.add("resources/stop_words.txt");
        FilesTasks.renameFiles(list);
        System.out.println();
    }
}
