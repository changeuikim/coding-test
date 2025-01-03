# [Gold III] [나머지 합](https://www.acmicpc.net/problem/10986) - 10986 

NaN수학, 누적 합

## Java 11 문제풀이

```Java 11
import java.io.*;

class Solution {
    public void rangeSum() throws IOException {
        // 누적 합 초기화
        int N = nextInt(), M = nextInt();

        int[] nums = new int[N];
        for (int i = 0; i < N; i++) {
            nums[i] = nextInt();
        }

        int[] pre = new int[N + 1];
        for (int i = 0; i < N; i++) {
            pre[i + 1] = (pre[i] + nums[i]) % M;
        }

        // 나머지 배열 초기화
        int[] r = new int[M];
        for (int i = 1; i <= N; i++) {
            r[pre[i]]++;
        }

        // 조합
        long count = r[0]; // 누적합도 구간합
        for (int i = 0; i < M; i++) {
            count += (long) r[i] * (r[i] - 1) / 2; // nC2 = n * (n-1) / 2
        }

        System.out.println(count);
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
        new Solution().rangeSum();
    }
}
```

### 성능 요약

시간: 336 ms

메모리: 22344 KB

### 제출 일자

2024년 12월 16일 (월) 10:13

> 출처: 백준 온라인 저지, https://www.acmicpc.net/problemset 

