# [Gold II] [기업투자](https://www.acmicpc.net/problem/2662) - 2662 

NaN다이나믹 프로그래밍, 배낭 문제

## Java 11 문제풀이

```Java 11
/*
    골드2 - 2662번: 기업투자 https://www.acmicpc.net/problem/2662
 */

import java.io.*;

class Solution {
    public void dynamic() throws IOException  {
        int N = nextInt(), M = nextInt();

        // 1. 2차원 : 투자 x 이익, 1-based
        int[][] profit = new int[N + 1][M + 1];
        for (int i = 1; i <= N; i++) {
            for (int j = 0; j <= M; j++) {
                profit[i][j] = nextInt();
            }
        }

        // 2. 다이나믹 프로그래밍밍
        // DP[N][M] : 총 투자 N원으로 M번째 기업까지의 최대 이익
        // memo[N][M] : 총 투자 N원으로 M 기업이 받은 투자액
        int[][] dp = new int[N + 1][M + 1];
        int[][] memo = new int[N + 1][M + 1];

        // 루프 : 기업j -> 투자i -> 변동k
        // 점화식 : dp[N][다음 기업] = dp[N-k][이전 기업] + profit[k][다음 기업]
        for (int j = 1; j <= M; j++) {
            for (int i = 0; i <= N; i++) {
                for (int k = 0; k <= i; k++) {
                    int nxt = dp[i - k][j - 1] + profit[k][j];
                    if (dp[i][j] < nxt) {
                        dp[i][j] = nxt;
                        memo[i][j] = k;
                    }
                }
            }
        }
        // 투자 N으로 기업 M까지의 최대 이익
        System.out.println(dp[N][M]);

        // 3. 기업별 투자액 역추적
        int[] trace = new int[M + 1];
        int invest = N;

        for (int corp = M; corp > 0; corp--) {
            trace[corp] = memo[invest][corp];
            invest -= trace[corp];
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= M; i++) {
            sb.append(trace[i]).append(" ");
        }
        
        System.out.println(sb);
    }

    private static int nextInt() throws IOException {
        int n = 0;
        int c;
        while ((c = System.in.read()) <= 32);
        do {
            n = n * 10 + (c - '0');
        } while ((c = System.in.read()) > 32);
        return n;
    }
}

public class Main {
    public static void main(String[] args) throws IOException  {
        new Solution().dynamic();
    }
}
```

### 성능 요약

시간: 124 ms

메모리: 14284 KB

### 제출 일자

2024년 12월 18일 (수) 15:07

> 출처: 백준 온라인 저지, https://www.acmicpc.net/problemset 

