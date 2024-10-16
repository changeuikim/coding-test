# [Lv.0] [두 수의 연산값 비교하기](https://school.programmers.co.kr/learn/courses/30/lessons/181938?language=java) - 181938 

### 구분

코딩테스트 연습 > 코딩 기초 트레이닝

## Java 문제풀이

```java
class Solution {
    public int solution(int a, int b) {
        int left = Integer.parseInt(String.format("%d%d", a, b));
        int right = 2 * a * b;
        return Integer.max(left, right);
    }
}
```

### 성능 요약

1. 시간: 1.37 ms, 메모리: 73.2 MB

2. 시간: 1.00 ms, 메모리: 89.5 MB
3. 시간: 1.00 ms, 메모리: 75.2 MB
4. 시간: 0.97 ms, 메모리: 73.6 MB
5. 시간: 0.91 ms, 메모리: 69.8 MB

### 제출 일자

2024년 10월 17일 (목) 02:22

> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges