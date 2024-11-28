# [Lv.1] [대충 만든 자판](https://school.programmers.co.kr/learn/courses/30/lessons/160586?language=java) - 160586 

### 구분

코딩테스트 연습 > 연습문제

## Java 문제풀이

```java
import java.util.Map;
import java.util.HashMap;

public class Solution {
    public static int[] solution(String[] keymap, String[] targets) {
        // 키 사전 생성
        Map<Character, Integer> keyMap = new HashMap<>();

        for (String key : keymap) {
            for (int idx = 0; idx < key.length(); idx++) {
                char ch = key.charAt(idx);
                keyMap.put(ch, Math.min(keyMap.getOrDefault(ch, Integer.MAX_VALUE), idx + 1));
            }
        }

        // 결과 처리
        int[] result = new int[targets.length];
        
        for (int i = 0; i < targets.length; i++) {
            String target = targets[i];
            int acc = 0;
            for (char ch : target.toCharArray()) {
                if (!keyMap.containsKey(ch)) {
                    acc = -1;
                    break;
                }
                acc += keyMap.get(ch);
            }
            result[i] = acc;
        }

        return result;
    }
}
```

### 성능 요약

1. 시간: 4.42 ms, 메모리: 79.4 MB

2. 시간: 4.08 ms, 메모리: 74.9 MB
3. 시간: 3.59 ms, 메모리: 80.1 MB
4. 시간: 3.12 ms, 메모리: 85.3 MB
5. 시간: 3.01 ms, 메모리: 89.1 MB

### 제출 일자

2024년 11월 28일 (목) 23:53

> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges