# [Lv.1] [음양 더하기](https://school.programmers.co.kr/learn/courses/30/lessons/76501?language=java) - 76501 

### 구분

코딩테스트 연습 > 월간 코드 챌린지 시즌2

## Java 문제풀이

```java
class Solution {
    public int solution(int[] absolutes, boolean[] signs) {
        int sum = 0;
        for (int i = 0; i < absolutes.length; i++) {
            sum += absolutes[i] * (signs[i] ? 1 : -1);
        }
        return sum;
    }
}
```

### 성능 요약

1. 시간: 0.08 ms, 메모리: 86 MB

2. 시간: 0.06 ms, 메모리: 86.3 MB
3. 시간: 0.06 ms, 메모리: 80.6 MB
4. 시간: 0.06 ms, 메모리: 78.4 MB
5. 시간: 0.05 ms, 메모리: 78.2 MB

### 제출 일자

2024년 11월 02일 (토) 19:35

> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges