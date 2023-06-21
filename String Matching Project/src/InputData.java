import java.io.*;

public class InputData {

    public static String[] fileNames = {
            "sample.html",
            "bit1.html",
            "bit2.html",
            "bit3.html",
            "text1.html",
            "text2.html",
            "text3.html"
    };
    public static String[] patterns = {"AT_THAT", "0111010", "01111111111111100000000000000000000000000000111111111"
            , "01000", "text", "Ottoman Empire", "content"};

    public static String text = "";

    public static String readTheText(String fileName){
        try {
            String path = System.getProperty("user.dir") + "/";
            File file = new File(path + fileName);

            // Read the contents of the file into a string
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line = "";
            StringBuilder content = new StringBuilder();
            while ((line = reader.readLine()) != null) {
                content.append(line);
            }
            reader.close();
            return content.toString();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public  static void writeInFile(String fileName, String output){
        try {
            String path = System.getProperty("user.dir") + "/";
            File file = new File(path + fileName);

            BufferedWriter writer = new BufferedWriter(new FileWriter(file));
            writer.write(output);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}