#include <vector>
#include <deque>

using namespace std;

int solution(int bridge_length, int weight, vector<int> truck_weights) {
    deque<int> bridge(bridge_length, 0);
    int totalWeight = 0;
    int time = 0;
    
    for (int truck : truck_weights) {
        while (true) {
            time++;
            totalWeight -= bridge.front();
            bridge.pop_front();

            if (totalWeight + truck <= weight) {
                bridge.push_back(truck);
                totalWeight += truck;
                break;
            } else {
                bridge.push_back(0);
            }
        }
    }

    return time + bridge_length;
}