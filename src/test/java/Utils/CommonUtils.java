package Utils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class CommonUtils {
    public static String  readJsonFile(String filePath) throws IOException {
        return new String(Files.readAllBytes(Paths.get(filePath)));
    }
}
