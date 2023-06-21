import java.util.ArrayList;

abstract class Algorithm {

    long timeOfStart, timeOfEnd;
    long timeOfExecution;
    int comparison;

    public void startTiming(){
        timeOfStart = System.currentTimeMillis();
    }
    public void stopTiming(){
        timeOfEnd = System.currentTimeMillis();
        timeOfExecution = timeOfEnd - timeOfStart;

        System.out.println("Execution Time: " + timeOfExecution);
    }

    public String highligthText(String text, ArrayList<Integer> matchIndexes, int lengthOfPattern){
        StringBuilder textHighlighted = new StringBuilder();
        textHighlighted.append(text);

        for (int index = matchIndexes.size() - 1; index >= 0; index--){

            int overlapCount = 0;
            while(index > 0 && matchIndexes.get(index) - matchIndexes.get(index - 1) < lengthOfPattern){
                overlapCount++;
                index--;
            }

            textHighlighted.insert(matchIndexes.get(index + overlapCount) + lengthOfPattern, "</mark>");
            textHighlighted.insert(matchIndexes.get(index), "<mark>");
        }
        return textHighlighted.toString();
    }

}
