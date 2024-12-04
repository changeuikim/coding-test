import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        List<String> numbersList = new ArrayList<>();
        for (int number : numbers) {
            numbersList.add(String.valueOf(number));
        }
        
        Collections.sort(numbersList, (x, y) -> (y + x).compareTo(x + y));
        
        String result = String.join("", numbersList);
        
        return result.charAt(0) == '0' ? "0" : result;
    }
}