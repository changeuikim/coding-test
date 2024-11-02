# [Lv.1] [수박수박수박수박수박수?](https://school.programmers.co.kr/learn/courses/30/lessons/12922?language=java) - 12922 

### 구분

코딩테스트 연습 > 연습문제

## Java 문제풀이

```java
class Solution {
    public String solution(int n) {
        return "수박".repeat(n / 2) + "수".repeat(n & 1);
    }
}
```

### 성능 요약

1. 시간: 1.86 ms, 메모리: 82.7 MB

2. 시간: 1.84 ms, 메모리: 75.6 MB
3. 시간: 1.64 ms, 메모리: 70.9 MB
4. 시간: 1.60 ms, 메모리: 73.2 MB
5. 시간: 1.60 ms, 메모리: 72.2 MB

### 제출 일자

2024년 11월 02일 (토) 21:50

> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges