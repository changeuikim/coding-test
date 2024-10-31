# [Lv.1] [x만큼 간격이 있는 n개의 숫자](https://school.programmers.co.kr/learn/courses/30/lessons/12954?language=java) - 12954 

### 구분

코딩테스트 연습 > 연습문제

## Java 문제풀이

```java
import java.util.stream.LongStream;

class Solution {
    public long[] solution(int x, int n) {
        return LongStream.range(0, n)
            .map(i -> (long) x * (1 + i))
            .toArray();
    }
}
```

### 성능 요약

1. 시간: 6.80 ms, 메모리: 88.3 MB

2. 시간: 5.82 ms, 메모리: 81.7 MB
3. 시간: 5.11 ms, 메모리: 74.4 MB
4. 시간: 4.47 ms, 메모리: 73.6 MB
5. 시간: 4.10 ms, 메모리: 80.2 MB

### 제출 일자

2024년 10월 31일 (목) 20:37

> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges