# [Lv.0] [등차수열의 특정한 항만 더하기](https://school.programmers.co.kr/learn/courses/30/lessons/181931?language=java) - 181931 

### 구분

코딩테스트 연습 > 코딩 기초 트레이닝

## Java 문제풀이

```java
import java.util.stream.IntStream;
class Solution {
    public int solution(int a, int d, boolean[] included) {
        return IntStream.range(0, included.length)
            .filter(i -> included[i])
            .map(i -> a + i*d)
            .sum();
    }
}
```

### 성능 요약

1. 시간: 2.97 ms, 메모리: 74.5 MB

2. 시간: 2.83 ms, 메모리: 76.3 MB
3. 시간: 2.81 ms, 메모리: 76.9 MB
4. 시간: 2.73 ms, 메모리: 81.5 MB
5. 시간: 2.73 ms, 메모리: 74.7 MB

### 제출 일자

2024년 10월 18일 (금) 09:14

> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges