import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MainTest {

    @Test
    void test() {
        String inputPath = "./sample.txt";
        String outputPath = "./result.txt";
        String fieldIndex = "2";
        String[] args = {inputPath, outputPath, fieldIndex};

        Assertions.assertDoesNotThrow(() -> Main.main(args));
    }
}
