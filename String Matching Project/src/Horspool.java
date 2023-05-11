import java.util.ArrayList;
import java.util.Map;

public class Horspool extends Algorithm{

    public static void main(String[] args) {

    }

    public ArrayList<Integer> applyHorspool(String text, String pattern){

        int lengthOfText = text.length();
        int lengthOfPattern = pattern.length();
        ArrayList<Integer> matchIndexes = new ArrayList<>();

        int i = 0;
        while (i < lengthOfText - lengthOfPattern){
            int j = lengthOfPattern - 1;
            boolean isFullMatch = false;
            comparison++;

            while(j >= 0 && text.charAt(i + j) == pattern.charAt(j)){
                if (j == 0){
                    matchIndexes.add(i);
                    isFullMatch = true;
                }
                comparison++;
                j--;
            }
            i += getShiftSize(isFullMatch, text, pattern);
        }

        return matchIndexes;
    }

    int getShiftSize(boolean isFullMatch, String text, String pattern){
        int shiftSize = 0;
        Map<Character, Integer> badSymbolTable =  Helper.getBadSymbolTable(pattern);
        int lengthOfText = text.length();
        int lengthOfPattern = pattern.length();

        if (isFullMatch){
            shiftSize = lengthOfPattern;
        }
        else{
            char lastCharOfPattern = pattern.charAt(lengthOfPattern - 1);
            shiftSize = badSymbolTable.getOrDefault(lastCharOfPattern, lengthOfPattern); // if key doesn't exist in map, get lengthOfPattern
        }
        return shiftSize;
    }


}