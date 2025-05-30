package Helper;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.FileReader;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileReaderHelper {

  public static String readFromFile(Path filePath) throws IOException {
    try {
      return Files.readString(filePath);
    }catch (IOException e){
      throw e;
    }
  }
}
