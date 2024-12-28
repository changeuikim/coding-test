# [Gold IV] [네트워크 연결](https://www.acmicpc.net/problem/1922) - 1922 

NaN그래프 이론, 최소 스패닝 트리

## Java 11 문제풀이

```Java 11
import java.io.*;
import java.util.*;

class Solution {    
    static int[] parent;

    // 파인드
    static int find(int x) {
        while (parent[x] != x) {
            parent[x] = parent[parent[x]];
            x = parent[x];
        }
        return x;
    }

    // 유니온
    static boolean union(int a, int b) {
        a = find(a);
        b = find(b);
        if (a == b) return false;

        if (a > b) parent[a] = b;
        else parent[b] = a;
        return true;
    }

    public void kruskal() throws IOException {
        int V = nextInt(), E = nextInt();

        // 엣지리스트 초기화
        int[][] graph = new int[E][3];

        for (int i = 0; i < E; i++) {
            int u = nextInt(), v = nextInt(), w = nextInt();
            graph[i][0] = u;
            graph[i][1] = v;
            graph[i][2] = w;
        }

        // 부모노드 1 ~ N 초기화
        parent = new int[V + 1];
        Arrays.setAll(parent, i -> i);

        // 크루스칼
        int mstCost = 0;
        int edgeCnt = 0;

        // w정렬
        Arrays.sort(graph, Comparator.comparingInt(a -> a[2]));

        for (int[] edge : graph) {
            int u = edge[0], v = edge[1], w = edge[2];
            if (edgeCnt >= V - 1) break;
            if (union(u, v)) {
                mstCost += w;
                edgeCnt++;
            }
        }

        System.out.println(mstCost);
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
        new Solution().kruskal();
    }
}
```

### 성능 요약

시간: 308 ms

메모리: 23984 KB

### 제출 일자

2024년 12월 28일 (토) 17:46

> 출처: 백준 온라인 저지, https://www.acmicpc.net/problemset 

