import java.util.ArrayList;

abstract class Algorithm {

    long timeOfStart, timeOfEnd;
    long timeOfExecution;
    int comparison;

    public void StartTiming(){
        timeOfStart = System.currentTimeMillis();
        System.out.println("Time Of Start: " + timeOfStart + "\n");
    }
    public void StopTiming(){
        timeOfEnd = System.currentTimeMillis();
        timeOfExecution = timeOfEnd - timeOfStart;
        System.out.println("\nTime Of End: " + timeOfEnd);
        System.out.println("Execution Time: " + timeOfExecution);
    }

    public String HighligthText(String text, ArrayList<Integer> matchIndexes, int lengthOfPattern){
        StringBuilder textHighlighted = new StringBuilder();
        textHighlighted.append(text);

        for (int index = matchIndexes.size()-1; index >= 0; index--){
            textHighlighted.insert(matchIndexes.get(index) + lengthOfPattern, "</mark>");
            textHighlighted.insert(matchIndexes.get(index), "<mark>");
        }
        return textHighlighted.toString();
    }

}
