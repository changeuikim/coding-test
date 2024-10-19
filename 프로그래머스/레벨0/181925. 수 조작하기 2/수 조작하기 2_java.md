# [Lv.0] [수 조작하기 2](https://school.programmers.co.kr/learn/courses/30/lessons/181925?language=java) - 181925 

### 구분

코딩테스트 연습 > 코딩 기초 트레이닝

## Java 문제풀이

```java
import java.util.Map;
import java.util.HashMap;

class Solution {
    public String solution(int[] numLog) {
        Map<Integer, String> ops = new HashMap<>();
        ops.put(1, "w");
        ops.put(-1, "s");
        ops.put(10, "d");
        ops.put(-10, "a");
        
        StringBuilder controls = new StringBuilder();
        
        for (int i = 0; i < numLog.length - 1; i++) {
            int key = numLog[i + 1] - numLog[i];
            controls.append(ops.get(key));
        }
        
        return controls.toString();
    }
}
```

### 성능 요약

1. 시간: 15.35 ms, 메모리: 85.1 MB

2. 시간: 13.11 ms, 메모리: 75.3 MB
3. 시간: 11.69 ms, 메모리: 84.6 MB
4. 시간: 11.58 ms, 메모리: 85.1 MB
5. 시간: 11.50 ms, 메모리: 97.1 MB

### 제출 일자

2024년 10월 19일 (토) 23:47

> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges