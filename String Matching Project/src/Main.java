import javax.imageio.metadata.IIOMetadataNode;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        ArrayList<Integer> matchIndexes = new ArrayList<>();


        for (int i = 0; i < 3; i++){
            String text = InputData.readTheText(InputData.fileNames[i]);
            String pattern = InputData.patterns[i];

            Helper.printTables(pattern);

            testBruteForce(matchIndexes, pattern, text);
            testHorspool(matchIndexes, pattern, text);
            testBoyerMoore(matchIndexes,pattern, text);
            System.out.println();
        }



    }

    static void testBruteForce(ArrayList<Integer> matchIndexes, String pattern, String text){

        System.out.println("BRUTE FORCE");

        BruteForce bruteForce = new BruteForce();
        bruteForce.startTiming();

        int lengthOfPattern = pattern.length();

        matchIndexes = bruteForce.applyBruteForce(text, pattern);
        String textHighlighted = bruteForce.highligthText(text, matchIndexes, lengthOfPattern);
        //InputData.writeInFile(InputData.fileB, textHighlighted);
        System.out.println("Comparison: " + bruteForce.comparison);
        System.out.println("Matched words: " + matchIndexes.size());

        bruteForce.stopTiming();
    }

    static void testHorspool(ArrayList<Integer> matchIndexes, String pattern, String text){

        System.out.println("\nHORSPOOL ");

        Horspool horspool = new Horspool();
        horspool.startTiming();

        int lengthOfPattern = pattern.length();

        matchIndexes = horspool.applyHorspool(text, pattern);
        String textHighlighted = horspool.highligthText(text, matchIndexes, lengthOfPattern);
        //InputData.writeInFile(InputData.fileH, textHighlighted);
        System.out.println("Comparison: " + horspool.comparison);
        System.out.println("Matched words: " + matchIndexes.size());

        horspool.stopTiming();
    }

    static void testBoyerMoore(ArrayList<Integer> matchIndexes, String pattern, String text){

        System.out.println("\nBOYER MOORE");

        Bayer_Moore_Algorithm bayerMooreAlgorithm = new Bayer_Moore_Algorithm();
        bayerMooreAlgorithm.startTiming();

        int lengthOfPattern = pattern.length();

        matchIndexes = bayerMooreAlgorithm.applyBoyerMoore(text, pattern);
        String textHighlighted = bayerMooreAlgorithm.highligthText(text, matchIndexes, lengthOfPattern);
        //InputData.writeInFile(InputData.fileM, textHighlighted);
        System.out.println("Comparison: " + bayerMooreAlgorithm.comparison);
        System.out.println("Matched words: " + matchIndexes.size());

        bayerMooreAlgorithm.stopTiming();
    }


}
