# [Lv.1] [완주하지 못한 선수](https://school.programmers.co.kr/learn/courses/30/lessons/42576?language=java) - 42576 

### 구분

코딩테스트 연습 > 해시

## Java 문제풀이

```java
import java.util.Map;
import java.util.HashMap;

public class Solution {
    public String solution(String[] participant, String[] completion) {
        Map<String, Integer> hashMap = new HashMap<>();

        for (String p : participant) {
            hashMap.put(p, hashMap.getOrDefault(p, 0) + 1);
        }

        for (String c : completion) {
            hashMap.put(c, hashMap.get(c) - 1);
        }

        for (String key : hashMap.keySet()) {
            if (hashMap.get(key) == 1) {
                return key;
            }
        }

        return "";
    }
}
```

### 성능 요약

1. 시간: 100.19 ms, 메모리: 97 MB

2. 시간: 84.33 ms, 메모리: 97.5 MB
3. 시간: 74.68 ms, 메모리: 97.1 MB
4. 시간: 64.59 ms, 메모리: 89.9 MB
5. 시간: 37.04 ms, 메모리: 83.7 MB

### 제출 일자

2024년 11월 29일 (금) 23:58

> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges