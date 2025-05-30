import Helper.FileReaderHelper;
import java.io.IOException;
import java.nio.file.Path;

import org.junit.Assert;
import org.junit.Test;

public class FileReaderHelperTest {

  @Test(expected = IOException.class)
  public void readFromFileError() throws IOException {
    FileReaderHelper.readFromFile(Path.of(""));

  }

  @Test
  public void readFromFileSuccess() throws IOException {
    String expected = String.join("\n",
            "Lorem",
            "ipsum",
            "dolor",
            "sit",
            "amet,",
            "consectetur",
            "adipiscing",
            "elit."
    );
    String actual = FileReaderHelper.readFromFile(Path.of("src/test/resources/test.txt").toAbsolutePath()).replace("\r\n", "\n").trim();
    Assert.assertEquals(expected,actual);
  }

}
