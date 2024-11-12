# [Lv.3] [이중우선순위큐](https://school.programmers.co.kr/learn/courses/30/lessons/42628?language=java) - 42628 

### 구분

코딩테스트 연습 > 힙（Heap）

## Java 문제풀이

```java
import java.util.TreeMap;

class Solution {
    public int[] solution(String[] operations) {
        // 레드-블랙 트리 기반의 TreeMap
        TreeMap<Integer, Integer> map = new TreeMap<>();
        
        for (String element : operations) {
            String[] parts = element.split(" ");
            String op = parts[0];
            int val = Integer.parseInt(parts[1]);
            
            // 큐에 주어진 숫자를 삽입합니다.
            if (op.equals("I")) {
                map.put(val, map.getOrDefault(val, 0) + 1);
            } else if (op.equals("D")) {
                if (map.isEmpty()) {
                    continue;
                }                
                // 큐에서 최댓값을 삭제합니다.
                if (val == 1) {
                    int maxVal = map.lastKey();
                    if (map.get(maxVal) == 1) {
                        map.remove(maxVal);
                    } else {
                        map.put(maxVal, map.get(maxVal) - 1);
                    }
                }
                // 큐에서 최솟값을 삭제합니다.
                else if (val == -1) {
                    int minVal = map.firstKey();
                    if (map.get(minVal) == 1) {
                        map.remove(minVal);
                    } else {
                        map.put(minVal, map.get(minVal) - 1);
                    }
                }
            }            
        }
        
        // 결과 반환
        if (map.isEmpty()) {
            return new int[]{0, 0};
        } else {
            return new int[]{map.lastKey(), map.firstKey()};
        }
    }
}
```

### 성능 요약

1. 시간: 95.72 ms, 메모리: 131 MB

2. 시간: 1.41 ms, 메모리: 74.3 MB
3. 시간: 0.43 ms, 메모리: 81.8 MB
4. 시간: 0.41 ms, 메모리: 77.4 MB
5. 시간: 0.37 ms, 메모리: 73 MB

### 제출 일자

2024년 11월 12일 (화) 23:26

> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges