# [Lv.2] [숫자 변환하기](https://school.programmers.co.kr/learn/courses/30/lessons/154538?language=java) - 154538 

### 구분

코딩테스트 연습 > 연습문제

## Java 문제풀이

```java
import java.util.Map;
import java.util.HashMap;
import java.util.Queue;
import java.util.LinkedList;

public class Solution {
    public int solution(int x, int y, int n) {
        if (x == y) {
            return 0;
        }

        Map<Integer, Integer> dp = new HashMap<>();
        dp.put(y, 0);
        Queue<Integer> queue = new LinkedList<>();
        queue.add(y);

        while (!queue.isEmpty()) {
            int curr = queue.poll();

            // 종료 조건
            if (curr == x) {
                return dp.get(curr);
            }

            // 역방향 탐색
            int[] prevValues = new int[3];
            int index = 0;

            if (curr - n >= x) {
                prevValues[index++] = curr - n;
            }
            if (curr % 2 == 0) {
                prevValues[index++] = curr / 2;
            }
            if (curr % 3 == 0) {
                prevValues[index++] = curr / 3;
            }

            // DP에 추가
            for (int i = 0; i < index; i++) {
                int prev = prevValues[i];
                if (!dp.containsKey(prev)) {
                    dp.put(prev, dp.get(curr) + 1);
                    queue.add(prev);
                }
            }
        }

        return -1;
    }
}
```

### 성능 요약

1. 시간: 6.29 ms, 메모리: 91.3 MB

2. 시간: 1.96 ms, 메모리: 82.8 MB
3. 시간: 1.46 ms, 메모리: 88.9 MB
4. 시간: 1.44 ms, 메모리: 90 MB
5. 시간: 1.18 ms, 메모리: 75.6 MB

### 제출 일자

2024년 11월 27일 (수) 23:56

> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges