# [Lv.1] [내적](https://school.programmers.co.kr/learn/courses/30/lessons/70128?language=java) - 70128 

### 구분

코딩테스트 연습 > 월간 코드 챌린지 시즌1

## Java 문제풀이

```java
import java.util.stream.IntStream;

class Solution {
    public int solution(int[] a, int[] b) {        
        return IntStream.range(0, a.length)
                        .map(i -> a[i] * b[i])
                        .sum();
    }
}
```

### 성능 요약

1. 시간: 2.23 ms, 메모리: 81.5 MB

2. 시간: 2.08 ms, 메모리: 74.5 MB
3. 시간: 1.95 ms, 메모리: 76.3 MB
4. 시간: 1.94 ms, 메모리: 75.6 MB
5. 시간: 1.85 ms, 메모리: 75.4 MB

### 제출 일자

2024년 11월 02일 (토) 21:16

> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges