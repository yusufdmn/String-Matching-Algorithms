import java.util.ArrayList;
import java.util.Map;

public class Horspool extends Algorithm{


    public ArrayList<Integer> applyHorspool(String text, String pattern){

        int lengthOfText = text.length();
        int lengthOfPattern = pattern.length();
        ArrayList<Integer> matchIndexes = new ArrayList<>();

        Map<Character, Integer> badSymbolTable =  Helper.badSymbolTable;

        int i = 0;
        while (i <= lengthOfText - lengthOfPattern){
            int j = lengthOfPattern - 1;
            boolean isFullMatch = false;
            comparison++;

            while(j >= 0 && text.charAt(i + j) == pattern.charAt(j)){
                if (j <= 0){
                    matchIndexes.add(i);
                    isFullMatch = true;
                }
                comparison++;
                j--;
            }
            i += getShiftSize(isFullMatch, text, pattern, i, badSymbolTable);
        }

        return matchIndexes;
    }

    int getShiftSize(boolean isFullMatch, String text, String pattern, int i, Map<Character, Integer> badSymbolTable){
        int shiftSize = 0;

        int lengthOfPattern = pattern.length();

        char lastCharOfPattern = text.charAt(i + lengthOfPattern - 1);
        shiftSize = badSymbolTable.getOrDefault(lastCharOfPattern, lengthOfPattern); // if key doesn't exist in map, get lengthOfPattern

        return shiftSize;
    }


}
