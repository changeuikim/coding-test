# [Lv.0] [수 조작하기 1](https://school.programmers.co.kr/learn/courses/30/lessons/181926?language=java) - 181926 

### 구분

코딩테스트 연습 > 코딩 기초 트레이닝

## Java 문제풀이

```java
import java.util.Map;
import java.util.HashMap;

class Solution {
    public int solution(int n, String control) {
        Map<Character, Integer> ops = new HashMap<>();
        ops.put('w', 1);
        ops.put('s', -1);
        ops.put('d', 10);
        ops.put('a', -10);
        
        for (char key : control.toCharArray()) {
            n += ops.get(key);
        }
        
        return n;
    }
}
```

### 성능 요약

1. 시간: 12.28 ms, 메모리: 86.8 MB

2. 시간: 10.26 ms, 메모리: 81.9 MB
3. 시간: 9.25 ms, 메모리: 79.2 MB
4. 시간: 8.87 ms, 메모리: 73.4 MB
5. 시간: 8.18 ms, 메모리: 92.1 MB

### 제출 일자

2024년 10월 19일 (토) 21:13

> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges