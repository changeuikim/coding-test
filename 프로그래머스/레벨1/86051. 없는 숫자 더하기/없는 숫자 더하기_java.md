# [Lv.1] [없는 숫자 더하기](https://school.programmers.co.kr/learn/courses/30/lessons/86051?language=java) - 86051 

### 구분

코딩테스트 연습 > 월간 코드 챌린지 시즌3

## Java 문제풀이

```java
class Solution {
    public int solution(int[] numbers) {
        int sum = (0 + 9) * 10 / 2;
        for (int num : numbers) {
            sum -= num;
        }
        return sum;
    }
}
```

### 성능 요약

1. 시간: 0.03 ms, 메모리: 76.2 MB

2. 시간: 0.02 ms, 메모리: 79.1 MB
3. 시간: 0.02 ms, 메모리: 75.7 MB
4. 시간: 0.02 ms, 메모리: 73.3 MB
5. 시간: 0.02 ms, 메모리: 73.2 MB

### 제출 일자

2024년 11월 02일 (토) 20:02

> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges