import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        for (int i = 0; i < InputData.fileNames.length; i++){
            String text = InputData.readTheText(InputData.fileNames[i]);
            String pattern = InputData.patterns[i];

            Helper.printTables(pattern);

            System.out.println();
            testBruteForce(pattern, text, InputData.fileNames[i]);
            testHorspool(pattern, text, InputData.fileNames[i]);
            testBoyerMoore(pattern, text, InputData.fileNames[i]);
            System.out.println("------------------------------------------------");
        }


    }

    static void testBruteForce(String pattern, String text, String fileName){

        System.out.println("BRUTE FORCE");

        BruteForce bruteForce = new BruteForce();
        bruteForce.startTiming();

        int lengthOfPattern = pattern.length();

        ArrayList<Integer> matchIndexes = bruteForce.applyBruteForce(text, pattern);
        String textHighlighted = bruteForce.highligthText(text, matchIndexes, lengthOfPattern);
        InputData.writeInFile(fileName + "Brute_output.html", textHighlighted);
        System.out.println("Comparison: " + bruteForce.comparison);
        System.out.println("Matched words: " + matchIndexes.size());

        bruteForce.stopTiming();
    }

    static void testHorspool(String pattern, String text, String fileName){

        System.out.println("\nHORSPOOL ");

        Horspool horspool = new Horspool();
        horspool.startTiming();

        int lengthOfPattern = pattern.length();

        ArrayList<Integer> matchIndexes = horspool.applyHorspool(text, pattern);
        String textHighlighted = horspool.highligthText(text, matchIndexes, lengthOfPattern);
        InputData.writeInFile(fileName +"Horspool_output.html", textHighlighted);
        System.out.println("Comparison: " + horspool.comparison);
        System.out.println("Matched words: " + matchIndexes.size());

        horspool.stopTiming();
    }

    static void testBoyerMoore(String pattern, String text, String fileName){

        System.out.println("\nBOYER MOORE");

        Bayer_Moore_Algorithm bayerMooreAlgorithm = new Bayer_Moore_Algorithm(text,pattern);
        bayerMooreAlgorithm.startTiming();

        int lengthOfPattern = pattern.length();

        ArrayList<Integer> matchIndexes = bayerMooreAlgorithm.applyBoyerMoore();
        String textHighlighted = bayerMooreAlgorithm.highligthText(text, matchIndexes, lengthOfPattern);
        InputData.writeInFile(fileName +"Boyer_output.html", textHighlighted);
        System.out.println("Comparison: " + bayerMooreAlgorithm.comparison);
        System.out.println("Matched words: " + matchIndexes.size());

        bayerMooreAlgorithm.stopTiming();
    }


}
