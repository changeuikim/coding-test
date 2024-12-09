# [Lv.2] [다리를 지나는 트럭](https://programmers.co.kr/) - 42583 

### 구분

코딩테스트 연습 > 스택／큐

## Java 문제풀이

```java
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
```

### 성능 요약

1. 시간: 24.66 ms, 메모리: 91.2 MB

2. 시간: 10.67 ms, 메모리: 82.9 MB
3. 시간: 7.38 ms, 메모리: 80 MB
4. 시간: 5.17 ms, 메모리: 96.8 MB
5. 시간: 1.89 ms, 메모리: 88.9 MB

### 제출 일자

2024년 12월 09일 (월) 22:59

> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges