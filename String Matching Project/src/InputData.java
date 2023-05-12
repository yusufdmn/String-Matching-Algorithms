import java.io.*;

public class InputData {

    public static String[] fileNames = {"C:\\Users\\ilker\\IdeaProjects\\gitProjects\\String-Matching-Algorithms\\String Matching Project\\bit1.html"
            , "C:\\Users\\ilker\\IdeaProjects\\gitProjects\\String-Matching-Algorithms\\String Matching Project\\bit2.html",
            "C:\\Users\\ilker\\IdeaProjects\\gitProjects\\String-Matching-Algorithms\\String Matching Project\\bit3.html"};

    public static String[] patterns = {"00101010", "010101", "0000"};
    public static String text = "";

    public static String readTheText(String fileName){

        File file = new File(fileName);
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