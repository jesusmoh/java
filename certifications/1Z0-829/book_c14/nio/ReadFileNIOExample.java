
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ReadFileNIOExample {
    public static void main(String[] args) throws IOException {
        Path path = Paths.get("example.txt");
        byte[] data = Files.readAllBytes(path);
        System.out.println(new String(data));
    }
}
