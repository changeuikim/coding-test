# [Lv.1] [문자열 다루기 기본](https://school.programmers.co.kr/learn/courses/30/lessons/12918?language=java) - 12918 

### 구분

코딩테스트 연습 > 연습문제

## Java 문제풀이

```java
import java.util.regex.Pattern;

class Solution {
    public boolean solution(String s) {
        return Pattern.matches("^\\d{4}$|^\\d{6}$", s);
    }
}
```

### 성능 요약

1. 시간: 0.19 ms, 메모리: 76 MB

2. 시간: 0.18 ms, 메모리: 69.7 MB
3. 시간: 0.17 ms, 메모리: 73.8 MB
4. 시간: 0.16 ms, 메모리: 77.4 MB
5. 시간: 0.16 ms, 메모리: 75 MB

### 제출 일자

2024년 11월 03일 (일) 21:09

> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges