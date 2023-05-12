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
            comparison++;

            while(j >= 0 && text.charAt(i + j) == pattern.charAt(j)){
                if (j <= 0){
                    matchIndexes.add(i);
                }
                comparison++;
                j--;
            }
            i += getShiftSize(text, pattern, i, badSymbolTable, lengthOfPattern);
        }

        return matchIndexes;
    }

    int getShiftSize(String text, String pattern, int i, Map<Character, Integer> badSymbolTable, int lengthOfPattern){

        char lastChar = text.charAt(i + lengthOfPattern - 1);
        int shiftSize = badSymbolTable.getOrDefault(lastChar, lengthOfPattern); // if key doesn't exist in map, get lengthOfPattern

        return shiftSize;
    }


}
