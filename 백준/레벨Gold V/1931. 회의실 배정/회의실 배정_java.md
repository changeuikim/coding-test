# [Gold V] [회의실 배정](https://www.acmicpc.net/problem/1931) - 1931 

NaN그리디 알고리즘, 정렬

## Java 11 문제풀이

```Java 11
import java.io.*;
import java.util.*;

class Solution {
    public void greedy() throws IOException {
        int N = nextInt();

        int[][] meetings = new int[N][2];
        for (int i = 0; i < N; i++) {
            meetings[i][0] = nextInt();
            meetings[i][1] = nextInt();
        }

        // 종료가 빠른 순으로 정렬
        Arrays.sort(meetings, (a, b) -> a[1] == b[1] ? a[0] - b[0] : a[1] - b[1]);

        int E = -1, cnt = 0;
        for (int[] cur : meetings) {
            // 현재 종료 <= 다음 시작
            if (E <= cur[0]) {
                E = cur[1];
                cnt++;
            }
        }

        System.out.println(cnt);
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
    public static void main(String[] args) throws IOException {
        new Solution().greedy();
    }
}
```

### 성능 요약

시간: 304 ms

메모리: 22088 KB

### 제출 일자

2024년 12월 22일 (일) 17:59

> 출처: 백준 온라인 저지, https://www.acmicpc.net/problemset 

