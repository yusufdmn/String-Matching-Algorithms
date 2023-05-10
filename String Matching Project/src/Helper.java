import java.util.HashMap;
import java.util.Map;

//selam aleyküm
public class Helper {


    public static void main(String[] args) {
        String pattern = "CANAB";

        Map<Character,Integer> map = getBadSymbolTable(pattern);

        System.out.println(map);
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
