# [Gold IV] [여행 가자](https://www.acmicpc.net/problem/1976) - 1976 

NaN자료 구조, 분리 집합, 그래프 이론, 그래프 탐색

## Java 11 문제풀이

```Java 11
import java.io.*;
import java.util.*;

class Solution {
    private int[] parent; 

    public void disjointSet() throws IOException {
        // 부모 노드 초기화
        int N = nextInt(), M = nextInt();
        parent = new int[N + 1];
        for (int i = 1; i <= N; i++) parent[i] = i;

        // 분리 집합
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (nextInt() == 1) {
                    union(i, j);
                }
            }
        }

        // 경로 검증
        int[] cities = new int[M];
        for (int i = 0; i < M; i++) {
            cities[i] = nextInt();
        }

        int root = find(cities[0]);
        boolean isPossible = true;
        for (int city : cities) {
            if (find(city) != root) {
                isPossible = false;
                break;
            }
        }

        System.out.println(isPossible ? "YES" : "NO");
    }

    private int find(int x) {
        List<Integer> nodes = new ArrayList<>();
        while (parent[x] != x) {
            nodes.add(x);
            x = parent[x];
        }
        // 한번에 경로 압축
        for (int node : nodes) {
            parent[node] = x;
        }
        return x;
    }

    private void union(int a, int b) {
        int rootA = find(a);
        int rootB = find(b);
        if (rootA == rootB) return;

        if (rootA > rootB)  parent[rootA] = rootB;
        else parent[rootB] = rootA;
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

시간: 124 ms

메모리: 14952 KB

### 제출 일자

2024년 12월 17일 (화) 01:09

> 출처: 백준 온라인 저지, https://www.acmicpc.net/problemset 

