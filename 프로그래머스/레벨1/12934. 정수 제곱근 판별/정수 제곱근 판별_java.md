# [Lv.1] [정수 제곱근 판별](https://school.programmers.co.kr/learn/courses/30/lessons/12934?language=java) - 12934 

### 구분

코딩테스트 연습 > 연습문제

## Java 문제풀이

```java
class Solution {
    public long solution(long n) {
        double x = Math.sqrt(n);
        return (x == Math.floor(x)) ? (long) Math.pow(x + 1, 2) : -1;
    }
}
```

### 성능 요약

1. 시간: 0.36 ms, 메모리: 76.8 MB

2. 시간: 0.35 ms, 메모리: 79.4 MB
3. 시간: 0.34 ms, 메모리: 78.1 MB
4. 시간: 0.34 ms, 메모리: 75 MB
5. 시간: 0.34 ms, 메모리: 71.6 MB

### 제출 일자

2024년 11월 01일 (금) 21:51

> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges