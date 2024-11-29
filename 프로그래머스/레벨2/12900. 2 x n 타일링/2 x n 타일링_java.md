# [Lv.2] [2 x n 타일링](https://school.programmers.co.kr/learn/courses/30/lessons/12900?language=java) - 12900 

### 구분

코딩테스트 연습 > 연습문제

## Java 문제풀이

```java
public class Solution {
    public int solution(int n) {
        final int MOD = 1000000007;

        // 빠른 반환
        if (n == 1 || n == 2) {
            return n;
        }

        // DP 초기화
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;

        // DP 점화식
        for (int i = 3; i <= n; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2]) % MOD;
        }

        return dp[n];
    }
}
```

### 성능 요약

1. 시간: 2.24 ms, 메모리: 54.4 MB

2. 시간: 1.63 ms, 메모리: 67.1 MB
3. 시간: 1.27 ms, 메모리: 53.8 MB
4. 시간: 0.80 ms, 메모리: 53.8 MB
5. 시간: 0.64 ms, 메모리: 53.8 MB

### 제출 일자

2024년 11월 29일 (금) 22:45

> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges