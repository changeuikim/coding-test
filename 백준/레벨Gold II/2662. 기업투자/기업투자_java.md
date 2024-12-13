# [Gold II] [기업투자](https://www.acmicpc.net/problem/2662) - 2662 

NaN다이나믹 프로그래밍, 배낭 문제

## Java 11 문제풀이

```Java 11
import java.io.*;
import java.util.*;

public class Main {
    static int nextInt() throws IOException {
        int n = 0;
        int c;
        while((c = System.in.read()) <= 32); // 탭 9, 개행 10, 공백 32
        do {
            n = n * 10 + (c - '0'); // 현재 자리를 추가
        } while ((c = System.in.read()) > 32); // 구분자 전까지
        return n;
    }

    public static void main(String[] args) throws IOException {

        // 이익 2차원 배열 : n축 금액, m축 기업
        int N = nextInt(), M = nextInt();
        int[][] profit = new int[N+1][M+1];

        for (int i = 1; i <= N; i++) {
            for (int j = 0; j <= M; j++) {
                profit[i][j] = nextInt();
            }
        }

        // 누산 DP, 기업별 memo
        int[][] dp = new int[N+1][M+1];
        int[][] memo = new int[N+1][M+1];

        // 루프 : 기업 -> 투자액 -> 변동폭
        // 점화식 : dp[N][다음] = dp[N-k][이전] + profit[k][다음]
        for (int i = 1; i <= M; i++) {
            for (int j = 0; j <= N; j++) {
                for (int k = 0; k <= j; k++) {
                    int curProfit = dp[j - k][i - 1] + profit[k][i];
                    if (curProfit > dp[j][i]) {
                        dp[j][i] = curProfit;
                        memo[j][i] = k;
                    }
                }
            }
        }

        System.out.println(dp[N][M]);

        // memo[N][M]부터 N을 차감하며 역추적
        int[] corp = new int[M+1];
        int r = N;
        
        for (int i = M; i >= 1; i--) {
            corp[i] = memo[r][i];
            r -= memo[r][i];     
        }
        
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < corp.length; i++) {
            sb.append(corp[i]).append(" ");
        }

        System.out.println(sb);
    }
}
```

### 성능 요약

시간: 140 ms

메모리: 15336 KB

### 제출 일자

2024년 12월 13일 (금) 23:19

> 출처: 백준 온라인 저지, https://www.acmicpc.net/problemset 

