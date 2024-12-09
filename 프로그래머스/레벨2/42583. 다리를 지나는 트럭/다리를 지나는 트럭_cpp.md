# [Lv.2] [다리를 지나는 트럭](https://programmers.co.kr/) - 42583 

### 구분

코딩테스트 연습 > 스택／큐

## C++ 문제풀이

```cpp
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
```

### 성능 요약

1. 시간: 0.71 ms, 메모리: 3.68 MB

2. 시간: 0.21 ms, 메모리: 4.21 MB
3. 시간: 0.12 ms, 메모리: 3.72 MB
4. 시간: 0.07 ms, 메모리: 3.67 MB
5. 시간: 0.04 ms, 메모리: 4.13 MB

### 제출 일자

2024년 12월 09일 (월) 23:00

> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges