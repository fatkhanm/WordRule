
import Helper.FileReaderHelper;
import Rule.WordRule;
import RulesImpl.CountWordStartWithUppercase;
import RulesImpl.MoreThanFiveCharRule;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;
import java.util.stream.Collectors;

public class main {
  public static final String testPackage = "src/testcase/";
  public static void main(String[] args) {
    if (args.length == 0) {
      System.out.println("there is no file provided");
      return;
    }
    Map<String, String> documentMap = new HashMap<>();

    // read the file
    for (String fileName : args) {
      Path filePath = Path.of(testPackage +  fileName).toAbsolutePath();
      if (Files.exists(filePath)) {
          try {
              String doc = FileReaderHelper.readFromFile(filePath);
              documentMap.put(fileName, doc);
          } catch (IOException e) {
            System.out.println(e.getMessage());
              throw new RuntimeException(e);
          }
      } else {
        System.err.println("File not found or is not a regular file: " + filePath);
      }
    }
    if (documentMap.isEmpty()) {
      System.out.println("there is no file provided");
      return;
    }
    WordRule startWithUpper = new CountWordStartWithUppercase();
    WordRule haveGreaterThan5 = new MoreThanFiveCharRule();

    documentMap.forEach((key, value) -> {
      List<String> splitWords = Optional.of(Arrays
              .asList(value.split("\\W+")))
              .orElse(new ArrayList<>());

      List<String> result1 = splitWords
              .stream()
              .filter(haveGreaterThan5::rule)
              .collect(Collectors.toList());

      long result2 = splitWords
              .stream()
              .filter(startWithUpper::rule)
              .count();

      // print word greater that 5 char
      System.out.print(key + ": ");
      result1.forEach(System.out::println);
      System.out.print(" \n");

      // print word result
      System.out.println(key + ": " + result2);
    });
  }
}
