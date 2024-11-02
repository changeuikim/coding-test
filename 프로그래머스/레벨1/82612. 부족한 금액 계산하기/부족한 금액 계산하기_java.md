# [Lv.1] [부족한 금액 계산하기](https://school.programmers.co.kr/learn/courses/30/lessons/82612?language=java) - 82612 

### 구분

코딩테스트 연습 > 위클리 챌린지

## Java 문제풀이

```java
class Solution {
    public long solution(int price, int money, int count) {
        long cost = (long) price * count * (count + 1) / 2;
        long result = money - cost;
        return Math.max(0, -result);
    }
}
```

### 성능 요약

1. 시간: 0.17 ms, 메모리: 75.6 MB

2. 시간: 0.16 ms, 메모리: 74.7 MB
3. 시간: 0.11 ms, 메모리: 73.3 MB
4. 시간: 0.10 ms, 메모리: 79.3 MB
5. 시간: 0.10 ms, 메모리: 76.2 MB

### 제출 일자

2024년 11월 02일 (토) 22:56

> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges