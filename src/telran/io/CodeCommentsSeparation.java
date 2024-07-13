package telran.io;

import java.io.*;

public class CodeCommentsSeparation {

    public static void main(String[] args) {
        if (args.length < 3) {
            throw new IllegalArgumentException("Not enough arguments provided. At least 3 arguments are required.");
        }
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(args[0]));
             BufferedWriter fileWithCode = new BufferedWriter(new FileWriter(args[1]));
             BufferedWriter fileWithComments = new BufferedWriter(new FileWriter(args[2]))) {
            while (bufferedReader.ready()) {
                String str = bufferedReader.readLine();
                if (str.trim().startsWith("//")) {
                    fileWithComments.write(str + "\n");
                } else {
                    fileWithCode.write(str + "\n");
                }
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}