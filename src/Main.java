import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
    }

    private static BufferedReader getBufferReaderExample() {
        return new BufferedReader(new InputStreamReader(System.in));
    }

    private static InputStreamReader getInputStreamReaderExample() {
        return new InputStreamReader(System.in);
    }

    private static Scanner getScanner() {
        return new Scanner(new InputStreamReader(System.in));
    }
}