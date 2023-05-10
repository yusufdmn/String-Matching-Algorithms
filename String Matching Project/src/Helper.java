import java.util.HashMap;
import java.util.Map;

//selam aleyküm
public class Helper {


    public static void main(String[] args) {
        String pattern = "LAMALAMAL";

        Map<Character,Integer> map = getBadSymbolTable(pattern);

        System.out.println("For pattern \""+pattern+"\"");
        System.out.println("Bad Symbol Table");
        System.out.println(map);
        System.out.println("Good Suffix Table");
        System.out.println(getGoodSuffixTable(pattern));


    }

    //Good Suffix Table returns Map<k,shift size>
    public static Map<Integer,Integer> getGoodSuffixTable(String pattern){

        Map<Integer,Integer> map = new HashMap<>();



        //iterate # of character match
        outerLoop:
        for(int k=1;k<=pattern.length()-1;k++){
            int preceedingIndex = pattern.length()-k-1;
            char preceeding = pattern.charAt(preceedingIndex);
            String match = pattern.substring(preceedingIndex+1);

            //iterate preceeding part of the pattern
            for(int i= preceedingIndex;i>=0;i--){
                char preOfCheck= 59999;//if check part is at the beginning
                if(i!=0){
                    preOfCheck = pattern.charAt(i-1);
                }
                String check = pattern.substring(i,i+k);

                if (check.equals(match)&&preOfCheck!=preceeding){
                    map.put(k,preceedingIndex+1-i);
                    continue outerLoop;
                }

            }
            //partial match control
            for(int j = preceedingIndex+2;j<=pattern.length()-1;j++){
                String partialCheckStr = pattern.substring(j);
                if(pattern.startsWith(partialCheckStr)){
                    map.put(k,j);
                    continue outerLoop;
                }
            }
            //else
            map.put(k,pattern.length());

        }



        return map;

    }


    //could be used as Hoorspol's shift table or Boyer Moore's bas symbol table
    //For other characters that are not included in the map shift pattern.length times
    public static Map<Character,Integer> getBadSymbolTable(String pattern){

        Map<Character,Integer> map = new HashMap<>();
        if(pattern.length()==0){
            return map;
        }

        //convert pattern to char array
        char eachChar[] = pattern.toCharArray();


        //iterate pattern right to left
        for(int i = eachChar.length-2;i>=0;i--){
            if(!map.containsKey(eachChar[i])){
                map.put(eachChar[i],(eachChar.length-1-i));
            }
        }

        //check last element
        if(!map.containsKey(eachChar[eachChar.length-1])){
            map.put(eachChar[eachChar.length-1],(eachChar.length));
        }


        return map;
    }





}
