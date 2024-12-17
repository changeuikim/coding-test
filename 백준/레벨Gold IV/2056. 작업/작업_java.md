# [Gold IV] [작업](https://www.acmicpc.net/problem/2056) - 2056 

NaN방향 비순환 그래프, 다이나믹 프로그래밍, 그래프 이론, 위상 정렬

## Java 11 문제풀이

```Java 11
import java.io.*;

class Solution {
    public void topologicalSort() throws IOException {
        // 선행은 모두 1 이상 (K-1) 이하 : 1부터 N까지 이미 위상 정렬 됨
        int N = nextInt();
        int[] dp = new int[N + 1];

        for (int v = 1; v <= N; v++) {
            int time = nextInt(), size = nextInt();
            // 작업시간 설정
            dp[v] = time;
            // 선행시간 반영
            while (size-- > 0) {
                int u = nextInt();
                dp[v] = Math.max(dp[v], dp[u] + time);
            }
        }

        // 가장 늦게 끝나는 작업을 반환
        int maxTime = 0;
        for (int t : dp) {
            maxTime = Math.max(maxTime, t);
        }

        System.out.println(maxTime);
    }

    int nextInt() throws IOException {
        int n = 0;
        int c;

        while ((c = System.in.read()) <= 32); // 탭 2, 개행 10, 공백 32

        do {
            n = n * 10 + (c - '0'); // 한자리씩 추가
        } while ((c = System.in.read()) > 32); // 구분자 : 공백

        return n;
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        new Solution().topologicalSort();
    }
}
```

### 성능 요약

시간: 180 ms

메모리: 14420 KB

### 제출 일자

2024년 12월 17일 (화) 13:32

> 출처: 백준 온라인 저지, https://www.acmicpc.net/problemset 

