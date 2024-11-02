# [Lv.1] [가운데 글자 가져오기](https://school.programmers.co.kr/learn/courses/30/lessons/12903?language=java) - 12903 

### 구분

코딩테스트 연습 > 연습문제

## Java 문제풀이

```java
class Solution {
    public String solution(String s) {
        int n = s.length();
        int start = (n - 1) / 2;
        int end = n / 2 + 1;
        return s.substring(start, end);
    }
}
```

### 성능 요약

1. 시간: 0.03 ms, 메모리: 74.3 MB

2. 시간: 0.03 ms, 메모리: 73.7 MB
3. 시간: 0.03 ms, 메모리: 72.5 MB
4. 시간: 0.02 ms, 메모리: 80.9 MB
5. 시간: 0.02 ms, 메모리: 78 MB

### 제출 일자

2024년 11월 02일 (토) 21:34

> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges