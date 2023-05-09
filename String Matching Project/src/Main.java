import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        BruteForce bruteForce = new BruteForce();
        bruteForce.StartTiming();

        ArrayList<Integer> matchIndexes;
        String pattern = InputData.pattern;
        String text;

        text = InputData.ReadTheText(InputData.file);
        int lengthOfText = text.length();
        int lengthOfPattern = pattern.length();

        matchIndexes = bruteForce.ApplyBruteForce(text, lengthOfText, lengthOfPattern, pattern);
        String textHighlighted = bruteForce.HighligthText(text, matchIndexes, lengthOfPattern);

        System.out.println("pattern length: " + lengthOfPattern);
        System.out.println("text length: " + lengthOfText);
        System.out.println("Matched words: " + matchIndexes.size());

        //InputData.WriteInFile(InputData.file, textHighlighted.toString());
        //InputData.WriteInFile(InputData.file, "<HTML><BODY>0010010010010</BODY></HTML>");


        System.out.println("Comparison: " + bruteForce.comparison);
        bruteForce.StopTiming();
    }
}
