# [Lv.1] [숫자 짝꿍](https://school.programmers.co.kr/learn/courses/30/lessons/131128?language=java) - 131128 

### 구분

코딩테스트 연습 > 연습문제

## Java 문제풀이

```java
import java.util.Map;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public String solution(String X, String Y) {
        // X, Y의 Map
        Map<Character, Integer> xMap = new HashMap<>();
        Map<Character, Integer> yMap = new HashMap<>();

        for (int i = 0; i < X.length(); i++) {
            char key = X.charAt(i);
            xMap.put(key, xMap.getOrDefault(key, 0) + 1);
        }

        for (int i = 0; i < Y.length(); i++) {
            char key = Y.charAt(i);
            yMap.put(key, yMap.getOrDefault(key, 0) + 1);
        }

        // X, Y의 교집합 키
        List<Character> rKeys = new ArrayList<>();
        for (char i = '9'; i >= '0'; i--) {
            if (xMap.containsKey(i) && yMap.containsKey(i)) {
                rKeys.add(i);
            }
        }

        // 조기 반환
        if (rKeys.isEmpty()) {
            return "-1";
        } else if (rKeys.get(0) == '0') {
            return "0";
        }

        // 결과 반환
        StringBuilder result = new StringBuilder();
        for (char key : rKeys) {
            int count = Math.min(xMap.get(key), yMap.get(key));
            String keyString = String.valueOf(key);
            result.append(keyString.repeat(count));
        }

        return result.toString();
    }
}
```

### 성능 요약

1. 시간: 210.02 ms, 메모리: 158 MB

2. 시간: 200.94 ms, 메모리: 176 MB
3. 시간: 189.36 ms, 메모리: 173 MB
4. 시간: 170.80 ms, 메모리: 161 MB
5. 시간: 159.76 ms, 메모리: 177 MB

### 제출 일자

2024년 12월 01일 (일) 23:08

> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges