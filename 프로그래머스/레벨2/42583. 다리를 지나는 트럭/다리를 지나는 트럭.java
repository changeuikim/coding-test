import java.util.Queue;
import java.util.LinkedList;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        Queue<Integer> bridge = new LinkedList<>();
        int totalWeight = 0;        
        int time = 0;
        
        for (int i = 0; i < bridge_length; i++) {
            bridge.add(0);
        }        
        
        for (int truck : truck_weights) {
            while (true) {
                time++;
                totalWeight -= bridge.poll();

                if (totalWeight + truck <= weight) {
                    bridge.add(truck);
                    totalWeight += truck;
                    break;
                } else {
                    bridge.add(0);
                }
            }
        }

        return time + bridge_length;
    }
}