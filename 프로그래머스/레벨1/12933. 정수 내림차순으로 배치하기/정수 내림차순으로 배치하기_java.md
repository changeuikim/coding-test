# [Lv.1] [정수 내림차순으로 배치하기](https://school.programmers.co.kr/learn/courses/30/lessons/12933?language=java) - 12933 

### 구분

코딩테스트 연습 > 연습문제

## Java 문제풀이

```java
import java.util.Arrays;
import java.util.Collections;

class Solution {
    public long solution(long n) {
        String[] digits = String.valueOf(n).split("");
        Arrays.sort(digits, Collections.reverseOrder());
        
        StringBuilder sb = new StringBuilder();
        for (String digit : digits) {
            sb.append(digit);
        }
        
        return Long.parseLong(sb.toString());
    }
}
```

### 성능 요약

1. 시간: 0.78 ms, 메모리: 75.6 MB

2. 시간: 0.59 ms, 메모리: 74.3 MB
3. 시간: 0.57 ms, 메모리: 73.5 MB
4. 시간: 0.57 ms, 메모리: 68.6 MB
5. 시간: 0.56 ms, 메모리: 68.4 MB

### 제출 일자

2024년 11월 01일 (금) 21:21

> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges