import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class ReadFileServiceImpl implements ReadFileService {

    @Override
    public void sortFile(String inputPath, String outputPath, int fieldIndex) {
        List<String> file = Optional.ofNullable(readFile(inputPath)).orElseThrow(NullPointerException::new);
        List<String> sortedList = sort(file, fieldIndex);
        writeFile(outputPath, sortedList);
    }

    private List<String> readFile(String inputPath) {
        try {
            return Files.lines(new File(inputPath).toPath())
                    .map(String::trim)
                    .collect(Collectors.toList());
        } catch (IOException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    private List<String> sort(List<String> list, int fieldIndex) {
        return list.stream().map(line -> line.split(";"))
                .sorted(Comparator.comparing(line -> line[fieldIndex - 1]))
                .map(line -> String.join(";", line))
                .collect(Collectors.toList());
    }

    private void writeFile(String outputPath, List<String> file) {
        try {
            Files.write(Paths.get(outputPath), file);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
