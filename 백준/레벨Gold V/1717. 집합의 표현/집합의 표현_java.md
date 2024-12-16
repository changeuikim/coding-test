# [Gold V] [집합의 표현](https://www.acmicpc.net/problem/1717) - 1717 

NaN자료 구조, 분리 집합

## Java 11 문제풀이

```Java 11
import java.io.*;

class Solution {
    private int[] parent;

    public void disjointSet() throws IOException {
        // 부모 노드 초기화
        int N = nextInt(), M = nextInt();

        parent = new int[N + 1];
        for (int i = 0; i <= N; i++) {
            parent[i] = i;
        }

        // 서로소 집합 연산
        StringBuilder sb = new StringBuilder();
        while (M-- > 0) {
            int op = nextInt(), a = nextInt(), b = nextInt();

            if (op == 0) {
                union(a, b);
            } else {
                sb.append(find(a) == find(b) ? "YES" : "NO").append("\n");
            }
        }

        System.out.print(sb);
    }

    private int find(int x) {
        // 경로 압축
        while (parent[x] != x) {
            parent[x] = parent[parent[x]];
            x = parent[x];
        }
        return x;
    }

    private void union(int a, int b) {
        int rootA = find(a);
        int rootB = find(b);

        if (rootA > rootB) {
            parent[rootA] = rootB;
        } else {
            parent[rootB] = rootA;
        }
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
        new Solution().disjointSet();
    }
}
```

### 성능 요약

시간: 220 ms

메모리: 21800 KB

### 제출 일자

2024년 12월 16일 (월) 23:55

> 출처: 백준 온라인 저지, https://www.acmicpc.net/problemset 

