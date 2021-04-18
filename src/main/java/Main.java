
public class Main {
    public static void main(String[] args) {
        if (args.length != 3) {
            throw new IllegalArgumentException("Expected three parameters");
        }

        String inputPath = args[0];
        String outputPath = args[1];
        int fieldIndex = Integer.parseInt(args[2]);

        ReadFileService readFileService = new ReadFileServiceImpl();
        readFileService.sortFile(inputPath, outputPath, fieldIndex);
    }
}
