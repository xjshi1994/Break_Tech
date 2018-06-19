public class Main {
    public static void main(String[] args) {
        String inputPath = "src/main/resources/Test.csv";
        String ouputPath = "src/main/resources/output.csv";
        String charset = "UTF-8";
        int[] display = {1,2,3};
        int[] key = {0};
        CSVOperations csvOperations = new CSVOperations(inputPath, ouputPath, charset);
        csvOperations.removeDup(display, key);
    }
}
