# [Lv.0] [공배수](https://school.programmers.co.kr/learn/courses/30/lessons/181936?language=java) - 181936 

### 구분

코딩테스트 연습 > 코딩 기초 트레이닝

## Java 문제풀이

```java
class Solution {
    public int solution(int number, int n, int m) {
        return (number % n == 0) && (number % m == 0) ? 1 : 0;
    }
}
```

### 성능 요약

1. 시간: 0.03 ms, 메모리: 90.2 MB

2. 시간: 0.03 ms, 메모리: 80.8 MB
3. 시간: 0.03 ms, 메모리: 78.9 MB
4. 시간: 0.03 ms, 메모리: 75.9 MB
5. 시간: 0.03 ms, 메모리: 75.8 MB

### 제출 일자

2024년 10월 18일 (금) 01:27

> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges