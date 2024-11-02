# [Lv.1] [문자열 내림차순으로 배치하기](https://school.programmers.co.kr/learn/courses/30/lessons/12917?language=java) - 12917 

### 구분

코딩테스트 연습 > 연습문제

## Java 문제풀이

```java
import java.util.stream.Stream;
import java.util.Comparator;
import java.util.stream.Collectors;

class Solution {
    public String solution(String s) {
        return Stream.of(s.split(""))
                    .sorted(Comparator.reverseOrder())
                    .collect(Collectors.joining());    
    }
}
```

### 성능 요약

1. 시간: 5.92 ms, 메모리: 73.3 MB

2. 시간: 5.90 ms, 메모리: 80.4 MB
3. 시간: 5.35 ms, 메모리: 82 MB
4. 시간: 4.87 ms, 메모리: 72.7 MB
5. 시간: 2.87 ms, 메모리: 73.4 MB

### 제출 일자

2024년 11월 02일 (토) 22:41

> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges