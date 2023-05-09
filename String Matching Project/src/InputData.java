import java.io.*;

public class InputData {

    public static File file = new File("text.html");
    public static String pattern = "togg";
    public static String text = "";

    public static String ReadTheText(File file){

        try {
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

    public  static void WriteInFile(File file, String output){
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(file));
            writer.write(output);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}