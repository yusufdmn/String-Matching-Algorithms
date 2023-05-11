import java.util.ArrayList;
import java.util.Map;


public class Bayer_Moore_Algorithm extends Algorithm{


    public ArrayList<Integer> applyBoyerMoore(String text,String pattern){

        comparison =0;

        ArrayList<Integer> list = new ArrayList<>();

        //iterate all characters of text String
        for(int i = 0 ; i<=text.length()-pattern.length(); i++ ){

            //pattern alignment on the text
            int beginIndexOfPatternAtText = i;
            int endIndexOfPatternAtText = i+pattern.length()-1;
            int numOfMatches = 0;

            //traverse pattern right to left
            innerLoop:
            for(int _k = pattern.length()-1, l=0; _k>=0;_k--,l++ ){
                comparison++;//to get efficiency
                if(pattern.charAt(_k)==text.charAt(endIndexOfPatternAtText-l)){
                    numOfMatches++;
                }else{
                    break innerLoop;
                }
            }

            int shift =0;
            if(numOfMatches==pattern.length()){
                list.add(i);
                shift = pattern.length();
            }else{
                shift = getShiftSize(pattern,text.charAt(endIndexOfPatternAtText-numOfMatches),numOfMatches);

            }

            //-1 i zaten bura bitince arttıracak nötrlesin diye koydum
            i+=shift-1;

        }


        return list;
    }


    //k represents # of succesfull character match
    private static int getShiftSize(String pattern,char firstMismatch,int k){
        int shiftSize = 0;

        Map<Integer,Integer> goodSuffixTable = Helper.getGoodSuffixTable(pattern);
        Map<Character,Integer> badSymbolTable = Helper.getBadSymbolTable(pattern);

        int t_1 = 0;

        if(badSymbolTable.containsKey(firstMismatch)){
            t_1 = badSymbolTable.get(firstMismatch);
        }else{
            t_1 = pattern.length();
        }

        int d1 = Math.max(t_1-k,1);

        int d2 =0;

        if(k>=1&&k<=pattern.length()-1){
            d2 = goodSuffixTable.get(k);
        }else{
            return d1;
        }

        shiftSize = Math.max(d1,d2);

        return shiftSize;

    }



}
