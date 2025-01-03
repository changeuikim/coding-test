# [Silver III] [구간 합 구하기 4](https://www.acmicpc.net/problem/11659) - 11659 

NaN누적 합

## Java 11 문제풀이

```Java 11
import java.io.*;

class Solution {
    public void rangeSum() throws IOException {
        // 누적 합 초기화
        int N = nextInt(), M = nextInt();
        int[] prefixSum = new int[N+1];

        for (int i = 0; i < N; i++) {
            prefixSum[i + 1] = prefixSum[i] + nextInt();
        }

        // 구간 합 출력
        StringBuilder sb = new StringBuilder();
        while (M-- > 0) {
            int i = nextInt(), j = nextInt();
            sb.append(prefixSum[j] - prefixSum[i - 1]).append("\n");
        }

        System.out.println(sb);
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

시간: 252 ms

메모리: 20284 KB

### 제출 일자

2024년 12월 16일 (월) 08:39

> 출처: 백준 온라인 저지, https://www.acmicpc.net/problemset 

