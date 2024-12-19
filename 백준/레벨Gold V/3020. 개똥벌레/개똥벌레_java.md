# [Gold V] [개똥벌레](https://www.acmicpc.net/problem/3020) - 3020 

NaN이분 탐색, 누적 합

## Java 11 문제풀이

```Java 11
import java.io.*;

/*
  N = 2 * 10^5, H = 5 * 10^5, 최대 10^11
  일반적인 2차원 배열로는 O(N^2)를 못쓴다
 */

class Solution {
    public void difference() throws IOException {
        int N = nextInt(), H = nextInt();
        int[] height = new int[H];

        // 너비 압축
        for (int i = 0; i < N; i++) {
            int t = nextInt();

            // 짝수 : 석순, 홀수 : 종유석
            if (i % 2 == 0) {
                // 석순 : H-t 이전은 0 이후는 1
                height[H - t]++;
            } else {
                // 종유석 : t 이전은 1 이후는 0
                height[0]++;
                height[t]--;
            }
        }

        // 누적 합
        for (int i = 1; i < H; i++) {
            height[i] += height[i - 1];
        }

        // 최소값 및 빈도
        int minVal = height[0], minCnt = 1;
        for(int i = 1; i < height.length; i++) {
            if(height[i] < minVal) {
                minVal = height[i];
                minCnt = 1;
            } else if(height[i] == minVal) {
                minCnt++;
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(minVal).append(" ").append(minCnt);

        System.out.println(sb);
    }

    private static int nextInt() throws IOException {
        int n = 0, c;
        while ((c = System.in.read()) <= 32);
        do {
            n = n * 10 + (c - '0');
        } while ((c = System.in.read()) > 32);
        return n;
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        new Solution().difference();
    }
}
```

### 성능 요약

시간: 152 ms

메모리: 16312 KB

### 제출 일자

2024년 12월 19일 (목) 14:30

> 출처: 백준 온라인 저지, https://www.acmicpc.net/problemset 

