import java.util.*;

public class BruteForce extends Algorithm{

    public ArrayList<Integer> applyBruteForce(String text, String pattern){
        comparison = 0;
        int lengthOfText = text.length();
        int lengthOfPattern = pattern.length();

        ArrayList<Integer> matchIndexes = new ArrayList<>();
        for (int i = 0; i <= lengthOfText - lengthOfPattern; i++){
            int j = 0;
            comparison++;
            while(j < lengthOfPattern && pattern.charAt(j) == text.charAt(i + j)){
                j++;
                if(j == lengthOfPattern){
                    matchIndexes.add(i);
                }
                comparison++;
            }
        }
        return matchIndexes;
    }
}