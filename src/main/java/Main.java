import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
        public static void main(String[] args) throws IOException {

            String path = "D:\\test\\test.txt";
            String newPath = "D:\\test\\newTest.txt";

            File file = new File(path);
            File newFile = new File(newPath);

            sortFile(file, newFile);
        }


        public static File sortFile(File file, File newFile) throws IOException {
            List<String> arr = new ArrayList<>();

            try (BufferedReader br = new BufferedReader(new FileReader(file));) {
                String st;
                while ((st = br.readLine()) != null) {
                    arr.add(st);
                }
            }

            Collections.sort(arr, new StringComparator());

            try (BufferedWriter bf = new BufferedWriter(new FileWriter(newFile));) {
                for (String s : arr) {
                    bf.write(s + "\n");
                }
            }

            return newFile;
        }
    }