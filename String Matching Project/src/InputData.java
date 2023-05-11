import java.io.*;

public class InputData {

    public static File fileB = new File("textB.html");
    public static File fileH = new File("textH.html");
    public static File fileM = new File("textM.html");
    public static String pattern = "class";
    public static String text = "";

    public static String readTheText(File file){

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

    public  static void writeInFile(File file, String output){
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(file));
            writer.write(output);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}