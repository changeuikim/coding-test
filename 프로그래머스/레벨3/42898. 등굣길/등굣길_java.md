# [Lv.3] [등굣길](https://school.programmers.co.kr/learn/courses/30/lessons/42898?language=java) - 42898 

### 구분

코딩테스트 연습 > 동적계획법（Dynamic Programming）

## Java 문제풀이

```java
public class Solution {
    public int solution(int m, int n, int[][] puddles) {
        final int MOD = 1000000007;
        int[][] dp = new int[n + 1][m + 1];
        
        dp[1][1] = 1;
        for (int[] puddle : puddles) {
            int x = puddle[0];
            int y = puddle[1];
            dp[y][x] = -1;
        }

        for (int y = 1; y <= n; y++) {
            for (int x = 1; x <= m; x++) {
                if (dp[y][x] == -1) {
                    dp[y][x] = 0;
                } else {
                    dp[y][x] += (dp[y - 1][x] + dp[y][x - 1]) % MOD;
                }
            }
        }

        return dp[n][m];
    }
}
```

### 성능 요약

1. 시간: 0.52 ms, 메모리: 51.7 MB

2. 시간: 0.47 ms, 메모리: 59.6 MB
3. 시간: 0.46 ms, 메모리: 52.2 MB
4. 시간: 0.34 ms, 메모리: 51.9 MB
5. 시간: 0.32 ms, 메모리: 51.8 MB

### 제출 일자

2024년 11월 24일 (일) 23:24

> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges