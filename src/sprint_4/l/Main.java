package sprint_4.l;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] arr = reader.readLine().split(" ");
        int substringLength = Integer.parseInt(arr[0]);
        int showCount = Integer.parseInt(arr[1]);
        String value = reader.readLine();

        // Обработка

    }

    class Data {

        public Data(int count, int firstIndex) {
            this.count = count;
            this.firstIndex = firstIndex;
        }

        private int count = 0;
        private int firstIndex = 0;

        public int getCount() {
            return count;
        }

        public void setCount(int count) {
            this.count = count;
        }

        public int getFirstIndex() {
            return firstIndex;
        }

        public void setFirstIndex(int firstIndex) {
            this.firstIndex = firstIndex;
        }
    }
}
